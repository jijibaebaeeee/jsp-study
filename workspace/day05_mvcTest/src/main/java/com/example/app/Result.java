package com.example.app;

public class Result {
	private String path;
	private boolean isRedirect;
	
	
	//기본생성자
	public Result() {
		super();
	}

	//게터 세터
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public boolean isRedirect() {
		return isRedirect;
	}


	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
	
	
}
