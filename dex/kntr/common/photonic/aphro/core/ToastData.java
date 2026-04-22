package kntr.common.photonic.aphro.core;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/common/photonic/aphro/core/ToastData;", "", "content", "", "id", "", "<init>", "(Ljava/lang/String;J)V", "getContent", "()Ljava/lang/String;", "getId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ToastData {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static long idx;
    private final String content;
    private final long id;

    public static /* synthetic */ ToastData copy$default(ToastData toastData, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toastData.content;
        }
        if ((i & 2) != 0) {
            j = toastData.id;
        }
        return toastData.copy(str, j);
    }

    public final String component1() {
        return this.content;
    }

    public final long component2() {
        return this.id;
    }

    public final ToastData copy(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "content");
        return new ToastData(str, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToastData) {
            ToastData toastData = (ToastData) obj;
            return Intrinsics.areEqual(this.content, toastData.content) && this.id == toastData.id;
        }
        return false;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id);
    }

    public String toString() {
        String str = this.content;
        return "ToastData(content=" + str + ", id=" + this.id + ")";
    }

    public ToastData(String content, long id) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.id = id;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getId() {
        return this.id;
    }

    /* compiled from: AphroState.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/common/photonic/aphro/core/ToastData$Companion;", "", "<init>", "()V", "idx", "", "next", "Lkntr/common/photonic/aphro/core/ToastData;", "content", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ToastData next(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            long j = ToastData.idx;
            ToastData.idx = 1 + j;
            return new ToastData(content, j);
        }
    }
}