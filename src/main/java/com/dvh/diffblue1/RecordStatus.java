package com.dvh.diffblue1;

import java.time.Instant;
import java.util.Date;


public class RecordStatus {


    boolean flagIsBlocked = true;

    Date lastModification = Date.from( Instant.now() );

    public RecordStatus() {
    }

    public void setFlagIsBlocked( boolean flagIsBlocked ) {
        this.flagIsBlocked = flagIsBlocked;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification( Date lastModification ) {
        this.lastModification = lastModification;
    }
}
