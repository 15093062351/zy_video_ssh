package com.zhiyou100.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.dao.AdminCourseDao;
import com.zhiyou100.ssh.model.Course;
import com.zhiyou100.ssh.model.Speaker;
import com.zhiyou100.ssh.model.Statistics;
import com.zhiyou100.ssh.model.Subject;
import com.zhiyou100.ssh.model.Video;
import com.zhiyou100.ssh.service.AdminCourseService;
@Service
public class AdminCourseServiceImpl implements AdminCourseService {
	
	@Autowired
	AdminCourseDao acd;

	@Override
	public List<Course> findCourse() {
		
		
		return acd.findCourse();
	}

	@Override
	public List<Subject> findSubject() {
		
		return acd.findSubject();
	}

	@Override
	public List<Course> findCourse(Integer subjectId) {
		
		return acd.findCourse(subjectId);
	}

	@Override
	public Video findVideoBy(Integer videoId) {
		
		return acd.findVideoBy(videoId);
	}

	@Override
	public Speaker findSpeakerBy(Integer speakerId) {
		
		return acd.findSpeakerBy(speakerId);
	}

	@Override
	public List<Video> findVideoList(Integer courseId) {
		
		return acd.findVideoList(courseId);
	}

	@Override
	public List<Statistics> findStatistics() {
		// TODO Auto-generated method stub
		return acd.findStatistics();
	}

	@Override
	public void addCourse(Course course) {
	
		acd.addCourse(course);
	}

	@Override
	public Course findcourse(Integer id) {
		// TODO Auto-generated method stub
		return acd.findcourse(id);
	}

	@Override
	public void updateCourse(Course course) {
		acd.updateCourse(course);
		
	}

	@Override
	public void deleteCourse(Course findcourse) {
		// TODO Auto-generated method stub
		acd.deleteCourse(findcourse);
	}
}
