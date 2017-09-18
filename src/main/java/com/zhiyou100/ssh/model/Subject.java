package com.zhiyou100.ssh.model;

import java.util.HashSet;
import java.util.Set;


public class Subject {
	
    private Integer id;

    private String subjectName;
    
 private Set<Course> courseset = new HashSet<>();
    
    public Set<Course> getCourseset() {
		return courseset;
	}

	public void setCourseset(Set<Course> courseset) {
		this.courseset = courseset;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + "]";
	}


    
}