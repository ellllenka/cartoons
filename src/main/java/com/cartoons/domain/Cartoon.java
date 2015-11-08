package com.cartoons.domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Cartoon {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String link;
    private int priority;
    private boolean viewed;

    @OneToMany(cascade={CascadeType.PERSIST})
    private List<Category> categories = new LinkedList();

    public Cartoon (){}

    public Cartoon (String name, String link, int priority, boolean viewed, LinkedList<Category> categories){
        this.name = name;
        this.link = link;
        this.priority = priority;
        this.viewed = viewed;
        this.categories = categories;
    }

    public Cartoon (String name, boolean viewed){
        this.name = name;
        this.viewed = viewed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(LinkedList<Category> categories) {
        this.categories = categories;
    }
}
