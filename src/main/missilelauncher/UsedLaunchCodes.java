package main.missilelauncher;

public interface UsedLaunchCodes {
    void add(LaunchCode launchCode);

    boolean contains(LaunchCode launchCode);
}
