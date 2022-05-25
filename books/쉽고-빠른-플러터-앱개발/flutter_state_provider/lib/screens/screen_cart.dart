import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_state_provider/models/cart.dart';
import 'package:provider/provider.dart';

class CartScreen extends StatelessWidget {
  const CartScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final cart = Provider.of(context)<Cart>(context);
    final items = cart.items;
    return Scaffold(
      appBar: AppBar(
        title: Text('내 카트'),
        actions: [
          Center(
            child: Container(
              padding: EdgeInsets.all(20.0),
              child: Text(
                '총액 : ' + cart.getTotalPrice().toString(),
                style: TextStyle(fontSize: 15),
              ),
            ),
          )
        ],
      ),
      body: ListView.builder(
          itemCount: items.length,
          itemBuilder: (context, index) {
            return Builder(builder: (context) {
              return ListTile(
                title: Text(items[index].title),
                subtitle: Text(items[index].price.toString()),
                trailing: IconButton(
                  icon: Icon(Icons.delete),
                  onPressed: () {
                    cart.deleteItem(items[index].id);
                  },
                ),
              );
            });
          }),
    );
  }
}
