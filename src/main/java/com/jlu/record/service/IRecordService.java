package com.jlu.record.service;

import com.jlu.record.bean.RecordBean;
import com.jlu.record.model.PaperRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/20.
 */
public interface IRecordService {
    Long save(Long paperId, Map<String, String[]> requestParameterMap);

    RecordBean get(Long recordId);

    List<PaperRecord> getAll();

    List<PaperRecord> get(String username);

    void delete(Long recordId);
}
