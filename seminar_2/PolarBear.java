public class PolarBear extends Animal implements Runable, Swimable{

    public PolarBear(String name, int box) {
        super(name, box);
    }

    @Override
    public int speedOfSwim() {
        return 10;
    }

    @Override
    public int speedOfRun() {
        return 20;
    }

    @Override
    public String say() {
        return null;
    }

}
