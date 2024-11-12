package ChoiceComponents;

/**
 * Класс отвечающий за хранение - передачу из файла, комплектующих на офисные комплектующие
 */

public class HierarchyComponentOffice extends HierarchyComponentPC {
    @Override
    protected String[] hierarchyCpu() {
        String[] hierarchy = readerM.readerString("Storage\\Assembly\\OfficeAssembly\\CPU.txt");
        return hierarchy;
    }
    @Override
    protected String[] hierarchyMotherBoard() {
        String[] hierarchy = readerM.readerString("Storage\\Assembly\\OfficeAssembly\\MB.txt");
        return hierarchy;
    }
    @Override
    protected int[] hierarchySsd() {
        int[] hierarchy = readerM.readerInt("Storage\\Assembly\\OfficeAssembly\\SSD.txt");
        return hierarchy;
    }
    @Override
    protected int[] hierarchyRam() {
        int[] hierarchy = readerM.readerInt("Storage\\Assembly\\OfficeAssembly\\RAM.txt");
        return hierarchy;
    }
    @Override
    protected int[] hierarchyBlockPower() {
        int[] hierarchy = readerM.readerInt("Storage\\Assembly\\OfficeAssembly\\BlockPower.txt");
        return hierarchy;
    }
    @Override
    protected int[] hierarchyCase() {
        int[] hierarchy = readerM.readerInt("Storage\\Assembly\\OfficeAssembly\\case.txt");
        return hierarchy;
    }
    @Override
    protected String[] hierarchyCooling() {
        String[] hierarchy = readerM.readerString("Storage\\Assembly\\OfficeAssembly\\Cooling.txt");
        return hierarchy;
    }

    /** Функция отвечающая за мин. бюджет офисного ПК*/

    @Override
    public int minBudget() {
        int budget = min.newMinPrice(0,hierarchyCpu(),"partspc.officecpu", "model").getPrice()
                + min.newMinPrice(0, hierarchyMotherBoard(),"partspc.officemotherboard", "chipset").getPrice()
                + min.newMinPrice(0, hierarchyCooling(), "partspc.officecooling", "tdp").getPrice()
                + min.newMinPrice(0, hierarchyBlockPower(), "partspc.officebp", "capacity").getPrice()
                + min.newMinPrice(0, hierarchySsd(), "partspc.officessd", "volume").getPrice()
                + min.newMinPrice(0, hierarchyRam(),"partspc.officeram", "volume").getPrice()
                + min.newMinPrice(0, hierarchyCase(),"partspc.officecase", "hierarchy").getPrice();
        return budget;
    }
}
