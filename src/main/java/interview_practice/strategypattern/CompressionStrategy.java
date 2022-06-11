package interview_practice.strategypattern;

import java.io.File;
import java.util.ArrayList;

public interface CompressionStrategy {
    void compressFiles(ArrayList<File> files);
}