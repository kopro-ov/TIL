package effectiveJava.chapter01.item01;

import java.util.List;

public class Delivery {

    private List<OrderItem> orderItems;
    private boolean normal;
    private boolean express;

//    public Delivery(List<OrderItem> orderItems, boolean normal) {
//        this.orderItems = orderItems;
//        this.normal = normal;
//    }
//
//    public Delivery(List<OrderItem> orderItems, boolean express) {
//        this.orderItems = orderItems;
//        this.normal = express;
//    }
//    //순서를 바꿀 수 있긴 하지만.........
//    public Delivery(boolean express, List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//        this.normal = express;
//    }

    public static Delivery normalDeliver(List<OrderItem> orderItems) {
        Delivery delivery = new Delivery();
        delivery.orderItems = orderItems;
        delivery.normal = true;
        return delivery;
    }

    public static Delivery expressDeliver(List<OrderItem> orderItems) {
        Delivery delivery = new Delivery();
        delivery.orderItems = orderItems;
        delivery.express = true;
        return delivery;
    }

}
