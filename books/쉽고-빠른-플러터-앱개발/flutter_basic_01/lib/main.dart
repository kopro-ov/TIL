import 'package:flutter/material.dart';
import 'package:flutter_basic_01/screens/calculator_screen.dart';
import 'package:flutter_basic_01/screens/first_screen.dart';

import 'screens/counter_screen.dart';

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
        appBarTheme: AppBarTheme(
          color: Colors.green,
        ),
        useMaterial3: true,
        colorSchemeSeed: const Color(0xff6750a4),
        //primarySwatch: Colors.green,
      ),
      routes: {
        '/': (context) => MyHomePage(title: 'Flutter'),
        '/calculatorScreen': (context) => CalculatorScreen(),
        '/counter': (context) => CounterScreen(),
      },
      initialRoute: '/',
    );
  }
}

class MyHomePage extends StatelessWidget {
  final String title;
  MyHomePage({Key? key, required this.title}) : super(key: key);
  List<Widget> list = [];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text('계산기')), body: CalculatorScreen());
  }
}
