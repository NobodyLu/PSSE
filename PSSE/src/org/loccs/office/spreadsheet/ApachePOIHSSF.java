package org.loccs.office.spreadsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ApachePOIHSSF extends SpreadSheet {
    protected String filename = "";

    protected HSSFWorkbook workbook;

    public ApachePOIHSSF() {
//begin of modifiable zone(JavaSuper).....C/c4f5d581-c024-4055-8f3e-68a48e816e30

//end of modifiable zone(JavaSuper).......E/c4f5d581-c024-4055-8f3e-68a48e816e30
//begin of modifiable zone(JavaCode)......C/c4f5d581-c024-4055-8f3e-68a48e816e30

//end of modifiable zone(JavaCode)........E/c4f5d581-c024-4055-8f3e-68a48e816e30
    }

    @Override
    public boolean create() {
//begin of modifiable zone................T/237d0ed6-8324-43f9-9c0f-e6aaca74b639
        workbook = new HSSFWorkbook();
        workbook.createSheet("sheet1");
//end of modifiable zone..................E/237d0ed6-8324-43f9-9c0f-e6aaca74b639
//begin of modifiable zone................T/9e7df2e7-ea95-4a9f-bc52-be56aec002fb
        return true;
//end of modifiable zone..................E/9e7df2e7-ea95-4a9f-bc52-be56aec002fb
    }

    @Override
    public boolean open(String filename) {
//begin of modifiable zone................T/293995a7-4dc3-4542-97ee-571928a035e3
        try {
            
            FileInputStream file = new FileInputStream(new File(filename));
            workbook = new HSSFWorkbook(file);
            this.filename = filename;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
//end of modifiable zone..................E/293995a7-4dc3-4542-97ee-571928a035e3
//begin of modifiable zone................T/32be590f-20f6-4e27-935e-bd691d2691b8
        return true;
//end of modifiable zone..................E/32be590f-20f6-4e27-935e-bd691d2691b8
    }

    @Override
    public int getSheetCount() {
//begin of modifiable zone................T/ca8e32e7-e0db-40c4-951a-deaf67ec402e
        if (workbook != null)
            return workbook.getNumberOfSheets();
        else
            return 0;
//end of modifiable zone..................E/ca8e32e7-e0db-40c4-951a-deaf67ec402e
//begin of modifiable zone(JavaReturned)..C/a807e989-d4e4-4623-99a7-c74b9b364a8d

//end of modifiable zone(JavaReturned)....E/a807e989-d4e4-4623-99a7-c74b9b364a8d
    }

    @Override
    public Sheet getSheet(int index) {
//begin of modifiable zone................T/db249d26-121c-4048-910a-0ccf66ef301c
        if (workbook == null)
            return null;
        
        HSSFSheet sheet = workbook.getSheetAt(index);
//end of modifiable zone..................E/db249d26-121c-4048-910a-0ccf66ef301c
//begin of modifiable zone................T/be2a208d-35ce-479d-86d2-71eb5ec81095
        return new ApachePOIHSSFSheet(sheet);
//end of modifiable zone..................E/be2a208d-35ce-479d-86d2-71eb5ec81095
    }

    @Override
    public Sheet createSheet(String name) {
//begin of modifiable zone................T/87437961-5e6b-43d5-80d7-caf932e83327
        if (workbook == null)
            return null;
        
        HSSFSheet sheet = workbook.createSheet(name);
//end of modifiable zone..................E/87437961-5e6b-43d5-80d7-caf932e83327
//begin of modifiable zone................T/88cdfc62-e9eb-4a5d-ab6c-b3f264f77d96
        return new ApachePOIHSSFSheet(sheet);
//end of modifiable zone..................E/88cdfc62-e9eb-4a5d-ab6c-b3f264f77d96
    }

    @Override
    public boolean save() {
//begin of modifiable zone................T/2cd15481-fb61-434b-b47d-b9cc848b294d
        if (workbook == null || filename.isEmpty())
            return false;
        
        try {
            FileOutputStream out = new FileOutputStream(new File(filename));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
//end of modifiable zone..................E/2cd15481-fb61-434b-b47d-b9cc848b294d
//begin of modifiable zone................T/1d0bcba1-2e38-413a-a28f-09e7dd132210
        return true;
//end of modifiable zone..................E/1d0bcba1-2e38-413a-a28f-09e7dd132210
    }

    @Override
    public boolean saveAs(String filename) {
//begin of modifiable zone................T/22471df3-25a6-40c0-8c0c-8772cf02e863
        this.filename = filename;
//end of modifiable zone..................E/22471df3-25a6-40c0-8c0c-8772cf02e863
//begin of modifiable zone................T/f441d8ee-7323-42d1-b6e9-cb300de49f9a
        return save();
//end of modifiable zone..................E/f441d8ee-7323-42d1-b6e9-cb300de49f9a
    }

    @Override
    public void close() {
//begin of modifiable zone................T/2573251a-25e2-4ef8-8963-69de208f2b04
        workbook = null;
        filename = "";
//end of modifiable zone..................E/2573251a-25e2-4ef8-8963-69de208f2b04
    }

}
