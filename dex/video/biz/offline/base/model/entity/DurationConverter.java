package video.biz.offline.base.model.entity;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TypeConverter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/model/entity/DurationConverter;", "", "<init>", "()V", "revertDuration", "Lkotlin/time/Duration;", "value", "", "revertDuration-5sfh64U", "(J)J", "converterDuration", "converterDuration-LRDsOJo", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DurationConverter {
    public static final int $stable = 0;

    /* renamed from: revertDuration-5sfh64U  reason: not valid java name */
    public final long m2767revertDuration5sfh64U(long value) {
        Duration.Companion companion = Duration.Companion;
        return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
    }

    /* renamed from: converterDuration-LRDsOJo  reason: not valid java name */
    public final long m2766converterDurationLRDsOJo(long j) {
        return Duration.getInWholeMilliseconds-impl(j);
    }
}