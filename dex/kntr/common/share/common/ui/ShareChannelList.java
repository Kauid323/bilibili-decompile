package kntr.common.share.common.ui;

import androidx.compose.ui.graphics.ImageBitmap;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareTarget;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMenuVM.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/share/common/ui/ShareChannelList;", "", "items", "", "Lkntr/common/share/common/ui/ShareChannelList$Item;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "isEmpty", "", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "Item", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareChannelList {
    public static final int $stable = 8;
    private final List<List<Item>> items;

    public ShareChannelList() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShareChannelList copy$default(ShareChannelList shareChannelList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shareChannelList.items;
        }
        return shareChannelList.copy(list);
    }

    public final List<List<Item>> component1() {
        return this.items;
    }

    public final ShareChannelList copy(List<? extends List<Item>> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new ShareChannelList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShareChannelList) && Intrinsics.areEqual(this.items, ((ShareChannelList) obj).items);
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "ShareChannelList(items=" + this.items + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareChannelList(List<? extends List<Item>> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
    }

    public /* synthetic */ ShareChannelList(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<List<Item>> getItems() {
        return this.items;
    }

    /* compiled from: ShareMenuVM.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006 "}, d2 = {"Lkntr/common/share/common/ui/ShareChannelList$Item;", "", "target", "Lkntr/common/share/common/ShareTarget;", "name", "", "icon", "Landroidx/compose/ui/graphics/ImageBitmap;", "iconUrl", "cornerText", "<init>", "(Lkntr/common/share/common/ShareTarget;Ljava/lang/String;Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Ljava/lang/String;)V", "getTarget", "()Lkntr/common/share/common/ShareTarget;", "getName", "()Ljava/lang/String;", "getIcon", "()Landroidx/compose/ui/graphics/ImageBitmap;", "getIconUrl", "getCornerText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Item {
        public static final int $stable = 8;
        private final String cornerText;
        private final ImageBitmap icon;
        private final String iconUrl;
        private final String name;
        private final ShareTarget target;

        public static /* synthetic */ Item copy$default(Item item, ShareTarget shareTarget, String str, ImageBitmap imageBitmap, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                shareTarget = item.target;
            }
            if ((i & 2) != 0) {
                str = item.name;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                imageBitmap = item.icon;
            }
            ImageBitmap imageBitmap2 = imageBitmap;
            if ((i & 8) != 0) {
                str2 = item.iconUrl;
            }
            String str5 = str2;
            if ((i & 16) != 0) {
                str3 = item.cornerText;
            }
            return item.copy(shareTarget, str4, imageBitmap2, str5, str3);
        }

        public final ShareTarget component1() {
            return this.target;
        }

        public final String component2() {
            return this.name;
        }

        public final ImageBitmap component3() {
            return this.icon;
        }

        public final String component4() {
            return this.iconUrl;
        }

        public final String component5() {
            return this.cornerText;
        }

        public final Item copy(ShareTarget shareTarget, String str, ImageBitmap imageBitmap, String str2, String str3) {
            Intrinsics.checkNotNullParameter(shareTarget, "target");
            Intrinsics.checkNotNullParameter(str, "name");
            return new Item(shareTarget, str, imageBitmap, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Item) {
                Item item = (Item) obj;
                return Intrinsics.areEqual(this.target, item.target) && Intrinsics.areEqual(this.name, item.name) && Intrinsics.areEqual(this.icon, item.icon) && Intrinsics.areEqual(this.iconUrl, item.iconUrl) && Intrinsics.areEqual(this.cornerText, item.cornerText);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.target.hashCode() * 31) + this.name.hashCode()) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.iconUrl == null ? 0 : this.iconUrl.hashCode())) * 31) + (this.cornerText != null ? this.cornerText.hashCode() : 0);
        }

        public String toString() {
            ShareTarget shareTarget = this.target;
            String str = this.name;
            ImageBitmap imageBitmap = this.icon;
            String str2 = this.iconUrl;
            return "Item(target=" + shareTarget + ", name=" + str + ", icon=" + imageBitmap + ", iconUrl=" + str2 + ", cornerText=" + this.cornerText + ")";
        }

        public Item(ShareTarget target, String name, ImageBitmap icon, String iconUrl, String cornerText) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(name, "name");
            this.target = target;
            this.name = name;
            this.icon = icon;
            this.iconUrl = iconUrl;
            this.cornerText = cornerText;
        }

        public /* synthetic */ Item(ShareTarget shareTarget, String str, ImageBitmap imageBitmap, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(shareTarget, str, (i & 4) != 0 ? null : imageBitmap, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
        }

        public final ShareTarget getTarget() {
            return this.target;
        }

        public final String getName() {
            return this.name;
        }

        public final ImageBitmap getIcon() {
            return this.icon;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final String getCornerText() {
            return this.cornerText;
        }
    }

    public final boolean isEmpty() {
        Iterable $this$all$iv = this.items;
        if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            List it = (List) element$iv;
            if (!it.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}