package sci.java.logistic_system;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Company {

    private String name;
    private int numberOfDeliveryDrivers;
    private long startingProfit;
    private Map<LocalDate, Long> profitPerDay = new HashMap<>();
    private OrderRepository companyOrders;

    public Company(String companyName, int numberOfDeliveryDrivers, long startingProfit) {
        this.name = companyName;
        this.numberOfDeliveryDrivers = numberOfDeliveryDrivers;
        this.startingProfit = startingProfit;
        profitPerDay.put(LocalDate.of(2021, 12, 1), startingProfit);
    }

    public void setNumberOfDeliveryDrivers(int numberOfDeliveryDrivers) {
        this.numberOfDeliveryDrivers = numberOfDeliveryDrivers;
    }

    public void addDailyProfit(LocalDate date, long dailyProfit) {
        profitPerDay.put(date, dailyProfit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDeliveryDrivers() {
        return numberOfDeliveryDrivers;
    }

    public long getStartingProfit() {
        return startingProfit;
    }

    public void setStartingProfit(long startingProfit) {
        this.startingProfit = startingProfit;
    }

    public Map<LocalDate, Long> getProfitPerDay() {
        return profitPerDay;
    }

    public void setProfitPerDay(Map<LocalDate, Long> profitPerDay) {
        this.profitPerDay = profitPerDay;
    }

    public OrderRepository getCompanyOrders() {
        return companyOrders;
    }

    public void setCompanyOrders(OrderRepository companyOrders) {
        this.companyOrders = companyOrders;
    }
}
