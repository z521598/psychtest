package com.jlu.paper.dao;

import com.jlu.common.db.dao.IBaseDao;
import com.jlu.paper.model.Question;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface IQuestionDao extends IBaseDao<Question> {
    List<Question> find(Long paperId);
}
