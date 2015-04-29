package org.loccs.office.spreadsheet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

public class ApachePOIHSSFSheet extends Sheet {
    protected HSSFSheet sheet = null;

    public ApachePOIHSSFSheet() {
//begin of modifiable zone(JavaSuper).....C/fd30158a-a99d-4f1c-8243-e19fe63211ae

//end of modifiable zone(JavaSuper).......E/fd30158a-a99d-4f1c-8243-e19fe63211ae
//begin of modifiable zone(JavaCode)......C/fd30158a-a99d-4f1c-8243-e19fe63211ae

//end of modifiable zone(JavaCode)........E/fd30158a-a99d-4f1c-8243-e19fe63211ae
    }

    public ApachePOIHSSFSheet(HSSFSheet sheet) {
//begin of modifiable zone(JavaSuper).....C/381e63f6-e865-47e9-ae37-8db0779fd200

//end of modifiable zone(JavaSuper).......E/381e63f6-e865-47e9-ae37-8db0779fd200
//begin of modifiable zone................T/37f93f50-0776-4070-acde-93a371e84cbb
        this.sheet = sheet;
//end of modifiable zone..................E/37f93f50-0776-4070-acde-93a371e84cbb
    }

    @Override
    public Cell getCell(int row, int column) {
//begin of modifiable zone................T/1371f1f2-1769-4900-b4d8-1325e30a7912
        if (sheet == null)
            return null;
        
        HSSFRow hssfRow = sheet.getRow(row);
        if (hssfRow == null)
            hssfRow = sheet.createRow(row);
        if (hssfRow == null)
            return null;
        
        HSSFCell cell = hssfRow.getCell(column);
        if (cell == null)
            cell = hssfRow.createCell(column);
        if (cell == null)
            return null;
//end of modifiable zone..................E/1371f1f2-1769-4900-b4d8-1325e30a7912
//begin of modifiable zone................T/34ac9f14-47b2-42cc-847d-11e88811c638
        return new ApachePOIHSSFCell(cell);
//end of modifiable zone..................E/34ac9f14-47b2-42cc-847d-11e88811c638
    }

}
