package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/FloatUiState;", "", "saveButtonEnable", "", "selectedCount", "", "<init>", "(ZI)V", "getSaveButtonEnable", "()Z", "getSelectedCount", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FloatUiState {
    public static final int $stable = 0;
    private final boolean saveButtonEnable;
    private final int selectedCount;

    public FloatUiState() {
        this(false, 0, 3, null);
    }

    public static /* synthetic */ FloatUiState copy$default(FloatUiState floatUiState, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = floatUiState.saveButtonEnable;
        }
        if ((i2 & 2) != 0) {
            i = floatUiState.selectedCount;
        }
        return floatUiState.copy(z, i);
    }

    public final boolean component1() {
        return this.saveButtonEnable;
    }

    public final int component2() {
        return this.selectedCount;
    }

    public final FloatUiState copy(boolean z, int i) {
        return new FloatUiState(z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FloatUiState) {
            FloatUiState floatUiState = (FloatUiState) obj;
            return this.saveButtonEnable == floatUiState.saveButtonEnable && this.selectedCount == floatUiState.selectedCount;
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.saveButtonEnable) * 31) + this.selectedCount;
    }

    public String toString() {
        boolean z = this.saveButtonEnable;
        return "FloatUiState(saveButtonEnable=" + z + ", selectedCount=" + this.selectedCount + ")";
    }

    public FloatUiState(boolean saveButtonEnable, int selectedCount) {
        this.saveButtonEnable = saveButtonEnable;
        this.selectedCount = selectedCount;
    }

    public /* synthetic */ FloatUiState(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
    }

    public final boolean getSaveButtonEnable() {
        return this.saveButtonEnable;
    }

    public final int getSelectedCount() {
        return this.selectedCount;
    }
}