package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 메서드로 따로 뽑고 싶은 코드 드래그 cmd + option + m : 해당 부분이 메서드로 빠지며 이름 설정 가능
@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = request.getRequestURI(); // 들어오는 URI를 받는다
        System.out.println("requestURI = " + requestURI);

        ControllerV3 controller = controllerMap.get(requestURI); // 미리 URI로 매핑된 Controller 를 불러온다
        if(controller == null){ // 없을시
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request); // paramMap 을 넘겨주기위해 request에서 데이터들 꺼내서 Map 추출
        ModelView mv = controller.process(paramMap); // 각 Controller에게 넘겨주면 로직을 수행하고, ModelView 에 담아, 뱉어냄

        String viewName = mv.getViewName(); // 논리이름 반환 ex) new-form
        MyView view = viewResolver(viewName); // 뷰 반환 하는 메서드 사용(논리 이름에 경로와 확장명.jsp 추가해줌)

        view.render(mv.getModel(), request, response); // jsp 는 request 객체를 사용하기에 model의 parsing 이 필요함 (model 같이 넘겨줌)
    }

    // 논리 이름을 가지고 물리 이름을 뽑아주는 메서드
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    // 디테일한 코딩은 따로 메서드를 빼준다
    // request 돌려서 map 만들어주는 메서드
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

}
