package Shields;

public class Hoplon extends Shield{

    public Hoplon(int size, int armorReserve) {
        super(size, armorReserve);
    }

    @Override
    public String toString() {
        return "Hoplon{" +
                "armorReserve=" + armorReserve +
                '}';
    }
}
