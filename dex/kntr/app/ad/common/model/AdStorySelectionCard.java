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

/* compiled from: AdStoryStyleSelection.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bq\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jo\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001b\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00069"}, d2 = {"Lkntr/app/ad/common/model/AdStorySelectionCard;", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "icon", RoomRecommendViewModel.EMPTY_CURSOR, "title", "desc", "starRating", "rankStars", "qualityInfos", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdQualityInfo;", "button", "Lkntr/app/ad/common/model/AdButton;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkntr/app/ad/common/model/AdButton;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkntr/app/ad/common/model/AdButton;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()I", "getIcon", "()Ljava/lang/String;", "getTitle", "getDesc", "getStarRating", "getRankStars", "getQualityInfos", "()Ljava/util/List;", "getButton", "()Lkntr/app/ad/common/model/AdButton;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdStorySelectionCard {
    private final AdButton button;
    private final String desc;
    private final String icon;
    private final List<AdQualityInfo> qualityInfos;
    private final String rankStars;
    private final String starRating;
    private final String title;
    private final int type;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdStorySelectionCard$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdStorySelectionCard._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    public AdStorySelectionCard() {
        this(0, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (AdButton) null, 255, (DefaultConstructorMarker) null);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.desc;
    }

    public final String component5() {
        return this.starRating;
    }

    public final String component6() {
        return this.rankStars;
    }

    public final List<AdQualityInfo> component7() {
        return this.qualityInfos;
    }

    public final AdButton component8() {
        return this.button;
    }

    public final AdStorySelectionCard copy(int i, String str, String str2, String str3, String str4, String str5, List<AdQualityInfo> list, AdButton adButton) {
        return new AdStorySelectionCard(i, str, str2, str3, str4, str5, list, adButton);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdStorySelectionCard) {
            AdStorySelectionCard adStorySelectionCard = (AdStorySelectionCard) obj;
            return this.type == adStorySelectionCard.type && Intrinsics.areEqual(this.icon, adStorySelectionCard.icon) && Intrinsics.areEqual(this.title, adStorySelectionCard.title) && Intrinsics.areEqual(this.desc, adStorySelectionCard.desc) && Intrinsics.areEqual(this.starRating, adStorySelectionCard.starRating) && Intrinsics.areEqual(this.rankStars, adStorySelectionCard.rankStars) && Intrinsics.areEqual(this.qualityInfos, adStorySelectionCard.qualityInfos) && Intrinsics.areEqual(this.button, adStorySelectionCard.button);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.type * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.starRating == null ? 0 : this.starRating.hashCode())) * 31) + (this.rankStars == null ? 0 : this.rankStars.hashCode())) * 31) + (this.qualityInfos == null ? 0 : this.qualityInfos.hashCode())) * 31) + (this.button != null ? this.button.hashCode() : 0);
    }

    public String toString() {
        int i = this.type;
        String str = this.icon;
        String str2 = this.title;
        String str3 = this.desc;
        String str4 = this.starRating;
        String str5 = this.rankStars;
        List<AdQualityInfo> list = this.qualityInfos;
        return "AdStorySelectionCard(type=" + i + ", icon=" + str + ", title=" + str2 + ", desc=" + str3 + ", starRating=" + str4 + ", rankStars=" + str5 + ", qualityInfos=" + list + ", button=" + this.button + ")";
    }

    /* compiled from: AdStoryStyleSelection.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdStorySelectionCard$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdStorySelectionCard;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdStorySelectionCard> serializer() {
            return AdStorySelectionCard$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdStorySelectionCard(int seen0, int type, String icon, String title, String desc, String starRating, String rankStars, List qualityInfos, AdButton button, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.type = 0;
        } else {
            this.type = type;
        }
        if ((seen0 & 2) == 0) {
            this.icon = null;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 4) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 8) == 0) {
            this.desc = null;
        } else {
            this.desc = desc;
        }
        if ((seen0 & 16) == 0) {
            this.starRating = null;
        } else {
            this.starRating = starRating;
        }
        if ((seen0 & 32) == 0) {
            this.rankStars = null;
        } else {
            this.rankStars = rankStars;
        }
        if ((seen0 & 64) == 0) {
            this.qualityInfos = null;
        } else {
            this.qualityInfos = qualityInfos;
        }
        if ((seen0 & 128) == 0) {
            this.button = null;
        } else {
            this.button = button;
        }
    }

    public AdStorySelectionCard(int type, String icon, String title, String desc, String starRating, String rankStars, List<AdQualityInfo> list, AdButton button) {
        this.type = type;
        this.icon = icon;
        this.title = title;
        this.desc = desc;
        this.starRating = starRating;
        this.rankStars = rankStars;
        this.qualityInfos = list;
        this.button = button;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdQualityInfo$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdStorySelectionCard self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != 0) {
            output.encodeIntElement(serialDesc, 0, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.desc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.starRating != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.starRating);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.rankStars != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.rankStars);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.qualityInfos != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.qualityInfos);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.button != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, AdButton$$serializer.INSTANCE, self.button);
        }
    }

    public /* synthetic */ AdStorySelectionCard(int i, String str, String str2, String str3, String str4, String str5, List list, AdButton adButton, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : list, (i2 & 128) == 0 ? adButton : null);
    }

    public final int getType() {
        return this.type;
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

    public final String getStarRating() {
        return this.starRating;
    }

    public final String getRankStars() {
        return this.rankStars;
    }

    public final List<AdQualityInfo> getQualityInfos() {
        return this.qualityInfos;
    }

    public final AdButton getButton() {
        return this.button;
    }
}