import 'package:bloc/bloc.dart';
import 'package:equatable/equatable.dart';

part 'counter_event.dart';
part 'counter_state.dart';

class CounterBloc extends Bloc<CounterEvent, CounterState> {
  CounterBloc() : super(CounterInitial(0)) {
    on<CounterIncrement>((event, emit) async {
      emit(CounterInitial(state.count + 1));
    });
    on<CounterDecrement>(
      (event, emit) {
        emit(CounterInitial(state.count - 1));
      },
    );
  }
}
