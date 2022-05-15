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
<<<<<<< HEAD
##### mvc 패턴
* jsp 기초
* mvc 패턴의 개념 및 서블릿의 분리(servlet -> Controller, view 렌더링)
  - 분리이유: 수정주기가 달라서, 한 곳에 너무 많은 책임들이 들어가있어서 등

##### Front Controller
* v1 : 컨트롤러를 찾고 넘겨주는 용도의 front controller, 기존 코드들은 유지
  - (Tip!) 구조를 수정할 시, 구조만 하자! 세부적인 코드 수정은 유지, 구조수정->배포 우선하고,
  - 디테일한 코드를 수정하는 것이 실수를 줄이는 개발 방법!
* v2 : MyView 를 통해 jsp forward 및 rendering
  - Controller 는 jsp forward에 대해 고민X, MyView가 Rendering



