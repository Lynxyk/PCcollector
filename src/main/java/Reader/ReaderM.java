package Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * Класс  отвечающий за создание массива из файла-хранилища
 */


public class ReaderM {
    /** Функция отвечающая за передачу массива int из файла*/
    public int[] readerInt(String way) {
        String[] stringArr = readerString(way);
        int[] intArr = new int[stringArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        return intArr;
    }

    /** Функция отвечающая за передачу массива String из файла*/
    public String[] readerString(String way) {
        ArrayList<String> list = null;
        Path path = Paths.get(way);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String str;

            list = new ArrayList<>();
            while ((str = bufferedReader.readLine()) != null) {
                if (!str.isEmpty()) {
                    list.add(str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } if (list != null) {
            String[] stringArr = list.toArray(new String[0]);
            return stringArr;
        } else {
            return new String[0];
        }
    }
}
