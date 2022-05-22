import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';

class CalculatorScreen extends StatefulWidget {
  const CalculatorScreen({Key? key}) : super(key: key);

  @override
  State<CalculatorScreen> createState() => _CalculatorScreenState();
}

class _CalculatorScreenState extends State<CalculatorScreen> {
  late int result;
  late int num;
  @override
  void initState() {
    super.initState();
    result = 0;
    num = 0;
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Container(
          width: MediaQuery.of(context).size.width,
          padding: EdgeInsets.all(20.0),
          child: Text(
            '$result',
            textAlign: TextAlign.right,
            style: TextStyle(fontSize: 25),
          ),
        ),
        Row(
          children: [
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('AC')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('+/-')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('%')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('÷')),
            ),
          ],
        ),
        Row(
          children: [
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('7')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('8')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('9')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('X')),
            ),
          ],
        ),
        Row(
          children: [
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('4')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('5')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('6')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('-')),
            ),
          ],
        ),
        Row(
          children: [
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('1')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('2')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('3')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('4')),
            ),
          ],
        ),
        Row(
          children: [
            Expanded(
              flex: 2,
              child: ElevatedButton(onPressed: () {}, child: Text('0')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('.')),
            ),
            Expanded(
              child: ElevatedButton(onPressed: () {}, child: Text('=')),
            ),
          ],
        )
      ],
    );
  }
}
