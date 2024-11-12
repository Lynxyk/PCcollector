package ChoiceComponents;

/**
 * Класс отвечающий за хранение - передачу из файла, комплектующих на игровые комплектующие
 */

public class HierarchyComponentGame extends HierarchyComponentPC{
    @Override
    protected String[] hierarchyCpu() {
        String[] hierarchy = readerM.readerString("Storage\\Assembly\\GameAssembly\\CPU.txt");
        return hierarchy;
    }
    @Override
    protected String[] hierarchyGpu() {
        String[] hierarchy = readerM.readerString("Storage\\Assembly\\GameAssembly\\GPU.txt");
        return hierarchy;
    }
    @Override
    protected String[] hierarchyMotherBoard() {
        String[] hierarchy = readerM.readerString("Storage\\Assembly\\GameAssembly\\MB.txt");
        return hierarchy;
    }
    @Override
    protected int[] hierarchyHdd() {
        int[] hierarchy = readerM.readerInt("Storage\\Assembly\\GameAssembly\\HDD.txt");
        return hierarchy;
    }
    @Override
    protected int[] hierarchySsd() {
        int[] hierarchy = readerM.readerInt("Storage\\Assembly\\GameAssembly\\SSD.txt");
        return hierarchy;
    }
    @Override
    protected int[] hierarchyRam() {
        int[] hierarchy = readerM.readerInt("Storage\\Assembly\\GameAssembly\\RAM.txt");
        return hierarchy;
    }
    @Override
    protected int[] hierarchyBlockPower() {
        int[] hierarchy = readerM.readerInt("Storage\\Assembly\\GameAssembly\\BlockPower.txt");
        return hierarchy;
    }
    @Override
    protected int[] hierarchyCase() {
        int[] hierarchy = readerM.readerInt("Storage\\Assembly\\GameAssembly\\case.txt");
        return hierarchy;
    }
    @Override
    protected String[] hierarchyCooling() {
        String[] hierarchy = readerM.readerString("Storage\\Assembly\\GameAssembly\\Cooling.txt");
        return hierarchy;
    }

    /** Функция отвечающая за мин. бюджет игрового ПК*/

    @Override
    public int minBudget() {
        int budget = min.newMinPrice(0,hierarchyCpu(),"partspc.gamecpu", "model").getPrice()
                + min.newMinPrice(0, hierarchyMotherBoard(),"partspc.gamemotherboard", "chipset").getPrice()
                + min.newMinPrice(0, hierarchyCooling(), "partspc.gamecooling", "tdp").getPrice()
                + min.newMinPrice(0, hierarchyBlockPower(), "partspc.gamebp", "capacity").getPrice()
                + min.newMinPrice(0, hierarchySsd(), "partspc.gamessd", "volume").getPrice()
                + min.newMinPrice(0, hierarchyRam(),"partspc.gameram", "volume").getPrice()
                + min.newMinPrice(0, hierarchyCase(),"partspc.gamecase", "hierarchy").getPrice()
                + min.newMinPrice(0, hierarchyGpu(), "partspc.gpugame", "GPU_line").getPrice()
                + min.newMinPrice(0,hierarchyHdd(), "partspc.gamehdd", "volume").getPrice();

        return budget;
    }
}
