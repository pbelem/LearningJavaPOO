package service;

import java.util.Date;

public class HourContract {

    private Date date;
    private double valuePerHour;
    private int hours;
    private double totalIncome;

    public HourContract(Date contractDate, double valuePerHour, int duration) {
        this.date = contractDate;
        this.valuePerHour = valuePerHour;
        this.hours = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public double totalValue() {
        return valuePerHour * hours;
    }

}
