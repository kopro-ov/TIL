package chapter01;

import java.io.File;
import java.io.FileFilter;

public class FileFiltering {

    public static void main(String[] args) {

        // 기존의 숨겨진 방식
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        // 람다 익명 함수
        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);

    }

}
