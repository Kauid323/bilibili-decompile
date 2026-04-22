package usercenter;

import BottomSheetItemData$;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UserHandleModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lusercenter/UserHandleModel;", "Ljava/io/Serializable;", "handle", "", "editable", "", "ruleMessage", "confirmMessage", "submittedMessage", "bindTelUrl", "maxLength", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getHandle", "()Ljava/lang/String;", "getEditable", "()Z", "getRuleMessage", "getConfirmMessage", "getSubmittedMessage", "getBindTelUrl", "getMaxLength", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UserHandleModel implements Serializable {
    public static final int $stable = 0;
    private final String bindTelUrl;
    private final String confirmMessage;
    private final boolean editable;
    private final String handle;
    private final int maxLength;
    private final String ruleMessage;
    private final String submittedMessage;

    public static /* synthetic */ UserHandleModel copy$default(UserHandleModel userHandleModel, String str, boolean z, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userHandleModel.handle;
        }
        if ((i2 & 2) != 0) {
            z = userHandleModel.editable;
        }
        boolean z2 = z;
        if ((i2 & 4) != 0) {
            str2 = userHandleModel.ruleMessage;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = userHandleModel.confirmMessage;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = userHandleModel.submittedMessage;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            str5 = userHandleModel.bindTelUrl;
        }
        String str9 = str5;
        if ((i2 & 64) != 0) {
            i = userHandleModel.maxLength;
        }
        return userHandleModel.copy(str, z2, str6, str7, str8, str9, i);
    }

    public final String component1() {
        return this.handle;
    }

    public final boolean component2() {
        return this.editable;
    }

    public final String component3() {
        return this.ruleMessage;
    }

    public final String component4() {
        return this.confirmMessage;
    }

    public final String component5() {
        return this.submittedMessage;
    }

    public final String component6() {
        return this.bindTelUrl;
    }

    public final int component7() {
        return this.maxLength;
    }

    public final UserHandleModel copy(String str, boolean z, String str2, String str3, String str4, String str5, int i) {
        Intrinsics.checkNotNullParameter(str, "handle");
        Intrinsics.checkNotNullParameter(str2, "ruleMessage");
        Intrinsics.checkNotNullParameter(str3, "confirmMessage");
        Intrinsics.checkNotNullParameter(str4, "submittedMessage");
        Intrinsics.checkNotNullParameter(str5, "bindTelUrl");
        return new UserHandleModel(str, z, str2, str3, str4, str5, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserHandleModel) {
            UserHandleModel userHandleModel = (UserHandleModel) obj;
            return Intrinsics.areEqual(this.handle, userHandleModel.handle) && this.editable == userHandleModel.editable && Intrinsics.areEqual(this.ruleMessage, userHandleModel.ruleMessage) && Intrinsics.areEqual(this.confirmMessage, userHandleModel.confirmMessage) && Intrinsics.areEqual(this.submittedMessage, userHandleModel.submittedMessage) && Intrinsics.areEqual(this.bindTelUrl, userHandleModel.bindTelUrl) && this.maxLength == userHandleModel.maxLength;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.handle.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.editable)) * 31) + this.ruleMessage.hashCode()) * 31) + this.confirmMessage.hashCode()) * 31) + this.submittedMessage.hashCode()) * 31) + this.bindTelUrl.hashCode()) * 31) + this.maxLength;
    }

    public String toString() {
        String str = this.handle;
        boolean z = this.editable;
        String str2 = this.ruleMessage;
        String str3 = this.confirmMessage;
        String str4 = this.submittedMessage;
        String str5 = this.bindTelUrl;
        return "UserHandleModel(handle=" + str + ", editable=" + z + ", ruleMessage=" + str2 + ", confirmMessage=" + str3 + ", submittedMessage=" + str4 + ", bindTelUrl=" + str5 + ", maxLength=" + this.maxLength + ")";
    }

    public UserHandleModel(String handle, boolean editable, String ruleMessage, String confirmMessage, String submittedMessage, String bindTelUrl, int maxLength) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        Intrinsics.checkNotNullParameter(ruleMessage, "ruleMessage");
        Intrinsics.checkNotNullParameter(confirmMessage, "confirmMessage");
        Intrinsics.checkNotNullParameter(submittedMessage, "submittedMessage");
        Intrinsics.checkNotNullParameter(bindTelUrl, "bindTelUrl");
        this.handle = handle;
        this.editable = editable;
        this.ruleMessage = ruleMessage;
        this.confirmMessage = confirmMessage;
        this.submittedMessage = submittedMessage;
        this.bindTelUrl = bindTelUrl;
        this.maxLength = maxLength;
    }

    public final String getHandle() {
        return this.handle;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final String getRuleMessage() {
        return this.ruleMessage;
    }

    public final String getConfirmMessage() {
        return this.confirmMessage;
    }

    public final String getSubmittedMessage() {
        return this.submittedMessage;
    }

    public final String getBindTelUrl() {
        return this.bindTelUrl;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }
}