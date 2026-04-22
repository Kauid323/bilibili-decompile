package tv.danmaku.bili.ui.garb.api;

import BottomSheetItemData$;
import com.bilibili.bson.adapter.EnumWithJsonValue;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: BiliDLCCardItem.kt */
@Bson
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001fB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Ltv/danmaku/bili/ui/garb/api/UseMenu;", "", "available", "", ReportUtilKt.POS_TITLE, "", "targetUrl", "tips", "jumpType", "Ltv/danmaku/bili/ui/garb/api/UseMenu$Type;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/api/UseMenu$Type;)V", "getAvailable", "()Z", "getTitle", "()Ljava/lang/String;", "getTargetUrl", "getTips", "getJumpType", "()Ltv/danmaku/bili/ui/garb/api/UseMenu$Type;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Type", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UseMenu {
    public static final int $stable = 0;
    @SerializedName("can_set")
    private final boolean available;
    private final Type jumpType;
    private final String targetUrl;
    private final String tips;
    private final String title;

    public static /* synthetic */ UseMenu copy$default(UseMenu useMenu, boolean z, String str, String str2, String str3, Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            z = useMenu.available;
        }
        if ((i & 2) != 0) {
            str = useMenu.title;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = useMenu.targetUrl;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = useMenu.tips;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            type = useMenu.jumpType;
        }
        return useMenu.copy(z, str4, str5, str6, type);
    }

    public final boolean component1() {
        return this.available;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.targetUrl;
    }

    public final String component4() {
        return this.tips;
    }

    public final Type component5() {
        return this.jumpType;
    }

    public final UseMenu copy(boolean z, String str, String str2, String str3, Type type) {
        Intrinsics.checkNotNullParameter(str, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(type, "jumpType");
        return new UseMenu(z, str, str2, str3, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UseMenu) {
            UseMenu useMenu = (UseMenu) obj;
            return this.available == useMenu.available && Intrinsics.areEqual(this.title, useMenu.title) && Intrinsics.areEqual(this.targetUrl, useMenu.targetUrl) && Intrinsics.areEqual(this.tips, useMenu.tips) && this.jumpType == useMenu.jumpType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.available) * 31) + this.title.hashCode()) * 31) + (this.targetUrl == null ? 0 : this.targetUrl.hashCode())) * 31) + (this.tips != null ? this.tips.hashCode() : 0)) * 31) + this.jumpType.hashCode();
    }

    public String toString() {
        boolean z = this.available;
        String str = this.title;
        String str2 = this.targetUrl;
        String str3 = this.tips;
        return "UseMenu(available=" + z + ", title=" + str + ", targetUrl=" + str2 + ", tips=" + str3 + ", jumpType=" + this.jumpType + ")";
    }

    public UseMenu(boolean available, String title, String targetUrl, String tips, Type jumpType) {
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(jumpType, "jumpType");
        this.available = available;
        this.title = title;
        this.targetUrl = targetUrl;
        this.tips = tips;
        this.jumpType = jumpType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ UseMenu(boolean z, String str, String str2, String str3, Type type, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, str2, str3, r5);
        Type type2;
        if ((i & 16) == 0) {
            type2 = type;
        } else {
            type2 = Type.Dynamic;
        }
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTargetUrl() {
        return this.targetUrl;
    }

    public final String getTips() {
        return this.tips;
    }

    public final Type getJumpType() {
        return this.jumpType;
    }

    /* compiled from: BiliDLCCardItem.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/UseMenu$Type;", "Lcom/bilibili/bson/adapter/EnumWithJsonValue;", "", "", "value", "<init>", "(Ljava/lang/String;II)V", "getValue", "()Ljava/lang/Integer;", "Dynamic", "Comment", "SplashSetting", "AppWidget", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum Type implements EnumWithJsonValue<Integer> {
        Dynamic(1),
        Comment(2),
        SplashSetting(3),
        AppWidget(4);
        
        private final int value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        Type(int value) {
            this.value = value;
        }

        /* renamed from: getValue */
        public Integer m1728getValue() {
            return Integer.valueOf(this.value);
        }
    }
}