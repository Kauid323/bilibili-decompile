package kntr.app.ad.common.model;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003JA\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lkntr/app/ad/common/model/AdGameQualityInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "grade", RoomRecommendViewModel.EMPTY_CURSOR, "firstLine", RoomRecommendViewModel.EMPTY_CURSOR, "secondLine", "rankIcon", "type", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGrade", "()F", "getFirstLine", "()Ljava/lang/String;", "getSecondLine", "getRankIcon", "getType$annotations", "()V", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGameQualityInfo {
    public static final Companion Companion = new Companion(null);
    private final String firstLine;
    private final float grade;
    private final String rankIcon;
    private final String secondLine;
    private final int type;

    public AdGameQualityInfo() {
        this(0.0f, (String) null, (String) null, (String) null, 0, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdGameQualityInfo copy$default(AdGameQualityInfo adGameQualityInfo, float f, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = adGameQualityInfo.grade;
        }
        if ((i2 & 2) != 0) {
            str = adGameQualityInfo.firstLine;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = adGameQualityInfo.secondLine;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = adGameQualityInfo.rankIcon;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            i = adGameQualityInfo.type;
        }
        return adGameQualityInfo.copy(f, str4, str5, str6, i);
    }

    @SerialName("quality_type")
    public static /* synthetic */ void getType$annotations() {
    }

    public final float component1() {
        return this.grade;
    }

    public final String component2() {
        return this.firstLine;
    }

    public final String component3() {
        return this.secondLine;
    }

    public final String component4() {
        return this.rankIcon;
    }

    public final int component5() {
        return this.type;
    }

    public final AdGameQualityInfo copy(float f, String str, String str2, String str3, int i) {
        return new AdGameQualityInfo(f, str, str2, str3, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGameQualityInfo) {
            AdGameQualityInfo adGameQualityInfo = (AdGameQualityInfo) obj;
            return Float.compare(this.grade, adGameQualityInfo.grade) == 0 && Intrinsics.areEqual(this.firstLine, adGameQualityInfo.firstLine) && Intrinsics.areEqual(this.secondLine, adGameQualityInfo.secondLine) && Intrinsics.areEqual(this.rankIcon, adGameQualityInfo.rankIcon) && this.type == adGameQualityInfo.type;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.grade) * 31) + (this.firstLine == null ? 0 : this.firstLine.hashCode())) * 31) + (this.secondLine == null ? 0 : this.secondLine.hashCode())) * 31) + (this.rankIcon != null ? this.rankIcon.hashCode() : 0)) * 31) + this.type;
    }

    public String toString() {
        float f = this.grade;
        String str = this.firstLine;
        String str2 = this.secondLine;
        String str3 = this.rankIcon;
        return "AdGameQualityInfo(grade=" + f + ", firstLine=" + str + ", secondLine=" + str2 + ", rankIcon=" + str3 + ", type=" + this.type + ")";
    }

    /* compiled from: AdAndroidGameInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGameQualityInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGameQualityInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGameQualityInfo> serializer() {
            return AdGameQualityInfo$$serializer.INSTANCE;
        }
    }

    public AdGameQualityInfo(float grade, String firstLine, String secondLine, String rankIcon, int type) {
        this.grade = grade;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.rankIcon = rankIcon;
        this.type = type;
    }

    public /* synthetic */ AdGameQualityInfo(int seen0, float grade, String firstLine, String secondLine, String rankIcon, int type, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.grade = 0.0f;
        } else {
            this.grade = grade;
        }
        if ((seen0 & 2) == 0) {
            this.firstLine = null;
        } else {
            this.firstLine = firstLine;
        }
        if ((seen0 & 4) == 0) {
            this.secondLine = null;
        } else {
            this.secondLine = secondLine;
        }
        if ((seen0 & 8) == 0) {
            this.rankIcon = null;
        } else {
            this.rankIcon = rankIcon;
        }
        if ((seen0 & 16) == 0) {
            this.type = 2;
        } else {
            this.type = type;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGameQualityInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || Float.compare(self.grade, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 0, self.grade);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.firstLine != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.firstLine);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.secondLine != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.secondLine);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.rankIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.rankIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.type != 2) {
            output.encodeIntElement(serialDesc, 4, self.type);
        }
    }

    public /* synthetic */ AdGameQualityInfo(float f, String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) == 0 ? str3 : null, (i2 & 16) != 0 ? 2 : i);
    }

    public final float getGrade() {
        return this.grade;
    }

    public final String getFirstLine() {
        return this.firstLine;
    }

    public final String getSecondLine() {
        return this.secondLine;
    }

    public final String getRankIcon() {
        return this.rankIcon;
    }

    public final int getType() {
        return this.type;
    }
}