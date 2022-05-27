import 'package:equatable/equatable.dart';
import 'package:flutter/material.dart';

class Pizza extends Equatable {
  final String id;
  final String name;

  const Pizza({required this.id, required this.name});

  @override
  List<Object?> get props => [id, name];

  static List<Pizza> pizzas = [
    const Pizza(id: '0', name: 'Pizza'),
    const Pizza(id: '0', name: 'Pizza Peperoni'),
  ];
}
