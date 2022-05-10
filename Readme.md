> # Spring MVC 학습 1

#### 도구: spring boot, timeleaf / IntelliJ
___
#### [프로젝트 설명]
* 스프링 mvc 학습
* 서버사이드 랜더링 new 기술 학습(timeleaf, jsp 포함)
* 서블릿, http 활용 등 웹 전반의 인프라에 대한 이해
* (HTTP 관련 강의 종료 후 들음, 추후 필요시 HTTP 강의 다시 들춰보기)
___
> 학습내용
##### servlet의 이해
* helloServlet 생성 및 활용
* 포스트 맨 활용
##### request 객체 활용 - 서블릿
* request content, header, body 관련 레거시한 작성법
* 관련 유용한 메서드 작성
  ~~~
  [데이터 받기] 3가지 방법
  - GET parameter (quary parameter)
  - POST HMTL Form 태그
  - HTML message body
    ㄴ JSON, XML, TEXT 
    ㄴ 여기선 JSON 으로 객체 활용해서 받음(HelloData)
  ~~~
##### response 객체 활용 - 서블릿
* Status-line, 편의 메서드 작성
  - content
  - cookie 
  - redirect
  - writer.println
  ~~~
  [응답 보내기] 3가지 방법
  - text
  - html
  - JSON
    ㄴ 객체 활용해서 받음(HelloData)
  ~~~



