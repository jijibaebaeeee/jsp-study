package com.example.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 모든 클래스는 이거를 상속받아서 구현만 하면된다.

// Execute 왜필요한가?
// 프론트 controller에서 분기돼서 각 controller(servlet)으로 왔으니 여기서 쿼리 메소드를 실행해야함

public interface Execute {
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
