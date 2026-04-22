package tv.danmaku.bili.ui.garb.api;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: BiliDLCCardItem.kt */
@Bson
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003Jm\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\nHÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001a¨\u00060"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;", "", "id", "", ChannelRoutes.CHANNEL_NAME, "", "overviewImage", "content", "Ltv/danmaku/bili/ui/garb/api/Content;", "materialType", "", "theme", "scarcity", "layout", "width", "height", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/api/Content;ILjava/lang/String;IIII)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getOverviewImage", "getContent", "()Ltv/danmaku/bili/ui/garb/api/Content;", "getMaterialType", "()I", "getTheme", "getScarcity", "getLayout", "getWidth", "getHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CardTypeInfo {
    public static final int $stable = 8;
    @SerializedName("content")
    private final Content content;
    @SerializedName("height")
    private final int height;
    @SerializedName("id")
    private final long id;
    @SerializedName("layout")
    private final int layout;
    @SerializedName("material_type")
    private final int materialType;
    @SerializedName(ChannelRoutes.CHANNEL_NAME)
    private final String name;
    @SerializedName("overview_image")
    private final String overviewImage;
    @SerializedName("item_scarcity")
    private final int scarcity;
    @SerializedName("theme")
    private final String theme;
    @SerializedName("width")
    private final int width;

    public final long component1() {
        return this.id;
    }

    public final int component10() {
        return this.height;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.overviewImage;
    }

    public final Content component4() {
        return this.content;
    }

    public final int component5() {
        return this.materialType;
    }

    public final String component6() {
        return this.theme;
    }

    public final int component7() {
        return this.scarcity;
    }

    public final int component8() {
        return this.layout;
    }

    public final int component9() {
        return this.width;
    }

    public final CardTypeInfo copy(long j, String str, String str2, Content content, int i, String str3, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(str2, "overviewImage");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(str3, "theme");
        return new CardTypeInfo(j, str, str2, content, i, str3, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardTypeInfo) {
            CardTypeInfo cardTypeInfo = (CardTypeInfo) obj;
            return this.id == cardTypeInfo.id && Intrinsics.areEqual(this.name, cardTypeInfo.name) && Intrinsics.areEqual(this.overviewImage, cardTypeInfo.overviewImage) && Intrinsics.areEqual(this.content, cardTypeInfo.content) && this.materialType == cardTypeInfo.materialType && Intrinsics.areEqual(this.theme, cardTypeInfo.theme) && this.scarcity == cardTypeInfo.scarcity && this.layout == cardTypeInfo.layout && this.width == cardTypeInfo.width && this.height == cardTypeInfo.height;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.name.hashCode()) * 31) + this.overviewImage.hashCode()) * 31) + this.content.hashCode()) * 31) + this.materialType) * 31) + this.theme.hashCode()) * 31) + this.scarcity) * 31) + this.layout) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        long j = this.id;
        String str = this.name;
        String str2 = this.overviewImage;
        Content content = this.content;
        int i = this.materialType;
        String str3 = this.theme;
        int i2 = this.scarcity;
        int i3 = this.layout;
        int i4 = this.width;
        return "CardTypeInfo(id=" + j + ", name=" + str + ", overviewImage=" + str2 + ", content=" + content + ", materialType=" + i + ", theme=" + str3 + ", scarcity=" + i2 + ", layout=" + i3 + ", width=" + i4 + ", height=" + this.height + ")";
    }

    public CardTypeInfo(long id, String name, String overviewImage, Content content, int materialType, String theme, int scarcity, int layout, int width, int height) {
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(overviewImage, "overviewImage");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.id = id;
        this.name = name;
        this.overviewImage = overviewImage;
        this.content = content;
        this.materialType = materialType;
        this.theme = theme;
        this.scarcity = scarcity;
        this.layout = layout;
        this.width = width;
        this.height = height;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOverviewImage() {
        return this.overviewImage;
    }

    public final Content getContent() {
        return this.content;
    }

    public final int getMaterialType() {
        return this.materialType;
    }

    public final String getTheme() {
        return this.theme;
    }

    public final int getScarcity() {
        return this.scarcity;
    }

    public final int getLayout() {
        return this.layout;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}