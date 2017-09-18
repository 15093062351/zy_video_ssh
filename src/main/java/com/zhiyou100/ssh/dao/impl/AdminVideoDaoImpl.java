package com.zhiyou100.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.dao.AdminVideoDao;
import com.zhiyou100.ssh.model.Video;
import com.zhiyou100.ssh.util.Page;

public class AdminVideoDaoImpl extends HibernateDaoSupport  implements AdminVideoDao {

	@Override
	public Page<Video> findVideo(DetachedCriteria dc, Integer page) {
		
		int size = getHibernateTemplate().findByCriteria(dc).size();
		
		List<Video> video = (List<Video>) getHibernateTemplate().findByCriteria(dc, 5*(page-1), 5);
		
		Page<Video> p = new Page<>();
		p.setPage(page);
		p.setRows(video);
		p.setSize(5);
		p.setTotal(size);
		return p;
		
	}
	@Override
	public void addVideo(Video video) {
		
		getHibernateTemplate().save(video);
		
	}
	@Override
	public void deleteVideoBy(Video video) {
		getHibernateTemplate().delete(video);
		
	}
	@Override
	public Video findVideoBy(Integer id) {
		
		List<Video> list = (List<Video>) getHibernateTemplate().find("from Video where id = ?", id);
		Video video = list.get(0);
		
		return video;
	}
	@Override
	public void updateVideo(Video video) {
		
		getHibernateTemplate().update(video);
	}
	/*@Override
	public void deleteVideobach(List<Integer> list) {
		for(Integer li:list){
			getHibernateTemplate().delete(li);
		}
	}*/
	@Override
	public void deleteVideobach(Integer[] checkid) {
		for(int li:checkid){
			List<Video> list = (List<Video>) getHibernateTemplate().find("from Video where id = ?", li);
			getHibernateTemplate().delete(list.get(0));
		}
	}
	
	}
	
	


	
	

