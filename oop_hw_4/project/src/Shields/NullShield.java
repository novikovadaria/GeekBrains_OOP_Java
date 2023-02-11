package Shields;

public class NullShield extends Shield {

    private static NullShield instance;

    private NullShield(){
        super(0, 0);
    }

    public static NullShield getInstance(){
        if (instance == null){
            synchronized (NullShield.class){
                if (instance == null){
                    instance = new NullShield();
                }
            }
        }
        return instance;
    }

}
