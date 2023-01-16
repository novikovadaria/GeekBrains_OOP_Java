public abstract class Animal implements Speakable{

    private String name;
    private int box;

    public Animal(String name, int box) {
        this.name = name;
        this.box = box;
    }

    @Override
    public String toString() {
        String text = String.format("name: %s, box: %d", this.name, this.box);

        return text;
    }

    public abstract String say();
}
