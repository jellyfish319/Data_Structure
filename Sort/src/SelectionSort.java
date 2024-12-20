public class SelectionSort {
    public static void sort(Comparable[] a) { // 정렬을 수행하는 코드
        int N = a.length ; // 배열의 길이 저장
        for(int i = 0 ; i < N ; i++) {
            int right = i ; // 정렬된 배열의 가장 오른쪽 인덱스
            for(int j = i + 1 ; j < N ; j++) {
                if (compare(a[j], a[right])) {
                    swap(a,right,i) ;
                    // right와 정렬되지 않은 값 중 작은 값이 있다면 right의 인덱스를 업데이트
                }
            }
        }
    }

    public static boolean compare(Comparable i, Comparable j) {
        // 배열의 두 값을 비교해주는 코드
        return i.compareTo(j) < 0 ;
    }

    public static void swap(Comparable[] a , int i , int j) {
        // 배열의 원소를 서로 바꿔주는 코드
        Comparable temp = a[i] ;
        a[i] = a[j] ;
        a[j] = temp ;
    }
}