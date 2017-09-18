package com.zhiyou100.ssh.service;



import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh.model.Video;
import com.zhiyou100.ssh.util.Page;

public interface AdminVideoService {

	Page<Video> findVideo(DetachedCriteria dc, Integer page);

	void addVideo(Video video);

	void deleteVideoBy(Video video);

	Video findVideoBy(Integer id);

	void updateVideo(Video video);

	void deleteVideobach(Integer[] checkid);






	



}
