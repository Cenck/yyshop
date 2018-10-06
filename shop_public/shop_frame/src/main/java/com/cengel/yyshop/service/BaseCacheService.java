package com.cengel.yyshop.service;

import java.io.Serializable;

public interface BaseCacheService {
	Serializable get(Integer id);
	void set(Integer id,Serializable entity);
}
