package misterdata.service;

import misterdata.dao.TrxIdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrxIdService {
    @Autowired
    TrxIdDao trxIdDao;

    public void save(String tid) {
        trxIdDao.save(tid);
    }
}



