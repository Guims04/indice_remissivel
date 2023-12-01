package Tree;

import List.DynamicList;

public class TreeNode implements Comparable<TreeNode> {
    Object data;
    DynamicList lines;
    int factor;
    TreeNode left;
    TreeNode right;

    public TreeNode(Object data, DynamicList line) {
        this.data = data;
        this.lines = line;
        this.left = null;
        this.right = null;
        this.factor = 0;
    }

    public void showDynamic() {
        System.out.print(lines);
    }

    @Override
    public int compareTo(TreeNode o) {
        if (data instanceof Integer && o.data instanceof Integer)
            return ((Integer) data).compareTo((Integer) o.data);
        else if (data instanceof Character && o.data instanceof Character)
            return ((Character) data).compareTo((Character) o.data);
        else if (data instanceof Double && o.data instanceof Double)
            return ((Double) data).compareTo((Double) o.data);
        else if (data instanceof Float && o.data instanceof Float)
            return ((Float) data).compareTo((Float) o.data);
        else if (data instanceof String && o.data instanceof String)
            return ((String) data).compareTo((String) o.data);
        else
            return -1;
    }

    public int compareStringByLength(TreeNode s) {
        if (data instanceof String && s.data instanceof String) {
            if (((String) data).length() > ((String) s.data).length()) {
                return 1;
            } else if (((String) data).length() == ((String) s.data).length()) {
                return 0;
            }
        }
        return -1;
    }
}