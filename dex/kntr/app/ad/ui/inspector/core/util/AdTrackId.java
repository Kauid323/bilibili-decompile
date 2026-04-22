package kntr.app.ad.ui.inspector.core.util;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: AdTrackId.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 g2\u00020\u0001:\u0002fgB»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018B³\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\u0006\u0010E\u001a\u00020\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u000eHÆ\u0003J\t\u0010P\u001a\u00020\u0007HÆ\u0003J\t\u0010Q\u001a\u00020\u0007HÆ\u0003J\t\u0010R\u001a\u00020\u0007HÆ\u0003J\t\u0010S\u001a\u00020\u000eHÆ\u0003J\t\u0010T\u001a\u00020\u000eHÆ\u0003J\t\u0010U\u001a\u00020\u0007HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\t\u0010W\u001a\u00020\u0007HÆ\u0003J½\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0007HÆ\u0001J\u0013\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\u000eHÖ\u0001J\t\u0010]\u001a\u00020\u0003HÖ\u0001J%\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u00002\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dH\u0001¢\u0006\u0002\beR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010'R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010'R\u001c\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010'R\u001c\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010'R\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001e\u001a\u0004\b/\u0010 R\u001c\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010'R\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001e\u001a\u0004\b3\u00104R\u001c\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001e\u001a\u0004\b6\u0010'R\u001c\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u001e\u001a\u0004\b8\u0010'R\u001c\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u001e\u001a\u0004\b:\u0010'R\u001c\u0010\u0012\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\u001e\u001a\u0004\b<\u00104R\u001c\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\u001e\u001a\u0004\b>\u00104R\u001c\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\u001e\u001a\u0004\b@\u0010'R\u001c\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u001e\u001a\u0004\bB\u0010'R\u001c\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010\u001e\u001a\u0004\bD\u0010'¨\u0006h"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/AdTrackId;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.BUVID, "requestId", "accountId", RoomRecommendViewModel.EMPTY_CURSOR, "unitId", "creativeId", "sourceId", "salesType", "planId", "deviceType", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.AID, AdAlarmExtraKey.CID, "upMid", "ocpxTarget", "gameChannelId", "requestTime", "customId", "orderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/String;JIJJJIIJJJ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/String;JIJJJIIJJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMid$annotations", "()V", "getMid", "()Ljava/lang/String;", "getBuvid$annotations", "getBuvid", "getRequestId$annotations", "getRequestId", "getAccountId$annotations", "getAccountId", "()J", "getUnitId$annotations", "getUnitId", "getCreativeId$annotations", "getCreativeId", "getSourceId$annotations", "getSourceId", "getSalesType$annotations", "getSalesType", "getPlanId$annotations", "getPlanId", "getDeviceType$annotations", "getDeviceType", "()I", "getAid$annotations", "getAid", "getCid$annotations", "getCid", "getUpMid$annotations", "getUpMid", "getOcpxTarget$annotations", "getOcpxTarget", "getGameChannelId$annotations", "getGameChannelId", "getRequestTime$annotations", "getRequestTime", "getCustomId$annotations", "getCustomId", "getOrderId$annotations", "getOrderId", "toJson", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$ad_inspector_debug", "$serializer", "Companion", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdTrackId {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long accountId;
    private final long aid;
    private final String buvid;
    private final long cid;
    private final long creativeId;
    private final long customId;
    private final int deviceType;
    private final int gameChannelId;
    private final String mid;
    private final int ocpxTarget;
    private final long orderId;
    private final long planId;
    private final String requestId;
    private final long requestTime;
    private final String salesType;
    private final long sourceId;
    private final long unitId;
    private final long upMid;

    public AdTrackId() {
        this((String) null, (String) null, (String) null, 0L, 0L, 0L, 0L, (String) null, 0L, 0, 0L, 0L, 0L, 0, 0, 0L, 0L, 0L, 262143, (DefaultConstructorMarker) null);
    }

    @ProtoNumber(number = 4)
    public static /* synthetic */ void getAccountId$annotations() {
    }

    @ProtoNumber(number = AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER)
    public static /* synthetic */ void getAid$annotations() {
    }

    @ProtoNumber(number = 2)
    public static /* synthetic */ void getBuvid$annotations() {
    }

    @ProtoNumber(number = AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER)
    public static /* synthetic */ void getCid$annotations() {
    }

    @ProtoNumber(number = 6)
    public static /* synthetic */ void getCreativeId$annotations() {
    }

    @ProtoNumber(number = AdditionVote2.URI_FIELD_NUMBER)
    public static /* synthetic */ void getCustomId$annotations() {
    }

    @ProtoNumber(number = 10)
    public static /* synthetic */ void getDeviceType$annotations() {
    }

    @ProtoNumber(number = AdditionVote2.CARD_TYPE_FIELD_NUMBER)
    public static /* synthetic */ void getGameChannelId$annotations() {
    }

    @ProtoNumber(number = 1)
    public static /* synthetic */ void getMid$annotations() {
    }

    @ProtoNumber(number = AdditionVote2.TOTAL_FIELD_NUMBER)
    public static /* synthetic */ void getOcpxTarget$annotations() {
    }

    @ProtoNumber(number = AdditionVote2.IS_VOTED_FIELD_NUMBER)
    public static /* synthetic */ void getOrderId$annotations() {
    }

    @ProtoNumber(number = 9)
    public static /* synthetic */ void getPlanId$annotations() {
    }

    @ProtoNumber(number = 3)
    public static /* synthetic */ void getRequestId$annotations() {
    }

    @ProtoNumber(number = AdditionVote2.TIPS_FIELD_NUMBER)
    public static /* synthetic */ void getRequestTime$annotations() {
    }

    @ProtoNumber(number = 8)
    public static /* synthetic */ void getSalesType$annotations() {
    }

    @ProtoNumber(number = 7)
    public static /* synthetic */ void getSourceId$annotations() {
    }

    @ProtoNumber(number = 5)
    public static /* synthetic */ void getUnitId$annotations() {
    }

    @ProtoNumber(number = AdditionVote2.BIZ_TYPE_FIELD_NUMBER)
    public static /* synthetic */ void getUpMid$annotations() {
    }

    public final String component1() {
        return this.mid;
    }

    public final int component10() {
        return this.deviceType;
    }

    public final long component11() {
        return this.aid;
    }

    public final long component12() {
        return this.cid;
    }

    public final long component13() {
        return this.upMid;
    }

    public final int component14() {
        return this.ocpxTarget;
    }

    public final int component15() {
        return this.gameChannelId;
    }

    public final long component16() {
        return this.requestTime;
    }

    public final long component17() {
        return this.customId;
    }

    public final long component18() {
        return this.orderId;
    }

    public final String component2() {
        return this.buvid;
    }

    public final String component3() {
        return this.requestId;
    }

    public final long component4() {
        return this.accountId;
    }

    public final long component5() {
        return this.unitId;
    }

    public final long component6() {
        return this.creativeId;
    }

    public final long component7() {
        return this.sourceId;
    }

    public final String component8() {
        return this.salesType;
    }

    public final long component9() {
        return this.planId;
    }

    public final AdTrackId copy(String str, String str2, String str3, long j2, long j3, long j4, long j5, String str4, long j6, int i, long j7, long j8, long j9, int i2, int i3, long j10, long j11, long j12) {
        Intrinsics.checkNotNullParameter(str, ReportBuildInParam.MID);
        Intrinsics.checkNotNullParameter(str2, ReportBuildInParam.BUVID);
        Intrinsics.checkNotNullParameter(str3, "requestId");
        Intrinsics.checkNotNullParameter(str4, "salesType");
        return new AdTrackId(str, str2, str3, j2, j3, j4, j5, str4, j6, i, j7, j8, j9, i2, i3, j10, j11, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdTrackId) {
            AdTrackId adTrackId = (AdTrackId) obj;
            return Intrinsics.areEqual(this.mid, adTrackId.mid) && Intrinsics.areEqual(this.buvid, adTrackId.buvid) && Intrinsics.areEqual(this.requestId, adTrackId.requestId) && this.accountId == adTrackId.accountId && this.unitId == adTrackId.unitId && this.creativeId == adTrackId.creativeId && this.sourceId == adTrackId.sourceId && Intrinsics.areEqual(this.salesType, adTrackId.salesType) && this.planId == adTrackId.planId && this.deviceType == adTrackId.deviceType && this.aid == adTrackId.aid && this.cid == adTrackId.cid && this.upMid == adTrackId.upMid && this.ocpxTarget == adTrackId.ocpxTarget && this.gameChannelId == adTrackId.gameChannelId && this.requestTime == adTrackId.requestTime && this.customId == adTrackId.customId && this.orderId == adTrackId.orderId;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.mid.hashCode() * 31) + this.buvid.hashCode()) * 31) + this.requestId.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.accountId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.unitId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.creativeId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sourceId)) * 31) + this.salesType.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.planId)) * 31) + this.deviceType) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.upMid)) * 31) + this.ocpxTarget) * 31) + this.gameChannelId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.requestTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.customId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.orderId);
    }

    public String toString() {
        String str = this.mid;
        String str2 = this.buvid;
        String str3 = this.requestId;
        long j2 = this.accountId;
        long j3 = this.unitId;
        long j4 = this.creativeId;
        long j5 = this.sourceId;
        String str4 = this.salesType;
        long j6 = this.planId;
        int i = this.deviceType;
        long j7 = this.aid;
        long j8 = this.cid;
        long j9 = this.upMid;
        int i2 = this.ocpxTarget;
        int i3 = this.gameChannelId;
        long j10 = this.requestTime;
        long j11 = this.customId;
        return "AdTrackId(mid=" + str + ", buvid=" + str2 + ", requestId=" + str3 + ", accountId=" + j2 + ", unitId=" + j3 + ", creativeId=" + j4 + ", sourceId=" + j5 + ", salesType=" + str4 + ", planId=" + j6 + ", deviceType=" + i + ", aid=" + j7 + ", cid=" + j8 + ", upMid=" + j9 + ", ocpxTarget=" + i2 + ", gameChannelId=" + i3 + ", requestTime=" + j10 + ", customId=" + j11 + ", orderId=" + this.orderId + ")";
    }

    /* compiled from: AdTrackId.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/AdTrackId$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/ui/inspector/core/util/AdTrackId;", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdTrackId> serializer() {
            return new GeneratedSerializer<AdTrackId>() { // from class: kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.ui.inspector.core.util.AdTrackId", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.ui.inspector.core.util.AdTrackId> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.ui.inspector.core.util.AdTrackId> A[REMOVE]) =  kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer.INSTANCE kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer)
                         in method: kntr.app.ad.ui.inspector.core.util.AdTrackId.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.ui.inspector.core.util.AdTrackId>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.util.ArrayList.forEach(ArrayList.java:1257)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.ad.ui.inspector.core.util.AdTrackId")
                          (wrap: kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer A[REMOVE]) =  kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer.INSTANCE kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer)
                          (18 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:775)
                        	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:765)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer r0 = kntr.app.ad.ui.inspector.core.util.AdTrackId$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.ui.inspector.core.util.AdTrackId.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ AdTrackId(int seen0, String mid, String buvid, String requestId, long accountId, long unitId, long creativeId, long sourceId, String salesType, long planId, int deviceType, long aid, long cid, long upMid, int ocpxTarget, int gameChannelId, long requestTime, long customId, long orderId, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.mid = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.mid = mid;
                }
                if ((seen0 & 2) == 0) {
                    this.buvid = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.buvid = buvid;
                }
                if ((seen0 & 4) == 0) {
                    this.requestId = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.requestId = requestId;
                }
                if ((seen0 & 8) == 0) {
                    this.accountId = 0L;
                } else {
                    this.accountId = accountId;
                }
                if ((seen0 & 16) == 0) {
                    this.unitId = 0L;
                } else {
                    this.unitId = unitId;
                }
                if ((seen0 & 32) == 0) {
                    this.creativeId = 0L;
                } else {
                    this.creativeId = creativeId;
                }
                if ((seen0 & 64) == 0) {
                    this.sourceId = 0L;
                } else {
                    this.sourceId = sourceId;
                }
                if ((seen0 & 128) == 0) {
                    this.salesType = RoomRecommendViewModel.EMPTY_CURSOR;
                } else {
                    this.salesType = salesType;
                }
                if ((seen0 & 256) == 0) {
                    this.planId = 0L;
                } else {
                    this.planId = planId;
                }
                if ((seen0 & 512) == 0) {
                    this.deviceType = 0;
                } else {
                    this.deviceType = deviceType;
                }
                if ((seen0 & 1024) == 0) {
                    this.aid = 0L;
                } else {
                    this.aid = aid;
                }
                if ((seen0 & 2048) == 0) {
                    this.cid = 0L;
                } else {
                    this.cid = cid;
                }
                if ((seen0 & 4096) == 0) {
                    this.upMid = 0L;
                } else {
                    this.upMid = upMid;
                }
                if ((seen0 & 8192) == 0) {
                    this.ocpxTarget = 0;
                } else {
                    this.ocpxTarget = ocpxTarget;
                }
                if ((seen0 & 16384) == 0) {
                    this.gameChannelId = 0;
                } else {
                    this.gameChannelId = gameChannelId;
                }
                if ((32768 & seen0) == 0) {
                    this.requestTime = 0L;
                } else {
                    this.requestTime = requestTime;
                }
                if ((seen0 & 65536) == 0) {
                    this.customId = 0L;
                } else {
                    this.customId = customId;
                }
                if ((seen0 & 131072) == 0) {
                    this.orderId = 0L;
                } else {
                    this.orderId = orderId;
                }
            }

            public AdTrackId(String mid, String buvid, String requestId, long accountId, long unitId, long creativeId, long sourceId, String salesType, long planId, int deviceType, long aid, long cid, long upMid, int ocpxTarget, int gameChannelId, long requestTime, long customId, long orderId) {
                Intrinsics.checkNotNullParameter(mid, ReportBuildInParam.MID);
                Intrinsics.checkNotNullParameter(buvid, ReportBuildInParam.BUVID);
                Intrinsics.checkNotNullParameter(requestId, "requestId");
                Intrinsics.checkNotNullParameter(salesType, "salesType");
                this.mid = mid;
                this.buvid = buvid;
                this.requestId = requestId;
                this.accountId = accountId;
                this.unitId = unitId;
                this.creativeId = creativeId;
                this.sourceId = sourceId;
                this.salesType = salesType;
                this.planId = planId;
                this.deviceType = deviceType;
                this.aid = aid;
                this.cid = cid;
                this.upMid = upMid;
                this.ocpxTarget = ocpxTarget;
                this.gameChannelId = gameChannelId;
                this.requestTime = requestTime;
                this.customId = customId;
                this.orderId = orderId;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$ad_inspector_debug(AdTrackId self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.mid, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 0, self.mid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.buvid, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 1, self.buvid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.requestId, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 2, self.requestId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.accountId != 0) {
                    output.encodeLongElement(serialDesc, 3, self.accountId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.unitId != 0) {
                    output.encodeLongElement(serialDesc, 4, self.unitId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.creativeId != 0) {
                    output.encodeLongElement(serialDesc, 5, self.creativeId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.sourceId != 0) {
                    output.encodeLongElement(serialDesc, 6, self.sourceId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.salesType, RoomRecommendViewModel.EMPTY_CURSOR)) {
                    output.encodeStringElement(serialDesc, 7, self.salesType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.planId != 0) {
                    output.encodeLongElement(serialDesc, 8, self.planId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.deviceType != 0) {
                    output.encodeIntElement(serialDesc, 9, self.deviceType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.aid != 0) {
                    output.encodeLongElement(serialDesc, 10, self.aid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.cid != 0) {
                    output.encodeLongElement(serialDesc, 11, self.cid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.upMid != 0) {
                    output.encodeLongElement(serialDesc, 12, self.upMid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.ocpxTarget != 0) {
                    output.encodeIntElement(serialDesc, 13, self.ocpxTarget);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.gameChannelId != 0) {
                    output.encodeIntElement(serialDesc, 14, self.gameChannelId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.requestTime != 0) {
                    output.encodeLongElement(serialDesc, 15, self.requestTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.customId != 0) {
                    output.encodeLongElement(serialDesc, 16, self.customId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.orderId != 0) {
                    output.encodeLongElement(serialDesc, 17, self.orderId);
                }
            }

            public /* synthetic */ AdTrackId(String str, String str2, String str3, long j2, long j3, long j4, long j5, String str4, long j6, int i, long j7, long j8, long j9, int i2, int i3, long j10, long j11, long j12, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this((i4 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i4 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i4 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i4 & 8) != 0 ? 0L : j2, (i4 & 16) != 0 ? 0L : j3, (i4 & 32) != 0 ? 0L : j4, (i4 & 64) != 0 ? 0L : j5, (i4 & 128) == 0 ? str4 : RoomRecommendViewModel.EMPTY_CURSOR, (i4 & 256) != 0 ? 0L : j6, (i4 & 512) != 0 ? 0 : i, (i4 & 1024) != 0 ? 0L : j7, (i4 & 2048) != 0 ? 0L : j8, (i4 & 4096) != 0 ? 0L : j9, (i4 & 8192) != 0 ? 0 : i2, (i4 & 16384) == 0 ? i3 : 0, (32768 & i4) != 0 ? 0L : j10, (65536 & i4) != 0 ? 0L : j11, (i4 & 131072) != 0 ? 0L : j12);
            }

            public final String getMid() {
                return this.mid;
            }

            public final String getBuvid() {
                return this.buvid;
            }

            public final String getRequestId() {
                return this.requestId;
            }

            public final long getAccountId() {
                return this.accountId;
            }

            public final long getUnitId() {
                return this.unitId;
            }

            public final long getCreativeId() {
                return this.creativeId;
            }

            public final long getSourceId() {
                return this.sourceId;
            }

            public final String getSalesType() {
                return this.salesType;
            }

            public final long getPlanId() {
                return this.planId;
            }

            public final int getDeviceType() {
                return this.deviceType;
            }

            public final long getAid() {
                return this.aid;
            }

            public final long getCid() {
                return this.cid;
            }

            public final long getUpMid() {
                return this.upMid;
            }

            public final int getOcpxTarget() {
                return this.ocpxTarget;
            }

            public final int getGameChannelId() {
                return this.gameChannelId;
            }

            public final long getRequestTime() {
                return this.requestTime;
            }

            public final long getCustomId() {
                return this.customId;
            }

            public final long getOrderId() {
                return this.orderId;
            }

            public final String toJson() {
                String str;
                String str2;
                int i;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7 = this.mid;
                String str8 = this.buvid;
                String str9 = this.requestId;
                long j2 = this.accountId;
                long j3 = this.unitId;
                long j4 = this.creativeId;
                long j5 = this.sourceId;
                String str10 = this.salesType;
                long j6 = this.planId;
                int i2 = this.deviceType;
                int i3 = this.ocpxTarget;
                long j7 = this.customId;
                if (this.aid > 0) {
                    str2 = RoomRecommendViewModel.EMPTY_CURSOR;
                    i = i3;
                    str = str10;
                    str3 = ", \"aid\": " + this.aid;
                } else {
                    str = str10;
                    str2 = RoomRecommendViewModel.EMPTY_CURSOR;
                    i = i3;
                    str3 = str2;
                }
                if (this.cid > 0) {
                    str4 = str3;
                    str5 = ", \"cid\": " + this.cid;
                } else {
                    str4 = str3;
                    str5 = str2;
                }
                if (this.upMid > 0) {
                    str6 = ", \"up_mid\": " + this.upMid;
                } else {
                    str6 = str2;
                }
                return StringsKt.replace$default(StringsKt.replace$default(StringsKt.trimIndent("\n            {\n                \"mid\": \"" + str7 + "\",\n                \"buvid\": \"" + str8 + "\",\n                \"request_id\": \"" + str9 + "\",\n                \"account_id\": " + j2 + ",\n                \"unit_id\": \"" + j3 + "\",\n                \"creative_id\": \"" + j4 + "\",\n                \"source_id\": " + j5 + ",\n                \"sales_type\": \"" + str + "\",\n                \"plan_id\": " + j6 + ",\n                \"device_type\": " + i2 + ",\n                \"ocpx_target\": " + i + ",\n                \"custom_id\": " + j7 + "\n                " + str4 + "\n                " + str5 + "\n                " + str6 + "\n            }\n            "), "\n", RoomRecommendViewModel.EMPTY_CURSOR, false, 4, (Object) null), "    ", RoomRecommendViewModel.EMPTY_CURSOR, false, 4, (Object) null);
            }
        }