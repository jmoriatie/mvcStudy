package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

// /** + enter : 메서드 위에다 쓰면, 자동 주석 생성
public interface ControllerV4 {

    /**
     *
     * @param paramMap
     * @param model
     * @return
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
