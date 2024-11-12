package ChoiceComponents;

import Reader.ReaderM;

/**
 * Класс - шаблон для HierarchyComponentGame и HierarchyComponentOffice
 */

public abstract class HierarchyComponentPC {
    /** поле readerM - отвечает за чтение и создание массива из файла*/
    ReaderM readerM = new ReaderM();
    /** поле min - мин. цена комплектующего */
    Choice min = new Choice();
    protected abstract String[] hierarchyCpu();
    protected String[] hierarchyGpu() {
        return (new String[0]);
    }
    protected int[] hierarchyHdd() {
        return (new int[0]);
    }
    protected abstract String[] hierarchyMotherBoard();
    protected abstract int[] hierarchySsd();
    protected abstract int[] hierarchyRam();
    protected abstract int[] hierarchyBlockPower();
    protected abstract int[] hierarchyCase();
    protected abstract String[] hierarchyCooling();
    /** Функция отвечающая за мин. бюджет определенного ПК*/
    public abstract int minBudget();
}
