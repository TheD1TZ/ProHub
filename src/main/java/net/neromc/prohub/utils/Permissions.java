package net.neromc.prohub.utils;

public enum Permissions {

    //Basic Perms
    COMMAND_PROHUB_HELP("command.help"),
    COMMAND_PROHUB_RELOAD("command.reload"),
    UPDATE_NOTIFICATION("update.notify"),
    WORLD_SETTINGS_BYPASS("worldsettings.bypass"),

    //Join item Perms
    TELEPORT_BOW_GET("teleportbow.get");



    private final String perm;

    Permissions(String perm) {
        this.perm = perm;
    }

    public final String getPermission() {
        return "prohub." + this.perm;
    }
}
