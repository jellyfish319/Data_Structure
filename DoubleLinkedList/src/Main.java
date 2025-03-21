public class Main {
    public static void main(String[] args) {
        DList<String> s = new DList<String>();

        s.insertAfter(s.head,"apple");
        s.insertBefore(s.tail, "orange");
        s.insertBefore(s.tail,"cherry");
        s.insertAfter(s.head.getNext(),"pear");
        s.print(); System.out.println();

        s.delete(s.tail.getPre());
        s.print(); System.out.println();

        s.insertBefore(s.tail,"grape");
        s.print(); System.out.println();
        s.delete(s.head.getNext()); s.print(); System.out.println();  s.delete(s.head.getNext()); s.print(); System.out.println();
        s.delete(s.head.getNext()); s.print(); System.out.println();	s.delete(s.head.getNext()); s.print(); System.out.println();

        s.insertAfter(s.head,"A"); s.insertAfter(s.head,"B");
        s.insertAfter(s.head,"C"); s.insertAfter(s.head,"D");
        s.deleteByValue("C"); s.deleteByValue("B"); s.print();

    }
}
