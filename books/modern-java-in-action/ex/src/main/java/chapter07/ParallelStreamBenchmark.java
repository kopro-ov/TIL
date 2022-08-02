package chapter07;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime) // 벤치마크 대상 메서드를 실행하는 데 걸린 평균 시간 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 벤치마크 결과를 밀리초 단위로 출력
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"}) // 4Gb의 힙 공간을 제공한 환경에서 두 번 벤치마크를 수행해 결과의 신뢰성 확보
public class ParallelStreamBenchmark {

    private static final long N = 10_000_000L;

    /**
     * 전통적인 자바
     */
    @Benchmark // 벤치마크 대상 메서드
    public long iterativeSum() {
        long result = 0;
        for (long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

    /**
     * 순차스트림
     * 숫자 n을 인수로 받아서 1부터 n까지의 모든 숫자의 합계를 반환하는 메서드
     * @return
     */
    @Benchmark // 벤치마크 대상 메서드
    public long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1)  // 무한 자연수 스트림 생성
                .limit(N)   // n개 이하로 제한
                .reduce(0L, Long::sum); // 모든 숫자를 더하는 스트림 리듀싱 연산
    }

    /**
     * 병렬 스트림
     * @return
     */
    @Benchmark // 벤치마크 대상 메서드
    public long parallelSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .parallel() // 스트림을 병렬 스트림으로 변환
                .reduce(0L, Long::sum);
    }

    @TearDown(Level.Invocation) // 매 번 벤치마크를 실행한 다음에는 가비지 컬렉터 동작 시도
    public void tearDown() {
        System.gc();
    }

}
