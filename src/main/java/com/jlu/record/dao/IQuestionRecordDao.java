package com.jlu.record.dao;

import com.jlu.common.db.dao.IBaseDao;
import com.jlu.record.model.QuestionRecord;

import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
public interface IQuestionRecordDao extends IBaseDao<QuestionRecord>{
    List<QuestionRecord> find(Long recordId);
}
