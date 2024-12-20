public class hanoi {
        public static void move(int disk, char source, char dest, char aux){ // disk : 원판의 개수 , source : 시작 지점, dest : 도착 지점, aux : 그 외 지점
            if(disk == 1)
                System.out.println("Moved disk "+disk+" from "+source+" to "+dest);
            else  {
                move(disk-1, source, aux, dest) ;
                System.out.println("Moved disk " + disk + " from " + source + " to " + dest);
                move(disk - 1, aux, dest, source);
            }
        }
        public static void main(String[] args){
            move(4, 'A', 'C', 'B');
        }
}

