package kntr.base.account.adapter;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountStateNotifier.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/account/adapter/AccountAdapterEvent;", "", "OnLogin", "OnUpdate", "OnLogout", "Lkntr/base/account/adapter/AccountAdapterEvent$OnLogin;", "Lkntr/base/account/adapter/AccountAdapterEvent$OnLogout;", "Lkntr/base/account/adapter/AccountAdapterEvent$OnUpdate;", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AccountAdapterEvent {

    /* compiled from: AccountStateNotifier.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/base/account/adapter/AccountAdapterEvent$OnLogin;", "Lkntr/base/account/adapter/AccountAdapterEvent;", "userInfo", "Lkntr/base/account/model/UserInfo;", "<init>", "(Lkntr/base/account/model/UserInfo;)V", "getUserInfo", "()Lkntr/base/account/model/UserInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class OnLogin implements AccountAdapterEvent {
        private final UserInfo userInfo;

        public static /* synthetic */ OnLogin copy$default(OnLogin onLogin, UserInfo userInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                userInfo = onLogin.userInfo;
            }
            return onLogin.copy(userInfo);
        }

        public final UserInfo component1() {
            return this.userInfo;
        }

        public final OnLogin copy(UserInfo userInfo) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            return new OnLogin(userInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnLogin) && Intrinsics.areEqual(this.userInfo, ((OnLogin) obj).userInfo);
        }

        public int hashCode() {
            return this.userInfo.hashCode();
        }

        public String toString() {
            return "OnLogin(userInfo=" + this.userInfo + ")";
        }

        public OnLogin(UserInfo userInfo) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            this.userInfo = userInfo;
        }

        public final UserInfo getUserInfo() {
            return this.userInfo;
        }
    }

    /* compiled from: AccountStateNotifier.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/base/account/adapter/AccountAdapterEvent$OnUpdate;", "Lkntr/base/account/adapter/AccountAdapterEvent;", "userInfo", "Lkntr/base/account/model/UserInfo;", "<init>", "(Lkntr/base/account/model/UserInfo;)V", "getUserInfo", "()Lkntr/base/account/model/UserInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class OnUpdate implements AccountAdapterEvent {
        private final UserInfo userInfo;

        public static /* synthetic */ OnUpdate copy$default(OnUpdate onUpdate, UserInfo userInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                userInfo = onUpdate.userInfo;
            }
            return onUpdate.copy(userInfo);
        }

        public final UserInfo component1() {
            return this.userInfo;
        }

        public final OnUpdate copy(UserInfo userInfo) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            return new OnUpdate(userInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnUpdate) && Intrinsics.areEqual(this.userInfo, ((OnUpdate) obj).userInfo);
        }

        public int hashCode() {
            return this.userInfo.hashCode();
        }

        public String toString() {
            return "OnUpdate(userInfo=" + this.userInfo + ")";
        }

        public OnUpdate(UserInfo userInfo) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            this.userInfo = userInfo;
        }

        public final UserInfo getUserInfo() {
            return this.userInfo;
        }
    }

    /* compiled from: AccountStateNotifier.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/account/adapter/AccountAdapterEvent$OnLogout;", "Lkntr/base/account/adapter/AccountAdapterEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class OnLogout implements AccountAdapterEvent {
        public static final OnLogout INSTANCE = new OnLogout();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OnLogout) {
                OnLogout onLogout = (OnLogout) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1677260241;
        }

        public String toString() {
            return "OnLogout";
        }

        private OnLogout() {
        }
    }
}