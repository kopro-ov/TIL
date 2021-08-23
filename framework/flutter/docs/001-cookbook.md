| 내용 | 최초 작성일 | 참고 |
|---|:---:|---:|
| 가장 적합한 질문을 찾아내는 방식으로 이 문서를 요리책(cookbook) | 2021-08-23 | Flutter 한국 공식 문서 |
필요한 부분에 가장 적합한 질문을 찾아내는 방식으로 이 문서를 요리책(cookbook)처럼 활용하실 수도 있다.
# Dart 소개
React Native처럼, Flutter는 reactive-style 뷰를 사용한다.  
하지만, 네이티브 위젯으로 변환(transpile)하는 RN과 달리, Flutter는 모든 것을 네이티브 코드로 직접 컴파일한다.  
Flutter는 화면의 각 픽셀을 직접 제어하기 때문에, 자바스크립트 브리지로 인한 성능 문제가 발생하지 않습니다.  
Dart는 아래와 같은 기능을 제공한다.
- 웹, 서버, 모바일 앱 개발이 가능한 확장성 있는 오픈 소스 프로그래밍 언어 제공
- AOT를 통해 네이티브로 컴파일되는 C 방식의 구문을 사용하는 객체 지향 단일 상속 언어를 제공
- 자바스크립트로 변환(transcompile) 가능
- 인터페이스와 추상 클래스 지원
# 진입점(사용자 정의 시작 주소를 지정하는 함수)
자바스크립트에는 진입점 역할을 하는 함수가 미리 정의되어 있지 않지만, Dart에서는 최상단에 앱의 진입점인 main() 함수가 반드시 있어야 한다.
**Javascript**
```javascript
// JavaScript
function startHere() {
  // Can be used as entry point
}
```
**Dart**
```dart
// Dart
main() {
}
```
[DartPad](https://dartpad.dev/?id=0df636e00f348bdec2bc1c8ebc7daeb1&null_safety=true)에서 확인이 가능하다.
# 콘솔 출력
**Javascript**
```javascript
console.log('Hello world!');
```
**Dart**
```dart
print('Hello world!');
```
[DartPad](https://dartpad.dev/?id=cf9e652f77636224d3e37d96dcf238e5&null_safety=true)에서 확인이 가능하다.
# 변수
Dart는 타입 검사를 하는(type safe) 언어이다.  
Dart는 정적 타입 검사와 런타임 검사를 동시에 사용하여, 변수의 값이 변수의 정적 타입과 항상 일치하는지 검사한다.  
타입이 필수이긴 하지만, 타입 추론을 하기 때문에 일부 타입 표기는 생략해도 된다.  
## 변수 생성 및 할당
자바스크립트에서는, 변수의 타입을 선언할 수 없다.  
[Dart](https://dart.dev/dart-2)에서는, 명시적으로 변수의 타입을 선언하거나 타입 시스템이 자동으로 적절한 변수의 타입을 추론할 수 있어야 한다.  
**javascript**
```javascript
var name = 'JavaScript';
```
**dart**
```dart
String name = 'dart'; // 명시적으로 문자열 타입 선언.
var otherName = 'Dart'; // 문자열 타입으로 추론.
// Dart에서는 두 방법 다 가능.
```
[DartPad](https://dartpad.dev/?id=3f4625c16e05eec396d6046883739612&null_safety=true)  
[Dart의 타입 시스템](https://dart.dev/guides/language/type-system)
## 기본값
자바스크립트에서 초기화지 않은 변수는 undefined,  
DartDart에서 초기화하지 않은 변수는 null 값을 가진다.  
Dart에선 숫자도 객체이기 때문에, 초기화하지 않은 숫자 타입 변수도 null 값을 가진다.
**javascript**
```javascript
var name; // == undefinedjava
```
**dart**
```dart
var name; // == null
int x; // == null
```
[DartPad](https://dartpad.dev/?id=57ec21faa8b6fe2326ffd74e9781a2c7&null_safety=true)  
[Dart 변수](https://dart.dev/guides/language/language-tour#variables)
# null 또는 0 체크
자바스크립트는 1이나 null이 아닌 객체도 true로 취급한다.  
```javascript
var myNull = null;
if (!myNull) {
  console.log('null is treated as false');
}
var zero = 0;
if (!zero) {
  console.log('0 is treated as false');
}
```
Dart는 boolean 값 true만 true로 취급한다.
```dart
var myNull = null;
if (myNull == null) {
  print('use "== null" to check null');
}
var zero = 0;
if (zero == 0) {
  print('use "== 0" to check zero');
}
```
[DartPad](https://dartpad.dev/?id=c85038ad677963cb6dc943eb1a0b72e6&null_safety=true)
# 함수
Dart와 자바스크립트 함수는 유사하나 주된 차이점은 선언이다.  
**Javascript**
```javascript
function fn() {
  return true;
}
```
**Dart**
```dart
fn() {
  return true;
}
// can also be written as
bool fn() {
  return true;
}
```
[DartPad](https://dartpad.dev/?id=5454e8bfadf3000179d19b9bc6be9918&null_safety=true)  
[Dart함수](https://dart.dev/guides/language/language-tour#functions)



