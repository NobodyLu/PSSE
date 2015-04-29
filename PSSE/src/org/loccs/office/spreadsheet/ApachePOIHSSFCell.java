package org.loccs.office.spreadsheet;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class ApachePOIHSSFCell extends Cell {
    protected HSSFCell cell = null;

    public ApachePOIHSSFCell() {
//begin of modifiable zone(JavaSuper).....C/e97fed05-7eb8-42d7-9af9-2a8d946eab8c

//end of modifiable zone(JavaSuper).......E/e97fed05-7eb8-42d7-9af9-2a8d946eab8c
//begin of modifiable zone(JavaCode)......C/e97fed05-7eb8-42d7-9af9-2a8d946eab8c

//end of modifiable zone(JavaCode)........E/e97fed05-7eb8-42d7-9af9-2a8d946eab8c
    }

    public ApachePOIHSSFCell(HSSFCell cell) {
//begin of modifiable zone(JavaSuper).....C/bc0d9439-ffa6-45cb-9547-d1e219e6c585

//end of modifiable zone(JavaSuper).......E/bc0d9439-ffa6-45cb-9547-d1e219e6c585
//begin of modifiable zone................T/4987ea53-3580-402d-9be5-b2b31ba3024a
        this.cell = cell;
//end of modifiable zone..................E/4987ea53-3580-402d-9be5-b2b31ba3024a
    }

    @Override
    public String getStringValue() {
//begin of modifiable zone................T/0492f8f4-78f2-4666-a668-0adb0272f617
        if (cell == null)
            return null;
        else
            return cell.getStringCellValue();
//end of modifiable zone..................E/0492f8f4-78f2-4666-a668-0adb0272f617
//begin of modifiable zone(JavaReturned)..C/53727d52-45a7-4b0e-8c0c-b7464ae099df

//end of modifiable zone(JavaReturned)....E/53727d52-45a7-4b0e-8c0c-b7464ae099df
    }

    @Override
    public double getNumericValue() {
//begin of modifiable zone................T/8acaef79-21c4-4ee1-abba-03d2a3fc4537
        if (cell == null)
            return 0;
        else
            return cell.getNumericCellValue();
//end of modifiable zone..................E/8acaef79-21c4-4ee1-abba-03d2a3fc4537
//begin of modifiable zone(JavaReturned)..C/d3204708-7239-46aa-b577-266a4667e628

//end of modifiable zone(JavaReturned)....E/d3204708-7239-46aa-b577-266a4667e628
    }

    @Override
    public boolean setStringValue(String value) {
//begin of modifiable zone................T/a628bc33-ccc7-4780-ba53-f22a5fe030dd
        if (cell == null)
        {
            return false;
        }else
        {
            cell.setCellValue(value);
            return true;
        }
//end of modifiable zone..................E/a628bc33-ccc7-4780-ba53-f22a5fe030dd
//begin of modifiable zone(JavaReturned)..C/2fd6b6da-c324-4fdc-89ed-f1fdc4fb0767

//end of modifiable zone(JavaReturned)....E/2fd6b6da-c324-4fdc-89ed-f1fdc4fb0767
    }

    @Override
    public boolean setNumericValue(double value) {
//begin of modifiable zone................T/22a28354-bc84-4390-a42f-c3419f0567cd
        if (cell == null)
        {
            return false;
        }else
        {
            cell.setCellValue(value);
            return true;
        }
//end of modifiable zone..................E/22a28354-bc84-4390-a42f-c3419f0567cd
//begin of modifiable zone(JavaReturned)..C/3220d630-c9cd-43e4-a691-89187eb3f687

//end of modifiable zone(JavaReturned)....E/3220d630-c9cd-43e4-a691-89187eb3f687
    }

}
