/**
 * Design a phone directory which supports the following operations:
 1. get: provide a number which is not assigned to anyone
 2. check: check if a numnber is avilable
 3. release: recycle or release a number
 */
import java.util.*;
public class LC379 {
    private Set<Integer> used = new HashSet<>();
    private Queue<Integer> available = new LinkedList<>();
    int max;
    public LC379(int maxNumbers) {
        max = maxNumbers;
        for(int i = 0; i<maxNumbers;i++) {
            available.offer(i);
        }
    }

    public int get() {
        Integer ret = available.poll();
        if(ret == null) return -1;
        used.add(ret);
        return ret;
    }

    public boolean check(int number) {
        if(number >= max || number < 0) return false;
        return !used.contains(number);
    }

    public void release(int number) {
        if(used.remove(number)) {
            available.offer(number);
        }
    }
}