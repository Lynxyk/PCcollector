package ChoiceComponents;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс отвечающий за нахождение мин. цены из БД, определенного типа комплектующего
 */

public class MinPriceComponent {
    private final String URL = "jdbc:mysql://localhost:3306/partspc?useSSL=false";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    /** Функия отвечающая за получение мин. цены
     * @param table - таблица в которой мы ищем цену
     * @param objectChoice - колонка в таблице
     * @param  version - тип комплектующего*/


    protected <T1> int minPrice(String table, String objectChoice, T1 version){
        Connection connection = null;
        Statement statement = null;
        int min = -1;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT price FROM " + table + " WHERE " + objectChoice + " =  " + version);
            List<Price> list = new ArrayList<>();
            while (resultSet.next()){
                int priceComonent = resultSet.getInt(1);
                Price price = new Price(priceComonent);
                list.add(price);
            }
            int[] price = new int[list.size()];
            for ( int i = 0; i < list.size(); i++) {
                price[i] = list.get(i).getPriceComponent();
            }
            Arrays.sort(price);
            for ( int i = 0; i < price.length; i++ ) {
                if ( price[i] > 0) {
                    min = price[i];
                    break;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                if (connection != null)
                connection.close();
                if (statement != null)
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return min;
    }
}