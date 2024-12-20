import java.util.Random ;
public class RandomProbing<K, V> {
    private int M ;
    private int N = 0;
    private K[] a = (K[]) new Object[M] ;
    private V[] d = (V[]) new Object[M] ;
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void put(K key, V data) {
        int init = hash(key) ;
        int i = init, loop_limit = 20 ;
        Random rand = new Random() ;
        rand.setSeed(10) ;
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
            i = (init + rand.nextInt(1000)) % M ;
            loop_limit-- ;
        } while(loop_limit > 0) ;
    }

    public V get(K key) {
        int init = hash(key) ;
        int i = init, loop_limit = 20 ;
        Random rand = new Random() ;
        rand.setSeed(10) ;
        while(a[i]!= null & loop_limit > 0) {
            if(a[i].equals(key)) {
                return d[i] ;
            }
            i = (init + rand.nextInt(1000)) % M ;
            loop_limit-- ;
        }
        return null ;
    }
}
