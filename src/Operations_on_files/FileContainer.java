package Operations_on_files;

import GUI.ResultFrame;
import Shared_resources.Column;
import Shared_resources.Column;
import static Shared_resources.Path.generateMapKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class FileContainer {
    
    private static Map<String, ArrayList<Object>> mFileName = new HashMap<String, ArrayList<Object>>();
    private static DefaultTableModel model = (DefaultTableModel) ResultFrame.getInstance().getFileTable().getModel();
    
    private static ArrayList<Object> generateColumns(){
        
        ArrayList<Object> columnArr = new ArrayList<>();
        
        for(int i = 0; i < 7; i++)
            columnArr.add((i == Column.LONGEST_WORD.ordinal() || i == Column.SHORTEST_WORD.ordinal()) ? "" : 0);
        
        return columnArr;

    }   
    public synchronized static void add(String filePath){
        
        ArrayList<Object> columns = generateColumns();
        String file = generateMapKey(filePath);
        ArrayList<Object> rowData = new ArrayList<>();
        
        columns.set(Column.ROW_NUM.ordinal(), (model.getRowCount() + 1));
        
        mFileName.put(file, columns);
        
        rowData.add(columns.get(Column.ROW_NUM.ordinal()));
        rowData.add(file);
        for(int i = 1; i < 7; i++){
            rowData.add(columns.get(i));
        }
        
        model.addRow(rowData.toArray());
    }
    public synchronized static void incrementCounter(String filePath, int numOfCol){
        
        String file = generateMapKey(filePath); //method is used to generate a unique key for a directory path
        int newValue = (int) mFileName.get(file).get(numOfCol) + 1;
        mFileName.get(file).set(numOfCol, newValue);
        
        if(numOfCol > 0){
            model.setValueAt(newValue, (int)mFileName.get(file).get(Column.ROW_NUM.ordinal())-1, numOfCol+1);
        }
        
    }
    public synchronized static void storeLongestWord(String filePath, String word){
        String file = generateMapKey(filePath); // method is used to generate a unique key for a directory path
        mFileName.get(file).set(Column.LONGEST_WORD.ordinal(), word);
        model.setValueAt(word, (int)mFileName.get(file).get(Column.ROW_NUM.ordinal())-1, Column.LONGEST_WORD.ordinal()+1);
    }    
    public synchronized static void storeShortestWord(String filePath, String word){
        String file = generateMapKey(filePath); //method is used to generate a unique key for a directory path
        mFileName.get(file).set(Column.SHORTEST_WORD.ordinal(), word);
        model.setValueAt(word, (int)mFileName.get(file).get(Column.ROW_NUM.ordinal())-1, Column.SHORTEST_WORD.ordinal()+1);
    }
    public synchronized static void clearTablesAndInternalState() {
    // Clear the directory table model
    model.setRowCount(0);
    
    // Clear the internal directory data map
    mFileName.clear();
    
    // Optionally, reset any additional internal variables related to processing
    // ...
}

}
