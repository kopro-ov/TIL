package chapter07;

import java.util.stream.Stream;

public class AllNumberSum {

    /**
     * 전통적인 자바
     */
    public long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /**
     * 순차스트림
     * 숫자 n을 인수로 받아서 1부터 n까지의 모든 숫자의 합계를 반환하는 메서드
     *
     * @param n
     * @return
     */
    public long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)  // 무한 자연수 스트림 생성
                .limit(n)   // n개 이하로 제한
                .reduce(0L, Long::sum); // 모든 숫자를 더하는 스트림 리듀싱 연산
    }

    public long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel() // 스트림을 병렬 스트림으로 변환
                .reduce(0L, Long::sum);
    }


}
