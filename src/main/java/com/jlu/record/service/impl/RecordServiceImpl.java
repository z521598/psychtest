package com.jlu.record.service.impl;

import com.jlu.common.exception.PsychtestRuntimeException;
import com.jlu.paper.bean.OptionBean;
import com.jlu.paper.bean.PaperBean;
import com.jlu.paper.bean.QuestionBean;
import com.jlu.paper.service.IPaperService;
import com.jlu.record.bean.RecordBean;
import com.jlu.record.dao.IPaperRecordDao;
import com.jlu.record.dao.IQuestionRecordDao;
import com.jlu.record.model.PaperRecord;
import com.jlu.record.model.QuestionRecord;
import com.jlu.record.service.IRecordService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/20.
 */
@Service
public class RecordServiceImpl implements IRecordService {

    @Autowired
    private IPaperRecordDao paperRecordDao;

    @Autowired
    private IQuestionRecordDao questionRecordDao;

    @Autowired
    private IPaperService paperService;

    @Override
    public Long save(Long paperId, Map<String, String[]> requestParameterMap) {
        PaperBean paperBean = paperService.getPaperBean(paperId);
        PaperRecord paperRecord = paperBean.toPaperRecord();
        paperRecordDao.saveOrUpdate(paperRecord);
        List<QuestionBean> questionBeanList = paperBean.getQuestions();
        if(requestParameterMap.size() != questionBeanList.size()){
            throw new PsychtestRuntimeException("所有的题目都必须选择,请后退继续答题");
        }
        List<QuestionRecord> questionRecordList = new LinkedList<>();
        for (int i = 0; i < questionBeanList.size(); i++) {
            QuestionBean questionBean = questionBeanList.get(i);
            QuestionRecord questionRecord = new QuestionRecord();
            BeanUtils.copyProperties(questionBean, questionRecord);
            questionRecord.setId(null);
            questionRecord.setPaperId(paperId);
            questionRecord.setQuestionId(questionBean.getId());
            questionRecord.setPaperRecordId(paperRecord.getId());
            questionRecordList.add(questionRecord);
            Integer questionIndex = questionBean.getIndex();
            String value = requestParameterMap.get(String.valueOf(questionIndex))[0];
            Integer selectedIndex = Integer.parseInt(value);
            questionRecord.setSelectedOption(selectedIndex);
            OptionBean optionBean = questionBean.getOptionByIndex(selectedIndex);
            questionRecord.setMark(optionBean.getMark());
            System.out.println(questionRecord);
            questionRecordDao.saveOrUpdate(questionRecord);
        }
        return paperRecord.getId();
    }


    @Override
    public RecordBean get(Long recordId) {
        RecordBean recordBean = new RecordBean();
        PaperRecord paperRecord = paperRecordDao.findById(recordId);
        BeanUtils.copyProperties(paperRecord, recordBean);
        List<QuestionRecord> questionRecordList = questionRecordDao.find(recordId);
        for (QuestionRecord questionRecord : questionRecordList) {
            recordBean.addQuestionRecord(questionRecord.toBean());
        }
        return recordBean;
    }

    @Override
    public List<PaperRecord> getAll() {
        return paperRecordDao.findByProperties(null);
    }

    @Override
    public List<PaperRecord> get(String username) {
        return paperRecordDao.find(username);

    }

    @Override
    public void delete(Long recordId) {
        List<QuestionRecord> questionRecords = questionRecordDao.find(recordId);
        for (int i = 0; questionRecords != null && i < questionRecords.size(); i++) {
            questionRecordDao.delete(questionRecords.get(i));
        }
        PaperRecord paperRecord = paperRecordDao.findById(recordId);
        if (recordId != null) {
            paperRecordDao.delete(paperRecord);
        }
    }

    @Override
    public void deleteByPaperId(Long paperId) {
        List<PaperRecord> paperRecords = paperRecordDao.find(paperId);
        for (int i = 0; paperRecords != null && i < paperRecords.size(); i++) {
            paperRecordDao.delete(paperRecords.get(i));
        }
        List<QuestionRecord> questionRecordList = questionRecordDao.findByPaperId(paperId);
        for (int i = 0; questionRecordList != null && i < questionRecordList.size(); i++) {
            questionRecordDao.delete(questionRecordList.get(i));
        }
    }

    @Override
    public Boolean checkPermission(Long id, String username) {
        PaperRecord paperRecord = paperRecordDao.findById(id);
        if (paperRecord == null) {
            return false;
        }
        return paperRecord.getUsername().equals(username);
    }
}
