package UpdateDB;


/**
 * Класс отвечающий за хранение - передачу из файла, ссылок на офисные комплектующие
 */

public class StorageUrlOffice extends StorageUrl{


    @Override
    protected String[] gpuUrl() {
        return gpu;
    }

    @Override
    protected String[] motherBoardUrl() {
        motherBoard = readerM.readerString("Storage\\URL\\OfficeURL\\MB.txt");
        return motherBoard;
    }

    @Override
    protected String[] ramUrl() {
        ram = readerM.readerString("Storage\\URL\\OfficeURL\\RAM.txt");
        return ram;
    }

    @Override
    protected String[] cpuUrl() {
        cpu = readerM.readerString("Storage\\URL\\OfficeURL\\CPU.txt");
        return cpu;
    }

    @Override
    protected String[] blockPowerUrl() {
        blockPower = readerM.readerString("Storage\\URL\\OfficeURL\\BlockPower.txt");
        return blockPower;
    }

    @Override
    protected String[] casePcUrl() {
        casePc = readerM.readerString("Storage\\URL\\OfficeURL\\case.txt");
        return casePc;
    }

    @Override
    protected String[] hddUrl() {
        return hdd;
    }

    @Override
    protected String[] ssdUrl() {
        ssd = readerM.readerString("Storage\\URL\\OfficeURL\\SSD.txt");
        return ssd;
    }

    @Override
    protected String[] coolingUrl() {
        cooling = readerM.readerString("Storage\\URL\\OfficeURL\\Cooling.txt");
        return cooling;
    }
}
