package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.model;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CustomModeState.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\n\"\u0004\b\r\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/model/CustomModeState;", "", "customMode", "", "isFromPreviewPage", "previewPageChangeId", "", "<init>", "(ZZLjava/lang/String;)V", "getCustomMode", "()Z", "setCustomMode", "(Z)V", "setFromPreviewPage", "getPreviewPageChangeId", "()Ljava/lang/String;", "setPreviewPageChangeId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CustomModeState {
    public static final int $stable = 8;
    private boolean customMode;
    private boolean isFromPreviewPage;
    private String previewPageChangeId;

    public CustomModeState() {
        this(false, false, null, 7, null);
    }

    public static /* synthetic */ CustomModeState copy$default(CustomModeState customModeState, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = customModeState.customMode;
        }
        if ((i & 2) != 0) {
            z2 = customModeState.isFromPreviewPage;
        }
        if ((i & 4) != 0) {
            str = customModeState.previewPageChangeId;
        }
        return customModeState.copy(z, z2, str);
    }

    public final boolean component1() {
        return this.customMode;
    }

    public final boolean component2() {
        return this.isFromPreviewPage;
    }

    public final String component3() {
        return this.previewPageChangeId;
    }

    public final CustomModeState copy(boolean z, boolean z2, String str) {
        return new CustomModeState(z, z2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomModeState) {
            CustomModeState customModeState = (CustomModeState) obj;
            return this.customMode == customModeState.customMode && this.isFromPreviewPage == customModeState.isFromPreviewPage && Intrinsics.areEqual(this.previewPageChangeId, customModeState.previewPageChangeId);
        }
        return false;
    }

    public int hashCode() {
        return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.customMode) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFromPreviewPage)) * 31) + (this.previewPageChangeId == null ? 0 : this.previewPageChangeId.hashCode());
    }

    public String toString() {
        boolean z = this.customMode;
        boolean z2 = this.isFromPreviewPage;
        return "CustomModeState(customMode=" + z + ", isFromPreviewPage=" + z2 + ", previewPageChangeId=" + this.previewPageChangeId + ")";
    }

    public CustomModeState(boolean customMode, boolean isFromPreviewPage, String previewPageChangeId) {
        this.customMode = customMode;
        this.isFromPreviewPage = isFromPreviewPage;
        this.previewPageChangeId = previewPageChangeId;
    }

    public /* synthetic */ CustomModeState(boolean z, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : str);
    }

    public final boolean getCustomMode() {
        return this.customMode;
    }

    public final String getPreviewPageChangeId() {
        return this.previewPageChangeId;
    }

    public final boolean isFromPreviewPage() {
        return this.isFromPreviewPage;
    }

    public final void setCustomMode(boolean z) {
        this.customMode = z;
    }

    public final void setFromPreviewPage(boolean z) {
        this.isFromPreviewPage = z;
    }

    public final void setPreviewPageChangeId(String str) {
        this.previewPageChangeId = str;
    }
}