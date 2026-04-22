package im.setting;

import com.bilibili.blens.Lens;
import im.base.ContentStatus;
import im.base.ErrorContent;
import im.base.IMRouteHolder;
import im.base.IMToast;
import im.base.IdleContent;
import im.base.LoadingContent;
import im.setting.model.IMSettingPageData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingState.kt */
@Lens
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 02\u00020\u0001:\u00010BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b#J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0002\b%J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003JM\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Lim/setting/IMSettingState;", "", "type", "Lim/setting/IMSettingStateType;", UtilsKt.DATA_KEY, "Lim/setting/model/IMSettingPageData;", "toast", "Lim/base/IMToast;", "redirect", "Lim/base/IMRouteHolder;", "windowSelect", "Lim/setting/IMSettingWindowSelect;", "dialog", "Lim/setting/IMSettingDialog;", "<init>", "(Lim/setting/IMSettingStateType;Lim/setting/model/IMSettingPageData;Lim/base/IMToast;Lim/base/IMRouteHolder;Lim/setting/IMSettingWindowSelect;Lim/setting/IMSettingDialog;)V", "getType", "()Lim/setting/IMSettingStateType;", "getData", "()Lim/setting/model/IMSettingPageData;", "getToast$logic_debug", "()Lim/base/IMToast;", "getRedirect$logic_debug", "()Lim/base/IMRouteHolder;", "getWindowSelect", "()Lim/setting/IMSettingWindowSelect;", "getDialog", "()Lim/setting/IMSettingDialog;", "contentStatus", "Lim/base/ContentStatus;", "getContentStatus", "()Lim/base/ContentStatus;", "component1", "component2", "component3", "component3$logic_debug", "component4", "component4$logic_debug", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingState {
    private final IMSettingPageData data;
    private final IMSettingDialog dialog;
    private final IMRouteHolder redirect;
    private final IMToast toast;
    private final IMSettingStateType type;
    private final IMSettingWindowSelect windowSelect;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ IMSettingState copy$default(IMSettingState iMSettingState, IMSettingStateType iMSettingStateType, IMSettingPageData iMSettingPageData, IMToast iMToast, IMRouteHolder iMRouteHolder, IMSettingWindowSelect iMSettingWindowSelect, IMSettingDialog iMSettingDialog, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMSettingStateType = iMSettingState.type;
        }
        if ((i2 & 2) != 0) {
            iMSettingPageData = iMSettingState.data;
        }
        IMSettingPageData iMSettingPageData2 = iMSettingPageData;
        if ((i2 & 4) != 0) {
            iMToast = iMSettingState.toast;
        }
        IMToast iMToast2 = iMToast;
        if ((i2 & 8) != 0) {
            iMRouteHolder = iMSettingState.redirect;
        }
        IMRouteHolder iMRouteHolder2 = iMRouteHolder;
        if ((i2 & 16) != 0) {
            iMSettingWindowSelect = iMSettingState.windowSelect;
        }
        IMSettingWindowSelect iMSettingWindowSelect2 = iMSettingWindowSelect;
        if ((i2 & 32) != 0) {
            iMSettingDialog = iMSettingState.dialog;
        }
        return iMSettingState.copy(iMSettingStateType, iMSettingPageData2, iMToast2, iMRouteHolder2, iMSettingWindowSelect2, iMSettingDialog);
    }

    public final IMSettingStateType component1() {
        return this.type;
    }

    public final IMSettingPageData component2() {
        return this.data;
    }

    public final IMToast component3$logic_debug() {
        return this.toast;
    }

    public final IMRouteHolder component4$logic_debug() {
        return this.redirect;
    }

    public final IMSettingWindowSelect component5() {
        return this.windowSelect;
    }

    public final IMSettingDialog component6() {
        return this.dialog;
    }

    public final IMSettingState copy(IMSettingStateType iMSettingStateType, IMSettingPageData iMSettingPageData, IMToast iMToast, IMRouteHolder iMRouteHolder, IMSettingWindowSelect iMSettingWindowSelect, IMSettingDialog iMSettingDialog) {
        Intrinsics.checkNotNullParameter(iMSettingStateType, "type");
        Intrinsics.checkNotNullParameter(iMSettingPageData, UtilsKt.DATA_KEY);
        return new IMSettingState(iMSettingStateType, iMSettingPageData, iMToast, iMRouteHolder, iMSettingWindowSelect, iMSettingDialog);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSettingState) {
            IMSettingState iMSettingState = (IMSettingState) obj;
            return Intrinsics.areEqual(this.type, iMSettingState.type) && Intrinsics.areEqual(this.data, iMSettingState.data) && Intrinsics.areEqual(this.toast, iMSettingState.toast) && Intrinsics.areEqual(this.redirect, iMSettingState.redirect) && Intrinsics.areEqual(this.windowSelect, iMSettingState.windowSelect) && Intrinsics.areEqual(this.dialog, iMSettingState.dialog);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.type.hashCode() * 31) + this.data.hashCode()) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + (this.redirect == null ? 0 : this.redirect.hashCode())) * 31) + (this.windowSelect == null ? 0 : this.windowSelect.hashCode())) * 31) + (this.dialog != null ? this.dialog.hashCode() : 0);
    }

    public String toString() {
        IMSettingStateType iMSettingStateType = this.type;
        IMSettingPageData iMSettingPageData = this.data;
        IMToast iMToast = this.toast;
        IMRouteHolder iMRouteHolder = this.redirect;
        IMSettingWindowSelect iMSettingWindowSelect = this.windowSelect;
        return "IMSettingState(type=" + iMSettingStateType + ", data=" + iMSettingPageData + ", toast=" + iMToast + ", redirect=" + iMRouteHolder + ", windowSelect=" + iMSettingWindowSelect + ", dialog=" + this.dialog + ")";
    }

    public IMSettingState(IMSettingStateType type, IMSettingPageData data, IMToast toast, IMRouteHolder redirect, IMSettingWindowSelect windowSelect, IMSettingDialog dialog) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, UtilsKt.DATA_KEY);
        this.type = type;
        this.data = data;
        this.toast = toast;
        this.redirect = redirect;
        this.windowSelect = windowSelect;
        this.dialog = dialog;
    }

    public /* synthetic */ IMSettingState(IMSettingStateType iMSettingStateType, IMSettingPageData iMSettingPageData, IMToast iMToast, IMRouteHolder iMRouteHolder, IMSettingWindowSelect iMSettingWindowSelect, IMSettingDialog iMSettingDialog, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iMSettingStateType, iMSettingPageData, (i2 & 4) != 0 ? null : iMToast, (i2 & 8) != 0 ? null : iMRouteHolder, (i2 & 16) != 0 ? null : iMSettingWindowSelect, (i2 & 32) != 0 ? null : iMSettingDialog);
    }

    public final IMSettingStateType getType() {
        return this.type;
    }

    public final IMSettingPageData getData() {
        return this.data;
    }

    public final IMToast getToast$logic_debug() {
        return this.toast;
    }

    public final IMRouteHolder getRedirect$logic_debug() {
        return this.redirect;
    }

    public final IMSettingWindowSelect getWindowSelect() {
        return this.windowSelect;
    }

    public final IMSettingDialog getDialog() {
        return this.dialog;
    }

    /* compiled from: IMSettingState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/setting/IMSettingState$Companion;", "", "<init>", "()V", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ContentStatus getContentStatus() {
        return !this.data.getGroups().isEmpty() ? IdleContent.INSTANCE : this.type instanceof IMSettingStateTypeLoading ? LoadingContent.INSTANCE : this.type instanceof IMSettingStateTypeError ? new ErrorContent(((IMSettingStateTypeError) this.type).getError().getMessage()) : IdleContent.INSTANCE;
    }
}