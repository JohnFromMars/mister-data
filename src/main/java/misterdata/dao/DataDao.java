package misterdata.dao;

import com.google.gson.Gson;
import misterdata.model.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

    @Autowired
    RedissonClient client;
    Logger log = LogManager.getLogger();

    //    public void save(Data data) {
//        RQueue<String> queue = client.getQueue("data-queue");
//        Gson gson = new Gson();
//        String dataJson = gson.toJson(data);
//        log.info("put to queue...");
//        queue.offer(dataJson);
//    }
//
    public Data findAny() {

        RQueue<String> queue = client.getQueue("data-json-queue");
        String dataJson = queue.poll();
        Data result = null;

        if (dataJson != null) {
            Gson gson = new Gson();
            result = gson.fromJson(dataJson, Data.class);
        }

        return result;
    }
}
