package test.missilelauncher;

import main.missilelauncher.LaunchCode;
import main.missilelauncher.UsedLaunchCodes;
import org.junit.Test;

import static main.missilelauncher.MissileLauncher.launchMissile;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MissileLauncherTest {
    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched_dummy() {
        LaunchCode expiredLaunchCode = new ExpiredLaunchCodeStub();


        launchMissile(new DummyMissile(), expiredLaunchCode, null);
    }

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched_spy() {
        MissileSpy missileSpy = new MissileSpy();
        LaunchCode expiredLaunchCode = new ExpiredLaunchCodeStub();


        launchMissile(missileSpy, expiredLaunchCode, null);


        assertThat(missileSpy.launchWasCalled(), equalTo(false));
    }

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched_mock() {
        MockMissile mockMissile = new MockMissile();
        LaunchCode expiredLaunchCode = new ExpiredLaunchCodeStub();


        launchMissile(mockMissile, expiredLaunchCode, null);


        mockMissile.verifyCodeRedAbort();
    }

    @Test
    public void givenUnsignedLaunchCodes_missileIsNotLaunched_mock() {
        MockMissile mockMissile = new MockMissile();
        UnsignedLaunchCodeStub unsignedLaunchCodeStub = new UnsignedLaunchCodeStub();


        launchMissile(mockMissile, unsignedLaunchCodeStub, null);


        mockMissile.verifyCodeRedAbort();
    }

    @Test
    public void reusedLaunchCodeTriggersCodeRedAbort() {
        UsedLaunchCodes usedLaunchCodes = new FakeUsedLaunchCodes();

        MissileSpy missileSpy = new MissileSpy();
        MockMissile mockMissile = new MockMissile();
        LaunchCode validLaunchCode = new ValidLaunchCodeStub();


        launchMissile(missileSpy, validLaunchCode, usedLaunchCodes);
        launchMissile(mockMissile, validLaunchCode, usedLaunchCodes);


        mockMissile.verifyCodeRedAbort();
    }
}
