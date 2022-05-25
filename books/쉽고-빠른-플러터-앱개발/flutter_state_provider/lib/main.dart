import 'package:flutter/material.dart';
import 'package:flutter_state_provider/models/cart.dart';
import 'package:flutter_state_provider/repositories/item_list.dart';
import 'package:flutter_state_provider/screens/screen_item.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
        providers: [
          ChangeNotifierProvider(create: (_) => Cart()),
          Provider(create: (_) => ItemList()),
        ],
        builder: (context, child) {
          return MaterialApp(
            title: 'Flutter Provider Example',
            initialRoute: '/',
            routes: {
              '/': (context) => ItemScreen(),
            },
          );
        });
  }
}
