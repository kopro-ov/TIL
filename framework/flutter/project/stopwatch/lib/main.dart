import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'StopWatch',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: StopWatchPage(),
    );
  }
}

class StopWatchPage extends StatefulWidget {
  const StopWatchPage({Key? key}) : super(key: key);

  @override
  _StopWatchPageState createState() => _StopWatchPageState();
}

class _StopWatchPageState extends State<StopWatchPage> {
  @override
  Widget build(BuildContext context) {
    return Container();
  }
}
