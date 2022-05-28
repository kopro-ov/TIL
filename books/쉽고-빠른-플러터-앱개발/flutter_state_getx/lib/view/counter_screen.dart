import 'package:flutter/material.dart';
import 'package:flutter_state_getx/controller/counter_controller.dart';
import 'package:get/get.dart';

class CounterScreen extends StatelessWidget {
  const CounterScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // Get.put()을 사용하여 클래스를 인스턴스화하여 모든 "child'에서 사용가능하게 합니다.
    final CounterController c = Get.put(CounterController());

    return Scaffold(
        // count가 변경 될 때마다 Obx(()=> 를 사용하여 Text()에 업데이트합니다.
        appBar: AppBar(title: Obx(() => Text("Clicks: ${c.count}"))),

        // 8줄의 Navigator.push를 간단한 Get.to()로 변경합니다. context는 필요없습니다.
        body: Center(
          child: Obx(() => Text('${c.count}')),
        ),
        floatingActionButton: Column(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            FloatingActionButton(
                child: Icon(Icons.add), onPressed: c.increment),
            FloatingActionButton(
                child: Icon(Icons.remove), onPressed: c.decrement),
          ],
        ));
  }
}
