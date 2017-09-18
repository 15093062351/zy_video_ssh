package com.zhiyou100.ssh.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.model.Speaker;
import com.zhiyou100.ssh.util.Page;

public interface AdminSpeakerService {

	List<Speaker> findSpeaker();

	Page<Speaker> findspeaker(DetachedCriteria dc, Integer page);

	void addSpeaker(Speaker speaker);

	Speaker findSpeakerBy(Integer id);

	void updateSpeaker(Speaker speaker);

	void deleteSpeaker(Speaker speaker);

}
