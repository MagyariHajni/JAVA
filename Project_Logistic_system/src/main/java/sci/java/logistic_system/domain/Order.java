package sci.java.logistic_system.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;


@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private Destination orderDestination;

    private LocalDateTime deliveryDate;
    private Map<LocalDateTime, OrderStatus> orderStatusMap;
    private LocalDateTime lastUpDated;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Destination getOrderDestination() {
        return orderDestination;
    }
    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public Map<LocalDateTime, OrderStatus> getOrderStatusMap() {
        return orderStatusMap;
    }
    public LocalDateTime getLastUpDated() {
        return lastUpDated;
    }
}
