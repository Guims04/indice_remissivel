package Node;

public class Node implements Comparable<Node> {
  public Object data;
  public Node next;
  public Node previous;
  public int priority;

  public Node(Object dado) {
    this.data = dado;
    previous = null;
    next = null;
  }

  public Node(Object dado, int priority) {
    this.data = dado;
    previous = null;
    next = null;
    this.priority = priority;
  }

  @Override
  public int compareTo(Node o) {
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

  public int compareStringByLength(Node s) {
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