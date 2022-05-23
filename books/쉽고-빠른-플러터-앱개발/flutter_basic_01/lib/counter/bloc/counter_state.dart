part of 'counter_bloc.dart';

@immutable
abstract class CounterState {
  late final int count;
}

class CounterInitial extends CounterState {}
