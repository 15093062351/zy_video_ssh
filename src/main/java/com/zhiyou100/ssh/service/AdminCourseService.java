package com.zhiyou100.ssh.service;

import java.util.List;

import com.zhiyou100.ssh.model.Course;
import com.zhiyou100.ssh.model.Speaker;
import com.zhiyou100.ssh.model.Statistics;
import com.zhiyou100.ssh.model.Subject;
import com.zhiyou100.ssh.model.Video;

public interface AdminCourseService {

	List<Course> findCourse();

	List<Subject> findSubject();

	List<Course> findCourse(Integer subjectId);

	Video findVideoBy(Integer videoId);

	Speaker findSpeakerBy(Integer speakerId);

	List<Video> findVideoList(Integer courseId);

	List<Statistics> findStatistics();

	void addCourse(Course course);

	Course findcourse(Integer id);

	void updateCourse(Course course);

	void deleteCourse(Course findcourse);

}
