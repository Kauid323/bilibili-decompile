package im.direct.notification.interactive;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.im.gateway.interfaces.v1.KThankButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000e\u0010\u001d\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b\u001eJE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\n\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006%"}, d2 = {"Lim/direct/notification/interactive/ThankCtrl;", "", "isSelected", "", "receiverName", "", "senderAvatar", "msgText", "msgID", "", "receiverMid", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "button", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KThankButton;", "(Lcom/bapis/bilibili/im/gateway/interfaces/v1/KThankButton;J)V", "()Z", "getReceiverName", "()Ljava/lang/String;", "getSenderAvatar", "getMsgText", "getMsgID", "()J", "getReceiverMid$interactive_debug", "component1", "component2", "component3", "component4", "component5", "component6", "component6$interactive_debug", "copy", "equals", "other", "hashCode", "", "toString", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThankCtrl {
    private final boolean isSelected;
    private final long msgID;
    private final String msgText;
    private final long receiverMid;
    private final String receiverName;
    private final String senderAvatar;

    public final boolean component1() {
        return this.isSelected;
    }

    public final String component2() {
        return this.receiverName;
    }

    public final String component3() {
        return this.senderAvatar;
    }

    public final String component4() {
        return this.msgText;
    }

    public final long component5() {
        return this.msgID;
    }

    public final long component6$interactive_debug() {
        return this.receiverMid;
    }

    public final ThankCtrl copy(boolean z, String str, String str2, String str3, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "receiverName");
        Intrinsics.checkNotNullParameter(str2, "senderAvatar");
        Intrinsics.checkNotNullParameter(str3, "msgText");
        return new ThankCtrl(z, str, str2, str3, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThankCtrl) {
            ThankCtrl thankCtrl = (ThankCtrl) obj;
            return this.isSelected == thankCtrl.isSelected && Intrinsics.areEqual(this.receiverName, thankCtrl.receiverName) && Intrinsics.areEqual(this.senderAvatar, thankCtrl.senderAvatar) && Intrinsics.areEqual(this.msgText, thankCtrl.msgText) && this.msgID == thankCtrl.msgID && this.receiverMid == thankCtrl.receiverMid;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSelected) * 31) + this.receiverName.hashCode()) * 31) + this.senderAvatar.hashCode()) * 31) + this.msgText.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.msgID)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.receiverMid);
    }

    public String toString() {
        boolean z = this.isSelected;
        String str = this.receiverName;
        String str2 = this.senderAvatar;
        String str3 = this.msgText;
        long j = this.msgID;
        return "ThankCtrl(isSelected=" + z + ", receiverName=" + str + ", senderAvatar=" + str2 + ", msgText=" + str3 + ", msgID=" + j + ", receiverMid=" + this.receiverMid + ")";
    }

    public ThankCtrl(boolean isSelected, String receiverName, String senderAvatar, String msgText, long msgID, long receiverMid) {
        Intrinsics.checkNotNullParameter(receiverName, "receiverName");
        Intrinsics.checkNotNullParameter(senderAvatar, "senderAvatar");
        Intrinsics.checkNotNullParameter(msgText, "msgText");
        this.isSelected = isSelected;
        this.receiverName = receiverName;
        this.senderAvatar = senderAvatar;
        this.msgText = msgText;
        this.msgID = msgID;
        this.receiverMid = receiverMid;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final String getReceiverName() {
        return this.receiverName;
    }

    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    public final String getMsgText() {
        return this.msgText;
    }

    public final long getMsgID() {
        return this.msgID;
    }

    public final long getReceiverMid$interactive_debug() {
        return this.receiverMid;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThankCtrl(KThankButton button, long msgID) {
        this(button.getHasSent(), button.getReceiverName(), button.getSenderAvatar(), button.getMsgText(), msgID, button.getReceiverMid());
        Intrinsics.checkNotNullParameter(button, "button");
    }
}