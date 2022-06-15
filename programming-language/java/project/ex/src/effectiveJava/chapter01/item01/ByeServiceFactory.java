package effectiveJava.chapter01.item01;

import java.util.Optional;
import java.util.ServiceLoader;

public class ByeServiceFactory {

    public static void main(String[] args) {

//        public static <S> ServiceLoader<S> load(ModuleLayer layer, Class<S> service) {
//            return new ServiceLoader<>(Reflection.getCallerClass(), layer, service);
//        }
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloService = loader.findFirst();
        helloService.ifPresent(h -> {
            h.hello();
        });

    }
}
