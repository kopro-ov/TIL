package effectiveJava.chapter01.item01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

public class ByeServiceFactory {

    public static void main(String[] args) {

//        public static <S> ServiceLoader<S> load(ModuleLayer layer, Class<S> service) {
//            return new ServiceLoader<>(Reflection.getCallerClass(), layer, service);
//        }
        ServiceLoader<ByeService> loader = ServiceLoader.load(ByeService.class);
        Optional<ByeService> byeServiceOptional = loader.findFirst();
        byeServiceOptional.ifPresent(h -> {
            h.bye();
        });

        ByeService byeService = new KoreanByeService();
        List list = new ArrayList<>(); //new도 허용
        List.of("ttt", "222"); //정적 팩터리 메서드
    }
}
