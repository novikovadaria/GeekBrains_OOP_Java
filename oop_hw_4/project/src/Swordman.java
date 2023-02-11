import Shields.NullShield;
import Shields.Shield;
import Shields.Shieldable;
import Weapons.Sword;

public class Swordman extends Warrior  implements Shieldable {

    private Shield shield = NullShield.getInstance();

    public Swordman(String name, int healthPoint, Sword sword) {
        super(name, healthPoint, sword);
    }

    public Swordman(String name, int healthPoint, Sword sword, Shield shield){
        this(name, healthPoint, sword);
        this.shield = shield;
    }

    public void setDamage(int value){
        int healthValue = Math.max(0, getHealthPoint() - value);
        setHealthPoint(healthValue);
        shield.addDamage(value);
        if (armor() <= 0){
            shield = NullShield.getInstance();
        }
    }

    @Override
    public String toString() {
        return String.format("name :%s, healthPoint = %s, weapon: %s, armor: %s", getName(), getHealthPoint(), getWeapon(), armor());
    }

    @Override
    public int sizeShield() {
        return shield.getSize();
    }

    @Override
    public int armor() {
        return shield.getArmorReserve();
    }

    @Override
    public Shield getShield() {
        return shield;
    }

}
