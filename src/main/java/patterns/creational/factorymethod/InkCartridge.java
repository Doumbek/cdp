package patterns.creational.factorymethod;

public class InkCartridge implements Cartridge {

    @Override
    public void print() {
        System.out.println("Print as Ink cartridge");
    }

}
