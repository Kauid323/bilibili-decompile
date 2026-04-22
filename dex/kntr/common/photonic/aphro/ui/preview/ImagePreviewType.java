package kntr.common.photonic.aphro.ui.preview;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;

/* compiled from: ImagePreviewLauncher.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType;", "", "Default", "Gallery", "Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType$Default;", "Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType$Gallery;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ImagePreviewType {

    /* compiled from: ImagePreviewLauncher.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType$Default;", "Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Default implements ImagePreviewType {
        public static final int $stable = 0;
        public static final Default INSTANCE = new Default();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Default) {
                Default r1 = (Default) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1150787392;
        }

        public String toString() {
            return "Default";
        }

        private Default() {
        }
    }

    /* compiled from: ImagePreviewLauncher.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType$Gallery;", "Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType;", "selectedAssets", "", "Lkntr/common/photonic/Asset;", "useOriginImage", "", "selectOption", "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "selectMatchKey", "", "<init>", "(Ljava/util/List;ZLkntr/common/photonic/aphro/core/AphroSelectOption;Ljava/lang/String;)V", "getSelectedAssets", "()Ljava/util/List;", "getUseOriginImage", "()Z", "getSelectOption", "()Lkntr/common/photonic/aphro/core/AphroSelectOption;", "getSelectMatchKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Gallery implements ImagePreviewType {
        public static final int $stable = 8;
        private final String selectMatchKey;
        private final AphroSelectOption selectOption;
        private final List<Asset> selectedAssets;
        private final boolean useOriginImage;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Gallery copy$default(Gallery gallery, List list, boolean z, AphroSelectOption aphroSelectOption, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = gallery.selectedAssets;
            }
            if ((i & 2) != 0) {
                z = gallery.useOriginImage;
            }
            if ((i & 4) != 0) {
                aphroSelectOption = gallery.selectOption;
            }
            if ((i & 8) != 0) {
                str = gallery.selectMatchKey;
            }
            return gallery.copy(list, z, aphroSelectOption, str);
        }

        public final List<Asset> component1() {
            return this.selectedAssets;
        }

        public final boolean component2() {
            return this.useOriginImage;
        }

        public final AphroSelectOption component3() {
            return this.selectOption;
        }

        public final String component4() {
            return this.selectMatchKey;
        }

        public final Gallery copy(List<? extends Asset> list, boolean z, AphroSelectOption aphroSelectOption, String str) {
            Intrinsics.checkNotNullParameter(list, "selectedAssets");
            Intrinsics.checkNotNullParameter(aphroSelectOption, "selectOption");
            Intrinsics.checkNotNullParameter(str, "selectMatchKey");
            return new Gallery(list, z, aphroSelectOption, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Gallery) {
                Gallery gallery = (Gallery) obj;
                return Intrinsics.areEqual(this.selectedAssets, gallery.selectedAssets) && this.useOriginImage == gallery.useOriginImage && Intrinsics.areEqual(this.selectOption, gallery.selectOption) && Intrinsics.areEqual(this.selectMatchKey, gallery.selectMatchKey);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.selectedAssets.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOriginImage)) * 31) + this.selectOption.hashCode()) * 31) + this.selectMatchKey.hashCode();
        }

        public String toString() {
            List<Asset> list = this.selectedAssets;
            boolean z = this.useOriginImage;
            AphroSelectOption aphroSelectOption = this.selectOption;
            return "Gallery(selectedAssets=" + list + ", useOriginImage=" + z + ", selectOption=" + aphroSelectOption + ", selectMatchKey=" + this.selectMatchKey + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Gallery(List<? extends Asset> list, boolean useOriginImage, AphroSelectOption selectOption, String selectMatchKey) {
            Intrinsics.checkNotNullParameter(list, "selectedAssets");
            Intrinsics.checkNotNullParameter(selectOption, "selectOption");
            Intrinsics.checkNotNullParameter(selectMatchKey, "selectMatchKey");
            this.selectedAssets = list;
            this.useOriginImage = useOriginImage;
            this.selectOption = selectOption;
            this.selectMatchKey = selectMatchKey;
        }

        public /* synthetic */ Gallery(List list, boolean z, AphroSelectOption aphroSelectOption, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, z, aphroSelectOption, (i & 8) != 0 ? Uuid.Companion.random().toString() : str);
        }

        public final List<Asset> getSelectedAssets() {
            return this.selectedAssets;
        }

        public final boolean getUseOriginImage() {
            return this.useOriginImage;
        }

        public final AphroSelectOption getSelectOption() {
            return this.selectOption;
        }

        public final String getSelectMatchKey() {
            return this.selectMatchKey;
        }
    }
}