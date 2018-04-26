package test.missilelauncher;

import main.missilelauncher.Missile;

public class DummyMissile implements Missile {
    @Override
    public void launch() {
        throw new RuntimeException();
    }

    @Override
    public void disable() {
        throw new RuntimeException();
    }
}
