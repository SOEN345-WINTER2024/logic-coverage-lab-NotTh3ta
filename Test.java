import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
public class Test {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream ogOut = System.out;

    @Before
    public void setup() {
        System.setOut(new PrintStream(out));
    }

    @org.junit.Test
    public void predicateCoverageTrueCase() {
        CheckIt.checkIt(true, false, false);
        assertEquals("P is true\r\n", out.toString());
    }

    @org.junit.Test
    public void predicateCoverageFalseCase() {
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\r\n", out.toString());
    }

    @org.junit.Test
    public void clauseCoverageTrueCase() {
        CheckIt.checkIt(true, true, true);
        assertEquals("P is true\r\n", out.toString());
    }

    @org.junit.Test
    public void clauseCoverageFalseCase() {
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\r\n", out.toString());
    }

    @org.junit.Test
    public void combinatorialCoverageTrueTrueTrue() {
        CheckIt.checkIt(true, true, true);
        assertEquals("P is true\r\n", out.toString());
    }

    @org.junit.Test
    public void combinatorialCoverageTrueTrueFalse() {
        CheckIt.checkIt(true, true, false);
        assertEquals("P is true\r\n", out.toString());
    }

    @org.junit.Test
    public void combinatorialCoverageTrueFalseTrue() {
        CheckIt.checkIt(true, false, true);
        assertEquals("P is true\r\n", out.toString());
    }

    @org.junit.Test
    public void combinatorialCoverageTrueFalseFalse() {
        CheckIt.checkIt(true, false, false);
        assertEquals("P is true\r\n", out.toString());
    }

    @org.junit.Test
    public void combinatorialCoverageFalseTrueTrue() {
        CheckIt.checkIt(false, true, true);
        assertEquals("P is true\r\n", out.toString());
    }

    @org.junit.Test
    public void combinatorialCoverageFalseTrueFalse() {
        CheckIt.checkIt(false, true, false);
        assertEquals("P isn't true\r\n", out.toString());
    }

    @org.junit.Test
    public void combinatorialCoverageFalseFalseTrue() {
        CheckIt.checkIt(false, false, true);
        assertEquals("P isn't true\r\n", out.toString());
    }

    @org.junit.Test
    public void combinatorialCoverageFalseFalseFalse() {
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\r\n", out.toString());
    }

    @org.junit.Test
    public void caccTrue() {
        CheckIt.checkIt(true, true, false);
        assertEquals("P is true\r\n", out.toString());
    }

    @org.junit.Test
    public void caccFalse() {
        CheckIt.checkIt(false, true, false);
        assertEquals("P isn't true\r\n", out.toString());
    }

    @org.junit.Test
    public void raccTrue() {
        CheckIt.checkIt(true, false, false);
        assertEquals("P is true\r\n", out.toString());
    }

    @org.junit.Test
    public void raccFalse() {
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\r\n", out.toString());
    }

    @After
    public void tearDown() {
        System.setOut(ogOut);
    }
}
