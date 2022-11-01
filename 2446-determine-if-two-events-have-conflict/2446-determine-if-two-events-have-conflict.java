class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
       int scenario1 = event2[1].compareTo(event1[0]);
       int scenario2 = event1[1].compareTo(event2[0]);
        
       return (scenario1 >= 0 && scenario2 >=0);
        
    }   
}