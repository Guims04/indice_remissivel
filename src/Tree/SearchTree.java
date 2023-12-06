package Tree;

import List.DynamicList;

public class SearchTree {
    private TreeNode root;

    public SearchTree() {
        root = null;
    }

    public int getBiggestChildren(int leftFactor, int rightFactor) {
        return Math.max(leftFactor, rightFactor);
    }

    public int getFactor(TreeNode root) {
        return root == null ? -1 : root.factor;
    }

    public void add(Object element) {
        TreeNode newNode = new TreeNode(element);

        if (root == null) {
            root = newNode;
        } else {
            root = add(newNode, root);
        }
    }

    private TreeNode add(TreeNode element, TreeNode root) {

        if (root == null) {
            root = element;
        } else if (root.compareTo(element) > 0) {
            root.left = add(element, root.left);
            if (getFactor(root.left) - getFactor(root.right) == 2) {
                if (element.compareTo(root.left) < 0) {
                    root = singleRightRotation(root);
                } else {
                    root = doubleRightRotation(root);
                }
            }
        } else if (root.compareTo(element) < 0) {
            root.right = add(element, root.right);
            if (getFactor(root.right) - getFactor(root.left) == 2) {
                if (element.compareTo(root.right) > 0) {
                    root = singleLeftRotation(root);
                } else {
                    root = doubleLeftRotation(root);
                }
            }
        }
        // else {
        // root.lines.add(element.lines.get(0));
        // }

        root.factor = getBiggestChildren(getFactor(root.left), getFactor(root.right)) + 1;
        return root;

    }

    public boolean research(String element, int line) {
        TreeNode newNode = new TreeNode(element, line);

        if (root == null) {
            return false;
        }
        return research(newNode, root);
    }

    private boolean research(TreeNode element, TreeNode root) {
        if (element.data.equals(root.data)) {
            root.lines.add(element.lines.get(0));
            return true;
        } else if (element.compareTo(root) < 0) {
            if (root.left == null)
                return false;
            return research(element, root.left);
        } else if (element.compareTo(root) > 0) {
            if (root.right == null)
                return false;
            return research(element, root.right);
        }

        return false;
    }

    private TreeNode singleRightRotation(TreeNode node) {
        TreeNode aux = node.left;
        node.left = aux.right;
        aux.right = node;
        node.factor = getBiggestChildren(getFactor(node.left), getFactor(node.right)) + 1;
        aux.factor = getBiggestChildren(getFactor(aux.left), node.factor) + 1;
        return aux;
    }

    private TreeNode singleLeftRotation(TreeNode node) {
        TreeNode aux = node.right;
        node.right = aux.left;
        aux.left = node;
        node.factor = getBiggestChildren(getFactor(node.left), getFactor(node.right)) + 1;
        aux.factor = getBiggestChildren(getFactor(aux.right), node.factor) + 1;
        return aux;
    }

    // ratacao dupla para direita
    private TreeNode doubleRightRotation(TreeNode node) {
        node.left = singleLeftRotation(node.left);
        return singleRightRotation(node);
    }

    // ratacao dupla para esquerda
    private TreeNode doubleLeftRotation(TreeNode node) {
        node.right = singleRightRotation(node.right);
        return singleLeftRotation(node);
    }

    // public void remove(Object element) {
    // if (root != null)
    // remove(element, root, null);
    // }

    // private void remove(Object element, TreeNode root, TreeNode father) {
    // if (element == root.data) {
    // if (root.left == null && root.right == null) {
    // if (root == father.left)
    // father.left = null;
    // else
    // father.right = null;
    // } else if (root.left != null && root.right == null) {
    // if (root == father.left)
    // father.left = root.left;
    // else
    // father.right = root.left;
    // } else if (root.left == null && root.right != null) {
    // if (root == father.left)
    // father.left = root.right;
    // else
    // father.right = root.right;
    // } else {
    // root.data = lowerValue(root.right);
    // remove(root.data, root.right, root);
    // }
    // } else if (element < root.data) {
    // if (root.left != null)
    // remove(element, root.left, root);
    // } else {
    // if (root.right != null)
    // remove(element, root.right, root);
    // }
    // }

    // private Object lowerValue(TreeNode root) {
    // if (root.left == null)
    // return root.data;

    // return lowerValue(root.left);
    // }

    public void displayPostOrder() {
        if (root != null) {
            displayPostOrder(root);
            System.out.println();
        }
    }

    private void displayPostOrder(TreeNode root) {
        if (root.left != null) {
            displayPostOrder(root.left);
        }
        if (root.right != null) {
            displayPostOrder(root.right);
        }
        System.out.print(root.data + " ");
    }

    public String displayInOrder() {
        String result = "";

        if (root != null) {
            result += displayInOrder(root, result);
        }

        return result;
    }

    private String displayInOrder(TreeNode root, String result) {

        if (root.left != null) {
            result = displayInOrder(root.left, result);
        }

        if (root.lines.size() != 0)
            result += root.data + " " + root.showDynamic() + " \n";

        if (root.right != null) {
            result = displayInOrder(root.right, result);
        }

        return result;
    }

    public void displayPreOrder() {
        if (root != null) {
            displayPreOrder(root);
            System.out.println();
        }
    }

    private void displayPreOrder(TreeNode root) {
        System.out.print(root.data + " ");

        if (root.left != null) {
            displayPreOrder(root.left);
        }
        if (root.right != null) {
            displayPreOrder(root.right);
        }
    }
}