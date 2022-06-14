package org.example;

import static java.lang.Boolean.parseBoolean;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test for simple App.
 */
public class SumTest
{

    public short[] readNumsFromFile(File file) {
        // read in the first 4 shorts
        int maxIndex = 4;
        short[] numArr = new short[4];
        try (DataInputStream in = new DataInputStream(Files.newInputStream(file.toPath()))) {
            for (int i = 0; i< maxIndex; i++) {
                numArr[i] = in.readShort();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return numArr;
    }

    boolean testFilesMissing(File testFile) {
        if (!testFile.exists()) {
            System.out.println("File " + testFile + " doesn't exist, skipping test");
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void shouldSumDataExampleFile()
    {
        System.out.println("PINEAPPLE");
        System.out.println(System.getenv("BUILD_ENV"));
        File testFile = new File(System.getProperty("user.dir") + "/testPrivateRepository/data/datafileexample.nv");
        if (testFilesMissing(testFile)) {
            return;
        }
        short[] nums = readNumsFromFile(testFile);
        Sum sum = new Sum();
        assertEquals(-12218, sum.sumNumbers(nums));
    }

    @Test
    public void shouldSumDataExampleFile2()
    {
        File testFile = new File(System.getProperty("user.dir") + "/testPrivateRepository/data/datafileexample2.nv");
        if (testFilesMissing(testFile)) {
            return;
        }
        short[] nums = readNumsFromFile(testFile);
        Sum sum = new Sum();
        assertEquals(21899, sum.sumNumbers(nums));
    }

    @Test
    public void shouldSumDataExampleFile3()
    {
        File testFile = new File(System.getProperty("user.dir") + "/testPrivateRepository/data/datafileexample3.nv");
        if (testFilesMissing(testFile)) {
            return;
        }
        short[] nums = readNumsFromFile(testFile);
        Sum sum = new Sum();
        assertEquals(-32643, sum.sumNumbers(nums));
    }
}
