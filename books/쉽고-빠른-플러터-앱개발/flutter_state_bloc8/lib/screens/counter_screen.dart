import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_state_bloc8/blocs/counter/bloc/counter_bloc.dart';

class CounterScreen extends StatelessWidget {
  const CounterScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    //final count = context.select((CounterBloc bloc) => bloc.state.count);
    return Scaffold(
      body: Center(
        child: BlocBuilder<CounterBloc, CounterState>(
          builder: (context, state) {
            return Text(state.count.toString());
          },
        ),
      ),
      floatingActionButton: Column(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          FloatingActionButton(
            child: Icon(Icons.add),
            backgroundColor: Colors.orange[800],
            onPressed: () {
              context.read<CounterBloc>().add(CounterIncrement());
            },
          ),
          const SizedBox(
            height: 10,
          ),
          FloatingActionButton(
            child: Icon(Icons.remove),
            backgroundColor: Colors.orange[800],
            onPressed: () {
              context.read<CounterBloc>().add(CounterDecrement());
            },
          ),
        ],
      ),
    );
  }
}
