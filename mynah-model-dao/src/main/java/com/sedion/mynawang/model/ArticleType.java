package com.sedion.mynawang.model;

public class ArticleType {
    private Integer articletypeId;

    private String articletypeName;

    private Integer articletyleLevel;

    private Integer upArticletypeId;

    private String articletypeRemark;

    private String addPeople;

    private String addDate;

    public Integer getArticletypeId() {
        return articletypeId;
    }

    public void setArticletypeId(Integer articletypeId) {
        this.articletypeId = articletypeId;
    }

    public String getArticletypeName() {
        return articletypeName;
    }

    public void setArticletypeName(String articletypeName) {
        this.articletypeName = articletypeName == null ? null : articletypeName.trim();
    }

    public Integer getArticletyleLevel() {
        return articletyleLevel;
    }

    public void setArticletyleLevel(Integer articletyleLevel) {
        this.articletyleLevel = articletyleLevel;
    }

    public Integer getUpArticletypeId() {
        return upArticletypeId;
    }

    public void setUpArticletypeId(Integer upArticletypeId) {
        this.upArticletypeId = upArticletypeId;
    }

    public String getArticletypeRemark() {
        return articletypeRemark;
    }

    public void setArticletypeRemark(String articletypeRemark) {
        this.articletypeRemark = articletypeRemark == null ? null : articletypeRemark.trim();
    }

    public String getAddPeople() {
        return addPeople;
    }

    public void setAddPeople(String addPeople) {
        this.addPeople = addPeople == null ? null : addPeople.trim();
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate == null ? null : addDate.trim();
    }
}