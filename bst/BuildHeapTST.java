import java.util.Arrays;
import java.util.Scanner;

public class BuildHeapTST {
    private int[] heap;
    private int tail;
    
    public BuildHeapTST(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }
    
    public BuildHeapTST(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }
     
    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int i) {
    	int left = 2 * i + 1;
        if (left < 0 || left > this.tail) {
            return -1;
        }return left;
    }

    public int right(int i) {
        int right = 2 * i + 2;
        if (right < 0 || right > this.tail) {
            return -1;
        }
        return right;
    }

    public int parent(int i) {
        int parent = (i-1)/2;
        if (parent < 0 || parent > this.tail) {
            return -1;
        } return parent;
    }

    public void add(int n) {
    	if (this.tail >= this.heap.length-1) {
            resize();
        }
        this.tail += 1;
        this.heap[tail] = n;

        int i = this.tail;
        while (i>0 && this.heap[parent(i)] < this.heap[i]) {
            int aux = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = aux;
            i = parent(i);
        }
    }

    private void buildHeap() {
        for(int i = parent(this.tail); i >= 0; i--) {
            heapify(i);
        }
    }
    
    public int remove() {
        if (isEmpty()) throw new RuntimeException("Empty");
        int element = this.heap[0];
        this.heap[0] = this.heap[tail];
        this.tail -= 1;

        this.heapify(0);
        
        return element;
    }
        
    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index))
            return;
        
        // compares index, left and right to find max
        int index_max = max_index(index, left(index), right(index));
        
        // if current index is not greater than its children, 
        // swap and keep heapifying.
        if (index_max != index) {
                swap(index, index_max);
                heapify(index_max);
        }
    } 
    
    private int max_index(int index, int left, int right) {
        
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[index] < this.heap[right])
                    return right;
            }
            return index;
        
        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            } 
            
            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail; 
    } 
    
    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private void resize() {
        int[] novoHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++){
            novoHeap[i] = this.heap[i];
        }
        this.heap = novoHeap;
    }
    
    public int size() {
        return this.tail + 1;
    }
    
    public String toString() {
        return Arrays.toString(this.heap);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] arv = new int[entrada.length];

        for(int i=0; i<entrada.length; i++){
            arv[i] = Integer.parseInt(entrada[i]);
        }

        BuildHeapTST heap = new BuildHeapTST(arv);
        System.out.println(heap.toString());
        sc.close();
    } 
}

