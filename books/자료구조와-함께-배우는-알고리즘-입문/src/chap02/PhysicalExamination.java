package chap02;

public class PhysicalExamination {

    static final int VMAX = 21;

    static class PhysData {
        String name;
        int height;
        double vision;

        PhysData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }


    // 키의 평균값을 구함
    static double aveHeight(PhysData[] dat) {
        double sum = 0;
        for (int i = 0; i < dat.length; i++) {
            sum += dat[i].height;
        }
        return sum / dat.length;
    }


}
