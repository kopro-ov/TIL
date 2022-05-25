part of 'counter_bloc.dart';

@immutable
abstract class CounterState {
  final int count;
  const CounterState(this.count);
}

class CounterInitial extends CounterState {
  const CounterInitial(int count) : super(count);

  @override
  String toString() => 'CounterInitial { count: $count }';
}
