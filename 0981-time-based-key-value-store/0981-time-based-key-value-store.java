class TimeMap {

    HashMap<String, List<Pair<String, Integer>> > map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))map.put(key, new ArrayList<>());
        map.get(key).add(new Pair (value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(!map.containsKey(key))return "";
        else{
            List< Pair<String, Integer>>  list = map.get(key);
            res = search(list, timestamp);
        }
        return res;
    }
    
    public String search(List< Pair<String, Integer>> list, int timestamp){
        int s = 0;
        int e = list.size() - 1;
        String res = "";
        
        while(s <= e){
            int mid = s + (e - s)/2;
            
            int currTimeStamp = list.get(mid).getValue();
            
            if(currTimeStamp == timestamp){
                res = list.get(mid).getKey();
                break;
            }
            else if(currTimeStamp <= timestamp){
                res = list.get(mid).getKey();
                s = mid + 1;
            }
            else e = mid -1;
        }
        return res;
    }
}

