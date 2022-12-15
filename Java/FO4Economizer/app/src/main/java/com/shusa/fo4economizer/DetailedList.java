package com.shusa.fo4economizer;

public class DetailedList {
    // Section 1
    private String name;
    private int difficulty;

    // Section 2
    private double baseValue;
    private double saleValue;
    private double ruinedValue;
    private double prestineValue;

    // Section 3
    private double baseVPW;
    private double saleVPW;
    private double ruinedVPW;
    private double prestineVPW;

    // Section 4
    private double weight;

    // Section 5
    private String craftList;

    // Explicit Constructor
    public DetailedList(final String _NAME, final int _DIFFICULTY,
                        final double _BASE_VALUE, final double _SALE_VALUE,
                        final double _RUINED_VALUE, final double _PRESTINE_VALUE,
                        final double _BASE_VPW, final double _SALE_VPW,
                        final double _RUINED_VPW, final double _PRESTINE_VPW,
                        final double _WEIGHT, final String _CRAFT_LIST) {

        name = _NAME;
        difficulty = _DIFFICULTY;
        baseValue = _BASE_VALUE;
        saleValue = _SALE_VALUE;
        ruinedValue = _RUINED_VALUE;
        prestineValue = _PRESTINE_VALUE;
        baseVPW = _BASE_VPW;
        saleVPW = _SALE_VPW;
        ruinedVPW = _RUINED_VPW;
        prestineVPW = _PRESTINE_VPW;
        weight = _WEIGHT;
        craftList = _CRAFT_LIST;
    }

    public DetailedList() {

    }

    // Getters
    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public double getSaleValue() {
        return saleValue;
    }

    public double getRuinedValue() {
        return ruinedValue;
    }

    public double getPrestineValue() {
        return prestineValue;
    }

    public double getBaseVPW() {
        return baseVPW;
    }

    public double getSaleVPW() {
        return saleVPW;
    }

    public double getRuinedVPW() {
        return ruinedVPW;
    }

    public double getPrestineVPW() {
        return prestineVPW;
    }

    public double getWeight() {
        return weight;
    }

    public String getCraftList() {
        return craftList;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDifficulty(final int DIFFICULTY) {
        difficulty = DIFFICULTY;
    }

    public void setBaseValue(final double BASE_VALUE) {
        baseValue = BASE_VALUE;
    }

    public void setSaleValue(final double SALE_VALUE) {
        saleValue = SALE_VALUE;
    }

    public void setRuinedValue(final double RUINED_VALUE) {
        ruinedValue = RUINED_VALUE;
    }

    public void setPrestineValue(final double PRESTINE_VALUE) {
        prestineValue = PRESTINE_VALUE;
    }

    public void setBaseVPW(final double BASE_VPW) {
        baseVPW = BASE_VPW;
    }

    public void setSaleVPW(final double SALE_VPW) {
        saleVPW = SALE_VPW;
    }

    public void setRuinedVPW(final double RUINED_VPW) {
        ruinedVPW = RUINED_VPW;
    }

    public void setPrestineVPW(final double PRESTINE_VPW) {
        prestineVPW = PRESTINE_VPW;
    }

    public void setWeight(final double WEIGHT) {
        weight = WEIGHT;
    }

    public void setCraftList(final String CRAFT_LIST) {
        craftList = CRAFT_LIST;
    }
}
