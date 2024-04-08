# Town Project

> **프로젝트 소개**

이웃과 소통하고 다양한 활동을 도모할 수 있는 프로그램입니다.  
현재는 개발 진행 중입니다.

- spring mvc 구조로 개발하였습니다.
- 객체의 불변성 유지를 위해 Builder 패턴을 적용하였습니다.
- @ControllerAdvice를 이용하여 하나의 클래스로 모든 컨트롤러에서 발생할 수 있는 예외를 잡고 @ExceptionHandler를 통해 예외의 종류에 따른 메서드를 작성하여 코드의 가독성을 높였습니다.
- 회원가입시, Bean Validation을 이용하여 유효성 검증을 하였습니다.
- ajax를 이용하여 ID 중복 확인 기능을 구현하였습니다.
- 카카오 우편번호 api를 이용하여 주소 검색 기능을 구현하였습니다.
- Spring Security를 적용하여 로그인 기능을 구현하였습니다.

> **사용기술**

- FrontEnd : HTML, CSS, JavaScript, jQuery, BootStrap
- BackEnd : Java, SpringBoot, JSP, Mybatis
- DataBase : MariaDB

> **개발환경**

- IDE : Eclipse
- Version Control : Git/Github
- Build Tool : Maven
