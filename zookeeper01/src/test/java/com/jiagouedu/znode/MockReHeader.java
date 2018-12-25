package com.jiagouedu.znode;

import org.apache.jute.InputArchive;
import org.apache.jute.OutputArchive;
import org.apache.jute.Record;

public class MockReHeader implements Record {
    private long sessionId;
    private String type;


    public MockReHeader() {
        
    }
    
    public MockReHeader(long sessionId, String type) {
        this.sessionId = sessionId;
        this.type = type;
    }
    
    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public long getSessionId() {
        return sessionId;
    }

    public String getType() {
        return type;
    }

    public void serialize(OutputArchive oa, String tag) throws java.io.IOException {
        oa.startRecord(this, tag);
        oa.writeLong(sessionId, "sessionId");
        oa.writeString(type, "type");
        oa.endRecord(this, tag);
    }
    
    public void deserialize(InputArchive ia, String tag) throws java.io.IOException {
        ia.startRecord(tag);
        this.sessionId = ia.readLong("sessionId");
        this.type = ia.readString("type");
        ia.endRecord(tag);
    }

    @Override
    public String toString() {
        return "sessionId = " + sessionId + ", type = " + type;
    }
}