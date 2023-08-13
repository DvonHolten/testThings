package com.dvh.diffblue1;

import org.jetbrains.annotations.*;

public class SalesProduct
        implements ISalesProduct {

    public static final String NULL_SALES_PRODUCT_CODE = "000";

    int rowId = -1;

    /**
     * Must be 3 digits
     */
    String productCode;

    String productName;

    /**
     * the UNStoffNr is a 4-digit code
     */
    String unStoffNr;

    private RecordStatus recStatus = new RecordStatus();

    public SalesProduct() {
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId( int rowId ) {
        this.rowId = rowId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode( @NotNull String prodCode ) {

        try {
            int i = Integer.parseInt( prodCode );

            if ( 100 <= i && i <= 999 ) {
                // 3 digits is ok
            } else {
                throw new IllegalArgumentException( "prodCode must be 3 digit! is:" + prodCode);
            }
        } catch (NumberFormatException nfExc ) {
            throw new IllegalArgumentException( "prodCode must be numeric! is:" + prodCode);
        }
        productCode = prodCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName( String productName ) {
        this.productName = productName;
    }

    public String getUnStoffNr() {
        return unStoffNr;
    }

    public void setUnStoffNr( @NotNull String newUNStoffNr ) {
        try {
            if ( newUNStoffNr == null ) {
                throw new IllegalArgumentException("UN-StoffNr must note null!");
            }

            int i = Integer.parseInt( newUNStoffNr );

            if ( 1000 <= i && i <= 9999 ) {
                // 3 digits is ok
            } else {
                throw new IllegalArgumentException( "UN-StoffNr must be 4 digit! is:" + newUNStoffNr);
            }
        } catch (NumberFormatException nfExc ) {
            throw new IllegalArgumentException( "UN-StoffNr must be numeric! is:" + newUNStoffNr);
        }
        unStoffNr = newUNStoffNr;
    }

    public RecordStatus getRecStatus() {
        return recStatus;
    }

    public void setRecStatus( RecordStatus recStatus ) {
        this.recStatus = recStatus;
    }

    public boolean getIsBlocked(){
        return recStatus.flagIsBlocked;
    }

    public void setIsBlocked( boolean flagBlock ){
        recStatus.flagIsBlocked = flagBlock;
    }

    @Override
    public String toString() {
        return "SalesProduct{" +
                "rowId=" + rowId +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", unStoffNr='" + unStoffNr + '\'' +
                ", recStatus=" + recStatus +
                '}';
    }
}
