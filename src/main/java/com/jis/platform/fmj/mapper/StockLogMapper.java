package com.jis.platform.fmj.mapper;

import com.jis.platform.fmj.model.entity.StockLog;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StockLogMapper extends Mapper<StockLog> {

    List<StockLog> selectLog(StockLog vo);
}