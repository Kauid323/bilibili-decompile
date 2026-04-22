package kntr.common.ouro.core.plugin.remoteImage;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroRemoteImageAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImageAction;", "Lkntr/common/ouro/core/action/OuroAction;", "InsertInlineImage", "InsertBlockImage", "Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImageAction$InsertBlockImage;", "Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImageAction$InsertInlineImage;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroRemoteImageAction extends OuroAction {

    /* compiled from: OuroRemoteImageAction.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImageAction$InsertInlineImage;", "Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImageAction;", "lightImageURL", "", "darkImageURL", "displayWidth", "", "displayHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;FF)V", "url", "(Ljava/lang/String;FF)V", "getLightImageURL", "()Ljava/lang/String;", "getDarkImageURL", "getDisplayWidth", "()F", "getDisplayHeight", "storage", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/drawable/OuroInlineContent;", "getStorage$core_debug", "()Lkntr/common/ouro/core/model/NodeStorage;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InsertInlineImage implements OuroRemoteImageAction {
        private final String darkImageURL;
        private final float displayHeight;
        private final float displayWidth;
        private final String lightImageURL;

        public static /* synthetic */ InsertInlineImage copy$default(InsertInlineImage insertInlineImage, String str, String str2, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = insertInlineImage.lightImageURL;
            }
            if ((i & 2) != 0) {
                str2 = insertInlineImage.darkImageURL;
            }
            if ((i & 4) != 0) {
                f = insertInlineImage.displayWidth;
            }
            if ((i & 8) != 0) {
                f2 = insertInlineImage.displayHeight;
            }
            return insertInlineImage.copy(str, str2, f, f2);
        }

        public final String component1() {
            return this.lightImageURL;
        }

        public final String component2() {
            return this.darkImageURL;
        }

        public final float component3() {
            return this.displayWidth;
        }

        public final float component4() {
            return this.displayHeight;
        }

        public final InsertInlineImage copy(String str, String str2, float f, float f2) {
            Intrinsics.checkNotNullParameter(str, "lightImageURL");
            Intrinsics.checkNotNullParameter(str2, "darkImageURL");
            return new InsertInlineImage(str, str2, f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InsertInlineImage) {
                InsertInlineImage insertInlineImage = (InsertInlineImage) obj;
                return Intrinsics.areEqual(this.lightImageURL, insertInlineImage.lightImageURL) && Intrinsics.areEqual(this.darkImageURL, insertInlineImage.darkImageURL) && Float.compare(this.displayWidth, insertInlineImage.displayWidth) == 0 && Float.compare(this.displayHeight, insertInlineImage.displayHeight) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.lightImageURL.hashCode() * 31) + this.darkImageURL.hashCode()) * 31) + Float.floatToIntBits(this.displayWidth)) * 31) + Float.floatToIntBits(this.displayHeight);
        }

        public String toString() {
            String str = this.lightImageURL;
            String str2 = this.darkImageURL;
            float f = this.displayWidth;
            return "InsertInlineImage(lightImageURL=" + str + ", darkImageURL=" + str2 + ", displayWidth=" + f + ", displayHeight=" + this.displayHeight + ")";
        }

        public InsertInlineImage(String lightImageURL, String darkImageURL, float displayWidth, float displayHeight) {
            Intrinsics.checkNotNullParameter(lightImageURL, "lightImageURL");
            Intrinsics.checkNotNullParameter(darkImageURL, "darkImageURL");
            this.lightImageURL = lightImageURL;
            this.darkImageURL = darkImageURL;
            this.displayWidth = displayWidth;
            this.displayHeight = displayHeight;
        }

        public final String getLightImageURL() {
            return this.lightImageURL;
        }

        public final String getDarkImageURL() {
            return this.darkImageURL;
        }

        public final float getDisplayWidth() {
            return this.displayWidth;
        }

        public final float getDisplayHeight() {
            return this.displayHeight;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public InsertInlineImage(String url, float displayWidth, float displayHeight) {
            this(url, url, displayWidth, displayHeight);
            Intrinsics.checkNotNullParameter(url, "url");
        }

        public final NodeStorage<OuroInlineContent> getStorage$core_debug() {
            NodeStorageBuilder $this$_get_storage__u24lambda_u240 = new NodeStorageBuilder(new OuroInlineContent(new OuroMarks(new OuroDrawableMark.Size.Specified(this.displayWidth, this.displayHeight))), null, null, 6, null);
            $this$_get_storage__u24lambda_u240.addChild((OuroNode.Parent<T>) $this$_get_storage__u24lambda_u240.getRoot(), (T) new OuroRemoteImage.Image(this.lightImageURL, this.darkImageURL, (int) this.displayWidth, (int) this.displayHeight, (String) null, 0, 48, (DefaultConstructorMarker) null));
            return OuroNodeMutableStorage.CC.build$default($this$_get_storage__u24lambda_u240, false, 1, null);
        }
    }

    /* compiled from: OuroRemoteImageAction.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImageAction$InsertBlockImage;", "Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImageAction;", "lightImageURL", "", "darkImageURL", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "url", "(Ljava/lang/String;II)V", "getLightImageURL", "()Ljava/lang/String;", "getDarkImageURL", "getWidth", "()I", "getHeight", "storage", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/drawable/OuroBoxContainer;", "getStorage$core_debug", "()Lkntr/common/ouro/core/model/NodeStorage;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InsertBlockImage implements OuroRemoteImageAction {
        private final String darkImageURL;
        private final int height;
        private final String lightImageURL;
        private final int width;

        public static /* synthetic */ InsertBlockImage copy$default(InsertBlockImage insertBlockImage, String str, String str2, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = insertBlockImage.lightImageURL;
            }
            if ((i3 & 2) != 0) {
                str2 = insertBlockImage.darkImageURL;
            }
            if ((i3 & 4) != 0) {
                i = insertBlockImage.width;
            }
            if ((i3 & 8) != 0) {
                i2 = insertBlockImage.height;
            }
            return insertBlockImage.copy(str, str2, i, i2);
        }

        public final String component1() {
            return this.lightImageURL;
        }

        public final String component2() {
            return this.darkImageURL;
        }

        public final int component3() {
            return this.width;
        }

        public final int component4() {
            return this.height;
        }

        public final InsertBlockImage copy(String str, String str2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "lightImageURL");
            Intrinsics.checkNotNullParameter(str2, "darkImageURL");
            return new InsertBlockImage(str, str2, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InsertBlockImage) {
                InsertBlockImage insertBlockImage = (InsertBlockImage) obj;
                return Intrinsics.areEqual(this.lightImageURL, insertBlockImage.lightImageURL) && Intrinsics.areEqual(this.darkImageURL, insertBlockImage.darkImageURL) && this.width == insertBlockImage.width && this.height == insertBlockImage.height;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.lightImageURL.hashCode() * 31) + this.darkImageURL.hashCode()) * 31) + this.width) * 31) + this.height;
        }

        public String toString() {
            String str = this.lightImageURL;
            String str2 = this.darkImageURL;
            int i = this.width;
            return "InsertBlockImage(lightImageURL=" + str + ", darkImageURL=" + str2 + ", width=" + i + ", height=" + this.height + ")";
        }

        public InsertBlockImage(String lightImageURL, String darkImageURL, int width, int height) {
            Intrinsics.checkNotNullParameter(lightImageURL, "lightImageURL");
            Intrinsics.checkNotNullParameter(darkImageURL, "darkImageURL");
            this.lightImageURL = lightImageURL;
            this.darkImageURL = darkImageURL;
            this.width = width;
            this.height = height;
        }

        public final String getLightImageURL() {
            return this.lightImageURL;
        }

        public final String getDarkImageURL() {
            return this.darkImageURL;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public InsertBlockImage(String url, int width, int height) {
            this(url, url, width, height);
            Intrinsics.checkNotNullParameter(url, "url");
        }

        public final NodeStorage<OuroBoxContainer> getStorage$core_debug() {
            NodeStorageBuilder $this$_get_storage__u24lambda_u240 = new NodeStorageBuilder(new OuroBoxContainer(new OuroMarks(new OuroDrawableMark.Size.BiliBlockImageSize(this.width, this.height), new OuroDrawableMark.Padding(4.0f))), null, null, 6, null);
            $this$_get_storage__u24lambda_u240.addChild((OuroNode.Parent<T>) $this$_get_storage__u24lambda_u240.getRoot(), (T) new OuroRemoteImage.Image(this.lightImageURL, this.darkImageURL, this.width, this.height, (String) null, 0, 48, (DefaultConstructorMarker) null));
            return OuroNodeMutableStorage.CC.build$default($this$_get_storage__u24lambda_u240, false, 1, null);
        }
    }
}