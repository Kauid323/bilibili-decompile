package tv.danmaku.bili.fullscreen.route;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginTypeRule.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/fullscreen/route/LoginTypeRule;", "", "validLoginTypes", "", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "<init>", "(Ljava/util/List;)V", "getValidLoginTypes", "()Ljava/util/List;", "isTypeEnabled", "", "type", "getAllValidLoginPages", "Ltv/danmaku/bili/fullscreen/route/LoginPageType;", "displays", "", "Ltv/danmaku/bili/fullscreen/route/LoginPageDisplay;", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginTypeRule {
    public static final int $stable = 8;
    private final List<ValidLoginType> validLoginTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoginTypeRule copy$default(LoginTypeRule loginTypeRule, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = loginTypeRule.validLoginTypes;
        }
        return loginTypeRule.copy(list);
    }

    public final List<ValidLoginType> component1() {
        return this.validLoginTypes;
    }

    public final LoginTypeRule copy(List<? extends ValidLoginType> list) {
        Intrinsics.checkNotNullParameter(list, "validLoginTypes");
        return new LoginTypeRule(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LoginTypeRule) && Intrinsics.areEqual(this.validLoginTypes, ((LoginTypeRule) obj).validLoginTypes);
    }

    public int hashCode() {
        return this.validLoginTypes.hashCode();
    }

    public String toString() {
        return "LoginTypeRule(validLoginTypes=" + this.validLoginTypes + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoginTypeRule(List<? extends ValidLoginType> list) {
        Intrinsics.checkNotNullParameter(list, "validLoginTypes");
        this.validLoginTypes = list;
    }

    public final List<ValidLoginType> getValidLoginTypes() {
        return this.validLoginTypes;
    }

    public final boolean isTypeEnabled(ValidLoginType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.validLoginTypes.contains(type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List getAllValidLoginPages$default(LoginTypeRule loginTypeRule, Iterable iterable, int i, Object obj) {
        if ((i & 1) != 0) {
            iterable = LoginPageDisplay.Companion.getDefaultArray();
        }
        return loginTypeRule.getAllValidLoginPages(iterable);
    }

    public final List<LoginPageType> getAllValidLoginPages(Iterable<? extends LoginPageDisplay> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "displays");
        List pageTypes = new ArrayList();
        for (Object element$iv : iterable) {
            LoginPageDisplay display = (LoginPageDisplay) element$iv;
            Iterable $this$forEach$iv = this.validLoginTypes;
            for (Object element$iv2 : $this$forEach$iv) {
                ValidLoginType type = (ValidLoginType) element$iv2;
                pageTypes.add(LoginPageTypeKt.toLoginPage(type, this.validLoginTypes, display));
            }
        }
        return CollectionsKt.filterNotNull(pageTypes);
    }
}