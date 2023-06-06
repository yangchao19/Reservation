package com.yang.reservation.domain.curriculum.model;

/**
 * @description:
 * @author：杨超
 * @date: 2023/6/5
 * @Copyright：
 */
public class SubjectVO {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubjectVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
