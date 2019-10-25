package patterns.creational.abstractfactory;

import patterns.creational.factorymethod.InkPrinter;
import patterns.creational.factorymethod.LaserPrinter;
import patterns.creational.factorymethod.Printer;

public class Example {

    public static void main(String[] args) {

        final CarComponentsFactory cheapComponentsFactory = new CheapCarComponentFactory();
        final CarComponentsFactory expensiveComponentsFactory = new ExpensiveCarComponentFactory();

        final Car cheapCar = new Car(cheapComponentsFactory);
        final Car expensiveCar = new Car(expensiveComponentsFactory);

        cheapCar.startEngine();
        cheapCar.turnOnHeadlight();

        System.out.println("======================");

        expensiveCar.startEngine();
        expensiveCar.turnOnHeadlight();

    }

}
