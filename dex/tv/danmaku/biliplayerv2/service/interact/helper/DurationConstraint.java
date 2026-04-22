package tv.danmaku.biliplayerv2.service.interact.helper;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThumbnailConfig.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\b\t\n\u000b\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/DurationConstraint;", "", "contains", "", "duration", "Lkotlin/time/Duration;", "contains-LRDsOJo", "(J)Z", "Ltv/danmaku/biliplayerv2/service/interact/helper/Always;", "Ltv/danmaku/biliplayerv2/service/interact/helper/ClosedRange;", "Ltv/danmaku/biliplayerv2/service/interact/helper/From;", "Ltv/danmaku/biliplayerv2/service/interact/helper/Never;", "Ltv/danmaku/biliplayerv2/service/interact/helper/UpTo;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface DurationConstraint {
    /* renamed from: contains-LRDsOJo */
    boolean mo2265containsLRDsOJo(long j);
}