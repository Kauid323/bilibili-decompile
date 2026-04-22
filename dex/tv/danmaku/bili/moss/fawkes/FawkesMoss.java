package tv.danmaku.bili.moss.fawkes;

import com.bapis.bilibili.metadata.fawkes.FawkesReply;
import com.bapis.bilibili.metadata.fawkes.FawkesReq;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.foundation.env.EnvManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FawkesMoss.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/moss/fawkes/FawkesMoss;", "", "<init>", "()V", "getFawkesReq", "Lcom/bapis/bilibili/metadata/fawkes/FawkesReq;", "onFawkesReply", "", "reply", "Lcom/bapis/bilibili/metadata/fawkes/FawkesReply;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FawkesMoss {
    public static final int $stable = 0;
    public static final FawkesMoss INSTANCE = new FawkesMoss();

    private FawkesMoss() {
    }

    public final FawkesReq getFawkesReq() {
        FawkesReq build = FawkesReq.newBuilder().setAppkey(FoundationAlias.getFapps().getFawkesAppKey()).setEnv(EnvManager.getCurrent().getLabel()).setSessionId(FoundationAlias.getFapps().getSessionId()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public final void onFawkesReply(FawkesReply reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        ConfigManager.Companion.config().onVersion(reply.getConfig());
        ConfigManager.Companion.ab().onVersion(reply.getFf());
    }
}