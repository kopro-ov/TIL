import 'package:flutter/material.dart';

class SecondScreen extends StatelessWidget {
  const SecondScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text('2번째 화면'),
            ElevatedButton(
              onPressed: () {},
              child: const Text("1번째 화면으로 이동"),
            ),
          ],
        ),
      ),
    );
  }
}
