package tv.danmaku.bili.quick.network;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: NetworkPermissionDialog.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/quick/network/NetworkDialogResult;", "", "<init>", "()V", "Default", "OtherWays", "HasOpenNetwork", "Ltv/danmaku/bili/quick/network/NetworkDialogResult$Default;", "Ltv/danmaku/bili/quick/network/NetworkDialogResult$HasOpenNetwork;", "Ltv/danmaku/bili/quick/network/NetworkDialogResult$OtherWays;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class NetworkDialogResult {
    public static final int $stable = 0;

    public /* synthetic */ NetworkDialogResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: NetworkPermissionDialog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/quick/network/NetworkDialogResult$Default;", "Ltv/danmaku/bili/quick/network/NetworkDialogResult;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Default extends NetworkDialogResult {
        public static final int $stable = 0;
        public static final Default INSTANCE = new Default();

        private Default() {
            super(null);
        }
    }

    private NetworkDialogResult() {
    }

    /* compiled from: NetworkPermissionDialog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/quick/network/NetworkDialogResult$OtherWays;", "Ltv/danmaku/bili/quick/network/NetworkDialogResult;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OtherWays extends NetworkDialogResult {
        public static final int $stable = 0;
        public static final OtherWays INSTANCE = new OtherWays();

        private OtherWays() {
            super(null);
        }
    }

    /* compiled from: NetworkPermissionDialog.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/quick/network/NetworkDialogResult$HasOpenNetwork;", "Ltv/danmaku/bili/quick/network/NetworkDialogResult;", "getPhoneInfoSuc", "", "<init>", "(Z)V", "getGetPhoneInfoSuc", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HasOpenNetwork extends NetworkDialogResult {
        public static final int $stable = 0;
        private final boolean getPhoneInfoSuc;

        public static /* synthetic */ HasOpenNetwork copy$default(HasOpenNetwork hasOpenNetwork, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = hasOpenNetwork.getPhoneInfoSuc;
            }
            return hasOpenNetwork.copy(z);
        }

        public final boolean component1() {
            return this.getPhoneInfoSuc;
        }

        public final HasOpenNetwork copy(boolean z) {
            return new HasOpenNetwork(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HasOpenNetwork) && this.getPhoneInfoSuc == ((HasOpenNetwork) obj).getPhoneInfoSuc;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.getPhoneInfoSuc);
        }

        public String toString() {
            return "HasOpenNetwork(getPhoneInfoSuc=" + this.getPhoneInfoSuc + ")";
        }

        public HasOpenNetwork(boolean getPhoneInfoSuc) {
            super(null);
            this.getPhoneInfoSuc = getPhoneInfoSuc;
        }

        public final boolean getGetPhoneInfoSuc() {
            return this.getPhoneInfoSuc;
        }
    }
}