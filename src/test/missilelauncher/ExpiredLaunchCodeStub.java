package test.missilelauncher;

import main.missilelauncher.LaunchCode;

public class ExpiredLaunchCodeStub implements LaunchCode {
    @Override
    public boolean isExpired() {
        return true;
    }

    @Override
    public boolean isUnsigned() {
        return false;
    }
}
