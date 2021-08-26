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
## 위젯을 사용하고 위젯 트리를 형성하는 방법은?
Flutter에서는 거의 모든 것이 위젯이다.  
위젯은 앱 UI의 기본 구성 요소 이다.  
위젯을 위젯 트리라고 불리는 계층 구조로 조합한다.  
각각의 위젯은 부모 위젯 내부에 들어가게 되고, 부모로부터 속성을 상속 받는다. 
앱 객체 자체도 위젯이다. 별도의 “application” 객체는 없고, 최상위 위젯이 그 역할을 담당합니다.  
위젯을 아래와 같이 정의할 수 있다.  
- 버튼이나 메뉴와 같은 구조적 요소
- 글꼴이나 색 구성표와 같은 문체 요소
- 레이아웃과 같은 패딩 또는 정렬의 한 측면
이 예제에서 위젯 트리는 MaterialApp 위젯 내부에 위치하게 됩니다.
```dart
// Flutter
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Welcome to Flutter',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Welcome to Flutter'),
        ),
        body: Center(
          child: Text('Hello world'),
        ),
      ),
    );
  }
}
```
플러터에서 앱을 작성할 때는 2가지 종류(StatelessWidget 또는 StatefulWidget)의 위젯을 사용하게 된다.  
**StatelessWidget**  
StatelessWidget은 위젯이지만 상태가 없는 위젯으로 한 번 만들어지고 절대 변하지 않는다.
**StatefulWidget**  
StatefulWidget은 사용자 입력이나 데이터 수신이 있으면 상태를 동적으로 변경한다.  
상태가 없는 위젯과 상태가 있는 위젯의 중요한 차이점은 StatefulWidgets이 상태 데이터를 저장하고 그것을 트리 재구성을 통해 전달하는 State 객체가 있어서 데이터가 손실 되지 않는다는 점이다.  
간단하거나 기본적인 앱에서 위젯을 감싸는 것은 쉽지만, 코드 베이스가 점차 커지고 앱이 복잡해지면, 너무 많이 감싸져 있는 위젯을 함수로 빼거나 작은 클래스로 분리해야 한다. 분리된 함수를 만들면 위젯을 앱 내에서 재사용할 수 있게 된다.
## 재사용 가능한 컴포넌트를 만드는 방법은?
`React Native`에서는 재사용 가능한 컴포넌트를 만들기 위해 클래스를 정의한 다음 props 메서드를 사용하여 선택한 요소의 속성과 값을 설정하거나 반환다. 아래 예제에서 CustomCard 클래스를 정의하고, 부모 클래스 안에서 사용한다.
```javascript
// React Native
class CustomCard extends React.Component {
  render() {
    return (
      <View>
        <Text> Card {this.props.index} </Text>
        <Button
          title="Press"
          onPress={() => this.props.onPress(this.props.index)}
        />
      </View>
    );
  }
}

// Usage
<CustomCard onPress={this.onPress} index={item.key} />
```
Flutter에서는 커스텀 위젯을 만들기 위해 클래스를 정의하면 그 위젯을 재사용할 수 있다.  
또는 아래 예제와 같은 build 함수에서 재사용 가능한 위젯을 정의하고 호출할 수 있다.
```dart
// Flutter
class CustomCard extends StatelessWidget {
  CustomCard({@required this.index, @required 
     this.onPress});

  final index;
  final Function onPress;

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Column(
        children: <Widget>[
          Text('Card $index'),
          FlatButton(
            child: const Text('Press'),
            onPressed: this.onPress,
          ),
        ],
      )
    );
  }
}
    ...
// Usage
CustomCard(
  index: index,
  onPress: () { 
    print('Card $index');
  },
)
    ...
```
이전 예제에서는 CustomCard 클래스의 생성자가 [optional parameters](https://dart.dev/guides/language/language-tour#optional-parameters)를 표현하기 위해 Dart의 중괄호 구문 { }을 사용했다.  
이 필드를 필수로 만들고 싶다면, 생성자에서 중괄호를 지우거나 @required를 추가하면 된다.
# 프로젝트 구조 및 리소스
## 어디서부터 코드 작성을 시작해야 하나요?
main.dart 파일에서 시작한다. Flutter 앱을 만들면 `main.dart`가 자동 생성된다. 
```dart
// Dart
void main(){
 print('Hello, this is the main function.');
}
```
Flutter에서 진입점은 `’projectname’/lib/main.dart` 파일이고, `main 함수`부터 실행을 시작한다.
## Flutter 앱에서 파일은 어떻게 구성되어 있습니까?
Flutter 프로젝트를 새롭게 만들면, 아래와 같은 디렉토리 구조가 생성됩니다. 나중에 구조를 변경할 수는 있지만, 일단은 아래와 같은 상태에서 시작한다.
```
┬
└ projectname
  ┬
  ├ android      - Android 관련 파일 포함.
  ├ build        - iOS 및 Android 빌드 파일 저장.
  ├ ios          - iOS 관련 파일 포함.
  ├ lib          - 외부에서 접근할 수 있는 Dart 소스 파일 포함.
    ┬
    └ src        - 추가적인 소스 파일 포함.
    └ main.dart  - Flutter 진입점이며 새로운 앱의 시작.
                   Flutter 프로젝트를 만들 때 자동으로 생성.
                   Dart코드 작성을 시작하는 부분임.
  ├ test         - 자동화 테스트 파일 포함.
  └ pubspec.yaml - Flutter 앱의 메타데이터 포함.
                   React Native의 package.json 파일과 동일함.
```
## 리소스와 asset은 어디에 위치 시키고, 어떻게 사용하나요?
Flutter 리소스 또는 asset은 앱과 함께 묶여서 배포되며 런타임에 접근할 수 있는 파일한다.  
Flutter 앱은 아래와 같은 asset 유형을 포함할 수 있다
- JSON 파일 같은 정적 데이터
- 설정 파일
- 아이콘과 이미지 (JPEG, PNG, GIF, Animated GIF, WebP, Animated WebP, BMP, and WBMP)
Flutter는 프로젝트 최상위에 위치한 pubspec.yaml 파일을 사용하여 앱에 필요한 assets을 식별한다.
```
flutter:
  assets:
    - assets/my_icon.png
    - assets/background.png
```
assets 부분은 앱에 포함시켜야하는 파일을 지정한다. 각 asset은 pubspec.yaml에 명시된 상대 경로에 의해서 asset 파일이 어디에 있는지 구분된다.  
빌드 중, Flutter는 런타임 때에 앱이 읽어올 asset bundle이라 불리는 특수한 아카이브에 asset을 저장한다.  
pubspec.yaml에 asset의 경로가 지정되면, 빌드 프로세스는 인접한 디렉토리에서 같은 이름의 파일을 찾는다.  
이 파일들은 지정된 asset과 함께 asset bundle에도 포함된다.  
Flutter는 앱에 적합한 해상도의 이미지를 선택할 때 asset variants를 사용한다.  
React Native에서는 이미지 파일을 소스 코드 디렉토리에 놓은 뒤 경로를 지정하여 정적 이미지를 추가할 수 있다.
```
<Image source={require('./my-icon.png')} />
```
## 네트워크를 통해 이미지를 가져오는 방법은?
React Native에서는 Image 컴포넌트의 source 속성에서 uri을 지정하고, 필요하다면 크기도 지정한다.  
Flutter에서는 Image.network 생성자를 사용하여 해당 URL에서 이미지를 가져온다.
```
// Flutter
body: Image.network(
          'https://flutter-io.kr/images/owl.jpg',
```
## 패키지와 패키지 플러그인을 설치하는 방법은?
Flutter에서 Flutter와 Dart 생태계의 다른 개발자들이 만든 공유 패키지를 사용할 수 있다.  
이를 통해 일일이 모든 것을 개발할 필요없이 빠르게 앱을 개발할 수 있다. 패키지 플러그인은 플랫폼별 코드가 포함된 패키지이다.  
React Native에서는 커멘드라인 yarn add {package-name}나 npm install --save {package-name} 명령을 사용해서 패키지를 설치한다.  
Flutter에서는 아래와 같은 방법으로 패키지를 설치한다.  
pubspec.yaml의 dependencies 부분에 패키지 이름과 버전을 추가한다.  
아래 예제는 pubspec.yaml 파일에 google_sign_in Dart 패키지를 추가하는 방법을 보여준다.  
공백이 문제가 될 수 있기 때문에 **YAML file의 공백을 잘 확인***해야한다!
```
dependencies:
  flutter:
    sdk: flutter
  google_sign_in: ^3.0.3
```
1. 커멘드라인에서 `flutter pub get`을 사용해서 패키지를 설치하세요. IDE를 이용하고 있으면, IDE가 종종 flutter pub get을 실행해주거나, 실행하도록 유도할 것입니다.
2. 아래 코드와 같은 패키지를 import 하세요:
```
import 'package:flutter/cupertino.dart';
```
더 많은 정보를 원하시면, [패키지 사용하기](https://flutter-ko.dev/docs/development/packages-and-plugins/using-packages)와 [패키지 & 플러그인 개발](https://flutter-ko.dev/docs/development/packages-and-plugins/developing-packages)를 참조  
[Pub site][]의 [Flutter Packages](https://pub.dev/flutter/packages) 섹션에서 Flutter 개발자들이 공유한 많은 패키지를 만날 수 있다.
# Flutter 위젯
Flutter에서는 UI를 만들 때 현재 상태와 설정에 따라 어떻게 보일지에 대한 정보를 담고 있는 위젯을 사용한다.  
위젯은 종종 강력한 효과를 내기 위해 다수의 중첩된 작은 단일 목적의 위젯으로 구성된다.  
예를 들어, Container 위젯은 레이아웃, 그리기, 위치, 크기를 담당하는 여러 위젯으로 구성된다.  
Container 위젯은 LimitedBox와 ConstrainedBox,  Align, Padding, DecoratedBox, Transform 위젯을 포함하고 있다.   원하는 효과를 내기 위해 Container 를 서브클래스로 만드는 대신, 여러 심플한 위젯들을 새롭고 독특한 방식으로 구성할 수 있다.  
Center 위젯은 레이아웃을 어떻게 조절할 수 있는지를 보여주는 또 다른 예이다.  
위젯을 가운데 정렬 하기 위해, Center 위젯으로 감싼 다음 정렬, 행, 그리드를 배치하는 위젯을 사용한다.  
배치 위젯은 시각적으로 자기 자신을 나타내지는 않지만. 대신, 다른 위젯 레이아웃을 제어하는 것이다.  
왜 위젯이 이런 방식으로 그려지는지 이해하기 위해, 인접한 위젯을 조사하는 것이 종종 도움이 된다.  
위젯 패키지의 핵심 위젯에 대한 자세한 정보는, [Flutter 기본 위젯](https://flutter-ko.dev/docs/development/ui/widgets/basics), [Flutter 위젯 카탈로그](https://flutter-ko.dev/docs/development/ui/widgets), [Flutter 위젯](https://flutter-ko.dev/docs/reference/widgets) 색인을 참조하세요.  
[Flutter 기술 개요](https://flutter-ko.dev/docs/resources/technical-overview)
# Views
## View 컨테이너와 동일한 것은?
React Native에서는 `View`가 컨테이너이고, `Flexbox`를 이용한 레이아웃, 스타일, 터치 핸들링, 접근성 제어를 지원한다.  
Flutter에서는 [Container](https://api.flutter.dev/flutter/widgets/Container-class.html)나 [Column](https://api.flutter.dev/flutter/widgets/Column-class.html), [Row](https://api.flutter.dev/flutter/widgets/Row-class.html), [Center](https://api.flutter.dev/flutter/widgets/Center-class.html) 같은 위젯 라이브러리의 핵심 레이아웃 위젯을 사용할 수 있다.  
더 많은 정보를 원하시면, [레이아웃 위젯 카탈로그](https://flutter-ko.dev/docs/development/ui/widgets/layout)를 참조
## FlatList나 SectionList와 동일한 것은?
`List`는 수직으로 배열된 구성 요소의 스크롤 가능한 목록이다.  
React Native에서는 `FlatList` 혹은 `SectionList`를 사용하여 단순 목록 혹은 섹션 목록을 그린다.
```javascript
// React Native
<FlatList
  data={[ ... ]}
  renderItem={({ item }) => <Text>{item.key}</Text>}
/>
```
Flutter에서는 ListView는 가장 많이 사용되는 스크롤 위젯이다.  
ListView는 기본 생성자를 통해 명시적으로 자식 목록을 받는다.  
ListView는 목록의 수가 적은 경우에 가장 적합하다.  
무거운 목록이거나 무한 스크롤 목록일 때는, ListView.builder를 사용한다.  
자식들을 필요할 때만 빌드하고, 자식들이 화면에 나타내야 할 자식들만 빌드합니다.
```dart
// Flutter
var data = [ ... ];
ListView.builder(
  itemCount: data.length,
  itemBuilder: (context, int index) {
    return Text(
      data[index],
    );
  },
)
```
무한 스크롤을 만드는 방법을 배우고 싶다면, [첫 Flutter 앱 만들기, part 1 코드랩](https://codelabs.developers.google.com/codelabs/first-flutter-app-pt1)을 참조
## Canvas를 사용하여 그리거나 색을 입히는 방법은?
React Native에서는 캔버스 컴포넌트가 없기 때문에, react-native-canvas 같은 서드 파티 라이브러리를 사용한다.
```javascript
// React Native
handleCanvas = canvas => {
  const ctx = canvas.getContext('2d');
  ctx.fillStyle = 'skyblue';
  ctx.beginPath();
  ctx.arc(75, 75, 50, 0, 2 * Math.PI);
  ctx.fillRect(150, 100, 300, 300);
  ctx.stroke();
};

render() {
  return (
    <View>
      <Canvas ref={this.handleCanvas} />
    </View>
  );
}
```
Flutter에서는 [CustomPaint](https://api.flutter.dev/flutter/widgets/CustomPaint-class.html)와 [CustomPainter](https://api.flutter.dev/flutter/rendering/CustomPainter-class.html) 클래스를 사용하여 캔버스에 그릴 수 있다.  
아래 예시는 CustomPaint 위젯을 사용해서 페인트 단계에서 그리는 방법을 보여준다.  
추상 클래스인 CustomPainter를 구현하고, 이를 CustomPaint의 painter 속성에 전달한다. `CustomPaint 서브 클래스`는 `paint`와 `shouldRepaint`를 꼭 구현해야 한다.
```dart
// Flutter
class MyCanvasPainter extends CustomPainter {

  @override
  void paint(Canvas canvas, Size size) {
    Paint paint = Paint();
    paint.color = Colors.amber;
    canvas.drawCircle(Offset(100.0, 200.0), 40.0, paint);
    Paint paintRect = Paint();
    paintRect.color = Colors.lightBlue;
    Rect rect = Rect.fromPoints(Offset(150.0, 300.0), Offset(300.0, 400.0));
    canvas.drawRect(rect, paintRect);
  }

  bool shouldRepaint(MyCanvasPainter oldDelegate) => false;
  bool shouldRebuildSemantics(MyCanvasPainter oldDelegate) => false;
}
class _MyCanvasState extends State<MyCanvas> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: CustomPaint(
        painter: MyCanvasPainter(),
      ),
    );
  }
}
```