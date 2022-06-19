package effectiveJava.chapter01.item03;

public class Elvis {

    public static final Elvis INSTANCE = new Elvis();
    private Elvis()  {
        if(INSTANCE != null) {
            //예외 처리
        }
    }

    public void leaveTheBuilding(){}

}
