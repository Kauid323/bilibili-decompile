package tv.danmaku.bili.fullscreen.state;

import bili.resource.account.R;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.ToastInfo;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/LoginFailed;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "PhoneBindingRequested", "Risk", "Error", "Ltv/danmaku/bili/fullscreen/state/LoginFailed$Error;", "Ltv/danmaku/bili/fullscreen/state/LoginFailed$PhoneBindingRequested;", "Ltv/danmaku/bili/fullscreen/state/LoginFailed$Risk;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface LoginFailed extends NetCodeState {

    /* compiled from: NetCodeState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/LoginFailed$PhoneBindingRequested;", "Ltv/danmaku/bili/fullscreen/state/LoginFailed;", "Ltv/danmaku/bili/fullscreen/state/NetCodeStartable;", "snsPlatform", "", "snsAppId", "snsOpenId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSnsPlatform", "()Ljava/lang/String;", "getSnsAppId", "getSnsOpenId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PhoneBindingRequested implements LoginFailed, NetCodeStartable {
        public static final int $stable = 0;
        private final String snsAppId;
        private final String snsOpenId;
        private final String snsPlatform;

        public static /* synthetic */ PhoneBindingRequested copy$default(PhoneBindingRequested phoneBindingRequested, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = phoneBindingRequested.snsPlatform;
            }
            if ((i & 2) != 0) {
                str2 = phoneBindingRequested.snsAppId;
            }
            if ((i & 4) != 0) {
                str3 = phoneBindingRequested.snsOpenId;
            }
            return phoneBindingRequested.copy(str, str2, str3);
        }

        public final String component1() {
            return this.snsPlatform;
        }

        public final String component2() {
            return this.snsAppId;
        }

        public final String component3() {
            return this.snsOpenId;
        }

        public final PhoneBindingRequested copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "snsPlatform");
            Intrinsics.checkNotNullParameter(str2, "snsAppId");
            Intrinsics.checkNotNullParameter(str3, "snsOpenId");
            return new PhoneBindingRequested(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PhoneBindingRequested) {
                PhoneBindingRequested phoneBindingRequested = (PhoneBindingRequested) obj;
                return Intrinsics.areEqual(this.snsPlatform, phoneBindingRequested.snsPlatform) && Intrinsics.areEqual(this.snsAppId, phoneBindingRequested.snsAppId) && Intrinsics.areEqual(this.snsOpenId, phoneBindingRequested.snsOpenId);
            }
            return false;
        }

        public int hashCode() {
            return (((this.snsPlatform.hashCode() * 31) + this.snsAppId.hashCode()) * 31) + this.snsOpenId.hashCode();
        }

        public String toString() {
            String str = this.snsPlatform;
            String str2 = this.snsAppId;
            return "PhoneBindingRequested(snsPlatform=" + str + ", snsAppId=" + str2 + ", snsOpenId=" + this.snsOpenId + ")";
        }

        public PhoneBindingRequested(String snsPlatform, String snsAppId, String snsOpenId) {
            Intrinsics.checkNotNullParameter(snsPlatform, "snsPlatform");
            Intrinsics.checkNotNullParameter(snsAppId, "snsAppId");
            Intrinsics.checkNotNullParameter(snsOpenId, "snsOpenId");
            this.snsPlatform = snsPlatform;
            this.snsAppId = snsAppId;
            this.snsOpenId = snsOpenId;
        }

        public final String getSnsPlatform() {
            return this.snsPlatform;
        }

        public final String getSnsAppId() {
            return this.snsAppId;
        }

        public final String getSnsOpenId() {
            return this.snsOpenId;
        }
    }

    /* compiled from: NetCodeState.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/LoginFailed$Risk;", "Ltv/danmaku/bili/fullscreen/state/LoginFailed;", "Ltv/danmaku/bili/fullscreen/state/NetCodeStartable;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Risk implements LoginFailed, NetCodeStartable {
        public static final int $stable = 0;
        public static final Risk INSTANCE = new Risk();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Risk) {
                Risk risk = (Risk) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1204057720;
        }

        public String toString() {
            return "Risk";
        }

        private Risk() {
        }
    }

    /* compiled from: NetCodeState.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/LoginFailed$Error;", "Ltv/danmaku/bili/fullscreen/state/LoginFailed;", "Ltv/danmaku/bili/fullscreen/state/NetCodeStartable;", "Ltv/danmaku/bili/fullscreen/state/Toasting;", "throwable", "", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "<init>", "(Ljava/lang/Throwable;Ltv/danmaku/bili/fullscreen/service/ToastInfo;)V", "getThrowable", "()Ljava/lang/Throwable;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Error implements LoginFailed, NetCodeStartable, Toasting {
        public static final int $stable = 8;
        private final Throwable throwable;
        private final ToastInfo toastInfo;

        public Error() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Error copy$default(Error error, Throwable th, ToastInfo toastInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                th = error.throwable;
            }
            if ((i & 2) != 0) {
                toastInfo = error.toastInfo;
            }
            return error.copy(th, toastInfo);
        }

        public final Throwable component1() {
            return this.throwable;
        }

        public final ToastInfo component2() {
            return this.toastInfo;
        }

        public final Error copy(Throwable th, ToastInfo toastInfo) {
            Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
            return new Error(th, toastInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Error) {
                Error error = (Error) obj;
                return Intrinsics.areEqual(this.throwable, error.throwable) && Intrinsics.areEqual(this.toastInfo, error.toastInfo);
            }
            return false;
        }

        public int hashCode() {
            return ((this.throwable == null ? 0 : this.throwable.hashCode()) * 31) + this.toastInfo.hashCode();
        }

        public String toString() {
            Throwable th = this.throwable;
            return "Error(throwable=" + th + ", toastInfo=" + this.toastInfo + ")";
        }

        public Error(Throwable throwable, ToastInfo toastInfo) {
            Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
            this.throwable = throwable;
            this.toastInfo = toastInfo;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Error(Throwable th, ToastInfo toastInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(th, toastInfo);
            th = (i & 1) != 0 ? null : th;
            if ((i & 2) != 0) {
                String string = FoundationAlias.getFapp().getString(R.string.account_global_string_136);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                toastInfo = new ToastInfo(string, 0L, 2, null);
            }
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        @Override // tv.danmaku.bili.fullscreen.state.Toasting
        public ToastInfo getToastInfo() {
            return this.toastInfo;
        }
    }
}