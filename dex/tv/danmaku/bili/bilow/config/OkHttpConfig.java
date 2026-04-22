package tv.danmaku.bili.bilow.config;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: OkHttpConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/bilow/config/OkHttpConfig;", "", "<init>", "()V", "CONNECT_TIMEOUT_MS", "", "connectTimeoutMs", "getConnectTimeoutMs", "()Ljava/lang/Long;", "READ_TIMEOUT_MS", "readTimeoutMs", "getReadTimeoutMs", "WRITE_TIMEOUT_MS", "writeTimeoutMs", "getWriteTimeoutMs", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OkHttpConfig {
    public static final long CONNECT_TIMEOUT_MS = 12000;
    public static final OkHttpConfig INSTANCE = new OkHttpConfig();
    public static final long READ_TIMEOUT_MS = 12000;
    public static final long WRITE_TIMEOUT_MS = 12000;

    private OkHttpConfig() {
    }

    public final Long getConnectTimeoutMs() {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.okhttp_connect_timeout_ms", (Object) null, 2, (Object) null);
        if (str != null) {
            return StringsKt.toLongOrNull(str);
        }
        return null;
    }

    public final Long getReadTimeoutMs() {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.okhttp_read_timeout_ms", (Object) null, 2, (Object) null);
        if (str != null) {
            return StringsKt.toLongOrNull(str);
        }
        return null;
    }

    public final Long getWriteTimeoutMs() {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.okhttp_write_timeout_ms", (Object) null, 2, (Object) null);
        if (str != null) {
            return StringsKt.toLongOrNull(str);
        }
        return null;
    }
}