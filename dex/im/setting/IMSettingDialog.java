package im.setting;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006!"}, d2 = {"Lim/setting/IMSettingDialog;", "", "title", "", "subtitle", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "confirmAction", "Lim/setting/IMSettingAction;", "cancelAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KIMSettingType;Lim/setting/IMSettingAction;Lim/setting/IMSettingAction;)V", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getConfirmAction", "()Lim/setting/IMSettingAction;", "getCancelAction", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingDialog {
    private final IMSettingAction cancelAction;
    private final IMSettingAction confirmAction;
    private final String subtitle;
    private final String title;
    private final KIMSettingType type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ IMSettingDialog copy$default(IMSettingDialog iMSettingDialog, String str, String str2, KIMSettingType kIMSettingType, IMSettingAction iMSettingAction, IMSettingAction iMSettingAction2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = iMSettingDialog.title;
        }
        if ((i2 & 2) != 0) {
            str2 = iMSettingDialog.subtitle;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            kIMSettingType = iMSettingDialog.type;
        }
        KIMSettingType kIMSettingType2 = kIMSettingType;
        if ((i2 & 8) != 0) {
            iMSettingAction = iMSettingDialog.confirmAction;
        }
        IMSettingAction iMSettingAction3 = iMSettingAction;
        if ((i2 & 16) != 0) {
            iMSettingAction2 = iMSettingDialog.cancelAction;
        }
        return iMSettingDialog.copy(str, str3, kIMSettingType2, iMSettingAction3, iMSettingAction2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subtitle;
    }

    public final KIMSettingType component3() {
        return this.type;
    }

    public final IMSettingAction component4() {
        return this.confirmAction;
    }

    public final IMSettingAction component5() {
        return this.cancelAction;
    }

    public final IMSettingDialog copy(String str, String str2, KIMSettingType kIMSettingType, IMSettingAction iMSettingAction, IMSettingAction iMSettingAction2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subtitle");
        Intrinsics.checkNotNullParameter(kIMSettingType, "type");
        Intrinsics.checkNotNullParameter(iMSettingAction, "confirmAction");
        Intrinsics.checkNotNullParameter(iMSettingAction2, "cancelAction");
        return new IMSettingDialog(str, str2, kIMSettingType, iMSettingAction, iMSettingAction2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSettingDialog) {
            IMSettingDialog iMSettingDialog = (IMSettingDialog) obj;
            return Intrinsics.areEqual(this.title, iMSettingDialog.title) && Intrinsics.areEqual(this.subtitle, iMSettingDialog.subtitle) && Intrinsics.areEqual(this.type, iMSettingDialog.type) && Intrinsics.areEqual(this.confirmAction, iMSettingDialog.confirmAction) && Intrinsics.areEqual(this.cancelAction, iMSettingDialog.cancelAction);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.type.hashCode()) * 31) + this.confirmAction.hashCode()) * 31) + this.cancelAction.hashCode();
    }

    public String toString() {
        String str = this.title;
        String str2 = this.subtitle;
        KIMSettingType kIMSettingType = this.type;
        IMSettingAction iMSettingAction = this.confirmAction;
        return "IMSettingDialog(title=" + str + ", subtitle=" + str2 + ", type=" + kIMSettingType + ", confirmAction=" + iMSettingAction + ", cancelAction=" + this.cancelAction + ")";
    }

    public IMSettingDialog(String title, String subtitle, KIMSettingType type, IMSettingAction confirmAction, IMSettingAction cancelAction) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(confirmAction, "confirmAction");
        Intrinsics.checkNotNullParameter(cancelAction, "cancelAction");
        this.title = title;
        this.subtitle = subtitle;
        this.type = type;
        this.confirmAction = confirmAction;
        this.cancelAction = cancelAction;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final KIMSettingType getType() {
        return this.type;
    }

    public final IMSettingAction getConfirmAction() {
        return this.confirmAction;
    }

    public final IMSettingAction getCancelAction() {
        return this.cancelAction;
    }

    /* compiled from: IMSettingState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/setting/IMSettingDialog$Companion;", "", "<init>", "()V", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}