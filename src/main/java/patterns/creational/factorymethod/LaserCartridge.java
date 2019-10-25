package patterns.creational.factorymethod;

public class LaserCartridge implements Cartridge {

    @Override
    public void print() {
        System.out.println("Print as Laser cartridge");
    }

}
