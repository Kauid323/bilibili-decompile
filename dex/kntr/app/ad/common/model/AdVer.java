package kntr.app.ad.common.model;

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

/* compiled from: AdVer.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JM\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lkntr/app/ad/common/model/AdVer;", RoomRecommendViewModel.EMPTY_CURSOR, "adverDesc", RoomRecommendViewModel.EMPTY_CURSOR, "adverId", RoomRecommendViewModel.EMPTY_CURSOR, "adverLogo", "adverName", "adverPageUrl", "adverType", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdverDesc", "()Ljava/lang/String;", "getAdverId", "()J", "getAdverLogo", "getAdverName", "getAdverPageUrl", "getAdverType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdVer {
    public static final Companion Companion = new Companion(null);
    private final String adverDesc;
    private final long adverId;
    private final String adverLogo;
    private final String adverName;
    private final String adverPageUrl;
    private final int adverType;

    public AdVer() {
        this((String) null, 0L, (String) null, (String) null, (String) null, 0, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdVer copy$default(AdVer adVer, String str, long j2, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = adVer.adverDesc;
        }
        if ((i2 & 2) != 0) {
            j2 = adVer.adverId;
        }
        long j3 = j2;
        if ((i2 & 4) != 0) {
            str2 = adVer.adverLogo;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = adVer.adverName;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = adVer.adverPageUrl;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            i = adVer.adverType;
        }
        return adVer.copy(str, j3, str5, str6, str7, i);
    }

    public final String component1() {
        return this.adverDesc;
    }

    public final long component2() {
        return this.adverId;
    }

    public final String component3() {
        return this.adverLogo;
    }

    public final String component4() {
        return this.adverName;
    }

    public final String component5() {
        return this.adverPageUrl;
    }

    public final int component6() {
        return this.adverType;
    }

    public final AdVer copy(String str, long j2, String str2, String str3, String str4, int i) {
        return new AdVer(str, j2, str2, str3, str4, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdVer) {
            AdVer adVer = (AdVer) obj;
            return Intrinsics.areEqual(this.adverDesc, adVer.adverDesc) && this.adverId == adVer.adverId && Intrinsics.areEqual(this.adverLogo, adVer.adverLogo) && Intrinsics.areEqual(this.adverName, adVer.adverName) && Intrinsics.areEqual(this.adverPageUrl, adVer.adverPageUrl) && this.adverType == adVer.adverType;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.adverDesc == null ? 0 : this.adverDesc.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.adverId)) * 31) + (this.adverLogo == null ? 0 : this.adverLogo.hashCode())) * 31) + (this.adverName == null ? 0 : this.adverName.hashCode())) * 31) + (this.adverPageUrl != null ? this.adverPageUrl.hashCode() : 0)) * 31) + this.adverType;
    }

    public String toString() {
        String str = this.adverDesc;
        long j2 = this.adverId;
        String str2 = this.adverLogo;
        String str3 = this.adverName;
        String str4 = this.adverPageUrl;
        return "AdVer(adverDesc=" + str + ", adverId=" + j2 + ", adverLogo=" + str2 + ", adverName=" + str3 + ", adverPageUrl=" + str4 + ", adverType=" + this.adverType + ")";
    }

    /* compiled from: AdVer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdVer$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdVer;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdVer> serializer() {
            return AdVer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdVer(int seen0, String adverDesc, long adverId, String adverLogo, String adverName, String adverPageUrl, int adverType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.adverDesc = null;
        } else {
            this.adverDesc = adverDesc;
        }
        if ((seen0 & 2) == 0) {
            this.adverId = 0L;
        } else {
            this.adverId = adverId;
        }
        if ((seen0 & 4) == 0) {
            this.adverLogo = null;
        } else {
            this.adverLogo = adverLogo;
        }
        if ((seen0 & 8) == 0) {
            this.adverName = null;
        } else {
            this.adverName = adverName;
        }
        if ((seen0 & 16) == 0) {
            this.adverPageUrl = null;
        } else {
            this.adverPageUrl = adverPageUrl;
        }
        if ((seen0 & 32) == 0) {
            this.adverType = 0;
        } else {
            this.adverType = adverType;
        }
    }

    public AdVer(String adverDesc, long adverId, String adverLogo, String adverName, String adverPageUrl, int adverType) {
        this.adverDesc = adverDesc;
        this.adverId = adverId;
        this.adverLogo = adverLogo;
        this.adverName = adverName;
        this.adverPageUrl = adverPageUrl;
        this.adverType = adverType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdVer self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.adverDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.adverDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.adverId != 0) {
            output.encodeLongElement(serialDesc, 1, self.adverId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.adverLogo != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.adverLogo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.adverName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.adverName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.adverPageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.adverPageUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.adverType != 0) {
            output.encodeIntElement(serialDesc, 5, self.adverType);
        }
    }

    public /* synthetic */ AdVer(String str, long j2, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) == 0 ? str4 : null, (i2 & 32) != 0 ? 0 : i);
    }

    public final String getAdverDesc() {
        return this.adverDesc;
    }

    public final long getAdverId() {
        return this.adverId;
    }

    public final String getAdverLogo() {
        return this.adverLogo;
    }

    public final String getAdverName() {
        return this.adverName;
    }

    public final String getAdverPageUrl() {
        return this.adverPageUrl;
    }

    public final int getAdverType() {
        return this.adverType;
    }
}