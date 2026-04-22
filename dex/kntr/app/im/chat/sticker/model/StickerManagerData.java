package kntr.app.im.chat.sticker.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import im.base.IMToast;
import java.util.List;
import java.util.Set;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StickerManagerData.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003Jm\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\fHÆ\u0001J\u0013\u0010+\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u001fHÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00060"}, d2 = {"Lkntr/app/im/chat/sticker/model/StickerManagerData;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "stickerList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/sticker/model/StickerAsset;", "selectedStickersToDelete", RoomRecommendViewModel.EMPTY_CURSOR, "selectedStickersToSave", "Lkntr/common/photonic/Asset;", "isEditMode", RoomRecommendViewModel.EMPTY_CURSOR, "toast", "Lim/base/IMToast;", "isShowConfirmDeleteDialog", "saved", "<init>", "(JLjava/util/List;Ljava/util/Set;Ljava/util/Set;ZLim/base/IMToast;ZZ)V", "getMid", "()J", "getStickerList", "()Ljava/util/List;", "getSelectedStickersToDelete", "()Ljava/util/Set;", "getSelectedStickersToSave", "()Z", "getToast", "()Lim/base/IMToast;", "getSaved", "selectedStickerToDeleteSize", RoomRecommendViewModel.EMPTY_CURSOR, "getSelectedStickerToDeleteSize", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerManagerData {
    public static final int $stable = 0;
    private final boolean isEditMode;
    private final boolean isShowConfirmDeleteDialog;
    private final long mid;
    private final boolean saved;
    private final Set<StickerAsset> selectedStickersToDelete;
    private final Set<Asset> selectedStickersToSave;
    private final List<StickerAsset> stickerList;
    private final IMToast toast;

    public StickerManagerData() {
        this(0L, null, null, null, false, null, false, false, 255, null);
    }

    public final long component1() {
        return this.mid;
    }

    public final List<StickerAsset> component2() {
        return this.stickerList;
    }

    public final Set<StickerAsset> component3() {
        return this.selectedStickersToDelete;
    }

    public final Set<Asset> component4() {
        return this.selectedStickersToSave;
    }

    public final boolean component5() {
        return this.isEditMode;
    }

    public final IMToast component6() {
        return this.toast;
    }

    public final boolean component7() {
        return this.isShowConfirmDeleteDialog;
    }

    public final boolean component8() {
        return this.saved;
    }

    public final StickerManagerData copy(long j2, List<StickerAsset> list, Set<StickerAsset> set, Set<? extends Asset> set2, boolean z, IMToast iMToast, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(list, "stickerList");
        Intrinsics.checkNotNullParameter(set, "selectedStickersToDelete");
        Intrinsics.checkNotNullParameter(set2, "selectedStickersToSave");
        return new StickerManagerData(j2, list, set, set2, z, iMToast, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerManagerData) {
            StickerManagerData stickerManagerData = (StickerManagerData) obj;
            return this.mid == stickerManagerData.mid && Intrinsics.areEqual(this.stickerList, stickerManagerData.stickerList) && Intrinsics.areEqual(this.selectedStickersToDelete, stickerManagerData.selectedStickersToDelete) && Intrinsics.areEqual(this.selectedStickersToSave, stickerManagerData.selectedStickersToSave) && this.isEditMode == stickerManagerData.isEditMode && Intrinsics.areEqual(this.toast, stickerManagerData.toast) && this.isShowConfirmDeleteDialog == stickerManagerData.isShowConfirmDeleteDialog && this.saved == stickerManagerData.saved;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid) * 31) + this.stickerList.hashCode()) * 31) + this.selectedStickersToDelete.hashCode()) * 31) + this.selectedStickersToSave.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isEditMode)) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShowConfirmDeleteDialog)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.saved);
    }

    public String toString() {
        long j2 = this.mid;
        List<StickerAsset> list = this.stickerList;
        Set<StickerAsset> set = this.selectedStickersToDelete;
        Set<Asset> set2 = this.selectedStickersToSave;
        boolean z = this.isEditMode;
        IMToast iMToast = this.toast;
        boolean z2 = this.isShowConfirmDeleteDialog;
        return "StickerManagerData(mid=" + j2 + ", stickerList=" + list + ", selectedStickersToDelete=" + set + ", selectedStickersToSave=" + set2 + ", isEditMode=" + z + ", toast=" + iMToast + ", isShowConfirmDeleteDialog=" + z2 + ", saved=" + this.saved + ")";
    }

    public StickerManagerData(long mid, List<StickerAsset> list, Set<StickerAsset> set, Set<? extends Asset> set2, boolean isEditMode, IMToast toast, boolean isShowConfirmDeleteDialog, boolean saved) {
        Intrinsics.checkNotNullParameter(list, "stickerList");
        Intrinsics.checkNotNullParameter(set, "selectedStickersToDelete");
        Intrinsics.checkNotNullParameter(set2, "selectedStickersToSave");
        this.mid = mid;
        this.stickerList = list;
        this.selectedStickersToDelete = set;
        this.selectedStickersToSave = set2;
        this.isEditMode = isEditMode;
        this.toast = toast;
        this.isShowConfirmDeleteDialog = isShowConfirmDeleteDialog;
        this.saved = saved;
    }

    public /* synthetic */ StickerManagerData(long j2, List list, Set set, Set set2, boolean z, IMToast iMToast, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j2, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? SetsKt.emptySet() : set, (i & 8) != 0 ? SetsKt.emptySet() : set2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : iMToast, (i & 64) != 0 ? false : z2, (i & 128) == 0 ? z3 : false);
    }

    public final long getMid() {
        return this.mid;
    }

    public final List<StickerAsset> getStickerList() {
        return this.stickerList;
    }

    public final Set<StickerAsset> getSelectedStickersToDelete() {
        return this.selectedStickersToDelete;
    }

    public final Set<Asset> getSelectedStickersToSave() {
        return this.selectedStickersToSave;
    }

    public final boolean isEditMode() {
        return this.isEditMode;
    }

    public final IMToast getToast() {
        return this.toast;
    }

    public final boolean isShowConfirmDeleteDialog() {
        return this.isShowConfirmDeleteDialog;
    }

    public final boolean getSaved() {
        return this.saved;
    }

    public final int getSelectedStickerToDeleteSize() {
        return this.selectedStickersToDelete.size();
    }
}