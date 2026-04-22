package kntr.app.ad.domain.report.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportConfig.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lkntr/app/ad/domain/report/internal/ReportConfig;", RoomRecommendViewModel.EMPTY_CURSOR, "RETRY_SCHEDULE_DELAY_TIME", RoomRecommendViewModel.EMPTY_CURSOR, "MAX_RETRY_COUNT", RoomRecommendViewModel.EMPTY_CURSOR, "MIN_RETRY_THRESHOLD", "MAX_RETRY_THRESHOLD", "MAX_BATCH_PAGE_SIZE", "BASE_UR", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JIJJILjava/lang/String;)V", "getRETRY_SCHEDULE_DELAY_TIME", "()J", "getMAX_RETRY_COUNT", "()I", "getMIN_RETRY_THRESHOLD", "getMAX_RETRY_THRESHOLD", "getMAX_BATCH_PAGE_SIZE", "getBASE_UR", "()Ljava/lang/String;", "getUiUrl", "getFeeUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReportConfig {
    private final String BASE_UR;
    private final int MAX_BATCH_PAGE_SIZE;
    private final int MAX_RETRY_COUNT;
    private final long MAX_RETRY_THRESHOLD;
    private final long MIN_RETRY_THRESHOLD;
    private final long RETRY_SCHEDULE_DELAY_TIME;

    public ReportConfig() {
        this(0L, 0, 0L, 0L, 0, null, 63, null);
    }

    public final long component1() {
        return this.RETRY_SCHEDULE_DELAY_TIME;
    }

    public final int component2() {
        return this.MAX_RETRY_COUNT;
    }

    public final long component3() {
        return this.MIN_RETRY_THRESHOLD;
    }

    public final long component4() {
        return this.MAX_RETRY_THRESHOLD;
    }

    public final int component5() {
        return this.MAX_BATCH_PAGE_SIZE;
    }

    public final String component6() {
        return this.BASE_UR;
    }

    public final ReportConfig copy(long j2, int i, long j3, long j4, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "BASE_UR");
        return new ReportConfig(j2, i, j3, j4, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReportConfig) {
            ReportConfig reportConfig = (ReportConfig) obj;
            return this.RETRY_SCHEDULE_DELAY_TIME == reportConfig.RETRY_SCHEDULE_DELAY_TIME && this.MAX_RETRY_COUNT == reportConfig.MAX_RETRY_COUNT && this.MIN_RETRY_THRESHOLD == reportConfig.MIN_RETRY_THRESHOLD && this.MAX_RETRY_THRESHOLD == reportConfig.MAX_RETRY_THRESHOLD && this.MAX_BATCH_PAGE_SIZE == reportConfig.MAX_BATCH_PAGE_SIZE && Intrinsics.areEqual(this.BASE_UR, reportConfig.BASE_UR);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.RETRY_SCHEDULE_DELAY_TIME) * 31) + this.MAX_RETRY_COUNT) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.MIN_RETRY_THRESHOLD)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.MAX_RETRY_THRESHOLD)) * 31) + this.MAX_BATCH_PAGE_SIZE) * 31) + this.BASE_UR.hashCode();
    }

    public String toString() {
        long j2 = this.RETRY_SCHEDULE_DELAY_TIME;
        int i = this.MAX_RETRY_COUNT;
        long j3 = this.MIN_RETRY_THRESHOLD;
        long j4 = this.MAX_RETRY_THRESHOLD;
        int i2 = this.MAX_BATCH_PAGE_SIZE;
        return "ReportConfig(RETRY_SCHEDULE_DELAY_TIME=" + j2 + ", MAX_RETRY_COUNT=" + i + ", MIN_RETRY_THRESHOLD=" + j3 + ", MAX_RETRY_THRESHOLD=" + j4 + ", MAX_BATCH_PAGE_SIZE=" + i2 + ", BASE_UR=" + this.BASE_UR + ")";
    }

    public ReportConfig(long RETRY_SCHEDULE_DELAY_TIME, int MAX_RETRY_COUNT, long MIN_RETRY_THRESHOLD, long MAX_RETRY_THRESHOLD, int MAX_BATCH_PAGE_SIZE, String BASE_UR) {
        Intrinsics.checkNotNullParameter(BASE_UR, "BASE_UR");
        this.RETRY_SCHEDULE_DELAY_TIME = RETRY_SCHEDULE_DELAY_TIME;
        this.MAX_RETRY_COUNT = MAX_RETRY_COUNT;
        this.MIN_RETRY_THRESHOLD = MIN_RETRY_THRESHOLD;
        this.MAX_RETRY_THRESHOLD = MAX_RETRY_THRESHOLD;
        this.MAX_BATCH_PAGE_SIZE = MAX_BATCH_PAGE_SIZE;
        this.BASE_UR = BASE_UR;
    }

    public /* synthetic */ ReportConfig(long j2, int i, long j3, long j4, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 60000L : j2, (i3 & 2) != 0 ? 3 : i, (i3 & 4) != 0 ? 3600000L : j3, (i3 & 8) != 0 ? 86400000L : j4, (i3 & 16) != 0 ? 10 : i2, (i3 & 32) != 0 ? "https://cm.bilibili.com" : str);
    }

    public final long getRETRY_SCHEDULE_DELAY_TIME() {
        return this.RETRY_SCHEDULE_DELAY_TIME;
    }

    public final int getMAX_RETRY_COUNT() {
        return this.MAX_RETRY_COUNT;
    }

    public final long getMIN_RETRY_THRESHOLD() {
        return this.MIN_RETRY_THRESHOLD;
    }

    public final long getMAX_RETRY_THRESHOLD() {
        return this.MAX_RETRY_THRESHOLD;
    }

    public final int getMAX_BATCH_PAGE_SIZE() {
        return this.MAX_BATCH_PAGE_SIZE;
    }

    public final String getBASE_UR() {
        return this.BASE_UR;
    }

    public final String getUiUrl() {
        return this.BASE_UR + "/cm/api/conversion/mobile/v2";
    }

    public final String getFeeUrl() {
        return this.BASE_UR + "/cm/api/fees/wise";
    }
}