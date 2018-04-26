package test.missilelauncher;

import main.missilelauncher.LaunchCode;
import main.missilelauncher.UsedLaunchCodes;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsedLaunchCodesTest {
    @Test
    public void usedLaunchCodes_containsLaunchCode_afterLaunchCodeIsAdded() {
        UsedLaunchCodes usedLaunchCodes = new FakeUsedLaunchCodes();

        LaunchCode launchCode = new SignedLaunchCodeStub();
        assertThat(usedLaunchCodes.contains(launchCode), equalTo(false));


        usedLaunchCodes.add(launchCode);


        assertThat(usedLaunchCodes.contains(launchCode), equalTo(true));
    }
}
