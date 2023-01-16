public class Cat extends Animal implements Runable{

    private String color;

    public Cat(String name, int box, String color) {
        super(name, box);
        this.color = color;
    }

    @Override
    public int speedOfRun() {
        return 15;
    }

    @Override
    public String say() {
        return "Мяу";
    }

    @Override
    public String toString() {
        return String.format("Cat: %s, colour: %s", super.toString(), this.color);
    }
}
