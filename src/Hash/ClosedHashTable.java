package Hash;

import Tree.SearchTree;

//Endereçamento fechado
public class ClosedHashTable {
  private SearchTree[] table;

  public ClosedHashTable(int size) {
    table = new SearchTree[size];
  }

  public void add(String element, int line) {
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

  @Override
  public String toString() {
    String str = "";
    for (SearchTree dynamicList : table) {
      str += dynamicList + "\n";
    }
    return str;
  }
}