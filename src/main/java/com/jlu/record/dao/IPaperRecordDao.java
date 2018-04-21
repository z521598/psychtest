package com.jlu.record.dao;

import com.jlu.common.db.dao.IBaseDao;
import com.jlu.record.model.PaperRecord;

import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
public interface IPaperRecordDao extends IBaseDao<PaperRecord>{
    List<PaperRecord> find(String username);
}
