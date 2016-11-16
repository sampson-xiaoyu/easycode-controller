package com.easycode.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.easycode.client.SearchClient;

@Controller
public class UserController {
	
	@Resource(name = "searchClient")
	private SearchClient searchClient;
	
	public void queryUsers(){
		
	}
}
