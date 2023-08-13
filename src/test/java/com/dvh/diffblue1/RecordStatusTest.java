package com.dvh.diffblue1;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;

class RecordStatusTest {

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RecordStatus}
     *   <li>{@link RecordStatus#setFlagIsBlocked(boolean)}
     *   <li>{@link RecordStatus#setLastModification(Date)}
     *   <li>{@link RecordStatus#getLastModification()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        RecordStatus actualRecordStatus = new RecordStatus();
        boolean flagIsBlocked = true;
        actualRecordStatus.setFlagIsBlocked( flagIsBlocked );
        Date lastModification = Date.from( LocalDate.of( 1970, 1, 1 ).atStartOfDay().atZone( ZoneOffset.UTC ).toInstant() );
        actualRecordStatus.setLastModification( lastModification );

        // Assert
        assertSame( lastModification, actualRecordStatus.getLastModification() );
    }

    /**
     * Method under test: default or parameterless constructor of {@link RecordStatus}
     */
    @Test
    void testConstructor2() {
        // Arrange and Act
        RecordStatus actualRecordStatus = new RecordStatus();

        // Assert
        Date expectedLastModification = actualRecordStatus.lastModification;
        assertSame( expectedLastModification, actualRecordStatus.getLastModification() );
        assertTrue( actualRecordStatus.flagIsBlocked );
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link RecordStatus}
     *   <li>{@link RecordStatus#setLastModification(Date)}
     * </ul>
     */
    @Test
    void testConstructor3() {
        // Arrange and Act
        RecordStatus actualRecordStatus = new RecordStatus();
        Date lastModification = Date.from( LocalDate.of( 1970, 1, 1 ).atStartOfDay().atZone( ZoneOffset.UTC ).toInstant() );
        actualRecordStatus.setLastModification( lastModification );

        // Assert
        assertSame( lastModification, actualRecordStatus.getLastModification() );
    }
}

