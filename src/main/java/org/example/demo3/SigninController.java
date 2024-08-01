package org.example.demo3;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebServlet(value="/signin")
@Log4j2
public class SigninController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("sign doGet");

        req.getRequestDispatcher("/WEB-INF/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("sign doPost");
            String uid = req.getParameter("uid"); //uid의 정보를 파라미터 값으로 가져온다.


            HttpSession session = req.getSession(); //세션이 없으면 생성, 있으면 기존것으로 시작.

            session.setAttribute("userInfo", uid);
            // userInfo라는 이름의 세션에 uid정보를 넣어준다. 결국에는 Obejct userInfo = uid
            // 이렇게 변수처럼 활용도 가능하고, 다른 페이지에서 이 페이지를 들렸다는 입장권 역할도 한다.
            resp.sendRedirect("/movies");
    }
}
