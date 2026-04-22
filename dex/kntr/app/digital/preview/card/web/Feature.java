package kntr.app.digital.preview.card.web;

import BottomSheetItemData$;
import com.bilibili.ogv.bpf.serialization.BooleanAsIntSerializer;
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

/* compiled from: WebCard.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 72\u00020\u0001:\u000267BV\u0012\u001b\b\u0002\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fBU\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\u001c\u0010#\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003JX\u0010)\u001a\u00020\u00002\u001b\b\u0002\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0011HÖ\u0001J\t\u0010-\u001a\u00020\tHÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R$\u0010\u0002\u001a\u00150\u0003j\u0002`\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR\u001c\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001a¨\u00068"}, d2 = {"Lkntr/app/digital/preview/card/web/Feature;", RoomRecommendViewModel.EMPTY_CURSOR, "sealed", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/Serializable;", "with", "Lkotlin/reflect/KClass;", "Lcom/bilibili/ogv/bpf/serialization/BooleanAsInt;", "icon", RoomRecommendViewModel.EMPTY_CURSOR, "title", "featureValue", "starIcon", "featureDesc", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSealed", "()Z", "getIcon$annotations", "()V", "getIcon", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "getFeatureValue$annotations", "getFeatureValue", "getStarIcon$annotations", "getStarIcon", "getFeatureDesc$annotations", "getFeatureDesc", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class Feature {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String featureDesc;
    private final String featureValue;
    private final String icon;
    private final boolean sealed;
    private final String starIcon;
    private final String title;

    public Feature() {
        this(false, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Feature copy$default(Feature feature, boolean z, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = feature.sealed;
        }
        if ((i & 2) != 0) {
            str = feature.icon;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = feature.title;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = feature.featureValue;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = feature.starIcon;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = feature.featureDesc;
        }
        return feature.copy(z, str6, str7, str8, str9, str5);
    }

    @SerialName("property_desc")
    public static /* synthetic */ void getFeatureDesc$annotations() {
    }

    @SerialName("property_value")
    public static /* synthetic */ void getFeatureValue$annotations() {
    }

    @SerialName("property_icon")
    public static /* synthetic */ void getIcon$annotations() {
    }

    @SerialName("property_level_icon")
    public static /* synthetic */ void getStarIcon$annotations() {
    }

    @SerialName("property_name")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final boolean component1() {
        return this.sealed;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.featureValue;
    }

    public final String component5() {
        return this.starIcon;
    }

    public final String component6() {
        return this.featureDesc;
    }

    public final Feature copy(boolean z, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "icon");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "featureValue");
        Intrinsics.checkNotNullParameter(str4, "starIcon");
        Intrinsics.checkNotNullParameter(str5, "featureDesc");
        return new Feature(z, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            return this.sealed == feature.sealed && Intrinsics.areEqual(this.icon, feature.icon) && Intrinsics.areEqual(this.title, feature.title) && Intrinsics.areEqual(this.featureValue, feature.featureValue) && Intrinsics.areEqual(this.starIcon, feature.starIcon) && Intrinsics.areEqual(this.featureDesc, feature.featureDesc);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.sealed) * 31) + this.icon.hashCode()) * 31) + this.title.hashCode()) * 31) + this.featureValue.hashCode()) * 31) + this.starIcon.hashCode()) * 31) + this.featureDesc.hashCode();
    }

    public String toString() {
        boolean z = this.sealed;
        String str = this.icon;
        String str2 = this.title;
        String str3 = this.featureValue;
        String str4 = this.starIcon;
        return "Feature(sealed=" + z + ", icon=" + str + ", title=" + str2 + ", featureValue=" + str3 + ", starIcon=" + str4 + ", featureDesc=" + this.featureDesc + ")";
    }

    /* compiled from: WebCard.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/card/web/Feature$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/card/web/Feature;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Feature> serializer() {
            return Feature$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Feature(int seen0, boolean sealed, String icon, String title, String featureValue, String starIcon, String featureDesc, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.sealed = false;
        } else {
            this.sealed = sealed;
        }
        if ((seen0 & 2) == 0) {
            this.icon = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 4) == 0) {
            this.title = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.title = title;
        }
        if ((seen0 & 8) == 0) {
            this.featureValue = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.featureValue = featureValue;
        }
        if ((seen0 & 16) == 0) {
            this.starIcon = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.starIcon = starIcon;
        }
        if ((seen0 & 32) == 0) {
            this.featureDesc = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.featureDesc = featureDesc;
        }
    }

    public Feature(boolean sealed, String icon, String title, String featureValue, String starIcon, String featureDesc) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(featureValue, "featureValue");
        Intrinsics.checkNotNullParameter(starIcon, "starIcon");
        Intrinsics.checkNotNullParameter(featureDesc, "featureDesc");
        this.sealed = sealed;
        this.icon = icon;
        this.title = title;
        this.featureValue = featureValue;
        this.starIcon = starIcon;
        this.featureDesc = featureDesc;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(Feature self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sealed) {
            output.encodeSerializableElement(serialDesc, 0, BooleanAsIntSerializer.INSTANCE, Boolean.valueOf(self.sealed));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.icon, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.title, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.featureValue, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.featureValue);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.starIcon, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.starIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.featureDesc, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.featureDesc);
        }
    }

    public /* synthetic */ Feature(boolean z, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i & 32) == 0 ? str5 : RoomRecommendViewModel.EMPTY_CURSOR);
    }

    public final boolean getSealed() {
        return this.sealed;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getFeatureValue() {
        return this.featureValue;
    }

    public final String getStarIcon() {
        return this.starIcon;
    }

    public final String getFeatureDesc() {
        return this.featureDesc;
    }
}