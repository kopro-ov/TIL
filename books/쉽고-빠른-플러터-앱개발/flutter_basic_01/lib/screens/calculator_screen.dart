import 'package:flutter/material.dart';

class CalculatorScreen extends StatefulWidget {
  const CalculatorScreen({Key? key}) : super(key: key);

  @override
  State<CalculatorScreen> createState() => _CalculatorScreenState();
}

class _CalculatorScreenState extends State<CalculatorScreen> {
  late String _output;
  int _num1 = 0;
  int _num2 = 0;

  @override
  void initState() {
    super.initState();
    _output = "0";
  }

  void addNumbers(int n) {
    setState(() {
      if (_num1 == 0) {
        _num2 = n;
      } else {
        _num2 = int.parse('$_num2$n');
      }
      _output = _num2.toString();
    });
  }

  void operand(String o) {
    switch (o) {
      case 'AC':
        setState(() {
          _num1 = 0;
          _num2 = 0;
          _output = "0";
        });
        break;
      case "+/-":
        setState(() {
          _num2 = -_num2;
          _output = _num2.toString();
        });
        break;
      case "-":
        setState(() {
          _num1 -= _num2;
          _num2 = 0;
          _output = _num1.toString();
        });
        break;
      case "+":
        setState(() {
          _num1 += _num2;
          _num2 = 0;
          _output = _num1.toString();
        });
        break;
      case "*":
        setState(() {
          if (_num1 == 0) _num1 = 1;
          _num1 *= _num2;
          _num2 = 0;
          _output = _num1.toString();
        });
        break;
      case "÷":
        setState(() {
          //_num1 /= _num2;
          _num2 = 0;
          _output = _num1.toString();
        });
        break;
      case "-/+":
        setState(() {
          _num2 = -_num2;
          _output = _num2.toString();
        });
        break;
      default:
        break;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Container(
          width: MediaQuery.of(context).size.width,
          padding: EdgeInsets.all(20.0),
          child: Text(
            '$_output',
            textAlign: TextAlign.right,
            style: TextStyle(fontSize: 25),
          ),
        ),
        Row(
          children: [
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    operand('AC');
                  },
                  child: Text('AC')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    operand('+/-');
                  },
                  child: Text('+/-')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    operand('%');
                  },
                  child: Text('%')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    operand('÷');
                  },
                  child: Text('÷')),
            ),
          ],
        ),
        Row(
          children: [
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    setState(() {
                      addNumbers(7);
                    });
                  },
                  child: Text('7')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    addNumbers(8);
                  },
                  child: Text('8')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    addNumbers(9);
                  },
                  child: Text('9')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    operand("*");
                  },
                  child: Text('*')),
            ),
          ],
        ),
        Row(
          children: [
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    addNumbers(4);
                  },
                  child: Text('4')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    addNumbers(5);
                  },
                  child: Text('5')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    addNumbers(6);
                  },
                  child: Text('6')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    operand("-");
                  },
                  child: Text('-')),
            ),
          ],
        ),
        Row(
          children: [
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    addNumbers(1);
                  },
                  child: Text('1')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    addNumbers(2);
                  },
                  child: Text('2')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    addNumbers(3);
                  },
                  child: Text('3')),
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
              child: ElevatedButton(
                  onPressed: () {
                    operand(".");
                  },
                  child: Text('.')),
            ),
            Expanded(
              child: ElevatedButton(
                  onPressed: () {
                    operand("=");
                  },
                  child: Text('=')),
            ),
          ],
        )
      ],
    );
  }
}
