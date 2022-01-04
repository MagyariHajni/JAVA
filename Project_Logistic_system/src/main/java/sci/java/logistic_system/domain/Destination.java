package sci.java.logistic_system.domain;

import javax.persistence.*;

@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String destinationName;
    private int distance;
}
