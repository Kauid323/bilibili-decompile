package kntr.common.share.common.ui;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareLocalContext;
import kntr.common.share.common.ShareTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMenuVM.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuViewAction;", "", "LoadChannelList", "Show", "Click", "Hidden", "Lkntr/common/share/common/ui/ShareMenuViewAction$Click;", "Lkntr/common/share/common/ui/ShareMenuViewAction$Hidden;", "Lkntr/common/share/common/ui/ShareMenuViewAction$LoadChannelList;", "Lkntr/common/share/common/ui/ShareMenuViewAction$Show;", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ShareMenuViewAction {

    /* compiled from: ShareMenuVM.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuViewAction$LoadChannelList;", "Lkntr/common/share/common/ui/ShareMenuViewAction;", "local", "Lkntr/common/share/common/ui/ShareChannelList;", "<init>", "(Lkntr/common/share/common/ui/ShareChannelList;)V", "getLocal", "()Lkntr/common/share/common/ui/ShareChannelList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadChannelList implements ShareMenuViewAction {
        public static final int $stable = 8;
        private final ShareChannelList local;

        public LoadChannelList() {
            this(null, 1, null);
        }

        public static /* synthetic */ LoadChannelList copy$default(LoadChannelList loadChannelList, ShareChannelList shareChannelList, int i, Object obj) {
            if ((i & 1) != 0) {
                shareChannelList = loadChannelList.local;
            }
            return loadChannelList.copy(shareChannelList);
        }

        public final ShareChannelList component1() {
            return this.local;
        }

        public final LoadChannelList copy(ShareChannelList shareChannelList) {
            return new LoadChannelList(shareChannelList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadChannelList) && Intrinsics.areEqual(this.local, ((LoadChannelList) obj).local);
        }

        public int hashCode() {
            if (this.local == null) {
                return 0;
            }
            return this.local.hashCode();
        }

        public String toString() {
            return "LoadChannelList(local=" + this.local + ")";
        }

        public LoadChannelList(ShareChannelList local) {
            this.local = local;
        }

        public /* synthetic */ LoadChannelList(ShareChannelList shareChannelList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : shareChannelList);
        }

        public final ShareChannelList getLocal() {
            return this.local;
        }
    }

    /* compiled from: ShareMenuVM.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuViewAction$Show;", "Lkntr/common/share/common/ui/ShareMenuViewAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Show implements ShareMenuViewAction {
        public static final int $stable = 0;
        public static final Show INSTANCE = new Show();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Show) {
                Show show = (Show) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2125366482;
        }

        public String toString() {
            return "Show";
        }

        private Show() {
        }
    }

    /* compiled from: ShareMenuVM.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuViewAction$Click;", "Lkntr/common/share/common/ui/ShareMenuViewAction;", "target", "Lkntr/common/share/common/ShareTarget;", "context", "Lkntr/common/share/common/ShareLocalContext;", "<init>", "(Lkntr/common/share/common/ShareTarget;Lkntr/common/share/common/ShareLocalContext;)V", "getTarget", "()Lkntr/common/share/common/ShareTarget;", "getContext", "()Lkntr/common/share/common/ShareLocalContext;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Click implements ShareMenuViewAction {
        public static final int $stable = 8;
        private final ShareLocalContext context;
        private final ShareTarget target;

        public static /* synthetic */ Click copy$default(Click click, ShareTarget shareTarget, ShareLocalContext shareLocalContext, int i, Object obj) {
            if ((i & 1) != 0) {
                shareTarget = click.target;
            }
            if ((i & 2) != 0) {
                shareLocalContext = click.context;
            }
            return click.copy(shareTarget, shareLocalContext);
        }

        public final ShareTarget component1() {
            return this.target;
        }

        public final ShareLocalContext component2() {
            return this.context;
        }

        public final Click copy(ShareTarget shareTarget, ShareLocalContext shareLocalContext) {
            Intrinsics.checkNotNullParameter(shareTarget, "target");
            Intrinsics.checkNotNullParameter(shareLocalContext, "context");
            return new Click(shareTarget, shareLocalContext);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Click) {
                Click click = (Click) obj;
                return Intrinsics.areEqual(this.target, click.target) && Intrinsics.areEqual(this.context, click.context);
            }
            return false;
        }

        public int hashCode() {
            return (this.target.hashCode() * 31) + this.context.hashCode();
        }

        public String toString() {
            ShareTarget shareTarget = this.target;
            return "Click(target=" + shareTarget + ", context=" + this.context + ")";
        }

        public Click(ShareTarget target, ShareLocalContext context) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(context, "context");
            this.target = target;
            this.context = context;
        }

        public final ShareTarget getTarget() {
            return this.target;
        }

        public final ShareLocalContext getContext() {
            return this.context;
        }
    }

    /* compiled from: ShareMenuVM.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuViewAction$Hidden;", "Lkntr/common/share/common/ui/ShareMenuViewAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Hidden implements ShareMenuViewAction {
        public static final int $stable = 0;
        public static final Hidden INSTANCE = new Hidden();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Hidden) {
                Hidden hidden = (Hidden) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1612903835;
        }

        public String toString() {
            return "Hidden";
        }

        private Hidden() {
        }
    }
}