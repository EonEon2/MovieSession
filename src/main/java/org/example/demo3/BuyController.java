package org.example.demo3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/buy")
@Log4j2
public class BuyController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("buy doPost");

        String [] items = req.getParameterValues("item");
        // movies.jsp에서 선택한것인 name="item"의 item을 파라미터 값으로 가져온다.
        // 그것들을 String으로 배열에 담는다.

        if(items == null || items.length == 0){ //만약에 movies에서 담지 않았으면 movies로 다시 보낸다.
            log.info("no");
            resp.sendRedirect("/movies");
            return;
        }


        HttpSession session = req.getSession(false);
        // session을 생성하지않고, 한번 꺼내봐.

        Object cartObj = session.getAttribute("cart");
        //cart라는 session이 있는지 없는지 확인한다.


        if(cartObj == null){ // cart session이 없다면 (첫방문)
            ArrayList<String> cartItems = new ArrayList<>();
            for(int i = 0; i < items.length; i++){
                cartItems.add(items[i]);
            }
            session.setAttribute("cart", cartItems); // 나중에 cart라는 이름으로 cartItems배열을 사용할거야.
        }
        else{ // 재방문할떄
            ArrayList<String> cartItems = (ArrayList<String>) cartObj; //다운캐스팅
            for(int i = 0; i < items.length; i++){
                cartItems.add(items[i]);
            }
        }

        log.info("buy now");
        resp.sendRedirect("/mypage");


    }


}
