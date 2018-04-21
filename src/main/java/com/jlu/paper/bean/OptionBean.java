package com.jlu.paper.bean;

/**
 * Created by Administrator on 2018/4/20.
 */
public class OptionBean {
    private Integer index;
    private String content;
    private Integer mark;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OptionBean{");
        sb.append("index=").append(index);
        sb.append(", content='").append(content).append('\'');
        sb.append(", mark=").append(mark);
        sb.append('}');
        return sb.toString();
    }

    public String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append("内容：").append(content).append("(").append(mark).append("分）");
        return sb.toString();
    }
}
