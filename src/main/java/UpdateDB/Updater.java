package UpdateDB;

/**
 * Класс отвечающий за запуск потоков, обнавляющих цены и наличие определенных типов комплектующих в БД, в
 * зависимости от выбранного типа пк пользователем
 */

public class Updater {

    StorageUrl storageUrl;

    public String update(String typePc) {
        if (typePc.equals("Game PC")) {
            storageUrl = new StorageUrlGame();
            UpdaterDB upadterDBgpu = new UpdaterDB("GPU_id", storageUrl.gpuUrl(), "gpugame");
            upadterDBgpu.start();
            UpdaterDB upadterDBblock = new UpdaterDB("BP_id", storageUrl.blockPowerUrl(), "gamebp");
            upadterDBblock.start();
            UpdaterDB updaterDBmotherboard = new UpdaterDB("board_id", storageUrl.motherBoardUrl(), "gamemotherboard");
            updaterDBmotherboard.start();
            UpdaterDB updaterDBssd = new UpdaterDB("ssd_id", storageUrl.ssdUrl(), "gamessd");
            updaterDBssd.start();
            UpdaterDB updaterDBRam = new UpdaterDB("ram_id", storageUrl.ramUrl(), "gameram");
            updaterDBRam.start();
            UpdaterDB updaterDBhdd = new UpdaterDB("hdd_id", storageUrl.hddUrl(), "gamehdd");
            updaterDBhdd.start();
            UpdaterDB updaterDBcpu = new UpdaterDB("cpu_id", storageUrl.cpuUrl(), "gamecpu");
            updaterDBcpu.start();
            UpdaterDB updaterDBcooling = new UpdaterDB("cooling_id", storageUrl.coolingUrl(), "gamecooling");
            updaterDBcooling.start();
            UpdaterDB updaterDBcase = new UpdaterDB("case_id", storageUrl.casePcUrl(), "gamecase");
            updaterDBcase.start();
            try {
                updaterDBcase.join();
                updaterDBcooling.join();
                updaterDBcpu.join();
                updaterDBcooling.join();
                updaterDBRam.join();
                updaterDBssd.join();
                upadterDBblock.join();
                upadterDBgpu.join();
                updaterDBhdd.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            return "готово";
        } else {
            storageUrl = new StorageUrlOffice();
            UpdaterDB upadterDBblock = new UpdaterDB("bp_id", storageUrl.blockPowerUrl(), "officebp");
            upadterDBblock.start();
            UpdaterDB updaterDBmotherboard = new UpdaterDB("mb_id", storageUrl.motherBoardUrl(), "officemotherboard");
            updaterDBmotherboard.start();
            UpdaterDB updaterDBssd = new UpdaterDB("ssd_id", storageUrl.ssdUrl(), "officessd");
            updaterDBssd.start();
            UpdaterDB updaterDBRam = new UpdaterDB("ram_id", storageUrl.ramUrl(), "officeram");
            updaterDBRam.start();
            UpdaterDB updaterDBcpu = new UpdaterDB("cpu_id", storageUrl.cpuUrl(), "officecpu");
            updaterDBcpu.start();
            UpdaterDB updaterDBcooling = new UpdaterDB("cooling_id", storageUrl.coolingUrl(), "officecooling");
            updaterDBcooling.start();
            UpdaterDB updaterDBcase = new UpdaterDB("case_id", storageUrl.casePcUrl(), "officecase");
            updaterDBcase.start();
            try {
                updaterDBcase.join();
                updaterDBcooling.join();
                updaterDBcpu.join();
                updaterDBcooling.join();
                updaterDBRam.join();
                updaterDBssd.join();
                upadterDBblock.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            return "готово";
        }
    }
}
