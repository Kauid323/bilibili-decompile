package kntr.common.photonic.aphro.core.assets;

import com.bilibili.blens.Lens;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: AphroAssetsState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "getAlbumInfo", "()Lkntr/common/photonic/AlbumInfo;", "Init", "LoadingAssets", "AphroContent", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$AphroContent;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$Init;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$LoadingAssets;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AphroAssetsState {
    AlbumInfo getAlbumInfo();

    /* compiled from: AphroAssetsState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$Init;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "requiredAssetCount", "", "<init>", "(Lkntr/common/photonic/AlbumInfo;I)V", "getAlbumInfo", "()Lkntr/common/photonic/AlbumInfo;", "getRequiredAssetCount", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Lens
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Init implements AphroAssetsState {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final AlbumInfo albumInfo;
        private final int requiredAssetCount;

        public static /* synthetic */ Init copy$default(Init init, AlbumInfo albumInfo, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                albumInfo = init.albumInfo;
            }
            if ((i2 & 2) != 0) {
                i = init.requiredAssetCount;
            }
            return init.copy(albumInfo, i);
        }

        public final AlbumInfo component1() {
            return this.albumInfo;
        }

        public final int component2() {
            return this.requiredAssetCount;
        }

        public final Init copy(AlbumInfo albumInfo, int i) {
            return new Init(albumInfo, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Init) {
                Init init = (Init) obj;
                return Intrinsics.areEqual(this.albumInfo, init.albumInfo) && this.requiredAssetCount == init.requiredAssetCount;
            }
            return false;
        }

        public int hashCode() {
            return ((this.albumInfo == null ? 0 : this.albumInfo.hashCode()) * 31) + this.requiredAssetCount;
        }

        public String toString() {
            AlbumInfo albumInfo = this.albumInfo;
            return "Init(albumInfo=" + albumInfo + ", requiredAssetCount=" + this.requiredAssetCount + ")";
        }

        public Init(AlbumInfo albumInfo, int requiredAssetCount) {
            this.albumInfo = albumInfo;
            this.requiredAssetCount = requiredAssetCount;
        }

        public /* synthetic */ Init(AlbumInfo albumInfo, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(albumInfo, (i2 & 2) != 0 ? -1 : i);
        }

        @Override // kntr.common.photonic.aphro.core.assets.AphroAssetsState
        public AlbumInfo getAlbumInfo() {
            return this.albumInfo;
        }

        public final int getRequiredAssetCount() {
            return this.requiredAssetCount;
        }

        /* compiled from: AphroAssetsState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$Init$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: AphroAssetsState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$LoadingAssets;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "requiredAssetCount", "", "<init>", "(Lkntr/common/photonic/AlbumInfo;I)V", "getAlbumInfo", "()Lkntr/common/photonic/AlbumInfo;", "getRequiredAssetCount", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Lens
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadingAssets implements AphroAssetsState {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final AlbumInfo albumInfo;
        private final int requiredAssetCount;

        public static /* synthetic */ LoadingAssets copy$default(LoadingAssets loadingAssets, AlbumInfo albumInfo, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                albumInfo = loadingAssets.albumInfo;
            }
            if ((i2 & 2) != 0) {
                i = loadingAssets.requiredAssetCount;
            }
            return loadingAssets.copy(albumInfo, i);
        }

        public final AlbumInfo component1() {
            return this.albumInfo;
        }

        public final int component2() {
            return this.requiredAssetCount;
        }

        public final LoadingAssets copy(AlbumInfo albumInfo, int i) {
            return new LoadingAssets(albumInfo, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadingAssets) {
                LoadingAssets loadingAssets = (LoadingAssets) obj;
                return Intrinsics.areEqual(this.albumInfo, loadingAssets.albumInfo) && this.requiredAssetCount == loadingAssets.requiredAssetCount;
            }
            return false;
        }

        public int hashCode() {
            return ((this.albumInfo == null ? 0 : this.albumInfo.hashCode()) * 31) + this.requiredAssetCount;
        }

        public String toString() {
            AlbumInfo albumInfo = this.albumInfo;
            return "LoadingAssets(albumInfo=" + albumInfo + ", requiredAssetCount=" + this.requiredAssetCount + ")";
        }

        public LoadingAssets(AlbumInfo albumInfo, int requiredAssetCount) {
            this.albumInfo = albumInfo;
            this.requiredAssetCount = requiredAssetCount;
        }

        public /* synthetic */ LoadingAssets(AlbumInfo albumInfo, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(albumInfo, (i2 & 2) != 0 ? -1 : i);
        }

        @Override // kntr.common.photonic.aphro.core.assets.AphroAssetsState
        public AlbumInfo getAlbumInfo() {
            return this.albumInfo;
        }

        public final int getRequiredAssetCount() {
            return this.requiredAssetCount;
        }

        /* compiled from: AphroAssetsState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$LoadingAssets$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: AphroAssetsState.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001c\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$AphroContent;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "reader", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkntr/common/photonic/Asset;", "assetList", "<init>", "(Lkntr/common/photonic/AlbumInfo;Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/List;)V", "getAlbumInfo", "()Lkntr/common/photonic/AlbumInfo;", "getReader$core_debug", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "getAssetList", "()Ljava/util/List;", "component1", "component2", "component2$core_debug", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Lens
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AphroContent implements AphroAssetsState {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final AlbumInfo albumInfo;
        private final List<Asset> assetList;
        private final ReceiveChannel<List<Asset>> reader;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AphroContent copy$default(AphroContent aphroContent, AlbumInfo albumInfo, ReceiveChannel receiveChannel, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                albumInfo = aphroContent.albumInfo;
            }
            if ((i & 2) != 0) {
                receiveChannel = aphroContent.reader;
            }
            if ((i & 4) != 0) {
                list = aphroContent.assetList;
            }
            return aphroContent.copy(albumInfo, receiveChannel, list);
        }

        public final AlbumInfo component1() {
            return this.albumInfo;
        }

        public final ReceiveChannel<List<Asset>> component2$core_debug() {
            return this.reader;
        }

        public final List<Asset> component3() {
            return this.assetList;
        }

        public final AphroContent copy(AlbumInfo albumInfo, ReceiveChannel<? extends List<? extends Asset>> receiveChannel, List<? extends Asset> list) {
            Intrinsics.checkNotNullParameter(list, "assetList");
            return new AphroContent(albumInfo, receiveChannel, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AphroContent) {
                AphroContent aphroContent = (AphroContent) obj;
                return Intrinsics.areEqual(this.albumInfo, aphroContent.albumInfo) && Intrinsics.areEqual(this.reader, aphroContent.reader) && Intrinsics.areEqual(this.assetList, aphroContent.assetList);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.albumInfo == null ? 0 : this.albumInfo.hashCode()) * 31) + (this.reader != null ? this.reader.hashCode() : 0)) * 31) + this.assetList.hashCode();
        }

        public String toString() {
            AlbumInfo albumInfo = this.albumInfo;
            ReceiveChannel<List<Asset>> receiveChannel = this.reader;
            return "AphroContent(albumInfo=" + albumInfo + ", reader=" + receiveChannel + ", assetList=" + this.assetList + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AphroContent(AlbumInfo albumInfo, ReceiveChannel<? extends List<? extends Asset>> receiveChannel, List<? extends Asset> list) {
            Intrinsics.checkNotNullParameter(list, "assetList");
            this.albumInfo = albumInfo;
            this.reader = receiveChannel;
            this.assetList = list;
        }

        @Override // kntr.common.photonic.aphro.core.assets.AphroAssetsState
        public AlbumInfo getAlbumInfo() {
            return this.albumInfo;
        }

        public final ReceiveChannel<List<Asset>> getReader$core_debug() {
            return this.reader;
        }

        public final List<Asset> getAssetList() {
            return this.assetList;
        }

        /* compiled from: AphroAssetsState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$AphroContent$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}