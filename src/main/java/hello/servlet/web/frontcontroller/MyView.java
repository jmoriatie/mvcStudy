package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyView {
    private String viewPath;

    // 생성 시점에 viewPath 넣어주고
    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    // 기존 jsp 로 이동하는 것 등을 렌더링이라고 함
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
