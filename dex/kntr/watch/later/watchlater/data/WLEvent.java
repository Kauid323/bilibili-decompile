package kntr.watch.later.watchlater.data;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WLState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/watch/later/watchlater/data/WLEvent;", "", "ShowBottomSheet", "ShowDeleteDialog", "ShowToast", "ShowDeleteBottomSheet", "Lkntr/watch/later/watchlater/data/WLEvent$ShowBottomSheet;", "Lkntr/watch/later/watchlater/data/WLEvent$ShowDeleteBottomSheet;", "Lkntr/watch/later/watchlater/data/WLEvent$ShowDeleteDialog;", "Lkntr/watch/later/watchlater/data/WLEvent$ShowToast;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface WLEvent {

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/watch/later/watchlater/data/WLEvent$ShowBottomSheet;", "Lkntr/watch/later/watchlater/data/WLEvent;", "<init>", "()V", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowBottomSheet implements WLEvent {
        public static final int $stable = 0;
        public static final ShowBottomSheet INSTANCE = new ShowBottomSheet();

        private ShowBottomSheet() {
        }
    }

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/watch/later/watchlater/data/WLEvent$ShowDeleteDialog;", "Lkntr/watch/later/watchlater/data/WLEvent;", "type", "Lkntr/watch/later/watchlater/data/DialogType;", "<init>", "(Lkntr/watch/later/watchlater/data/DialogType;)V", "getType", "()Lkntr/watch/later/watchlater/data/DialogType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowDeleteDialog implements WLEvent {
        public static final int $stable = 8;
        private final DialogType type;

        public static /* synthetic */ ShowDeleteDialog copy$default(ShowDeleteDialog showDeleteDialog, DialogType dialogType, int i, Object obj) {
            if ((i & 1) != 0) {
                dialogType = showDeleteDialog.type;
            }
            return showDeleteDialog.copy(dialogType);
        }

        public final DialogType component1() {
            return this.type;
        }

        public final ShowDeleteDialog copy(DialogType dialogType) {
            Intrinsics.checkNotNullParameter(dialogType, "type");
            return new ShowDeleteDialog(dialogType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowDeleteDialog) && Intrinsics.areEqual(this.type, ((ShowDeleteDialog) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "ShowDeleteDialog(type=" + this.type + ")";
        }

        public ShowDeleteDialog(DialogType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final DialogType getType() {
            return this.type;
        }
    }

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/watch/later/watchlater/data/WLEvent$ShowToast;", "Lkntr/watch/later/watchlater/data/WLEvent;", "type", "Lkntr/watch/later/watchlater/data/ToastType;", "<init>", "(Lkntr/watch/later/watchlater/data/ToastType;)V", "getType", "()Lkntr/watch/later/watchlater/data/ToastType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowToast implements WLEvent {
        public static final int $stable = 8;
        private final ToastType type;

        public static /* synthetic */ ShowToast copy$default(ShowToast showToast, ToastType toastType, int i, Object obj) {
            if ((i & 1) != 0) {
                toastType = showToast.type;
            }
            return showToast.copy(toastType);
        }

        public final ToastType component1() {
            return this.type;
        }

        public final ShowToast copy(ToastType toastType) {
            Intrinsics.checkNotNullParameter(toastType, "type");
            return new ShowToast(toastType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowToast) && Intrinsics.areEqual(this.type, ((ShowToast) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "ShowToast(type=" + this.type + ")";
        }

        public ShowToast(ToastType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final ToastType getType() {
            return this.type;
        }
    }

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/watch/later/watchlater/data/WLEvent$ShowDeleteBottomSheet;", "Lkntr/watch/later/watchlater/data/WLEvent;", "item", "Lkntr/watch/later/watchlater/data/WatchLaterItem;", "<init>", "(Lkntr/watch/later/watchlater/data/WatchLaterItem;)V", "getItem", "()Lkntr/watch/later/watchlater/data/WatchLaterItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowDeleteBottomSheet implements WLEvent {
        public static final int $stable = 8;
        private final WatchLaterItem item;

        public static /* synthetic */ ShowDeleteBottomSheet copy$default(ShowDeleteBottomSheet showDeleteBottomSheet, WatchLaterItem watchLaterItem, int i, Object obj) {
            if ((i & 1) != 0) {
                watchLaterItem = showDeleteBottomSheet.item;
            }
            return showDeleteBottomSheet.copy(watchLaterItem);
        }

        public final WatchLaterItem component1() {
            return this.item;
        }

        public final ShowDeleteBottomSheet copy(WatchLaterItem watchLaterItem) {
            Intrinsics.checkNotNullParameter(watchLaterItem, "item");
            return new ShowDeleteBottomSheet(watchLaterItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowDeleteBottomSheet) && Intrinsics.areEqual(this.item, ((ShowDeleteBottomSheet) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ShowDeleteBottomSheet(item=" + this.item + ")";
        }

        public ShowDeleteBottomSheet(WatchLaterItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final WatchLaterItem getItem() {
            return this.item;
        }
    }
}