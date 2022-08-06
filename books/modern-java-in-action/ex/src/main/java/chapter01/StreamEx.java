package chapter01;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class StreamEx {


    private class Transaction {
        private int price;

        private Currency currency;

        public int getPrice() {
            return price;
        }

        public Currency getCurrency() {
            return currency;
        }
    }

    public static void main(String[] args) {

        /**
         * 리스트에서 고가의 트랜잭션(거래)만 필터링한 다음에
         * 통화로 결과를 그룹화 해보기
         */
        List<Transaction> transactions = new ArrayList<>();
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

        /**
         * 1. 기본 코드로 구현해보기
         */
        for (Transaction transaction : transactions) {
            if (transaction.getPrice() > 1000) {
                Currency currency = transaction.getCurrency(); // 트랜잭션 통화 추출
                List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
                if (transactionsForCurrency == null) { // 현재 통화의 그룹화된 맵에 항목이 없으면 새로 만든다.
                    transactionsForCurrency = new ArrayList<>();
                    transactionsByCurrencies.put(currency, transactionsForCurrency);
                }
                transactionsForCurrency.add(transaction); // 현재 탐색된 트랜잭션을 같은 통화의 트랜잭션 리스트에 추가한디.
            }
        }

        /**
         * 2. 스트림 API를 이용하기
         * groupingBy(classifier, HashMap::new, downstream)
         */
        transactionsByCurrencies = transactions.stream()
                .filter((Transaction t) -> t.getPrice() > 1000) // 고가의 트랜잭션 필터링
                .collect(groupingBy(Transaction::getCurrency)); // 통화로 그룹핑

    }

}
