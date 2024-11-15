import java.util.Scanner;
public class Similares {
    private NodeS root;

    public Similares(){
        this.root = null;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void add(int k){
        if (isEmpty()) {
            NodeS no = new NodeS(k);
            this.root = no;
        }
        else{
            NodeS aux = this.root;
            while (aux != null) {
                if (k < aux.value) {
                    if (aux.left == null) {
                        NodeS n = new NodeS(k);
                        aux.left = n;
                        n.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }
                else{
                    if (aux.right == null) {
                        NodeS no = new NodeS(k);
                        aux.right = no;
                        no.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }
    public String similar(Similares outra){
        if (similar(this.root, outra.root)) {
            return "Arvores similares.";
        }return "Arvores com estruturas diferentes.";
    }
    private boolean similar(NodeS n1, NodeS n2){
        if (n1 == null && n2 == null) {
            return true;
        }
        if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) {
            return false;
        }
        return similar(n1.left, n2.left) && similar(n1.right, n2.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Similares bst = new Similares();
        Similares bst2 = new Similares();

        for(int i=0; i<n*2; i++){
            if (i<n) {
                bst.add(sc.nextInt());
            }
            else{
                bst2.add(sc.nextInt());
            }
            
        }

        System.out.println(bst.similar(bst2));
    }
}
class NodeS {
    
    int value;
    NodeS left;
    NodeS right;
    NodeS parent;
    
    NodeS(int v) {
        this.value = v;
    }
    public boolean isLeaf(){
        if (this.left == null && this.right == null) {
            return true;
        } return false;
    }
}