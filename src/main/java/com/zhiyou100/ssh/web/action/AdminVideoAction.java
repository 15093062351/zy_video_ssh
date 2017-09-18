package com.zhiyou100.ssh.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.model.Course;
import com.zhiyou100.ssh.model.Speaker;
import com.zhiyou100.ssh.model.Statistics;
import com.zhiyou100.ssh.model.Video;

import com.zhiyou100.ssh.service.AdminCourseService;
import com.zhiyou100.ssh.service.AdminSpeakerService;
import com.zhiyou100.ssh.service.AdminVideoService;
import com.zhiyou100.ssh.util.Page; 

@Controller("adminVideoAction")
@Scope(scopeName="prototype")
public class AdminVideoAction  extends ActionSupport implements ModelDriven<Video> {
	@Autowired
	AdminVideoService avs;
	@Autowired
	AdminSpeakerService ass;
	@Autowired
	AdminCourseService acs;
	
	private Integer speakerId;
	private Integer page;
	private Integer courseId;
	private String queryName;
	
	private Integer[] checkid;
	
	
	public Integer[] getCheckid() {
		return checkid;
	}
	public void setCheckid(Integer[] checkid) {
		this.checkid = checkid;
	}

	private Video video = new Video();
	
	public Integer getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(Integer speakerId) {
		this.speakerId = speakerId;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public String videoList(){
		
		page = page ==null ? 1 : page;
		speakerId =video.getSpeakerId() ==null ? 0 : video.getSpeakerId();
		courseId = video.getCourseId() ==null ? 0 : video.getCourseId();
		queryName =queryName==null ? "" : queryName;
		
     DetachedCriteria dc =DetachedCriteria.forClass(Video.class);
		
	 dc.add(Restrictions.like("videoTitle", queryName, MatchMode.ANYWHERE));
	 if(speakerId !=0){
		 dc.add(Restrictions.eq("speaker.id", speakerId));
	 }
	 if(courseId !=0){
		 dc.add(Restrictions.eq("course.id", courseId));
	 }
		
		Page<Video> thepage = avs.findVideo(dc,page);
		ActionContext.getContext().put("pages", thepage);
		
		List<Course> courses =acs.findCourse(); 
		ActionContext.getContext().put("courses", courses);
		
		List<Speaker>  speakers = ass.findSpeaker();
		ActionContext.getContext().put("speakers", speakers);
		
		return SUCCESS;
	}

public String videoadd(){
	
	List<Course> courses =acs.findCourse(); 
	ActionContext.getContext().put("course", courses);
	
	List<Speaker>  speakers = ass.findSpeaker();
	ActionContext.getContext().put("list", speakers);
	
	return SUCCESS;
	
}
@Override
public Video getModel() {
	return video;
}
	
public String videobaocun(){
	
	avs.addVideo(video); 
	return SUCCESS;
}	
	
public String deletevideo(){
	avs.deleteVideoBy(video);
	return SUCCESS;
}	
	
public String updatevideo(){
	
    Video v = avs.findVideoBy(video.getId());
    List<Course> courses =acs.findCourse(); 
	ActionContext.getContext().put("course", courses);
	
	List<Speaker>  speakers = ass.findSpeaker();
	ActionContext.getContext().put("list", speakers);
    
    ActionContext.getContext().put("vd", v);
	return SUCCESS;
}	
  public String updatevideobaocun(){
	  
	  
	  avs.updateVideo(video);
	  return SUCCESS;
  }

  public String batchDelete(){
	  
	  avs.deleteVideobach(checkid);
	  return SUCCESS;
  }
  
  
  //统计分析
  public String courseStatistical(){
	  
	  List<Statistics> list = acs.findStatistics();

		StringBuffer dataBuffer = new StringBuffer();
		StringBuffer timeBuffer = new StringBuffer();
		
		for (int i = 0; i < list.size(); i++){
			Statistics st = list.get(i);
			dataBuffer.append(st.getCourseName());
			timeBuffer.append(st.getAvgTime());
			if(i != list.size() -1 ){
				dataBuffer.append(",");
				timeBuffer.append(",");
			}
		}
		ActionContext.getContext().put("data",dataBuffer.toString());
		ActionContext.getContext().put("times",timeBuffer.toString());
		
	  return SUCCESS;
  }
  
  
  



	
}
