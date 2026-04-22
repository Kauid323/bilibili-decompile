package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.adapter.EnumWithJsonValue;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: CollectionRoomNoticeApiService.kt */
@Bson
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\"B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/Notice;", "", "iconUrl", "", "tipText", "btnUrl", "btnText", "uiStyle", "Ltv/danmaku/bili/ui/garb/api/Notice$Style;", "noticeTextType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/api/Notice$Style;I)V", "getIconUrl", "()Ljava/lang/String;", "getTipText", "getBtnUrl", "getBtnText", "getUiStyle", "()Ltv/danmaku/bili/ui/garb/api/Notice$Style;", "getNoticeTextType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Style", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Notice {
    public static final int $stable = 0;
    private final String btnText;
    private final String btnUrl;
    private final String iconUrl;
    @SerializedName("tip_type")
    private final int noticeTextType;
    private final String tipText;
    @SerializedName("icon_style")
    private final Style uiStyle;

    public static /* synthetic */ Notice copy$default(Notice notice, String str, String str2, String str3, String str4, Style style, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = notice.iconUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = notice.tipText;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = notice.btnUrl;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = notice.btnText;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            style = notice.uiStyle;
        }
        Style style2 = style;
        if ((i2 & 32) != 0) {
            i = notice.noticeTextType;
        }
        return notice.copy(str, str5, str6, str7, style2, i);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.tipText;
    }

    public final String component3() {
        return this.btnUrl;
    }

    public final String component4() {
        return this.btnText;
    }

    public final Style component5() {
        return this.uiStyle;
    }

    public final int component6() {
        return this.noticeTextType;
    }

    public final Notice copy(String str, String str2, String str3, String str4, Style style, int i) {
        Intrinsics.checkNotNullParameter(str, "iconUrl");
        Intrinsics.checkNotNullParameter(str2, "tipText");
        Intrinsics.checkNotNullParameter(str3, "btnUrl");
        Intrinsics.checkNotNullParameter(str4, "btnText");
        Intrinsics.checkNotNullParameter(style, "uiStyle");
        return new Notice(str, str2, str3, str4, style, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Notice) {
            Notice notice = (Notice) obj;
            return Intrinsics.areEqual(this.iconUrl, notice.iconUrl) && Intrinsics.areEqual(this.tipText, notice.tipText) && Intrinsics.areEqual(this.btnUrl, notice.btnUrl) && Intrinsics.areEqual(this.btnText, notice.btnText) && this.uiStyle == notice.uiStyle && this.noticeTextType == notice.noticeTextType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.iconUrl.hashCode() * 31) + this.tipText.hashCode()) * 31) + this.btnUrl.hashCode()) * 31) + this.btnText.hashCode()) * 31) + this.uiStyle.hashCode()) * 31) + this.noticeTextType;
    }

    public String toString() {
        String str = this.iconUrl;
        String str2 = this.tipText;
        String str3 = this.btnUrl;
        String str4 = this.btnText;
        Style style = this.uiStyle;
        return "Notice(iconUrl=" + str + ", tipText=" + str2 + ", btnUrl=" + str3 + ", btnText=" + str4 + ", uiStyle=" + style + ", noticeTextType=" + this.noticeTextType + ")";
    }

    public Notice(String iconUrl, String tipText, String btnUrl, String btnText, Style uiStyle, int noticeTextType) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(tipText, "tipText");
        Intrinsics.checkNotNullParameter(btnUrl, "btnUrl");
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        Intrinsics.checkNotNullParameter(uiStyle, "uiStyle");
        this.iconUrl = iconUrl;
        this.tipText = tipText;
        this.btnUrl = btnUrl;
        this.btnText = btnText;
        this.uiStyle = uiStyle;
        this.noticeTextType = noticeTextType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Notice(String str, String str2, String str3, String str4, Style style, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, r5, i);
        Style style2;
        if ((i2 & 16) == 0) {
            style2 = style;
        } else {
            style2 = Style.ICON;
        }
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getTipText() {
        return this.tipText;
    }

    public final String getBtnUrl() {
        return this.btnUrl;
    }

    public final String getBtnText() {
        return this.btnText;
    }

    public final Style getUiStyle() {
        return this.uiStyle;
    }

    public final int getNoticeTextType() {
        return this.noticeTextType;
    }

    /* compiled from: CollectionRoomNoticeApiService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/Notice$Style;", "Lcom/bilibili/bson/adapter/EnumWithJsonValue;", "", "", "value", "<init>", "(Ljava/lang/String;II)V", "getValue", "()Ljava/lang/Integer;", "ICON", "IMAGE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum Style implements EnumWithJsonValue<Integer> {
        ICON(1),
        IMAGE(2);
        
        private final int value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Style> getEntries() {
            return $ENTRIES;
        }

        Style(int value) {
            this.value = value;
        }

        /* renamed from: getValue */
        public Integer m1727getValue() {
            return Integer.valueOf(this.value);
        }
    }
}