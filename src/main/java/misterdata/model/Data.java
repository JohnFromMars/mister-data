package misterdata.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@lombok.Data
public class Data implements Serializable {
    private String uuid = UUID.randomUUID().toString();
    private Date date;
}
