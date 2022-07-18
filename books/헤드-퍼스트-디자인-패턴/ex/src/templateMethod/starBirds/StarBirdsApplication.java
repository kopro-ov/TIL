package templateMethod.starBirds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StarBirdsApplication {

    public static void main(String[] args) throws Exception {
        new StarBirdsApplication().run(args);
    }

    public void run(String[] args) throws Exception {

        final AtomicBoolean running = new AtomicBoolean(true);
        final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter output = new PrintWriter(System.out, false);

        final Map<Command, Consumer<List<String>>> commandActions = new HashMap<>();
        // 애플리케이션 종료:: ❯ quit
        commandActions.put(Command.Quit, arguments -> {
            output.println("quit application.");
            running.set(false);
        });

        commandActions.put(Command.Coffee, arguments -> {
            Coffee coffee = new Coffee();
            coffee.prepareRecipe();
            output.println("음료 나왔습니다");
        });

        commandActions.put(Command.Tea, arguments -> {
            Tea tea = new Tea();
            tea.prepareRecipe();
            output.println("음료 나왔습니다");
        });

        output.println();
        output.println("스타버즈 카페 오픈");

        while (running.get()) {
            try {
                // 사용자가 입력한 값 읽기
                output.print("❯ ");
                output.flush();
                List<String> arguments = Stream.of(input.readLine().split(" "))
                        .map(String::trim)
                        .filter(argument -> !argument.isBlank())
                        .collect(Collectors.toList());

                // 명령어 해석 후 실행, 연결된 명령어가 없으면 입력 오류 메시지 출력하기
                Command command = Command.parse(arguments.isEmpty() ? null : arguments.get(0));
                Consumer<List<String>> commandAction = commandActions.getOrDefault(command, null);
                if (Objects.isNull(commandAction)) {
                    throw new ApplicationException.UndefinedCommandActionException();
                }
                commandAction.accept(arguments);
            } catch (ApplicationException error) {
                output.println(error.getMessage());
            } finally {
                output.flush();
            }
        }

    }

    enum Command {
        Quit, Coffee, Tea;

        static Command parse(String text) {
            if (Objects.isNull(text)) {
                return null;
            }
            return Stream.of(Command.values())
                    .filter(it -> Objects.equals(it.name().toLowerCase(), text.toLowerCase()))
                    .findAny().orElse(null);
        }
    }
}
