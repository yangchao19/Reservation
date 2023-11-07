package com.yang.reservation.domain.luck.model;

/**
 * @description:
 * @author：杨超
 * @date: 2023/11/6
 * @Copyright：
 */
public class Strategy {
    /**
     * 奖品名称
     */
    private String text;

    /**
     * 奖品概率
     */
    private String top;

    public Strategy(String text, String top) {
        this.text = text;
        this.top = top;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }
}
