package prog2.gui.pflegedoku;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

public class TestBausteineHandler {

	BausteineHandler out;
	Pflegedoku pflegeGui;

	@Before
	public void test() {
	pflegeGui = new Pflegedoku();
	out = new BausteineHandler();
	}

	@Test
	public void testIfBausteineHandlerIsInitializedWhenCreatingGui() {
		assertTrue(this.out != null);
	}
	@Test
	public void testIfFrameSizeIsCorrect() {
		assertTrue(pflegeGui.frameSize == 800);
	}

}
