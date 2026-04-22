package tv.danmaku.bili.bilow;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: Defend.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"isDefendEnabled", "", "DEFEND_ENABLED", "defendEnabled", "getDefendEnabled", "()Ljava/lang/Boolean;", "interval", "", "DEFEND_INTERVAL_SECONDS", "defendIntervalSeconds", "getDefendIntervalSeconds", "()Ljava/lang/Long;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DefendKt {
    private static final boolean DEFEND_ENABLED = true;
    private static final long DEFEND_INTERVAL_SECONDS = 30;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDefendEnabled() {
        Boolean defendEnabled = getDefendEnabled();
        if (defendEnabled != null) {
            return defendEnabled.booleanValue();
        }
        return true;
    }

    private static final Boolean getDefendEnabled() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "security_defend_enabled", (Object) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long interval() {
        Long defendIntervalSeconds = getDefendIntervalSeconds();
        return defendIntervalSeconds != null ? defendIntervalSeconds.longValue() : DEFEND_INTERVAL_SECONDS;
    }

    private static final Long getDefendIntervalSeconds() {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "security.defend_interval_seconds", (Object) null, 2, (Object) null);
        if (str != null) {
            return StringsKt.toLongOrNull(str);
        }
        return null;
    }
}