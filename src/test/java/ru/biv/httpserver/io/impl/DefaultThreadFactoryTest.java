package ru.biv.httpserver.io.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class DefaultThreadFactoryTest {

	private ThreadFactory threadFactory;
	
	@Before
	public void before(){
		threadFactory = new DefaultThreadFactory();
	}
	
	@Test
	public void testNewThread(){
		Runnable r = mock(Runnable.class);
		Thread th = threadFactory.newThread(r);
		assertEquals(8, th.getPriority());
		assertFalse(th.isDaemon());
		assertEquals("executor-thread-1", th.getName());
	}
}
