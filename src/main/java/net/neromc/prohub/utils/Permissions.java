package net.neromc.prohub.utils;

public enum Permissions {

    COMMAND_PROHUB_HELP("command.help"),
    COMMAND_PROHUB_RELOAD("command.reload"),
    UPDATE_NOTIFICATION("update.notify");



    private final String perm;

    Permissions(String perm) {
        this.perm = perm;
    }

    public final String getPermission() {
        return "prohub." + this.perm;
    }
}
