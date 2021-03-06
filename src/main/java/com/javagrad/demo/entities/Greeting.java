package com.javagrad.demo.entities;

public class Greeting {
    private String greeting;

    public Greeting(){}
    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Greeting greeting1 = (Greeting) o;

        return greeting != null ? greeting.equals(greeting1.greeting) : greeting1.greeting == null;
    }

    @Override
    public int hashCode() {
        return greeting != null ? greeting.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "greeting='" + greeting + '\'' +
                '}';
    }
}
