package com.jlu.paper.dao.impl;

import com.jlu.common.db.dao.AbstractBaseDao;
import com.jlu.paper.dao.IQuestionDao;
import com.jlu.paper.model.Question;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/4/19.
 */
@Repository
public class QuestionDaoImpl extends AbstractBaseDao<Question> implements IQuestionDao {
}
