package common.sortmap;

import java.util.*;

public class SortMap {
    public static void sortValueMap(Map<Integer,User> map){
        List<Map.Entry<Integer, User>> list=new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return ((Integer)(o1.getValue()).getAge()).compareTo((Integer)(o2.getValue()).getAge());
            }
        });
        System.out.println(list);
    }
    public static void main(String[] args) {
        Map<Integer,User> map=new HashMap<>();
        map.put(22,new User("aa",1));
        map.put(11,new User("bb",11));
        map.put(33,new User("cc",3));
        sortValueMap(map);
    }
   static class MyComparable implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    static class MyComparableValue implements Comparator<Map<Integer,User>> {
        @Override
        public int compare(Map<Integer, User> o1, Map<Integer, User> o2) {
            return ((Integer)((User)o1.values()).getAge()).compareTo((Integer)((User)o2.values()).getAge());
        }
    }
}
