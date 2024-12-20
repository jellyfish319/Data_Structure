public class InsertionSort {
    public static void sort(Comparable[] a) {
        int N = a.length ;
        for(int i = 1 ; i < N ; i++) {
            for(int j = i ; j > 0 ; j--) {
                if(compare(a[j-1], a[j])) {
                    swap(a,j-1,j) ;
                }
                else {
                    break ;
                }
            }
        }
    }

    public static boolean compare(Comparable i, Comparable j) {
        return i.compareTo(j) > 0;
    }
    public static void swap(Comparable[] a , int i, int j) {
        Comparable t = a[i] ;
        a[i] = a[j] ;
        a[j] = t ;
    }
}