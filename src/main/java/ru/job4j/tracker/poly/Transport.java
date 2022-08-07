package ru.job4j.tracker.poly;

public interface Transport {
    void move();

    void passengers(int passengers);

    int refuel(int fuel);
}
