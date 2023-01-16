import java.util.ArrayList;
import java.util.List;

public class FamilyMember {

    private FamilyMember mother;
    private FamilyMember father;

    private String name;

    public FamilyMember(String name, FamilyMember mother, FamilyMember father) {
        this.mother = mother;
        this.father = father;
    }

    public List<FamilyMember> getTreeParents(){

        List<FamilyMember> parents = new ArrayList<>();

        boolean flag = true;

        if (mother != null){
            parents.add(mother);
        }

        if (father != null){
            parents.add(father);
        }

        for (int i = 0; i < parents.size(); i++) {
            FamilyMember current = parents.get(i);
            FamilyMember parentMother = current.getMother();
            FamilyMember parentFather = current.getFather();

            if (parentMother != null){
                parents.add(parentMother);
            }

            if (parentFather != null){
                parents.add(parentFather);
            }
        }

        return parents;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "name='" + name + '\'' +
                '}';
    }

    public FamilyMember(String name) {
        this.name = name;
    }

    public FamilyMember getMother() {
        return mother;
    }

    public void setMother(FamilyMember mother) {
        this.mother = mother;
    }

    public FamilyMember getFather() {
        return father;
    }

    public void setFather(FamilyMember father) {
        this.father = father;
    }
}
