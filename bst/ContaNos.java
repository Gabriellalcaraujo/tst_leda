import java.util.Scanner;
public class ContaNos {
    private NodeF raiz;
    private int size;
    
    public ContaNos(){
        this.size = 0;
        this.raiz = null;
    }
    public boolean isEmpty() {
        return this.raiz == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.raiz = new NodeF(element);
        else {
            
            NodeF aux = this.raiz;
            
            while (aux != null) { 
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        NodeF newNode = new NodeF(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        NodeF newNode = new NodeF(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
    }
    public int contaN(){
        if (this.raiz != null) {
            return contaREC(raiz);
        }return 0; 
    }
    private int contaREC(NodeF no){
        if (no == null) {
            return 0;
        }
        if (!no.isLeaf()) {
            return 1 + contaREC(no.right) + contaREC(no.left);
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arv = sc.nextLine().split(" ");
        ContaNos bst = new ContaNos();

        for(String s: arv){
            bst.add(Integer.parseInt(s));
        }
        System.out.println(bst.contaN());

    }
}
class NodeD {
    
    int value;
    NodeF left;
    NodeF right;
    NodeF parent;
    
    NodeD(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}

