package testqueue;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

class TestAppendFifoQueue {
	private FifoQueue<Integer> myIntQueue1;
	private FifoQueue<Integer> myIntQueue2;

	@BeforeEach
	void setUp() throws Exception {
		myIntQueue1 = new FifoQueue<Integer>();
		myIntQueue2 = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
		myIntQueue1 = null;
		myIntQueue2 = null;
	}

	@Test
	void testAppendTwoEmpty() {
		myIntQueue1.append(myIntQueue2);

		assertTrue("Wrong size on queue 1 after append", myIntQueue1.isEmpty());
		assertTrue("Wrong size on queue 2 after append", myIntQueue2.isEmpty());
	}

	@Test
	void testAppendThisEmpty() {
		myIntQueue2.offer(1);
		myIntQueue2.offer(2);
		myIntQueue2.offer(3);
		myIntQueue1.append(myIntQueue2);

		assertTrue("Wrong size of queue 2 after append", myIntQueue2.size() == 0);
		assertTrue("Wrong size of queue 1 after append", myIntQueue1.size() == 3);
		for (int i = 1; i <= 3; i++) {
			int k = myIntQueue1.poll();
			assertEquals("poll returns incorrect element", i, k);
		}

		assertTrue("Queue 1 is not empty after poll", myIntQueue1.isEmpty());

	}

	@Test
	void testAppendQEmpty() {
		myIntQueue1.offer(1);
		myIntQueue1.offer(2);
		myIntQueue1.offer(3);
		myIntQueue1.append(myIntQueue2);

		assertTrue("Wrong size of queue 1 after append", myIntQueue1.size() == 3);
		assertTrue("Wrong size of queue 2 after append", myIntQueue2.size() == 0);

		for (int i = 1; i <= 3; i++) {
			int k = myIntQueue1.poll();
			assertEquals("poll return incorrect element", i, k);
		}

		assertTrue("Queue is not empty after poll", myIntQueue1.isEmpty());

	}

	@Test
	void testAppendTwoNonEmpty() {
		myIntQueue1.offer(1);
		myIntQueue1.offer(2);
		myIntQueue1.offer(3);
		myIntQueue2.offer(4);
		myIntQueue2.offer(5);
		myIntQueue1.append(myIntQueue2);

		assertTrue("Wrong size of queue 1 after append", myIntQueue1.size() == 5);
		assertTrue("Wrong size of queue 2 after append", myIntQueue2.size() == 0);

		for (int i = 1; i <= 5; i++) {
			int k = myIntQueue1.poll();
			assertEquals("poll return incorrect element", i, k);

		}

		assertTrue("Queue is not empty after poll", myIntQueue1.isEmpty());

	}

	@Test
	void testAppendWithSelf() {
		myIntQueue1.offer(1);

		assertThrows(IllegalArgumentException.class, () -> myIntQueue1.append(myIntQueue1));

	}
}
