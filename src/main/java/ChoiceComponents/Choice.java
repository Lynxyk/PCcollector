package ChoiceComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс отвечающий за выбор комплектующих
 */

public class Choice {
    /**
     * поле minPrice - мин цена комплектующего
     */
    MinPriceComponent minPrice = new MinPriceComponent();
    /**
     * поле hierarchy - массивы с комплектующими определенного типа
     */
    HierarchyComponentPC hierarchy;

    /**
     * Функция отвечающий за выбор
     *
     * @param budget - бюджет, который вбил пользователь
     * @param typePc - тип ПК, который выбрал пользователь
     */
    public List<ComponentChoice> finalParts(int budget, String typePc) {
        List<ComponentChoice> list = new ArrayList<>();
        int hsrcI = 0;
        int cmcI = 0;
        int gpuI = 0;
        int bpI = 0;

        if (typePc.equals("Game PC")) {
            hierarchy = new HierarchyComponentGame();
        } else {
            hierarchy = new HierarchyComponentOffice();
        }
        int budgetAfter;

        for (int i = 0; i < 8; i++) {
            list.add(i, new ComponentChoice(0, 0));
        }

        ComponentChoice ccc;
        ComponentChoice ccm;
        ComponentChoice ccCool;
        ComponentChoice ccgpu = null;
        ComponentChoice ccBp;
        ComponentChoice ccs;
        ComponentChoice cch = null;
        ComponentChoice ccr;
        ComponentChoice ccCase;

        while (true) {
            budgetAfter = budget;

            if (typePc.equals("Game PC")) {
                ccc = newMinPrice(cmcI, hierarchy.hierarchyCpu(), "partspc.gamecpu", "model");
                ccm = newMinPrice(ccc.getNewIndex(), hierarchy.hierarchyMotherBoard(), "partspc.gamemotherboard", "chipset");
                ccCool = newMinPrice(cmcI, hierarchy.hierarchyCooling(), "partspc.gamecooling", "tdp");
                ccgpu = newMinPrice(gpuI, hierarchy.hierarchyGpu(), "partspc.gpugame", "GPU_line");
                ccBp = newMinPrice(bpI, hierarchy.hierarchyBlockPower(), "partspc.gamebp", "capacity");
                ccs = newMinPrice(hsrcI, hierarchy.hierarchySsd(), "partspc.gamessd", "volume");
                cch = newMinPrice(hsrcI, hierarchy.hierarchyHdd(), "partspc.gamehdd", "volume");
                ccr = newMinPrice(hsrcI, hierarchy.hierarchyRam(), "partspc.gameram", "volume");
                ccCase = newMinPrice(hsrcI, hierarchy.hierarchyCase(), "partspc.gamecase", "hierarchy");

                budgetAfter = budgetAfter - ccc.getPrice() - ccm.getPrice() - ccCool.getPrice() - ccgpu.getPrice()
                        - ccBp.getPrice() - ccs.getPrice() - cch.getPrice() - ccr.getPrice() - ccCase.getPrice();
            } else {
                ccc = newMinPrice(cmcI, hierarchy.hierarchyCpu(), "partspc.officecpu", "model");
                ccm = newMinPrice(ccc.getNewIndex(), hierarchy.hierarchyMotherBoard(), "partspc.officemotherboard", "chipset");
                ccCool = newMinPrice(cmcI, hierarchy.hierarchyCooling(), "partspc.officecooling", "tdp");
                ccBp = newMinPrice(bpI, hierarchy.hierarchyBlockPower(), "partspc.officebp", "capacity");
                ccs = newMinPrice(hsrcI, hierarchy.hierarchySsd(), "partspc.officessd", "volume");
                ccr = newMinPrice(hsrcI, hierarchy.hierarchyRam(), "partspc.officeram", "volume");
                ccCase = newMinPrice(hsrcI, hierarchy.hierarchyCase(), "partspc.officecase", "hierarchy");

                budgetAfter = budgetAfter - ccc.getPrice() - ccm.getPrice() - ccCool.getPrice() - ccBp.getPrice()
                        - ccs.getPrice() - ccr.getPrice() - ccCase.getPrice();
            }


            if (budgetAfter < 0) {
                break;
            } else {
                list.clear();
                list.add(0, ccc);
                list.add(1, ccm);
                list.add(2, ccCool);
                list.add(3, ccBp);
                list.add(4, ccs);
                list.add(5, ccr);
                list.add(6, ccCase);
                if (typePc.equals("Game PC")) {
                    list.add(7, ccgpu);
                    list.add(8, cch);
                }
            }

            if (hsrcI == hierarchy.hierarchyCpu().length - 1)
                break;

            if (hsrcI < hierarchy.hierarchyCpu().length - 1) {
                hsrcI++;
                cmcI++;
                gpuI++;
                bpI++;
            }

        }

        return list;
    }

    /**
     * Функция отвечающая за проверку налаичия и подбор в случае, если комплектующего нет в магазине
     *
     * @param index        - индекс
     * @param hierarchy    - комплектующие
     * @param table        - таблица
     * @param objectChoice - колонка выбора в БД
     */

    protected ComponentChoice newMinPrice(int index, String[] hierarchy, String table, String objectChoice) {

        int newPrice = minPrice.minPrice(table, objectChoice, hierarchy[index]);
        while (newPrice < 0 && index > 0) {
            index = index - 1;
            newPrice = minPrice.minPrice(table, objectChoice, hierarchy[index]);
        }
        while (newPrice < 0 && index < hierarchy.length - 1) {
            index = index + 1;
            newPrice = minPrice.minPrice(table, objectChoice, hierarchy[index]);
        }

        return new ComponentChoice(hierarchy[index], newPrice, index);
    }

    /**
     * Перегруженная функция отвечающая за проверку налаичия и подбор в случае, если комплектующего нет в магазине
     *
     * @param index        - индекс
     * @param hierarchy    - комплектующие
     * @param table        - таблица
     * @param objectChoice - колонка выбора в БД
     */

    protected ComponentChoice newMinPrice(int index, int[] hierarchy, String table, String objectChoice) {

        int newPrice = minPrice.minPrice(table, objectChoice, hierarchy[index]);
        while (newPrice < 0 && index > 0) {
            index = index - 1;
            newPrice = minPrice.minPrice(table, objectChoice, hierarchy[index]);
        }
        while (newPrice < 0 && index < hierarchy.length - 1) {
            index = index + 1;
            newPrice = minPrice.minPrice(table, objectChoice, hierarchy[index]);
        }

        return new ComponentChoice(hierarchy[index], newPrice, index);
    }
}
