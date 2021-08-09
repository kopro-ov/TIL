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
  var _pages = [
    Page1(),
    Page2(),
    Page3(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('복잡한 UI'),
        actions: <Widget>[
          IconButton(
            icon: Icon(
              Icons.add,
              color: Colors.black, //앱의 전체 테마를 수정했다면 작성하지 않아도댐.
            ),
            onPressed: () {},
          ),
        ],
      ),
      body: _pages[_index],
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

class Page1 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        _buildTop(),
        _buildMiddle(),
        _buildBottom(),
      ],
    );
  }

  //상단
  Widget _buildTop() {
    return Column(
      children: <Widget>[
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Column(
              children: <Widget>[
                Icon(
                  Icons.local_taxi,
                  size: 40,
                ),
                Text('택시'),
              ],
            ),
            Column(
              children: <Widget>[
                Icon(
                  Icons.local_taxi,
                  size: 40,
                ),
                Text('택시'),
              ],
            ),
            Column(
              children: <Widget>[
                Icon(
                  Icons.local_taxi,
                  size: 40,
                ),
                Text('택시'),
              ],
            ),
            Column(
              children: <Widget>[
                Icon(
                  Icons.local_taxi,
                  size: 40,
                ),
                Text('택시'),
              ],
            ),
          ],
        ),
        SizedBox(
          height: 20,
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Column(
              children: <Widget>[
                Icon(
                  Icons.local_taxi,
                  size: 40,
                ),
                Text('택시'),
              ],
            ),
            Column(
              children: <Widget>[
                Icon(
                  Icons.local_taxi,
                  size: 40,
                ),
                Text('택시'),
              ],
            ),
            Column(
              children: <Widget>[
                Icon(
                  Icons.local_taxi,
                  size: 40,
                ),
                Text('택시'),
              ],
            ),
            Opacity(
              opacity: 0.0,
              child: Column(
                children: <Widget>[
                  Icon(
                    Icons.local_taxi,
                    size: 40,
                  ),
                  Text('택시'),
                ],
              ),
            ),
          ],
        ),
      ],
    );
  }

  //중단
  Widget _buildMiddle() {
    return Text('Middle');
  }

  //중단
  Widget _buildBottom() {
    return Text('Bottom');
  }
}

class Page2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text(
        '이용서비스',
        style: TextStyle(fontSize: 40),
      ),
    );
  }
}

class Page3 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text(
        '내 정보',
        style: TextStyle(fontSize: 40),
      ),
    );
  }
}
