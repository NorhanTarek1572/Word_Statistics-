package Shared_resources;

import java.awt.Toolkit;
import java.io.File;
import static javax.swing.JOptionPane.showMessageDialog;

public class Path {

    private static String  beforeTheParentDir = "", parentMapKey = "";
    private static boolean parentFlag = true;
    
    private static void initPath(String path) {
        File file = new File(path);
        beforeTheParentDir = file.getParent() + "/";
        beforeTheParentDir = beforeTheParentDir.replaceAll("\\\\", "/");
    }

    public static boolean isValid(String dirPath) {
        File dir = new File(dirPath);
        initPath(dirPath);
        return dir.isDirectory();
    }

    public static String getParentOfFile(String path) {
        File p = new File(path);
        String parent = p.getParent();
        return parent.replaceAll("\\\\", "/");
    }

    public static String generateMapKey(String path) {
        
        
          path = path.replaceAll("\\\\", "/");
    
        if(parentFlag){
            parentMapKey = path.replaceAll(beforeTheParentDir, "");
            parentFlag = false;
        }
      
        return path.replaceAll(beforeTheParentDir, "");
         }
       
        
    public static boolean isEmpty(String dirPath) { // has no directory
    File dir = new File(dirPath);
    if(dir.isDirectory() && dir.listFiles().length == 0)  return true ;
    else return false ;
}
  
    public static String getParentMapKey(){
        return parentMapKey;
    }
 
}
