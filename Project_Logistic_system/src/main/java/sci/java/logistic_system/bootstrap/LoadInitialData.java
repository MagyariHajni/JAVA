package sci.java.logistic_system.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sci.java.logistic_system.Company;
import sci.java.logistic_system.OrderRepository;

@Component
public class LoadInitialData implements ApplicationListener<ContextRefreshedEvent> {

    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadInitialOrders();
    }

    private void loadInitialOrders() {
        //load from csv
    }
}

