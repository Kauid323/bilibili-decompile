package kntr.common.ouro.core.plugin.localImage;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.model.node.renderable.OuroLocalImage;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroLocalImageAction.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction;", "Lkntr/common/ouro/core/action/OuroAction;", "InsertBlockImage", "RetryUploadImage", "StartUploadImage", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction$InsertBlockImage;", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction$RetryUploadImage;", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction$StartUploadImage;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroLocalImageAction extends OuroAction {

    /* compiled from: OuroLocalImageAction.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001e"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction$InsertBlockImage;", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction;", "assets", "", "Lkntr/common/photonic/Asset;", "useOriginalImage", "", "shouldUploadImmediately", "<init>", "(Ljava/util/List;ZZ)V", "getAssets", "()Ljava/util/List;", "getUseOriginalImage", "()Z", "getShouldUploadImmediately", "storages", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/drawable/OuroBoxContainer;", "getStorages$core_debug", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InsertBlockImage implements OuroLocalImageAction {
        private final List<Asset> assets;
        private final boolean shouldUploadImmediately;
        private final boolean useOriginalImage;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InsertBlockImage copy$default(InsertBlockImage insertBlockImage, List list, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = insertBlockImage.assets;
            }
            if ((i & 2) != 0) {
                z = insertBlockImage.useOriginalImage;
            }
            if ((i & 4) != 0) {
                z2 = insertBlockImage.shouldUploadImmediately;
            }
            return insertBlockImage.copy(list, z, z2);
        }

        public final List<Asset> component1() {
            return this.assets;
        }

        public final boolean component2() {
            return this.useOriginalImage;
        }

        public final boolean component3() {
            return this.shouldUploadImmediately;
        }

        public final InsertBlockImage copy(List<? extends Asset> list, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(list, "assets");
            return new InsertBlockImage(list, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InsertBlockImage) {
                InsertBlockImage insertBlockImage = (InsertBlockImage) obj;
                return Intrinsics.areEqual(this.assets, insertBlockImage.assets) && this.useOriginalImage == insertBlockImage.useOriginalImage && this.shouldUploadImmediately == insertBlockImage.shouldUploadImmediately;
            }
            return false;
        }

        public int hashCode() {
            return (((this.assets.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOriginalImage)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.shouldUploadImmediately);
        }

        public String toString() {
            List<Asset> list = this.assets;
            boolean z = this.useOriginalImage;
            return "InsertBlockImage(assets=" + list + ", useOriginalImage=" + z + ", shouldUploadImmediately=" + this.shouldUploadImmediately + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public InsertBlockImage(List<? extends Asset> list, boolean useOriginalImage, boolean shouldUploadImmediately) {
            Intrinsics.checkNotNullParameter(list, "assets");
            this.assets = list;
            this.useOriginalImage = useOriginalImage;
            this.shouldUploadImmediately = shouldUploadImmediately;
        }

        public /* synthetic */ InsertBlockImage(List list, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, z, (i & 4) != 0 ? true : z2);
        }

        public final List<Asset> getAssets() {
            return this.assets;
        }

        public final boolean getUseOriginalImage() {
            return this.useOriginalImage;
        }

        public final boolean getShouldUploadImmediately() {
            return this.shouldUploadImmediately;
        }

        public final List<NodeStorage<OuroBoxContainer>> getStorages$core_debug() {
            InsertBlockImage insertBlockImage = this;
            Iterable $this$map$iv = insertBlockImage.assets;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Asset asset = (Asset) item$iv$iv;
                NodeStorageBuilder $this$_get_storages__u24lambda_u240_u240 = new NodeStorageBuilder(new OuroBoxContainer(new OuroMarks(new OuroDrawableMark.Size.BiliBlockImageSize(asset.getResolution().getWidthPx(), asset.getResolution().getHeightPx()), new OuroDrawableMark.Padding(4.0f))), null, null, 6, null);
                $this$_get_storages__u24lambda_u240_u240.addChild((OuroNode.Parent<T>) $this$_get_storages__u24lambda_u240_u240.getRoot(), (T) new OuroLocalImage(asset, insertBlockImage.useOriginalImage, (String) null, 4, (DefaultConstructorMarker) null));
                destination$iv$iv.add(OuroNodeMutableStorage.CC.build$default($this$_get_storages__u24lambda_u240_u240, false, 1, null));
                insertBlockImage = this;
                $this$map$iv = $this$map$iv;
            }
            return (List) destination$iv$iv;
        }
    }

    /* compiled from: OuroLocalImageAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction$RetryUploadImage;", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction;", "identifier", "", "<init>", "(Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RetryUploadImage implements OuroLocalImageAction {
        private final String identifier;

        public static /* synthetic */ RetryUploadImage copy$default(RetryUploadImage retryUploadImage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = retryUploadImage.identifier;
            }
            return retryUploadImage.copy(str);
        }

        public final String component1() {
            return this.identifier;
        }

        public final RetryUploadImage copy(String str) {
            Intrinsics.checkNotNullParameter(str, "identifier");
            return new RetryUploadImage(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RetryUploadImage) && Intrinsics.areEqual(this.identifier, ((RetryUploadImage) obj).identifier);
        }

        public int hashCode() {
            return this.identifier.hashCode();
        }

        public String toString() {
            return "RetryUploadImage(identifier=" + this.identifier + ")";
        }

        public RetryUploadImage(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
        }

        public final String getIdentifier() {
            return this.identifier;
        }
    }

    /* compiled from: OuroLocalImageAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\"\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÀ\u0001¢\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction$StartUploadImage;", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction;", "asset", "Lkntr/common/photonic/Asset;", "useOriginalImage", "", "<init>", "(Lkntr/common/photonic/Asset;Z)V", "getAsset", "()Lkntr/common/photonic/Asset;", "getUseOriginalImage", "()Z", "component1", "component2", "copy", "copy$core_debug", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class StartUploadImage implements OuroLocalImageAction {
        private final Asset asset;
        private final boolean useOriginalImage;

        public static /* synthetic */ StartUploadImage copy$core_debug$default(StartUploadImage startUploadImage, Asset asset, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                asset = startUploadImage.asset;
            }
            if ((i & 2) != 0) {
                z = startUploadImage.useOriginalImage;
            }
            return startUploadImage.copy$core_debug(asset, z);
        }

        public final Asset component1() {
            return this.asset;
        }

        public final boolean component2() {
            return this.useOriginalImage;
        }

        public final StartUploadImage copy$core_debug(Asset asset, boolean z) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            return new StartUploadImage(asset, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StartUploadImage) {
                StartUploadImage startUploadImage = (StartUploadImage) obj;
                return Intrinsics.areEqual(this.asset, startUploadImage.asset) && this.useOriginalImage == startUploadImage.useOriginalImage;
            }
            return false;
        }

        public int hashCode() {
            return (this.asset.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOriginalImage);
        }

        public String toString() {
            Asset asset = this.asset;
            return "StartUploadImage(asset=" + asset + ", useOriginalImage=" + this.useOriginalImage + ")";
        }

        public StartUploadImage(Asset asset, boolean useOriginalImage) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            this.asset = asset;
            this.useOriginalImage = useOriginalImage;
        }

        public final Asset getAsset() {
            return this.asset;
        }

        public final boolean getUseOriginalImage() {
            return this.useOriginalImage;
        }
    }
}