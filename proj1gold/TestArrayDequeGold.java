import org.junit.Test;
import static org.junit.Assert.*;
public class TestArrayDequeGold {
    StudentArrayDeque<Integer> s= new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> a= new ArrayDequeSolution<>();

    /*Your test should randomly call StudentArrayDeque and ArrayDequeSolution methods until they disagree on an output. */
    @Test
    public void testStudentArrayDeque() {
        int loop_number1= StdRandom.uniform(100);
        int loop_number2= StdRandom.uniform(100);
        int[] expected= new int[loop_number1+loop_number2];
        int index= loop_number1;
        //add the random numbers into the deque and store the correct into array-->actual
        while(index>0) {
            int first= StdRandom.uniform(10);
            a.addFirst(first);
            s.addFirst(first);
            expected[index-1]= first;
            index-=1;
        }
        while(index<loop_number2) {
            int last= StdRandom.uniform(10);
            a.addLast(last);
            s.addLast(last);
            expected[loop_number1+index]= last;
            loop_number1-=1;
            index+=1;
        }
        int sum= loop_number1+loop_number2-1;
        index=0;
        boolean judge= false;
        while(!a.isEmpty()&&!s.isEmpty()) {
            if(judge==false) {
                int test1 = a.removeFirst();
                int test2 = s.removeFirst();
                assertEquals(expected[sum-index], test1);
                assertEquals(expected[sum-index], test2);
            }else {
                int test3 = a.removeLast();
                int test4 = s.removeLast();
                assertEquals(expected[index], test3);
                assertEquals(expected[index], test4);
            }
            assertEquals(a.size(),s.size());
            index=index-1;
        }
        assertEquals(a.isEmpty(),s.isEmpty());
    }
}
