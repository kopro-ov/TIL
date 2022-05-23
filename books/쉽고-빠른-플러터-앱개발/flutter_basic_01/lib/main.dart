import 'package:flutter/material.dart';
import 'package:flutter_basic_01/counter/bloc/counter_bloc.dart';
import 'package:flutter_basic_01/screens/calculator_screen.dart';
import 'package:flutter_basic_01/screens/first_screen.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

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
      appBar: AppBar(title: Text('계산기')),
      body: BlocBuilder<CounterBloc, CounterState>(
        buildWhen: (previous, current) => previous.count != current.count,
        builder: (context, state) {
          return Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('Counter : ' + state.count.toString()),
                TextButton(
                  onPressed: () {
                    Navigator.of(context).pushNamed('/counter');
                  },
                  child: Text('Go to CounterScreen'),
                )
              ],
            ),
          );
        },
      ),
    );
  }
}
