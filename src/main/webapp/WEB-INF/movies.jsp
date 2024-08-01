
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Movies Page</h1>
<style>
    .pic{
        width: 12rem;
        margin : 2rem;
    }
</style>

<form action="/buy" method="post"> <!--buy버튼을 누르면 post만 있는 buy컨트롤러로 이동한다.-->
        <c:forEach items="${movies}" var="movie"> <!--movies컨트롤러에서 배열로 넣어두고 movies라는 이름으로 사용하기로 했다.-->
            <li>
                <img class="pic" src="/img/${movie}">
                <input type="checkbox" name="item" value="${movie}" >${movie}
                <!-- name="item"은 나중에 buy컨트롤러에서 item을 파라미터 값으로 가져오게 되면 내가 선택한 value(사진)들이 들어온다.-->
            </li>
        </c:forEach>
    <button>BUY</button>
</form>
</body>
</html>
