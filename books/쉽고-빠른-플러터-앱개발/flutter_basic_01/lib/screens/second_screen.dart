import 'package:flutter/material.dart';

class SecondScreen extends StatelessWidget {
  final String screenData;
  const SecondScreen({Key? key, required this.screenData}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('ScreenData : $screenData'),
            ElevatedButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: const Text("1번째 화면으로 이동"),
            ),
          ],
        ),
      ),
    );
  }
}
