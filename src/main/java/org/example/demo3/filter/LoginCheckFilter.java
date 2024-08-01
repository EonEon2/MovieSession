package org.example.demo3.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebFilter(urlPatterns = {"/movies","/buy","/mypage"}) //가장 기초적으로 들고있어야할, userInfo값은 매 브라우저마다 검사할거야.
// value 라고 해도 상관없음.
@Log4j2

public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession(false);
        //session 검사한다. 있으면 꺼내고, 없으면 생성안해줘

        if(session == null || session.getAttribute("userInfo") == null){ //가장 처음에 지급하는 userInfo 검사.
            resp.sendRedirect("/signin"); //없으면 초기화면으로
            log.info("No session");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse); //꼭해줘야해.

    }
}
