package Hash;

import List.DynamicList;

//Endereçamento fechado
public class ClosedHashTable {
  private DynamicList<Integer>[] table;

  public ClosedHashTable(int size) {
    table = new DynamicList[size];
  }

  public void add(int element) {
    int position = element % table.length;

    if (table[position] == null) {
      table[position] = new DynamicList<>();
    }

    table[position].add(element);
  }

  public void remove(int element) {
    int position = element % table.length;

    if (table[position] != null) {
      table[position].remove(element);
    }
  }

  @Override
  public String toString() {
    String str = "";
    for (DynamicList<Integer> dynamicList : table) {
      str += dynamicList + "\n";
    }
    return str;
  }
}