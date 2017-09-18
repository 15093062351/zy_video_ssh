package com.zhiyou100.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.dao.AdminSpeakerDao;
import com.zhiyou100.ssh.model.Speaker;
import com.zhiyou100.ssh.util.Page;

public class AdminSpeakerDaoImpl extends HibernateDaoSupport implements AdminSpeakerDao {
	@Override
	public List<Speaker> findSpeaker() {
		List<Speaker> list = (List<Speaker>) getHibernateTemplate().find("from Speaker");
		return list;
	}

	@Override
	public Page<Speaker> findspeaker(DetachedCriteria dc, Integer page) {
		
		int size = getHibernateTemplate().findByCriteria(dc).size();
		List<Speaker> speaker = (List<Speaker>) getHibernateTemplate().findByCriteria(dc, 5*(page-1), 5);
		
		Page<Speaker> p = new Page<>();
		p.setPage(page);
		p.setSize(5);
		p.setTotal(size);
		p.setRows(speaker);
		return p;
	}
	
	@Override
	public void addSpeaker(Speaker speaker) {
		getHibernateTemplate().save(speaker);
	}

	@Override
	public Speaker findSpeakerBy(Integer id) {
		List<Speaker> list = (List<Speaker>) getHibernateTemplate().find("from Speaker where id = ? ", id);
		Speaker speaker = list.get(0);
		return speaker;
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		getHibernateTemplate().update(speaker);
		
	}

	@Override
	public void deleteSpeaker(Speaker speaker) {
		getHibernateTemplate().delete(speaker);
	}

}
