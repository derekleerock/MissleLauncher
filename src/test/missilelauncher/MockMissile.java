package test.missilelauncher;

import main.missilelauncher.Missile;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MockMissile implements Missile {
    private boolean launchWasCalled = false;
    private boolean disableWasCalled = false;

    @Override
    public void launch() {
        launchWasCalled = true;
    }

    @Override
    public void disable() {
        disableWasCalled = true;
    }

    public void verifyCodeRedAbort() {
        assertThat(launchWasCalled, equalTo(false));
        assertThat(disableWasCalled, equalTo(true));
    }
}
