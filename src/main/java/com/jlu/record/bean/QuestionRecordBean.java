package com.jlu.record.bean;

import com.jlu.paper.bean.OptionBean;
import com.jlu.record.model.QuestionRecord;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
public class QuestionRecordBean extends QuestionRecord{

    private List<OptionBean> optionBeanList = new LinkedList<>();

    public List<OptionBean> getOptionBeanList() {
        return optionBeanList;
    }

    public void setOptionBeanList(List<OptionBean> optionBeanList) {
        this.optionBeanList = optionBeanList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionRecordBean{");
        sb.append("optionBeanList=").append(optionBeanList);
        sb.append('}');
        return sb.toString();
    }

    public String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        for (OptionBean optionBean : optionBeanList) {
            sb.append("\t").append(optionBean.toText());
            if(optionBean.getIndex().equals(selectedOption)){
                sb.append("(您选择了此项，等分").append(mark).append("分)");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

