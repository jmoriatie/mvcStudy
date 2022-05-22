package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }


    // Spring mvc 에서 ViewResolver 가 실제로 해주는 역할은 이러함
    // ㄴ 설정정보(application.properties)에 넣은 것이 아래와 같이 동작한다는 것
    @Bean
    ViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }
}
