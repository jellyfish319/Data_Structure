public class QuadraticProbing <K,V> {
    private int M ;
    private int N = 0;
    private K[] a = (K[]) new Object[M] ;
    private V[] d = (V[]) new Object[M] ;

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void put(K key, V data) {
        int init = hash(key) ;
        int i = init, j = 1, loop_limit = 20;
        do {
            if(a[i] == null) {
                a[i] = key ;
                d[i] = data ;
                N++ ;
                return ;
            }
            if(a[i].equals(key)) {
                d[i] = data ;
                return ;
            }
            i = (init + j*j++) % M ;
            loop_limit-- ;
        } while(loop_limit > 0) ;
    }

    public V get(K key) {
        int init = hash(key) ;
        int i = init, j = 1, loop_limit = 20 ;
        while (a[i] != null & loop_limit > 0) {
            if(a[i].equals(key)) {
                return d[i] ;
            }
            i = (init + j*j++) % M ;
            loop_limit-- ;
        }
        return null ;
    }
}
