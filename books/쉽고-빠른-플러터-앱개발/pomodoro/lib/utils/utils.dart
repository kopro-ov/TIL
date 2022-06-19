import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:sprintf/sprintf.dart';

String secondsToString(int seconds) {
  // A ~/ B는 다트에서 A를 B로 나눈 몫을 계산하는 연산자
  return sprintf("%02d:%02d", [seconds ~/ 60, seconds % 60]);
}

void showToast(String message) {
  Fluttertoast.showToast(
    msg: message,
    toastLength: Toast.LENGTH_LONG,
    gravity: ToastGravity.BOTTOM,
    timeInSecForIosWeb: 5,
    //backgroundColor: Theme.of(context).colorScheme.primary,
    textColor: Colors.white,
    fontSize: 16.0,
  );
}
