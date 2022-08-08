package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по трассе");
    }

    public static void main(String[] args) {
        Vehicle firstBus = new Bus();
        Vehicle secondBus = new Bus();
        Vehicle firstAirplane = new Airplane();
        Vehicle secondAirplane = new Airplane();
        Vehicle firstTrain = new Train();
        Vehicle secondTrain = new Train();
        Vehicle[] vehicles = new Vehicle[]{
                firstBus, firstAirplane, firstTrain, secondBus, secondAirplane, secondTrain};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }

}
