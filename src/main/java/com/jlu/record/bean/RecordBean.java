package com.jlu.record.bean;

import com.jlu.paper.bean.QuestionBean;
import com.jlu.record.model.PaperRecord;
import com.jlu.record.model.QuestionRecord;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
public class RecordBean extends PaperRecord{
    List<QuestionRecordBean> questionRecordList = new LinkedList<>();

    public List<QuestionRecordBean> getQuestionRecordList() {
        return questionRecordList;
    }

    public void setQuestionRecordList(List<QuestionRecordBean> questionRecordList) {
        this.questionRecordList = questionRecordList;
    }

    public void  addQuestionRecord(QuestionRecordBean questionRecordBean){
        questionRecordList.add(questionRecordBean);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecordBean{");
        sb.append("questionRecordList=").append(questionRecordList);
        sb.append('}');
        return sb.toString();
    }

        public String toText() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t").append(name).append("\n\n").append(guide).append("\n");
            for (QuestionRecordBean q : questionRecordList) {
                sb.append("\n").append(q.toText());
            }
            return sb.toString();
        }
    }
