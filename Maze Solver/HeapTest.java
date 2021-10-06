/**
 * this file is used called HeapTest.java, which is used to
 * test whether functions in heap correctly written. It contains
 * a HeapTest class which stores one test per method.
 *
 */

// import static org.junit.*;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;




public class HeapTest {


    @Test
    public void testConstructor(){
        IntComparator comp = new IntComparator();
        Heap test = new Heap(comp);
        List<Entry> list = new ArrayList<>();
        assertArrayEquals(list.toArray(), test.entries.toArray() );
        assertEquals(comp, test.comparator);
    }

    @Test
    public void testAdd(){
         IntComparator comp = new IntComparator();
         Heap test = new Heap(comp);
         test.add(9,2);
         test.add(2,5);
         test.add(1,1);
         test.add(8,0);
         Entry first = new Entry(1,1);
         Entry second = new Entry(8,0);
         Entry third = new Entry(2,5);
         Entry fourth = new Entry(9,2);

         assertEquals(first.toString(), test.peek().toString());
         assertEquals(second.toString(), test.entries.get(1).toString());
         assertEquals(third.toString(), test.entries.get(2).toString());
         assertEquals(fourth.toString(), test.entries.get(3).toString());
    }

    @Test
    public void testPoll() {
        IntComparator comp = new IntComparator();
        Heap test = new Heap(comp);
        test.add(9, 2);
        test.add(2, 5);
        test.add(1, 1);
        test.add(8, 0);
        Entry first = new Entry(1, 1);
        Entry second = new Entry(8, 0);
        Entry third = new Entry(2, 5);
        Entry fourth = new Entry(9, 2);
        assertEquals(first.toString(), test.poll().toString());
        assertEquals(3, test.size());
        assertEquals(second.toString(), test.entries.get(1).toString());
        assertEquals(fourth.toString(), test.entries.get(2).toString());
        assertEquals(third.toString(), test.poll().toString());
        assertEquals(second.toString(), test.poll().toString());
        assertEquals(1, test.size());
    }

    @Test
    public void testPeek(){
         IntComparator comp = new IntComparator();
         Heap test = new Heap(comp);
         test.add(9, 2);
         test.add(2, 5);
         test.add(1, 1);
         test.add(8, 0);
         Entry first = new Entry(1, 1);
         Entry second = new Entry(8, 0);
         Entry third = new Entry(2, 5);
         Entry fourth = new Entry(9, 2);
         assertEquals(first.toString(), test.peek().toString());
         test.poll();
         assertEquals(third.toString(), test.peek().toString());
         test.poll();
         assertEquals(second.toString(), test.peek().toString());
         test.poll();
         assertEquals(fourth.toString(), test.peek().toString());
         assertEquals(1, test.size());
    }

    @Test
    public void testToarray(){
        IntComparator comp = new IntComparator();
        Heap test = new Heap(comp);
        test.add(9, 2);
        test.add(2, 5);
        test.add(1, 1);
        test.add(8, 0);
        Entry first = new Entry(1, 1);
        Entry second = new Entry(8, 0);
        Entry third = new Entry(2, 5);
        Entry fourth = new Entry(9, 2);
        List<Entry> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);

        assertEquals(list.toString(), test.toArray().toString());
    }

    @Test
    public void testIsEmpty() {
        IntComparator comp = new IntComparator();
        Heap test = new Heap(comp);
        test.add(9, 2);
        test.add(2, 5);
        test.add(1, 1);
        assertEquals(false, test.isEmpty());
        test.poll();
        assertEquals(false, test.isEmpty());
        test.poll();
        assertEquals(false, test.isEmpty());
        test.poll();
        assertEquals(true, test.isEmpty());
    }

    @Test
    public void testHeapFunctionality_toArray(){
        IntComparator comp = new IntComparator();
        Heap test = new Heap(comp);

        String[] str = {"Eric", "Nandini", "Rebecca", "Greg", "Juan"};
        int[] ints = {0,1,2,3,4};

        for(int i=0;i<str.length;i++){
            test.add((Integer)ints[i],str[i]);
        }
        System.out.println(test.toArray());
        assertEquals(5, test.toArray().size());
        assertEquals(5, test.size());
    }

    @Test
    public void testHeapFunctionality_addMin(){
        IntComparator comp = new IntComparator();
        Heap test = new Heap(comp);

        String[] str = {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
        int[] ints = {20, 10, 30, 5, 1, 22};

        for(int i=0;i<str.length;i++){
            test.add((Integer)ints[i],str[i]);
        }
        System.out.println(test.toArray());
        assertEquals(6, test.toArray().size());
        assertEquals(6, test.size());
    }

    @Test
    public void testHeapFunctionality_addMax(){
        IntComparator comp = new IntComparator();
        Heap test = new Heap(comp);

        String[] str = {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
        int[] ints = {20, 10, 30, 5, 1, 22};

        for(int i=0;i<str.length;i++){
            test.add((Integer)ints[i],str[i]);
        }
        System.out.println(test.toArray());
        assertEquals(6, test.toArray().size());
        assertEquals(6, test.size());
    }

    @Test
    public void testHeapFunctionality_peek(){
        IntComparator comp = new IntComparator();
        Heap test = new Heap(comp);

        String[] str = {"Eric", "Nandini", "Rebecca", "Greg", "Juan"};
        int[] ints = {0,1,2,3,4};

        for(int i=0;i<str.length;i++){
            test.add((Integer)ints[i],str[i]);
        }
        System.out.println(test.toArray());
        boolean t1 = test.peek().value.equals(str[0]);
        boolean t2 = test.peek().key.equals(0);
        assertEquals(true, t1);
        assertEquals(true, t2);

    }

    @Test(expected = NoSuchElementException.class)
    public void testHeapFunctionality_removeMin(){
        IntComparator comp = new IntComparator();
        Heap test = new Heap(comp);

        String[] str = {"Garo", "Eric", "Nandini", "Paul", "Greg", "Rebecca"};
        int[] ints = {20, 10, 30, 5, 1, 22};

        for(int i=0;i<str.length;i++){
            test.add((Integer)ints[i],str[i]);
        }
        System.out.println(test.toArray());
        assertEquals(1, test.poll().key);
        System.out.println(test.toArray());
        assertEquals(5, test.poll().key);
        System.out.println(test.toArray());
        assertEquals(10, test.poll().key);
        System.out.println(test.toArray());
        assertEquals(20, test.poll().key);
        System.out.println(test.toArray());
        assertEquals(22, test.poll().key);
        System.out.println(test.toArray());
        assertEquals(30, test.poll().key);
        System.out.println(test.toArray());

        test.poll();
    }

}
