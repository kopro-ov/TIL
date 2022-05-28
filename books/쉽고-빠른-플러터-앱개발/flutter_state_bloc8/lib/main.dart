import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_state_bloc8/blocs/counter/bloc/counter_bloc.dart';
import 'package:flutter_state_bloc8/blocs/pizza/bloc/pizza_bloc.dart';
import 'package:flutter_state_bloc8/models/pizza_model.dart';
import 'package:flutter_state_bloc8/screens/counter_screen.dart';
import 'package:flutter_state_bloc8/screens/pizza_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiBlocProvider(
        providers: [
          BlocProvider(
              create: (context) => PizzaBloc()..add(LoadPizzaCounter())),
          BlocProvider(create: (context) => CounterBloc())
        ],
        child: MaterialApp(
          title: 'The Pizza Bloc',
          routes: {
            '/pizza': (context) => PizzaScreen(),
            '/couter': (context) => CounterScreen(),
            '/': (context) => HomeScreen()
          },
          initialRoute: '/',
        ));
  }
}

class HomeScreen extends StatelessWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Column(
      children: [
        TextButton(
            onPressed: () {
              Navigator.pushNamed(context, '/pizza');
            },
            child: Text('피자')),
        TextButton(
            onPressed: () {
              Navigator.pushNamed(context, '/couter');
            },
            child: Text('카운터'))
      ],
    ));
  }
}
