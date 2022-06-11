package interview_practice.strategypattern;

import java.io.File;
import java.util.ArrayList;

public class RarCompressionStrategy implements CompressionStrategy{
    @Override
    public void compressFiles(ArrayList<File> files) {

        System.out.println("Compressing using RAR");
    }
}
