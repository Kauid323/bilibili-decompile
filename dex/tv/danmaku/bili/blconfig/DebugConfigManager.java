package tv.danmaku.bili.blconfig;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blconfig.Env;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
public class DebugConfigManager extends ConfigManager {
    private ConfigManager delegate;

    public DebugConfigManager(ConfigManager delegate) {
        this.delegate = delegate;
    }

    public Pair<String, String> getRequestHeader() {
        return this.delegate != null ? this.delegate.getRequestHeader() : new Pair<>("", "");
    }

    protected Contract<Boolean> abOf(Env env) {
        Contract<Boolean> rContract = null;
        if (this.delegate != null) {
            rContract = this.delegate.getAb();
        }
        return NoopDebugConfigManager.INSTANCE.abOf(rContract);
    }

    protected Contract<String> configOf(Env env) {
        Contract<String> rContract = null;
        if (this.delegate != null) {
            rContract = this.delegate.getConfig();
        }
        return NoopDebugConfigManager.INSTANCE.configOf(rContract);
    }

    public void onLoggingStateChanged(Long uid) {
        if (this.delegate != null) {
            this.delegate.onLoggingStateChanged(uid);
        }
    }

    public void clear() {
        NoopDebugConfigManager.INSTANCE.clear();
        this.delegate.clear();
    }

    public ConfigManager getDelegate() {
        return this.delegate;
    }
}