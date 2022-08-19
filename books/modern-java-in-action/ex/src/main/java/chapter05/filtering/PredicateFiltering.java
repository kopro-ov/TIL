package chapter05.filtering;

import domain.Dish;
import domain.DishType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class PredicateFiltering {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish.Builder("pork", false, 800, DishType.MEAT).build(),
                new Dish.Builder("beef", false, 700, DishType.MEAT).build(),
                new Dish.Builder("chicken", false, 400, DishType.MEAT).build(),
                new Dish.Builder("french fries", true, 530, DishType.OTHER).build(),
                new Dish.Builder("rice", true, 350, DishType.OTHER).build(),
                new Dish.Builder("season fruit", true, 120, DishType.OTHER).build(),
                new Dish.Builder("pizza", true, 550, DishType.OTHER).build(),
                new Dish.Builder("prawns", false, 300, DishType.FISH).build(),
                new Dish.Builder("salmon", false, 450, DishType.FISH).build()
        );

        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        vegetarianMenu.stream().forEach(dish -> {
            System.out.println(dish.toString());
        });

        List<Dish> slicedMenu = menu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());


        // takeWhile 이용하면 무한 스트림을 포함한 모든 스트림에 프레디케이트 적용해 스트림을 슬라이스
        List<Dish> slicedMenu1 = menu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());


        // dropWhile 이용하면 나머지 요소
        List<Dish> slicedMenu2 = menu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());

        // 스트림 축소
        List<Dish> dishes = menu.stream()
                .dropWhile(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());

        // 요소 건너 뛰기
        List<Dish> dishes2 = menu.stream()
                .dropWhile(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());


        int totalCalories = menu.stream()
                .collect(reducing(0,
                        Dish::getCalories,
                        Integer::sum));

        String shortMenu = menu.stream().map(Dish::getName)
                .collect(reducing((s1, s2) -> s1 + s2)).get();

    }
}
