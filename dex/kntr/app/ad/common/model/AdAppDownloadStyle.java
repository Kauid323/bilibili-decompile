package kntr.app.ad.common.model;

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

/* compiled from: AdAppDownloadStyle.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rBu\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jq\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R&\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0015R&\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017¨\u00066"}, d2 = {"Lkntr/app/ad/common/model/AdAppDownloadStyle;", RoomRecommendViewModel.EMPTY_CURSOR, "style", RoomRecommendViewModel.EMPTY_CURSOR, "tags", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "guideText", "headImgList", "detailImageList", "detailImageLayout", "detailText", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStyle", "()I", "getTags", "()Ljava/util/List;", "getGuideText", "()Ljava/lang/String;", "getHeadImgList$annotations", "()V", "getHeadImgList", "getDetailImageList$annotations", "getDetailImageList", "getDetailImageLayout", "getDetailText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdAppDownloadStyle {
    private final int detailImageLayout;
    private final List<String> detailImageList;
    private final String detailText;
    private final String guideText;
    private final List<String> headImgList;
    private final int style;
    private final List<String> tags;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdAppDownloadStyle$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdAppDownloadStyle._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdAppDownloadStyle$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = AdAppDownloadStyle._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdAppDownloadStyle$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = AdAppDownloadStyle._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null, null};

    public AdAppDownloadStyle() {
        this(0, (List) null, (String) null, (List) null, (List) null, 0, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdAppDownloadStyle copy$default(AdAppDownloadStyle adAppDownloadStyle, int i, List list, String str, List list2, List list3, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = adAppDownloadStyle.style;
        }
        List<String> list4 = list;
        if ((i3 & 2) != 0) {
            list4 = adAppDownloadStyle.tags;
        }
        List list5 = list4;
        if ((i3 & 4) != 0) {
            str = adAppDownloadStyle.guideText;
        }
        String str3 = str;
        List<String> list6 = list2;
        if ((i3 & 8) != 0) {
            list6 = adAppDownloadStyle.headImgList;
        }
        List list7 = list6;
        List<String> list8 = list3;
        if ((i3 & 16) != 0) {
            list8 = adAppDownloadStyle.detailImageList;
        }
        List list9 = list8;
        if ((i3 & 32) != 0) {
            i2 = adAppDownloadStyle.detailImageLayout;
        }
        int i4 = i2;
        if ((i3 & 64) != 0) {
            str2 = adAppDownloadStyle.detailText;
        }
        return adAppDownloadStyle.copy(i, list5, str3, list7, list9, i4, str2);
    }

    @SerialName("detail_imgs")
    public static /* synthetic */ void getDetailImageList$annotations() {
    }

    @SerialName("head_imgs")
    public static /* synthetic */ void getHeadImgList$annotations() {
    }

    public final int component1() {
        return this.style;
    }

    public final List<String> component2() {
        return this.tags;
    }

    public final String component3() {
        return this.guideText;
    }

    public final List<String> component4() {
        return this.headImgList;
    }

    public final List<String> component5() {
        return this.detailImageList;
    }

    public final int component6() {
        return this.detailImageLayout;
    }

    public final String component7() {
        return this.detailText;
    }

    public final AdAppDownloadStyle copy(int i, List<String> list, String str, List<String> list2, List<String> list3, int i2, String str2) {
        return new AdAppDownloadStyle(i, list, str, list2, list3, i2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdAppDownloadStyle) {
            AdAppDownloadStyle adAppDownloadStyle = (AdAppDownloadStyle) obj;
            return this.style == adAppDownloadStyle.style && Intrinsics.areEqual(this.tags, adAppDownloadStyle.tags) && Intrinsics.areEqual(this.guideText, adAppDownloadStyle.guideText) && Intrinsics.areEqual(this.headImgList, adAppDownloadStyle.headImgList) && Intrinsics.areEqual(this.detailImageList, adAppDownloadStyle.detailImageList) && this.detailImageLayout == adAppDownloadStyle.detailImageLayout && Intrinsics.areEqual(this.detailText, adAppDownloadStyle.detailText);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.style * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.guideText == null ? 0 : this.guideText.hashCode())) * 31) + (this.headImgList == null ? 0 : this.headImgList.hashCode())) * 31) + (this.detailImageList == null ? 0 : this.detailImageList.hashCode())) * 31) + this.detailImageLayout) * 31) + (this.detailText != null ? this.detailText.hashCode() : 0);
    }

    public String toString() {
        int i = this.style;
        List<String> list = this.tags;
        String str = this.guideText;
        List<String> list2 = this.headImgList;
        List<String> list3 = this.detailImageList;
        int i2 = this.detailImageLayout;
        return "AdAppDownloadStyle(style=" + i + ", tags=" + list + ", guideText=" + str + ", headImgList=" + list2 + ", detailImageList=" + list3 + ", detailImageLayout=" + i2 + ", detailText=" + this.detailText + ")";
    }

    /* compiled from: AdAppDownloadStyle.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdAppDownloadStyle$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdAppDownloadStyle;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdAppDownloadStyle> serializer() {
            return AdAppDownloadStyle$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdAppDownloadStyle(int seen0, int style, List tags, String guideText, List headImgList, List detailImageList, int detailImageLayout, String detailText, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.style = 0;
        } else {
            this.style = style;
        }
        if ((seen0 & 2) == 0) {
            this.tags = null;
        } else {
            this.tags = tags;
        }
        if ((seen0 & 4) == 0) {
            this.guideText = null;
        } else {
            this.guideText = guideText;
        }
        if ((seen0 & 8) == 0) {
            this.headImgList = null;
        } else {
            this.headImgList = headImgList;
        }
        if ((seen0 & 16) == 0) {
            this.detailImageList = null;
        } else {
            this.detailImageList = detailImageList;
        }
        if ((seen0 & 32) == 0) {
            this.detailImageLayout = 0;
        } else {
            this.detailImageLayout = detailImageLayout;
        }
        if ((seen0 & 64) == 0) {
            this.detailText = null;
        } else {
            this.detailText = detailText;
        }
    }

    public AdAppDownloadStyle(int style, List<String> list, String guideText, List<String> list2, List<String> list3, int detailImageLayout, String detailText) {
        this.style = style;
        this.tags = list;
        this.guideText = guideText;
        this.headImgList = list2;
        this.detailImageList = list3;
        this.detailImageLayout = detailImageLayout;
        this.detailText = detailText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdAppDownloadStyle self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.style != 0) {
            output.encodeIntElement(serialDesc, 0, self.style);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.tags != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.tags);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.guideText != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.guideText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.headImgList != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.headImgList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.detailImageList != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.detailImageList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.detailImageLayout != 0) {
            output.encodeIntElement(serialDesc, 5, self.detailImageLayout);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.detailText != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.detailText);
        }
    }

    public /* synthetic */ AdAppDownloadStyle(int i, List list, String str, List list2, List list3, int i2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : list, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : list2, (i3 & 16) != 0 ? null : list3, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? null : str2);
    }

    public final int getStyle() {
        return this.style;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getGuideText() {
        return this.guideText;
    }

    public final List<String> getHeadImgList() {
        return this.headImgList;
    }

    public final List<String> getDetailImageList() {
        return this.detailImageList;
    }

    public final int getDetailImageLayout() {
        return this.detailImageLayout;
    }

    public final String getDetailText() {
        return this.detailText;
    }
}