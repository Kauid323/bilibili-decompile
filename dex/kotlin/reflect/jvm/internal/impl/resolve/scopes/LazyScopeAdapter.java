package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: LazyScopeAdapter.kt */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> lazyScope;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LazyScopeAdapter(Function0<? extends MemberScope> getScope) {
        this(null, getScope, 1, null);
        Intrinsics.checkNotNullParameter(getScope, "getScope");
    }

    public LazyScopeAdapter(StorageManager storageManager, final Function0<? extends MemberScope> getScope) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(getScope, "getScope");
        this.lazyScope = storageManager.createLazyValue(new Function0(getScope) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter$$Lambda$0
            private final Function0 arg$0;

            {
                this.arg$0 = getScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                MemberScope lazyScope$lambda$0;
                lazyScope$lambda$0 = LazyScopeAdapter.lazyScope$lambda$0(this.arg$0);
                return lazyScope$lambda$0;
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LazyScopeAdapter(StorageManager NO_LOCKS, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(NO_LOCKS, function0);
        if ((i & 1) != 0) {
            NO_LOCKS = LockBasedStorageManager.NO_LOCKS;
            Intrinsics.checkNotNullExpressionValue(NO_LOCKS, "NO_LOCKS");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemberScope lazyScope$lambda$0(Function0 $getScope) {
        MemberScope it = (MemberScope) $getScope.invoke();
        return it instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) it).getActualScope() : it;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected MemberScope getWorkerScope() {
        return this.lazyScope.invoke();
    }
}