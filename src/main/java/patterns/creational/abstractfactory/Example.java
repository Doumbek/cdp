package patterns.creational.abstractfactory;

import patterns.creational.factorymethod.InkPrinter;
import patterns.creational.factorymethod.LaserPrinter;
import patterns.creational.factorymethod.Printer;

public class Example {

    public static void main(String[] args) {

        final CarComponentsFactory cheapComponentsFactory = new CheapCarComponentFactory();
        final CarComponentsFactory expensiveComponentsFactory = new ExpensiveCarComponentFactory();
        final CarComponentsFactory electricComponentsFactory = new ElectricCarComponentFactory();

        final Car cheapCar = new Car(cheapComponentsFactory);
        final Car expensiveCar = new Car(expensiveComponentsFactory);
        final Car electricCar = new Car(electricComponentsFactory);

        cheapCar.startEngine();
        cheapCar.turnOnHeadlight();

        System.out.println("======================");

        expensiveCar.startEngine();
        expensiveCar.turnOnHeadlight();


        System.out.println("======================");
        electricCar.startEngine();
        electricCar.turnOnHeadlight();

    }

}
