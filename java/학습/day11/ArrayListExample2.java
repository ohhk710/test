package day11;
import java.util.*;
public class ArrayListExample2 {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>(); //스트링으로 받음
        list.add("포도");            
        list.add("딸기");           
        list.add("복숭아");  //뒤에추가
        System.out.println(list);
        list.add(2, "키위"); //해당인덱스위치 삽입
        System.out.println(list);
        list.set(0, "오렌지"); 
        System.out.println(list);
        list.remove(1);   
        System.out.println(list);
        list.remove("키위");
        System.out.println(list);
        int num = list.size();
        for (int cnt = 0; cnt < num; cnt++) {
            String str = list.get(cnt);
            System.out.println(str);
        }
        for(String fruit : list)
        	System.out.println(fruit);
        Iterator<String> iter = list.iterator();
        while(iter.hasNext())
        	System.out.println(iter.next());
        
    }
}
