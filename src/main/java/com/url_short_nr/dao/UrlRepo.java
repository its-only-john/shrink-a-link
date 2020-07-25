package com.url_short_nr.dao;

import org.springframework.data.repository.CrudRepository;

import com.url_short_nr.TheUrls;

public interface UrlRepo extends CrudRepository<TheUrls, String>{

}
