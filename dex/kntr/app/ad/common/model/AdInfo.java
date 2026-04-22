package kntr.app.ad.common.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.common.protocol.IAdInfo;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonNames;

/* compiled from: AdInfo.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\bW\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008c\u00012\u00020\u0001:\u0004\u008b\u0001\u008c\u0001BÏ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bB\u008b\u0002\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\b\u0010\"\u001a\u0004\u0018\u00010\b\u0012\b\u0010#\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020\u0012\u0012\b\u0010&\u001a\u0004\u0018\u00010\b\u0012\b\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0004\b\u001a\u0010)J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0005HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\t\u0010u\u001a\u00020\u0005HÆ\u0003J\t\u0010v\u001a\u00020\u0012HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010y\u001a\u00020\u0012HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010{\u001a\u00020\u0005HÆ\u0003J\t\u0010|\u001a\u00020\u0012HÆ\u0003JÑ\u0001\u0010}\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0012HÆ\u0001J\u0014\u0010~\u001a\u00020\u00032\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001HÖ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0012HÖ\u0001J\n\u0010\u0082\u0001\u001a\u00020\bHÖ\u0001J-\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u00002\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0001¢\u0006\u0003\b\u008a\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010+\u001a\u0004\b\u0002\u0010,R\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010+\u001a\u0004\b.\u0010/R\u001c\u0010\u0006\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010+\u001a\u0004\b1\u0010/R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010+\u001a\u0004\b3\u00104R\u001c\u0010\t\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010+\u001a\u0004\b6\u0010/R\u001e\u0010\n\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010+\u001a\u0004\b8\u00104R\u001c\u0010\u000b\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010+\u001a\u0004\b:\u0010/R\u001c\u0010\f\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010+\u001a\u0004\b<\u0010/R\u001c\u0010\r\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010+\u001a\u0004\b>\u0010/R\u001c\u0010\u000e\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010+\u001a\u0004\b\u000e\u0010,R\u001c\u0010\u000f\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010+\u001a\u0004\bA\u0010/R\u001c\u0010\u0010\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010+\u001a\u0004\bC\u0010/R\u001c\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010+\u001a\u0004\bE\u0010FR&\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bG\u0010+\u001a\u0004\bH\u00104\"\u0004\bI\u0010JR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010+\u001a\u0004\bL\u00104R\u001c\u0010\u0015\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010+\u001a\u0004\bN\u0010FR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010+\u001a\u0004\bP\u0010QR\u001c\u0010\u0018\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010+\u001a\u0004\bS\u0010/R\u001c\u0010\u0019\u001a\u00020\u00128\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bT\u0010+\u001a\u0004\bU\u0010FR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u00104R\u0014\u0010\u001e\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010/R\u0014\u0010\u001f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010/R\u0014\u0010 \u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010/R\u0014\u0010!\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010FR\u0016\u0010\"\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u00104R\u0016\u0010#\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u00104R\u0014\u0010$\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010/R\u0014\u0010%\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010FR\u0016\u0010&\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u00104R$\u0010`\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\ba\u0010+\u001a\u0004\bb\u0010/\"\u0004\bc\u0010dR$\u0010e\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bf\u0010+\u001a\u0004\bg\u0010,\"\u0004\bh\u0010i¨\u0006\u008d\u0001"}, d2 = {"Lkntr/app/ad/common/model/AdInfo;", "Lkntr/app/ad/common/protocol/IAdInfo;", "isAdLoc", RoomRecommendViewModel.EMPTY_CURSOR, "sourceId", RoomRecommendViewModel.EMPTY_CURSOR, "resourceId", "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "serverType", ReportBuildInParam.IP, "index", "cardIndex", ReportBuildInParam.ID, "isAd", "creativeId", "creativeType", "creativeStyle", RoomRecommendViewModel.EMPTY_CURSOR, "cardType", "adCb", "cmMark", "extra", "Lkntr/app/ad/common/model/AdInfoExtra;", "liveBookingId", "natureAd", "<init>", "(ZJJLjava/lang/String;JLjava/lang/String;JJJZJJILjava/lang/String;Ljava/lang/String;ILkntr/app/ad/common/model/AdInfoExtra;JI)V", "seen0", "track_id", "shopId", "upMid", "productId", "replaceStrategy", "fromTrackId", "cmFromTrackId", "itemId", "itemSource", "extraParams", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZJJLjava/lang/String;JLjava/lang/String;JJJZJJILjava/lang/String;Ljava/lang/String;IJILjava/lang/String;JJJILjava/lang/String;Ljava/lang/String;JILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "isAdLoc$annotations", "()V", "()Z", "getSourceId$annotations", "getSourceId", "()J", "getResourceId$annotations", "getResourceId", "getRequestId$annotations", "getRequestId", "()Ljava/lang/String;", "getServerType$annotations", "getServerType", "getIp$annotations", "getIp", "getIndex$annotations", "getIndex", "getCardIndex$annotations", "getCardIndex", "getId$annotations", "getId", "isAd$annotations", "getCreativeId$annotations", "getCreativeId", "getCreativeType$annotations", "getCreativeType", "getCreativeStyle$annotations", "getCreativeStyle", "()I", "getCardType$annotations", "getCardType", "setCardType", "(Ljava/lang/String;)V", "getAdCb$annotations", "getAdCb", "getCmMark$annotations", "getCmMark", "getExtra$annotations", "getExtra", "()Lkntr/app/ad/common/model/AdInfoExtra;", "getLiveBookingId$annotations", "getLiveBookingId", "getNatureAd$annotations", "getNatureAd", "getTrack_id", "getShopId", "getUpMid", "getProductId", "getReplaceStrategy", "getFromTrackId", "getCmFromTrackId", "getItemId", "getItemSource", "getExtraParams", "avid", "getAvid$annotations", "getAvid", "setAvid", "(J)V", "buttonShow", "getButtonShow$annotations", "getButtonShow", "setButtonShow", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdInfo implements IAdInfo {
    public static final Companion Companion = new Companion(null);
    private final String adCb;
    private long avid;
    private boolean buttonShow;
    private final long cardIndex;
    private String cardType;
    private final String cmFromTrackId;
    private final int cmMark;
    private final long creativeId;
    private final int creativeStyle;
    private final long creativeType;
    private final AdInfoExtra extra;
    private final String extraParams;
    private final String fromTrackId;
    private final long id;
    private final long index;
    private final String ip;
    private final boolean isAd;
    private final boolean isAdLoc;
    private final long itemId;
    private final int itemSource;
    private final long liveBookingId;
    private final int natureAd;
    private final long productId;
    private final int replaceStrategy;
    private final String requestId;
    private final long resourceId;
    private final long serverType;
    private final long shopId;
    private final long sourceId;
    private final String track_id;
    private final long upMid;

    public AdInfo() {
        this(false, 0L, 0L, null, 0L, null, 0L, 0L, 0L, false, 0L, 0L, 0, null, null, 0, null, 0L, 0, 524287, null);
    }

    public static /* synthetic */ AdInfo copy$default(AdInfo adInfo, boolean z, long j2, long j3, String str, long j4, String str2, long j5, long j6, long j7, boolean z2, long j8, long j9, int i, String str3, String str4, int i2, AdInfoExtra adInfoExtra, long j10, int i3, int i4, Object obj) {
        boolean z3 = (i4 & 1) != 0 ? adInfo.isAdLoc : z;
        long j11 = (i4 & 2) != 0 ? adInfo.sourceId : j2;
        long j12 = (i4 & 4) != 0 ? adInfo.resourceId : j3;
        String str5 = (i4 & 8) != 0 ? adInfo.requestId : str;
        long j13 = (i4 & 16) != 0 ? adInfo.serverType : j4;
        String str6 = (i4 & 32) != 0 ? adInfo.ip : str2;
        long j14 = (i4 & 64) != 0 ? adInfo.index : j5;
        long j15 = (i4 & 128) != 0 ? adInfo.cardIndex : j6;
        long j16 = (i4 & 256) != 0 ? adInfo.id : j7;
        return adInfo.copy(z3, j11, j12, str5, j13, str6, j14, j15, j16, (i4 & 512) != 0 ? adInfo.isAd : z2, (i4 & 1024) != 0 ? adInfo.creativeId : j8, (i4 & 2048) != 0 ? adInfo.creativeType : j9, (i4 & 4096) != 0 ? adInfo.creativeStyle : i, (i4 & 8192) != 0 ? adInfo.cardType : str3, (i4 & 16384) != 0 ? adInfo.adCb : str4, (i4 & 32768) != 0 ? adInfo.cmMark : i2, (i4 & 65536) != 0 ? adInfo.extra : adInfoExtra, (i4 & 131072) != 0 ? adInfo.liveBookingId : j10, (i4 & 262144) != 0 ? adInfo.natureAd : i3);
    }

    @SerialName("ad_cb")
    public static /* synthetic */ void getAdCb$annotations() {
    }

    @Transient
    public static /* synthetic */ void getAvid$annotations() {
    }

    @Transient
    public static /* synthetic */ void getButtonShow$annotations() {
    }

    @SerialName(ReportBuildInParam.CARD_INDEX)
    public static /* synthetic */ void getCardIndex$annotations() {
    }

    @SerialName(ReportBuildInParam.CARD_TYPE)
    public static /* synthetic */ void getCardType$annotations() {
    }

    @SerialName(ReportBuildInParam.CM_MARK)
    public static /* synthetic */ void getCmMark$annotations() {
    }

    @SerialName(ReportBuildInParam.CREATIVE_ID)
    public static /* synthetic */ void getCreativeId$annotations() {
    }

    @SerialName(ReportBuildInParam.CREATIVE_STYLE)
    public static /* synthetic */ void getCreativeStyle$annotations() {
    }

    @SerialName(ReportBuildInParam.CREATIVE_TYPE)
    public static /* synthetic */ void getCreativeType$annotations() {
    }

    @SerialName("extra")
    @Transient
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName(ReportBuildInParam.ID)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("index")
    public static /* synthetic */ void getIndex$annotations() {
    }

    @SerialName("client_ip")
    public static /* synthetic */ void getIp$annotations() {
    }

    @SerialName("live_booking_id")
    public static /* synthetic */ void getLiveBookingId$annotations() {
    }

    @SerialName(ReportBuildInParam.NATURE_AD)
    public static /* synthetic */ void getNatureAd$annotations() {
    }

    @SerialName(ReportBuildInParam.REQUEST_ID)
    public static /* synthetic */ void getRequestId$annotations() {
    }

    @SerialName(ReportBuildInParam.RESOURCE_ID)
    @JsonNames(names = {ReportBuildInParam.RESOURCE_ID, "resource"})
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName(ReportBuildInParam.SERVER_TYPE)
    public static /* synthetic */ void getServerType$annotations() {
    }

    @SerialName("source_id")
    @JsonNames(names = {"source_id", "source", ReportBuildInParam.SRC_ID})
    public static /* synthetic */ void getSourceId$annotations() {
    }

    @SerialName(ReportBuildInParam.IS_AD)
    public static /* synthetic */ void isAd$annotations() {
    }

    @SerialName("is_ad_loc")
    public static /* synthetic */ void isAdLoc$annotations() {
    }

    public final boolean component1() {
        return this.isAdLoc;
    }

    public final boolean component10() {
        return this.isAd;
    }

    public final long component11() {
        return this.creativeId;
    }

    public final long component12() {
        return this.creativeType;
    }

    public final int component13() {
        return this.creativeStyle;
    }

    public final String component14() {
        return this.cardType;
    }

    public final String component15() {
        return this.adCb;
    }

    public final int component16() {
        return this.cmMark;
    }

    public final AdInfoExtra component17() {
        return this.extra;
    }

    public final long component18() {
        return this.liveBookingId;
    }

    public final int component19() {
        return this.natureAd;
    }

    public final long component2() {
        return this.sourceId;
    }

    public final long component3() {
        return this.resourceId;
    }

    public final String component4() {
        return this.requestId;
    }

    public final long component5() {
        return this.serverType;
    }

    public final String component6() {
        return this.ip;
    }

    public final long component7() {
        return this.index;
    }

    public final long component8() {
        return this.cardIndex;
    }

    public final long component9() {
        return this.id;
    }

    public final AdInfo copy(boolean z, long j2, long j3, String str, long j4, String str2, long j5, long j6, long j7, boolean z2, long j8, long j9, int i, String str3, String str4, int i2, AdInfoExtra adInfoExtra, long j10, int i3) {
        return new AdInfo(z, j2, j3, str, j4, str2, j5, j6, j7, z2, j8, j9, i, str3, str4, i2, adInfoExtra, j10, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdInfo) {
            AdInfo adInfo = (AdInfo) obj;
            return this.isAdLoc == adInfo.isAdLoc && this.sourceId == adInfo.sourceId && this.resourceId == adInfo.resourceId && Intrinsics.areEqual(this.requestId, adInfo.requestId) && this.serverType == adInfo.serverType && Intrinsics.areEqual(this.ip, adInfo.ip) && this.index == adInfo.index && this.cardIndex == adInfo.cardIndex && this.id == adInfo.id && this.isAd == adInfo.isAd && this.creativeId == adInfo.creativeId && this.creativeType == adInfo.creativeType && this.creativeStyle == adInfo.creativeStyle && Intrinsics.areEqual(this.cardType, adInfo.cardType) && Intrinsics.areEqual(this.adCb, adInfo.adCb) && this.cmMark == adInfo.cmMark && Intrinsics.areEqual(this.extra, adInfo.extra) && this.liveBookingId == adInfo.liveBookingId && this.natureAd == adInfo.natureAd;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAdLoc) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sourceId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.resourceId)) * 31) + (this.requestId == null ? 0 : this.requestId.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.serverType)) * 31) + (this.ip == null ? 0 : this.ip.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.index)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardIndex)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAd)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.creativeId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.creativeType)) * 31) + this.creativeStyle) * 31) + (this.cardType == null ? 0 : this.cardType.hashCode())) * 31) + (this.adCb == null ? 0 : this.adCb.hashCode())) * 31) + this.cmMark) * 31) + (this.extra != null ? this.extra.hashCode() : 0)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.liveBookingId)) * 31) + this.natureAd;
    }

    public String toString() {
        boolean z = this.isAdLoc;
        long j2 = this.sourceId;
        long j3 = this.resourceId;
        String str = this.requestId;
        long j4 = this.serverType;
        String str2 = this.ip;
        long j5 = this.index;
        long j6 = this.cardIndex;
        long j7 = this.id;
        boolean z2 = this.isAd;
        long j8 = this.creativeId;
        long j9 = this.creativeType;
        int i = this.creativeStyle;
        String str3 = this.cardType;
        String str4 = this.adCb;
        int i2 = this.cmMark;
        AdInfoExtra adInfoExtra = this.extra;
        long j10 = this.liveBookingId;
        return "AdInfo(isAdLoc=" + z + ", sourceId=" + j2 + ", resourceId=" + j3 + ", requestId=" + str + ", serverType=" + j4 + ", ip=" + str2 + ", index=" + j5 + ", cardIndex=" + j6 + ", id=" + j7 + ", isAd=" + z2 + ", creativeId=" + j8 + ", creativeType=" + j9 + ", creativeStyle=" + i + ", cardType=" + str3 + ", adCb=" + str4 + ", cmMark=" + i2 + ", extra=" + adInfoExtra + ", liveBookingId=" + j10 + ", natureAd=" + this.natureAd + ")";
    }

    /* compiled from: AdInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdInfo> serializer() {
            return AdInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdInfo(int seen0, boolean isAdLoc, long sourceId, long resourceId, String requestId, long serverType, String ip, long index, long cardIndex, long id, boolean isAd, long creativeId, long creativeType, int creativeStyle, String cardType, String adCb, int cmMark, long liveBookingId, int natureAd, String track_id, long shopId, long upMid, long productId, int replaceStrategy, String fromTrackId, String cmFromTrackId, long itemId, int itemSource, String extraParams, SerializationConstructorMarker serializationConstructorMarker) {
        AdInfoCard card;
        Number number;
        AdInfoCard card2;
        Number number2;
        AdInfoCard card3;
        Number number3;
        Number number4;
        Number number5;
        Number number6;
        if ((seen0 & 1) == 0) {
            this.isAdLoc = false;
        } else {
            this.isAdLoc = isAdLoc;
        }
        if ((seen0 & 2) == 0) {
            this.sourceId = 0L;
        } else {
            this.sourceId = sourceId;
        }
        if ((seen0 & 4) == 0) {
            this.resourceId = 0L;
        } else {
            this.resourceId = resourceId;
        }
        if ((seen0 & 8) == 0) {
            this.requestId = null;
        } else {
            this.requestId = requestId;
        }
        if ((seen0 & 16) == 0) {
            this.serverType = -1L;
        } else {
            this.serverType = serverType;
        }
        if ((seen0 & 32) == 0) {
            this.ip = null;
        } else {
            this.ip = ip;
        }
        if ((seen0 & 64) == 0) {
            this.index = 0L;
        } else {
            this.index = index;
        }
        if ((seen0 & 128) == 0) {
            this.cardIndex = -1L;
        } else {
            this.cardIndex = cardIndex;
        }
        if ((seen0 & 256) == 0) {
            this.id = 0L;
        } else {
            this.id = id;
        }
        if ((seen0 & 512) == 0) {
            this.isAd = false;
        } else {
            this.isAd = isAd;
        }
        if ((seen0 & 1024) == 0) {
            this.creativeId = 0L;
        } else {
            this.creativeId = creativeId;
        }
        if ((seen0 & 2048) == 0) {
            this.creativeType = 0L;
        } else {
            this.creativeType = creativeType;
        }
        if ((seen0 & 4096) == 0) {
            this.creativeStyle = 0;
        } else {
            this.creativeStyle = creativeStyle;
        }
        if ((seen0 & 8192) == 0) {
            this.cardType = null;
        } else {
            this.cardType = cardType;
        }
        if ((seen0 & 16384) == 0) {
            this.adCb = null;
        } else {
            this.adCb = adCb;
        }
        if ((seen0 & 32768) == 0) {
            this.cmMark = 0;
        } else {
            this.cmMark = cmMark;
        }
        this.extra = null;
        if ((seen0 & 65536) == 0) {
            this.liveBookingId = 0L;
        } else {
            this.liveBookingId = liveBookingId;
        }
        if ((seen0 & 131072) == 0) {
            this.natureAd = 0;
        } else {
            this.natureAd = natureAd;
        }
        if ((seen0 & 262144) == 0) {
            AdInfoExtra extra = getExtra();
            this.track_id = extra != null ? extra.getTrackId() : null;
        } else {
            this.track_id = track_id;
        }
        if ((seen0 & 524288) == 0) {
            AdInfoExtra extra2 = getExtra();
            Number $this$orZero$iv = extra2 != null ? Long.valueOf(extra2.getShopId()) : null;
            if ($this$orZero$iv == null) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number6 = (Long) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number6 = (Long) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number6 = (Number) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number6 = (Long) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number6 = (Long) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number6 = (Long) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number6 = (Long) (byte) 0;
                }
            } else {
                number6 = $this$orZero$iv;
            }
            this.shopId = number6.longValue();
        } else {
            this.shopId = shopId;
        }
        if ((seen0 & 1048576) == 0) {
            AdInfoExtra extra3 = getExtra();
            Number $this$orZero$iv2 = extra3 != null ? Long.valueOf(extra3.getUpMid()) : null;
            if ($this$orZero$iv2 == null) {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number5 = (Long) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number5 = (Long) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number5 = (Number) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number5 = (Long) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number5 = (Long) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number5 = (Long) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number5 = (Long) (byte) 0;
                }
            } else {
                number5 = $this$orZero$iv2;
            }
            this.upMid = number5.longValue();
        } else {
            this.upMid = upMid;
        }
        if ((seen0 & 2097152) == 0) {
            AdInfoExtra extra4 = getExtra();
            Number $this$orZero$iv3 = extra4 != null ? Long.valueOf(extra4.getProductId()) : null;
            if ($this$orZero$iv3 == null) {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number4 = (Long) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number4 = (Long) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number4 = (Number) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number4 = (Long) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number4 = (Long) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number4 = (Long) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number4 = (Long) (byte) 0;
                }
            } else {
                number4 = $this$orZero$iv3;
            }
            this.productId = number4.longValue();
        } else {
            this.productId = productId;
        }
        if ((seen0 & 4194304) == 0) {
            AdInfoExtra extra5 = getExtra();
            Number $this$orZero$iv4 = extra5 != null ? Integer.valueOf(extra5.getMacroReplacePriority()) : null;
            if ($this$orZero$iv4 == null) {
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number3 = (Integer) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number3 = (Integer) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number3 = (Integer) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number3 = (Number) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number3 = (Integer) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number3 = (Integer) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number3 = (Integer) (byte) 0;
                }
            } else {
                number3 = $this$orZero$iv4;
            }
            this.replaceStrategy = number3.intValue();
        } else {
            this.replaceStrategy = replaceStrategy;
        }
        if ((seen0 & 8388608) == 0) {
            AdInfoExtra extra6 = getExtra();
            this.fromTrackId = extra6 != null ? extra6.getFromTrackId() : null;
        } else {
            this.fromTrackId = fromTrackId;
        }
        if ((seen0 & 16777216) == 0) {
            AdInfoExtra extra7 = getExtra();
            this.cmFromTrackId = extra7 != null ? extra7.getCmFromTrackId() : null;
        } else {
            this.cmFromTrackId = cmFromTrackId;
        }
        if ((seen0 & 33554432) == 0) {
            AdInfoExtra extra8 = getExtra();
            Number $this$orZero$iv5 = (extra8 == null || (card3 = extra8.getCard()) == null) ? null : Long.valueOf(card3.getGoodsItemId());
            if ($this$orZero$iv5 == null) {
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number2 = (Long) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number2 = (Long) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number2 = (Number) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number2 = (Long) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number2 = (Long) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number2 = (Long) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number2 = (Long) (byte) 0;
                }
            } else {
                number2 = $this$orZero$iv5;
            }
            this.itemId = number2.longValue();
        } else {
            this.itemId = itemId;
        }
        if ((seen0 & 67108864) == 0) {
            AdInfoExtra extra9 = getExtra();
            Number $this$orZero$iv6 = (extra9 == null || (card2 = extra9.getCard()) == null) ? null : Integer.valueOf(card2.getGoodsItemSource());
            if ($this$orZero$iv6 == null) {
                KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    number = (Integer) Double.valueOf(0.0d);
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    number = (Integer) Float.valueOf(0.0f);
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    number = (Integer) 0L;
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    number = (Number) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                    number = (Integer) (char) 0;
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    number = (Integer) (short) 0;
                } else if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new RuntimeException("not primitive number type");
                } else {
                    number = (Integer) (byte) 0;
                }
            } else {
                number = $this$orZero$iv6;
            }
            this.itemSource = number.intValue();
        } else {
            this.itemSource = itemSource;
        }
        if ((134217728 & seen0) == 0) {
            AdInfoExtra extra10 = getExtra();
            this.extraParams = (extra10 == null || (card = extra10.getCard()) == null) ? null : card.getExtraParams();
        } else {
            this.extraParams = extraParams;
        }
        this.avid = 0L;
        this.buttonShow = false;
    }

    public AdInfo(boolean isAdLoc, long sourceId, long resourceId, String requestId, long serverType, String ip, long index, long cardIndex, long id, boolean isAd, long creativeId, long creativeType, int creativeStyle, String cardType, String adCb, int cmMark, AdInfoExtra extra, long liveBookingId, int natureAd) {
        Number number;
        AdInfoCard card;
        AdInfoCard card2;
        AdInfoCard card3;
        this.isAdLoc = isAdLoc;
        this.sourceId = sourceId;
        this.resourceId = resourceId;
        this.requestId = requestId;
        this.serverType = serverType;
        this.ip = ip;
        this.index = index;
        this.cardIndex = cardIndex;
        this.id = id;
        this.isAd = isAd;
        this.creativeId = creativeId;
        this.creativeType = creativeType;
        this.creativeStyle = creativeStyle;
        this.cardType = cardType;
        this.adCb = adCb;
        this.cmMark = cmMark;
        this.extra = extra;
        this.liveBookingId = liveBookingId;
        this.natureAd = natureAd;
        AdInfoExtra extra2 = getExtra();
        String str = null;
        this.track_id = extra2 != null ? extra2.getTrackId() : null;
        AdInfoExtra extra3 = getExtra();
        Number $this$orZero$iv = extra3 != null ? Long.valueOf(extra3.getShopId()) : null;
        if ($this$orZero$iv == null) {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                $this$orZero$iv = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                $this$orZero$iv = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                $this$orZero$iv = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                $this$orZero$iv = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                $this$orZero$iv = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                $this$orZero$iv = (Long) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                $this$orZero$iv = (Long) (byte) 0;
            }
        }
        this.shopId = $this$orZero$iv.longValue();
        AdInfoExtra extra4 = getExtra();
        Number $this$orZero$iv2 = extra4 != null ? Long.valueOf(extra4.getUpMid()) : null;
        if ($this$orZero$iv2 == null) {
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                $this$orZero$iv2 = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                $this$orZero$iv2 = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                $this$orZero$iv2 = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                $this$orZero$iv2 = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                $this$orZero$iv2 = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                $this$orZero$iv2 = (Long) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                $this$orZero$iv2 = (Long) (byte) 0;
            }
        }
        this.upMid = $this$orZero$iv2.longValue();
        AdInfoExtra extra5 = getExtra();
        Number $this$orZero$iv3 = extra5 != null ? Long.valueOf(extra5.getProductId()) : null;
        if ($this$orZero$iv3 == null) {
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                $this$orZero$iv3 = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                $this$orZero$iv3 = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                $this$orZero$iv3 = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                $this$orZero$iv3 = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                $this$orZero$iv3 = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                $this$orZero$iv3 = (Long) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                $this$orZero$iv3 = (Long) (byte) 0;
            }
        }
        this.productId = $this$orZero$iv3.longValue();
        AdInfoExtra extra6 = getExtra();
        Number $this$orZero$iv4 = extra6 != null ? Integer.valueOf(extra6.getMacroReplacePriority()) : null;
        if ($this$orZero$iv4 == null) {
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                $this$orZero$iv4 = (Integer) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                $this$orZero$iv4 = (Integer) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                $this$orZero$iv4 = (Integer) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                $this$orZero$iv4 = (Number) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                $this$orZero$iv4 = (Integer) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                $this$orZero$iv4 = (Integer) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                $this$orZero$iv4 = (Integer) (byte) 0;
            }
        }
        this.replaceStrategy = $this$orZero$iv4.intValue();
        AdInfoExtra extra7 = getExtra();
        this.fromTrackId = extra7 != null ? extra7.getFromTrackId() : null;
        AdInfoExtra extra8 = getExtra();
        this.cmFromTrackId = extra8 != null ? extra8.getCmFromTrackId() : null;
        AdInfoExtra extra9 = getExtra();
        Number $this$orZero$iv5 = (extra9 == null || (card3 = extra9.getCard()) == null) ? null : Long.valueOf(card3.getGoodsItemId());
        if ($this$orZero$iv5 == null) {
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                $this$orZero$iv5 = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                $this$orZero$iv5 = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                $this$orZero$iv5 = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                $this$orZero$iv5 = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                $this$orZero$iv5 = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                $this$orZero$iv5 = (Long) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                $this$orZero$iv5 = (Long) (byte) 0;
            }
        }
        this.itemId = $this$orZero$iv5.longValue();
        AdInfoExtra extra10 = getExtra();
        Number $this$orZero$iv6 = (extra10 == null || (card2 = extra10.getCard()) == null) ? null : Integer.valueOf(card2.getGoodsItemSource());
        if ($this$orZero$iv6 != null) {
            number = $this$orZero$iv6;
        } else {
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                number = (Integer) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                number = (Integer) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                number = (Integer) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                number = (Number) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                number = (Integer) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                number = (Integer) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                number = (Integer) (byte) 0;
            }
        }
        this.itemSource = number.intValue();
        AdInfoExtra extra11 = getExtra();
        if (extra11 != null && (card = extra11.getCard()) != null) {
            str = card.getExtraParams();
        }
        this.extraParams = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x06df  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x06f3  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x07b4  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x07e9  */
    /* JADX WARN: Removed duplicated region for block: B:457:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void write$Self$dto_debug(AdInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z;
        Number number;
        boolean z2;
        Number number2;
        boolean z3;
        Number number3;
        boolean z4;
        boolean z5;
        boolean z6;
        Number number4;
        boolean z7;
        AdInfoCard card;
        Number number5;
        boolean z8;
        AdInfoCard card2;
        boolean z9;
        AdInfoCard card3;
        Number number6;
        boolean z10 = true;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.isAdLoc()) {
            output.encodeBooleanElement(serialDesc, 0, self.isAdLoc());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getSourceId() != 0) {
            output.encodeLongElement(serialDesc, 1, self.getSourceId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getResourceId() != 0) {
            output.encodeLongElement(serialDesc, 2, self.getResourceId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getRequestId() != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.getRequestId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.getServerType() != -1) {
            output.encodeLongElement(serialDesc, 4, self.getServerType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.getIp() != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.getIp());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.getIndex() != 0) {
            output.encodeLongElement(serialDesc, 6, self.getIndex());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.getCardIndex() != -1) {
            output.encodeLongElement(serialDesc, 7, self.getCardIndex());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.getId() != 0) {
            output.encodeLongElement(serialDesc, 8, self.getId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.isAd()) {
            output.encodeBooleanElement(serialDesc, 9, self.isAd());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.getCreativeId() != 0) {
            output.encodeLongElement(serialDesc, 10, self.getCreativeId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.getCreativeType() != 0) {
            output.encodeLongElement(serialDesc, 11, self.getCreativeType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.getCreativeStyle() != 0) {
            output.encodeIntElement(serialDesc, 12, self.getCreativeStyle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.getCardType() != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.getCardType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.getAdCb() != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.getAdCb());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.getCmMark() != 0) {
            output.encodeIntElement(serialDesc, 15, self.getCmMark());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.getLiveBookingId() != 0) {
            output.encodeLongElement(serialDesc, 16, self.getLiveBookingId());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.getNatureAd() != 0) {
            output.encodeIntElement(serialDesc, 17, self.getNatureAd());
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 18)) {
            String track_id = self.getTrack_id();
            AdInfoExtra extra = self.getExtra();
            if (Intrinsics.areEqual(track_id, extra != null ? extra.getTrackId() : null)) {
                z = false;
                if (z) {
                    output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.getTrack_id());
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 19)) {
                    long shopId = self.getShopId();
                    AdInfoExtra extra2 = self.getExtra();
                    Number $this$orZero$iv = extra2 != null ? Long.valueOf(extra2.getShopId()) : null;
                    if ($this$orZero$iv == null) {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            number6 = (Long) Double.valueOf(0.0d);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            number6 = (Long) Float.valueOf(0.0f);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            number6 = (Number) 0L;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            number6 = (Long) 0;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                            number6 = (Long) (char) 0;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            number6 = (Long) (short) 0;
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                            throw new RuntimeException("not primitive number type");
                        } else {
                            number6 = (Long) (byte) 0;
                        }
                    } else {
                        number6 = $this$orZero$iv;
                    }
                    z10 = shopId != number6.longValue();
                }
                if (z10) {
                    output.encodeLongElement(serialDesc, 19, self.getShopId());
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 20)) {
                    long upMid = self.getUpMid();
                    AdInfoExtra extra3 = self.getExtra();
                    Number $this$orZero$iv2 = extra3 != null ? Long.valueOf(extra3.getUpMid()) : null;
                    if ($this$orZero$iv2 == null) {
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            number = (Long) Double.valueOf(0.0d);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            number = (Long) Float.valueOf(0.0f);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            number = (Number) 0L;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            number = (Long) 0;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                            number = (Long) (char) 0;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            number = (Long) (short) 0;
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                            throw new RuntimeException("not primitive number type");
                        } else {
                            number = (Long) (byte) 0;
                        }
                    } else {
                        number = $this$orZero$iv2;
                    }
                    if (upMid == number.longValue()) {
                        z2 = false;
                        if (z2) {
                            output.encodeLongElement(serialDesc, 20, self.getUpMid());
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 21)) {
                            long productId = self.getProductId();
                            AdInfoExtra extra4 = self.getExtra();
                            Number $this$orZero$iv3 = extra4 != null ? Long.valueOf(extra4.getProductId()) : null;
                            if ($this$orZero$iv3 == null) {
                                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    number2 = (Long) Double.valueOf(0.0d);
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    number2 = (Long) Float.valueOf(0.0f);
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    number2 = (Number) 0L;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                    number2 = (Long) 0;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                                    number2 = (Long) (char) 0;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    number2 = (Long) (short) 0;
                                } else if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                    throw new RuntimeException("not primitive number type");
                                } else {
                                    number2 = (Long) (byte) 0;
                                }
                            } else {
                                number2 = $this$orZero$iv3;
                            }
                            if (productId == number2.longValue()) {
                                z3 = false;
                                if (z3) {
                                    output.encodeLongElement(serialDesc, 21, self.getProductId());
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 22)) {
                                    int replaceStrategy = self.getReplaceStrategy();
                                    AdInfoExtra extra5 = self.getExtra();
                                    Number $this$orZero$iv4 = extra5 != null ? Integer.valueOf(extra5.getMacroReplacePriority()) : null;
                                    if ($this$orZero$iv4 == null) {
                                        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Integer.class);
                                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                            number3 = (Integer) Double.valueOf(0.0d);
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            number3 = (Integer) Float.valueOf(0.0f);
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                            number3 = (Integer) 0L;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                            number3 = (Number) 0;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                                            number3 = (Integer) (char) 0;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                            number3 = (Integer) (short) 0;
                                        } else if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                            throw new RuntimeException("not primitive number type");
                                        } else {
                                            number3 = (Integer) (byte) 0;
                                        }
                                    } else {
                                        number3 = $this$orZero$iv4;
                                    }
                                    if (replaceStrategy == number3.intValue()) {
                                        z4 = false;
                                        if (z4) {
                                            output.encodeIntElement(serialDesc, 22, self.getReplaceStrategy());
                                        }
                                        if (!output.shouldEncodeElementDefault(serialDesc, 23)) {
                                            String fromTrackId = self.getFromTrackId();
                                            AdInfoExtra extra6 = self.getExtra();
                                            if (Intrinsics.areEqual(fromTrackId, extra6 != null ? extra6.getFromTrackId() : null)) {
                                                z5 = false;
                                                if (z5) {
                                                    output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.getFromTrackId());
                                                }
                                                if (!output.shouldEncodeElementDefault(serialDesc, 24)) {
                                                    String cmFromTrackId = self.getCmFromTrackId();
                                                    AdInfoExtra extra7 = self.getExtra();
                                                    if (Intrinsics.areEqual(cmFromTrackId, extra7 != null ? extra7.getCmFromTrackId() : null)) {
                                                        z6 = false;
                                                        if (z6) {
                                                            output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.getCmFromTrackId());
                                                        }
                                                        if (!output.shouldEncodeElementDefault(serialDesc, 25)) {
                                                            long itemId = self.getItemId();
                                                            AdInfoExtra extra8 = self.getExtra();
                                                            Number $this$orZero$iv5 = (extra8 == null || (card = extra8.getCard()) == null) ? null : Long.valueOf(card.getGoodsItemId());
                                                            if ($this$orZero$iv5 == null) {
                                                                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Long.class);
                                                                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                                                    number4 = (Long) Double.valueOf(0.0d);
                                                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                                                    number4 = (Long) Float.valueOf(0.0f);
                                                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                                                    number4 = (Number) 0L;
                                                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                                                    number4 = (Long) 0;
                                                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                                                                    number4 = (Long) (char) 0;
                                                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                                                    number4 = (Long) (short) 0;
                                                                } else if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                                                    throw new RuntimeException("not primitive number type");
                                                                } else {
                                                                    number4 = (Long) (byte) 0;
                                                                }
                                                            } else {
                                                                number4 = $this$orZero$iv5;
                                                            }
                                                            if (itemId == number4.longValue()) {
                                                                z7 = false;
                                                                if (z7) {
                                                                    output.encodeLongElement(serialDesc, 25, self.getItemId());
                                                                }
                                                                if (!output.shouldEncodeElementDefault(serialDesc, 26)) {
                                                                    int itemSource = self.getItemSource();
                                                                    AdInfoExtra extra9 = self.getExtra();
                                                                    Number $this$orZero$iv6 = (extra9 == null || (card2 = extra9.getCard()) == null) ? null : Integer.valueOf(card2.getGoodsItemSource());
                                                                    if ($this$orZero$iv6 == null) {
                                                                        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Integer.class);
                                                                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                                                            number5 = (Integer) Double.valueOf(0.0d);
                                                                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                                                            number5 = (Integer) Float.valueOf(0.0f);
                                                                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                                                            number5 = (Integer) 0L;
                                                                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                                                            number5 = (Number) 0;
                                                                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                                                                            number5 = (Integer) (char) 0;
                                                                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                                                            number5 = (Integer) (short) 0;
                                                                        } else if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                                                                            throw new RuntimeException("not primitive number type");
                                                                        } else {
                                                                            number5 = (Integer) (byte) 0;
                                                                        }
                                                                    } else {
                                                                        number5 = $this$orZero$iv6;
                                                                    }
                                                                    if (itemSource == number5.intValue()) {
                                                                        z8 = false;
                                                                        if (z8) {
                                                                            output.encodeIntElement(serialDesc, 26, self.getItemSource());
                                                                        }
                                                                        if (!output.shouldEncodeElementDefault(serialDesc, 27)) {
                                                                            String extraParams = self.getExtraParams();
                                                                            AdInfoExtra extra10 = self.getExtra();
                                                                            if (Intrinsics.areEqual(extraParams, (extra10 == null || (card3 = extra10.getCard()) == null) ? null : card3.getExtraParams())) {
                                                                                z9 = false;
                                                                                if (z9) {
                                                                                    return;
                                                                                }
                                                                                output.encodeNullableSerializableElement(serialDesc, 27, StringSerializer.INSTANCE, self.getExtraParams());
                                                                                return;
                                                                            }
                                                                        }
                                                                        z9 = true;
                                                                        if (z9) {
                                                                        }
                                                                    }
                                                                }
                                                                z8 = true;
                                                                if (z8) {
                                                                }
                                                                if (!output.shouldEncodeElementDefault(serialDesc, 27)) {
                                                                }
                                                                z9 = true;
                                                                if (z9) {
                                                                }
                                                            }
                                                        }
                                                        z7 = true;
                                                        if (z7) {
                                                        }
                                                        if (!output.shouldEncodeElementDefault(serialDesc, 26)) {
                                                        }
                                                        z8 = true;
                                                        if (z8) {
                                                        }
                                                        if (!output.shouldEncodeElementDefault(serialDesc, 27)) {
                                                        }
                                                        z9 = true;
                                                        if (z9) {
                                                        }
                                                    }
                                                }
                                                z6 = true;
                                                if (z6) {
                                                }
                                                if (!output.shouldEncodeElementDefault(serialDesc, 25)) {
                                                }
                                                z7 = true;
                                                if (z7) {
                                                }
                                                if (!output.shouldEncodeElementDefault(serialDesc, 26)) {
                                                }
                                                z8 = true;
                                                if (z8) {
                                                }
                                                if (!output.shouldEncodeElementDefault(serialDesc, 27)) {
                                                }
                                                z9 = true;
                                                if (z9) {
                                                }
                                            }
                                        }
                                        z5 = true;
                                        if (z5) {
                                        }
                                        if (!output.shouldEncodeElementDefault(serialDesc, 24)) {
                                        }
                                        z6 = true;
                                        if (z6) {
                                        }
                                        if (!output.shouldEncodeElementDefault(serialDesc, 25)) {
                                        }
                                        z7 = true;
                                        if (z7) {
                                        }
                                        if (!output.shouldEncodeElementDefault(serialDesc, 26)) {
                                        }
                                        z8 = true;
                                        if (z8) {
                                        }
                                        if (!output.shouldEncodeElementDefault(serialDesc, 27)) {
                                        }
                                        z9 = true;
                                        if (z9) {
                                        }
                                    }
                                }
                                z4 = true;
                                if (z4) {
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 23)) {
                                }
                                z5 = true;
                                if (z5) {
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 24)) {
                                }
                                z6 = true;
                                if (z6) {
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 25)) {
                                }
                                z7 = true;
                                if (z7) {
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 26)) {
                                }
                                z8 = true;
                                if (z8) {
                                }
                                if (!output.shouldEncodeElementDefault(serialDesc, 27)) {
                                }
                                z9 = true;
                                if (z9) {
                                }
                            }
                        }
                        z3 = true;
                        if (z3) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 22)) {
                        }
                        z4 = true;
                        if (z4) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 23)) {
                        }
                        z5 = true;
                        if (z5) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 24)) {
                        }
                        z6 = true;
                        if (z6) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 25)) {
                        }
                        z7 = true;
                        if (z7) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 26)) {
                        }
                        z8 = true;
                        if (z8) {
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 27)) {
                        }
                        z9 = true;
                        if (z9) {
                        }
                    }
                }
                z2 = true;
                if (z2) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 21)) {
                }
                z3 = true;
                if (z3) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 22)) {
                }
                z4 = true;
                if (z4) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 23)) {
                }
                z5 = true;
                if (z5) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 24)) {
                }
                z6 = true;
                if (z6) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 25)) {
                }
                z7 = true;
                if (z7) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 26)) {
                }
                z8 = true;
                if (z8) {
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 27)) {
                }
                z9 = true;
                if (z9) {
                }
            }
        }
        z = true;
        if (z) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 19)) {
        }
        if (z10) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 20)) {
        }
        z2 = true;
        if (z2) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 21)) {
        }
        z3 = true;
        if (z3) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 22)) {
        }
        z4 = true;
        if (z4) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 23)) {
        }
        z5 = true;
        if (z5) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 24)) {
        }
        z6 = true;
        if (z6) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 25)) {
        }
        z7 = true;
        if (z7) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 26)) {
        }
        z8 = true;
        if (z8) {
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 27)) {
        }
        z9 = true;
        if (z9) {
        }
    }

    public /* synthetic */ AdInfo(boolean z, long j2, long j3, String str, long j4, String str2, long j5, long j6, long j7, boolean z2, long j8, long j9, int i, String str3, String str4, int i2, AdInfoExtra adInfoExtra, long j10, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? 0L : j2, (i4 & 4) != 0 ? 0L : j3, (i4 & 8) != 0 ? null : str, (i4 & 16) != 0 ? -1L : j4, (i4 & 32) != 0 ? null : str2, (i4 & 64) != 0 ? 0L : j5, (i4 & 128) == 0 ? j6 : -1L, (i4 & 256) != 0 ? 0L : j7, (i4 & 512) != 0 ? false : z2, (i4 & 1024) != 0 ? 0L : j8, (i4 & 2048) != 0 ? 0L : j9, (i4 & 4096) != 0 ? 0 : i, (i4 & 8192) != 0 ? null : str3, (i4 & 16384) != 0 ? null : str4, (i4 & 32768) != 0 ? 0 : i2, (i4 & 65536) != 0 ? null : adInfoExtra, (i4 & 131072) != 0 ? 0L : j10, (i4 & 262144) != 0 ? 0 : i3);
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public boolean isAdLoc() {
        return this.isAdLoc;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getSourceId() {
        return this.sourceId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getResourceId() {
        return this.resourceId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public String getRequestId() {
        return this.requestId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getServerType() {
        return this.serverType;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public String getIp() {
        return this.ip;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getIndex() {
        return this.index;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getCardIndex() {
        return this.cardIndex;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getId() {
        return this.id;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public boolean isAd() {
        return this.isAd;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getCreativeId() {
        return this.creativeId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getCreativeType() {
        return this.creativeType;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public int getCreativeStyle() {
        return this.creativeStyle;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public String getCardType() {
        return this.cardType;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public void setCardType(String str) {
        this.cardType = str;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public String getAdCb() {
        return this.adCb;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public int getCmMark() {
        return this.cmMark;
    }

    @Override // kntr.app.ad.common.protocol.IAdInfo
    public AdInfoExtra getExtra() {
        return this.extra;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getLiveBookingId() {
        return this.liveBookingId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public int getNatureAd() {
        return this.natureAd;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public String getTrack_id() {
        return this.track_id;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getShopId() {
        return this.shopId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getUpMid() {
        return this.upMid;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getProductId() {
        return this.productId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public int getReplaceStrategy() {
        return this.replaceStrategy;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public String getFromTrackId() {
        return this.fromTrackId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public String getCmFromTrackId() {
        return this.cmFromTrackId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getItemId() {
        return this.itemId;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public int getItemSource() {
        return this.itemSource;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public String getExtraParams() {
        return this.extraParams;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public long getAvid() {
        return this.avid;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public void setAvid(long j2) {
        this.avid = j2;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public boolean getButtonShow() {
        return this.buttonShow;
    }

    @Override // kntr.app.ad.protocol.report.IReportable
    public void setButtonShow(boolean z) {
        this.buttonShow = z;
    }
}