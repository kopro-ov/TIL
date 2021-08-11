import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '폼 검증 데모',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: Text('폼 검증 데모'),
        ),
        body: MyCustomForm(),
      ),
    );
  }
}

class MyCustomForm extends StatefulWidget {
  const MyCustomForm({Key? key}) : super(key: key);

  @override
  _MyCustomFormState createState() => _MyCustomFormState();
}

class _MyCustomFormState extends State<MyCustomForm> {
  //Form 위젯에 유니크한 키갑을 부여하고 검증시 사용
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Form(
        key: _formKey,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            TextFormField(
              validator: (String? value) {
                //그냥 value.isEmpty하면 > The property 'isEmpty" can't be unconditionally accessed because the receiver can be 'null'
                if (value!.isEmpty) {
                  return '글자를 입력하세요';
                }
                return null;
              },
            ),
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 16.0),
              child: ElevatedButton(
                onPressed: () {
                  //폼을 검증하여 통과하면 true 실패하면 false
                  if (_formKey.currentState!.validate()) {
                    //검증이 통과하면 스낵바 표시
                    ScaffoldMessenger.of(context)
                        .showSnackBar(SnackBar(content: Text('검증 완료')));
                  }
                },
                child: Text('검증'),
              ),
            )
          ],
        ));
  }
}
