package com.jlu.record.dao.impl;

import com.jlu.common.db.dao.AbstractBaseDao;
import com.jlu.common.db.sqlcondition.AscOrder;
import com.jlu.common.db.sqlcondition.ConditionAndSet;
import com.jlu.record.dao.IQuestionRecordDao;
import com.jlu.record.model.QuestionRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
@Repository
public class QuestionRecordDaoImpl extends AbstractBaseDao<QuestionRecord> implements IQuestionRecordDao{
    @Override
    public List<QuestionRecord> find(Long recordId) {
        ConditionAndSet conditionAndSet = new ConditionAndSet();
        conditionAndSet.put("paperRecordId",recordId);
        return findByProperties(conditionAndSet,new AscOrder("orderNumber"));
    }

    @Override
    public List<QuestionRecord> findByPaperId(Long paperId) {
        ConditionAndSet conditionAndSet = new ConditionAndSet();
        conditionAndSet.put("paperId",paperId);
        return findByProperties(conditionAndSet);
    }
}
