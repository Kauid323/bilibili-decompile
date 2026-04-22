package kntr.common.photonic.aphro.core;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroAction.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction;", "", "SwitchAlbum", "SelectAsset", "UnSelectAsset", "CheckUseOriginImage", "ClearSelectedAssets", "SetSelectedAssets", "RefreshAlbums", "LoadMoreAsset", "ConfirmSelection", "ConsumeConfirm", "Lkntr/common/photonic/aphro/core/AphroAction$CheckUseOriginImage;", "Lkntr/common/photonic/aphro/core/AphroAction$ClearSelectedAssets;", "Lkntr/common/photonic/aphro/core/AphroAction$ConfirmSelection;", "Lkntr/common/photonic/aphro/core/AphroAction$ConsumeConfirm;", "Lkntr/common/photonic/aphro/core/AphroAction$LoadMoreAsset;", "Lkntr/common/photonic/aphro/core/AphroAction$RefreshAlbums;", "Lkntr/common/photonic/aphro/core/AphroAction$SelectAsset;", "Lkntr/common/photonic/aphro/core/AphroAction$SetSelectedAssets;", "Lkntr/common/photonic/aphro/core/AphroAction$SwitchAlbum;", "Lkntr/common/photonic/aphro/core/AphroAction$UnSelectAsset;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AphroAction {

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$SwitchAlbum;", "Lkntr/common/photonic/aphro/core/AphroAction;", "album", "Lkntr/common/photonic/AlbumInfo;", "<init>", "(Lkntr/common/photonic/AlbumInfo;)V", "getAlbum", "()Lkntr/common/photonic/AlbumInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SwitchAlbum implements AphroAction {
        public static final int $stable = 8;
        private final AlbumInfo album;

        public static /* synthetic */ SwitchAlbum copy$default(SwitchAlbum switchAlbum, AlbumInfo albumInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                albumInfo = switchAlbum.album;
            }
            return switchAlbum.copy(albumInfo);
        }

        public final AlbumInfo component1() {
            return this.album;
        }

        public final SwitchAlbum copy(AlbumInfo albumInfo) {
            Intrinsics.checkNotNullParameter(albumInfo, "album");
            return new SwitchAlbum(albumInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchAlbum) && Intrinsics.areEqual(this.album, ((SwitchAlbum) obj).album);
        }

        public int hashCode() {
            return this.album.hashCode();
        }

        public String toString() {
            return "SwitchAlbum(album=" + this.album + ")";
        }

        public SwitchAlbum(AlbumInfo album) {
            Intrinsics.checkNotNullParameter(album, "album");
            this.album = album;
        }

        public final AlbumInfo getAlbum() {
            return this.album;
        }
    }

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$SelectAsset;", "Lkntr/common/photonic/aphro/core/AphroAction;", "asset", "Lkntr/common/photonic/Asset;", "<init>", "(Lkntr/common/photonic/Asset;)V", "getAsset", "()Lkntr/common/photonic/Asset;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectAsset implements AphroAction {
        public static final int $stable = 8;
        private final Asset asset;

        public static /* synthetic */ SelectAsset copy$default(SelectAsset selectAsset, Asset asset, int i, Object obj) {
            if ((i & 1) != 0) {
                asset = selectAsset.asset;
            }
            return selectAsset.copy(asset);
        }

        public final Asset component1() {
            return this.asset;
        }

        public final SelectAsset copy(Asset asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            return new SelectAsset(asset);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectAsset) && Intrinsics.areEqual(this.asset, ((SelectAsset) obj).asset);
        }

        public int hashCode() {
            return this.asset.hashCode();
        }

        public String toString() {
            return "SelectAsset(asset=" + this.asset + ")";
        }

        public SelectAsset(Asset asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            this.asset = asset;
        }

        public final Asset getAsset() {
            return this.asset;
        }
    }

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$UnSelectAsset;", "Lkntr/common/photonic/aphro/core/AphroAction;", "asset", "Lkntr/common/photonic/Asset;", "<init>", "(Lkntr/common/photonic/Asset;)V", "getAsset", "()Lkntr/common/photonic/Asset;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UnSelectAsset implements AphroAction {
        public static final int $stable = 8;
        private final Asset asset;

        public static /* synthetic */ UnSelectAsset copy$default(UnSelectAsset unSelectAsset, Asset asset, int i, Object obj) {
            if ((i & 1) != 0) {
                asset = unSelectAsset.asset;
            }
            return unSelectAsset.copy(asset);
        }

        public final Asset component1() {
            return this.asset;
        }

        public final UnSelectAsset copy(Asset asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            return new UnSelectAsset(asset);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UnSelectAsset) && Intrinsics.areEqual(this.asset, ((UnSelectAsset) obj).asset);
        }

        public int hashCode() {
            return this.asset.hashCode();
        }

        public String toString() {
            return "UnSelectAsset(asset=" + this.asset + ")";
        }

        public UnSelectAsset(Asset asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            this.asset = asset;
        }

        public final Asset getAsset() {
            return this.asset;
        }
    }

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$CheckUseOriginImage;", "Lkntr/common/photonic/aphro/core/AphroAction;", "useOriginImage", "", "<init>", "(Z)V", "getUseOriginImage", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CheckUseOriginImage implements AphroAction {
        public static final int $stable = 0;
        private final boolean useOriginImage;

        public static /* synthetic */ CheckUseOriginImage copy$default(CheckUseOriginImage checkUseOriginImage, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = checkUseOriginImage.useOriginImage;
            }
            return checkUseOriginImage.copy(z);
        }

        public final boolean component1() {
            return this.useOriginImage;
        }

        public final CheckUseOriginImage copy(boolean z) {
            return new CheckUseOriginImage(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CheckUseOriginImage) && this.useOriginImage == ((CheckUseOriginImage) obj).useOriginImage;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOriginImage);
        }

        public String toString() {
            return "CheckUseOriginImage(useOriginImage=" + this.useOriginImage + ")";
        }

        public CheckUseOriginImage(boolean useOriginImage) {
            this.useOriginImage = useOriginImage;
        }

        public final boolean getUseOriginImage() {
            return this.useOriginImage;
        }
    }

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$ClearSelectedAssets;", "Lkntr/common/photonic/aphro/core/AphroAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ClearSelectedAssets implements AphroAction {
        public static final int $stable = 0;
        public static final ClearSelectedAssets INSTANCE = new ClearSelectedAssets();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClearSelectedAssets) {
                ClearSelectedAssets clearSelectedAssets = (ClearSelectedAssets) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 840437684;
        }

        public String toString() {
            return "ClearSelectedAssets";
        }

        private ClearSelectedAssets() {
        }
    }

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$SetSelectedAssets;", "Lkntr/common/photonic/aphro/core/AphroAction;", "assets", "", "Lkntr/common/photonic/Asset;", "<init>", "(Ljava/util/List;)V", "getAssets", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SetSelectedAssets implements AphroAction {
        public static final int $stable = 8;
        private final List<Asset> assets;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SetSelectedAssets copy$default(SetSelectedAssets setSelectedAssets, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = setSelectedAssets.assets;
            }
            return setSelectedAssets.copy(list);
        }

        public final List<Asset> component1() {
            return this.assets;
        }

        public final SetSelectedAssets copy(List<? extends Asset> list) {
            Intrinsics.checkNotNullParameter(list, "assets");
            return new SetSelectedAssets(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SetSelectedAssets) && Intrinsics.areEqual(this.assets, ((SetSelectedAssets) obj).assets);
        }

        public int hashCode() {
            return this.assets.hashCode();
        }

        public String toString() {
            return "SetSelectedAssets(assets=" + this.assets + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SetSelectedAssets(List<? extends Asset> list) {
            Intrinsics.checkNotNullParameter(list, "assets");
            this.assets = list;
        }

        public final List<Asset> getAssets() {
            return this.assets;
        }
    }

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$RefreshAlbums;", "Lkntr/common/photonic/aphro/core/AphroAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RefreshAlbums implements AphroAction {
        public static final int $stable = 0;
        public static final RefreshAlbums INSTANCE = new RefreshAlbums();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RefreshAlbums) {
                RefreshAlbums refreshAlbums = (RefreshAlbums) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1272979608;
        }

        public String toString() {
            return "RefreshAlbums";
        }

        private RefreshAlbums() {
        }
    }

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$LoadMoreAsset;", "Lkntr/common/photonic/aphro/core/AphroAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadMoreAsset implements AphroAction {
        public static final int $stable = 0;
        public static final LoadMoreAsset INSTANCE = new LoadMoreAsset();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadMoreAsset) {
                LoadMoreAsset loadMoreAsset = (LoadMoreAsset) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -341185762;
        }

        public String toString() {
            return "LoadMoreAsset";
        }

        private LoadMoreAsset() {
        }
    }

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$ConfirmSelection;", "Lkntr/common/photonic/aphro/core/AphroAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ConfirmSelection implements AphroAction {
        public static final int $stable = 0;
        public static final ConfirmSelection INSTANCE = new ConfirmSelection();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ConfirmSelection) {
                ConfirmSelection confirmSelection = (ConfirmSelection) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1325252931;
        }

        public String toString() {
            return "ConfirmSelection";
        }

        private ConfirmSelection() {
        }
    }

    /* compiled from: AphroAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroAction$ConsumeConfirm;", "Lkntr/common/photonic/aphro/core/AphroAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ConsumeConfirm implements AphroAction {
        public static final int $stable = 0;
        public static final ConsumeConfirm INSTANCE = new ConsumeConfirm();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ConsumeConfirm) {
                ConsumeConfirm consumeConfirm = (ConsumeConfirm) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1168930949;
        }

        public String toString() {
            return "ConsumeConfirm";
        }

        private ConsumeConfirm() {
        }
    }
}