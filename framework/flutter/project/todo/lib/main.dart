import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(const MyApp());
}

//할 일 클래스
class Todo {
  bool isDone;
  String title;
  Todo(this.title, {this.isDone = false});
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '할 일 관리',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: TodoListPage(),
    );
  }
}

class TodoListPage extends StatefulWidget {
  const TodoListPage({Key? key}) : super(key: key);

  @override
  _TodoListPageState createState() => _TodoListPageState();
}

class _TodoListPageState extends State<TodoListPage> {
  //할 일 목록을 저장할 리스트
  final _items = <Todo>[];

  //할 일 문자열 조작을 위한 컨트롤러
  var _todoController = TextEditingController();

  //할 일 추가 메서드
  void _addTodo(Todo todo) {
    setState(() {
      _items.add(todo);
      _todoController.text = '';
    });
  }

  //할 일 삭제 메서드
  void _deleteTodo(Todo todo) {
    setState(() {
      _items.remove(todo);
    });
  }

  //할 일 완료/미완료 메서드
  void _toggleTodo(Todo todo) {
    setState(() {
      todo.isDone = !todo.isDone;
    });
  }

  @override
  void dispose() {
    _todoController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('남은 할 일'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          children: <Widget>[
            Row(
              children: <Widget>[
                Expanded(
                  child: TextField(
                    controller: _todoController,
                  ),
                ),
                ElevatedButton(
                  child: Text('추가'),
                  onPressed: () => _addTodo(Todo(_todoController.text)),
                ),
              ],
            ),
            StreamBuilder<QuerySnapshot>(
              stream: FirebaseFirestore.instance.collection('todo').snapshots(),
              builder: (context, snapshot) {
                if (snapshot.hasError) {
                  return Center(
                    child: Text(snapshot.error.toString()),
                  );
                }

                if (!snapshot.hasData) {
                  return const Center(child: CircularProgressIndicator());
                }

                final documents = snapshot.data!.docs;
                return Expanded(
                  child: ListView(
                    children:
                        documents.map((doc) => _buildItemWidget(doc)).toList(),
                  ),
                );
              },
            ),
          ],
        ),
      ),
    );
  }

  //할 일 객체를 ListTitle 형태로 변경하는 메서드
  Widget _buildItemWidget(DocumentSnapshot doc) {
    final todo = Todo(doc['title'], isDone: doc['isDone']);

    return ListTile(
      onTap: () => _toggleTodo(todo), //Todo : 클릭 시 완료/취소되도록 수정
      title: Text(
        todo.title, //할일
        style: todo.isDone //완료일 때는 스타일 적용
            ? TextStyle(
                decoration: TextDecoration.lineThrough, //취소선
                fontStyle: FontStyle.italic, //이탤릭체
              )
            : null,
      ),
      trailing: IconButton(
        icon: Icon(Icons.delete_forever),
        onPressed: () => _deleteTodo(todo), //Todo: 쓰레기통 클릭 시 삭제되도록 수정
      ),
    );
  }
}
