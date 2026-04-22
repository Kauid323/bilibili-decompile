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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdQualityInfo.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@AB\u009b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013B\u0097\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\u009d\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00104\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0011HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u001b\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006B"}, d2 = {"Lkntr/app/ad/common/model/AdQualityInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "icon", RoomRecommendViewModel.EMPTY_CURSOR, "text", "isBg", RoomRecommendViewModel.EMPTY_CURSOR, "bgColor", "bgColorNight", "textColor", "textColorNight", "userFaces", RoomRecommendViewModel.EMPTY_CURSOR, "iconNight", "borderColor", "borderColorNight", "bgStyle", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIcon", "()Ljava/lang/String;", "getText", "()Z", "getBgColor", "getBgColorNight", "getTextColor", "getTextColorNight", "getUserFaces", "()Ljava/util/List;", "getIconNight", "getBorderColor", "getBorderColorNight", "getBgStyle", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdQualityInfo {
    private final String bgColor;
    private final String bgColorNight;
    private final int bgStyle;
    private final String borderColor;
    private final String borderColorNight;
    private final String icon;
    private final String iconNight;
    private final boolean isBg;
    private final String text;
    private final String textColor;
    private final String textColorNight;
    private final List<String> userFaces;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdQualityInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdQualityInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null};

    public AdQualityInfo() {
        this((String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, 0, 4095, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component10() {
        return this.borderColor;
    }

    public final String component11() {
        return this.borderColorNight;
    }

    public final int component12() {
        return this.bgStyle;
    }

    public final String component2() {
        return this.text;
    }

    public final boolean component3() {
        return this.isBg;
    }

    public final String component4() {
        return this.bgColor;
    }

    public final String component5() {
        return this.bgColorNight;
    }

    public final String component6() {
        return this.textColor;
    }

    public final String component7() {
        return this.textColorNight;
    }

    public final List<String> component8() {
        return this.userFaces;
    }

    public final String component9() {
        return this.iconNight;
    }

    public final AdQualityInfo copy(String str, String str2, boolean z, String str3, String str4, String str5, String str6, List<String> list, String str7, String str8, String str9, int i) {
        return new AdQualityInfo(str, str2, z, str3, str4, str5, str6, list, str7, str8, str9, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdQualityInfo) {
            AdQualityInfo adQualityInfo = (AdQualityInfo) obj;
            return Intrinsics.areEqual(this.icon, adQualityInfo.icon) && Intrinsics.areEqual(this.text, adQualityInfo.text) && this.isBg == adQualityInfo.isBg && Intrinsics.areEqual(this.bgColor, adQualityInfo.bgColor) && Intrinsics.areEqual(this.bgColorNight, adQualityInfo.bgColorNight) && Intrinsics.areEqual(this.textColor, adQualityInfo.textColor) && Intrinsics.areEqual(this.textColorNight, adQualityInfo.textColorNight) && Intrinsics.areEqual(this.userFaces, adQualityInfo.userFaces) && Intrinsics.areEqual(this.iconNight, adQualityInfo.iconNight) && Intrinsics.areEqual(this.borderColor, adQualityInfo.borderColor) && Intrinsics.areEqual(this.borderColorNight, adQualityInfo.borderColorNight) && this.bgStyle == adQualityInfo.bgStyle;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((this.icon == null ? 0 : this.icon.hashCode()) * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isBg)) * 31) + (this.bgColor == null ? 0 : this.bgColor.hashCode())) * 31) + (this.bgColorNight == null ? 0 : this.bgColorNight.hashCode())) * 31) + (this.textColor == null ? 0 : this.textColor.hashCode())) * 31) + (this.textColorNight == null ? 0 : this.textColorNight.hashCode())) * 31) + (this.userFaces == null ? 0 : this.userFaces.hashCode())) * 31) + (this.iconNight == null ? 0 : this.iconNight.hashCode())) * 31) + (this.borderColor == null ? 0 : this.borderColor.hashCode())) * 31) + (this.borderColorNight != null ? this.borderColorNight.hashCode() : 0)) * 31) + this.bgStyle;
    }

    public String toString() {
        String str = this.icon;
        String str2 = this.text;
        boolean z = this.isBg;
        String str3 = this.bgColor;
        String str4 = this.bgColorNight;
        String str5 = this.textColor;
        String str6 = this.textColorNight;
        List<String> list = this.userFaces;
        String str7 = this.iconNight;
        String str8 = this.borderColor;
        String str9 = this.borderColorNight;
        return "AdQualityInfo(icon=" + str + ", text=" + str2 + ", isBg=" + z + ", bgColor=" + str3 + ", bgColorNight=" + str4 + ", textColor=" + str5 + ", textColorNight=" + str6 + ", userFaces=" + list + ", iconNight=" + str7 + ", borderColor=" + str8 + ", borderColorNight=" + str9 + ", bgStyle=" + this.bgStyle + ")";
    }

    /* compiled from: AdQualityInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdQualityInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdQualityInfo;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdQualityInfo> serializer() {
            return AdQualityInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdQualityInfo(int seen0, String icon, String text, boolean isBg, String bgColor, String bgColorNight, String textColor, String textColorNight, List userFaces, String iconNight, String borderColor, String borderColorNight, int bgStyle, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.icon = null;
        } else {
            this.icon = icon;
        }
        if ((seen0 & 2) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
        if ((seen0 & 4) == 0) {
            this.isBg = false;
        } else {
            this.isBg = isBg;
        }
        if ((seen0 & 8) == 0) {
            this.bgColor = null;
        } else {
            this.bgColor = bgColor;
        }
        if ((seen0 & 16) == 0) {
            this.bgColorNight = null;
        } else {
            this.bgColorNight = bgColorNight;
        }
        if ((seen0 & 32) == 0) {
            this.textColor = null;
        } else {
            this.textColor = textColor;
        }
        if ((seen0 & 64) == 0) {
            this.textColorNight = null;
        } else {
            this.textColorNight = textColorNight;
        }
        if ((seen0 & 128) == 0) {
            this.userFaces = null;
        } else {
            this.userFaces = userFaces;
        }
        if ((seen0 & 256) == 0) {
            this.iconNight = null;
        } else {
            this.iconNight = iconNight;
        }
        if ((seen0 & 512) == 0) {
            this.borderColor = null;
        } else {
            this.borderColor = borderColor;
        }
        if ((seen0 & 1024) == 0) {
            this.borderColorNight = null;
        } else {
            this.borderColorNight = borderColorNight;
        }
        if ((seen0 & 2048) == 0) {
            this.bgStyle = 0;
        } else {
            this.bgStyle = bgStyle;
        }
    }

    public AdQualityInfo(String icon, String text, boolean isBg, String bgColor, String bgColorNight, String textColor, String textColorNight, List<String> list, String iconNight, String borderColor, String borderColorNight, int bgStyle) {
        this.icon = icon;
        this.text = text;
        this.isBg = isBg;
        this.bgColor = bgColor;
        this.bgColorNight = bgColorNight;
        this.textColor = textColor;
        this.textColorNight = textColorNight;
        this.userFaces = list;
        this.iconNight = iconNight;
        this.borderColor = borderColor;
        this.borderColorNight = borderColorNight;
        this.bgStyle = bgStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdQualityInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isBg) {
            output.encodeBooleanElement(serialDesc, 2, self.isBg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.bgColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.bgColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.bgColorNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.bgColorNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.textColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.textColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.textColorNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.textColorNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.userFaces != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.userFaces);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.iconNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.iconNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.borderColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.borderColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.borderColorNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.borderColorNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.bgStyle != 0) {
            output.encodeIntElement(serialDesc, 11, self.bgStyle);
        }
    }

    public /* synthetic */ AdQualityInfo(String str, String str2, boolean z, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : list, (i2 & 256) != 0 ? null : str7, (i2 & 512) != 0 ? null : str8, (i2 & 1024) == 0 ? str9 : null, (i2 & 2048) == 0 ? i : 0);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isBg() {
        return this.isBg;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getBgColorNight() {
        return this.bgColorNight;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getTextColorNight() {
        return this.textColorNight;
    }

    public final List<String> getUserFaces() {
        return this.userFaces;
    }

    public final String getIconNight() {
        return this.iconNight;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final String getBorderColorNight() {
        return this.borderColorNight;
    }

    public final int getBgStyle() {
        return this.bgStyle;
    }
}