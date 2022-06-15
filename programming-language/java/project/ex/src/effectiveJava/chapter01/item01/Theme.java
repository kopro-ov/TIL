package effectiveJava.chapter01.item01;

/**
 * 이 클래스의 인스턴스는 #getInstance()를 통해 사용된다
 * @see #getInstance()
 */
public class Theme {

    public boolean dark;

    private Theme() {

    }

    private static final Theme THEME = new Theme();

    public static Theme getInstance() {
        return THEME;
    }

}
