package com.pagerduty.client.model;

public class User{
	private String summary;
	private String htmlUrl;
	private String self;
	private String id;
	private String type;

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setSelf(String self){
		this.self = self;
	}

	public String getSelf(){
		return self;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}
