package chapter01.apple;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple a) {
        return "An Apple of " + a.getWeight() + "g";
    }
}
