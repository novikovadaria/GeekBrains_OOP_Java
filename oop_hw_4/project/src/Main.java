// Реализовать абстрактный класс Warrior, с полями name, weapon, healthPoint
// Создать интерфейс Weapon с методом damage(), который будет показывать наносимый урон
// На основе класса Warrior создать различные типы воинов, например, лучник, меченосец, ополченец и т.п.
// У лучника добавить поле расстояние поражения. 
// Создать различные виды вооружения, например, меч, лук, лопата.
// Обеспечить, чтобы определенный тип воина мог нести только определенной оружие
// Создать класс командира

//ДЗ: На основе работы на уроке. Создать класс щита, разработать разные типы щитов,
// добавить в семейство классов Warriors обобщения в виде щитов.
// Реструктуризировать код в конечных классах семейства Warriors.
// Добавить метод определения минимального щита в команде.
//* Продумать, как можно сделать воина без щита.


import Shields.Buckler;
import Weapons.Bow;
import Weapons.Sword;

public class Main {
    public static void main(String[] args) {
        Team <Swordman> team1 = new Team<>();
        team1.addWarriorToTeam(new Swordman("Vasya", 250, new Sword(25)))
        .addWarriorToTeam(new Swordman("John", 200, new Sword(50), new Buckler(50, 100)));

        for (Swordman swordman : team1) {
            System.out.println(swordman);
        }

        Team <Archer> team2 = new Team<>();
        team2.addWarriorToTeam(new Archer("Kolya", 150, new Bow(100, 50)))
        .addWarriorToTeam(new Archer("Paul", 200, new Bow(75, 70)));

        for (Archer person : team2) {
            System.out.println(person);
        }

        System.out.println(team1.maxTeamRange());
        System.out.println(team2.maxTeamRange());
        System.out.println(team1.minArmor());
    }
    
    
}
