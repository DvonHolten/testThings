package com.dvh.diffblue1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SalesProductTest {

    static final String VALID_UNSTOFFNR_4711 = "4711";
    static final String VALID_UNSTOFFNR_1202 = "1202";
    static final String VALID_UNSTOFFNR_1203 = "1203";

    @BeforeAll
    static void beforeAllMethod() {

    }

    @BeforeEach
    void beforeEachMethod(){

    }

    @AfterEach
    void afterEachMethod(){

    }

    @AfterAll
    static void afterAllMethod(){

    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link SalesProduct}
     *   <li>{@link SalesProduct#setProductCode(String)}
     *   <li>{@link SalesProduct#setProductName(String)}
     *   <li>{@link SalesProduct#setRecStatus(RecordStatus)}
     *   <li>{@link SalesProduct#setRowId(int)}
     *   <li>{@link SalesProduct#setUnStoffNr(String)}
     *   <li>{@link SalesProduct#toString()}
     *   <li>{@link SalesProduct#getProductCode()}
     *   <li>{@link SalesProduct#getProductName()}
     *   <li>{@link SalesProduct#getRecStatus()}
     *   <li>{@link SalesProduct#getRowId()}
     *   <li>{@link SalesProduct#getUnStoffNr()}
     * </ul>
     */
    @Test
    @DisplayName("some simple ctor test")
    void testConstructor() {
        // Arrange and Act
        SalesProduct actualSalesProduct = new SalesProduct();
        String productCode = "321";
        actualSalesProduct.setProductCode( productCode );
        String productName = "Product Name";
        actualSalesProduct.setProductName( productName );
        RecordStatus recStatus = new RecordStatus();
        recStatus.setFlagIsBlocked( true );
        recStatus
                .setLastModification( Date.from( LocalDate.of( 1970, 1, 1 ).atStartOfDay().atZone( ZoneOffset.UTC ).toInstant() ) );
        actualSalesProduct.setRecStatus( recStatus );
        int rowId = 1;
        actualSalesProduct.setRowId( rowId );
        String unStoffNr = VALID_UNSTOFFNR_4711;
        actualSalesProduct.setUnStoffNr( unStoffNr );
        actualSalesProduct.toString();

        // Assert that nothing has changed
        assertEquals( "321", actualSalesProduct.getProductCode() );
        assertEquals( "Product Name", actualSalesProduct.getProductName() );
        assertSame( recStatus, actualSalesProduct.getRecStatus() );
        assertEquals( 1, actualSalesProduct.getRowId() );
        assertEquals( VALID_UNSTOFFNR_4711, actualSalesProduct.getUnStoffNr() );
    }

    /**
     * Method under test: {@link SalesProduct#setProductCode(String)}
     */
    @Test
    void testSetProductCode_valid() {
        // Arrange
        SalesProduct salesProduct = new SalesProduct();
        String prodCode = "321";

        // Act and Assert
        assertDoesNotThrow( () -> {
            salesProduct.setProductCode( prodCode );
        } );

        assertThat( prodCode ).isEqualTo( "321" );
    }

    /**
     * Method under test: {@link SalesProduct#setProductCode(String)}
     */
    @Test
    void testSetProductCode() {
        // Arrange
        SalesProduct salesProduct = new SalesProduct();
        String invalid_prodCode = "Prod Code";

        // Act and Assert
        assertThrows( IllegalArgumentException.class,
                () -> salesProduct.setProductCode( invalid_prodCode ) );
    }

    /**
     * Method under test: {@link SalesProduct#setProductCode(String)}
     */
    @Test
    void testSetProductCode2() {
        // Arrange
        SalesProduct salesProduct = new SalesProduct();
        String prodCode = null;

        // Act and Assert
        assertThrows( IllegalArgumentException.class, () -> salesProduct.setProductCode( prodCode ) );
    }

    /**
     * Method under test: {@link SalesProduct#setProductCode(String)}
     */
    @Test
    void testSetProductCode3() {
        // Arrange
        SalesProduct salesProduct = new SalesProduct();
        String prodCode = "42";

        // Act and Assert
        assertThrows( IllegalArgumentException.class, () -> salesProduct.setProductCode( prodCode ) );
    }

    /**
     * Method under test: {@link SalesProduct#setUnStoffNr(String)}
     */
    @Test
    @DisplayName("simple test with valid UNStoffNr '1202' : OK")
    void testSetUnStoffNr_valid() {
        // Arrange
        SalesProduct salesProduct = new SalesProduct();
        List<String> validUnStoffNrLst
                = List.of( VALID_UNSTOFFNR_1202, VALID_UNSTOFFNR_1203);

        for( String newUNStoffNr : validUnStoffNrLst ){
            salesProduct.setUnStoffNr( newUNStoffNr );
            assertThat( salesProduct.getUnStoffNr() ).isEqualTo( newUNStoffNr );
        }
    }

    /**
     * Method under test: {@link SalesProduct#setUnStoffNr(String)}
     */
    @Test
    @DisplayName("simple test with invalid UNStoffNr 'New UNStoff Nr' is not numeric : FAIL")
    void testSetUnStoffNr() {
        // Arrange
        SalesProduct salesProduct = new SalesProduct();
        String newUNStoffNr = "New UNStoff Nr";

        // Act and Assert
        assertThrows( IllegalArgumentException.class, () -> salesProduct.setUnStoffNr( newUNStoffNr ) );
    }

    /**
     * Method under test: {@link SalesProduct#setUnStoffNr(String)}
     */
    @Test
    @DisplayName("simple test with invalid UNStoffNr null : FAIL")
    void testSetUnStoffNr_is_null() {
        // Arrange
        SalesProduct salesProduct = new SalesProduct();
        String newUNStoffNr = null;

        // Act and Assert
        assertThrows( IllegalArgumentException.class, () -> salesProduct.setUnStoffNr( newUNStoffNr ) );
    }

    /**
     * Method under test: {@link SalesProduct#setUnStoffNr(String)}
     */
    @Test
    @DisplayName("simple test with invalid UNStoffNr '42' : FAIL")
    void testSetUnStoffNr_too_short() {
        // Arrange
        SalesProduct salesProduct = new SalesProduct();
        String newUNStoffNr = "42";

        // Act and Assert
        assertThrows( IllegalArgumentException.class, () -> salesProduct.setUnStoffNr( newUNStoffNr ) );
    }

    /**
     * Method under test: {@link SalesProduct#getIsBlocked()}
     */
    @Test
    void testGetIsBlocked() {
        // Arrange
        SalesProduct salesProduct = new SalesProduct();

        // Act
        boolean actualIsBlocked = salesProduct.getIsBlocked();

        // Assert
        assertTrue( actualIsBlocked );
    }

    /**
     * Method under test: {@link SalesProduct#getIsBlocked()}
     */
    @Test
    void testGetIsBlocked2() {
        // Arrange
        RecordStatus recStatus = new RecordStatus();
        recStatus.setFlagIsBlocked( false );
        recStatus
                .setLastModification( Date.from( LocalDate.of( 1970, 1, 1 ).atStartOfDay().atZone( ZoneOffset.UTC ).toInstant() ) );

        SalesProduct salesProduct = new SalesProduct();
        salesProduct.setRecStatus( recStatus );

        // Act
        boolean actualIsBlocked = salesProduct.getIsBlocked();

        // Assert
        assertFalse( actualIsBlocked );
    }

    /**
     * Method under test: {@link SalesProduct#getIsBlocked()}
     */
    @Test
    void testGetIsBlocked3() {
        // Arrange
        RecordStatus recStatus = new RecordStatus();
        recStatus.setFlagIsBlocked( false );
        recStatus.setLastModification( mock( java.sql.Date.class ) );

        SalesProduct salesProduct = new SalesProduct();
        salesProduct.setRecStatus( recStatus );

        // Act
        boolean actualIsBlocked = salesProduct.getIsBlocked();

        // Assert
        assertFalse( actualIsBlocked );
    }
}

