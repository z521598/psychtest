package com.jlu.paper.dao.impl;

import com.jlu.common.db.dao.AbstractBaseDao;
import com.jlu.common.db.sqlcondition.AscOrder;
import com.jlu.common.db.sqlcondition.ConditionAndSet;
import com.jlu.common.db.sqlcondition.OrderCondition;
import com.jlu.paper.dao.IQuestionDao;
import com.jlu.paper.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
@Repository
public class QuestionDaoImpl extends AbstractBaseDao<Question> implements IQuestionDao {
    @Override
    public List<Question> find(Long paperId) {
        ConditionAndSet conditionAndSet = new ConditionAndSet();
        conditionAndSet.put("paperId",paperId);
        return findByProperties(conditionAndSet,new AscOrder("orderNumber"));
    }
}
