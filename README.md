# 일정 관리 프로젝트
Lv 1 부터 Lv 7순으로 점차적으로 기능을 확장해 나간 일정 관리 프로그램 입니다.

## 목차 
* 개발 기간
* 개발 환경
* 구현한 기능
* 프로그램 확장 과정
* 패키지 구조
* API 명세
* ERD 명세
* 사용 방법
* 실행 예시

### 개발 기간 
25.11.03~25.11.05

### 개발 환경 
* 개발 언어 : JAVA
* JDK 버전 : 17
* 프레임워크 : Spring boot 3.5.7
* 빌드 도구 : Gradle
* DB : MySQL
* ORM : Spring Data JPA
* IDE : IntelliJ IDEA
* API 테스트 : Postman

### 구현한 기능 
| 번호| 기능명 | 설명 |
|-------|-------|-------|
|1| 일정 생성 | 제목, 내용, 작성자명, 비밀번호를 입력받아 일에 등록합니다. |
|2| 일정 전체 조회 | 등록된 모든 일정을 최신순으로 조회합니다. </br>그리고 특정 작성자명으로 조회시 작성자가 쓴 일정을 전부 조회합니다. |
|3| 일정 단건 조회 | 일정 ID를 통해 일정을 조회합니다. </br>그리고 단건 조회시 댓글이 있으면 댓글도 포함해서 출력합니다.|
|4| 일정 수정 | 일정 ID를 통해 특정 일정의 비밀번호를 검증한뒤 제목/작성자명 수정할 수 있습니다. |
|5| 일정 삭제 | 일정 ID를 통해 특정 일정의 비밀번호를 검증한뒤 일정을 삭제합니다. |
|6| 댓글 생성 | 특정 일정의 댓글을 등록합니다.(내용 작성자명 비밀번호를 입력받아 등록, </br>댓글은 최대 10개 제한) |

### 프로그램 확장 과정 
| 레벨 | 구현 내용 |
|-----|-----|
| Lv 1 | 일정 등록 기능 구현 |
| Lv 2 | 일정 전체 조회 및 단건 조회 기능 구현 |
| Lv 3 | 일정 수정 기능 구현 |
| Lv 4 | 일정 삭제 기능 구현 |
| Lv 5 | 댓글 생성 기능 구현 |
| Lv 6 | 일정 단건 조회시 등록된 댓글이 있으면 포함해서 출력하는 기능 구현 |
| Lv 7 | 유효성 검사 및 예외 처리 추가 |

### 패키지 구조
<img width="363" height="608" alt="image" src="https://github.com/user-attachments/assets/e351ab4c-4881-441d-98d5-7d2d4a6b1f76" />

### API 명세
https://documenter.getpostman.com/view/12989531/2sB3Wqu132


### ERD 명세
<img width="401" height="425" alt="image" src="https://github.com/user-attachments/assets/bbbcab64-d9d3-46c8-9d92-dc761c241aa6" />

### 사용 방법
1. IntelliJ 실행
2. schedule 폴더를 open
3. src/main/java/com/example/challengeschedule/ChallengeScheduleApplication.java 파일을 열기
4. 상단 메뉴에서 Run 클릭 해서 실행
5. Postman로 API요청 보내기

### 실행 예시
일정 생성

<img width="641" height="479" alt="image" src="https://github.com/user-attachments/assets/63b124e3-0dff-42cf-8b0d-92154c5d5a94" />

단건 조회

<img width="472" height="478" alt="image" src="https://github.com/user-attachments/assets/b22527cb-450b-4e24-9b29-3f2c4eb5a6b9" />

일정 작성자명으로 전체 조회

<img width="519" height="644" alt="image" src="https://github.com/user-attachments/assets/32271f9c-6fa7-4ffc-aa44-56ff0231fd00" />

일정 전체조회

<img width="534" height="695" alt="image" src="https://github.com/user-attachments/assets/fc26bc49-8d23-4571-bfd0-1d3815f2b418" />

일정 수정

<img width="653" height="461" alt="image" src="https://github.com/user-attachments/assets/3043f5b7-029c-4f20-a103-6d11ae85d183" />

일정 삭제

<img width="635" height="306" alt="image" src="https://github.com/user-attachments/assets/2bc95a15-e1ac-48b0-934c-c0d270c7bcf1" />

댓글 생성

<img width="630" height="451" alt="image" src="https://github.com/user-attachments/assets/f7c8a25f-0d0e-495a-8835-71f2395e847a" />


