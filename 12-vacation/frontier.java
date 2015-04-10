public interface frontier<E>{
  public void enqueue(E data);
  public E dequeue();
  public boolean empty();
  public E head();
}
