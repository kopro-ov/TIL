import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.green,
      ),
      home: MyHomePage(title: 'Flutter'),
    );
  }
}

class MyHomePage extends StatelessWidget {
  final String title;
  MyHomePage({Key? key, required this.title}) : super(key: key);
  List<Widget> list = [];

  @override
  Widget build(BuildContext context) {
    for (var i = 0; i < 50; i++) {
      list.add(
        Text(
          'Hello ' + (i + 1).toString(),
          style: TextStyle(fontSize: 25),
        ),
      );
    }
    return Scaffold(
      appBar: AppBar(
        title: Text(
          title,
        ),
      ),
      body: Center(
        child: Stack(
          children: [
            Image.asset(
              'images/logo.png',
              width: 500,
              height: 500,
            ),
            Positioned(
              left: 0,
              bottom: 0,
              child: Image.network(
                'https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAyMjhfMTIx%2FMDAxNjQ2MDQ5Nzc0MzYx.5-e6Mv-NIxtatcBoAtVGuR-_RwoksYiN2jXEMxTlA1og.fyUs_n_nw7aFu97y2wgcbhYt7PF_KVp8cG8Hw30F0CEg.JPEG.ksy9823%2F%25C1%25D2%25B8%25A3%25B5%25F0-2.jpg&type=a340',
                width: 200,
                height: 200,
              ),
            )
          ],
        ),
      ),
    );
  }
}
