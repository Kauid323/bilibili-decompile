package tv.danmaku.biliplayerv2.service.interact.helper;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThumbnailConfig.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/Always;", "Ltv/danmaku/biliplayerv2/service/interact/helper/DurationConstraint;", "<init>", "()V", "contains", "", "duration", "Lkotlin/time/Duration;", "contains-LRDsOJo", "(J)Z", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Always implements DurationConstraint {
    public static final Always INSTANCE = new Always();

    private Always() {
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.helper.DurationConstraint
    /* renamed from: contains-LRDsOJo  reason: not valid java name */
    public boolean mo2265containsLRDsOJo(long j) {
        return true;
    }
}