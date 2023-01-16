import java.util.List;

public class FamilyMemberTestDrive {

    public static void main(String[] args){

        FamilyMember fm = new FamilyMember("fm");
        FamilyMember fm1 = new FamilyMember("fm1");
        FamilyMember fm2 = new FamilyMember("fm2");
        FamilyMember fm3 = new FamilyMember("fm3");
        FamilyMember fm4 = new FamilyMember("fm4");
        FamilyMember fm5 = new FamilyMember("fm5");
        FamilyMember fm6 = new FamilyMember("fm6");
        FamilyMember fm7 = new FamilyMember("fm7");
        FamilyMember fm8 = new FamilyMember("fm8");

        fm.setMother(fm1);
        fm.setFather(fm2);
        fm1.setFather(fm3);
        fm1.setMother(fm4);
        fm2.setFather(fm5);
        fm2.setMother(fm6);

        System.out.println("genealogical tree for fm");
        List<FamilyMember> listFM = fm.getTreeParents();

        for (FamilyMember current : listFM){
            System.out.println(current);
        }

        System.out.println("_________________________");
        List<FamilyMember> listFM1 = fm1.getTreeParents();

        for (FamilyMember current : listFM1){
            System.out.println(current);
        }

    }
}
