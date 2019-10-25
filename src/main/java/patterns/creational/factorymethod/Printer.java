package patterns.creational.factorymethod;

public abstract class Printer {

    private Cartridge cartridge;

    public Printer() {
        this.cartridge = createCartridge();
    }

    protected abstract Cartridge createCartridge();

    public void print() {
        cartridge.print();
    }

}
