package trees.HARDlevel;

   class BinaryTreeNode<T> {
        T val;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

public class childSum{
     public static void checkChildrenSum(BinaryTreeNode<Integer> root) { 

if(root== null) return;
int child=0;

if(root.left !=null){
    child+= root.left.val;
}
if(root.right !=null){
    child+= root.right.val;
}


if(child >= root.val){
    root.val=child;
}else {
    if (root.left != null)  root.left.val= root.val; 
    if(root.right != null) root.right.val = root.val;
}


checkChildrenSum(root.left);
checkChildrenSum(root.right);

int total =0;
if(root.left != null) total+= root.left.val;
if(root.right != null) total+= root.right.val;

        if (root.left != null || root.right != null)
            root.val = total;


        
    }


     public static void inorder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {


       BinaryTreeNode<Integer> root = new BinaryTreeNode<>(50);
        root.left = new BinaryTreeNode<>(7);
        root.right = new BinaryTreeNode<>(2);

        root.left.left = new BinaryTreeNode<>(3);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(1);

        System.out.print("Before: ");
        inorder(root);

        checkChildrenSum(root);

        System.out.print("\nAfter:  ");
        inorder(root);
    }

 }