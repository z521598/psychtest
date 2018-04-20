package com.jlu.paper.bean;

import com.jlu.paper.model.Paper;
import com.jlu.paper.model.Question;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public class PaperBean {
    private String guide; //引导语
    private String name;
    private String conclusionFilePath;
    private List<QuestionBean> questions = new ArrayList<>();

    public List<QuestionBean> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionBean> questions) {
        this.questions = questions;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConclusionFilePath() {
        return conclusionFilePath;
    }

    public void setConclusionFilePath(String conclusionFilePath) {
        this.conclusionFilePath = conclusionFilePath;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaperBean{");
        sb.append("guide='").append(guide).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", conclusionFilePath='").append(conclusionFilePath).append('\'');
        sb.append(", questions=").append(questions);
        sb.append('}');
        return sb.toString();
    }
    public Paper toPaper(){
        Paper paper = new Paper();
        paper.setGuide(guide);
        paper.setName(name);
        paper.setDisable(false);
        paper.setConclusionFilePath(conclusionFilePath);
        paper.setNewTime(new Date());
        return paper;
    }
    public void addQuestion(QuestionBean questionBean){
        questions.add(questionBean);
    }
}
