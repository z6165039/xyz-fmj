package com.jis.platform.fmj.component;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: FastDFS文件上传下载包装类</p>
 */
@Component
public class FastDFSClientWrapper {

    private final Logger logger = LoggerFactory.getLogger(FastDFSClientWrapper.class);

    @Autowired
    private FastFileStorageClient storageClient;

    @Value("${juss.fastdfs.webConetext}")
    private String webConetxt;

    @Value("${juss.upload.image.maxNumber}")
    private int maxNumber;
    
    @Value("${juss.upload.image.type}")
    private String type;
    
    @Value("${juss.upload.image.maxSize}")
    private long maxSize;
    /**
     * 上传文件
     * @param files 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public List<String> uploadFiles(MultipartFile ...files) throws Exception {
    	boolean bool = checkImage(files);
    	if(!bool) {
    		throw new Exception();
    	}
    	List<String> list = new ArrayList<String>();
        for(MultipartFile file : files) {
        	String url = uploadFile(file);
        	list.add(url);
        }
        return list;
    }
    
    private boolean checkImage(MultipartFile ...files) {
    	if(files.length > maxNumber) {
    		return false;
    	}
    	
    	if(!StringUtils.isEmpty(type)) {
    		for(MultipartFile file : files ) {
        		int last = file.getName().lastIndexOf(".");
        		String nowType = file.getName().substring(last+1, file.getName().length());
        		long nowSize = file.getSize();
        		if(type.indexOf(nowType) != -1 && nowSize > maxSize) {
        			return false;
        		}
        	}
    	}
    	return true;
    }
    
    /**
     * 上传文件
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    private String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
//        return getResAccessUrl(storePath);
//        System.out.println(storePath.getFullPath());
        return webConetxt + storePath.getFullPath();
    }

    /**
     * 上传文件
     * @param inputStream 文件对象
     * @param size 文件对象
     * @param originalFilename 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(InputStream inputStream, long size, String originalFilename) throws IOException {
        StorePath storePath = storageClient.uploadFile(inputStream,size, FilenameUtils.getExtension(originalFilename),null);
        return webConetxt + storePath.getFullPath();
    }
//    /**
//     * 将一段字符串生成一个文件上传
//     * @param content 文件内容
//     * @param fileExtension
//     * @return
//     */
//    public String uploadFile(String content, String fileExtension) {
//        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
//        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
//        StorePath storePath = storageClient.uploadFile(stream,buff.length, fileExtension,null);
//        return getResAccessUrl(storePath);
//    }

//    // 封装图片完整URL地址
//    private String getResAccessUrl(StorePath storePath) {
//        String fileUrl = AppConstants.HTTP_PRODOCOL + appConfig.getResHost()
//                + ":" + appConfig.getFdfsStoragePort() + "/" + storePath.getFullPath();
//        return fileUrl;
//    }

    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            logger.warn(e.getMessage());
        }
    }
}
