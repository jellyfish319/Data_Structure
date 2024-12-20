public class ShallSort {
    public static void sort(Comparable[] a, int h) {
        int N = a.length ;
        while(h>=1) {
            for(int i = h ; i < N ; i++) {
                for(int j = i ; j >= h ;j -= h ) {
                    if(compare(a[j-h], a[j])) {
                        swap(a,j-h,j);
                    }
                    else {
                        break ;
                    }
                }
            }
            h /= 3 ;
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
