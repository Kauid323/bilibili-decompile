package kntr.app.tribee.repost.action;

import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeRepostAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostUIAction;", "", "ToastTips", "CloseAndRouterTo", "Lkntr/app/tribee/repost/action/TribeeRepostUIAction$CloseAndRouterTo;", "Lkntr/app/tribee/repost/action/TribeeRepostUIAction$ToastTips;", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeRepostUIAction {

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostUIAction$ToastTips;", "Lkntr/app/tribee/repost/action/TribeeRepostUIAction;", "tribeeToast", "Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;", "<init>", "(Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;)V", "getTribeeToast", "()Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToastTips implements TribeeRepostUIAction {
        public static final int $stable = TribeeToast.$stable;
        private final TribeeToast tribeeToast;

        public static /* synthetic */ ToastTips copy$default(ToastTips toastTips, TribeeToast tribeeToast, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeToast = toastTips.tribeeToast;
            }
            return toastTips.copy(tribeeToast);
        }

        public final TribeeToast component1() {
            return this.tribeeToast;
        }

        public final ToastTips copy(TribeeToast tribeeToast) {
            return new ToastTips(tribeeToast);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToastTips) && Intrinsics.areEqual(this.tribeeToast, ((ToastTips) obj).tribeeToast);
        }

        public int hashCode() {
            if (this.tribeeToast == null) {
                return 0;
            }
            return this.tribeeToast.hashCode();
        }

        public String toString() {
            return "ToastTips(tribeeToast=" + this.tribeeToast + ")";
        }

        public ToastTips(TribeeToast tribeeToast) {
            this.tribeeToast = tribeeToast;
        }

        public final TribeeToast getTribeeToast() {
            return this.tribeeToast;
        }
    }

    /* compiled from: TribeeRepostAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/repost/action/TribeeRepostUIAction$CloseAndRouterTo;", "Lkntr/app/tribee/repost/action/TribeeRepostUIAction;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CloseAndRouterTo implements TribeeRepostUIAction {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ CloseAndRouterTo copy$default(CloseAndRouterTo closeAndRouterTo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = closeAndRouterTo.url;
            }
            return closeAndRouterTo.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final CloseAndRouterTo copy(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new CloseAndRouterTo(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CloseAndRouterTo) && Intrinsics.areEqual(this.url, ((CloseAndRouterTo) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "CloseAndRouterTo(url=" + this.url + ")";
        }

        public CloseAndRouterTo(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }
}