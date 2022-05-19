import 'dart:async';

import 'package:flutter/material.dart';
import 'package:sprintf/sprintf.dart';

//타이머의 상태를 표현하기 위한 자료형
enum TimerStatus { running, paused, stopped, resting }

class TimerScreen extends StatefulWidget {
  const TimerScreen({Key? key}) : super(key: key);

  @override
  State<TimerScreen> createState() => _TimerScreenState();
}

class _TimerScreenState extends State<TimerScreen> {
  //상태 정의
  static const WORK_SECONDS = 25; //*60
  static const REST_SECONDS = 5; //* 60

  late TimerStatus _timerStatus;
  late int _timer;
  late int _pomodoroCount;

  @override
  void initState() {
    super.initState();
    _timerStatus = TimerStatus.stopped;
    _timer = WORK_SECONDS;
    _pomodoroCount = 0;
  }

  String secondsToSTring(int seconds) {
    // A ~/ B는 다트에서 A를 B로 나눈 몫을 계산하는 연산자
    return sprintf("%02d:%02d", [seconds ~/ 60, seconds % 60]);
  }

  void run() {
    setState(() {
      _timerStatus = TimerStatus.running;
      runTimer();
    });
  }

  void runTimer() {
    Timer.periodic(Duration(seconds: 1), (timer) {
      switch (_timerStatus) {
        case TimerStatus.paused:
          timer.cancel();
          break;
        case TimerStatus.stopped:
          timer.cancel();
          break;
        case TimerStatus.running:
          if (_timer <= 0) {
            rest();
          } else {
            setState(() {
              _timer = -1;
            });
          }
          break;
        case TimerStatus.resting:
          if (_timer <= 0) {
            setState(() {
              _pomodoroCount += 1;
            });
            timer.cancel();
            stop();
          }
          break;
        default:
          break;
      }
    });
  }

  void rest() {
    setState(() {
      _timer = REST_SECONDS;
      _timerStatus = TimerStatus.resting;
    });
  }

  void pause() {
    setState(() {
      _timerStatus = TimerStatus.paused;
    });
  }

  void resume() {
    run();
  }

  void stop() {
    setState(() {
      _timer = WORK_SECONDS;
      _timerStatus = TimerStatus.stopped;
    });
  }

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
