package kntr.app.ad.common.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.multivideo.poll.LivePollConnection;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdButton.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 i2\u00020\u0001:\u0002hiB\u0083\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fBë\u0001\b\u0010\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b\u001e\u0010#J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010K\u001a\u00020\fHÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0011HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\fHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0011HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0085\u0002\u0010[\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\\\u001a\u00020\u00112\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\u0005HÖ\u0001J\t\u0010_\u001a\u00020\u0003HÖ\u0001J%\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH\u0001¢\u0006\u0002\bgR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010%R\u001b\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010*\u001a\u0004\b/\u0010%R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b8\u00101R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u001c\u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010*\u001a\u0004\b<\u00106R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010*\u001a\u0004\bB\u0010CR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010%¨\u0006j"}, d2 = {"Lkntr/app/ad/common/model/AdButton;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "jumpUrl", "callupUrl", "reportUrls", RoomRecommendViewModel.EMPTY_CURSOR, "dlsucCallupUrl", "btnDelayTime", RoomRecommendViewModel.EMPTY_CURSOR, "gameId", "gameMonitorParam", "extremeTeamScore", "storyArrow", RoomRecommendViewModel.EMPTY_CURSOR, "showStyle", "showDynamicTime", "btnBgColor", "textColor", "showGameButtonCustomText", "btnStyle", "gameChannelId", "gameChannelExtra", "gameSourcefrom", "subCardModule", "Lkntr/app/ad/common/model/AdSubCardModule;", "dlsucCallupText", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JILjava/lang/String;IZIJLjava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdSubCardModule;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JILjava/lang/String;IZIJLjava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdSubCardModule;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getType", "()I", "getJumpUrl", "getCallupUrl$annotations", "()V", "getCallupUrl", "getReportUrls", "()Ljava/util/List;", "getDlsucCallupUrl$annotations", "getDlsucCallupUrl", "getBtnDelayTime", "()J", "getGameId", "getGameMonitorParam", "getExtremeTeamScore", "getStoryArrow", "()Z", "getShowStyle", "getShowDynamicTime", "getBtnBgColor", "getTextColor", "getShowGameButtonCustomText$annotations", "getShowGameButtonCustomText", "getBtnStyle", "getGameChannelId", "getGameChannelExtra", "getGameSourcefrom", "getSubCardModule$annotations", "getSubCardModule", "()Lkntr/app/ad/common/model/AdSubCardModule;", "getDlsucCallupText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdButton {
    private final String btnBgColor;
    private final long btnDelayTime;
    private final int btnStyle;
    private final String callupUrl;
    private final String dlsucCallupText;
    private final String dlsucCallupUrl;
    private final int extremeTeamScore;
    private final String gameChannelExtra;
    private final int gameChannelId;
    private final int gameId;
    private final String gameMonitorParam;
    private final String gameSourcefrom;
    private final String jumpUrl;
    private final List<String> reportUrls;
    private final long showDynamicTime;
    private final boolean showGameButtonCustomText;
    private final int showStyle;
    private final boolean storyArrow;
    private final AdSubCardModule subCardModule;
    private final String text;
    private final String textColor;
    private final int type;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdButton$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdButton._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    public AdButton() {
        this((String) null, 0, (String) null, (String) null, (List) null, (String) null, 0L, 0, (String) null, 0, false, 0, 0L, (String) null, (String) null, false, 0, 0, (String) null, (String) null, (AdSubCardModule) null, (String) null, 4194303, (DefaultConstructorMarker) null);
    }

    @SerialName("callup_url")
    public static /* synthetic */ void getCallupUrl$annotations() {
    }

    @SerialName("dlsuc_callup_url")
    public static /* synthetic */ void getDlsucCallupUrl$annotations() {
    }

    @SerialName("show_game_custom_text")
    public static /* synthetic */ void getShowGameButtonCustomText$annotations() {
    }

    @SerialName("subcard_module")
    public static /* synthetic */ void getSubCardModule$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final int component10() {
        return this.extremeTeamScore;
    }

    public final boolean component11() {
        return this.storyArrow;
    }

    public final int component12() {
        return this.showStyle;
    }

    public final long component13() {
        return this.showDynamicTime;
    }

    public final String component14() {
        return this.btnBgColor;
    }

    public final String component15() {
        return this.textColor;
    }

    public final boolean component16() {
        return this.showGameButtonCustomText;
    }

    public final int component17() {
        return this.btnStyle;
    }

    public final int component18() {
        return this.gameChannelId;
    }

    public final String component19() {
        return this.gameChannelExtra;
    }

    public final int component2() {
        return this.type;
    }

    public final String component20() {
        return this.gameSourcefrom;
    }

    public final AdSubCardModule component21() {
        return this.subCardModule;
    }

    public final String component22() {
        return this.dlsucCallupText;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final String component4() {
        return this.callupUrl;
    }

    public final List<String> component5() {
        return this.reportUrls;
    }

    public final String component6() {
        return this.dlsucCallupUrl;
    }

    public final long component7() {
        return this.btnDelayTime;
    }

    public final int component8() {
        return this.gameId;
    }

    public final String component9() {
        return this.gameMonitorParam;
    }

    public final AdButton copy(String str, int i, String str2, String str3, List<String> list, String str4, long j2, int i2, String str5, int i3, boolean z, int i4, long j3, String str6, String str7, boolean z2, int i5, int i6, String str8, String str9, AdSubCardModule adSubCardModule, String str10) {
        return new AdButton(str, i, str2, str3, list, str4, j2, i2, str5, i3, z, i4, j3, str6, str7, z2, i5, i6, str8, str9, adSubCardModule, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdButton) {
            AdButton adButton = (AdButton) obj;
            return Intrinsics.areEqual(this.text, adButton.text) && this.type == adButton.type && Intrinsics.areEqual(this.jumpUrl, adButton.jumpUrl) && Intrinsics.areEqual(this.callupUrl, adButton.callupUrl) && Intrinsics.areEqual(this.reportUrls, adButton.reportUrls) && Intrinsics.areEqual(this.dlsucCallupUrl, adButton.dlsucCallupUrl) && this.btnDelayTime == adButton.btnDelayTime && this.gameId == adButton.gameId && Intrinsics.areEqual(this.gameMonitorParam, adButton.gameMonitorParam) && this.extremeTeamScore == adButton.extremeTeamScore && this.storyArrow == adButton.storyArrow && this.showStyle == adButton.showStyle && this.showDynamicTime == adButton.showDynamicTime && Intrinsics.areEqual(this.btnBgColor, adButton.btnBgColor) && Intrinsics.areEqual(this.textColor, adButton.textColor) && this.showGameButtonCustomText == adButton.showGameButtonCustomText && this.btnStyle == adButton.btnStyle && this.gameChannelId == adButton.gameChannelId && Intrinsics.areEqual(this.gameChannelExtra, adButton.gameChannelExtra) && Intrinsics.areEqual(this.gameSourcefrom, adButton.gameSourcefrom) && Intrinsics.areEqual(this.subCardModule, adButton.subCardModule) && Intrinsics.areEqual(this.dlsucCallupText, adButton.dlsucCallupText);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((this.text == null ? 0 : this.text.hashCode()) * 31) + this.type) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.callupUrl == null ? 0 : this.callupUrl.hashCode())) * 31) + (this.reportUrls == null ? 0 : this.reportUrls.hashCode())) * 31) + (this.dlsucCallupUrl == null ? 0 : this.dlsucCallupUrl.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.btnDelayTime)) * 31) + this.gameId) * 31) + (this.gameMonitorParam == null ? 0 : this.gameMonitorParam.hashCode())) * 31) + this.extremeTeamScore) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.storyArrow)) * 31) + this.showStyle) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.showDynamicTime)) * 31) + (this.btnBgColor == null ? 0 : this.btnBgColor.hashCode())) * 31) + (this.textColor == null ? 0 : this.textColor.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showGameButtonCustomText)) * 31) + this.btnStyle) * 31) + this.gameChannelId) * 31) + (this.gameChannelExtra == null ? 0 : this.gameChannelExtra.hashCode())) * 31) + (this.gameSourcefrom == null ? 0 : this.gameSourcefrom.hashCode())) * 31) + (this.subCardModule == null ? 0 : this.subCardModule.hashCode())) * 31) + (this.dlsucCallupText != null ? this.dlsucCallupText.hashCode() : 0);
    }

    public String toString() {
        String str = this.text;
        int i = this.type;
        String str2 = this.jumpUrl;
        String str3 = this.callupUrl;
        List<String> list = this.reportUrls;
        String str4 = this.dlsucCallupUrl;
        long j2 = this.btnDelayTime;
        int i2 = this.gameId;
        String str5 = this.gameMonitorParam;
        int i3 = this.extremeTeamScore;
        boolean z = this.storyArrow;
        int i4 = this.showStyle;
        long j3 = this.showDynamicTime;
        String str6 = this.btnBgColor;
        String str7 = this.textColor;
        boolean z2 = this.showGameButtonCustomText;
        int i5 = this.btnStyle;
        int i6 = this.gameChannelId;
        String str8 = this.gameChannelExtra;
        String str9 = this.gameSourcefrom;
        AdSubCardModule adSubCardModule = this.subCardModule;
        return "AdButton(text=" + str + ", type=" + i + ", jumpUrl=" + str2 + ", callupUrl=" + str3 + ", reportUrls=" + list + ", dlsucCallupUrl=" + str4 + ", btnDelayTime=" + j2 + ", gameId=" + i2 + ", gameMonitorParam=" + str5 + ", extremeTeamScore=" + i3 + ", storyArrow=" + z + ", showStyle=" + i4 + ", showDynamicTime=" + j3 + ", btnBgColor=" + str6 + ", textColor=" + str7 + ", showGameButtonCustomText=" + z2 + ", btnStyle=" + i5 + ", gameChannelId=" + i6 + ", gameChannelExtra=" + str8 + ", gameSourcefrom=" + str9 + ", subCardModule=" + adSubCardModule + ", dlsucCallupText=" + this.dlsucCallupText + ")";
    }

    /* compiled from: AdButton.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdButton$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdButton;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdButton> serializer() {
            return AdButton$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdButton(int seen0, String text, int type, String jumpUrl, String callupUrl, List reportUrls, String dlsucCallupUrl, long btnDelayTime, int gameId, String gameMonitorParam, int extremeTeamScore, boolean storyArrow, int showStyle, long showDynamicTime, String btnBgColor, String textColor, boolean showGameButtonCustomText, int btnStyle, int gameChannelId, String gameChannelExtra, String gameSourcefrom, AdSubCardModule subCardModule, String dlsucCallupText, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
        if ((seen0 & 2) == 0) {
            this.type = 0;
        } else {
            this.type = type;
        }
        if ((seen0 & 4) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 8) == 0) {
            this.callupUrl = null;
        } else {
            this.callupUrl = callupUrl;
        }
        if ((seen0 & 16) == 0) {
            this.reportUrls = null;
        } else {
            this.reportUrls = reportUrls;
        }
        if ((seen0 & 32) == 0) {
            this.dlsucCallupUrl = null;
        } else {
            this.dlsucCallupUrl = dlsucCallupUrl;
        }
        if ((seen0 & 64) == 0) {
            this.btnDelayTime = 0L;
        } else {
            this.btnDelayTime = btnDelayTime;
        }
        if ((seen0 & 128) == 0) {
            this.gameId = 0;
        } else {
            this.gameId = gameId;
        }
        if ((seen0 & 256) == 0) {
            this.gameMonitorParam = null;
        } else {
            this.gameMonitorParam = gameMonitorParam;
        }
        if ((seen0 & 512) == 0) {
            this.extremeTeamScore = 0;
        } else {
            this.extremeTeamScore = extremeTeamScore;
        }
        if ((seen0 & 1024) == 0) {
            this.storyArrow = false;
        } else {
            this.storyArrow = storyArrow;
        }
        if ((seen0 & 2048) == 0) {
            this.showStyle = 0;
        } else {
            this.showStyle = showStyle;
        }
        if ((seen0 & 4096) == 0) {
            this.showDynamicTime = LivePollConnection.DEFAULT_INTERVAL;
        } else {
            this.showDynamicTime = showDynamicTime;
        }
        if ((seen0 & 8192) == 0) {
            this.btnBgColor = null;
        } else {
            this.btnBgColor = btnBgColor;
        }
        if ((seen0 & 16384) == 0) {
            this.textColor = null;
        } else {
            this.textColor = textColor;
        }
        if ((32768 & seen0) == 0) {
            this.showGameButtonCustomText = false;
        } else {
            this.showGameButtonCustomText = showGameButtonCustomText;
        }
        if ((seen0 & 65536) == 0) {
            this.btnStyle = 0;
        } else {
            this.btnStyle = btnStyle;
        }
        if ((seen0 & 131072) == 0) {
            this.gameChannelId = 0;
        } else {
            this.gameChannelId = gameChannelId;
        }
        if ((seen0 & 262144) == 0) {
            this.gameChannelExtra = null;
        } else {
            this.gameChannelExtra = gameChannelExtra;
        }
        if ((seen0 & 524288) == 0) {
            this.gameSourcefrom = null;
        } else {
            this.gameSourcefrom = gameSourcefrom;
        }
        if ((seen0 & 1048576) == 0) {
            this.subCardModule = null;
        } else {
            this.subCardModule = subCardModule;
        }
        if ((seen0 & 2097152) == 0) {
            this.dlsucCallupText = null;
        } else {
            this.dlsucCallupText = dlsucCallupText;
        }
    }

    public AdButton(String text, int type, String jumpUrl, String callupUrl, List<String> list, String dlsucCallupUrl, long btnDelayTime, int gameId, String gameMonitorParam, int extremeTeamScore, boolean storyArrow, int showStyle, long showDynamicTime, String btnBgColor, String textColor, boolean showGameButtonCustomText, int btnStyle, int gameChannelId, String gameChannelExtra, String gameSourcefrom, AdSubCardModule subCardModule, String dlsucCallupText) {
        this.text = text;
        this.type = type;
        this.jumpUrl = jumpUrl;
        this.callupUrl = callupUrl;
        this.reportUrls = list;
        this.dlsucCallupUrl = dlsucCallupUrl;
        this.btnDelayTime = btnDelayTime;
        this.gameId = gameId;
        this.gameMonitorParam = gameMonitorParam;
        this.extremeTeamScore = extremeTeamScore;
        this.storyArrow = storyArrow;
        this.showStyle = showStyle;
        this.showDynamicTime = showDynamicTime;
        this.btnBgColor = btnBgColor;
        this.textColor = textColor;
        this.showGameButtonCustomText = showGameButtonCustomText;
        this.btnStyle = btnStyle;
        this.gameChannelId = gameChannelId;
        this.gameChannelExtra = gameChannelExtra;
        this.gameSourcefrom = gameSourcefrom;
        this.subCardModule = subCardModule;
        this.dlsucCallupText = dlsucCallupText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdButton self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != 0) {
            output.encodeIntElement(serialDesc, 1, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.callupUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.callupUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.reportUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.reportUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.dlsucCallupUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.dlsucCallupUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.btnDelayTime != 0) {
            output.encodeLongElement(serialDesc, 6, self.btnDelayTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.gameId != 0) {
            output.encodeIntElement(serialDesc, 7, self.gameId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.gameMonitorParam != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.gameMonitorParam);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.extremeTeamScore != 0) {
            output.encodeIntElement(serialDesc, 9, self.extremeTeamScore);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.storyArrow) {
            output.encodeBooleanElement(serialDesc, 10, self.storyArrow);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.showStyle != 0) {
            output.encodeIntElement(serialDesc, 11, self.showStyle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.showDynamicTime != LivePollConnection.DEFAULT_INTERVAL) {
            output.encodeLongElement(serialDesc, 12, self.showDynamicTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.btnBgColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.btnBgColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.textColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.textColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.showGameButtonCustomText) {
            output.encodeBooleanElement(serialDesc, 15, self.showGameButtonCustomText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.btnStyle != 0) {
            output.encodeIntElement(serialDesc, 16, self.btnStyle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.gameChannelId != 0) {
            output.encodeIntElement(serialDesc, 17, self.gameChannelId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.gameChannelExtra != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.gameChannelExtra);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.gameSourcefrom != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.gameSourcefrom);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.subCardModule != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, AdSubCardModule$$serializer.INSTANCE, self.subCardModule);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || self.dlsucCallupText != null) {
            output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.dlsucCallupText);
        }
    }

    public /* synthetic */ AdButton(String str, int i, String str2, String str3, List list, String str4, long j2, int i2, String str5, int i3, boolean z, int i4, long j3, String str6, String str7, boolean z2, int i5, int i6, String str8, String str9, AdSubCardModule adSubCardModule, String str10, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? null : str, (i7 & 2) != 0 ? 0 : i, (i7 & 4) != 0 ? null : str2, (i7 & 8) != 0 ? null : str3, (i7 & 16) != 0 ? null : list, (i7 & 32) != 0 ? null : str4, (i7 & 64) != 0 ? 0L : j2, (i7 & 128) != 0 ? 0 : i2, (i7 & 256) != 0 ? null : str5, (i7 & 512) != 0 ? 0 : i3, (i7 & 1024) != 0 ? false : z, (i7 & 2048) != 0 ? 0 : i4, (i7 & 4096) != 0 ? LivePollConnection.DEFAULT_INTERVAL : j3, (i7 & 8192) != 0 ? null : str6, (i7 & 16384) != 0 ? null : str7, (i7 & 32768) != 0 ? false : z2, (i7 & 65536) != 0 ? 0 : i5, (i7 & 131072) != 0 ? 0 : i6, (i7 & 262144) != 0 ? null : str8, (i7 & 524288) != 0 ? null : str9, (i7 & 1048576) != 0 ? null : adSubCardModule, (i7 & 2097152) != 0 ? null : str10);
    }

    public final String getText() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getCallupUrl() {
        return this.callupUrl;
    }

    public final List<String> getReportUrls() {
        return this.reportUrls;
    }

    public final String getDlsucCallupUrl() {
        return this.dlsucCallupUrl;
    }

    public final long getBtnDelayTime() {
        return this.btnDelayTime;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final String getGameMonitorParam() {
        return this.gameMonitorParam;
    }

    public final int getExtremeTeamScore() {
        return this.extremeTeamScore;
    }

    public final boolean getStoryArrow() {
        return this.storyArrow;
    }

    public final int getShowStyle() {
        return this.showStyle;
    }

    public final long getShowDynamicTime() {
        return this.showDynamicTime;
    }

    public final String getBtnBgColor() {
        return this.btnBgColor;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final boolean getShowGameButtonCustomText() {
        return this.showGameButtonCustomText;
    }

    public final int getBtnStyle() {
        return this.btnStyle;
    }

    public final int getGameChannelId() {
        return this.gameChannelId;
    }

    public final String getGameChannelExtra() {
        return this.gameChannelExtra;
    }

    public final String getGameSourcefrom() {
        return this.gameSourcefrom;
    }

    public final AdSubCardModule getSubCardModule() {
        return this.subCardModule;
    }

    public final String getDlsucCallupText() {
        return this.dlsucCallupText;
    }
}