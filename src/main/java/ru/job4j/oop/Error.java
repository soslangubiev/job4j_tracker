package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        defaultError.printInfo();
        System.out.println("------------------------------");
        Error requestError = new Error(true, 400, "Bad request");
        requestError.printInfo();
        System.out.println("------------------------------");
        Error timeoutError = new Error(true, 504, "Gateway Timeout");
        timeoutError.printInfo();
    }
}
