package kntr.app.ad.common.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdHeartBox.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0002CDB\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013B\u0081\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008a\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\"R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001e¨\u0006E"}, d2 = {"Lkntr/app/ad/common/model/AdHeartBox;", RoomRecommendViewModel.EMPTY_CURSOR, "countDownSeconds", RoomRecommendViewModel.EMPTY_CURSOR, "countDownTitle", RoomRecommendViewModel.EMPTY_CURSOR, "title", "icon", "desc", "isBoxTwistOn", RoomRecommendViewModel.EMPTY_CURSOR, "boxTwistAngle", RoomRecommendViewModel.EMPTY_CURSOR, "boxTwistSpeed", "boxHintTime", RoomRecommendViewModel.EMPTY_CURSOR, "boxHint", "boxVideoUrl", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZFFJLjava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZFFJLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCountDownSeconds$annotations", "()V", "getCountDownSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCountDownTitle", "()Ljava/lang/String;", "getTitle", "getIcon", "getDesc", "()Z", "getBoxTwistAngle", "()F", "getBoxTwistSpeed", "getBoxHintTime", "()J", "getBoxHint", "getBoxVideoUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZFFJLjava/lang/String;Ljava/lang/String;)Lkntr/app/ad/common/model/AdHeartBox;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdHeartBox {
    public static final Companion Companion = new Companion(null);
    private final String boxHint;
    private final long boxHintTime;
    private final float boxTwistAngle;
    private final float boxTwistSpeed;
    private final String boxVideoUrl;
    private final Integer countDownSeconds;
    private final String countDownTitle;
    private final String desc;
    private final String icon;
    private final boolean isBoxTwistOn;
    private final String title;

    public AdHeartBox() {
        this((Integer) null, (String) null, (String) null, (String) null, (String) null, false, 0.0f, 0.0f, 0L, (String) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    @SerialName("count_down_secs")
    public static /* synthetic */ void getCountDownSeconds$annotations() {
    }

    public final Integer component1() {
        return this.countDownSeconds;
    }

    public final String component10() {
        return this.boxHint;
    }

    public final String component11() {
        return this.boxVideoUrl;
    }

    public final String component2() {
        return this.countDownTitle;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.desc;
    }

    public final boolean component6() {
        return this.isBoxTwistOn;
    }

    public final float component7() {
        return this.boxTwistAngle;
    }

    public final float component8() {
        return this.boxTwistSpeed;
    }

    public final long component9() {
        return this.boxHintTime;
    }

    public final AdHeartBox copy(Integer num, String str, String str2, String str3, String str4, boolean z, float f, float f2, long j2, String str5, String str6) {
        return new AdHeartBox(num, str, str2, str3, str4, z, f, f2, j2, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdHeartBox) {
            AdHeartBox adHeartBox = (AdHeartBox) obj;
            return Intrinsics.areEqual(this.countDownSeconds, adHeartBox.countDownSeconds) && Intrinsics.areEqual(this.countDownTitle, adHeartBox.countDownTitle) && Intrinsics.areEqual(this.title, adHeartBox.title) && Intrinsics.areEqual(this.icon, adHeartBox.icon) && Intrinsics.areEqual(this.desc, adHeartBox.desc) && this.isBoxTwistOn == adHeartBox.isBoxTwistOn && Float.compare(this.boxTwistAngle, adHeartBox.boxTwistAngle) == 0 && Float.compare(this.boxTwistSpeed, adHeartBox.boxTwistSpeed) == 0 && this.boxHintTime == adHeartBox.boxHintTime && Intrinsics.areEqual(this.boxHint, adHeartBox.boxHint) && Intrinsics.areEqual(this.boxVideoUrl, adHeartBox.boxVideoUrl);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((this.countDownSeconds == null ? 0 : this.countDownSeconds.hashCode()) * 31) + (this.countDownTitle == null ? 0 : this.countDownTitle.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isBoxTwistOn)) * 31) + Float.floatToIntBits(this.boxTwistAngle)) * 31) + Float.floatToIntBits(this.boxTwistSpeed)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.boxHintTime)) * 31) + (this.boxHint == null ? 0 : this.boxHint.hashCode())) * 31) + (this.boxVideoUrl != null ? this.boxVideoUrl.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.countDownSeconds;
        String str = this.countDownTitle;
        String str2 = this.title;
        String str3 = this.icon;
        String str4 = this.desc;
        boolean z = this.isBoxTwistOn;
        float f = this.boxTwistAngle;
        float f2 = this.boxTwistSpeed;
        long j2 = this.boxHintTime;
        String str5 = this.boxHint;
        return "AdHeartBox(countDownSeconds=" + num + ", countDownTitle=" + str + ", title=" + str2 + ", icon=" + str3 + ", desc=" + str4 + ", isBoxTwistOn=" + z + ", boxTwistAngle=" + f + ", boxTwistSpeed=" + f2 + ", boxHintTime=" + j2 + ", boxHint=" + str5 + ", boxVideoUrl=" + this.boxVideoUrl + ")";
    }

    /* compiled from: AdHeartBox.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdHeartBox$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdHeartBox;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdHeartBox> serializer() {
            return AdHeartBox$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdHeartBox(int seen0, Integer countDownSeconds, String countDownTitle, String title, String icon, String desc, boolean isBoxTwistOn, float boxTwistAngle, float boxTwistSpeed, long boxHintTime, String boxHint, String boxVideoUrl, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.countDownSeconds = 0;
        } else {
            this.countDownSeconds = countDownSeconds;
        }
        if ((seen0 & 2) == 0) {
            this.countDownTitle = null;
        } else {
            this.countDownTitle = countDownTitle;
        }
        if ((seen0 & 4) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 8) == 0) {
            this.icon = null;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 16) == 0) {
            this.desc = null;
        } else {
            this.desc = desc;
        }
        if ((seen0 & 32) == 0) {
            this.isBoxTwistOn = false;
        } else {
            this.isBoxTwistOn = isBoxTwistOn;
        }
        if ((seen0 & 64) == 0) {
            this.boxTwistAngle = 0.0f;
        } else {
            this.boxTwistAngle = boxTwistAngle;
        }
        if ((seen0 & 128) == 0) {
            this.boxTwistSpeed = 0.0f;
        } else {
            this.boxTwistSpeed = boxTwistSpeed;
        }
        if ((seen0 & 256) == 0) {
            this.boxHintTime = 0L;
        } else {
            this.boxHintTime = boxHintTime;
        }
        if ((seen0 & 512) == 0) {
            this.boxHint = null;
        } else {
            this.boxHint = boxHint;
        }
        if ((seen0 & 1024) == 0) {
            this.boxVideoUrl = null;
        } else {
            this.boxVideoUrl = boxVideoUrl;
        }
    }

    public AdHeartBox(Integer countDownSeconds, String countDownTitle, String title, String icon, String desc, boolean isBoxTwistOn, float boxTwistAngle, float boxTwistSpeed, long boxHintTime, String boxHint, String boxVideoUrl) {
        this.countDownSeconds = countDownSeconds;
        this.countDownTitle = countDownTitle;
        this.title = title;
        this.icon = icon;
        this.desc = desc;
        this.isBoxTwistOn = isBoxTwistOn;
        this.boxTwistAngle = boxTwistAngle;
        this.boxTwistSpeed = boxTwistSpeed;
        this.boxHintTime = boxHintTime;
        this.boxHint = boxHint;
        this.boxVideoUrl = boxVideoUrl;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdHeartBox self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Integer num;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || (num = self.countDownSeconds) == null || num.intValue() != 0) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.countDownSeconds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.countDownTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.countDownTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.desc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isBoxTwistOn) {
            output.encodeBooleanElement(serialDesc, 5, self.isBoxTwistOn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Float.compare(self.boxTwistAngle, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 6, self.boxTwistAngle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Float.compare(self.boxTwistSpeed, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 7, self.boxTwistSpeed);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.boxHintTime != 0) {
            output.encodeLongElement(serialDesc, 8, self.boxHintTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.boxHint != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.boxHint);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.boxVideoUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.boxVideoUrl);
        }
    }

    public /* synthetic */ AdHeartBox(Integer num, String str, String str2, String str3, String str4, boolean z, float f, float f2, long j2, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) == 0 ? z : false, (i & 64) != 0 ? 0.0f : f, (i & 128) == 0 ? f2 : 0.0f, (i & 256) != 0 ? 0L : j2, (i & 512) != 0 ? null : str5, (i & 1024) == 0 ? str6 : null);
    }

    public final Integer getCountDownSeconds() {
        return this.countDownSeconds;
    }

    public final String getCountDownTitle() {
        return this.countDownTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean isBoxTwistOn() {
        return this.isBoxTwistOn;
    }

    public final float getBoxTwistAngle() {
        return this.boxTwistAngle;
    }

    public final float getBoxTwistSpeed() {
        return this.boxTwistSpeed;
    }

    public final long getBoxHintTime() {
        return this.boxHintTime;
    }

    public final String getBoxHint() {
        return this.boxHint;
    }

    public final String getBoxVideoUrl() {
        return this.boxVideoUrl;
    }
}