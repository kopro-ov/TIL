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
# 비동기 프로그래밍
## Futures
자바스크립트와 마찬가지로 Dart도 단일 스레드 실행을 지원한다.  
자바스크립트에서 Promise 객체는 비동기 작업의 최종 완료 (또는 실패)와 결과 값을 나타낸다.
Dart는 이러한 비동기 처리를 위해서 [Future](https://dart.dev/codelabs/async-await) 객체를 사용한다.  
**javascript**
```javascript
class Example {
  _getIPAddress() {
    const url = 'https://httpbin.org/ip';
    return fetch(url)
      .then(response => response.json())
      .then(responseJson => {
        const ip = responseJson.origin;
        return ip;
      });
  }
}

function main() {
  const example = new Example();
  example
    ._getIPAddress()
    .then(ip => console.log(ip))
    .catch(error => console.error(error));
}

main();
```
**dart**
```dart
import 'dart:convert';
import 'package:http/http.dart' as http;

class Example {
  Future<String> _getIPAddress() {
    final url = 'https://httpbin.org/ip';
    return http.get(url).then((response) {
      String ip = jsonDecode(response.body)['origin'];
      return ip;
    });
  }
}

main() {
  final example = new Example();
  example
      ._getIPAddress()
      .then((ip) => print(ip))
      .catchError((error) => print(error));
}
```
더 많은 정보를 원하시면, [Futures](https://dart.dev/codelabs/async-await)를 참조
## async와 await
async 함수 선언으로 비동기 함수를 정의한다.  
자바스크립트에서는 async 함수가 Promise를 반환한다.  
await 연산자는 Promise를 기다리기 위해서 사용한다.  
**javascript**
```javascript
class Example {
  async function _getIPAddress() {
    const url = 'https://httpbin.org/ip';
    const response = await fetch(url);
    const json = await response.json();
    const data = await json.origin;
    return data;
  }
}

async function main() {
  const example = new Example();
  try {
    const ip = await example._getIPAddress();
    console.log(ip);
  } catch (error) {
    console.error(error);
  }
}

main();
```
Dart에서는 async 함수가 Future를 반환하고, 함수의 구현된 내용은 나중에 실행되도록 예약된다.  
await 연산자는 Future를 기다리기 위해서 사용된다.  
**dart**
```dart
import 'dart:convert';
import 'package:http/http.dart' as http;

class Example {
  Future<String> _getIPAddress() async {
    final url = 'https://httpbin.org/ip';
    final response = await http.get(url);
    String ip = jsonDecode(response.body)['origin'];
    return ip;
  }
}

main() async {
  final example = new Example();
  try {
    final ip = await example._getIPAddress();
    print(ip);
  } catch (error) {
    print(error);
  }
}
```
# 기본
## Flutter 앱을 만드는 방법은?
React Native로 앱을 만드려면 커멘드라인에서 create-react-native-app을 실행하면 된다.
```
$ create-react-native-app <projectname>
```
Flutter에서 앱을 만들기 위해서는, 아래 방법 중 하나를 수행하면 된다.
- Flutter와 Dart 플러그인이 설치된 IDE를 이용하세요.
- 커멘드라인에서 flutter create 명령을 실행하세요. Flutter SDK가 PATH에 들어있는지 확인이 필요합니다.
```
$ flutter create <projectname>
```
## 앱을 실행하는 방법은?
React Native를 사용할 때는, 프로젝트 디렉토리에서 npm run이나 yarn run으로 앱을 실행했을 것이다.  
Flutter apps를 실행하는 몇가지 방법이 있다.
- Flutter와 Dart 플러그인이 설치된 IDE에서 “run”을 실행
- 프로젝트 최상위 디렉토리에서 flutter run을 사용.
앱이 연결된 기기나, iOS 시뮬레이터 혹은 Android 에뮬레이터에서 실행될 것이다.  
더 많은 정보를 원하시면, [Flutter 시작하기](https://flutter-ko.dev/docs/get-started/install)를 참조하세요.
## 위젯을 import 하는 방법은?
React Native에서는 필요한 모든 컴포넌트를 각각 import 해야 한다.
```javascript
//React Native
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
```
Flutter에서는 머티리얼 디자인 라이브러리에서 위젯을 사용하기 위해 material.dart 패키지를 import 한다.  
iOS 스타일 위젯을 사용하기 위해 쿠퍼티노 라이브러리를 import 한다.  
더 많은 기본 위젯을 사용하고 싶다면, 위젯 라이브러리를 import 하거나 직접 위젯 라이브러리를 작성하여 import 할 수도 있다.
```dart
import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter/my_widgets.dart';
```
어떤 위젯 패키지를 import 하건, Dart는 앱에서 사용되는 위젯만 가져온다.  
더 많은 정보를 원하시면, [Flutter 위젯 카탈로그를 참조](https://flutter-ko.dev/docs/development/ui/widgets)
## Flutter에서 React Native “Hello world!” 앱과 동일한 것은?
React Native에서는 HelloWorldApp이 React.Component를 상속 받고 render 메서드가 view 컴포넌트를 반환하도록 구현한다.
```javascript
// React Native
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

export default class App extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text>Hello world!</Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center'
  }
});
```
Flutter에서는, 기본 위젯 라이브러리의 Center와 Text 위젯을 활용하여 “Hello world!” 앱과 동일한 것을 만들 수 있다.  
Center 위젯을 최상위 위젯으로 하고, 자식으로 Text 위젯을 넣으면 된다.
```dart
// Flutter
import 'package:flutter/material.dart';

void main() {
  runApp(
    Center(
      child: Text(
        'Hello, world!',
        textDirection: TextDirection.ltr,
      ),
    ),
  );
}
```
