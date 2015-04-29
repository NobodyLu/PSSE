package org.loccs.office.spreadsheet;


public abstract class SpreadSheet {
    public SpreadSheet() {
//begin of modifiable zone(JavaSuper).....C/bc7ec321-87a5-488f-961f-aefff329746f

//end of modifiable zone(JavaSuper).......E/bc7ec321-87a5-488f-961f-aefff329746f
//begin of modifiable zone(JavaCode)......C/bc7ec321-87a5-488f-961f-aefff329746f

//end of modifiable zone(JavaCode)........E/bc7ec321-87a5-488f-961f-aefff329746f
    }

    public abstract boolean create();

    public abstract boolean open(String filename);

    public abstract int getSheetCount();

    public abstract Sheet getSheet(int index);

    public abstract Sheet createSheet(String name);

    public abstract boolean save();

    public abstract boolean saveAs(String filename);

    public abstract void close();

}
