import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:pomodoro/controller/timer_controller.dart';

class TimerButtons extends StatelessWidget {
  const TimerButtons({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final TimerController c = Get.put(TimerController());

    final List<Widget> _runningButtons = [
      Obx(
        () => ElevatedButton(
          onPressed: c.timerStatus == TimerStatus.paused ? c.resume : c.pause,
          child: Text(
            c.timerStatus == TimerStatus.paused ? '계속하기' : '일시정지',
            style: TextStyle(fontSize: 16),
          ),
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
        onPressed: c.stop,
        child: const Text('포기하기'),
      ),
    ];

    final List<Widget> _stoppedButtons = [
      ElevatedButton(
        style: ElevatedButton.styleFrom(
          primary: c.timerStatus == TimerStatus.resting
              ? Theme.of(context).colorScheme.primary
              : Theme.of(context).colorScheme.onPrimary,
        ),
        onPressed: c.run,
        child: const Text('시작하기'),
      ),
    ];

    return Obx(
      () => Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: c.timerStatus == TimerStatus.resting
            ? const []
            : c.timerStatus == TimerStatus.stopped
                ? _stoppedButtons
                : _runningButtons,
      ),
    );
    ;
  }
}
