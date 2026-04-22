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

/* compiled from: AdComboClickParams.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eBq\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jo\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001b\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u00066"}, d2 = {"Lkntr/app/ad/common/model/AdComboClickParams;", RoomRecommendViewModel.EMPTY_CURSOR, "btnAnimType", RoomRecommendViewModel.EMPTY_CURSOR, "btnAnimUrl", RoomRecommendViewModel.EMPTY_CURSOR, "btnIcon", "btnText", "dmContents", RoomRecommendViewModel.EMPTY_CURSOR, "dmBgColor", "dmTextColor", "dmLeaderIcon", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBtnAnimType", "()I", "getBtnAnimUrl", "()Ljava/lang/String;", "getBtnIcon", "getBtnText", "getDmContents", "()Ljava/util/List;", "getDmBgColor", "getDmTextColor", "getDmLeaderIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdComboClickParams {
    private final int btnAnimType;
    private final String btnAnimUrl;
    private final String btnIcon;
    private final String btnText;
    private final String dmBgColor;
    private final List<String> dmContents;
    private final String dmLeaderIcon;
    private final String dmTextColor;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdComboClickParams$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdComboClickParams._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null};

    public AdComboClickParams() {
        this(0, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public final int component1() {
        return this.btnAnimType;
    }

    public final String component2() {
        return this.btnAnimUrl;
    }

    public final String component3() {
        return this.btnIcon;
    }

    public final String component4() {
        return this.btnText;
    }

    public final List<String> component5() {
        return this.dmContents;
    }

    public final String component6() {
        return this.dmBgColor;
    }

    public final String component7() {
        return this.dmTextColor;
    }

    public final String component8() {
        return this.dmLeaderIcon;
    }

    public final AdComboClickParams copy(int i, String str, String str2, String str3, List<String> list, String str4, String str5, String str6) {
        return new AdComboClickParams(i, str, str2, str3, list, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdComboClickParams) {
            AdComboClickParams adComboClickParams = (AdComboClickParams) obj;
            return this.btnAnimType == adComboClickParams.btnAnimType && Intrinsics.areEqual(this.btnAnimUrl, adComboClickParams.btnAnimUrl) && Intrinsics.areEqual(this.btnIcon, adComboClickParams.btnIcon) && Intrinsics.areEqual(this.btnText, adComboClickParams.btnText) && Intrinsics.areEqual(this.dmContents, adComboClickParams.dmContents) && Intrinsics.areEqual(this.dmBgColor, adComboClickParams.dmBgColor) && Intrinsics.areEqual(this.dmTextColor, adComboClickParams.dmTextColor) && Intrinsics.areEqual(this.dmLeaderIcon, adComboClickParams.dmLeaderIcon);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.btnAnimType * 31) + (this.btnAnimUrl == null ? 0 : this.btnAnimUrl.hashCode())) * 31) + (this.btnIcon == null ? 0 : this.btnIcon.hashCode())) * 31) + (this.btnText == null ? 0 : this.btnText.hashCode())) * 31) + (this.dmContents == null ? 0 : this.dmContents.hashCode())) * 31) + (this.dmBgColor == null ? 0 : this.dmBgColor.hashCode())) * 31) + (this.dmTextColor == null ? 0 : this.dmTextColor.hashCode())) * 31) + (this.dmLeaderIcon != null ? this.dmLeaderIcon.hashCode() : 0);
    }

    public String toString() {
        int i = this.btnAnimType;
        String str = this.btnAnimUrl;
        String str2 = this.btnIcon;
        String str3 = this.btnText;
        List<String> list = this.dmContents;
        String str4 = this.dmBgColor;
        String str5 = this.dmTextColor;
        return "AdComboClickParams(btnAnimType=" + i + ", btnAnimUrl=" + str + ", btnIcon=" + str2 + ", btnText=" + str3 + ", dmContents=" + list + ", dmBgColor=" + str4 + ", dmTextColor=" + str5 + ", dmLeaderIcon=" + this.dmLeaderIcon + ")";
    }

    /* compiled from: AdComboClickParams.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdComboClickParams$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdComboClickParams;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdComboClickParams> serializer() {
            return AdComboClickParams$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdComboClickParams(int seen0, int btnAnimType, String btnAnimUrl, String btnIcon, String btnText, List dmContents, String dmBgColor, String dmTextColor, String dmLeaderIcon, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.btnAnimType = 0;
        } else {
            this.btnAnimType = btnAnimType;
        }
        if ((seen0 & 2) == 0) {
            this.btnAnimUrl = null;
        } else {
            this.btnAnimUrl = btnAnimUrl;
        }
        if ((seen0 & 4) == 0) {
            this.btnIcon = null;
        } else {
            this.btnIcon = btnIcon;
        }
        if ((seen0 & 8) == 0) {
            this.btnText = null;
        } else {
            this.btnText = btnText;
        }
        if ((seen0 & 16) == 0) {
            this.dmContents = null;
        } else {
            this.dmContents = dmContents;
        }
        if ((seen0 & 32) == 0) {
            this.dmBgColor = null;
        } else {
            this.dmBgColor = dmBgColor;
        }
        if ((seen0 & 64) == 0) {
            this.dmTextColor = null;
        } else {
            this.dmTextColor = dmTextColor;
        }
        if ((seen0 & 128) == 0) {
            this.dmLeaderIcon = null;
        } else {
            this.dmLeaderIcon = dmLeaderIcon;
        }
    }

    public AdComboClickParams(int btnAnimType, String btnAnimUrl, String btnIcon, String btnText, List<String> list, String dmBgColor, String dmTextColor, String dmLeaderIcon) {
        this.btnAnimType = btnAnimType;
        this.btnAnimUrl = btnAnimUrl;
        this.btnIcon = btnIcon;
        this.btnText = btnText;
        this.dmContents = list;
        this.dmBgColor = dmBgColor;
        this.dmTextColor = dmTextColor;
        this.dmLeaderIcon = dmLeaderIcon;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdComboClickParams self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.btnAnimType != 0) {
            output.encodeIntElement(serialDesc, 0, self.btnAnimType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.btnAnimUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.btnAnimUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.btnIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.btnIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.btnText != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.btnText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.dmContents != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.dmContents);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.dmBgColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.dmBgColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.dmTextColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.dmTextColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.dmLeaderIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.dmLeaderIcon);
        }
    }

    public /* synthetic */ AdComboClickParams(int i, String str, String str2, String str3, List list, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : list, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) == 0 ? str6 : null);
    }

    public final int getBtnAnimType() {
        return this.btnAnimType;
    }

    public final String getBtnAnimUrl() {
        return this.btnAnimUrl;
    }

    public final String getBtnIcon() {
        return this.btnIcon;
    }

    public final String getBtnText() {
        return this.btnText;
    }

    public final List<String> getDmContents() {
        return this.dmContents;
    }

    public final String getDmBgColor() {
        return this.dmBgColor;
    }

    public final String getDmTextColor() {
        return this.dmTextColor;
    }

    public final String getDmLeaderIcon() {
        return this.dmLeaderIcon;
    }
}