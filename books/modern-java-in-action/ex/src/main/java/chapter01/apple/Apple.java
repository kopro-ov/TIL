package chapter01.apple;

public class Apple {

    private final Color color;
    private final int weight;

    public static class Builder {

        private final Color color;
        private final int weight;

        public Builder(Color color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public Apple build() {
            return new Apple(this);
        }

    }

    private Apple(Builder builder) {
        color = builder.color;
        weight = builder.weight;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

}
