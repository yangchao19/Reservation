package com.yang.reservation.domain.luck.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/11/6
 * @Copyright：
 */
public class Prize {
    private List<Strategy> fonts= new ArrayList<>();
    private String background;

    public Prize(List<Strategy> fonts, String background) {
        this.fonts = fonts;
        this.background = background;
    }
    public Prize(Strategy strategy, String background) {
        this.fonts.add(strategy);
        this.background = background;
    }

    public List<Strategy> getFonts() {
        return fonts;
    }

    public void setFonts(List<Strategy> fonts) {
        this.fonts = fonts;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
