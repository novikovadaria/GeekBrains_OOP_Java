public class Horse extends Animal implements Runable{

    public Horse(String name, int box) {
        super(name, box);
    }

    @Override
    public int speedOfRun() {
        return 30;
    }

    @Override
    public String say() {
        return "Игого";
    }
}
