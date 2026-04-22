package kntr.base.moss.api;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KCallOptions.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/base/moss/api/KCallOptions;", "", "timeoutInMs", "", "<init>", "(J)V", "getTimeoutInMs", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KCallOptions {
    public static final Companion Companion = new Companion(null);
    private static final KCallOptions defOptions = new KCallOptions(20000);
    private final long timeoutInMs;

    public static /* synthetic */ KCallOptions copy$default(KCallOptions kCallOptions, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = kCallOptions.timeoutInMs;
        }
        return kCallOptions.copy(j);
    }

    public final long component1() {
        return this.timeoutInMs;
    }

    public final KCallOptions copy(long j) {
        return new KCallOptions(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KCallOptions) && this.timeoutInMs == ((KCallOptions) obj).timeoutInMs;
    }

    public int hashCode() {
        return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timeoutInMs);
    }

    public String toString() {
        return "KCallOptions(timeoutInMs=" + this.timeoutInMs + ")";
    }

    public KCallOptions(long timeoutInMs) {
        this.timeoutInMs = timeoutInMs;
    }

    public final long getTimeoutInMs() {
        return this.timeoutInMs;
    }

    /* compiled from: KCallOptions.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/moss/api/KCallOptions$Companion;", "", "<init>", "()V", "defOptions", "Lkntr/base/moss/api/KCallOptions;", "getDefOptions", "()Lkntr/base/moss/api/KCallOptions;", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KCallOptions getDefOptions() {
            return KCallOptions.defOptions;
        }
    }
}