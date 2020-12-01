package Programming.Heap;

import java.util.Arrays;

public interface Heap {
  public boolean isEmpty();

  public boolean isFull();

  public int parent();

  public int kthChild();

  public void insert();

  public void delete();

  /*Min Max will be changed in class */
  public void heapify();

  public void printHeap();
}
