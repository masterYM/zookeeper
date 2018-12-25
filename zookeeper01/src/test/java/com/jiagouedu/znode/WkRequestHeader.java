package com.jiagouedu.znode;

import org.apache.jute.InputArchive;
import org.apache.jute.OutputArchive;
import org.apache.jute.Record;

import java.util.Arrays;

public class WkRequestHeader implements Record {
    private int protocolVersion;
    private long lastZxidSeen;
    private int timeOut;
    private long sessionId;
    private byte[] passwd;


    public WkRequestHeader() {

    }


    public void serialize(OutputArchive oa, String tag) throws java.io.IOException {
      /*  oa.startRecord(this, tag);
        oa.writeLong(sessionId, "sessionId");
        oa.writeString(type, "type");
        oa.endRecord(this, tag);*/
    }
    
    public void deserialize(InputArchive ia, String tag) throws java.io.IOException {
        ia.startRecord(tag);
        protocolVersion=ia.readInt("protocolVersion");
        lastZxidSeen=ia.readLong("lastZxidSeen");
        timeOut=ia.readInt("timeOut");
        sessionId=ia.readLong("sessionId");
        passwd=ia.readBuffer("passwd");
        ia.endRecord(tag);
    }

    @Override
    public String toString() {
        return "WkRequestHeader{" +
                "protocolVersion=" + protocolVersion +
                ", lastZxidSeen=" + lastZxidSeen +
                ", timeOut=" + timeOut +
                ", sessionId=" + sessionId +
                ", passwd=" + Arrays.toString(passwd) +
                '}';
    }
}