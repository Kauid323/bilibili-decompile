package kntr.common.share.common;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChannelList.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB-\b\u0007\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkntr/common/share/common/ChannelList;", "", "above", "", "Lkntr/common/share/common/ChannelList$Item;", "below", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getAbove", "()Ljava/util/List;", "setAbove", "(Ljava/util/List;)V", "getBelow", "setBelow", "Item", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ChannelList {
    public static final int $stable = 8;
    private List<Item> above;
    private List<Item> below;

    public ChannelList() {
        this(null, null, 3, null);
    }

    public ChannelList(List<Item> list, List<Item> list2) {
        this.above = list;
        this.below = list2;
    }

    public /* synthetic */ ChannelList(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    public final List<Item> getAbove() {
        return this.above;
    }

    public final void setAbove(List<Item> list) {
        this.above = list;
    }

    public final List<Item> getBelow() {
        return this.below;
    }

    public final void setBelow(List<Item> list) {
        this.below = list;
    }

    /* compiled from: ChannelList.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lkntr/common/share/common/ChannelList$Item;", "", "target", "Lkntr/common/share/common/ShareTarget;", "name", "", "iconUrl", "<init>", "(Lkntr/common/share/common/ShareTarget;Ljava/lang/String;Ljava/lang/String;)V", "getTarget", "()Lkntr/common/share/common/ShareTarget;", "setTarget", "(Lkntr/common/share/common/ShareTarget;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Item {
        public static final int $stable = 8;
        private String iconUrl;
        private String name;
        private ShareTarget target;

        public Item(ShareTarget target, String name, String iconUrl) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(name, "name");
            this.target = target;
            this.name = name;
            this.iconUrl = iconUrl;
        }

        public /* synthetic */ Item(ShareTarget shareTarget, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(shareTarget, str, (i & 4) != 0 ? null : str2);
        }

        public final ShareTarget getTarget() {
            return this.target;
        }

        public final void setTarget(ShareTarget shareTarget) {
            Intrinsics.checkNotNullParameter(shareTarget, "<set-?>");
            this.target = shareTarget;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final void setIconUrl(String str) {
            this.iconUrl = str;
        }
    }
}