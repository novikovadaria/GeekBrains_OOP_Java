package Shields;

public class Buckler extends Shield{

    public Buckler(int size, int armorReserve) {
        super(size, armorReserve);
    }

    @Override
    public String toString() {
        return "Buckler{" +
                "armorReserve=" + armorReserve +
                '}';
    }
}
