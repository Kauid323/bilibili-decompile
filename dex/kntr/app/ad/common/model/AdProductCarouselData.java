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

/* compiled from: AdProductCarouselData.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006+"}, d2 = {"Lkntr/app/ad/common/model/AdProductCarouselData;", RoomRecommendViewModel.EMPTY_CURSOR, "animeStartTime", RoomRecommendViewModel.EMPTY_CURSOR, "themeColor", RoomRecommendViewModel.EMPTY_CURSOR, "carouselImages", RoomRecommendViewModel.EMPTY_CURSOR, "guideImage", "<init>", "(JLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAnimeStartTime", "()J", "getThemeColor", "()Ljava/lang/String;", "getCarouselImages", "()Ljava/util/List;", "getGuideImage", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdProductCarouselData {
    private final long animeStartTime;
    private final List<String> carouselImages;
    private final String guideImage;
    private final String themeColor;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdProductCarouselData$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdProductCarouselData._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    public AdProductCarouselData() {
        this(0L, (String) null, (List) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdProductCarouselData copy$default(AdProductCarouselData adProductCarouselData, long j2, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = adProductCarouselData.animeStartTime;
        }
        long j3 = j2;
        if ((i & 2) != 0) {
            str = adProductCarouselData.themeColor;
        }
        String str3 = str;
        List<String> list2 = list;
        if ((i & 4) != 0) {
            list2 = adProductCarouselData.carouselImages;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            str2 = adProductCarouselData.guideImage;
        }
        return adProductCarouselData.copy(j3, str3, list3, str2);
    }

    public final long component1() {
        return this.animeStartTime;
    }

    public final String component2() {
        return this.themeColor;
    }

    public final List<String> component3() {
        return this.carouselImages;
    }

    public final String component4() {
        return this.guideImage;
    }

    public final AdProductCarouselData copy(long j2, String str, List<String> list, String str2) {
        return new AdProductCarouselData(j2, str, list, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdProductCarouselData) {
            AdProductCarouselData adProductCarouselData = (AdProductCarouselData) obj;
            return this.animeStartTime == adProductCarouselData.animeStartTime && Intrinsics.areEqual(this.themeColor, adProductCarouselData.themeColor) && Intrinsics.areEqual(this.carouselImages, adProductCarouselData.carouselImages) && Intrinsics.areEqual(this.guideImage, adProductCarouselData.guideImage);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.animeStartTime) * 31) + (this.themeColor == null ? 0 : this.themeColor.hashCode())) * 31) + (this.carouselImages == null ? 0 : this.carouselImages.hashCode())) * 31) + (this.guideImage != null ? this.guideImage.hashCode() : 0);
    }

    public String toString() {
        long j2 = this.animeStartTime;
        String str = this.themeColor;
        List<String> list = this.carouselImages;
        return "AdProductCarouselData(animeStartTime=" + j2 + ", themeColor=" + str + ", carouselImages=" + list + ", guideImage=" + this.guideImage + ")";
    }

    /* compiled from: AdProductCarouselData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdProductCarouselData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdProductCarouselData;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdProductCarouselData> serializer() {
            return AdProductCarouselData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdProductCarouselData(int seen0, long animeStartTime, String themeColor, List carouselImages, String guideImage, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.animeStartTime = 0L;
        } else {
            this.animeStartTime = animeStartTime;
        }
        if ((seen0 & 2) == 0) {
            this.themeColor = null;
        } else {
            this.themeColor = themeColor;
        }
        if ((seen0 & 4) == 0) {
            this.carouselImages = null;
        } else {
            this.carouselImages = carouselImages;
        }
        if ((seen0 & 8) == 0) {
            this.guideImage = null;
        } else {
            this.guideImage = guideImage;
        }
    }

    public AdProductCarouselData(long animeStartTime, String themeColor, List<String> list, String guideImage) {
        this.animeStartTime = animeStartTime;
        this.themeColor = themeColor;
        this.carouselImages = list;
        this.guideImage = guideImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdProductCarouselData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.animeStartTime != 0) {
            output.encodeLongElement(serialDesc, 0, self.animeStartTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.themeColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.themeColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.carouselImages != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.carouselImages);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.guideImage != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.guideImage);
        }
    }

    public /* synthetic */ AdProductCarouselData(long j2, String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str2);
    }

    public final long getAnimeStartTime() {
        return this.animeStartTime;
    }

    public final String getThemeColor() {
        return this.themeColor;
    }

    public final List<String> getCarouselImages() {
        return this.carouselImages;
    }

    public final String getGuideImage() {
        return this.guideImage;
    }
}