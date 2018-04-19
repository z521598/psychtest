package com.jlu.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by langshiquan on 17/3/24.
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {

    // SimpleDateFormat线程不安全
    //    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    //    private static final SimpleDateFormat dateFormat = new Sim/leDateFormat("yyyy-MM-dd");
    private static final String DATE_FORMAT_STR = "yyyy-MM-dd";
    private static final String ZERO_SECONDS_READAVLE = "<0ms";
    private static final String ZERO_SECONDS_CHINESE_READAVLE = "小于1毫秒";
    private static final String MSEC_READABLE = "ms";
    private static final String MSEC_CHINESE_READABLE = "毫秒";
    private static final List<DateReadableBean> readableList = new LinkedList<>();

    static {
        DateReadableBean dayReadable = new DateReadableBean();
        dayReadable.setMillis(MILLIS_PER_DAY);
        dayReadable.setChineseReabale("天");
        dayReadable.setReadable("d");
        readableList.add(dayReadable);

        DateReadableBean hourReadable = new DateReadableBean();
        hourReadable.setMillis(MILLIS_PER_HOUR);
        hourReadable.setChineseReabale("时");
        hourReadable.setReadable("h");
        readableList.add(hourReadable);

        DateReadableBean minuteReadable = new DateReadableBean();
        minuteReadable.setMillis(MILLIS_PER_MINUTE);
        minuteReadable.setChineseReabale("分");
        minuteReadable.setReadable("m");
        readableList.add(minuteReadable);

        DateReadableBean secondsReadable = new DateReadableBean();
        secondsReadable.setMillis(MILLIS_PER_SECOND);
        secondsReadable.setChineseReabale("秒");
        secondsReadable.setReadable("s");

        readableList.add(secondsReadable);
    }

    /**
     * 获取当前时间格式化输出
     *
     * @return
     */
    public static String getNowTimeFormat() {
        // JDK8特性
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIME_FORMAT_STR));
//        return new SimpleDateFormat(TIME_FORMAT_STR).format(new Date());
    }

    public static String format(Date time) {
        return convertDateToLDT(time).format(DateTimeFormatter.ofPattern(TIME_FORMAT_STR));
    }
    // Date转换为LocalDateTime
    private static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 获取当前日期格式化输出
     *
     * @return
     */
    public static String getNowDateFormat() {
        // JDK8特性
        return LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT_STR));
    }

    /**
     * 将毫秒数转换成易读的数字
     * e.g.:1d7h12m9s
     *
     * @param time
     * @return
     */
    public static String getRealableTime(Long time) {
        if (time == 0L) {
            return ZERO_SECONDS_READAVLE;
        }
        if (time < MILLIS_PER_SECOND) {
            return time + MSEC_READABLE;
        }
        StringBuilder timeSb = new StringBuilder();
        for (int i = 0; i < readableList.size(); i++) {
            DateReadableBean dateReadableBean = readableList.get(i);
            Long num = time / dateReadableBean.getMillis();
            time = time % dateReadableBean.getMillis();
            if (num != 0L) {
                timeSb.append(num).append(dateReadableBean.getReadable());
            }
        }
        return timeSb.toString();
    }

    /**
     * 将毫秒数转换成易读的中文数字
     * e.g.:1d7h12m9s
     *
     * @param time
     * @return
     */
    public static String getRealableChineseTime(Long time) {
        if (time == 0L) {
            return ZERO_SECONDS_CHINESE_READAVLE;
        }
        if (time < MILLIS_PER_SECOND) {
            return time + MSEC_CHINESE_READABLE;
        }
        StringBuilder timeSb = new StringBuilder();
        for (int i = 0; i < readableList.size(); i++) {
            DateReadableBean dateReadableBean = readableList.get(i);
            Long num = time / dateReadableBean.getMillis();
            time = time % dateReadableBean.getMillis();
            if (num != 0L) {
                timeSb.append(num).append(dateReadableBean.getChineseReabale());
            }
        }
        return timeSb.toString();
    }

    private static class DateReadableBean {
        private Long millis;
        private String readable;
        private String chineseReabale;

        public Long getMillis() {
            return millis;
        }

        public void setMillis(Long millis) {
            this.millis = millis;
        }

        public String getReadable() {
            return readable;
        }

        public void setReadable(String readable) {
            this.readable = readable;
        }

        public String getChineseReabale() {
            return chineseReabale;
        }

        public void setChineseReabale(String chineseReabale) {
            this.chineseReabale = chineseReabale;
        }
    }

}
