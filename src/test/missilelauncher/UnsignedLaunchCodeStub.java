package test.missilelauncher;

import main.missilelauncher.LaunchCode;

public class UnsignedLaunchCodeStub implements LaunchCode {
    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isUnsigned() {
        return true;
    }
}
