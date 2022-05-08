package chap03;

import java.util.Comparator;
import java.util.Scanner;

//신체검사 데이터 배열에서 이진 검색하기
public class PhysExamSearch {

    //신체검사 데이터를 정의합니다.
    static class PhyscData {
        private String name;    //이름
        private int height;     //키
        private double vision;  //시력

        //생성자
        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return "PhyscData{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }
    }


}
