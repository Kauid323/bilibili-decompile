package kntr.app.upcomingEpisode.base.stateMachine;

import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarTimeRange;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcomingEpisodeData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam;", "", "WatchCalendarReqParam", "DeleteCalendarReqParam", "ReserveReqParam", "CancelReqParam", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$CancelReqParam;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$DeleteCalendarReqParam;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$ReserveReqParam;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$WatchCalendarReqParam;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface RequestParam {

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$WatchCalendarReqParam;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam;", "timeRange", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarTimeRange;", "<init>", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarTimeRange;)V", "getTimeRange", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarTimeRange;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class WatchCalendarReqParam implements RequestParam {
        private final KCalendarTimeRange timeRange;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public static /* synthetic */ WatchCalendarReqParam copy$default(WatchCalendarReqParam watchCalendarReqParam, KCalendarTimeRange kCalendarTimeRange, int i, Object obj) {
            if ((i & 1) != 0) {
                kCalendarTimeRange = watchCalendarReqParam.timeRange;
            }
            return watchCalendarReqParam.copy(kCalendarTimeRange);
        }

        public final KCalendarTimeRange component1() {
            return this.timeRange;
        }

        public final WatchCalendarReqParam copy(KCalendarTimeRange kCalendarTimeRange) {
            Intrinsics.checkNotNullParameter(kCalendarTimeRange, "timeRange");
            return new WatchCalendarReqParam(kCalendarTimeRange);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WatchCalendarReqParam) && Intrinsics.areEqual(this.timeRange, ((WatchCalendarReqParam) obj).timeRange);
        }

        public int hashCode() {
            return this.timeRange.hashCode();
        }

        public String toString() {
            return "WatchCalendarReqParam(timeRange=" + this.timeRange + ")";
        }

        public WatchCalendarReqParam(KCalendarTimeRange timeRange) {
            Intrinsics.checkNotNullParameter(timeRange, "timeRange");
            this.timeRange = timeRange;
        }

        public final KCalendarTimeRange getTimeRange() {
            return this.timeRange;
        }

        /* compiled from: UpcomingEpisodeData.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$WatchCalendarReqParam$Companion;", "", "<init>", "()V", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$DeleteCalendarReqParam;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam;", "bizType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "bizId", "", "<init>", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;Ljava/lang/String;)V", "getBizType", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "getBizId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DeleteCalendarReqParam implements RequestParam {
        private final String bizId;
        private final KWatchBizType bizType;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public static /* synthetic */ DeleteCalendarReqParam copy$default(DeleteCalendarReqParam deleteCalendarReqParam, KWatchBizType kWatchBizType, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                kWatchBizType = deleteCalendarReqParam.bizType;
            }
            if ((i & 2) != 0) {
                str = deleteCalendarReqParam.bizId;
            }
            return deleteCalendarReqParam.copy(kWatchBizType, str);
        }

        public final KWatchBizType component1() {
            return this.bizType;
        }

        public final String component2() {
            return this.bizId;
        }

        public final DeleteCalendarReqParam copy(KWatchBizType kWatchBizType, String str) {
            Intrinsics.checkNotNullParameter(kWatchBizType, "bizType");
            Intrinsics.checkNotNullParameter(str, "bizId");
            return new DeleteCalendarReqParam(kWatchBizType, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeleteCalendarReqParam) {
                DeleteCalendarReqParam deleteCalendarReqParam = (DeleteCalendarReqParam) obj;
                return Intrinsics.areEqual(this.bizType, deleteCalendarReqParam.bizType) && Intrinsics.areEqual(this.bizId, deleteCalendarReqParam.bizId);
            }
            return false;
        }

        public int hashCode() {
            return (this.bizType.hashCode() * 31) + this.bizId.hashCode();
        }

        public String toString() {
            KWatchBizType kWatchBizType = this.bizType;
            return "DeleteCalendarReqParam(bizType=" + kWatchBizType + ", bizId=" + this.bizId + ")";
        }

        public DeleteCalendarReqParam(KWatchBizType bizType, String bizId) {
            Intrinsics.checkNotNullParameter(bizType, "bizType");
            Intrinsics.checkNotNullParameter(bizId, "bizId");
            this.bizType = bizType;
            this.bizId = bizId;
        }

        public final KWatchBizType getBizType() {
            return this.bizType;
        }

        public final String getBizId() {
            return this.bizId;
        }

        /* compiled from: UpcomingEpisodeData.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$DeleteCalendarReqParam$Companion;", "", "<init>", "()V", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$ReserveReqParam;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam;", "bizId", "", "<init>", "(Ljava/lang/String;)V", "getBizId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReserveReqParam implements RequestParam {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String bizId;

        public static /* synthetic */ ReserveReqParam copy$default(ReserveReqParam reserveReqParam, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reserveReqParam.bizId;
            }
            return reserveReqParam.copy(str);
        }

        public final String component1() {
            return this.bizId;
        }

        public final ReserveReqParam copy(String str) {
            Intrinsics.checkNotNullParameter(str, "bizId");
            return new ReserveReqParam(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReserveReqParam) && Intrinsics.areEqual(this.bizId, ((ReserveReqParam) obj).bizId);
        }

        public int hashCode() {
            return this.bizId.hashCode();
        }

        public String toString() {
            return "ReserveReqParam(bizId=" + this.bizId + ")";
        }

        public ReserveReqParam(String bizId) {
            Intrinsics.checkNotNullParameter(bizId, "bizId");
            this.bizId = bizId;
        }

        public final String getBizId() {
            return this.bizId;
        }

        /* compiled from: UpcomingEpisodeData.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$ReserveReqParam$Companion;", "", "<init>", "()V", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$CancelReqParam;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam;", "bizId", "", "<init>", "(Ljava/lang/String;)V", "getBizId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CancelReqParam implements RequestParam {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String bizId;

        public static /* synthetic */ CancelReqParam copy$default(CancelReqParam cancelReqParam, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cancelReqParam.bizId;
            }
            return cancelReqParam.copy(str);
        }

        public final String component1() {
            return this.bizId;
        }

        public final CancelReqParam copy(String str) {
            Intrinsics.checkNotNullParameter(str, "bizId");
            return new CancelReqParam(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CancelReqParam) && Intrinsics.areEqual(this.bizId, ((CancelReqParam) obj).bizId);
        }

        public int hashCode() {
            return this.bizId.hashCode();
        }

        public String toString() {
            return "CancelReqParam(bizId=" + this.bizId + ")";
        }

        public CancelReqParam(String bizId) {
            Intrinsics.checkNotNullParameter(bizId, "bizId");
            this.bizId = bizId;
        }

        public final String getBizId() {
            return this.bizId;
        }

        /* compiled from: UpcomingEpisodeData.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam$CancelReqParam$Companion;", "", "<init>", "()V", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}