package kntr.app.im.chat.sticker.model;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StickerAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerAction;", RoomRecommendViewModel.EMPTY_CURSOR, "ReverseEditMode", "SelectStickerOrUnSelectToDelete", "SelectStickerOrUnSelectToSave", "DeleteStickers", "DeleteSelectedStickers", "SaveSelectedStickers", "ShowConfirmDeleteDialog", "Lkntr/app/im/chat/sticker/model/StickerAction$DeleteSelectedStickers;", "Lkntr/app/im/chat/sticker/model/StickerAction$DeleteStickers;", "Lkntr/app/im/chat/sticker/model/StickerAction$ReverseEditMode;", "Lkntr/app/im/chat/sticker/model/StickerAction$SaveSelectedStickers;", "Lkntr/app/im/chat/sticker/model/StickerAction$SelectStickerOrUnSelectToDelete;", "Lkntr/app/im/chat/sticker/model/StickerAction$SelectStickerOrUnSelectToSave;", "Lkntr/app/im/chat/sticker/model/StickerAction$ShowConfirmDeleteDialog;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface StickerAction {

    /* compiled from: StickerAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerAction$ReverseEditMode;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReverseEditMode implements StickerAction {
        public static final int $stable = 0;
        public static final ReverseEditMode INSTANCE = new ReverseEditMode();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReverseEditMode) {
                ReverseEditMode reverseEditMode = (ReverseEditMode) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1967140888;
        }

        public String toString() {
            return "ReverseEditMode";
        }

        private ReverseEditMode() {
        }
    }

    /* compiled from: StickerAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerAction$SelectStickerOrUnSelectToDelete;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "sticker", "Lkntr/app/im/chat/sticker/model/StickerAsset;", "<init>", "(Lkntr/app/im/chat/sticker/model/StickerAsset;)V", "getSticker", "()Lkntr/app/im/chat/sticker/model/StickerAsset;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SelectStickerOrUnSelectToDelete implements StickerAction {
        public static final int $stable = 8;
        private final StickerAsset sticker;

        public static /* synthetic */ SelectStickerOrUnSelectToDelete copy$default(SelectStickerOrUnSelectToDelete selectStickerOrUnSelectToDelete, StickerAsset stickerAsset, int i, Object obj) {
            if ((i & 1) != 0) {
                stickerAsset = selectStickerOrUnSelectToDelete.sticker;
            }
            return selectStickerOrUnSelectToDelete.copy(stickerAsset);
        }

        public final StickerAsset component1() {
            return this.sticker;
        }

        public final SelectStickerOrUnSelectToDelete copy(StickerAsset stickerAsset) {
            Intrinsics.checkNotNullParameter(stickerAsset, "sticker");
            return new SelectStickerOrUnSelectToDelete(stickerAsset);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectStickerOrUnSelectToDelete) && Intrinsics.areEqual(this.sticker, ((SelectStickerOrUnSelectToDelete) obj).sticker);
        }

        public int hashCode() {
            return this.sticker.hashCode();
        }

        public String toString() {
            return "SelectStickerOrUnSelectToDelete(sticker=" + this.sticker + ")";
        }

        public SelectStickerOrUnSelectToDelete(StickerAsset sticker) {
            Intrinsics.checkNotNullParameter(sticker, "sticker");
            this.sticker = sticker;
        }

        public final StickerAsset getSticker() {
            return this.sticker;
        }
    }

    /* compiled from: StickerAction.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerAction$SelectStickerOrUnSelectToSave;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "assetList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/common/photonic/Asset;", "<init>", "(Ljava/util/List;)V", "getAssetList", "()Ljava/util/List;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SelectStickerOrUnSelectToSave implements StickerAction {
        public static final int $stable = 8;
        private final List<Asset> assetList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SelectStickerOrUnSelectToSave copy$default(SelectStickerOrUnSelectToSave selectStickerOrUnSelectToSave, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = selectStickerOrUnSelectToSave.assetList;
            }
            return selectStickerOrUnSelectToSave.copy(list);
        }

        public final List<Asset> component1() {
            return this.assetList;
        }

        public final SelectStickerOrUnSelectToSave copy(List<? extends Asset> list) {
            Intrinsics.checkNotNullParameter(list, "assetList");
            return new SelectStickerOrUnSelectToSave(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectStickerOrUnSelectToSave) && Intrinsics.areEqual(this.assetList, ((SelectStickerOrUnSelectToSave) obj).assetList);
        }

        public int hashCode() {
            return this.assetList.hashCode();
        }

        public String toString() {
            return "SelectStickerOrUnSelectToSave(assetList=" + this.assetList + ")";
        }

        public SelectStickerOrUnSelectToSave(List<? extends Asset> list) {
            Intrinsics.checkNotNullParameter(list, "assetList");
            this.assetList = list;
        }

        public final List<Asset> getAssetList() {
            return this.assetList;
        }
    }

    /* compiled from: StickerAction.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerAction$DeleteStickers;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "stickers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/sticker/model/StickerAsset;", "<init>", "(Ljava/util/List;)V", "getStickers", "()Ljava/util/List;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DeleteStickers implements StickerAction {
        public static final int $stable = 8;
        private final List<StickerAsset> stickers;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeleteStickers copy$default(DeleteStickers deleteStickers, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = deleteStickers.stickers;
            }
            return deleteStickers.copy(list);
        }

        public final List<StickerAsset> component1() {
            return this.stickers;
        }

        public final DeleteStickers copy(List<StickerAsset> list) {
            Intrinsics.checkNotNullParameter(list, "stickers");
            return new DeleteStickers(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteStickers) && Intrinsics.areEqual(this.stickers, ((DeleteStickers) obj).stickers);
        }

        public int hashCode() {
            return this.stickers.hashCode();
        }

        public String toString() {
            return "DeleteStickers(stickers=" + this.stickers + ")";
        }

        public DeleteStickers(List<StickerAsset> list) {
            Intrinsics.checkNotNullParameter(list, "stickers");
            this.stickers = list;
        }

        public final List<StickerAsset> getStickers() {
            return this.stickers;
        }
    }

    /* compiled from: StickerAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerAction$DeleteSelectedStickers;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DeleteSelectedStickers implements StickerAction {
        public static final int $stable = 0;
        public static final DeleteSelectedStickers INSTANCE = new DeleteSelectedStickers();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeleteSelectedStickers) {
                DeleteSelectedStickers deleteSelectedStickers = (DeleteSelectedStickers) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1995991565;
        }

        public String toString() {
            return "DeleteSelectedStickers";
        }

        private DeleteSelectedStickers() {
        }
    }

    /* compiled from: StickerAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerAction$SaveSelectedStickers;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SaveSelectedStickers implements StickerAction {
        public static final int $stable = 0;
        public static final SaveSelectedStickers INSTANCE = new SaveSelectedStickers();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SaveSelectedStickers) {
                SaveSelectedStickers saveSelectedStickers = (SaveSelectedStickers) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1236801659;
        }

        public String toString() {
            return "SaveSelectedStickers";
        }

        private SaveSelectedStickers() {
        }
    }

    /* compiled from: StickerAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerAction$ShowConfirmDeleteDialog;", "Lkntr/app/im/chat/sticker/model/StickerAction;", "isShow", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ShowConfirmDeleteDialog implements StickerAction {
        public static final int $stable = 0;
        private final boolean isShow;

        public static /* synthetic */ ShowConfirmDeleteDialog copy$default(ShowConfirmDeleteDialog showConfirmDeleteDialog, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = showConfirmDeleteDialog.isShow;
            }
            return showConfirmDeleteDialog.copy(z);
        }

        public final boolean component1() {
            return this.isShow;
        }

        public final ShowConfirmDeleteDialog copy(boolean z) {
            return new ShowConfirmDeleteDialog(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowConfirmDeleteDialog) && this.isShow == ((ShowConfirmDeleteDialog) obj).isShow;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShow);
        }

        public String toString() {
            return "ShowConfirmDeleteDialog(isShow=" + this.isShow + ")";
        }

        public ShowConfirmDeleteDialog(boolean isShow) {
            this.isShow = isShow;
        }

        public final boolean isShow() {
            return this.isShow;
        }
    }
}