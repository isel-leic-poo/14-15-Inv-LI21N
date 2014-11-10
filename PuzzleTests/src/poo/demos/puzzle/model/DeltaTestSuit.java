package poo.demos.puzzle.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import poo.demos.puzzle.model.Delta;

/**
 * Note to students:
 * Just for fun, my test suits are using Hamcrest's matchers.
 * Notice the increased expressiveness.. ;)
 * 
 * For your own tests I recommend you use (for now) JUnit's assertions (e.g. assertSame,
 * assertEqual, assertTrue, and so on).
 * 
 * The next example illustrates the use of JUnit's assertions to express the 
 * getReverse_inAllDeltaInstances_returnsCorrectResult unit test.
 * <pre> 
 * {@code
 * 		assertSame(Delta.STEP_DOWN, Delta.STEP_UP.getReverse());
 * 		assertSame(Delta.STEP_UP, Delta.STEP_DOWN.getReverse());
 * 		assertSame(Delta.STEP_LEFT, Delta.STEP_RIGHT.getReverse());
 * 		assertSame(Delta.STEP_RIGHT, Delta.STEP_LEFT.getReverse());
 * }
 * </pre>
 */
public class DeltaTestSuit {

	@Test
	public void getReverse_inAllDeltaInstances_returnsCorrectResult()
	{
		assertThat(Delta.STEP_DOWN.getReverse(), is(sameInstance(Delta.STEP_UP)));
		assertThat(Delta.STEP_UP.getReverse(), is(sameInstance(Delta.STEP_DOWN)));
		assertThat(Delta.STEP_LEFT.getReverse(), is(sameInstance(Delta.STEP_RIGHT)));
		assertThat(Delta.STEP_RIGHT.getReverse(), is(sameInstance(Delta.STEP_LEFT)));
	}
	
	@Test
	public void getInstanceFromCoordinates_withAllDirectionsCoordinates_returnsCorrectInstances()
	{
		assertThat(Delta.getInstanceFromCoordinates(0, 1), is(sameInstance(Delta.STEP_DOWN)));
		assertThat(Delta.getInstanceFromCoordinates(0, -1), is(sameInstance(Delta.STEP_UP)));
		assertThat(Delta.getInstanceFromCoordinates(1, 0), is(sameInstance(Delta.STEP_RIGHT)));
		assertThat(Delta.getInstanceFromCoordinates(-1, 0), is(sameInstance(Delta.STEP_LEFT)));
	}
	
	@Test
	public void getInstanceFromCoordinates_withInvalidDirectionsCoordinates_returnsNull()
	{
		assertThat(Delta.getInstanceFromCoordinates(0, 0), is(nullValue()));
		assertThat(Delta.getInstanceFromCoordinates(1, 1), is(nullValue()));
		assertThat(Delta.getInstanceFromCoordinates(1, -1), is(nullValue()));
		assertThat(Delta.getInstanceFromCoordinates(-1, -1), is(nullValue()));
		assertThat(Delta.getInstanceFromCoordinates(-1, 1), is(nullValue()));
	}
	
}
