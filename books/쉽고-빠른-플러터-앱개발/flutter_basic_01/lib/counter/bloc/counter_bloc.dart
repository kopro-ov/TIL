import 'dart:async';

import 'package:bloc/bloc.dart';
import 'package:meta/meta.dart';

part 'counter_event.dart';
part 'counter_state.dart';

class CounterBloc extends Bloc<CounterEvent, CounterState> {
  static const int _count = 0;

  CounterBloc() : super(const CounterInitial(_count)) {
    on<CounterEvent>(mapEventToState);
  }

  Future<void> mapEventToState(
      CounterEvent event, Emitter<CounterState> emit) async {
    if (event is CounterIncrement) {
      state.count + 1;
    } else if (event is CounterDecrement) {
      state.count - 1;
    }
  }
}
