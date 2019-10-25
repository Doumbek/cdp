package patterns.structural.decorator;

public class TextBasePrinter implements Printer {

    @Override
    public void print() {
        System.out.println("Print text!");
    }

}
