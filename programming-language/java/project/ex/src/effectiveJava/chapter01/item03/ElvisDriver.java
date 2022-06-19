package effectiveJava.chapter01.item03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.Base64;

public class ElvisDriver {

    public static void main(String[] args) throws Exception{

        //public static final 필드 방식의 싱글턴
        Elvis elvis = Elvis.INSTANCE;
        System.out.println(elvis);

        //리플렉션 API
        Constructor<?> con = Elvis.class.getDeclaredConstructors()[0];
        con.setAccessible(true);

        elvis = (Elvis) con.newInstance();
        System.out.println(elvis);

        System.out.println("====");

        //정적 팩토리 방식의 싱글턴
        Elvis2 elvis2 = Elvis2.getInstance();
        System.out.println(elvis2);


        //직렬화
        byte[] serializedElvis2;
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try(ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(elvis2);
                serializedElvis2 = baos.toByteArray();
            }
        }

        //역직렬화
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedElvis2)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {

                Object objectPost = ois.readObject();
                elvis2 = (Elvis2) objectPost;

            }
        }
        System.out.println(elvis2);

        System.out.println("==");

        //열거 타입 방식의 싱글턴
        Elvis3 elvis3 = Elvis3.INSTANCE;
        System.out.println(elvis3);

        byte[] serializedElvis3;
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try(ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(elvis3);
                serializedElvis3 = baos.toByteArray();
            }
        }

        //역직렬화
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedElvis3)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {

                Object objectPost = ois.readObject();
                elvis3 = (Elvis3) objectPost;

            }
        }
        System.out.println(elvis3);

    }
}
