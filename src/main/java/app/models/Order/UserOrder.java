package app.models.Order;

import app.models.User.User;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "USER_ORDER")
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItemList;

    public UserOrder() {
    }

    public UserOrder(User user, List<OrderItem> orderItemList) {
        this.user = user;
        this.orderItemList = orderItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
