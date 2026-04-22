package tv.danmaku.bili.ui.freedata.tracer;

import com.bapis.bilibili.app.wall.v1.RuleRequest;
import com.bapis.bilibili.app.wall.v1.RulesReply;
import com.bapis.bilibili.app.wall.v1.WallMoss;
import com.bilibili.fd_service.api.beans.RulesInfoData;
import com.bilibili.fd_service.rules.FdRuleDelegate;
import com.bilibili.lib.moss.api.CallOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FreeDataRuleDelegateImpl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/freedata/tracer/FreeDataRuleDelegateImpl;", "Lcom/bilibili/fd_service/rules/FdRuleDelegate;", "<init>", "()V", "loadFromAssets", "Lcom/bilibili/fd_service/api/beans/RulesInfoData;", "fetchProxyRulesSync", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FreeDataRuleDelegateImpl implements FdRuleDelegate {
    public static final int $stable = 0;

    public RulesInfoData loadFromAssets() {
        return null;
    }

    public RulesInfoData fetchProxyRulesSync() {
        RulesInfoData rulesInfoData;
        WallMoss wallMoss = new WallMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
        RuleRequest build = RuleRequest.newBuilder().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        RulesReply rulesReply = wallMoss.executeRuleInfo(build);
        if (rulesReply != null) {
            TfMultiDomainKt.updateMultiDomainRule(rulesReply);
        }
        if (rulesReply != null) {
            rulesInfoData = FreeDataRuleDelegateImplKt.toRulesInfoData(rulesReply);
            return rulesInfoData;
        }
        return null;
    }
}