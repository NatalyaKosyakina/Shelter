package org.Model;

import java.io.*;

public class Counter {
    private static String path = "counter.txt";
    //private static int count;

    public static int add() throws IOException{
        return 2;
    }

//    public static int getCount() throws IOException {
//        try (FileReader reader = new FileReader(new File(path))){
//            count = reader.read();
//        } catch (IOException e) {
//            throw new IOException(e);
//        }
//        return count;
//    }
//
//    private void add() throws IOException {
//        try (FileWriter writer = new FileWriter(path, false)){
//            writer.write(count);
//        } catch (IOException e) {
//            throw new IOException(e);
//        }
//    }
}
