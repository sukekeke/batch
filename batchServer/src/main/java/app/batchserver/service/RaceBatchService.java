package app.batchserver.service;


import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.batchserver.dao.RaceInfoDao;

@Service
public class RaceBatchService {

    private static final Logger log = LoggerFactory.getLogger(RaceBatchService.class);

    private final RaceInfoDao raceInfoDao;

    public RaceBatchService(RaceInfoDao raceInfoDao) {
        this.raceInfoDao = raceInfoDao;
    }

    public void execute() {
        log.info("レースバッチ処理開始");

        int count = raceInfoDao.insert("大阪杯", LocalDate.of(2026, 4, 5));

        log.info("insert件数: {}", count);
        log.info("レースバッチ処理終了");
    }
}