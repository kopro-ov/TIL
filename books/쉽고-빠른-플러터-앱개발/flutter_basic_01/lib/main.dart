import 'package:flutter/material.dart';
import 'package:flutter_basic_01/screens/first_screen.dart';

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
        //primarySwatch: Colors.green,
        appBarTheme: AppBarTheme(
          color: Colors.green,
        ),
        useMaterial3: true,
        colorSchemeSeed: const Color(0xff6750a4),
        //primarySwatch: Colors.green,
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
        body: FirstScreen());
  }
}
