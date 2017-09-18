package com.zhiyou100.ssh.service.impl;




import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.dao.AdminVideoDao;
import com.zhiyou100.ssh.model.Video;
import com.zhiyou100.ssh.service.AdminVideoService;
import com.zhiyou100.ssh.util.Page;
@Service
public class AdminVideoServiceImpl implements AdminVideoService {
    @Autowired
	AdminVideoDao avd;

	@Override
	public Page<Video> findVideo(DetachedCriteria dc, Integer page) {
		
		
		
		return avd.findVideo(dc,page);
	}

	@Override
	public void addVideo(Video video) {
		
		avd.addVideo(video);
	}

	@Override
	public void deleteVideoBy(Video video) {
		avd.deleteVideoBy(video);
	}

	@Override
	public Video findVideoBy(Integer id) {
		
		return avd.findVideoBy(id);
	}

	@Override
	public void updateVideo(Video video) {
		avd.updateVideo(video);
	}

	@Override
	public void deleteVideobach(Integer[] checkid) {
		avd.deleteVideobach(checkid);
		
	}

	


	
    

}
