package com.zhiyou100.ssh.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.dao.AdminSpeakerDao;
import com.zhiyou100.ssh.model.Speaker;
import com.zhiyou100.ssh.service.AdminSpeakerService;
import com.zhiyou100.ssh.util.Page;
@Service
public class AdminSpeakerServiceImpl implements AdminSpeakerService {
    @Autowired
	AdminSpeakerDao asd;

	@Override
	public List<Speaker> findSpeaker() {
		
		
		return asd.findSpeaker();
	}

	@Override
	public Page<Speaker> findspeaker(DetachedCriteria dc, Integer page) {
		// TODO Auto-generated method stub
		return asd.findspeaker(dc,page);
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		asd.addSpeaker(speaker);
	}

	@Override
	public Speaker findSpeakerBy(Integer id) {
		// TODO Auto-generated method stub
		return asd.findSpeakerBy(id);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		asd.updateSpeaker(speaker);
	}

	@Override
	public void deleteSpeaker(Speaker speaker) {
		
		asd.deleteSpeaker(speaker);
	}
	
}
