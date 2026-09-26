import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class TimeMap {

    Map<String , TreeSet<MyStore>> myMap = null;
    Comparator<MyStore> comp = new Comparator<>(){
        @Override
        public int compare(MyStore obj1, MyStore obj2){
            return obj2.getTimestamp() - obj1.getTimestamp();
        }};
    public TimeMap() {
        myMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        myMap.putIfAbsent(key,new TreeSet<>(comp));
        MyStore myStore = new MyStore(value, timestamp);
        myMap.get(key).add(myStore);
    }

    public String get(String key, int timestamp) {
        String valueToReturn = null;
        TreeSet<MyStore> myTreeSet = myMap.get(key);
        if(myTreeSet == null) return "";
        for(MyStore myStore : myTreeSet){
            if(myStore.getTimestamp() <= timestamp){
                valueToReturn = myStore.getValue();
                break;
            }
        }
        return valueToReturn;
    }
}

class MyStore {
    int timestamp;
    String value;
    public MyStore(String val, int times){
        value = val;
        timestamp = times;
    }
    public int getTimestamp(){
        return timestamp;
    }
    public String getValue(){
        return value;
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */