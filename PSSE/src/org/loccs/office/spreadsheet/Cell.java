package org.loccs.office.spreadsheet;


public abstract class Cell {
    public Cell() {
//begin of modifiable zone(JavaSuper).....C/e8aca984-394a-410b-a3d3-323301c248a4

//end of modifiable zone(JavaSuper).......E/e8aca984-394a-410b-a3d3-323301c248a4
//begin of modifiable zone(JavaCode)......C/e8aca984-394a-410b-a3d3-323301c248a4

//end of modifiable zone(JavaCode)........E/e8aca984-394a-410b-a3d3-323301c248a4
    }

    public abstract String getStringValue();

    public abstract double getNumericValue();

    public abstract boolean setStringValue(String value);

    public abstract boolean setNumericValue(double value);

}
