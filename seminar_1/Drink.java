public class Drink extends Product{

    double volume;
    TypesOfDrink type;

    public Drink(String name, double cost, double volume, TypesOfDrink type) {
        super(name, cost);
        this.volume = volume;
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", volume: %f, type: %s", this.volume, this.type);
    }
}
