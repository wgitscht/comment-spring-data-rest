package net.gitschthaler;

import net.gitschthaler.eventhandler.SaveCommentHandler;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPadding {

	@Test
	public void contextLoads() {
		assertThat(SaveCommentHandler.fillZeroes(1L, 5), is(equalTo("00001")));
		assertThat(SaveCommentHandler.fillZeroes(1000L, 5), is(equalTo("01000")));
	}



}
