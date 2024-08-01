package org.example.demo3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/movies")
@Log4j2
public class MoviesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("movies doGet");

        ArrayList<String> movies = new ArrayList<>();
        // movies라는 이름으로 jpg사진을 넣을 list를 생성해준다.

        movies.add("movie1.jpg");
        movies.add("movie2.jpg");
        movies.add("movie3.jpg");
        movies.add("movie4.jpg");
        movies.add("movie5.jpg");

        req.setAttribute("movies", movies);
        //jsp에서는 movies라는 이름으로 movies 배열의 정보가 들어가있어서 변수역할을 하고.
        //Controller에서는 session입장권 역할을한다.

        req.getRequestDispatcher("/WEB-INF/movies.jsp").forward(req, resp);
    }
}
