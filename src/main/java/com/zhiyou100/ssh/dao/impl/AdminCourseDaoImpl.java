package com.zhiyou100.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.dao.AdminCourseDao;
import com.zhiyou100.ssh.model.Course;
import com.zhiyou100.ssh.model.Speaker;
import com.zhiyou100.ssh.model.Statistics;
import com.zhiyou100.ssh.model.Subject;
import com.zhiyou100.ssh.model.Video;
public class AdminCourseDaoImpl extends HibernateDaoSupport implements AdminCourseDao {

	@Override
	public List<Course> findCourse() {
		List<Course> list = (List<Course>) getHibernateTemplate().find("from Course");
		return list;
	}

	@Override
	public List<Subject> findSubject() {
		List<Subject> list = (List<Subject>) getHibernateTemplate().find("from Subject");
		
		return list;
	}

	@Override
	public List<Course> findCourse(Integer subjectId) {
		List<Course> list = (List<Course>) getHibernateTemplate().find("from Course where subject_id = ?", subjectId);
		return list;
	}

	@Override
	public Video findVideoBy(Integer videoId) {
		
		List<Video> list = (List<Video>) getHibernateTemplate().find("from Video where id = ?", videoId);
		Video video = list.get(0);
		return video;
	}

	@Override
	public Speaker findSpeakerBy(Integer speakerId) {
		List<Speaker> list = (List<Speaker>) getHibernateTemplate().find("from Speaker where id = ?", speakerId);
		Speaker speaker = list.get(0);
		return speaker;
	}

	@Override
	public List<Video> findVideoList(Integer courseId) {
		List<Video> list = (List<Video>) getHibernateTemplate().find("from Video where  course_id = ?", courseId);
		return list;
	}

	@Override
	public List<Statistics> findStatistics() {
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery("select course_name courseName,"
				+ "ROUND(AVG(video_play_times)) avgTime "
				+ "from video,course c where course_id = c.id "
				+ "GROUP BY course_id").setResultTransformer(Transformers.aliasToBean(Statistics.class));
		List<Statistics> list =  query.list();
		return list;
	}

	@Override
	public void addCourse(Course course) {
		getHibernateTemplate().save(course);
		
	}

	@Override
	public Course findcourse(Integer id) {
		List<Course> list = (List<Course>) getHibernateTemplate().find("from Course where id = ?", id);
		Course course = list.get(0);
		return course;
	}

	@Override
	public void updateCourse(Course course) {
		getHibernateTemplate().update(course);
	}

	@Override
	public void deleteCourse(Course findcourse) {
		getHibernateTemplate().delete(findcourse);
		
	}
	
	
	
	
	
}
