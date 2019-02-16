package com.hphclass.base_project.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "blog",type = "article")
public class Article implements Serializable {
    private static final long serialVersionUID = -1564737555013859300L;

    private long id;
    private String title;
    private String summary;
    private String content;
    private int pv;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public Article() {
    }

    public Article(long id, String title, String summary, String content, int pv) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.pv = pv;
    }
}
