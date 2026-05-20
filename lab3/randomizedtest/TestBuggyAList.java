package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList <Integer> bad = new BuggyAList<>();
        AListNoResizing <Integer> correct = new AListNoResizing<>();
        for(int i=0;i<=3;i++){
            bad.addLast(i);
            correct.addLast(i);
        }
        assertEquals(correct.size(),bad.size());
        for(int i=0;i<=3;i++){
            assertEquals(correct.removeLast(),bad.removeLast());
        }
    }
    @Test
    public void randomizedtest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList <Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB = B.size();
                assertEquals(sizeL, sizeB);
                System.out.println("size: " + sizeL + "," + sizeB);
            }else if (operationNumber == 2) {
                int size = L.size();
                if(size == 0){
                    continue;
                }
                int last1 =L.getLast();
                int last2 =B.getLast();
                assertEquals(last1,last2);
                System.out.println("last: " + last1 +  ", " + last2);
            } else if (operationNumber == 3) {
                int size = L.size();
                if(size == 0){
                    continue;
                }
                int remL =L.removeLast();
                int remB =B.removeLast();
                assertEquals(remL,remB);
                System.out.println("removeLast(" + remL + ")");
            }
        }
    }
}
