package UpdateDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Класс отвечающий за получение новой цены и проверки наличия
 */

public class UpdatePrices {
    /**
     * Функция отвечающая за проверку новой цены и наличия
     * Если товар есть в наличии, то возвращается новая цена, иначе возвращает: -1
     */
    public int issuingAPrice(String urlUpdate) throws IOException {
        URL url = new URL(urlUpdate);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine = null;
        String text = null;
        while ((inputLine = in.readLine()) != null) {
            text = text + inputLine;
        }
        if (text != null && !text.contains("₽")) {
            return -1;
        } else {
            if (text != null) {
                int end = text.indexOf("₽<");
                int begin = end - 10;
                String part = text.substring(begin, end);
                String result = part.replaceAll("[^0-9]", "");
                return Integer.valueOf(result);
            } else {
                return -1;
            }
        }
    }

}



