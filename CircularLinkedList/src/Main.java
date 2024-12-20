public class Main {
    public static void main(String[] args) {
        CList<String> s = new CList<String>();

        s.insert("pear");    s.insert("cherry");
        s.insert("orange");  s.insert("apple");
        s.print();
        System.out.print(": length of s = "+s.size()+"\n");

        s.delete();
        s.print();
        System.out.print(" : length of s = "+s.size()); System.out.println();

        s.insert("A"); s.insert("B"); s.insert("C");
        s.deleteByValue("B"); s.print() ;
    }
}