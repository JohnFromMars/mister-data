package misterdata.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Queue;

@Repository
public class TrxIdDao {
    @Autowired
    RedissonClient client;
    Logger log = LogManager.getLogger();

    public void save(String tid){
        Queue<String> queue = client.getQueue("tid");
        queue.offer(tid);
        log.info("put tid:{} into queue", tid);
    }

    public String findAny(){
        Queue<String> queue = client.getQueue("tid");
        return queue.poll();
    }
}
