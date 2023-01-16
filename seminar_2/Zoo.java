import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals;
    private Radio radio = new Radio();

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public Zoo addAnimal(Animal animal){
        this.animals.add(animal);
        return this;
    }

    public List<Speakable> getSpeakables(){
        List<Speakable> answer = new ArrayList<>();

        for (Animal animal : animals){
            answer.add(animal);
        }

        answer.add(radio);

        return answer;
    }

    public int getChampionOfRunners(){
        int result = 0;

        List<Runable> list = getRunables();
        for (Runable runable : list){
            if (runable.speedOfRun() > result){
                result = runable.speedOfRun();
            }
        }

        return result;
    }

    public List<Runable> getRunables(){
        List<Runable> result = new ArrayList<>();
        for (Animal animal : animals){
            if (animal instanceof Runable){
                result.add((Runable) animal);
            }
        }
        return result;

    }

    public List<Flyable> getFlyable(){
        List<Flyable> result = new ArrayList<>();
        for (Animal animal : animals){
            if (animal instanceof Flyable){
                result.add((Flyable) animal);
            }
        }
        return result;

    }

    public List<Swimable> getSwimable(){
        List<Swimable> result = new ArrayList<>();
        for (Animal animal : animals){
            if (animal instanceof Swimable){
                result.add((Swimable) animal);
            }
        }
        return result;

    }

    public  List<Animal> getAnimals() {
        return animals;
    }
}
