package com.url_short_nr;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.url_short_nr.dao.UrlRepo;

@RestController

public class UrlsRestController {
	
	@Autowired
	UrlRepo url_repo;
	
	private Map<String, TheUrls> shortenUrlList = new HashMap<>();
	
	@RequestMapping(value="/shortenurl", method=RequestMethod.POST)
	
	public ResponseEntity<Object> getShortenUrl(@RequestBody TheUrls shortenUrl) throws MalformedURLException {		
		String randomChar = getRandomChars();
	    setShortUrl(randomChar, shortenUrl);
		return new ResponseEntity<Object>(shortenUrl, HttpStatus.OK);
		
	}

	private void setShortUrl(String randomChar, TheUrls shortenUrl) {
		// TODO Auto-generated method stub
		shortenUrl.setShort_url("jc.links/short/"+randomChar);
		url_repo.save(shortenUrl);
		shortenUrlList.put(randomChar,  shortenUrl);	
	}
	
	
	private String getRandomChars() {
		String randomStr = "";
		String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++)
			randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
		return randomStr;
	}
}
