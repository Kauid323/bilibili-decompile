package kntr.app.ad.domain.alarm;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdAlarmCommonParams.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B;\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\b\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\b\u000e\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\b\u0010\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\b\u0012\u001a\u0004\b\u0011\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\b\u0014\u001a\u0004\b\u0013\u0010\u000b¨\u0006#"}, d2 = {"Lkntr/app/ad/domain/alarm/AdAlarmCommonParams;", "Lkntr/app/ad/domain/alarm/IAdAlarmCommonParams;", "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "creativeId", "srcId", "cardType", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "requestId$1", "getCreativeId", "creativeId$1", "getSrcId", "srcId$1", "getCardType", "cardType$1", "getExtra", "extra$1", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Empty", "alarm_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdAlarmCommonParams implements IAdAlarmCommonParams {
    public static final Empty Empty = new Empty(null);
    private static final String cardType = null;
    private static final String creativeId = null;
    private static final String extra = null;
    private static final String requestId = null;
    private static final String srcId = null;
    private final String cardType$1;
    private final String creativeId$1;
    private final String extra$1;
    private final String requestId$1;
    private final String srcId$1;

    public static /* synthetic */ AdAlarmCommonParams copy$default(AdAlarmCommonParams adAlarmCommonParams, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adAlarmCommonParams.requestId$1;
        }
        if ((i & 2) != 0) {
            str2 = adAlarmCommonParams.creativeId$1;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = adAlarmCommonParams.srcId$1;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = adAlarmCommonParams.cardType$1;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = adAlarmCommonParams.extra$1;
        }
        return adAlarmCommonParams.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.requestId$1;
    }

    public final String component2() {
        return this.creativeId$1;
    }

    public final String component3() {
        return this.srcId$1;
    }

    public final String component4() {
        return this.cardType$1;
    }

    public final String component5() {
        return this.extra$1;
    }

    public final AdAlarmCommonParams copy(String str, String str2, String str3, String str4, String str5) {
        return new AdAlarmCommonParams(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdAlarmCommonParams) {
            AdAlarmCommonParams adAlarmCommonParams = (AdAlarmCommonParams) obj;
            return Intrinsics.areEqual(this.requestId$1, adAlarmCommonParams.requestId$1) && Intrinsics.areEqual(this.creativeId$1, adAlarmCommonParams.creativeId$1) && Intrinsics.areEqual(this.srcId$1, adAlarmCommonParams.srcId$1) && Intrinsics.areEqual(this.cardType$1, adAlarmCommonParams.cardType$1) && Intrinsics.areEqual(this.extra$1, adAlarmCommonParams.extra$1);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.requestId$1 == null ? 0 : this.requestId$1.hashCode()) * 31) + (this.creativeId$1 == null ? 0 : this.creativeId$1.hashCode())) * 31) + (this.srcId$1 == null ? 0 : this.srcId$1.hashCode())) * 31) + (this.cardType$1 == null ? 0 : this.cardType$1.hashCode())) * 31) + (this.extra$1 != null ? this.extra$1.hashCode() : 0);
    }

    public String toString() {
        String str = this.requestId$1;
        String str2 = this.creativeId$1;
        String str3 = this.srcId$1;
        String str4 = this.cardType$1;
        return "AdAlarmCommonParams(requestId=" + str + ", creativeId=" + str2 + ", srcId=" + str3 + ", cardType=" + str4 + ", extra=" + this.extra$1 + ")";
    }

    public AdAlarmCommonParams(String requestId2, String creativeId2, String srcId2, String cardType2, String extra2) {
        this.requestId$1 = requestId2;
        this.creativeId$1 = creativeId2;
        this.srcId$1 = srcId2;
        this.cardType$1 = cardType2;
        this.extra$1 = extra2;
    }

    @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
    public String getRequestId() {
        return this.requestId$1;
    }

    @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
    public String getCreativeId() {
        return this.creativeId$1;
    }

    @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
    public String getSrcId() {
        return this.srcId$1;
    }

    @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
    public String getCardType() {
        return this.cardType$1;
    }

    @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
    public String getExtra() {
        return this.extra$1;
    }

    /* compiled from: IAdAlarmCommonParams.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkntr/app/ad/domain/alarm/AdAlarmCommonParams$Empty;", "Lkntr/app/ad/domain/alarm/IAdAlarmCommonParams;", "<init>", "()V", "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "getRequestId", "()Ljava/lang/String;", "creativeId", "getCreativeId", "srcId", "getSrcId", "cardType", "getCardType", "extra", "getExtra", "alarm_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Empty implements IAdAlarmCommonParams {
        public /* synthetic */ Empty(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Empty() {
        }

        @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
        public String getRequestId() {
            return AdAlarmCommonParams.requestId;
        }

        @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
        public String getCreativeId() {
            return AdAlarmCommonParams.creativeId;
        }

        @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
        public String getSrcId() {
            return AdAlarmCommonParams.srcId;
        }

        @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
        public String getCardType() {
            return AdAlarmCommonParams.cardType;
        }

        @Override // kntr.app.ad.domain.alarm.IAdAlarmCommonParams
        public String getExtra() {
            return AdAlarmCommonParams.extra;
        }
    }
}