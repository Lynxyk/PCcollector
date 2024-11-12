package ChoiceComponents;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Класс отвечающий за выдачу полных характеристик выбра*/

public class FinalAssembly<ObjectChoice> {
    /** поле URL  - хост БД */
    private final String URL = "jdbc:mysql://localhost:3306/partspc?useSSL=false";
    /** поле LOGIN - логин БД */
    private final String LOGIN = "root";
    /** поле PASSWORD - пароль БД*/
    private final String PASSWORD = "root";

    /** Функция отвечающая за передачу Листа с полными характеристиками
     * @param budget - бюджет
     * @param typePC - тип пк
     */

    public List<ComponentChoice> assemblyFullName(int budget, String typePC) {
        Choice choice = new Choice();
        List<ComponentChoice> list = choice.finalParts(budget, typePC);
        List<ComponentChoice> listNew = new ArrayList<>();

        String way = typePC.equals("Game PC") ? ("partspc.game") : ("partspc.office");

        listNew.add(0, assembly(way + "cpu", list.get(0), "model"));
        listNew.add(1, assembly(way + "motherboard", list.get(1), "chipset"));
        listNew.add(2, assembly(way + "cooling", list.get(2), "tdp"));
        listNew.add(3, assembly(way + "bp", list.get(3), "capacity"));
        listNew.add(4, assembly(way + "ssd", list.get(4), "volume"));
        listNew.add(5, assembly(way + "ram", list.get(5), "volume"));
        listNew.add(6, assembly(way + "case", list.get(6), "hierarchy"));
        if (typePC.equals("Game PC")) {
            listNew.add(7, assembly("partspc.gpugame", list.get(7), "GPU_line"));
            listNew.add(8, assembly("partspc.gamehdd", list.get(8), "volume"));
        }

        return listNew;
    }

    /** Функция отвечающая за взаимодействие с БД и выдачу полных характеристик, выбраных комплектующих
     * @param table - таблица
     * @param choice - колонка в таблице
     * @param сс - объект с мин. характеристиками
     */

    private ComponentChoice assembly(String table, ComponentChoice сс, String choice) {
        String GET_ALL = "SELECT mark, model FROM " + table + " WHERE price = " + сс.getPrice() + " and " + choice + " = " + сс.getModel() + ";";


        Connection connection = null;
        PreparedStatement statement = null;
        ComponentChoice componentChoice = null;


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(GET_ALL);

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                String mark = resultSet.getString(1);
                String model = resultSet.getString(2);
                componentChoice = new ComponentChoice(сс.getPrice(), сс.getModel(), mark, model);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if ( connection != null)
                connection.close();
                if (statement != null)
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return componentChoice;

    }

}
