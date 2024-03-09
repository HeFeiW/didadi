package top.fatbird.didadi.model;

import java.util.Date;

public class Proposal {
    private Integer id;
    private String title;
    private String tag;
    private String description;
    private Date expectTime;
    private String location;
    private Integer expectNumber;
    private Integer recruitedNumber;
    private String creator;
    private Long gmtCreate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getExpectNumber() {
        return expectNumber;
    }

    public void setExpectNumber(Integer expectNumber) {
        this.expectNumber = expectNumber;
    }

    public Integer getRecruitedNumber() {
        return recruitedNumber;
    }

    public void setRecruitedNumber(Integer recruitedNumber) {
        this.recruitedNumber = recruitedNumber;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    private Long gmtModified;
    private Integer viewCount;

}
