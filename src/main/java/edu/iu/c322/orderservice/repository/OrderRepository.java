package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();


    public Order findCustomerID(int id){
        return getOrderById(id);
        /*
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getCustomerId() == id ){
                o =orders.get(i);
                return o;
            }
        }

        return null;
        */

    }

    public int create(Order order){
        orders.add(order);
        return order.getCustomerId();
    }


    public void update(Order order, int id){
        Order x = getOrderById(id);
        if (x != null){
            x.setReason("Return");
        }
        else {
            throw new IllegalStateException("Not Valid ID");
        }
    }

    public void delete(int id){
        Order x = getOrderById(id);
        if (x != null){
            orders.remove(x);
        }
        else {
            throw new IllegalStateException("Not Valid ID");
        }
    }

    private Order getOrderById(int id){
        return  orders.stream().filter(x -> x.getCustomerId() == id).findAny().orElse(null);
    }


}
