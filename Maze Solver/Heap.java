/**
 * this file is called Heap.java file. it contains a
 * class called Heap which implements PriorityQueue.
 * It will be used to solve the Maze
 * XiangHong Lin
 * xil113@ucsd.edu
 * A16632477
 *
 */

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;


public class Heap<K, V> implements PriorityQueue<K, V> {

    public static final int DOUBLE = 2;
    public static final String SPACE = " ";
    /**Instance Variables*/
    public List<Entry<K, V>> entries;
    public Comparator<K> comparator;

    /**
     * constructor
     * @param comparator
     */
    public Heap(Comparator<K> comparator) {
        this.entries = new ArrayList<>();
        this.comparator = (Comparator<K>) comparator;
    }

    /**
     * Insert a new entry with the given key and value
     * to the end of the heap
     * @param k
     * @param v
     */
    @Override
    public void add(K k, V v) {
        if(k == null) return;
        Entry node = new Entry(k, v);
        this.entries.add(node);
        this.bubbleUp(this.size()-1);

    }

    /**
     * Remove and return the root element in the heap.
     * @return
     */
    @Override
    public Entry<K, V> poll() {
        if(this.size() == 0){
            throw new NoSuchElementException();
        }
        Entry root = this.entries.get(0);
        this.entries.set(0, this.entries.get(size()-1));
        this.entries.remove(size()-1);
        if(this.entries.size() != 0) {
            this.bubbleDown(0);
        }

        return root;
    }

    /**
     * Return the root element of the heap
     * @return
     */
    @Override
    public Entry<K, V> peek() {
        if(this.size() == 0){
            throw new NoSuchElementException();
        }else{
            return this.entries.get(0);
        }
    }

    /**
     * Return the list of entries
     * @return
     */
    @Override
    public List<Entry<K, V>> toArray() {
        return this.entries;
    }

    /**
     * it returns If the List of entries is empty.
     * @return
     */
    @Override
    public boolean isEmpty() {
        if(this.size()==0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * return the index of parent
     * @param index
     * @return
     */
    public int parent(int index){
        if(index == 0){
            return index;
        }
        return (index - 1)/DOUBLE;
    }

    /**
     * return the left child index
     * @param index
     * @return
     */
    public int left(int index){
       if((index*DOUBLE + 1) > size()-1){
           return index;
       } else{
           return (index*DOUBLE + 1);
       }

    }

    /**
     * return the right child index
     * @param index
     * @return
     */
    public int right(int index){
        if((index*DOUBLE + DOUBLE)>size()-1){
            return index;
        } else{
            return (index*DOUBLE + DOUBLE);
        }


    }

    /**
     * Takes the index of two entries and swaps them.
     * @param i1
     * @param i2
     */
    public void swap(int i1, int i2){
        Entry first = this.entries.get(i1);
        Entry second = this.entries.get(i2);
        this.entries.set(i1,second);
        this.entries.set(i2,first);
    }

    /**
     * moves the entry at the specified index to a smaller index
     * @param index
     */
    public void bubbleUp(int index){

        int Parent = parent(index);
        if(!existsAndGreater(index, Parent) || index == 0){
            return;
        } else {
            this.swap(index, Parent);
            bubbleUp(Parent);
        }
    }


    /**
     * moves the entry at the specified index to a larger index (down the tree)
     * while maintaining the heap structure.
     * @param index
     */
    public void bubbleDown(int index){

        int leftChild = left(index);
        int rightChild = right(index);
        int swapped;

        if (leftChild == index) {
            return;
        }
        else if (rightChild == index) {
            swapped = leftChild;
        }
        else {
            if (existsAndGreater(rightChild, leftChild)) {
                swapped = rightChild;
            }
            else {
                swapped = leftChild;
            }
        }

        if (existsAndGreater(swapped, index)) {
            swap(swapped, index);
            bubbleDown(swapped);
        }
    }

    /**
     * Returns true if the entry at index1 is greater than that at index2
     * @param index1
     * @param index2
     * @return
     */
    public boolean existsAndGreater(int index1, int index2){
        if(index1 > (this.entries.size()-1) ||
                index2 > (this.entries.size()-1)){
            return false;
        }
        else if(this.comparator.compare(this.entries.get(index1).key,
                this.entries.get(index2).key) > 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * return the size of entries.
     * @return
     */
    public int size(){
        return this.entries.size();
    }

    /**
     * return a string representation of the elements in entries
     * @return
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Entry e: entries){
            str.append(e.toString());
            str.append(SPACE);
        }
        return str.toString();
    }
}

class Entry<K, V> {
    K key; // aka the _priority_
    V value;

    /**
     * constructor
     * @param k
     * @param v
     */
    public Entry(K k, V v) { this.key = k; this.value = v; }

    /**
     * return the string of entry
     * @return
     */
    public String toString() {
        return key + ": " + value;
    }
}
