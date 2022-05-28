part of 'counter_bloc.dart';

abstract class CounterState extends Equatable {
  final int count;

  const CounterState(this.count);

  @override
  List<Object> get props => [count];
}

class CounterInitial extends CounterState {
  const CounterInitial(int count) : super(count);

  @override
  String toString() => 'CounterInitial { count: $count }';
}
