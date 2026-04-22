package tv.danmaku.bili.quick.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: OnePassLoginPathLinkManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "", "<init>", "()V", "None", "Trigger", "PrepareRemoteLoginInfo", "CheckConditions", "GetNumberSuc", "DisplayLoginDialog", "Unknown", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$CheckConditions;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$DisplayLoginDialog;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$GetNumberSuc;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$None;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$PrepareRemoteLoginInfo;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$Trigger;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$Unknown;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class OnePassLoginPhaseType {
    public static final int $stable = 0;

    public /* synthetic */ OnePassLoginPhaseType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$None;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class None extends OnePassLoginPhaseType {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    private OnePassLoginPhaseType() {
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$Trigger;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Trigger extends OnePassLoginPhaseType {
        public static final int $stable = 0;
        public static final Trigger INSTANCE = new Trigger();

        private Trigger() {
            super(null);
        }
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$PrepareRemoteLoginInfo;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PrepareRemoteLoginInfo extends OnePassLoginPhaseType {
        public static final int $stable = 0;
        public static final PrepareRemoteLoginInfo INSTANCE = new PrepareRemoteLoginInfo();

        private PrepareRemoteLoginInfo() {
            super(null);
        }
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$CheckConditions;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CheckConditions extends OnePassLoginPhaseType {
        public static final int $stable = 0;
        public static final CheckConditions INSTANCE = new CheckConditions();

        private CheckConditions() {
            super(null);
        }
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$GetNumberSuc;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class GetNumberSuc extends OnePassLoginPhaseType {
        public static final int $stable = 0;
        public static final GetNumberSuc INSTANCE = new GetNumberSuc();

        private GetNumberSuc() {
            super(null);
        }
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$DisplayLoginDialog;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "loginSessionId", "", "<init>", "(Ljava/lang/String;)V", "getLoginSessionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DisplayLoginDialog extends OnePassLoginPhaseType {
        public static final int $stable = 0;
        private final String loginSessionId;

        public static /* synthetic */ DisplayLoginDialog copy$default(DisplayLoginDialog displayLoginDialog, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = displayLoginDialog.loginSessionId;
            }
            return displayLoginDialog.copy(str);
        }

        public final String component1() {
            return this.loginSessionId;
        }

        public final DisplayLoginDialog copy(String str) {
            return new DisplayLoginDialog(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayLoginDialog) && Intrinsics.areEqual(this.loginSessionId, ((DisplayLoginDialog) obj).loginSessionId);
        }

        public int hashCode() {
            if (this.loginSessionId == null) {
                return 0;
            }
            return this.loginSessionId.hashCode();
        }

        public String toString() {
            return "DisplayLoginDialog(loginSessionId=" + this.loginSessionId + ")";
        }

        public DisplayLoginDialog(String loginSessionId) {
            super(null);
            this.loginSessionId = loginSessionId;
        }

        public final String getLoginSessionId() {
            return this.loginSessionId;
        }
    }

    /* compiled from: OnePassLoginPathLinkManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType$Unknown;", "Ltv/danmaku/bili/quick/core/OnePassLoginPhaseType;", "<init>", "()V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Unknown extends OnePassLoginPhaseType {
        public static final int $stable = 0;
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }
}