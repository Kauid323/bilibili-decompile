package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/NetCodeAction;", "", "Authorize", "AuthorizeResult", "VerifyResult", "Ltv/danmaku/bili/fullscreen/state/NetCodeAction$Authorize;", "Ltv/danmaku/bili/fullscreen/state/NetCodeAction$AuthorizeResult;", "Ltv/danmaku/bili/fullscreen/state/NetCodeAction$VerifyResult;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface NetCodeAction {

    /* compiled from: NetCodeState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/NetCodeAction$Authorize;", "Ltv/danmaku/bili/fullscreen/state/NetCodeAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Authorize implements NetCodeAction {
        public static final int $stable = 0;
        public static final Authorize INSTANCE = new Authorize();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Authorize) {
                Authorize authorize = (Authorize) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 891527050;
        }

        public String toString() {
            return "Authorize";
        }

        private Authorize() {
        }
    }

    /* compiled from: NetCodeState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u001e\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/NetCodeAction$AuthorizeResult;", "Ltv/danmaku/bili/fullscreen/state/NetCodeAction;", "result", "Lkotlin/Result;", "Ltv/danmaku/bili/wauth/WAuthResult;", "<init>", "(Ljava/lang/Object;)V", "getResult-d1pmJ48", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component1-d1pmJ48", "copy", "(Ljava/lang/Object;)Ltv/danmaku/bili/fullscreen/state/NetCodeAction$AuthorizeResult;", "equals", "", "other", "", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AuthorizeResult implements NetCodeAction {
        public static final int $stable = 8;
        private final Object result;

        public static /* synthetic */ AuthorizeResult copy$default(AuthorizeResult authorizeResult, Result result, int i, Object obj) {
            if ((i & 1) != 0) {
                result = Result.box-impl(authorizeResult.result);
            }
            return authorizeResult.copy(result.unbox-impl());
        }

        /* renamed from: component1-d1pmJ48  reason: not valid java name */
        public final Object m1113component1d1pmJ48() {
            return this.result;
        }

        public final AuthorizeResult copy(Object obj) {
            return new AuthorizeResult(obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AuthorizeResult) && Result.equals-impl0(this.result, ((AuthorizeResult) obj).result);
        }

        public int hashCode() {
            return Result.hashCode-impl(this.result);
        }

        public String toString() {
            return "AuthorizeResult(result=" + Result.toString-impl(this.result) + ")";
        }

        public AuthorizeResult(Object result) {
            this.result = result;
        }

        /* renamed from: getResult-d1pmJ48  reason: not valid java name */
        public final Object m1114getResultd1pmJ48() {
            return this.result;
        }
    }

    /* compiled from: NetCodeState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J(\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/NetCodeAction$VerifyResult;", "Ltv/danmaku/bili/fullscreen/state/NetCodeAction;", "result", "Lkotlin/Result;", "Lcom/bilibili/lib/accountsui/ThirdLoginResult;", "loginType", "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;)V", "getResult-d1pmJ48", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLoginType", "()Ljava/lang/String;", "component1", "component1-d1pmJ48", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/String;)Ltv/danmaku/bili/fullscreen/state/NetCodeAction$VerifyResult;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class VerifyResult implements NetCodeAction {
        public static final int $stable = 8;
        private final String loginType;
        private final Object result;

        public static /* synthetic */ VerifyResult copy$default(VerifyResult verifyResult, Result result, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                result = Result.box-impl(verifyResult.result);
            }
            if ((i & 2) != 0) {
                str = verifyResult.loginType;
            }
            return verifyResult.copy(result.unbox-impl(), str);
        }

        /* renamed from: component1-d1pmJ48  reason: not valid java name */
        public final Object m1115component1d1pmJ48() {
            return this.result;
        }

        public final String component2() {
            return this.loginType;
        }

        public final VerifyResult copy(Object obj, String str) {
            Intrinsics.checkNotNullParameter(str, "loginType");
            return new VerifyResult(obj, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VerifyResult) {
                VerifyResult verifyResult = (VerifyResult) obj;
                return Result.equals-impl0(this.result, verifyResult.result) && Intrinsics.areEqual(this.loginType, verifyResult.loginType);
            }
            return false;
        }

        public int hashCode() {
            return (Result.hashCode-impl(this.result) * 31) + this.loginType.hashCode();
        }

        public String toString() {
            String str = Result.toString-impl(this.result);
            return "VerifyResult(result=" + str + ", loginType=" + this.loginType + ")";
        }

        public VerifyResult(Object result, String loginType) {
            Intrinsics.checkNotNullParameter(loginType, "loginType");
            this.result = result;
            this.loginType = loginType;
        }

        /* renamed from: getResult-d1pmJ48  reason: not valid java name */
        public final Object m1116getResultd1pmJ48() {
            return this.result;
        }

        public final String getLoginType() {
            return this.loginType;
        }
    }
}