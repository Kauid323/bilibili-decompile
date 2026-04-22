package kntr.app.im.chat.core.model;

import BottomSheetItemData$;
import com.bilibili.blens.Lens;
import java.util.List;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputBoxConfig.kt */
@Lens
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u0006\""}, d2 = {"Lkntr/app/im/chat/core/model/InputContent;", RoomRecommendViewModel.EMPTY_CURSOR, "inputBoxContent", "Lkntr/app/im/chat/db/model/InputBoxContent;", "selectedAssets", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/common/photonic/Asset;", "useOriginImage", RoomRecommendViewModel.EMPTY_CURSOR, "contentVersion", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/im/chat/db/model/InputBoxContent;Ljava/util/List;ZI)V", "getInputBoxContent", "()Lkntr/app/im/chat/db/model/InputBoxContent;", "getSelectedAssets", "()Ljava/util/List;", "getUseOriginImage", "()Z", "getContentVersion", "()I", "hasContent", "getHasContent", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InputContent {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int contentVersion;
    private final InputBoxContent inputBoxContent;
    private final List<Asset> selectedAssets;
    private final boolean useOriginImage;

    public InputContent() {
        this(null, null, false, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputContent copy$default(InputContent inputContent, InputBoxContent inputBoxContent, List list, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            inputBoxContent = inputContent.inputBoxContent;
        }
        if ((i2 & 2) != 0) {
            list = inputContent.selectedAssets;
        }
        if ((i2 & 4) != 0) {
            z = inputContent.useOriginImage;
        }
        if ((i2 & 8) != 0) {
            i = inputContent.contentVersion;
        }
        return inputContent.copy(inputBoxContent, list, z, i);
    }

    public final InputBoxContent component1() {
        return this.inputBoxContent;
    }

    public final List<Asset> component2() {
        return this.selectedAssets;
    }

    public final boolean component3() {
        return this.useOriginImage;
    }

    public final int component4() {
        return this.contentVersion;
    }

    public final InputContent copy(InputBoxContent inputBoxContent, List<? extends Asset> list, boolean z, int i) {
        Intrinsics.checkNotNullParameter(inputBoxContent, "inputBoxContent");
        Intrinsics.checkNotNullParameter(list, "selectedAssets");
        return new InputContent(inputBoxContent, list, z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InputContent) {
            InputContent inputContent = (InputContent) obj;
            return Intrinsics.areEqual(this.inputBoxContent, inputContent.inputBoxContent) && Intrinsics.areEqual(this.selectedAssets, inputContent.selectedAssets) && this.useOriginImage == inputContent.useOriginImage && this.contentVersion == inputContent.contentVersion;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.inputBoxContent.hashCode() * 31) + this.selectedAssets.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOriginImage)) * 31) + this.contentVersion;
    }

    public String toString() {
        InputBoxContent inputBoxContent = this.inputBoxContent;
        List<Asset> list = this.selectedAssets;
        boolean z = this.useOriginImage;
        return "InputContent(inputBoxContent=" + inputBoxContent + ", selectedAssets=" + list + ", useOriginImage=" + z + ", contentVersion=" + this.contentVersion + ")";
    }

    public InputContent(InputBoxContent inputBoxContent, List<? extends Asset> list, boolean useOriginImage, int contentVersion) {
        Intrinsics.checkNotNullParameter(inputBoxContent, "inputBoxContent");
        Intrinsics.checkNotNullParameter(list, "selectedAssets");
        this.inputBoxContent = inputBoxContent;
        this.selectedAssets = list;
        this.useOriginImage = useOriginImage;
        this.contentVersion = contentVersion;
    }

    public /* synthetic */ InputContent(InputBoxContent inputBoxContent, List list, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new InputBoxContent(null, 0, 0, null, 15, null) : inputBoxContent, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 0 : i);
    }

    public final InputBoxContent getInputBoxContent() {
        return this.inputBoxContent;
    }

    public final List<Asset> getSelectedAssets() {
        return this.selectedAssets;
    }

    public final boolean getUseOriginImage() {
        return this.useOriginImage;
    }

    public final int getContentVersion() {
        return this.contentVersion;
    }

    /* compiled from: InputBoxConfig.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/core/model/InputContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean getHasContent() {
        return (this.inputBoxContent.isBlank() && this.selectedAssets.isEmpty()) ? false : true;
    }
}