package org.Model;

import java.io.*;

public class Counter {
    private static String path = "counter.txt";

    public static int getCount() throws IOException{
        int result = -1;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String info = reader.readLine();
            result = Integer.parseInt(info);
            reader.close();
            fr.close();
        } catch (Exception e) {
            throw new IOException("Не удалось прочитать файл");
        }
        return result;
    }

    public static void add() throws IOException {
        int newCount = getCount() + 1;
        String stringCount = "" + newCount;
        try (FileWriter writer = new FileWriter(path, false)) {
                writer.append(stringCount);
        } catch (IOException ex) {
            throw new IOException(ex);
        }
   }
}
