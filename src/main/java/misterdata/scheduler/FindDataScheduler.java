package misterdata.scheduler;

import misterdata.dao.DataDao;
import misterdata.dao.TrxIdDao;
import misterdata.model.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FindDataScheduler {

    @Autowired
    TrxIdDao trxIdDao;
    @Autowired
    DataDao dataDao;

    Logger log = LogManager.getLogger();

    @Scheduled(fixedRate = 1000)
    public void findData() {
        Data tid = dataDao.findAny();
        if (tid != null) {
            log.info("Get data:{} from redis", tid);
        }
    }

}


