package kntr.common.behavior.prediction.model;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.behavior.prediction.IBehaviorData;
import kntr.common.behavior.prediction.IPredictionContext;
import kntr.common.behavior.prediction.IPredictionResult;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoQualityData.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoQualityData;", "", "<init>", "()V", "Behavior", "Context", "Result", "Lkntr/common/behavior/prediction/model/VideoQualityData$Behavior;", "Lkntr/common/behavior/prediction/model/VideoQualityData$Context;", "Lkntr/common/behavior/prediction/model/VideoQualityData$Result;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class VideoQualityData {
    public /* synthetic */ VideoQualityData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private VideoQualityData() {
    }

    /* compiled from: VideoQualityData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoQualityData$Behavior;", "Lkntr/common/behavior/prediction/model/VideoQualityData;", "Lkntr/common/behavior/prediction/IBehaviorData;", WatchLaterReporterKt.KEY_AVID, "", "mediaInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAvid", "()Ljava/lang/String;", "getMediaInfo", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Behavior extends VideoQualityData implements IBehaviorData {
        private final String avid;
        private final String mediaInfo;

        public Behavior() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Behavior copy$default(Behavior behavior, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = behavior.avid;
            }
            if ((i & 2) != 0) {
                str2 = behavior.mediaInfo;
            }
            return behavior.copy(str, str2);
        }

        public final String component1() {
            return this.avid;
        }

        public final String component2() {
            return this.mediaInfo;
        }

        public final Behavior copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, WatchLaterReporterKt.KEY_AVID);
            Intrinsics.checkNotNullParameter(str2, "mediaInfo");
            return new Behavior(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Behavior) {
                Behavior behavior = (Behavior) obj;
                return Intrinsics.areEqual(this.avid, behavior.avid) && Intrinsics.areEqual(this.mediaInfo, behavior.mediaInfo);
            }
            return false;
        }

        public int hashCode() {
            return (this.avid.hashCode() * 31) + this.mediaInfo.hashCode();
        }

        public String toString() {
            String str = this.avid;
            return "Behavior(avid=" + str + ", mediaInfo=" + this.mediaInfo + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Behavior(String avid, String mediaInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(avid, WatchLaterReporterKt.KEY_AVID);
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            this.avid = avid;
            this.mediaInfo = mediaInfo;
        }

        public /* synthetic */ Behavior(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }

        public final String getAvid() {
            return this.avid;
        }

        public final String getMediaInfo() {
            return this.mediaInfo;
        }
    }

    /* compiled from: VideoQualityData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoQualityData$Context;", "Lkntr/common/behavior/prediction/model/VideoQualityData;", "Lkntr/common/behavior/prediction/IPredictionContext;", WatchLaterReporterKt.KEY_AVID, "", "autoMaxQn", "", "isHighScreenRatio", "", "isWifi", "<init>", "(Ljava/lang/String;IZZ)V", "getAvid", "()Ljava/lang/String;", "getAutoMaxQn", "()I", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Context extends VideoQualityData implements IPredictionContext {
        private final int autoMaxQn;
        private final String avid;
        private final boolean isHighScreenRatio;
        private final boolean isWifi;

        public Context() {
            this(null, 0, false, false, 15, null);
        }

        public static /* synthetic */ Context copy$default(Context context, String str, int i, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = context.avid;
            }
            if ((i2 & 2) != 0) {
                i = context.autoMaxQn;
            }
            if ((i2 & 4) != 0) {
                z = context.isHighScreenRatio;
            }
            if ((i2 & 8) != 0) {
                z2 = context.isWifi;
            }
            return context.copy(str, i, z, z2);
        }

        public final String component1() {
            return this.avid;
        }

        public final int component2() {
            return this.autoMaxQn;
        }

        public final boolean component3() {
            return this.isHighScreenRatio;
        }

        public final boolean component4() {
            return this.isWifi;
        }

        public final Context copy(String str, int i, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(str, WatchLaterReporterKt.KEY_AVID);
            return new Context(str, i, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Context) {
                Context context = (Context) obj;
                return Intrinsics.areEqual(this.avid, context.avid) && this.autoMaxQn == context.autoMaxQn && this.isHighScreenRatio == context.isHighScreenRatio && this.isWifi == context.isWifi;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.avid.hashCode() * 31) + this.autoMaxQn) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isHighScreenRatio)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isWifi);
        }

        public String toString() {
            String str = this.avid;
            int i = this.autoMaxQn;
            boolean z = this.isHighScreenRatio;
            return "Context(avid=" + str + ", autoMaxQn=" + i + ", isHighScreenRatio=" + z + ", isWifi=" + this.isWifi + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Context(String avid, int autoMaxQn, boolean isHighScreenRatio, boolean isWifi) {
            super(null);
            Intrinsics.checkNotNullParameter(avid, WatchLaterReporterKt.KEY_AVID);
            this.avid = avid;
            this.autoMaxQn = autoMaxQn;
            this.isHighScreenRatio = isHighScreenRatio;
            this.isWifi = isWifi;
        }

        public /* synthetic */ Context(String str, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2);
        }

        public final String getAvid() {
            return this.avid;
        }

        public final int getAutoMaxQn() {
            return this.autoMaxQn;
        }

        public final boolean isHighScreenRatio() {
            return this.isHighScreenRatio;
        }

        public final boolean isWifi() {
            return this.isWifi;
        }
    }

    /* compiled from: VideoQualityData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoQualityData$Result;", "Lkntr/common/behavior/prediction/model/VideoQualityData;", "Lkntr/common/behavior/prediction/IPredictionResult;", "maxQn", "", "<init>", "(I)V", "getMaxQn$annotations", "()V", "getMaxQn", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Result extends VideoQualityData implements IPredictionResult {
        private final int maxQn;

        public Result() {
            this(0, 1, null);
        }

        public static /* synthetic */ Result copy$default(Result result, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = result.maxQn;
            }
            return result.copy(i);
        }

        public static /* synthetic */ void getMaxQn$annotations() {
        }

        public final int component1() {
            return this.maxQn;
        }

        public final Result copy(int i) {
            return new Result(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Result) && this.maxQn == ((Result) obj).maxQn;
        }

        public int hashCode() {
            return this.maxQn;
        }

        public String toString() {
            return "Result(maxQn=" + this.maxQn + ")";
        }

        public Result(int maxQn) {
            super(null);
            this.maxQn = maxQn;
        }

        public /* synthetic */ Result(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i);
        }

        public final int getMaxQn() {
            return this.maxQn;
        }
    }
}