package Theads;

import Shared_resources.Buffer;
import java.io.* ; 

public class DiscoverFiles implements Runnable {
    
    private String dirPath ; 
    
    public DiscoverFiles(String dirPath){
        this.dirPath = dirPath ; 
    }
    
    @Override
    public void run(){
        File f = new File(dirPath); 
        
        File[] filesArr = f.listFiles(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
             return name.endsWith(".txt");
        }
    });

        for(File file : filesArr){
            Buffer.pushBack(file.getAbsolutePath());
        }
    }
    
}
