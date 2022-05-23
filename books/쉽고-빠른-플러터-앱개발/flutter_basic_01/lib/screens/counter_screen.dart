import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_basic_01/counter/bloc/counter_bloc.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class CounterScreen extends StatelessWidget {
  const CounterScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: BlocBuilder<CounterBloc, CounterState>(
        builder: (context, state) {
          return Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('Counter : ' + state.count.toString()),
                TextButton(
                  onPressed: () {
                    BlocProvider.of<CounterBloc>(context)
                        .add(CounterIncrement());
                  },
                  child: Text('[+] Increment'),
                ),
                TextButton(
                  onPressed: () {
                    BlocProvider.of<CounterBloc>(context)
                        .add(CounterDecrement());
                  },
                  child: Text('[-] Decrement'),
                ),
              ],
            ),
          );
        },
      ),
    );
  }
}
