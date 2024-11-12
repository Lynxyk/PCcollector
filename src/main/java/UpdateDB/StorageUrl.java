package UpdateDB;

import Reader.ReaderM;

/** Абстрактный класс - шаблон для StorageUrlGame и StorageUrlOffice*/

public abstract class StorageUrl {
    /** 9 полей с определенным типом комплектующего - каждое хранит ссылки из файла */
    protected String[] gpu;
    protected String[] motherBoard;
    protected String[] ram;
    protected String[] cpu;
    protected String[] blockPower;
    protected String[] casePc;
    protected String[] hdd;
    protected String[] ssd;
    protected String[] cooling;
    /** поле readerM - отвечает за чтение и создание массива из файла*/
    ReaderM readerM = new ReaderM();

    protected abstract String[] gpuUrl();
    protected abstract String[] motherBoardUrl();
    protected abstract String[] ramUrl();
    protected abstract String[] cpuUrl();
    protected abstract String[] blockPowerUrl();
    protected abstract String[] casePcUrl();
    protected abstract String[] hddUrl();
    protected abstract String[] ssdUrl();
    protected abstract String[] coolingUrl();
}
