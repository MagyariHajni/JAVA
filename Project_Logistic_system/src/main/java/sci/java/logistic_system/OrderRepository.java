package sci.java.logistic_system;

import org.springframework.stereotype.Service;
import sci.java.logistic_system.domain.Order;

import java.util.*;

@Service
public class OrderRepository {

    private Map<Integer, Order> allOrdersMap;

    public OrderRepository() {
        this.allOrdersMap = new HashMap<>();
    }

    public List<Order> listAll() {
        return new ArrayList<>(allOrdersMap.values());
    }

    public Order getById(Integer id) {
        return allOrdersMap.get(id);
    }

    public Order saveOrUpdate(Order order) {
        if (order != null) {
            if (order.getId() == null) {
                order.setId(getNextKey());
            }
            allOrdersMap.put(order.getId(), order);
            return order;
        } else {
            throw new RuntimeException("\u001B[38;5;213m" + "\u001B[41m"
                    + "Cannot be null, please fill all fields!!!"
                    + "\u001B[0m");
        }
    }

    private Integer getNextKey() {
        if (allOrdersMap.isEmpty()) {
            return 1;
        }
        return Collections.max(allOrdersMap.keySet()) + 1;
    }

}
