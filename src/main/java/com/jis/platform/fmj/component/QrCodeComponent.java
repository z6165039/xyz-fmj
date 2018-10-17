package com.jis.platform.fmj.component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.jis.platform.fmj.sfexpress.MatrixToImageWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Hashtable;

@Component
public class QrCodeComponent {

    @Value("${qrcode.create.width}")
    private int width;

    @Value("${qrcode.create.height}")
    private int height;

    @Value("${qrcode.create.type}")
    private String type;

    @Value("${qrcode.create.path}")
    private String path;

    /**
     * 根据内容，生成指定宽高、指定格式的二维码图片
     * @param qrcodePath   图片路径
     * @param text   内容
     * @param format 图片格式
     * @return 生成的二维码图片路径
     * @throws Exception
     */
    private  String generateQRCode(String qrcodePath, String text, String format) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        String pathName = getProStatus() + qrcodePath + "/" + System.currentTimeMillis() + ".png";
        File outputFile = new File(pathName);
        if (!outputFile.exists()) {
            outputFile.mkdirs();
        }
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
        return pathName;
    }


    /**
     * 根据内容，生成二维码图片
     * @param text   内容
     * @return 生成的二维码图片路径
     * @throws Exception
     */
    public String generateQRCode(String text) throws Exception {
        return generateQRCode(path, text, type);
    }

    private  String getProStatus() {
        return isLinux() ? "" : "c:";
    }
    /**
     * 判断是否是linux环境
     *
     * @return
     */
    private  boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0;
    }
}
