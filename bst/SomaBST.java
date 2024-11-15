import java.util.Scanner;

public class SomaBST {
    private NodeB root;
    private int size;
    
    public SomaBST(){
        this.size = 0;
        this.root = null;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new NodeB(element);
        else {
            
            NodeB aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        NodeB newNode = new NodeB(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        NodeB newNode = new NodeB(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    private int soma(){
        if (isEmpty()) {
            return 0;
        }
        else if (size == 1) {
            return this.root.value;
        }
        else{
            return somaREC(this.root);
        }
    }
    private int somaREC(NodeB no){
        if (no == null) {
            return 0;
        }
        if (no.isLeaf()) {
            return no.value;
        }
        return somaREC(no.right) + somaREC(no.left);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        SomaBST bst = new SomaBST();
        
        for(String s: entrada){
            bst.add(Integer.parseInt(s));
        }
        System.out.println(bst.soma());
    }
}
class NodeB {
    
    int value;
    NodeB left;
    NodeB right;
    NodeB parent;
    
    NodeB(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}
