import Shields.Shieldable;

import java.util.*;

public class Team <E extends Warrior> implements Iterable<E>{
    private List<E> team = new ArrayList<>();
    
    public Team<E> addWarriorToTeam(E person) {
        team.add(person);
        return this;
    }

    @Override
    public Iterator<E> iterator() {
        return team.iterator();
    }

    public E minArmor(){
        E element = null;
        Iterator<E> iterator = this.iterator();

        while (iterator.hasNext() && element == null){
            E currentElement = iterator.next();
            if (currentElement instanceof Shieldable){
                element = currentElement;

            }
        }

        while (iterator.hasNext()){
            E currentElement = iterator.next();
            if (currentElement instanceof Shieldable){
                if (((Shieldable) currentElement).armor() < ((Shieldable) element).armor()){
                    element = currentElement;
                }
            }
        }

        return element;
    }

    public int maxTeamRange() {
        int maxRange = 0;
        for (E item : team) {
            if(item instanceof Archer) {
                if(((Archer)item).shotRange() > maxRange) maxRange = ((Archer)item).shotRange();
            }
        }
        return maxRange;
    }



}
