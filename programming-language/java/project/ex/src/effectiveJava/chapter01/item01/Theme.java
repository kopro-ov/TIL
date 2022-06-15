package effectiveJava.chapter01.item01;

public class Theme {

    public boolean dark;

    private Theme() {

    }

    private static final Theme THEME = new Theme();

    public static Theme newInstance() {
        return THEME;
    }

}
