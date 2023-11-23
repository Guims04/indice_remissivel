package List;

import Node.Node;

public class DynamicList {
  Node first;
  Node last;
  int count;

  public DynamicList() {
    first = null;
    last = null;
  }

  public void add(Object element) {
    Node newElement = new Node(element);

    if (first == null) {
      first = newElement;
      last = newElement;
    } else {
      last.next = newElement;
      last = newElement;
    }
    count++;
  }

  public void add(int position, Object element) {
    Node newElement = new Node(element);

    if (position == 0) {
      newElement.next = first;
      first = newElement;
    } else if (position == size()) {
      add(element);
    } else {
      Node aux = first;

      for (int i = 0; i < position - 1; i++) {
        aux = aux.next;
      }

      newElement.next = aux.next;
      aux.next = newElement;
    }
    count++;
  }

  public int size() {
    return count;
  }

  public void clear() {
    first = null;
    count = 0;
  }

  public boolean contains(Object element) {
    Node aux = first;

    while (aux != null) {
      if (aux.data.equals(element))
        return true;

      aux = aux.next;
    }
    return false;
  }

  public void remove(Object element) {
    Node aux = first;
    Node previous = null;

    if (first == null)
      throw new Error("Empty list!");

    while (aux != null) {
      if (aux.data.equals(element)) {
        if (aux == first) {
          first = aux.next;
          aux = first;
          count--;
        } else if (aux.equals(last)) {
          previous.next = null;
          last = previous;
          aux = null;
          count--;
        } else {
          previous.next = aux.next;
          aux = aux.next;
          count--;
        }
      } else {
        previous = aux;
        aux = aux.next;
      }
    }
  }

  public void removeAt(int position) {
    Node aux = first;
    Node previous = null;

    if (position == 0) {
      aux = first.next;
      first = aux;
    } else if (position == size() - 1) {
      for (int i = 0; i < size() - 2; i++) {
        aux = aux.next;
      }
      last = aux;
      aux.next = null;
    } else {
      for (int i = 0; i < position; i++) {
        previous = aux;
        aux = aux.next;
      }
      previous.next = aux.next;
    }
    count--;
  }

  public Object get(int index) {
    if (index > count)
      return -1;

    Node aux = first;
    for (int i = 0; i < index; i++) {
      aux = aux.next;
    }
    return aux.data;
  }

  public int indexOf(Object element) {
    Node aux = first;
    for (int i = 0; i <= count; i++) {
      if (aux.data.equals(element))
        return i;

      aux = aux.next;
    }
    return -1;
  }

  @Override
  public String toString() {
    String str = "[";
    Node aux = first;

    while (aux != null) {
      str += " " + aux.data;
      aux = aux.next;
    }
    return str + " ]";
  }
}