package Java;

import Java.list.arraylist.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        System.out.println(arrayList.contains("1"));
    }
}
