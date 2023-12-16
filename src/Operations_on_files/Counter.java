package Operations_on_files;

import Shared_resources.Column;

public class Counter {
    
    private volatile static Counter uniqueIstance;
    
    
    public static Counter getInstance() {
        if(uniqueIstance == null){
            synchronized(Counter.class){
                uniqueIstance = new Counter();
            }
        }
        return uniqueIstance;
    }
    
    public static void increaseIs(String path) {
        
      FileContainer.incrementCounter(path, Column.NUMBER_OF_IS.ordinal());
      DirectoryContainer.incrementCounter(path, Column.NUMBER_OF_IS.ordinal());
    
    }

    public static void increaseYou(String path) {
        
      FileContainer.incrementCounter(path, Column.NUMBER_OF_YOU.ordinal());
      DirectoryContainer.incrementCounter(path, Column.NUMBER_OF_YOU.ordinal());
      
    }

    public static void increaseAre(String path) {
        
      FileContainer.incrementCounter(path, Column.NUMBER_OF_ARE.ordinal());
      DirectoryContainer.incrementCounter(path, Column.NUMBER_OF_ARE.ordinal());
      
    }

    public static void increaseWords(String path) {
        
      FileContainer.incrementCounter(path, Column.NUMBER_OF_WORDS.ordinal());

      DirectoryContainer.incrementCounter(path, Column.NUMBER_OF_WORDS.ordinal());
    
    }
}