package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("The bus is running");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Passengers in bus: " + passengers);
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 52;
    }
}
