package kntr.app.tribee.invite.viewmodel;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.invite.page.InviteItem;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeInviteStateAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "", "ToastTips", "ExpandList", "CollapseList", "RouterTo", "ShareCode", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$CollapseList;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$ExpandList;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$RouterTo;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$ShareCode;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$ToastTips;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeInviteUIAction {

    /* compiled from: TribeeInviteStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$ToastTips;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "tribeeToast", "Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;", "<init>", "(Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;)V", "getTribeeToast", "()Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToastTips implements TribeeInviteUIAction {
        public static final int $stable = 0;
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

    /* compiled from: TribeeInviteStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$ExpandList;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "tribeeId", "", "<init>", "(J)V", "getTribeeId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ExpandList implements TribeeInviteUIAction {
        public static final int $stable = 0;
        private final long tribeeId;

        public static /* synthetic */ ExpandList copy$default(ExpandList expandList, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = expandList.tribeeId;
            }
            return expandList.copy(j);
        }

        public final long component1() {
            return this.tribeeId;
        }

        public final ExpandList copy(long j) {
            return new ExpandList(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ExpandList) && this.tribeeId == ((ExpandList) obj).tribeeId;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.tribeeId);
        }

        public String toString() {
            return "ExpandList(tribeeId=" + this.tribeeId + ")";
        }

        public ExpandList(long tribeeId) {
            this.tribeeId = tribeeId;
        }

        public final long getTribeeId() {
            return this.tribeeId;
        }
    }

    /* compiled from: TribeeInviteStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$CollapseList;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "tribeeId", "", "<init>", "(J)V", "getTribeeId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CollapseList implements TribeeInviteUIAction {
        public static final int $stable = 0;
        private final long tribeeId;

        public static /* synthetic */ CollapseList copy$default(CollapseList collapseList, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = collapseList.tribeeId;
            }
            return collapseList.copy(j);
        }

        public final long component1() {
            return this.tribeeId;
        }

        public final CollapseList copy(long j) {
            return new CollapseList(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CollapseList) && this.tribeeId == ((CollapseList) obj).tribeeId;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.tribeeId);
        }

        public String toString() {
            return "CollapseList(tribeeId=" + this.tribeeId + ")";
        }

        public CollapseList(long tribeeId) {
            this.tribeeId = tribeeId;
        }

        public final long getTribeeId() {
            return this.tribeeId;
        }
    }

    /* compiled from: TribeeInviteStateAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$RouterTo;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RouterTo implements TribeeInviteUIAction {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ RouterTo copy$default(RouterTo routerTo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = routerTo.url;
            }
            return routerTo.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final RouterTo copy(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new RouterTo(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RouterTo) && Intrinsics.areEqual(this.url, ((RouterTo) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "RouterTo(url=" + this.url + ")";
        }

        public RouterTo(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: TribeeInviteStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction$ShareCode;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "code", "Lkntr/app/tribee/invite/page/InviteItem$CodeItem;", "<init>", "(Lkntr/app/tribee/invite/page/InviteItem$CodeItem;)V", "getCode", "()Lkntr/app/tribee/invite/page/InviteItem$CodeItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShareCode implements TribeeInviteUIAction {
        public static final int $stable = 8;
        private final InviteItem.CodeItem code;

        public static /* synthetic */ ShareCode copy$default(ShareCode shareCode, InviteItem.CodeItem codeItem, int i, Object obj) {
            if ((i & 1) != 0) {
                codeItem = shareCode.code;
            }
            return shareCode.copy(codeItem);
        }

        public final InviteItem.CodeItem component1() {
            return this.code;
        }

        public final ShareCode copy(InviteItem.CodeItem codeItem) {
            Intrinsics.checkNotNullParameter(codeItem, "code");
            return new ShareCode(codeItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShareCode) && Intrinsics.areEqual(this.code, ((ShareCode) obj).code);
        }

        public int hashCode() {
            return this.code.hashCode();
        }

        public String toString() {
            return "ShareCode(code=" + this.code + ")";
        }

        public ShareCode(InviteItem.CodeItem code) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
        }

        public final InviteItem.CodeItem getCode() {
            return this.code;
        }
    }
}