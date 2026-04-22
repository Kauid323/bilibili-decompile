package kntr.base.neuron.internal.model.pb;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 b2\u00020\u0001:\u0002bcB»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017B½\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0006HÆ\u0003J\t\u0010S\u001a\u00020\u0006HÆ\u0003J½\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006HÆ\u0001J\u0013\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\u0006HÖ\u0001J\t\u0010Y\u001a\u00020\u0003HÖ\u0001J%\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00002\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0001¢\u0006\u0002\baR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010$R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001fR\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001fR\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001fR\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001d\u001a\u0004\b.\u0010\u001fR\u001c\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010$R\u001c\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001d\u001a\u0004\b2\u0010$R\u001c\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001d\u001a\u0004\b4\u0010$R\u001c\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001d\u001a\u0004\b6\u0010$R\u001c\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u001d\u001a\u0004\b8\u0010$R\u001c\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u001d\u001a\u0004\b:\u0010\u001fR\u001c\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\u001d\u001a\u0004\b<\u0010\u001fR\u001c\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\u001d\u001a\u0004\b>\u0010\u001fR\u001c\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\u001d\u001a\u0004\b\u0014\u0010$R\u001c\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u001d\u001a\u0004\bA\u0010$¨\u0006d"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppPlayerInfo;", "", "playFromSpmid", "", "seasonId", "type", "", "subType", "epId", "progress", WatchLaterReporterKt.KEY_AVID, "cid", "networkType", "danmaku", "status", "playMethod", "playType", "playerSessionId", "speed", "playerClarity", "isAutoplay", "videoFormat", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPlayFromSpmid$annotations", "()V", "getPlayFromSpmid", "()Ljava/lang/String;", "getSeasonId$annotations", "getSeasonId", "getType$annotations", "getType", "()I", "getSubType$annotations", "getSubType", "getEpId$annotations", "getEpId", "getProgress$annotations", "getProgress", "getAvid$annotations", "getAvid", "getCid$annotations", "getCid", "getNetworkType$annotations", "getNetworkType", "getDanmaku$annotations", "getDanmaku", "getStatus$annotations", "getStatus", "getPlayMethod$annotations", "getPlayMethod", "getPlayType$annotations", "getPlayType", "getPlayerSessionId$annotations", "getPlayerSessionId", "getSpeed$annotations", "getSpeed", "getPlayerClarity$annotations", "getPlayerClarity", "isAutoplay$annotations", "getVideoFormat$annotations", "getVideoFormat", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class KAppPlayerInfo {
    public static final Companion Companion = new Companion(null);
    public static final String targetPath = "/AppPlayerInfo";
    private final String avid;
    private final String cid;
    private final int danmaku;
    private final String epId;
    private final int isAutoplay;
    private final int networkType;
    private final String playFromSpmid;
    private final int playMethod;
    private final int playType;
    private final String playerClarity;
    private final String playerSessionId;
    private final String progress;
    private final String seasonId;
    private final String speed;
    private final int status;
    private final int subType;
    private final int type;
    private final int videoFormat;

    public KAppPlayerInfo() {
        this((String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, 0, 0, 0, (String) null, (String) null, (String) null, 0, 0, 262143, (DefaultConstructorMarker) null);
    }

    @SerialName(WatchLaterReporterKt.KEY_AVID)
    @ProtoNumber(number = AdditionalButton.CLICK_TYPE_FIELD_NUMBER)
    public static /* synthetic */ void getAvid$annotations() {
    }

    @SerialName("cid")
    @ProtoNumber(number = 8)
    public static /* synthetic */ void getCid$annotations() {
    }

    @SerialName("danmaku")
    @ProtoNumber(number = 10)
    public static /* synthetic */ void getDanmaku$annotations() {
    }

    @SerialName("epId")
    @ProtoNumber(number = 5)
    public static /* synthetic */ void getEpId$annotations() {
    }

    @SerialName("networkType")
    @ProtoNumber(number = ConstantsKt.SPACER_9)
    public static /* synthetic */ void getNetworkType$annotations() {
    }

    @SerialName("playFromSpmid")
    @ProtoNumber(number = 1)
    public static /* synthetic */ void getPlayFromSpmid$annotations() {
    }

    @SerialName("playMethod")
    @ProtoNumber(number = 12)
    public static /* synthetic */ void getPlayMethod$annotations() {
    }

    @SerialName("playType")
    @ProtoNumber(number = 13)
    public static /* synthetic */ void getPlayType$annotations() {
    }

    @SerialName("playerClarity")
    @ProtoNumber(number = 16)
    public static /* synthetic */ void getPlayerClarity$annotations() {
    }

    @SerialName("playerSessionId")
    @ProtoNumber(number = ConstantsKt.SPACER_14)
    public static /* synthetic */ void getPlayerSessionId$annotations() {
    }

    @SerialName("progress")
    @ProtoNumber(number = 6)
    public static /* synthetic */ void getProgress$annotations() {
    }

    @SerialName("seasonId")
    @ProtoNumber(number = 2)
    public static /* synthetic */ void getSeasonId$annotations() {
    }

    @SerialName("speed")
    @ProtoNumber(number = 15)
    public static /* synthetic */ void getSpeed$annotations() {
    }

    @SerialName("status")
    @ProtoNumber(number = MediaAttrUtils.TYPE_MENU)
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("subType")
    @ProtoNumber(number = 4)
    public static /* synthetic */ void getSubType$annotations() {
    }

    @SerialName("type")
    @ProtoNumber(number = 3)
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("videoFormat")
    @ProtoNumber(number = 18)
    public static /* synthetic */ void getVideoFormat$annotations() {
    }

    @SerialName("isAutoplay")
    @ProtoNumber(number = 17)
    public static /* synthetic */ void isAutoplay$annotations() {
    }

    public final String component1() {
        return this.playFromSpmid;
    }

    public final int component10() {
        return this.danmaku;
    }

    public final int component11() {
        return this.status;
    }

    public final int component12() {
        return this.playMethod;
    }

    public final int component13() {
        return this.playType;
    }

    public final String component14() {
        return this.playerSessionId;
    }

    public final String component15() {
        return this.speed;
    }

    public final String component16() {
        return this.playerClarity;
    }

    public final int component17() {
        return this.isAutoplay;
    }

    public final int component18() {
        return this.videoFormat;
    }

    public final String component2() {
        return this.seasonId;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.subType;
    }

    public final String component5() {
        return this.epId;
    }

    public final String component6() {
        return this.progress;
    }

    public final String component7() {
        return this.avid;
    }

    public final String component8() {
        return this.cid;
    }

    public final int component9() {
        return this.networkType;
    }

    public final KAppPlayerInfo copy(String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, int i3, int i4, int i5, int i6, int i7, String str7, String str8, String str9, int i8, int i9) {
        Intrinsics.checkNotNullParameter(str, "playFromSpmid");
        Intrinsics.checkNotNullParameter(str2, "seasonId");
        Intrinsics.checkNotNullParameter(str3, "epId");
        Intrinsics.checkNotNullParameter(str4, "progress");
        Intrinsics.checkNotNullParameter(str5, WatchLaterReporterKt.KEY_AVID);
        Intrinsics.checkNotNullParameter(str6, "cid");
        Intrinsics.checkNotNullParameter(str7, "playerSessionId");
        Intrinsics.checkNotNullParameter(str8, "speed");
        Intrinsics.checkNotNullParameter(str9, "playerClarity");
        return new KAppPlayerInfo(str, str2, i, i2, str3, str4, str5, str6, i3, i4, i5, i6, i7, str7, str8, str9, i8, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KAppPlayerInfo) {
            KAppPlayerInfo kAppPlayerInfo = (KAppPlayerInfo) obj;
            return Intrinsics.areEqual(this.playFromSpmid, kAppPlayerInfo.playFromSpmid) && Intrinsics.areEqual(this.seasonId, kAppPlayerInfo.seasonId) && this.type == kAppPlayerInfo.type && this.subType == kAppPlayerInfo.subType && Intrinsics.areEqual(this.epId, kAppPlayerInfo.epId) && Intrinsics.areEqual(this.progress, kAppPlayerInfo.progress) && Intrinsics.areEqual(this.avid, kAppPlayerInfo.avid) && Intrinsics.areEqual(this.cid, kAppPlayerInfo.cid) && this.networkType == kAppPlayerInfo.networkType && this.danmaku == kAppPlayerInfo.danmaku && this.status == kAppPlayerInfo.status && this.playMethod == kAppPlayerInfo.playMethod && this.playType == kAppPlayerInfo.playType && Intrinsics.areEqual(this.playerSessionId, kAppPlayerInfo.playerSessionId) && Intrinsics.areEqual(this.speed, kAppPlayerInfo.speed) && Intrinsics.areEqual(this.playerClarity, kAppPlayerInfo.playerClarity) && this.isAutoplay == kAppPlayerInfo.isAutoplay && this.videoFormat == kAppPlayerInfo.videoFormat;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.playFromSpmid.hashCode() * 31) + this.seasonId.hashCode()) * 31) + this.type) * 31) + this.subType) * 31) + this.epId.hashCode()) * 31) + this.progress.hashCode()) * 31) + this.avid.hashCode()) * 31) + this.cid.hashCode()) * 31) + this.networkType) * 31) + this.danmaku) * 31) + this.status) * 31) + this.playMethod) * 31) + this.playType) * 31) + this.playerSessionId.hashCode()) * 31) + this.speed.hashCode()) * 31) + this.playerClarity.hashCode()) * 31) + this.isAutoplay) * 31) + this.videoFormat;
    }

    public String toString() {
        String str = this.playFromSpmid;
        String str2 = this.seasonId;
        int i = this.type;
        int i2 = this.subType;
        String str3 = this.epId;
        String str4 = this.progress;
        String str5 = this.avid;
        String str6 = this.cid;
        int i3 = this.networkType;
        int i4 = this.danmaku;
        int i5 = this.status;
        int i6 = this.playMethod;
        int i7 = this.playType;
        String str7 = this.playerSessionId;
        String str8 = this.speed;
        String str9 = this.playerClarity;
        int i8 = this.isAutoplay;
        return "KAppPlayerInfo(playFromSpmid=" + str + ", seasonId=" + str2 + ", type=" + i + ", subType=" + i2 + ", epId=" + str3 + ", progress=" + str4 + ", avid=" + str5 + ", cid=" + str6 + ", networkType=" + i3 + ", danmaku=" + i4 + ", status=" + i5 + ", playMethod=" + i6 + ", playType=" + i7 + ", playerSessionId=" + str7 + ", speed=" + str8 + ", playerClarity=" + str9 + ", isAutoplay=" + i8 + ", videoFormat=" + this.videoFormat + ")";
    }

    public /* synthetic */ KAppPlayerInfo(int seen0, String playFromSpmid, String seasonId, int type, int subType, String epId, String progress, String avid, String cid, int networkType, int danmaku, int status, int playMethod, int playType, String playerSessionId, String speed, String playerClarity, int isAutoplay, int videoFormat, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.playFromSpmid = "";
        } else {
            this.playFromSpmid = playFromSpmid;
        }
        if ((seen0 & 2) == 0) {
            this.seasonId = "";
        } else {
            this.seasonId = seasonId;
        }
        if ((seen0 & 4) == 0) {
            this.type = 0;
        } else {
            this.type = type;
        }
        if ((seen0 & 8) == 0) {
            this.subType = 0;
        } else {
            this.subType = subType;
        }
        if ((seen0 & 16) == 0) {
            this.epId = "";
        } else {
            this.epId = epId;
        }
        if ((seen0 & 32) == 0) {
            this.progress = "";
        } else {
            this.progress = progress;
        }
        if ((seen0 & 64) == 0) {
            this.avid = "";
        } else {
            this.avid = avid;
        }
        if ((seen0 & 128) == 0) {
            this.cid = "";
        } else {
            this.cid = cid;
        }
        if ((seen0 & 256) == 0) {
            this.networkType = 0;
        } else {
            this.networkType = networkType;
        }
        if ((seen0 & 512) == 0) {
            this.danmaku = 0;
        } else {
            this.danmaku = danmaku;
        }
        if ((seen0 & 1024) == 0) {
            this.status = 0;
        } else {
            this.status = status;
        }
        if ((seen0 & 2048) == 0) {
            this.playMethod = 0;
        } else {
            this.playMethod = playMethod;
        }
        if ((seen0 & 4096) == 0) {
            this.playType = 0;
        } else {
            this.playType = playType;
        }
        if ((seen0 & 8192) == 0) {
            this.playerSessionId = "";
        } else {
            this.playerSessionId = playerSessionId;
        }
        if ((seen0 & 16384) == 0) {
            this.speed = "";
        } else {
            this.speed = speed;
        }
        if ((seen0 & 32768) == 0) {
            this.playerClarity = "";
        } else {
            this.playerClarity = playerClarity;
        }
        if ((seen0 & 65536) == 0) {
            this.isAutoplay = 0;
        } else {
            this.isAutoplay = isAutoplay;
        }
        if ((seen0 & 131072) == 0) {
            this.videoFormat = 0;
        } else {
            this.videoFormat = videoFormat;
        }
    }

    public KAppPlayerInfo(String playFromSpmid, String seasonId, int type, int subType, String epId, String progress, String avid, String cid, int networkType, int danmaku, int status, int playMethod, int playType, String playerSessionId, String speed, String playerClarity, int isAutoplay, int videoFormat) {
        Intrinsics.checkNotNullParameter(playFromSpmid, "playFromSpmid");
        Intrinsics.checkNotNullParameter(seasonId, "seasonId");
        Intrinsics.checkNotNullParameter(epId, "epId");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(avid, WatchLaterReporterKt.KEY_AVID);
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(playerSessionId, "playerSessionId");
        Intrinsics.checkNotNullParameter(speed, "speed");
        Intrinsics.checkNotNullParameter(playerClarity, "playerClarity");
        this.playFromSpmid = playFromSpmid;
        this.seasonId = seasonId;
        this.type = type;
        this.subType = subType;
        this.epId = epId;
        this.progress = progress;
        this.avid = avid;
        this.cid = cid;
        this.networkType = networkType;
        this.danmaku = danmaku;
        this.status = status;
        this.playMethod = playMethod;
        this.playType = playType;
        this.playerSessionId = playerSessionId;
        this.speed = speed;
        this.playerClarity = playerClarity;
        this.isAutoplay = isAutoplay;
        this.videoFormat = videoFormat;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$neuron_debug(KAppPlayerInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.playFromSpmid, "")) {
            output.encodeStringElement(serialDesc, 0, self.playFromSpmid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.seasonId, "")) {
            output.encodeStringElement(serialDesc, 1, self.seasonId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.type != 0) {
            output.encodeIntElement(serialDesc, 2, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.subType != 0) {
            output.encodeIntElement(serialDesc, 3, self.subType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.epId, "")) {
            output.encodeStringElement(serialDesc, 4, self.epId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.progress, "")) {
            output.encodeStringElement(serialDesc, 5, self.progress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.avid, "")) {
            output.encodeStringElement(serialDesc, 6, self.avid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.cid, "")) {
            output.encodeStringElement(serialDesc, 7, self.cid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.networkType != 0) {
            output.encodeIntElement(serialDesc, 8, self.networkType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.danmaku != 0) {
            output.encodeIntElement(serialDesc, 9, self.danmaku);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.status != 0) {
            output.encodeIntElement(serialDesc, 10, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.playMethod != 0) {
            output.encodeIntElement(serialDesc, 11, self.playMethod);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.playType != 0) {
            output.encodeIntElement(serialDesc, 12, self.playType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.playerSessionId, "")) {
            output.encodeStringElement(serialDesc, 13, self.playerSessionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || !Intrinsics.areEqual(self.speed, "")) {
            output.encodeStringElement(serialDesc, 14, self.speed);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || !Intrinsics.areEqual(self.playerClarity, "")) {
            output.encodeStringElement(serialDesc, 15, self.playerClarity);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.isAutoplay != 0) {
            output.encodeIntElement(serialDesc, 16, self.isAutoplay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.videoFormat != 0) {
            output.encodeIntElement(serialDesc, 17, self.videoFormat);
        }
    }

    public /* synthetic */ KAppPlayerInfo(String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, int i3, int i4, int i5, int i6, int i7, String str7, String str8, String str9, int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? 0 : i, (i10 & 8) != 0 ? 0 : i2, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? "" : str4, (i10 & 64) != 0 ? "" : str5, (i10 & 128) != 0 ? "" : str6, (i10 & 256) != 0 ? 0 : i3, (i10 & 512) != 0 ? 0 : i4, (i10 & 1024) != 0 ? 0 : i5, (i10 & 2048) != 0 ? 0 : i6, (i10 & 4096) != 0 ? 0 : i7, (i10 & 8192) != 0 ? "" : str7, (i10 & 16384) != 0 ? "" : str8, (i10 & 32768) != 0 ? "" : str9, (i10 & 65536) != 0 ? 0 : i8, (i10 & 131072) != 0 ? 0 : i9);
    }

    public final String getPlayFromSpmid() {
        return this.playFromSpmid;
    }

    public final String getSeasonId() {
        return this.seasonId;
    }

    public final int getType() {
        return this.type;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final String getEpId() {
        return this.epId;
    }

    public final String getProgress() {
        return this.progress;
    }

    public final String getAvid() {
        return this.avid;
    }

    public final String getCid() {
        return this.cid;
    }

    public final int getNetworkType() {
        return this.networkType;
    }

    public final int getDanmaku() {
        return this.danmaku;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getPlayMethod() {
        return this.playMethod;
    }

    public final int getPlayType() {
        return this.playType;
    }

    public final String getPlayerSessionId() {
        return this.playerSessionId;
    }

    public final String getSpeed() {
        return this.speed;
    }

    public final String getPlayerClarity() {
        return this.playerClarity;
    }

    public final int isAutoplay() {
        return this.isAutoplay;
    }

    public final int getVideoFormat() {
        return this.videoFormat;
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppPlayerInfo$Companion;", "", "<init>", "()V", "targetPath", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppPlayerInfo;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<KAppPlayerInfo> serializer() {
            return KAppPlayerInfo$$serializer.INSTANCE;
        }
    }
}