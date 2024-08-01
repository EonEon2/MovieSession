package org.example.demo3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebServlet(value = "/mypage")
@Log4j2
public class MypageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("mypage doGet");

        HttpSession session = req.getSession(false);
        // 세션검사한다. 없으면 생성안해주고, 있는거 꺼내라.

        Object cartSession = session.getAttribute("cart");
        //cart라는 세션을 cartSession에 담아두고 (이 과정 생략하고 밑에 코드랑 합쳐도 무방 session이 Object 타입인걸 보여주고싶었음.)

        if(cartSession == null) { // cart session이 없다면 movies로 들려
            resp.sendRedirect("/movies");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/mypage.jsp").forward(req, resp);
    }
}
