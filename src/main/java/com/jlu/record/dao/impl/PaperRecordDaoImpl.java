package com.jlu.record.dao.impl;

import com.jlu.common.db.dao.AbstractBaseDao;
import com.jlu.common.db.sqlcondition.ConditionAndSet;
import com.jlu.record.dao.IPaperRecordDao;
import com.jlu.record.model.PaperRecord;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
@Repository
public class PaperRecordDaoImpl extends AbstractBaseDao<PaperRecord> implements IPaperRecordDao {
    @Override
    public List<PaperRecord> find(String username) {
        ConditionAndSet conditionAndSet = new ConditionAndSet();
        conditionAndSet.put("username", username);
        List<PaperRecord> paperRecords = findByProperties(conditionAndSet);
        return paperRecords == null ? new ArrayList<>() : paperRecords;
    }

    @Override
    public  List<PaperRecord>  find(Long paperId) {
        ConditionAndSet conditionAndSet = new ConditionAndSet();
        conditionAndSet.put("paperId", paperId);
        List<PaperRecord> paperRecords = findByProperties(conditionAndSet);
        return paperRecords == null ? new ArrayList<>() : paperRecords;
    }
}
