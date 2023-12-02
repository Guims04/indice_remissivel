package Hash;

import List.DynamicList;
import Tree.SearchTree;

//Endereçamento fechado
public class ClosedHashTable {
  private SearchTree[] table;

  public ClosedHashTable(int size) {
    table = new SearchTree[size];
  }

  public void add(String element, DynamicList line) {
    int position = ((int) element.charAt(0)) - 65;

    if (table[position] == null) {
      table[position] = new SearchTree();
    }

    table[position].add(element, line);
  }

  // public void remove(int element) {
  // int position = element % table.length;

  // if (table[position] != null) {
  // table[position].remove(element);
  // }
  // }

  public String show() {
    String result = "";
    for (SearchTree searchTree : table) {
      if (searchTree != null)
        result += searchTree.displayInOrder();
    }

    return result;
  }
}