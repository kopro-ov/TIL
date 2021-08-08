import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  var _index = 0; //페이지 인덱스 0, 1, 2

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('복잡한 UI'),
      ),
      body: Center(
        child: Text(
          '$_index 페이지',
          style: TextStyle(fontSize: 40),
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
          onTap: (index) {
            setState(() {
              _index = index; //선택된 탭의 인덱스로 _index를 변경
            });
          },
          currentIndex: _index,
          items: <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              label: '홈',
              icon: Icon(Icons.home),
            ),
            BottomNavigationBarItem(
              label: '이용서비스',
              icon: Icon(Icons.assignment),
            ),
            BottomNavigationBarItem(
              label: '내 정보',
              icon: Icon(Icons.account_circle),
            ),
          ]),
    );
  }
}
