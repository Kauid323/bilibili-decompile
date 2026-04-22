package tv.danmaku.bili.ui.watchlater.data;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WLState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLEvent;", "", "ShowBottomSheet", "ShowDeleteDialog", "ShowToast", "ShowDeleteBottomSheet", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent$ShowBottomSheet;", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent$ShowDeleteBottomSheet;", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent$ShowDeleteDialog;", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent$ShowToast;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface WLEvent {

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLEvent$ShowBottomSheet;", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent;", "<init>", "()V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowBottomSheet implements WLEvent {
        public static final int $stable = 0;
        public static final ShowBottomSheet INSTANCE = new ShowBottomSheet();

        private ShowBottomSheet() {
        }
    }

    /* compiled from: WLState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLEvent$ShowDeleteDialog;", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent;", "type", "Ltv/danmaku/bili/ui/watchlater/data/DialogType;", "<init>", "(Ltv/danmaku/bili/ui/watchlater/data/DialogType;)V", "getType", "()Ltv/danmaku/bili/ui/watchlater/data/DialogType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLEvent$ShowToast;", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent;", "type", "Ltv/danmaku/bili/ui/watchlater/data/ToastType;", "<init>", "(Ltv/danmaku/bili/ui/watchlater/data/ToastType;)V", "getType", "()Ltv/danmaku/bili/ui/watchlater/data/ToastType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/data/WLEvent$ShowDeleteBottomSheet;", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent;", "aid", "", "<init>", "(J)V", "getAid", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShowDeleteBottomSheet implements WLEvent {
        public static final int $stable = 0;
        private final long aid;

        public static /* synthetic */ ShowDeleteBottomSheet copy$default(ShowDeleteBottomSheet showDeleteBottomSheet, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = showDeleteBottomSheet.aid;
            }
            return showDeleteBottomSheet.copy(j);
        }

        public final long component1() {
            return this.aid;
        }

        public final ShowDeleteBottomSheet copy(long j) {
            return new ShowDeleteBottomSheet(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowDeleteBottomSheet) && this.aid == ((ShowDeleteBottomSheet) obj).aid;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid);
        }

        public String toString() {
            return "ShowDeleteBottomSheet(aid=" + this.aid + ")";
        }

        public ShowDeleteBottomSheet(long aid) {
            this.aid = aid;
        }

        public final long getAid() {
            return this.aid;
        }
    }
}