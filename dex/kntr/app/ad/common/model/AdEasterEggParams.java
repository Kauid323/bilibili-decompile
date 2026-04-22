package kntr.app.ad.common.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdEasterEggParams.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 X2\u00020\u0001:\u0002WXBÇ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bB·\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001a\u0010\u001fJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u000bHÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\t\u0010@\u001a\u00020\u000bHÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0019HÆ\u0003JÉ\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010K\u001a\u00020\u00152\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\u0003HÖ\u0001J\t\u0010N\u001a\u00020\u0007HÖ\u0001J%\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0001¢\u0006\u0002\bVR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006Y"}, d2 = {"Lkntr/app/ad/common/model/AdEasterEggParams;", RoomRecommendViewModel.EMPTY_CURSOR, "eggType", RoomRecommendViewModel.EMPTY_CURSOR, "eggLottieDurTime", RoomRecommendViewModel.EMPTY_CURSOR, "eggLottie", RoomRecommendViewModel.EMPTY_CURSOR, "eggImage", "eggHint", "eggTwistAngle", RoomRecommendViewModel.EMPTY_CURSOR, "eggTwistSpeed", "eggLottieX", "eggLottieY", "natureStartTime", "natureCanTwistEndTime", "natureEndTime", "showBindSourceType", "lottieAnimateStyle", "lottieClickAble", RoomRecommendViewModel.EMPTY_CURSOR, "eggClickHint", "eggDesc", "drawGesture", "Lkntr/app/ad/common/model/AdDrawGesture;", "<init>", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FFFFJJJIIZLjava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdDrawGesture;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FFFFJJJIIZLjava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdDrawGesture;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEggType", "()I", "getEggLottieDurTime", "()J", "getEggLottie", "()Ljava/lang/String;", "getEggImage", "getEggHint", "getEggTwistAngle", "()F", "getEggTwistSpeed", "getEggLottieX", "getEggLottieY", "getNatureStartTime", "getNatureCanTwistEndTime", "getNatureEndTime", "getShowBindSourceType", "getLottieAnimateStyle", "getLottieClickAble", "()Z", "getEggClickHint", "getEggDesc", "getDrawGesture", "()Lkntr/app/ad/common/model/AdDrawGesture;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdEasterEggParams {
    public static final Companion Companion = new Companion(null);
    private final AdDrawGesture drawGesture;
    private final String eggClickHint;
    private final String eggDesc;
    private final String eggHint;
    private final String eggImage;
    private final String eggLottie;
    private final long eggLottieDurTime;
    private final float eggLottieX;
    private final float eggLottieY;
    private final float eggTwistAngle;
    private final float eggTwistSpeed;
    private final int eggType;
    private final int lottieAnimateStyle;
    private final boolean lottieClickAble;
    private final long natureCanTwistEndTime;
    private final long natureEndTime;
    private final long natureStartTime;
    private final int showBindSourceType;

    public AdEasterEggParams() {
        this(0, 0L, (String) null, (String) null, (String) null, 0.0f, 0.0f, 0.0f, 0.0f, 0L, 0L, 0L, 0, 0, false, (String) null, (String) null, (AdDrawGesture) null, 262143, (DefaultConstructorMarker) null);
    }

    public final int component1() {
        return this.eggType;
    }

    public final long component10() {
        return this.natureStartTime;
    }

    public final long component11() {
        return this.natureCanTwistEndTime;
    }

    public final long component12() {
        return this.natureEndTime;
    }

    public final int component13() {
        return this.showBindSourceType;
    }

    public final int component14() {
        return this.lottieAnimateStyle;
    }

    public final boolean component15() {
        return this.lottieClickAble;
    }

    public final String component16() {
        return this.eggClickHint;
    }

    public final String component17() {
        return this.eggDesc;
    }

    public final AdDrawGesture component18() {
        return this.drawGesture;
    }

    public final long component2() {
        return this.eggLottieDurTime;
    }

    public final String component3() {
        return this.eggLottie;
    }

    public final String component4() {
        return this.eggImage;
    }

    public final String component5() {
        return this.eggHint;
    }

    public final float component6() {
        return this.eggTwistAngle;
    }

    public final float component7() {
        return this.eggTwistSpeed;
    }

    public final float component8() {
        return this.eggLottieX;
    }

    public final float component9() {
        return this.eggLottieY;
    }

    public final AdEasterEggParams copy(int i, long j2, String str, String str2, String str3, float f, float f2, float f3, float f4, long j3, long j4, long j5, int i2, int i3, boolean z, String str4, String str5, AdDrawGesture adDrawGesture) {
        return new AdEasterEggParams(i, j2, str, str2, str3, f, f2, f3, f4, j3, j4, j5, i2, i3, z, str4, str5, adDrawGesture);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdEasterEggParams) {
            AdEasterEggParams adEasterEggParams = (AdEasterEggParams) obj;
            return this.eggType == adEasterEggParams.eggType && this.eggLottieDurTime == adEasterEggParams.eggLottieDurTime && Intrinsics.areEqual(this.eggLottie, adEasterEggParams.eggLottie) && Intrinsics.areEqual(this.eggImage, adEasterEggParams.eggImage) && Intrinsics.areEqual(this.eggHint, adEasterEggParams.eggHint) && Float.compare(this.eggTwistAngle, adEasterEggParams.eggTwistAngle) == 0 && Float.compare(this.eggTwistSpeed, adEasterEggParams.eggTwistSpeed) == 0 && Float.compare(this.eggLottieX, adEasterEggParams.eggLottieX) == 0 && Float.compare(this.eggLottieY, adEasterEggParams.eggLottieY) == 0 && this.natureStartTime == adEasterEggParams.natureStartTime && this.natureCanTwistEndTime == adEasterEggParams.natureCanTwistEndTime && this.natureEndTime == adEasterEggParams.natureEndTime && this.showBindSourceType == adEasterEggParams.showBindSourceType && this.lottieAnimateStyle == adEasterEggParams.lottieAnimateStyle && this.lottieClickAble == adEasterEggParams.lottieClickAble && Intrinsics.areEqual(this.eggClickHint, adEasterEggParams.eggClickHint) && Intrinsics.areEqual(this.eggDesc, adEasterEggParams.eggDesc) && Intrinsics.areEqual(this.drawGesture, adEasterEggParams.drawGesture);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.eggType * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.eggLottieDurTime)) * 31) + (this.eggLottie == null ? 0 : this.eggLottie.hashCode())) * 31) + (this.eggImage == null ? 0 : this.eggImage.hashCode())) * 31) + (this.eggHint == null ? 0 : this.eggHint.hashCode())) * 31) + Float.floatToIntBits(this.eggTwistAngle)) * 31) + Float.floatToIntBits(this.eggTwistSpeed)) * 31) + Float.floatToIntBits(this.eggLottieX)) * 31) + Float.floatToIntBits(this.eggLottieY)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.natureStartTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.natureCanTwistEndTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.natureEndTime)) * 31) + this.showBindSourceType) * 31) + this.lottieAnimateStyle) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.lottieClickAble)) * 31) + (this.eggClickHint == null ? 0 : this.eggClickHint.hashCode())) * 31) + (this.eggDesc == null ? 0 : this.eggDesc.hashCode())) * 31) + (this.drawGesture != null ? this.drawGesture.hashCode() : 0);
    }

    public String toString() {
        int i = this.eggType;
        long j2 = this.eggLottieDurTime;
        String str = this.eggLottie;
        String str2 = this.eggImage;
        String str3 = this.eggHint;
        float f = this.eggTwistAngle;
        float f2 = this.eggTwistSpeed;
        float f3 = this.eggLottieX;
        float f4 = this.eggLottieY;
        long j3 = this.natureStartTime;
        long j4 = this.natureCanTwistEndTime;
        long j5 = this.natureEndTime;
        int i2 = this.showBindSourceType;
        int i3 = this.lottieAnimateStyle;
        boolean z = this.lottieClickAble;
        String str4 = this.eggClickHint;
        String str5 = this.eggDesc;
        return "AdEasterEggParams(eggType=" + i + ", eggLottieDurTime=" + j2 + ", eggLottie=" + str + ", eggImage=" + str2 + ", eggHint=" + str3 + ", eggTwistAngle=" + f + ", eggTwistSpeed=" + f2 + ", eggLottieX=" + f3 + ", eggLottieY=" + f4 + ", natureStartTime=" + j3 + ", natureCanTwistEndTime=" + j4 + ", natureEndTime=" + j5 + ", showBindSourceType=" + i2 + ", lottieAnimateStyle=" + i3 + ", lottieClickAble=" + z + ", eggClickHint=" + str4 + ", eggDesc=" + str5 + ", drawGesture=" + this.drawGesture + ")";
    }

    /* compiled from: AdEasterEggParams.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdEasterEggParams$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdEasterEggParams;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdEasterEggParams> serializer() {
            return AdEasterEggParams$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdEasterEggParams(int seen0, int eggType, long eggLottieDurTime, String eggLottie, String eggImage, String eggHint, float eggTwistAngle, float eggTwistSpeed, float eggLottieX, float eggLottieY, long natureStartTime, long natureCanTwistEndTime, long natureEndTime, int showBindSourceType, int lottieAnimateStyle, boolean lottieClickAble, String eggClickHint, String eggDesc, AdDrawGesture drawGesture, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.eggType = 0;
        } else {
            this.eggType = eggType;
        }
        if ((seen0 & 2) == 0) {
            this.eggLottieDurTime = 0L;
        } else {
            this.eggLottieDurTime = eggLottieDurTime;
        }
        if ((seen0 & 4) == 0) {
            this.eggLottie = null;
        } else {
            this.eggLottie = eggLottie;
        }
        if ((seen0 & 8) == 0) {
            this.eggImage = null;
        } else {
            this.eggImage = eggImage;
        }
        if ((seen0 & 16) == 0) {
            this.eggHint = null;
        } else {
            this.eggHint = eggHint;
        }
        if ((seen0 & 32) == 0) {
            this.eggTwistAngle = 0.0f;
        } else {
            this.eggTwistAngle = eggTwistAngle;
        }
        if ((seen0 & 64) == 0) {
            this.eggTwistSpeed = 0.0f;
        } else {
            this.eggTwistSpeed = eggTwistSpeed;
        }
        if ((seen0 & 128) == 0) {
            this.eggLottieX = 0.0f;
        } else {
            this.eggLottieX = eggLottieX;
        }
        if ((seen0 & 256) == 0) {
            this.eggLottieY = 0.0f;
        } else {
            this.eggLottieY = eggLottieY;
        }
        if ((seen0 & 512) == 0) {
            this.natureStartTime = 0L;
        } else {
            this.natureStartTime = natureStartTime;
        }
        if ((seen0 & 1024) == 0) {
            this.natureCanTwistEndTime = 0L;
        } else {
            this.natureCanTwistEndTime = natureCanTwistEndTime;
        }
        if ((seen0 & 2048) == 0) {
            this.natureEndTime = 0L;
        } else {
            this.natureEndTime = natureEndTime;
        }
        if ((seen0 & 4096) == 0) {
            this.showBindSourceType = 0;
        } else {
            this.showBindSourceType = showBindSourceType;
        }
        if ((seen0 & 8192) == 0) {
            this.lottieAnimateStyle = 0;
        } else {
            this.lottieAnimateStyle = lottieAnimateStyle;
        }
        if ((seen0 & 16384) == 0) {
            this.lottieClickAble = false;
        } else {
            this.lottieClickAble = lottieClickAble;
        }
        if ((32768 & seen0) == 0) {
            this.eggClickHint = null;
        } else {
            this.eggClickHint = eggClickHint;
        }
        if ((seen0 & 65536) == 0) {
            this.eggDesc = null;
        } else {
            this.eggDesc = eggDesc;
        }
        if ((seen0 & 131072) == 0) {
            this.drawGesture = null;
        } else {
            this.drawGesture = drawGesture;
        }
    }

    public AdEasterEggParams(int eggType, long eggLottieDurTime, String eggLottie, String eggImage, String eggHint, float eggTwistAngle, float eggTwistSpeed, float eggLottieX, float eggLottieY, long natureStartTime, long natureCanTwistEndTime, long natureEndTime, int showBindSourceType, int lottieAnimateStyle, boolean lottieClickAble, String eggClickHint, String eggDesc, AdDrawGesture drawGesture) {
        this.eggType = eggType;
        this.eggLottieDurTime = eggLottieDurTime;
        this.eggLottie = eggLottie;
        this.eggImage = eggImage;
        this.eggHint = eggHint;
        this.eggTwistAngle = eggTwistAngle;
        this.eggTwistSpeed = eggTwistSpeed;
        this.eggLottieX = eggLottieX;
        this.eggLottieY = eggLottieY;
        this.natureStartTime = natureStartTime;
        this.natureCanTwistEndTime = natureCanTwistEndTime;
        this.natureEndTime = natureEndTime;
        this.showBindSourceType = showBindSourceType;
        this.lottieAnimateStyle = lottieAnimateStyle;
        this.lottieClickAble = lottieClickAble;
        this.eggClickHint = eggClickHint;
        this.eggDesc = eggDesc;
        this.drawGesture = drawGesture;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdEasterEggParams self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.eggType != 0) {
            output.encodeIntElement(serialDesc, 0, self.eggType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.eggLottieDurTime != 0) {
            output.encodeLongElement(serialDesc, 1, self.eggLottieDurTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.eggLottie != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.eggLottie);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.eggImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.eggImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.eggHint != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.eggHint);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || Float.compare(self.eggTwistAngle, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 5, self.eggTwistAngle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Float.compare(self.eggTwistSpeed, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 6, self.eggTwistSpeed);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Float.compare(self.eggLottieX, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 7, self.eggLottieX);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || Float.compare(self.eggLottieY, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 8, self.eggLottieY);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.natureStartTime != 0) {
            output.encodeLongElement(serialDesc, 9, self.natureStartTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.natureCanTwistEndTime != 0) {
            output.encodeLongElement(serialDesc, 10, self.natureCanTwistEndTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.natureEndTime != 0) {
            output.encodeLongElement(serialDesc, 11, self.natureEndTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.showBindSourceType != 0) {
            output.encodeIntElement(serialDesc, 12, self.showBindSourceType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.lottieAnimateStyle != 0) {
            output.encodeIntElement(serialDesc, 13, self.lottieAnimateStyle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.lottieClickAble) {
            output.encodeBooleanElement(serialDesc, 14, self.lottieClickAble);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.eggClickHint != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.eggClickHint);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.eggDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.eggDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.drawGesture != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, AdDrawGesture$$serializer.INSTANCE, self.drawGesture);
        }
    }

    public /* synthetic */ AdEasterEggParams(int i, long j2, String str, String str2, String str3, float f, float f2, float f3, float f4, long j3, long j4, long j5, int i2, int i3, boolean z, String str4, String str5, AdDrawGesture adDrawGesture, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0L : j2, (i4 & 4) != 0 ? null : str, (i4 & 8) != 0 ? null : str2, (i4 & 16) != 0 ? null : str3, (i4 & 32) != 0 ? 0.0f : f, (i4 & 64) != 0 ? 0.0f : f2, (i4 & 128) != 0 ? 0.0f : f3, (i4 & 256) == 0 ? f4 : 0.0f, (i4 & 512) != 0 ? 0L : j3, (i4 & 1024) != 0 ? 0L : j4, (i4 & 2048) == 0 ? j5 : 0L, (i4 & 4096) != 0 ? 0 : i2, (i4 & 8192) != 0 ? 0 : i3, (i4 & 16384) != 0 ? false : z, (i4 & 32768) != 0 ? null : str4, (i4 & 65536) != 0 ? null : str5, (i4 & 131072) != 0 ? null : adDrawGesture);
    }

    public final int getEggType() {
        return this.eggType;
    }

    public final long getEggLottieDurTime() {
        return this.eggLottieDurTime;
    }

    public final String getEggLottie() {
        return this.eggLottie;
    }

    public final String getEggImage() {
        return this.eggImage;
    }

    public final String getEggHint() {
        return this.eggHint;
    }

    public final float getEggTwistAngle() {
        return this.eggTwistAngle;
    }

    public final float getEggTwistSpeed() {
        return this.eggTwistSpeed;
    }

    public final float getEggLottieX() {
        return this.eggLottieX;
    }

    public final float getEggLottieY() {
        return this.eggLottieY;
    }

    public final long getNatureStartTime() {
        return this.natureStartTime;
    }

    public final long getNatureCanTwistEndTime() {
        return this.natureCanTwistEndTime;
    }

    public final long getNatureEndTime() {
        return this.natureEndTime;
    }

    public final int getShowBindSourceType() {
        return this.showBindSourceType;
    }

    public final int getLottieAnimateStyle() {
        return this.lottieAnimateStyle;
    }

    public final boolean getLottieClickAble() {
        return this.lottieClickAble;
    }

    public final String getEggClickHint() {
        return this.eggClickHint;
    }

    public final String getEggDesc() {
        return this.eggDesc;
    }

    public final AdDrawGesture getDrawGesture() {
        return this.drawGesture;
    }
}