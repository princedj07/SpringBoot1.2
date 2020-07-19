package com.springboot.rest.controller.model;

public class Greeting {

	  private String content;

	  public Greeting() {
	  }

	  public Greeting(String content) {
		  System.out.println("**** "+content);
	    this.content = content;
	  }

	  public String getContent() {
	    return content;
	  }

	}