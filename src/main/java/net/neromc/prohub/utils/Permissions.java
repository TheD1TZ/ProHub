package net.neromc.prohub.utils;

public enum Permissions {

    //Player Perms
    DISABLED_COMMANDS("disable.commands"),
    COMMAND_PROHUB_SPAWN("command.spawn"),

    //Staff Perms
    COMMAND_PROHUB_HELP("command.help"),
    COMMAND_PROHUB_RELOAD("command.reload"),
    COMMAND_PROHUB_SETSPAWN("command.setspawn"),
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
