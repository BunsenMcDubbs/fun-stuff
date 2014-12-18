public class MaxHeap {

    Node[] arr;
    int size;

    class Node {
        int data;
        Node (int num) { data = num; }
    }

    public MaxHeap(int N) {
        arr = new Node[N];
        size = 0;
    }

    public MaxHeap(int[] ns) {
        arr = new Node[ns.length];
        for(int i = 0; i < ns.length; i++) {
            arr[i] = new Node(ns[i]);
        }
        size = 0;
        build();
    }

    private void build() {
        while (size < arr.length) {
            print();
            swim(++size - 1);
        }
    }

    public void toList() {
        while(size > 0) {
            exch(0, size - 1);
            size--;
            sink(0);
        }
    }

    public void insert(int num) {
        if (size >= arr.length - 1) { return; }
        arr[size] = new Node(num);
        swim(size++);
    }

    public int removeMax() {
        int max = arr[0].data;
        exch(0, size - 1);
        arr[size - 1] = null;
        size--;
        sink(0);
        return max;
    }

    private void swim(int ind) {
        while(ind > 0 && arr[ind].data > arr[(ind - 1) / 2].data) {
            exch(ind, (ind - 1) / 2);
            ind = (ind - 1) / 2;
        }
    }

    private void sink(int ind) {
        while(ind <= size){

            try {
                if (!(arr[ind].data < arr[ind * 2 + 1].data)) { break; }
                if (!(arr[ind].data < arr[ind * 2 + 2].data)) { break; }
            }
            catch (ArrayIndexOutOfBoundsException e) {}
            catch (NullPointerException e) {}

            int c1 = ind * 2 + 1, c2 = ind * 2 + 2;
            if (c1 >= size) { return; }
            int big = c1;
            if (c2 < size) {
                try {
                    if (arr[c1].data < arr[c2].data) { big = c2; }
                } catch(NullPointerException e) {}
            }

            exch(ind, big);
            ind = big;
        }
    }

    private void exch(int a, int b) {
        if (a >= size) { throw new IndexOutOfBoundsException("size = " + size + " " + a); }
        if (b >= size) { throw new IndexOutOfBoundsException("size = " + size + " " + b); }
        Node temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
            System.out.printf("%4d ", arr[i].data);
            else
            System.out.print("null ");
        }
        System.out.println("| size = " + size);
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(new int[]{10,20,13,2,30,21,3,4,18});
        mh.toList();
        mh.print();
    }
}
