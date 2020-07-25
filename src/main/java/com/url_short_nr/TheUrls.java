package com.url_short_nr;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TheUrls {
	@Id
	private String short_url;
	private String full_url;
	

	public String getFull_url() {
		return full_url;
	}

	public void setFull_url(String full_url) {
		this.full_url = full_url;
	}

	public String getShort_url() {
		return short_url;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}
}
