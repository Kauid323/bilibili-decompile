package tv.danmaku.bili.fullscreen.state;

import bili.resource.account.R;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0003\u0004\u0005\u0082\u0001\u0003\u0006\u0007\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeStartable;", "AppRequested", "Cancelled", "OtherFailure", "Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed$AppRequested;", "Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed$Cancelled;", "Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed$OtherFailure;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface AuthorizeFailed extends NetCodeState, NetCodeStartable {

    /* compiled from: NetCodeState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed$AppRequested;", "Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed;", "Ltv/danmaku/bili/fullscreen/state/Toasting;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "<init>", "(Ltv/danmaku/bili/fullscreen/service/ToastInfo;)V", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AppRequested implements AuthorizeFailed, Toasting {
        public static final int $stable = 0;
        private final ToastInfo toastInfo;

        public AppRequested() {
            this(null, 1, null);
        }

        public static /* synthetic */ AppRequested copy$default(AppRequested appRequested, ToastInfo toastInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                toastInfo = appRequested.toastInfo;
            }
            return appRequested.copy(toastInfo);
        }

        public final ToastInfo component1() {
            return this.toastInfo;
        }

        public final AppRequested copy(ToastInfo toastInfo) {
            Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
            return new AppRequested(toastInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AppRequested) && Intrinsics.areEqual(this.toastInfo, ((AppRequested) obj).toastInfo);
        }

        public int hashCode() {
            return this.toastInfo.hashCode();
        }

        public String toString() {
            return "AppRequested(toastInfo=" + this.toastInfo + ")";
        }

        public AppRequested(ToastInfo toastInfo) {
            Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
            this.toastInfo = toastInfo;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ AppRequested(ToastInfo toastInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(toastInfo);
            if ((i & 1) != 0) {
                String string = FoundationAlias.getFapp().getString(R.string.account_global_string_420);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                toastInfo = new ToastInfo(string, 0L, 2, null);
            }
        }

        @Override // tv.danmaku.bili.fullscreen.state.Toasting
        public ToastInfo getToastInfo() {
            return this.toastInfo;
        }
    }

    /* compiled from: NetCodeState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed$Cancelled;", "Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed;", "Ltv/danmaku/bili/fullscreen/state/Toasting;", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "<init>", "(Ltv/danmaku/bili/fullscreen/service/ToastInfo;)V", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Cancelled implements AuthorizeFailed, Toasting {
        public static final int $stable = 0;
        private final ToastInfo toastInfo;

        public Cancelled() {
            this(null, 1, null);
        }

        public static /* synthetic */ Cancelled copy$default(Cancelled cancelled, ToastInfo toastInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                toastInfo = cancelled.toastInfo;
            }
            return cancelled.copy(toastInfo);
        }

        public final ToastInfo component1() {
            return this.toastInfo;
        }

        public final Cancelled copy(ToastInfo toastInfo) {
            Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
            return new Cancelled(toastInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cancelled) && Intrinsics.areEqual(this.toastInfo, ((Cancelled) obj).toastInfo);
        }

        public int hashCode() {
            return this.toastInfo.hashCode();
        }

        public String toString() {
            return "Cancelled(toastInfo=" + this.toastInfo + ")";
        }

        public Cancelled(ToastInfo toastInfo) {
            Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
            this.toastInfo = toastInfo;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Cancelled(ToastInfo toastInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(toastInfo);
            if ((i & 1) != 0) {
                String string = FoundationAlias.getFapp().getString(R.string.account_global_string_368);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                toastInfo = new ToastInfo(string, 0L, 2, null);
            }
        }

        @Override // tv.danmaku.bili.fullscreen.state.Toasting
        public ToastInfo getToastInfo() {
            return this.toastInfo;
        }
    }

    /* compiled from: NetCodeState.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed$OtherFailure;", "Ltv/danmaku/bili/fullscreen/state/AuthorizeFailed;", "Ltv/danmaku/bili/fullscreen/state/Toasting;", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", "message", "throwable", "", "toastInfo", "Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ltv/danmaku/bili/fullscreen/service/ToastInfo;)V", "getCode", "()Ljava/lang/String;", "getMessage", "getThrowable", "()Ljava/lang/Throwable;", "getToastInfo", "()Ltv/danmaku/bili/fullscreen/service/ToastInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OtherFailure implements AuthorizeFailed, Toasting {
        public static final int $stable = 8;
        private final String code;
        private final String message;
        private final Throwable throwable;
        private final ToastInfo toastInfo;

        public OtherFailure() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ OtherFailure copy$default(OtherFailure otherFailure, String str, String str2, Throwable th, ToastInfo toastInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                str = otherFailure.code;
            }
            if ((i & 2) != 0) {
                str2 = otherFailure.message;
            }
            if ((i & 4) != 0) {
                th = otherFailure.throwable;
            }
            if ((i & 8) != 0) {
                toastInfo = otherFailure.toastInfo;
            }
            return otherFailure.copy(str, str2, th, toastInfo);
        }

        public final String component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final Throwable component3() {
            return this.throwable;
        }

        public final ToastInfo component4() {
            return this.toastInfo;
        }

        public final OtherFailure copy(String str, String str2, Throwable th, ToastInfo toastInfo) {
            Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
            return new OtherFailure(str, str2, th, toastInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OtherFailure) {
                OtherFailure otherFailure = (OtherFailure) obj;
                return Intrinsics.areEqual(this.code, otherFailure.code) && Intrinsics.areEqual(this.message, otherFailure.message) && Intrinsics.areEqual(this.throwable, otherFailure.throwable) && Intrinsics.areEqual(this.toastInfo, otherFailure.toastInfo);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + (this.throwable != null ? this.throwable.hashCode() : 0)) * 31) + this.toastInfo.hashCode();
        }

        public String toString() {
            String str = this.code;
            String str2 = this.message;
            Throwable th = this.throwable;
            return "OtherFailure(code=" + str + ", message=" + str2 + ", throwable=" + th + ", toastInfo=" + this.toastInfo + ")";
        }

        public OtherFailure(String code, String message, Throwable throwable, ToastInfo toastInfo) {
            Intrinsics.checkNotNullParameter(toastInfo, "toastInfo");
            this.code = code;
            this.message = message;
            this.throwable = throwable;
            this.toastInfo = toastInfo;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ OtherFailure(String str, String str2, Throwable th, ToastInfo toastInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, th, toastInfo);
            str = (i & 1) != 0 ? null : str;
            str2 = (i & 2) != 0 ? null : str2;
            th = (i & 4) != 0 ? null : th;
            if ((i & 8) != 0) {
                String string = FoundationAlias.getFapp().getString(R.string.account_global_string_136);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                toastInfo = new ToastInfo(string, 0L, 2, null);
            }
        }

        public final String getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
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