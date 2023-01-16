public class Main {
    public static void main(String[] args) {

        Zoo zoo = new Zoo();
        zoo.addAnimal(new Cat("Барсик", 1, "grey"))
                .addAnimal(new Dog("Барон", 2))
                .addAnimal(new Horse("Horse", 3))
                .addAnimal(new Duck("Утка", 4))
                .addAnimal(new PolarBear("Белый медведь", 20)
                );

        for (Animal animal : zoo.getAnimals()){
            System.out.println(animal);
            System.out.println(animal.say());
        }

        System.out.println("__________________________Speakable");

        for (Speakable speak : zoo.getSpeakables()){
            System.out.println(speak.say());
        }

        System.out.println("__________________________Runable");

        for (Runable runner : zoo.getRunables()){
            System.out.println(String.format("%s, скорость: %s", String.valueOf(runner), runner.speedOfRun()));
        }

        System.out.println("__________________________Swimable");

        for (Swimable swimmer : zoo.getSwimable()){
            System.out.println(String.format("%s, скорость: %s", String.valueOf(swimmer), swimmer.speedOfSwim()));
        }

        System.out.println("__________________________Flyable");

        for (Flyable fly : zoo.getFlyable()){
            System.out.println(String.format("%s, скорость: %s", String.valueOf(fly), fly.speedOfFly()));
        }

    }
}