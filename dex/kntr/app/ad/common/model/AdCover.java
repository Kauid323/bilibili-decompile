package kntr.app.ad.common.model;

import BottomSheetItemData$;
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdCover.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011B\u007f\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\u0081\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u00101\u001a\u00020\u000f2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\tHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006?"}, d2 = {"Lkntr/app/ad/common/model/AdCover;", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "nightUrl", "jumpUrl", "reportUrls", RoomRecommendViewModel.EMPTY_CURSOR, "loopCount", RoomRecommendViewModel.EMPTY_CURSOR, "imageHeight", "imageWidth", "gifUrl", "gifCoverUrl", "gifTagShow", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IIILjava/lang/String;Ljava/lang/String;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IIILjava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "getNightUrl", "getJumpUrl", "getReportUrls", "()Ljava/util/List;", "getLoopCount$annotations", "()V", "getLoopCount", "()I", "getImageHeight", "getImageWidth", "getGifUrl", "getGifCoverUrl", "getGifTagShow", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdCover {
    private final String gifCoverUrl;
    private final boolean gifTagShow;
    private final String gifUrl;
    private final int imageHeight;
    private final int imageWidth;
    private final String jumpUrl;
    private final int loopCount;
    private final String nightUrl;
    private final List<String> reportUrls;
    private final String url;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdCover$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdCover._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null};

    public AdCover() {
        this((String) null, (String) null, (String) null, (List) null, 0, 0, 0, (String) null, (String) null, false, 1023, (DefaultConstructorMarker) null);
    }

    @SerialName("loop")
    public static /* synthetic */ void getLoopCount$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final boolean component10() {
        return this.gifTagShow;
    }

    public final String component2() {
        return this.nightUrl;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final List<String> component4() {
        return this.reportUrls;
    }

    public final int component5() {
        return this.loopCount;
    }

    public final int component6() {
        return this.imageHeight;
    }

    public final int component7() {
        return this.imageWidth;
    }

    public final String component8() {
        return this.gifUrl;
    }

    public final String component9() {
        return this.gifCoverUrl;
    }

    public final AdCover copy(String str, String str2, String str3, List<String> list, int i, int i2, int i3, String str4, String str5, boolean z) {
        return new AdCover(str, str2, str3, list, i, i2, i3, str4, str5, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdCover) {
            AdCover adCover = (AdCover) obj;
            return Intrinsics.areEqual(this.url, adCover.url) && Intrinsics.areEqual(this.nightUrl, adCover.nightUrl) && Intrinsics.areEqual(this.jumpUrl, adCover.jumpUrl) && Intrinsics.areEqual(this.reportUrls, adCover.reportUrls) && this.loopCount == adCover.loopCount && this.imageHeight == adCover.imageHeight && this.imageWidth == adCover.imageWidth && Intrinsics.areEqual(this.gifUrl, adCover.gifUrl) && Intrinsics.areEqual(this.gifCoverUrl, adCover.gifCoverUrl) && this.gifTagShow == adCover.gifTagShow;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.nightUrl == null ? 0 : this.nightUrl.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.reportUrls == null ? 0 : this.reportUrls.hashCode())) * 31) + this.loopCount) * 31) + this.imageHeight) * 31) + this.imageWidth) * 31) + (this.gifUrl == null ? 0 : this.gifUrl.hashCode())) * 31) + (this.gifCoverUrl != null ? this.gifCoverUrl.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.gifTagShow);
    }

    public String toString() {
        String str = this.url;
        String str2 = this.nightUrl;
        String str3 = this.jumpUrl;
        List<String> list = this.reportUrls;
        int i = this.loopCount;
        int i2 = this.imageHeight;
        int i3 = this.imageWidth;
        String str4 = this.gifUrl;
        String str5 = this.gifCoverUrl;
        return "AdCover(url=" + str + ", nightUrl=" + str2 + ", jumpUrl=" + str3 + ", reportUrls=" + list + ", loopCount=" + i + ", imageHeight=" + i2 + ", imageWidth=" + i3 + ", gifUrl=" + str4 + ", gifCoverUrl=" + str5 + ", gifTagShow=" + this.gifTagShow + ")";
    }

    /* compiled from: AdCover.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdCover$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdCover;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdCover> serializer() {
            return AdCover$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdCover(int seen0, String url, String nightUrl, String jumpUrl, List reportUrls, int loopCount, int imageHeight, int imageWidth, String gifUrl, String gifCoverUrl, boolean gifTagShow, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 2) == 0) {
            this.nightUrl = null;
        } else {
            this.nightUrl = nightUrl;
        }
        if ((seen0 & 4) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 8) == 0) {
            this.reportUrls = null;
        } else {
            this.reportUrls = reportUrls;
        }
        if ((seen0 & 16) == 0) {
            this.loopCount = 0;
        } else {
            this.loopCount = loopCount;
        }
        if ((seen0 & 32) == 0) {
            this.imageHeight = 0;
        } else {
            this.imageHeight = imageHeight;
        }
        if ((seen0 & 64) == 0) {
            this.imageWidth = 0;
        } else {
            this.imageWidth = imageWidth;
        }
        if ((seen0 & 128) == 0) {
            this.gifUrl = null;
        } else {
            this.gifUrl = gifUrl;
        }
        if ((seen0 & 256) == 0) {
            this.gifCoverUrl = null;
        } else {
            this.gifCoverUrl = gifCoverUrl;
        }
        if ((seen0 & 512) == 0) {
            this.gifTagShow = false;
        } else {
            this.gifTagShow = gifTagShow;
        }
    }

    public AdCover(String url, String nightUrl, String jumpUrl, List<String> list, int loopCount, int imageHeight, int imageWidth, String gifUrl, String gifCoverUrl, boolean gifTagShow) {
        this.url = url;
        this.nightUrl = nightUrl;
        this.jumpUrl = jumpUrl;
        this.reportUrls = list;
        this.loopCount = loopCount;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
        this.gifUrl = gifUrl;
        this.gifCoverUrl = gifCoverUrl;
        this.gifTagShow = gifTagShow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdCover self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.nightUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.nightUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.reportUrls != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.reportUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.loopCount != 0) {
            output.encodeIntElement(serialDesc, 4, self.loopCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.imageHeight != 0) {
            output.encodeIntElement(serialDesc, 5, self.imageHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.imageWidth != 0) {
            output.encodeIntElement(serialDesc, 6, self.imageWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.gifUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.gifUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.gifCoverUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.gifCoverUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.gifTagShow) {
            output.encodeBooleanElement(serialDesc, 9, self.gifTagShow);
        }
    }

    public /* synthetic */ AdCover(String str, String str2, String str3, List list, int i, int i2, int i3, String str4, String str5, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : list, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) != 0 ? 0 : i3, (i4 & 128) != 0 ? null : str4, (i4 & 256) == 0 ? str5 : null, (i4 & 512) == 0 ? z : false);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getNightUrl() {
        return this.nightUrl;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final List<String> getReportUrls() {
        return this.reportUrls;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final String getGifUrl() {
        return this.gifUrl;
    }

    public final String getGifCoverUrl() {
        return this.gifCoverUrl;
    }

    public final boolean getGifTagShow() {
        return this.gifTagShow;
    }
}