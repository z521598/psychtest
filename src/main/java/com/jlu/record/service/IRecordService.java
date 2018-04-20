package com.jlu.record.service;

import com.jlu.record.bean.RecordBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/4/20.
 */
public interface IRecordService {
    Long save(Long paperId, Map<String, String[]> requestParameterMap);

    RecordBean get(Long recordId);
}
