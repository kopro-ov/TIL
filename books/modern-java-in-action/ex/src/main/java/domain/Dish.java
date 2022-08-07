package domain;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final DishType dishType;


    public static class Builder {
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final DishType dishType;

        public Builder(String name, boolean vegetarian, int calories, DishType dishType) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.dishType = dishType;
        }

        public Dish build() {
            return new Dish(this);
        }
    }

    private Dish(Builder builder) {
        this.name = builder.name;
        this.vegetarian = builder.vegetarian;
        this.calories = builder.calories;
        this.dishType = builder.dishType;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public DishType getDishType() {
        return dishType;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                '}';
    }
}
