public class MergeSort {
    public static void sort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length] ;
        sort(a,b,0,a.length-1) ;
    }

    public static void sort(Comparable[] a , Comparable[] b , int start ,int end) {
        if(start >= end) return ;
        int mid = (start+end)/2 ;
        sort(a,b,start,mid);
        sort(a,b,mid+1,end) ;
        merge(a,b,start,mid,end) ;
    }

    public static void merge(Comparable[] a, Comparable[] b, int start, int mid, int end) {
        int n = start ;
        int m = mid + 1 ;
        for(int i = start ; i <= end ; i++) {
            if(n  > mid) {
                b[i] = a[m++] ;
            }
            else if (m > end) {
                b[i] = a[n++] ;
            }
            else if (compare(a[n], a[m])) {
                b[i] = a[m++] ;
            }
            else {
                b[i] = a[n++] ;
            }
        }
        for(int i = start ; i <= end ; i++) {
            a[i] = b[i] ;
        }
    }

    public static boolean compare(Comparable i, Comparable j) {
        return i.compareTo(j) > 0;
    }
}
