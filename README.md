# TIL
Today I Learned

## 디렉토리별 주제
- books : 책을 통한 TIL
- docs : 학습 내용 문서화(블로그 외에)
- framework : 프레임워크 TIL
- programming-language : 언어 TIL

## git message 규칙 
###  <타입> 리스트
|타입 |내용|
|:---|:---|
|Init|초기화|
|Feat|기능 (새로운 기능)|
|Fix|버그 수정|
|Refactor|리팩토링|
|Styles|스타일(코드 형식, 세미콜론 추가: 비즈니스 로직에 변경 없음)|
|Docs|문서 (문서 추가, 수정, 삭제)|
|Test|테스트 (테스트 코드 추가, 수정, 삭제 : 비즈니스 로직에 변경 없음)|
|Chore|기타 변경 사항(빌드 스크립트 수정 등)|

### 메시지 내용 작성
- 제목 첫 글자는 대문자로
- 제목은 명령문으로
- 제목 끝에 마침표 금지
- 제목과 본문을 한 줄 띄워 분리하기
- 본문은 "어떻게"보다 "무엇을", "왜"를 설명
- 본문에 여러 줄의 메시지를 작성할 땐 "-"혹은 "번호"로 구분

### 커밋 메시지 예
```
# --- <타입(type)> <제목(title)> - 50자 이내로 ---
Docs(Add) Commit docs Add
# --- 본문(content) - 72자마다 줄바꾸기  ---
- Workflow
1. 커밋 메시지에 대한 문서 제작 추가.
2. commit message docs add.
# --- 꼬리말(footer) <타입(type)> <이슈 번호(issue number)> --- 
예시(ex) : Fix #122
```

