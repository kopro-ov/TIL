import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_state_bloc8/blocs/pizza/bloc/pizza_bloc.dart';
import 'package:flutter_state_bloc8/models/pizza_model.dart';

class PizzaScreen extends StatelessWidget {
  const PizzaScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: BlocBuilder<PizzaBloc, PizzaState>(
          builder: (context, state) {
            if (state is PizzaInitial) {
              return const CircularProgressIndicator(
                color: Colors.orange,
              );
            }
            if (state is PizzaLoaded) {
              return Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text('${state.pizzas.length}'),
                  const SizedBox(
                    height: 20,
                  ),
                  SizedBox(
                    height: MediaQuery.of(context).size.height / 1.5,
                    width: MediaQuery.of(context).size.width,
                    child: Stack(
                      alignment: Alignment.center,
                      clipBehavior: Clip.none,
                      children: [
                        for (int index = 0;
                            index < state.pizzas.length;
                            index++)
                          Positioned(
                            child: SizedBox(
                              width: 150,
                              height: 150,
                              child: Text(state.pizzas[index].name),
                            ),
                          )
                      ],
                    ),
                  )
                ],
              );
            } else {
              return const Text('Something went wrong!');
            }
          },
        ),
      ),
      floatingActionButton: Column(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          FloatingActionButton(
            child: Icon(Icons.local_pizza_outlined),
            backgroundColor: Colors.orange[800],
            onPressed: () {
              context.read<PizzaBloc>().add(AddPizza(Pizza.pizzas[0]));
            },
          ),
          const SizedBox(
            height: 10,
          ),
          FloatingActionButton(
            child: Icon(Icons.remove),
            backgroundColor: Colors.orange[800],
            onPressed: () {
              context.read<PizzaBloc>().add(RemovePizza(Pizza.pizzas[0]));
            },
          ),
          const SizedBox(
            height: 10,
          ),
          FloatingActionButton(
            child: Icon(Icons.local_pizza),
            backgroundColor: Colors.orange[800],
            onPressed: () {
              context.read<PizzaBloc>().add(AddPizza(Pizza.pizzas[1]));
            },
          ),
          const SizedBox(
            height: 10,
          ),
          FloatingActionButton(
            child: Icon(Icons.remove),
            backgroundColor: Colors.orange[800],
            onPressed: () {
              context.read<PizzaBloc>().add(RemovePizza(Pizza.pizzas[1]));
            },
          )
        ],
      ),
    );
  }
}
