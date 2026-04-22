package tv.danmaku.player.plugin;

public class PluginResult {
    private Throwable exception;
    private boolean success;

    public PluginResult(boolean success) {
        this.success = false;
        this.success = success;
    }

    public PluginResult(Throwable exception) {
        this.success = false;
        this.success = false;
        this.exception = exception;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Throwable getException() {
        return this.exception;
    }
}