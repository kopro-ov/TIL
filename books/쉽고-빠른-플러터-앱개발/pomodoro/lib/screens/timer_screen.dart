import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:pomodoro/controller/timer_controller.dart';
import 'package:pomodoro/widgets/timer_buttons.dart';

import '../utils/utils.dart';

class TimerScreen extends StatelessWidget {
  const TimerScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final TimerController c = Get.put(TimerController());

    return Scaffold(
      appBar: AppBar(
        title: const Text('뽀모도로 타이머'),
      ),
      body: Obx(
        () => Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              height: MediaQuery.of(context).size.height * 0.5,
              width: MediaQuery.of(context).size.width * 0.6,
              decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  color: c.timerStatus == TimerStatus.resting
                      ? Colors.green
                      : Theme.of(context).colorScheme.primary),
              child: Center(
                child: Text(
                  secondsToString(c.timer),
                  style: const TextStyle(
                    color: Colors.white,
                    fontSize: 48,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ),
            ),
            const TimerButtons(),
          ],
        ),
      ),
    );
  }
}
