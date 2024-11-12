package UpdateDB;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;

/**
 * Класс отвечающий за обновление и наличия цен в БД
 */

public class UpdaterDB extends Thread {
    /** 3 поля, для подключения к БД*/
    private final String URL = "jdbc:mysql://localhost:3306/partspc?useSSL=false";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";
    /** Поле componentID - id определенного комплектующего */
    private String componentId;
    /** поле UPDATE - команда для взаимодествия с БД*/
    private String UPDATE;
    /** поле newPriceUrl - массив ссылок для получения новых цен с помощью UpdaterPrices*/
    private String[] newPriceUrl;
    /** поле column - таблица в которой обновляются цены и наличие */
    private String column;
    UpdatePrices updatePrices = new UpdatePrices();

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param componentId - id комплектующего
     * @param  newPriceUrl - массив ссылок
     * @param column - таблица */

    public UpdaterDB(String componentId, String[] newPriceUrl, String column) {
        this.componentId = componentId;
        this.newPriceUrl = newPriceUrl;
        this.column = column;
    }

    /**
     * Функия отвечающая за обновление цен по полученным значениям */

    public void run(){
        UPDATE = "UPDATE " + column + " SET price = ? WHERE "+componentId+ " = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(UPDATE);
            for (int i = 0; i < newPriceUrl.length; i++) {
                statement.setInt(1, updatePrices.issuingAPrice(newPriceUrl[i]));
                statement.setInt(2,i +1);
                statement.execute();
            }

        } catch (SQLException | IOException e) {
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
    }

}

