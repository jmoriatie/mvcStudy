> # Spring MVC 학습 1

#### 도구: spring boot, jsp, timeleaf / IntelliJ
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

##### mvc 패턴
* jsp 기초
* mvc 패턴의 개념 및 서블릿의 분리(servlet -> Controller, view 렌더링)
  - 분리이유: 수정주기가 달라서, 한 곳에 너무 많은 책임들이 들어가있어서 등

##### Front Controller
> front-controller 는 spring framework 의 핵심! 가장먼저 이런저런 것들을 처리해주는 컨트롤러
>> framework 는 아키텍쳐 도 중요하지만, 개발자가 단순하고 편리하게 사용할 수 있어야함(실용성)
* v1 : 해당 controller 찾고 view 에게 넘겨주는 용도의 front-controller, 기존 코드들은 유지
  - (Tip!) 구조를 수정할 시, 구조만 하자! 세부적인 코드 수정은 유지, 구조수정->배포 우선하고,
  - 디테일한 코드를 수정하는 것이 실수를 줄이는 개발 방법!
* v2 : MyView 를 통해, jsp forward 및 rendering
  - Controller 는 jsp forward에 대해 고민X, MyView가 Rendering
  - 수정 주기가 다른 앞, 뒷단의 분리를 통해 유지보수 용이
* v3 : 서블릿 종속성 제거, 뷰 이름 중복 제거(ModelView 객체)
  - Controller 가 Servlet 기술을 전혀 사용하지 않아도 되도록 만듦
    - 장점 : 구현코드의 단순화, 테스트 코드 작성 용이
  - Controller: 논리이름 반환, Front-Controller: 실제 물리적 위치 처리(viewResolve 메서드)
    - 장점 : view 폴더 위치 변경시에도 Front-Controller 만 수정하면 됨 -> 유지보수 용이
  - front-controller 패턴의 구조적인 부분은 v3에서 거의 완성!
* v4 : 단순하고 실용적인 컨트롤러
  - 개발자가 편할 수 있는 컨트롤러!
  - v3 랑 동일하지만 Controller 가 view 논리 이름만 반환 
  - front-controller 에서 model Map 먼저 생성
  - model Map을 파라미터로 넘겨서, controller 는 걔를 그냥 사용하고 view 논리 이름만 리턴함
* v5 : 유연한 컨트롤러 사용을 위해, 핸들러 어댑터(handler 를 호출하는 어댑터) 적용
  - Handler->Controller 로 생각
  - Hanlder 는 어떤 것이든 해당하는 종류의 어댑터만 있으면 처리할 수 있기에, Controller보다 확장된 개념
  - Front-Controller 는 Handler adapter 를 통해 Contoller(Handler) 를 호출
  - 기능이 확장되더라도 HandlerAdapter 만 추가해주면 됨(OCP 와 DIP 가 매우 만족됨)
