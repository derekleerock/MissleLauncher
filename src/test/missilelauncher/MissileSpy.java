package test.missilelauncher;

import main.missilelauncher.Missile;

public class MissileSpy implements Missile {
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

    public boolean launchWasCalled() {
        return launchWasCalled;
    }
}
