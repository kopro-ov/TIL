package effectiveJava.chapter01.item01;

public class Home {

    public static void main(String[] args) {

        //매번 다른 인스턴스가 만들어짐.
        //Theme theme1 = new Theme();
        //Theme theme2 = new Theme(); //다른

        //정적 팩터리 메서드로 인스턴스를 통제하기 때문에 인스턴스가 동일함
        Theme theme1 = Theme.newInstance();
        Theme theme2 = Theme.newInstance();
        System.out.println(theme1);
        System.out.println(theme2);
    }
}
