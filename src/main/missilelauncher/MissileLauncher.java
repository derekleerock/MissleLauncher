package main.missilelauncher;

public class MissileLauncher {
    public static void launchMissile(
            Missile missile,
            LaunchCode launchCode,
            UsedLaunchCodes usedLaunchCodes
    ) {
        try {
            if (launchCode.isExpired() || launchCode.isUnsigned() || usedLaunchCodes.contains(launchCode)) {
                missile.disable();
                return;
            }

            missile.launch();
            usedLaunchCodes.add(launchCode);
        } catch (Exception e) {
            // Malicious swallowing of the exception thrown by the dummy
        }
    }
}
