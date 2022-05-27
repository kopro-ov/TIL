part of 'pizza_bloc.dart';

abstract class PizzaState extends Equatable {
  const PizzaState();

  @override
  List<Object> get props => [];
}

class PizzaInitial extends PizzaState {}

class PizzLoaded extends PizzaState {
  final List<Pizza> pizzas;

  const PizzLoaded({required this.pizzas});

  @override
  List<Object> get props => [pizzas];
}
