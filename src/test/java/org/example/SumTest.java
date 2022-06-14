package org.example;

import static java.lang.Boolean.parseBoolean;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assume;
import org.junit.Test;

import java.io.*;
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

    boolean testFilesMissing(File testFile) throws FileNotFoundException {
        if (!testFile.exists()) {
            boolean isBuildEnv = Boolean.parseBoolean(System.getenv("BUILD_ENV"));;
            String msg = "File " + testFile + " doesn't exist";
            if (isBuildEnv) {
                throw new FileNotFoundException(msg);
            }
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void shouldSumDataExampleFile() throws FileNotFoundException {
        File testFile = new File(System.getProperty("user.dir") + "/testPrivateRepository/data/datafileexample.nv");
        Assume.assumeFalse(testFile + " doesn't exist", testFilesMissing(testFile));
        short[] nums = readNumsFromFile(testFile);
        Sum sum = new Sum();
        assertEquals(-12218, sum.sumNumbers(nums));
    }

    @Test
    public void shouldSumDataExampleFile2() throws FileNotFoundException {
        File testFile = new File(System.getProperty("user.dir") + "/testPrivateRepository/data/datafileexample2.nv");
        Assume.assumeFalse(testFile + " doesn't exist", testFilesMissing(testFile));
        short[] nums = readNumsFromFile(testFile);
        Sum sum = new Sum();
        assertEquals(21899, sum.sumNumbers(nums));
    }

    @Test
    public void shouldSumDataExampleFile3() throws FileNotFoundException {
        File testFile = new File(System.getProperty("user.dir") + "/testPrivateRepository/data/nonexistentfile.nv");
        Assume.assumeFalse(testFile + " doesn't exist", testFilesMissing(testFile));
        short[] nums = readNumsFromFile(testFile);
        Sum sum = new Sum();
        assertEquals(-32643, sum.sumNumbers(nums));
    }
}
