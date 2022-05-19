import 'package:flutter/material.dart';

//타이머의 상태를 표현하기 위한 자료형
enum TimerStatus { running, paused, stopped, resting }

class TimerScreen extends StatefulWidget {
  const TimerScreen({Key? key}) : super(key: key);

  @override
  State<TimerScreen> createState() => _TimerScreenState();
}

class _TimerScreenState extends State<TimerScreen> {
  @override
  Widget build(BuildContext context) {
    final List<Widget> _runningButtons = [
      ElevatedButton(
        onPressed: () {},
        child: Text(
          1 == 2 ? '계속하기' : '일시정지',
          style: TextStyle(fontSize: 16),
        ),
      ),
      Padding(
        padding: EdgeInsets.all(20),
      ),
      ElevatedButton(
        style: ElevatedButton.styleFrom(
          // Foreground color
          onPrimary: Theme.of(context).colorScheme.onPrimary,
          // Background color
          primary: Theme.of(context).colorScheme.primary,
        ),
        onPressed: () {},
        child: const Text('포기하기'),
      ),
    ];
    final List<Widget> _stoppedButtons = [
      ElevatedButton(
        style: ElevatedButton.styleFrom(
          primary: 1 == 2
              ? Theme.of(context).colorScheme.primary
              : Theme.of(context).colorScheme.onPrimary,
        ),
        onPressed: () {},
        child: const Text('시작하기'),
      ),
    ];

    return Scaffold(
      appBar: AppBar(
        title: Text('뽀모도로 타이머'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Container(
            height: MediaQuery.of(context).size.height * 0.5,
            width: MediaQuery.of(context).size.width * 0.6,
            child: Center(
              child: Text(
                '00:00',
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 48,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
            decoration: BoxDecoration(
                shape: BoxShape.circle,
                color: 1 == 2
                    ? Colors.green
                    : Theme.of(context).colorScheme.primary),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: 1 == 2
                ? const []
                : 1 == 2
                    ? _stoppedButtons
                    : _runningButtons,
          )
        ],
      ),
    );
  }
}
