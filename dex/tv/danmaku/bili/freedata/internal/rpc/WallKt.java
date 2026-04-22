package tv.danmaku.bili.freedata.internal.rpc;

import com.bapis.bilibili.app.wall.v1.RuleRequest;
import com.bapis.bilibili.app.wall.v1.RulesReply;
import com.bapis.bilibili.app.wall.v1.WallMoss;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.tf.freedata.util.log.TfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: Wall.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"TAG", "", "getTfRules", "Lcom/bapis/bilibili/app/wall/v1/RulesReply;", "network-ignet-ctr_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class WallKt {
    private static final String TAG = "tf.app.rpc";

    public static final RulesReply getTfRules() {
        try {
            RuleRequest req = RuleRequest.getDefaultInstance();
            WallMoss wallMoss = new WallMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNull(req);
            return wallMoss.executeRuleInfo(req);
        } catch (Exception e) {
            TfLog.Companion.e(TAG, "getTfRules via moss exception=" + e);
            return null;
        }
    }
}