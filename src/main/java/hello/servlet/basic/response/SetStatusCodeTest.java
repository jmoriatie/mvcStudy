package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "setStatusCodeTest", urlPatterns = "/set-statuscode-test")
public class SetStatusCodeTest extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        List<String> params = new ArrayList<>();
//        request.getParameterNames().asIterator()
//                        .forEachRemaining(paramName -> params.add( request.getParameter(paramName) ));
//
//        String code = "";
//        for (String param : params) {
//            System.out.println("param = " + param);
//            if(param != null){
//                code = param;
//            }
//        }

        String code = request.getParameter("code");
        System.out.println("code = " + code);

        switch (code){
            case "202":
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("SUCCESS!!");
            case "404":
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                break;
            case "304":
                response.sendRedirect("/basic/set-status-code-test.html");
                break;
            case "500":
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                break;
            case "default":
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("없는 코드!!!");
            default:
                response.setHeader("Location", "/basic/set-status-code-test.html");
                response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
        }



    }
}
