import 'package:get/get.dart';
import 'dart:async';

import 'package:pomodoro/utils/utils.dart';

//타이머의 상태를 표현하기 위한 자료형
enum TimerStatus { running, paused, stopped, resting }

class TimerController extends GetxController {
  //상태 정의
  static const WORK_SECONDS = 25; // * 60;
  static const REST_SECONDS = 5; //* 60;

  // late TimerStatus _timerStatus;
  // late int _timer;
  // late int _pomodoroCount;

  final _timerStatus = TimerStatus.stopped.obs;
  final _timer = 0.obs;
  final _pomodoroCount = 0.obs;

  get timerStatus => _timerStatus.value;
  get timer => _timer.value;
  get pomodoroCount => _pomodoroCount.value;

  @override
  onInit() {
    super.onInit();
    _timerStatus.value = TimerStatus.stopped;
    _timer.value = WORK_SECONDS;
    _pomodoroCount.value = 0;
  }

  run() {
    _timerStatus.value = TimerStatus.running;
    _timerStatus.refresh;
    runTimer();
  }

  runTimer() async {
    Timer.periodic(Duration(seconds: 1), (Timer t) {
      switch (_timerStatus.value) {
        case TimerStatus.paused:
          t.cancel();
          break;
        case TimerStatus.stopped:
          t.cancel();
          break;
        case TimerStatus.running:
          if (_timer <= 0) {
            showToast("작업 완료!");
            rest();
          } else {
            _timer.value -= 1;
          }
          break;
        case TimerStatus.resting:
          if (_timer <= 0) {
            _pomodoroCount.value += 1;
            showToast("오늘 $_pomodoroCount개의 뽀모도로를 달성했습니다.");
            t.cancel();
            stop();
          } else {
            _timer.value -= 1;
          }
          break;
        default:
          break;
      }
      _timer.refresh();
    });
  }

  rest() {
    _timer.value = REST_SECONDS;
    _timerStatus.value = TimerStatus.resting;
    _timer.refresh();
    _timerStatus.refresh();
  }

  pause() {
    _timerStatus.value = TimerStatus.paused;
    print(TimerStatus.paused);
    _timerStatus.refresh();
  }

  resume() {
    run();
  }

  stop() {
    _timer.value = WORK_SECONDS;
    _timerStatus.value = TimerStatus.stopped;
    _timer.refresh();
    _timerStatus.refresh();
  }
}
