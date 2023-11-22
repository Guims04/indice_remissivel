package Tree;

public class TreeNode {
    int data;
    int count;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.count = 0;
    }
}