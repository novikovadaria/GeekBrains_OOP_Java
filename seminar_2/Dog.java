public class Dog extends Animal implements Runable{

    public Dog(String name, int box) {
        super(name, box);
    }

    @Override
    public int speedOfRun() {
        return 20;
    }

    @Override
    public String say() {
        return "Гав";
    }
}
