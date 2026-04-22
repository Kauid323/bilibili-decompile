package kntr.app.deepsearch.base.model.biz;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.datetime.Clock;

/* compiled from: DeepSearchTimeout.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeout;", RoomRecommendViewModel.EMPTY_CURSOR, "ts", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTimeout {
    public static final Companion Companion = new Companion(null);
    private final long ts;

    private final long component1() {
        return this.ts;
    }

    public static /* synthetic */ DeepSearchTimeout copy$default(DeepSearchTimeout deepSearchTimeout, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = deepSearchTimeout.ts;
        }
        return deepSearchTimeout.copy(j2);
    }

    public final DeepSearchTimeout copy(long j2) {
        return new DeepSearchTimeout(j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeepSearchTimeout) && this.ts == ((DeepSearchTimeout) obj).ts;
    }

    public int hashCode() {
        return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.ts);
    }

    public String toString() {
        return "DeepSearchTimeout(ts=" + this.ts + ")";
    }

    public DeepSearchTimeout(long ts) {
        this.ts = ts;
    }

    /* compiled from: DeepSearchTimeout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeout$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeout;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeepSearchTimeout create() {
            return new DeepSearchTimeout(Clock.System.INSTANCE.now().toEpochMilliseconds());
        }
    }
}