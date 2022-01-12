package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> queue = new QueueNode<E>(e);

		// If the queue is empty
		if (last == null) {
			last = queue;
			last.next = last;

		}
		// If the queue is not empty
		else {

			queue.next = last.next;
			last.next = queue;
			last = queue;

		}

		size++;
		return true;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {

		if (size == 0) {
			return null;
		} else {
			return last.next.element;
		}

	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			size--;
			QueueNode<E> temp = last;
			last = null;
			return temp.element;

		} else {
			size--;
			QueueNode<E> temp = last.next;
			last.next = last.next.next;
			return temp.element;

		}

	}

	/**
	 * Appends the specified queue to this queue post: all elements from the
	 * specified queue are appended to this queue. The specified queue (q) is empty
	 * after the call.
	 * 
	 * @param q the queue to append
	 * @throws IllegalArgumentException if this queue and q are identical
	 */
	public void append(FifoQueue<E> q) {

		if (this == q) {

			throw new IllegalArgumentException();

		} else {
			if (q.size == 0) {

				return;

			} else if (this.size == 0) {

				this.last = q.last;
				this.size = q.size;
				q.size = 0;
				return;

			} else {

			}

		}

	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private int iteratorSize;

		/**
		 * Constructor
		 */
		private QueueIterator() {
			pos = last;
			iteratorSize = size;
		}

		public boolean hasNext() {
			if (iteratorSize > 0) {
				return true;
			} else {
				return false;
			}
		}

		public E next() {
			if (hasNext()) {
				pos = pos.next;
				iteratorSize--;
				return pos.element;
			} else {
				throw new NoSuchElementException();
			}

		}
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
