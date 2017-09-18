package com.zhiyou100.ssh.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.model.Result;
import com.zhiyou100.ssh.model.Speaker;
import com.zhiyou100.ssh.service.AdminCourseService;
import com.zhiyou100.ssh.service.AdminSpeakerService;
import com.zhiyou100.ssh.util.Page;
@Controller("adminSpeakerAction")
@Scope(scopeName="prototype")
public class AdminSpeakerAction extends ActionSupport implements ModelDriven<Speaker>{
	@Autowired
	AdminSpeakerService ass;
	@Autowired
	AdminCourseService acs;
	
	private String queryName;
	private String queryJob;
	private Integer page;
	private Result result;
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	private Speaker speaker = new Speaker ();
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public String getQueryJob() {
		return queryJob;
	}
	public void setQueryJob(String queryJob) {
		this.queryJob = queryJob;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

	public String speakerList(){
		queryName =queryName==null ? "" : queryName;
		queryJob = queryJob ==null ?"" : queryJob;
		page = page ==null ? 1 : page;
		DetachedCriteria dc =DetachedCriteria.forClass(Speaker.class);
		dc.add(Restrictions.like("speakerName", queryName, MatchMode.ANYWHERE));
		dc.add(Restrictions.like("speakerJob", queryJob, MatchMode.ANYWHERE));
		Page<Speaker> thepage = ass.findspeaker(dc,page);
		ActionContext.getContext().put("pages", thepage);
		return SUCCESS;
	}
	
	public String speakeradd(){
		return SUCCESS;
	}
	public String speakeraddbaocun(){
		ass.addSpeaker(speaker);
		return SUCCESS;
	}
	@Override
	public Speaker getModel() {
		return speaker;
	}
	public String updateSpeaker(){
         Speaker s = ass.findSpeakerBy(speaker.getId());
         ActionContext.getContext().put("s", s);
		return SUCCESS;
	}
	
	public String updateSpeakerbaocun(){
      ass.updateSpeaker(speaker);
		return SUCCESS;
	}
	
	public String deleteSpeaker(){
		
		result = new Result();
		ass.deleteSpeaker(speaker);
		result.setSuccess(true);
		return SUCCESS;
	}
	
	
	
	
	
	
	

}
