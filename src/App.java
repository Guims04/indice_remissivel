import Tree.SearchTree;

public class App {

  public static void main(String[] args) {
    SearchTree tree = new SearchTree();

    tree.add(10);
    tree.add(8);
    tree.add(11);

    tree.displayInOrder();
  }

}
