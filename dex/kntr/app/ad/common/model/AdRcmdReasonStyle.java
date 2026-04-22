package kntr.app.ad.common.model;

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

/* compiled from: AdRcmdReasonStyle.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 T2\u00020\u0001:\u0002STBá\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018BÏ\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\rHÆ\u0003J\t\u0010<\u001a\u00020\rHÆ\u0003J\t\u0010=\u001a\u00020\rHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jã\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\rHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001J%\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0001¢\u0006\u0002\bRR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001e¨\u0006U"}, d2 = {"Lkntr/app/ad/common/model/AdRcmdReasonStyle;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "textColor", "textColorNight", "borderColor", "borderColorNight", "bgColor", "bgColorNight", "iconUrl", "iconNightUrl", "iconWidth", RoomRecommendViewModel.EMPTY_CURSOR, "iconHeight", "rightIconType", "iconBgUrl", "textLen", "bgStyle", "uri", "event", "eventV2", "leftIconType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getTextColor", "getTextColorNight", "getBorderColor", "getBorderColorNight", "getBgColor", "getBgColorNight", "getIconUrl", "getIconNightUrl", "getIconWidth", "()I", "getIconHeight", "getRightIconType", "getIconBgUrl", "getTextLen", "getBgStyle", "getUri", "getEvent", "getEventV2", "getLeftIconType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdRcmdReasonStyle {
    public static final Companion Companion = new Companion(null);
    private final String bgColor;
    private final String bgColorNight;
    private final int bgStyle;
    private final String borderColor;
    private final String borderColorNight;
    private final String event;
    private final String eventV2;
    private final String iconBgUrl;
    private final int iconHeight;
    private final String iconNightUrl;
    private final String iconUrl;
    private final int iconWidth;
    private final String leftIconType;
    private final int rightIconType;
    private final String text;
    private final String textColor;
    private final String textColorNight;
    private final int textLen;
    private final String uri;

    public AdRcmdReasonStyle() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 524287, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.text;
    }

    public final int component10() {
        return this.iconWidth;
    }

    public final int component11() {
        return this.iconHeight;
    }

    public final int component12() {
        return this.rightIconType;
    }

    public final String component13() {
        return this.iconBgUrl;
    }

    public final int component14() {
        return this.textLen;
    }

    public final int component15() {
        return this.bgStyle;
    }

    public final String component16() {
        return this.uri;
    }

    public final String component17() {
        return this.event;
    }

    public final String component18() {
        return this.eventV2;
    }

    public final String component19() {
        return this.leftIconType;
    }

    public final String component2() {
        return this.textColor;
    }

    public final String component3() {
        return this.textColorNight;
    }

    public final String component4() {
        return this.borderColor;
    }

    public final String component5() {
        return this.borderColorNight;
    }

    public final String component6() {
        return this.bgColor;
    }

    public final String component7() {
        return this.bgColorNight;
    }

    public final String component8() {
        return this.iconUrl;
    }

    public final String component9() {
        return this.iconNightUrl;
    }

    public final AdRcmdReasonStyle copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, int i2, int i3, String str10, int i4, int i5, String str11, String str12, String str13, String str14) {
        return new AdRcmdReasonStyle(str, str2, str3, str4, str5, str6, str7, str8, str9, i, i2, i3, str10, i4, i5, str11, str12, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdRcmdReasonStyle) {
            AdRcmdReasonStyle adRcmdReasonStyle = (AdRcmdReasonStyle) obj;
            return Intrinsics.areEqual(this.text, adRcmdReasonStyle.text) && Intrinsics.areEqual(this.textColor, adRcmdReasonStyle.textColor) && Intrinsics.areEqual(this.textColorNight, adRcmdReasonStyle.textColorNight) && Intrinsics.areEqual(this.borderColor, adRcmdReasonStyle.borderColor) && Intrinsics.areEqual(this.borderColorNight, adRcmdReasonStyle.borderColorNight) && Intrinsics.areEqual(this.bgColor, adRcmdReasonStyle.bgColor) && Intrinsics.areEqual(this.bgColorNight, adRcmdReasonStyle.bgColorNight) && Intrinsics.areEqual(this.iconUrl, adRcmdReasonStyle.iconUrl) && Intrinsics.areEqual(this.iconNightUrl, adRcmdReasonStyle.iconNightUrl) && this.iconWidth == adRcmdReasonStyle.iconWidth && this.iconHeight == adRcmdReasonStyle.iconHeight && this.rightIconType == adRcmdReasonStyle.rightIconType && Intrinsics.areEqual(this.iconBgUrl, adRcmdReasonStyle.iconBgUrl) && this.textLen == adRcmdReasonStyle.textLen && this.bgStyle == adRcmdReasonStyle.bgStyle && Intrinsics.areEqual(this.uri, adRcmdReasonStyle.uri) && Intrinsics.areEqual(this.event, adRcmdReasonStyle.event) && Intrinsics.areEqual(this.eventV2, adRcmdReasonStyle.eventV2) && Intrinsics.areEqual(this.leftIconType, adRcmdReasonStyle.leftIconType);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((this.text == null ? 0 : this.text.hashCode()) * 31) + (this.textColor == null ? 0 : this.textColor.hashCode())) * 31) + (this.textColorNight == null ? 0 : this.textColorNight.hashCode())) * 31) + (this.borderColor == null ? 0 : this.borderColor.hashCode())) * 31) + (this.borderColorNight == null ? 0 : this.borderColorNight.hashCode())) * 31) + (this.bgColor == null ? 0 : this.bgColor.hashCode())) * 31) + (this.bgColorNight == null ? 0 : this.bgColorNight.hashCode())) * 31) + (this.iconUrl == null ? 0 : this.iconUrl.hashCode())) * 31) + (this.iconNightUrl == null ? 0 : this.iconNightUrl.hashCode())) * 31) + this.iconWidth) * 31) + this.iconHeight) * 31) + this.rightIconType) * 31) + (this.iconBgUrl == null ? 0 : this.iconBgUrl.hashCode())) * 31) + this.textLen) * 31) + this.bgStyle) * 31) + (this.uri == null ? 0 : this.uri.hashCode())) * 31) + (this.event == null ? 0 : this.event.hashCode())) * 31) + (this.eventV2 == null ? 0 : this.eventV2.hashCode())) * 31) + (this.leftIconType != null ? this.leftIconType.hashCode() : 0);
    }

    public String toString() {
        String str = this.text;
        String str2 = this.textColor;
        String str3 = this.textColorNight;
        String str4 = this.borderColor;
        String str5 = this.borderColorNight;
        String str6 = this.bgColor;
        String str7 = this.bgColorNight;
        String str8 = this.iconUrl;
        String str9 = this.iconNightUrl;
        int i = this.iconWidth;
        int i2 = this.iconHeight;
        int i3 = this.rightIconType;
        String str10 = this.iconBgUrl;
        int i4 = this.textLen;
        int i5 = this.bgStyle;
        String str11 = this.uri;
        String str12 = this.event;
        String str13 = this.eventV2;
        return "AdRcmdReasonStyle(text=" + str + ", textColor=" + str2 + ", textColorNight=" + str3 + ", borderColor=" + str4 + ", borderColorNight=" + str5 + ", bgColor=" + str6 + ", bgColorNight=" + str7 + ", iconUrl=" + str8 + ", iconNightUrl=" + str9 + ", iconWidth=" + i + ", iconHeight=" + i2 + ", rightIconType=" + i3 + ", iconBgUrl=" + str10 + ", textLen=" + i4 + ", bgStyle=" + i5 + ", uri=" + str11 + ", event=" + str12 + ", eventV2=" + str13 + ", leftIconType=" + this.leftIconType + ")";
    }

    /* compiled from: AdRcmdReasonStyle.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdRcmdReasonStyle$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdRcmdReasonStyle;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdRcmdReasonStyle> serializer() {
            return AdRcmdReasonStyle$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdRcmdReasonStyle(int seen0, String text, String textColor, String textColorNight, String borderColor, String borderColorNight, String bgColor, String bgColorNight, String iconUrl, String iconNightUrl, int iconWidth, int iconHeight, int rightIconType, String iconBgUrl, int textLen, int bgStyle, String uri, String event, String eventV2, String leftIconType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.text = null;
        } else {
            this.text = text;
        }
        if ((seen0 & 2) == 0) {
            this.textColor = null;
        } else {
            this.textColor = textColor;
        }
        if ((seen0 & 4) == 0) {
            this.textColorNight = null;
        } else {
            this.textColorNight = textColorNight;
        }
        if ((seen0 & 8) == 0) {
            this.borderColor = null;
        } else {
            this.borderColor = borderColor;
        }
        if ((seen0 & 16) == 0) {
            this.borderColorNight = null;
        } else {
            this.borderColorNight = borderColorNight;
        }
        if ((seen0 & 32) == 0) {
            this.bgColor = null;
        } else {
            this.bgColor = bgColor;
        }
        if ((seen0 & 64) == 0) {
            this.bgColorNight = null;
        } else {
            this.bgColorNight = bgColorNight;
        }
        if ((seen0 & 128) == 0) {
            this.iconUrl = null;
        } else {
            this.iconUrl = iconUrl;
        }
        if ((seen0 & 256) == 0) {
            this.iconNightUrl = null;
        } else {
            this.iconNightUrl = iconNightUrl;
        }
        if ((seen0 & 512) == 0) {
            this.iconWidth = 0;
        } else {
            this.iconWidth = iconWidth;
        }
        if ((seen0 & 1024) == 0) {
            this.iconHeight = 0;
        } else {
            this.iconHeight = iconHeight;
        }
        if ((seen0 & 2048) == 0) {
            this.rightIconType = 0;
        } else {
            this.rightIconType = rightIconType;
        }
        if ((seen0 & 4096) == 0) {
            this.iconBgUrl = null;
        } else {
            this.iconBgUrl = iconBgUrl;
        }
        if ((seen0 & 8192) == 0) {
            this.textLen = -1;
        } else {
            this.textLen = textLen;
        }
        if ((seen0 & 16384) == 0) {
            this.bgStyle = 0;
        } else {
            this.bgStyle = bgStyle;
        }
        if ((seen0 & 32768) == 0) {
            this.uri = null;
        } else {
            this.uri = uri;
        }
        if ((seen0 & 65536) == 0) {
            this.event = null;
        } else {
            this.event = event;
        }
        if ((seen0 & 131072) == 0) {
            this.eventV2 = null;
        } else {
            this.eventV2 = eventV2;
        }
        if ((seen0 & 262144) == 0) {
            this.leftIconType = null;
        } else {
            this.leftIconType = leftIconType;
        }
    }

    public AdRcmdReasonStyle(String text, String textColor, String textColorNight, String borderColor, String borderColorNight, String bgColor, String bgColorNight, String iconUrl, String iconNightUrl, int iconWidth, int iconHeight, int rightIconType, String iconBgUrl, int textLen, int bgStyle, String uri, String event, String eventV2, String leftIconType) {
        this.text = text;
        this.textColor = textColor;
        this.textColorNight = textColorNight;
        this.borderColor = borderColor;
        this.borderColorNight = borderColorNight;
        this.bgColor = bgColor;
        this.bgColorNight = bgColorNight;
        this.iconUrl = iconUrl;
        this.iconNightUrl = iconNightUrl;
        this.iconWidth = iconWidth;
        this.iconHeight = iconHeight;
        this.rightIconType = rightIconType;
        this.iconBgUrl = iconBgUrl;
        this.textLen = textLen;
        this.bgStyle = bgStyle;
        this.uri = uri;
        this.event = event;
        this.eventV2 = eventV2;
        this.leftIconType = leftIconType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdRcmdReasonStyle self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.textColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.textColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.textColorNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.textColorNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.borderColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.borderColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.borderColorNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.borderColorNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.bgColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.bgColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.bgColorNight != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.bgColorNight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.iconUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.iconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.iconNightUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.iconNightUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.iconWidth != 0) {
            output.encodeIntElement(serialDesc, 9, self.iconWidth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.iconHeight != 0) {
            output.encodeIntElement(serialDesc, 10, self.iconHeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.rightIconType != 0) {
            output.encodeIntElement(serialDesc, 11, self.rightIconType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.iconBgUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.iconBgUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.textLen != -1) {
            output.encodeIntElement(serialDesc, 13, self.textLen);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.bgStyle != 0) {
            output.encodeIntElement(serialDesc, 14, self.bgStyle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.uri != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.uri);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.event != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.event);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.eventV2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.eventV2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.leftIconType != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.leftIconType);
        }
    }

    public /* synthetic */ AdRcmdReasonStyle(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, int i2, int i3, String str10, int i4, int i5, String str11, String str12, String str13, String str14, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? null : str2, (i6 & 4) != 0 ? null : str3, (i6 & 8) != 0 ? null : str4, (i6 & 16) != 0 ? null : str5, (i6 & 32) != 0 ? null : str6, (i6 & 64) != 0 ? null : str7, (i6 & 128) != 0 ? null : str8, (i6 & 256) != 0 ? null : str9, (i6 & 512) != 0 ? 0 : i, (i6 & 1024) != 0 ? 0 : i2, (i6 & 2048) != 0 ? 0 : i3, (i6 & 4096) != 0 ? null : str10, (i6 & 8192) != 0 ? -1 : i4, (i6 & 16384) != 0 ? 0 : i5, (i6 & 32768) != 0 ? null : str11, (i6 & 65536) != 0 ? null : str12, (i6 & 131072) != 0 ? null : str13, (i6 & 262144) != 0 ? null : str14);
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getTextColorNight() {
        return this.textColorNight;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final String getBorderColorNight() {
        return this.borderColorNight;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getBgColorNight() {
        return this.bgColorNight;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIconNightUrl() {
        return this.iconNightUrl;
    }

    public final int getIconWidth() {
        return this.iconWidth;
    }

    public final int getIconHeight() {
        return this.iconHeight;
    }

    public final int getRightIconType() {
        return this.rightIconType;
    }

    public final String getIconBgUrl() {
        return this.iconBgUrl;
    }

    public final int getTextLen() {
        return this.textLen;
    }

    public final int getBgStyle() {
        return this.bgStyle;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getEventV2() {
        return this.eventV2;
    }

    public final String getLeftIconType() {
        return this.leftIconType;
    }
}