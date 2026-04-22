package tv.danmaku.bili.growth;

import com.bilibili.lib.gripper.api.PreTrigger;
import com.bilibili.login.GrowthLogConsumer;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;

/* compiled from: LogConsumer.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"provideDebugLogConsumer", "Lcom/bilibili/login/GrowthLogConsumer;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LogConsumerKt {
    @PreTrigger(trigger = "OnPrivacyAllowed")
    public static final GrowthLogConsumer provideDebugLogConsumer() {
        LogConsumer $this$provideDebugLogConsumer_u24lambda_u240 = LogConsumer.Companion.getInstance();
        ClipboardChecker.INSTANCE.injectLogConsumer$core_apinkDebug($this$provideDebugLogConsumer_u24lambda_u240);
        return $this$provideDebugLogConsumer_u24lambda_u240;
    }
}