package Shields;

public abstract class Shield{

    private int size;
    public int armorReserve;

    public Shield(int size, int armorReserve) {
        this.size = size;
        this.armorReserve = armorReserve;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getArmorReserve() {
        return armorReserve;
    }

    public void setArmorReserve(int armorReserve) {
        this.armorReserve = armorReserve;
    }

    public void addDamage(int damage) {
        armorReserve = Math.max(armorReserve - damage, 0);
    }
}
