import 'package:flutter/material.dart';
import 'package:flutter_basic_01/screens/second_screen.dart';

class FirstScreen extends StatelessWidget {
  const FirstScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text('1번째 화면'),
            ElevatedButton(
              onPressed: () {
                Navigator.of(context).push(MaterialPageRoute(
                    builder: (BuildContext context) =>
                        SecondScreen(screenData: '값을 넘겨줘봐요')));
              },
              child: const Text("2번째 화면으로 이동"),
            ),
          ],
        ),
      ),
    );
  }
}
