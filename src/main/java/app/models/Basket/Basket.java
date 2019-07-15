package app.models.Basket;


import app.models.Order.OrderItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Basket {
    private List<OrderItem> orderItemList;
    private int price;

    public Basket() {
        orderItemList = new ArrayList<OrderItem>();
        price = 0;
    }

    public Basket(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;

    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItemList.add(orderItem);
        price += orderItem.getFlower().getPrice() * orderItem.getCount();
    }
    public void clear(){
        orderItemList.clear();
        price = 0;
    }
}
