package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdTreasureHuntBall.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 U2\u00020\u0001:\u0002TUBá\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019BÑ\u0001\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0018\u0010\u001dJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jã\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0005HÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001J%\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0001¢\u0006\u0002\bSR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u001b\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001f¨\u0006V"}, d2 = {"Lkntr/app/ad/common/model/AdTreasureHuntBall;", RoomRecommendViewModel.EMPTY_CURSOR, "ballId", RoomRecommendViewModel.EMPTY_CURSOR, "achieveStatus", RoomRecommendViewModel.EMPTY_CURSOR, "appearanceTime", RoomRecommendViewModel.EMPTY_CURSOR, "appearanceDuration", "text", "imageUrl", "options", RoomRecommendViewModel.EMPTY_CURSOR, "buttonText", "successText", "successImageUrl", "successButtonText", "failureText", "achieveText", "achieveImageUrl", "achieveButtonText", "jumpUrl", "adTagImageUrl", "adTagText", "<init>", "(Ljava/lang/String;IJJLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IJJLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBallId", "()Ljava/lang/String;", "getAchieveStatus", "()I", "getAppearanceTime", "()J", "getAppearanceDuration", "getText", "getImageUrl", "getOptions", "()Ljava/util/List;", "getButtonText", "getSuccessText", "getSuccessImageUrl", "getSuccessButtonText", "getFailureText", "getAchieveText", "getAchieveImageUrl", "getAchieveButtonText", "getJumpUrl", "getAdTagImageUrl", "getAdTagText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdTreasureHuntBall {
    private final String achieveButtonText;
    private final String achieveImageUrl;
    private final int achieveStatus;
    private final String achieveText;
    private final String adTagImageUrl;
    private final String adTagText;
    private final long appearanceDuration;
    private final long appearanceTime;
    private final String ballId;
    private final String buttonText;
    private final String failureText;
    private final String imageUrl;
    private final String jumpUrl;
    private final List<String> options;
    private final String successButtonText;
    private final String successImageUrl;
    private final String successText;
    private final String text;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdTreasureHuntBall$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdTreasureHuntBall._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, null, null, null};

    public AdTreasureHuntBall() {
        this((String) null, 0, 0L, 0L, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 262143, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.ballId;
    }

    public final String component10() {
        return this.successImageUrl;
    }

    public final String component11() {
        return this.successButtonText;
    }

    public final String component12() {
        return this.failureText;
    }

    public final String component13() {
        return this.achieveText;
    }

    public final String component14() {
        return this.achieveImageUrl;
    }

    public final String component15() {
        return this.achieveButtonText;
    }

    public final String component16() {
        return this.jumpUrl;
    }

    public final String component17() {
        return this.adTagImageUrl;
    }

    public final String component18() {
        return this.adTagText;
    }

    public final int component2() {
        return this.achieveStatus;
    }

    public final long component3() {
        return this.appearanceTime;
    }

    public final long component4() {
        return this.appearanceDuration;
    }

    public final String component5() {
        return this.text;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final List<String> component7() {
        return this.options;
    }

    public final String component8() {
        return this.buttonText;
    }

    public final String component9() {
        return this.successText;
    }

    public final AdTreasureHuntBall copy(String str, int i, long j2, long j3, String str2, String str3, List<String> list, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        return new AdTreasureHuntBall(str, i, j2, j3, str2, str3, list, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdTreasureHuntBall) {
            AdTreasureHuntBall adTreasureHuntBall = (AdTreasureHuntBall) obj;
            return Intrinsics.areEqual(this.ballId, adTreasureHuntBall.ballId) && this.achieveStatus == adTreasureHuntBall.achieveStatus && this.appearanceTime == adTreasureHuntBall.appearanceTime && this.appearanceDuration == adTreasureHuntBall.appearanceDuration && Intrinsics.areEqual(this.text, adTreasureHuntBall.text) && Intrinsics.areEqual(this.imageUrl, adTreasureHuntBall.imageUrl) && Intrinsics.areEqual(this.options, adTreasureHuntBall.options) && Intrinsics.areEqual(this.buttonText, adTreasureHuntBall.buttonText) && Intrinsics.areEqual(this.successText, adTreasureHuntBall.successText) && Intrinsics.areEqual(this.successImageUrl, adTreasureHuntBall.successImageUrl) && Intrinsics.areEqual(this.successButtonText, adTreasureHuntBall.successButtonText) && Intrinsics.areEqual(this.failureText, adTreasureHuntBall.failureText) && Intrinsics.areEqual(this.achieveText, adTreasureHuntBall.achieveText) && Intrinsics.areEqual(this.achieveImageUrl, adTreasureHuntBall.achieveImageUrl) && Intrinsics.areEqual(this.achieveButtonText, adTreasureHuntBall.achieveButtonText) && Intrinsics.areEqual(this.jumpUrl, adTreasureHuntBall.jumpUrl) && Intrinsics.areEqual(this.adTagImageUrl, adTreasureHuntBall.adTagImageUrl) && Intrinsics.areEqual(this.adTagText, adTreasureHuntBall.adTagText);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((this.ballId == null ? 0 : this.ballId.hashCode()) * 31) + this.achieveStatus) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.appearanceTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.appearanceDuration)) * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31) + (this.imageUrl == null ? 0 : this.imageUrl.hashCode())) * 31) + (this.options == null ? 0 : this.options.hashCode())) * 31) + (this.buttonText == null ? 0 : this.buttonText.hashCode())) * 31) + (this.successText == null ? 0 : this.successText.hashCode())) * 31) + (this.successImageUrl == null ? 0 : this.successImageUrl.hashCode())) * 31) + (this.successButtonText == null ? 0 : this.successButtonText.hashCode())) * 31) + (this.failureText == null ? 0 : this.failureText.hashCode())) * 31) + (this.achieveText == null ? 0 : this.achieveText.hashCode())) * 31) + (this.achieveImageUrl == null ? 0 : this.achieveImageUrl.hashCode())) * 31) + (this.achieveButtonText == null ? 0 : this.achieveButtonText.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.adTagImageUrl == null ? 0 : this.adTagImageUrl.hashCode())) * 31) + (this.adTagText != null ? this.adTagText.hashCode() : 0);
    }

    public String toString() {
        String str = this.ballId;
        int i = this.achieveStatus;
        long j2 = this.appearanceTime;
        long j3 = this.appearanceDuration;
        String str2 = this.text;
        String str3 = this.imageUrl;
        List<String> list = this.options;
        String str4 = this.buttonText;
        String str5 = this.successText;
        String str6 = this.successImageUrl;
        String str7 = this.successButtonText;
        String str8 = this.failureText;
        String str9 = this.achieveText;
        String str10 = this.achieveImageUrl;
        String str11 = this.achieveButtonText;
        String str12 = this.jumpUrl;
        String str13 = this.adTagImageUrl;
        return "AdTreasureHuntBall(ballId=" + str + ", achieveStatus=" + i + ", appearanceTime=" + j2 + ", appearanceDuration=" + j3 + ", text=" + str2 + ", imageUrl=" + str3 + ", options=" + list + ", buttonText=" + str4 + ", successText=" + str5 + ", successImageUrl=" + str6 + ", successButtonText=" + str7 + ", failureText=" + str8 + ", achieveText=" + str9 + ", achieveImageUrl=" + str10 + ", achieveButtonText=" + str11 + ", jumpUrl=" + str12 + ", adTagImageUrl=" + str13 + ", adTagText=" + this.adTagText + ")";
    }

    /* compiled from: AdTreasureHuntBall.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdTreasureHuntBall$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdTreasureHuntBall;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdTreasureHuntBall> serializer() {
            return AdTreasureHuntBall$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdTreasureHuntBall(int seen0, String ballId, int achieveStatus, long appearanceTime, long appearanceDuration, String text, String imageUrl, List options, String buttonText, String successText, String successImageUrl, String successButtonText, String failureText, String achieveText, String achieveImageUrl, String achieveButtonText, String jumpUrl, String adTagImageUrl, String adTagText, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.ballId = null;
        } else {
            this.ballId = ballId;
        }
        if ((seen0 & 2) == 0) {
            this.achieveStatus = 0;
        } else {
            this.achieveStatus = achieveStatus;
        }
        if ((seen0 & 4) == 0) {
            this.appearanceTime = 0L;
        } else {
            this.appearanceTime = appearanceTime;
        }
        if ((seen0 & 8) == 0) {
            this.appearanceDuration = 0L;
        } else {
            this.appearanceDuration = appearanceDuration;
        }
        if ((seen0 & 16) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
        if ((seen0 & 32) == 0) {
            this.imageUrl = null;
        } else {
            this.imageUrl = imageUrl;
        }
        if ((seen0 & 64) == 0) {
            this.options = null;
        } else {
            this.options = options;
        }
        if ((seen0 & 128) == 0) {
            this.buttonText = null;
        } else {
            this.buttonText = buttonText;
        }
        if ((seen0 & 256) == 0) {
            this.successText = null;
        } else {
            this.successText = successText;
        }
        if ((seen0 & 512) == 0) {
            this.successImageUrl = null;
        } else {
            this.successImageUrl = successImageUrl;
        }
        if ((seen0 & 1024) == 0) {
            this.successButtonText = null;
        } else {
            this.successButtonText = successButtonText;
        }
        if ((seen0 & 2048) == 0) {
            this.failureText = null;
        } else {
            this.failureText = failureText;
        }
        if ((seen0 & 4096) == 0) {
            this.achieveText = null;
        } else {
            this.achieveText = achieveText;
        }
        if ((seen0 & 8192) == 0) {
            this.achieveImageUrl = null;
        } else {
            this.achieveImageUrl = achieveImageUrl;
        }
        if ((seen0 & 16384) == 0) {
            this.achieveButtonText = null;
        } else {
            this.achieveButtonText = achieveButtonText;
        }
        if ((seen0 & 32768) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 65536) == 0) {
            this.adTagImageUrl = null;
        } else {
            this.adTagImageUrl = adTagImageUrl;
        }
        if ((seen0 & 131072) == 0) {
            this.adTagText = null;
        } else {
            this.adTagText = adTagText;
        }
    }

    public AdTreasureHuntBall(String ballId, int achieveStatus, long appearanceTime, long appearanceDuration, String text, String imageUrl, List<String> list, String buttonText, String successText, String successImageUrl, String successButtonText, String failureText, String achieveText, String achieveImageUrl, String achieveButtonText, String jumpUrl, String adTagImageUrl, String adTagText) {
        this.ballId = ballId;
        this.achieveStatus = achieveStatus;
        this.appearanceTime = appearanceTime;
        this.appearanceDuration = appearanceDuration;
        this.text = text;
        this.imageUrl = imageUrl;
        this.options = list;
        this.buttonText = buttonText;
        this.successText = successText;
        this.successImageUrl = successImageUrl;
        this.successButtonText = successButtonText;
        this.failureText = failureText;
        this.achieveText = achieveText;
        this.achieveImageUrl = achieveImageUrl;
        this.achieveButtonText = achieveButtonText;
        this.jumpUrl = jumpUrl;
        this.adTagImageUrl = adTagImageUrl;
        this.adTagText = adTagText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdTreasureHuntBall self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ballId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.ballId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.achieveStatus != 0) {
            output.encodeIntElement(serialDesc, 1, self.achieveStatus);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.appearanceTime != 0) {
            output.encodeLongElement(serialDesc, 2, self.appearanceTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.appearanceDuration != 0) {
            output.encodeLongElement(serialDesc, 3, self.appearanceDuration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.imageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.imageUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.options != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.options);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.buttonText != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.buttonText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.successText != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.successText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.successImageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.successImageUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.successButtonText != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.successButtonText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.failureText != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.failureText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.achieveText != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.achieveText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.achieveImageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.achieveImageUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.achieveButtonText != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.achieveButtonText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.adTagImageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.adTagImageUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.adTagText != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.adTagText);
        }
    }

    public /* synthetic */ AdTreasureHuntBall(String str, int i, long j2, long j3, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0L : j2, (i2 & 8) == 0 ? j3 : 0L, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : list, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? null : str5, (i2 & 512) != 0 ? null : str6, (i2 & 1024) != 0 ? null : str7, (i2 & 2048) != 0 ? null : str8, (i2 & 4096) != 0 ? null : str9, (i2 & 8192) != 0 ? null : str10, (i2 & 16384) != 0 ? null : str11, (i2 & 32768) != 0 ? null : str12, (i2 & 65536) != 0 ? null : str13, (i2 & 131072) != 0 ? null : str14);
    }

    public final String getBallId() {
        return this.ballId;
    }

    public final int getAchieveStatus() {
        return this.achieveStatus;
    }

    public final long getAppearanceTime() {
        return this.appearanceTime;
    }

    public final long getAppearanceDuration() {
        return this.appearanceDuration;
    }

    public final String getText() {
        return this.text;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final List<String> getOptions() {
        return this.options;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getSuccessText() {
        return this.successText;
    }

    public final String getSuccessImageUrl() {
        return this.successImageUrl;
    }

    public final String getSuccessButtonText() {
        return this.successButtonText;
    }

    public final String getFailureText() {
        return this.failureText;
    }

    public final String getAchieveText() {
        return this.achieveText;
    }

    public final String getAchieveImageUrl() {
        return this.achieveImageUrl;
    }

    public final String getAchieveButtonText() {
        return this.achieveButtonText;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getAdTagImageUrl() {
        return this.adTagImageUrl;
    }

    public final String getAdTagText() {
        return this.adTagText;
    }
}