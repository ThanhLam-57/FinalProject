import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Hashtable<Integer,String>> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for(Integer key : list.get(i).keySet()){
                System.out.println(list.get(i).get(key));
            }
        }
    }
}