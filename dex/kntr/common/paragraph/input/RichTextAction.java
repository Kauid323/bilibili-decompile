package kntr.common.paragraph.input;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.AssetUploaderParams;
import kntr.common.paragraph.input.content.TextContent;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RichTextAction.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\t\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u0082\u0001\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction;", "", "TextChanged", "AddAsset", "RemoveAsset", "FocusOn", "FocusOnFirstText", "RetryFocusOn", "FocusOnTitle", "RetryAsset", "FocusConsumed", "Lkntr/common/paragraph/input/RichTextAction$AddAsset;", "Lkntr/common/paragraph/input/RichTextAction$FocusConsumed;", "Lkntr/common/paragraph/input/RichTextAction$FocusOn;", "Lkntr/common/paragraph/input/RichTextAction$FocusOnFirstText;", "Lkntr/common/paragraph/input/RichTextAction$FocusOnTitle;", "Lkntr/common/paragraph/input/RichTextAction$RemoveAsset;", "Lkntr/common/paragraph/input/RichTextAction$RetryAsset;", "Lkntr/common/paragraph/input/RichTextAction$RetryFocusOn;", "Lkntr/common/paragraph/input/RichTextAction$TextChanged;", "Lkntr/common/paragraph/input/StartAsset;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface RichTextAction {

    /* compiled from: RichTextAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction$TextChanged;", "Lkntr/common/paragraph/input/RichTextAction;", "text", "Lkntr/common/paragraph/input/content/TextContent;", "index", "", "<init>", "(Lkntr/common/paragraph/input/content/TextContent;I)V", "getText", "()Lkntr/common/paragraph/input/content/TextContent;", "getIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TextChanged implements RichTextAction {
        private final int index;
        private final TextContent text;

        public static /* synthetic */ TextChanged copy$default(TextChanged textChanged, TextContent textContent, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                textContent = textChanged.text;
            }
            if ((i2 & 2) != 0) {
                i = textChanged.index;
            }
            return textChanged.copy(textContent, i);
        }

        public final TextContent component1() {
            return this.text;
        }

        public final int component2() {
            return this.index;
        }

        public final TextChanged copy(TextContent textContent, int i) {
            Intrinsics.checkNotNullParameter(textContent, "text");
            return new TextChanged(textContent, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TextChanged) {
                TextChanged textChanged = (TextChanged) obj;
                return Intrinsics.areEqual(this.text, textChanged.text) && this.index == textChanged.index;
            }
            return false;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.index;
        }

        public String toString() {
            TextContent textContent = this.text;
            return "TextChanged(text=" + textContent + ", index=" + this.index + ")";
        }

        public TextChanged(TextContent text, int index) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.index = index;
        }

        public final TextContent getText() {
            return this.text;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    /* compiled from: RichTextAction.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB)\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\fJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction$AddAsset;", "Lkntr/common/paragraph/input/RichTextAction;", "asset", "", "Lkntr/common/paragraph/input/SelectedAsset;", "uploaderParams", "Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;", "<init>", "(Ljava/util/List;Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;)V", "Lkntr/common/photonic/Asset;", "useOrigin", "", "(Ljava/util/List;ZLkntr/common/paragraph/assetuploader/base/AssetUploaderParams;)V", "getAsset", "()Ljava/util/List;", "getUploaderParams", "()Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AddAsset implements RichTextAction {
        private final List<SelectedAsset> asset;
        private final AssetUploaderParams uploaderParams;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AddAsset copy$default(AddAsset addAsset, List list, AssetUploaderParams assetUploaderParams, int i, Object obj) {
            if ((i & 1) != 0) {
                list = addAsset.asset;
            }
            if ((i & 2) != 0) {
                assetUploaderParams = addAsset.uploaderParams;
            }
            return addAsset.copy(list, assetUploaderParams);
        }

        public final List<SelectedAsset> component1() {
            return this.asset;
        }

        public final AssetUploaderParams component2() {
            return this.uploaderParams;
        }

        public final AddAsset copy(List<SelectedAsset> list, AssetUploaderParams assetUploaderParams) {
            Intrinsics.checkNotNullParameter(list, "asset");
            return new AddAsset(list, assetUploaderParams);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AddAsset) {
                AddAsset addAsset = (AddAsset) obj;
                return Intrinsics.areEqual(this.asset, addAsset.asset) && Intrinsics.areEqual(this.uploaderParams, addAsset.uploaderParams);
            }
            return false;
        }

        public int hashCode() {
            return (this.asset.hashCode() * 31) + (this.uploaderParams == null ? 0 : this.uploaderParams.hashCode());
        }

        public String toString() {
            List<SelectedAsset> list = this.asset;
            return "AddAsset(asset=" + list + ", uploaderParams=" + this.uploaderParams + ")";
        }

        public AddAsset(List<SelectedAsset> list, AssetUploaderParams uploaderParams) {
            Intrinsics.checkNotNullParameter(list, "asset");
            this.asset = list;
            this.uploaderParams = uploaderParams;
        }

        public final List<SelectedAsset> getAsset() {
            return this.asset;
        }

        public final AssetUploaderParams getUploaderParams() {
            return this.uploaderParams;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AddAsset(List<? extends Asset> list, boolean useOrigin, AssetUploaderParams uploaderParams) {
            this((List) destination$iv$iv, uploaderParams);
            Intrinsics.checkNotNullParameter(list, "asset");
            List<? extends Asset> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Asset it = (Asset) item$iv$iv;
                destination$iv$iv.add(new SelectedAsset(it, useOrigin));
            }
        }
    }

    /* compiled from: RichTextAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction$RemoveAsset;", "Lkntr/common/paragraph/input/RichTextAction;", "index", "", "<init>", "(I)V", "getIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RemoveAsset implements RichTextAction {
        private final int index;

        public static /* synthetic */ RemoveAsset copy$default(RemoveAsset removeAsset, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = removeAsset.index;
            }
            return removeAsset.copy(i);
        }

        public final int component1() {
            return this.index;
        }

        public final RemoveAsset copy(int i) {
            return new RemoveAsset(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RemoveAsset) && this.index == ((RemoveAsset) obj).index;
        }

        public int hashCode() {
            return this.index;
        }

        public String toString() {
            return "RemoveAsset(index=" + this.index + ")";
        }

        public RemoveAsset(int index) {
            this.index = index;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    /* compiled from: RichTextAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction$FocusOn;", "Lkntr/common/paragraph/input/RichTextAction;", "paragraphIndex", "", "requestFocus", "", "<init>", "(IZ)V", "getParagraphIndex", "()I", "getRequestFocus", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FocusOn implements RichTextAction {
        private final int paragraphIndex;
        private final boolean requestFocus;

        public static /* synthetic */ FocusOn copy$default(FocusOn focusOn, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = focusOn.paragraphIndex;
            }
            if ((i2 & 2) != 0) {
                z = focusOn.requestFocus;
            }
            return focusOn.copy(i, z);
        }

        public final int component1() {
            return this.paragraphIndex;
        }

        public final boolean component2() {
            return this.requestFocus;
        }

        public final FocusOn copy(int i, boolean z) {
            return new FocusOn(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FocusOn) {
                FocusOn focusOn = (FocusOn) obj;
                return this.paragraphIndex == focusOn.paragraphIndex && this.requestFocus == focusOn.requestFocus;
            }
            return false;
        }

        public int hashCode() {
            return (this.paragraphIndex * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.requestFocus);
        }

        public String toString() {
            int i = this.paragraphIndex;
            return "FocusOn(paragraphIndex=" + i + ", requestFocus=" + this.requestFocus + ")";
        }

        public FocusOn(int paragraphIndex, boolean requestFocus) {
            this.paragraphIndex = paragraphIndex;
            this.requestFocus = requestFocus;
        }

        public /* synthetic */ FocusOn(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z);
        }

        public final int getParagraphIndex() {
            return this.paragraphIndex;
        }

        public final boolean getRequestFocus() {
            return this.requestFocus;
        }
    }

    /* compiled from: RichTextAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction$FocusOnFirstText;", "Lkntr/common/paragraph/input/RichTextAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FocusOnFirstText implements RichTextAction {
        public static final FocusOnFirstText INSTANCE = new FocusOnFirstText();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FocusOnFirstText) {
                FocusOnFirstText focusOnFirstText = (FocusOnFirstText) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 234310651;
        }

        public String toString() {
            return "FocusOnFirstText";
        }

        private FocusOnFirstText() {
        }
    }

    /* compiled from: RichTextAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction$RetryFocusOn;", "Lkntr/common/paragraph/input/RichTextAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RetryFocusOn implements RichTextAction {
        public static final RetryFocusOn INSTANCE = new RetryFocusOn();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RetryFocusOn) {
                RetryFocusOn retryFocusOn = (RetryFocusOn) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1175846236;
        }

        public String toString() {
            return "RetryFocusOn";
        }

        private RetryFocusOn() {
        }
    }

    /* compiled from: RichTextAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction$FocusOnTitle;", "Lkntr/common/paragraph/input/RichTextAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FocusOnTitle implements RichTextAction {
        public static final FocusOnTitle INSTANCE = new FocusOnTitle();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FocusOnTitle) {
                FocusOnTitle focusOnTitle = (FocusOnTitle) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 481651030;
        }

        public String toString() {
            return "FocusOnTitle";
        }

        private FocusOnTitle() {
        }
    }

    /* compiled from: RichTextAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction$RetryAsset;", "Lkntr/common/paragraph/input/RichTextAction;", "asset", "Lkntr/common/photonic/Asset;", "<init>", "(Lkntr/common/photonic/Asset;)V", "getAsset", "()Lkntr/common/photonic/Asset;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RetryAsset implements RichTextAction {
        private final Asset asset;

        public static /* synthetic */ RetryAsset copy$default(RetryAsset retryAsset, Asset asset, int i, Object obj) {
            if ((i & 1) != 0) {
                asset = retryAsset.asset;
            }
            return retryAsset.copy(asset);
        }

        public final Asset component1() {
            return this.asset;
        }

        public final RetryAsset copy(Asset asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            return new RetryAsset(asset);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RetryAsset) && Intrinsics.areEqual(this.asset, ((RetryAsset) obj).asset);
        }

        public int hashCode() {
            return this.asset.hashCode();
        }

        public String toString() {
            return "RetryAsset(asset=" + this.asset + ")";
        }

        public RetryAsset(Asset asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            this.asset = asset;
        }

        public final Asset getAsset() {
            return this.asset;
        }
    }

    /* compiled from: RichTextAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/common/paragraph/input/RichTextAction$FocusConsumed;", "Lkntr/common/paragraph/input/RichTextAction;", "index", "", "<init>", "(I)V", "getIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FocusConsumed implements RichTextAction {
        private final int index;

        public static /* synthetic */ FocusConsumed copy$default(FocusConsumed focusConsumed, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = focusConsumed.index;
            }
            return focusConsumed.copy(i);
        }

        public final int component1() {
            return this.index;
        }

        public final FocusConsumed copy(int i) {
            return new FocusConsumed(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FocusConsumed) && this.index == ((FocusConsumed) obj).index;
        }

        public int hashCode() {
            return this.index;
        }

        public String toString() {
            return "FocusConsumed(index=" + this.index + ")";
        }

        public FocusConsumed(int index) {
            this.index = index;
        }

        public final int getIndex() {
            return this.index;
        }
    }
}