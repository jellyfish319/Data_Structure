public class Main {
    public static void main(String[] args) {
        DataGenerator gen = new DataGenerator() ;
        gen.generateRandomData(5000) ;
        Comparable[] originalData = gen.getData(5000) ;

        Comparable[] data1 = new Comparable[originalData.length];
        Comparable[] data2 = new Comparable[originalData.length];
        Comparable[] data3 = new Comparable[originalData.length];
        Comparable[] data4 = new Comparable[originalData.length];

        System.arraycopy(originalData, 0, data1, 0, originalData.length);
        System.arraycopy(originalData, 0, data2, 0, originalData.length);
        System.arraycopy(originalData, 0, data3, 0, originalData.length);
        System.arraycopy(originalData, 0, data4, 0, originalData.length);


        System.out.print("Original Data : ") ;
        print(data1) ;
        System.out.println() ;
        long startTime = System.nanoTime();
        SelectionSort.sort(data1);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime ;
        System.out.print("Selection sort : ") ;
        print(data1) ;
        System.out.println("total processing time : "+ totalTime) ;
        System.out.println() ;

        startTime = System.nanoTime() ;
        InsertionSort.sort(data2) ;
        endTime = System.nanoTime();
        totalTime = endTime - startTime ;
        System.out.print("Insertion sort : ") ;
        print(data2) ;
        System.out.println("total processing time : "+ totalTime) ;
        System.out.println() ;

        startTime = System.nanoTime() ;
        ShallSort.sort(data3, 4) ;
        endTime = System.nanoTime();
        totalTime = endTime - startTime ;
        System.out.print("Shall Sort : ") ;
        print(data3) ;
        System.out.println("total processing time : "+ totalTime) ;
        System.out.println() ;

        startTime = System.nanoTime() ;
        MergeSort.sort(data4) ;
        endTime = System.nanoTime();
        totalTime = endTime - startTime ;
        System.out.print("Merge sort : ") ;
        print(data4) ;
        System.out.println("total processing time : "+ totalTime) ;
    }

    static void print(Comparable[] a) {
        for(int i = 0 ; i < a.length ; i++) {
            System.out.print(a[i] + " ") ;
        }
        System.out.println() ;
    }
}