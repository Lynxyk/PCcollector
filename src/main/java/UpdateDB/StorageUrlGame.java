package UpdateDB;


/**
 * Класс отвечающий за хранение - передачу из файла, ссылок на офисные комплектующие
 */

public class StorageUrlGame extends StorageUrl{

    @Override
    protected String[] gpuUrl() {
        gpu = readerM.readerString("Storage\\URL\\GameURL\\GPU.txt");
        return gpu;
    }

    @Override
    protected String[] motherBoardUrl() {
        motherBoard = readerM.readerString("Storage\\URL\\GameURL\\MB.txt");
        return motherBoard;
    }

    @Override
    protected String[] ramUrl() {
        ram = readerM.readerString("Storage\\URL\\GameURL\\RAM.txt");
        return ram;
    }

    @Override
    protected String[] cpuUrl() {
        cpu = readerM.readerString("Storage\\URL\\GameURL\\CPU.txt");
        return cpu;
    }

    @Override
    protected String[] blockPowerUrl() {
        blockPower = readerM.readerString("Storage\\URL\\GameURL\\BlockPower.txt");
        return blockPower;
    }

    @Override
    protected String[] casePcUrl() {
        casePc = readerM.readerString("Storage\\URL\\GameURL\\case.txt");
        return casePc;
    }

    @Override
    protected String[] hddUrl() {
        hdd = readerM.readerString("Storage\\URL\\GameURL\\HDD.txt");
        return hdd;
    }

    @Override
    protected String[] ssdUrl() {
        ssd = readerM.readerString("Storage\\URL\\GameURL\\SSD.txt");
        return ssd;
    }

    @Override
    protected String[] coolingUrl() {
        cooling = readerM.readerString("Storage\\URL\\GameURL\\Cooling.txt");
        return cooling;
    }

}
