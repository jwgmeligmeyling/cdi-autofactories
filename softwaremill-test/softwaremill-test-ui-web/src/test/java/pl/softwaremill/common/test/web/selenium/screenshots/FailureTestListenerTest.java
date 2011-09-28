package pl.softwaremill.common.test.web.selenium.screenshots;

/**
 * This test cannot be run during module build, it have to be commented
 */
public class FailureTestListenerTest {
/*

    private Selenium selenium;
    private PrintStream out;

    private ByteArrayOutputStream baos;

    @BeforeMethod
    public void setUp() throws Exception {
        selenium = AbstractSeleniumTest.selenium;

        baos = new ByteArrayOutputStream();
        out = System.out;
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        AbstractSeleniumTest.selenium = selenium;
        System.setOut(out);
    }

    @Test
    public void shouldMakeScreenshot() throws Exception {
        // given
        FailureTestListener listener = new FailureTestListener();

        AbstractSeleniumTest.selenium = mock(Selenium.class);

        ITestResult result = setupTestResult(AnSeleniumTest.class);

        // when
        listener.onTestFailure(result);

        // then
        assertThat(baos.toString()).contains("##teamcity[publishArtifacts '");
        verify(AbstractSeleniumTest.selenium).captureEntirePageScreenshot(anyString(), anyString());
    }

    @Test
    public void shouldNotMakeScreenshot() throws Exception {
        // given
        FailureTestListener listener = new FailureTestListener();

        AbstractSeleniumTest.selenium = mock(Selenium.class);

        ITestResult result = setupTestResult(AnTest.class);

        // when
        listener.onTestFailure(result);

        // then
        assertThat(baos.toString()).isEqualTo("");
        verifyZeroInteractions(AbstractSeleniumTest.selenium);
    }

    private ITestResult setupTestResult(Class value) {
        ITestResult result = mock(ITestResult.class);
        IClass testClass = mock(IClass.class);
        when(testClass.getRealClass()).thenReturn(value);
        when(result.getTestClass()).thenReturn(testClass);
        return result;
    }
*/

}

/*
@Test
class AnSeleniumTest extends AbstractSeleniumTest {}
*/

/*
@Test
class AnTest {}
*/
