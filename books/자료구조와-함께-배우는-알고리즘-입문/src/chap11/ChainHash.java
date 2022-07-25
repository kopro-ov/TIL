package chap11;

public class ChainHash {

    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> next;

        public Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        //키의 해시 값을 반환
        public int hashCode() {
            return key.hashCode();
        }


    }




}
