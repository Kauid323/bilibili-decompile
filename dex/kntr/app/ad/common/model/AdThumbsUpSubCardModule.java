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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdThumbsUpSubCardModule.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fBs\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0011HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u00068"}, d2 = {"Lkntr/app/ad/common/model/AdThumbsUpSubCardModule;", RoomRecommendViewModel.EMPTY_CURSOR, "icon", RoomRecommendViewModel.EMPTY_CURSOR, "title", "desc", "rankStars", "button", "Lkntr/app/ad/common/model/AdButton;", "qualityInfos", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdQualityInfo;", "subDesc", "starRating", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdButton;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdButton;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIcon", "()Ljava/lang/String;", "getTitle", "getDesc", "getRankStars", "getButton", "()Lkntr/app/ad/common/model/AdButton;", "getQualityInfos", "()Ljava/util/List;", "getSubDesc", "getStarRating", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdThumbsUpSubCardModule {
    private final AdButton button;
    private final String desc;
    private final String icon;
    private final List<AdQualityInfo> qualityInfos;
    private final String rankStars;
    private final String starRating;
    private final String subDesc;
    private final String title;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdThumbsUpSubCardModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdThumbsUpSubCardModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};

    public AdThumbsUpSubCardModule() {
        this((String) null, (String) null, (String) null, (String) null, (AdButton) null, (List) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.rankStars;
    }

    public final AdButton component5() {
        return this.button;
    }

    public final List<AdQualityInfo> component6() {
        return this.qualityInfos;
    }

    public final String component7() {
        return this.subDesc;
    }

    public final String component8() {
        return this.starRating;
    }

    public final AdThumbsUpSubCardModule copy(String str, String str2, String str3, String str4, AdButton adButton, List<AdQualityInfo> list, String str5, String str6) {
        return new AdThumbsUpSubCardModule(str, str2, str3, str4, adButton, list, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdThumbsUpSubCardModule) {
            AdThumbsUpSubCardModule adThumbsUpSubCardModule = (AdThumbsUpSubCardModule) obj;
            return Intrinsics.areEqual(this.icon, adThumbsUpSubCardModule.icon) && Intrinsics.areEqual(this.title, adThumbsUpSubCardModule.title) && Intrinsics.areEqual(this.desc, adThumbsUpSubCardModule.desc) && Intrinsics.areEqual(this.rankStars, adThumbsUpSubCardModule.rankStars) && Intrinsics.areEqual(this.button, adThumbsUpSubCardModule.button) && Intrinsics.areEqual(this.qualityInfos, adThumbsUpSubCardModule.qualityInfos) && Intrinsics.areEqual(this.subDesc, adThumbsUpSubCardModule.subDesc) && Intrinsics.areEqual(this.starRating, adThumbsUpSubCardModule.starRating);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.icon == null ? 0 : this.icon.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.rankStars == null ? 0 : this.rankStars.hashCode())) * 31) + (this.button == null ? 0 : this.button.hashCode())) * 31) + (this.qualityInfos == null ? 0 : this.qualityInfos.hashCode())) * 31) + (this.subDesc == null ? 0 : this.subDesc.hashCode())) * 31) + (this.starRating != null ? this.starRating.hashCode() : 0);
    }

    public String toString() {
        String str = this.icon;
        String str2 = this.title;
        String str3 = this.desc;
        String str4 = this.rankStars;
        AdButton adButton = this.button;
        List<AdQualityInfo> list = this.qualityInfos;
        String str5 = this.subDesc;
        return "AdThumbsUpSubCardModule(icon=" + str + ", title=" + str2 + ", desc=" + str3 + ", rankStars=" + str4 + ", button=" + adButton + ", qualityInfos=" + list + ", subDesc=" + str5 + ", starRating=" + this.starRating + ")";
    }

    /* compiled from: AdThumbsUpSubCardModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdThumbsUpSubCardModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdThumbsUpSubCardModule;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdThumbsUpSubCardModule> serializer() {
            return AdThumbsUpSubCardModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdThumbsUpSubCardModule(int seen0, String icon, String title, String desc, String rankStars, AdButton button, List qualityInfos, String subDesc, String starRating, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.icon = null;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 2) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 4) == 0) {
            this.desc = null;
        } else {
            this.desc = desc;
        }
        if ((seen0 & 8) == 0) {
            this.rankStars = null;
        } else {
            this.rankStars = rankStars;
        }
        if ((seen0 & 16) == 0) {
            this.button = null;
        } else {
            this.button = button;
        }
        if ((seen0 & 32) == 0) {
            this.qualityInfos = null;
        } else {
            this.qualityInfos = qualityInfos;
        }
        if ((seen0 & 64) == 0) {
            this.subDesc = null;
        } else {
            this.subDesc = subDesc;
        }
        if ((seen0 & 128) == 0) {
            this.starRating = null;
        } else {
            this.starRating = starRating;
        }
    }

    public AdThumbsUpSubCardModule(String icon, String title, String desc, String rankStars, AdButton button, List<AdQualityInfo> list, String subDesc, String starRating) {
        this.icon = icon;
        this.title = title;
        this.desc = desc;
        this.rankStars = rankStars;
        this.button = button;
        this.qualityInfos = list;
        this.subDesc = subDesc;
        this.starRating = starRating;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdQualityInfo$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdThumbsUpSubCardModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.desc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.rankStars != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.rankStars);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.button != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, AdButton$$serializer.INSTANCE, self.button);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.qualityInfos != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.qualityInfos);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.subDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.subDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.starRating != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.starRating);
        }
    }

    public /* synthetic */ AdThumbsUpSubCardModule(String str, String str2, String str3, String str4, AdButton adButton, List list, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : adButton, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str5, (i & 128) == 0 ? str6 : null);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getRankStars() {
        return this.rankStars;
    }

    public final AdButton getButton() {
        return this.button;
    }

    public final List<AdQualityInfo> getQualityInfos() {
        return this.qualityInfos;
    }

    public final String getSubDesc() {
        return this.subDesc;
    }

    public final String getStarRating() {
        return this.starRating;
    }
}