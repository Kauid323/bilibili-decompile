package kntr.common.komponent;

import java.util.HashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.komponent.KomponentHostScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0011\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000\u0012\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\tH\u0016JF\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2'\u0010\u001e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0 \u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001f¢\u0006\u0002\b\tH\u0016¢\u0006\u0002\u0010!J+\u0010\"\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\tH\u0016J#\u0010\"\u001a\u00020\u00012\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$*\b\u0012\u0004\u0012\u0002H$0\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lkntr/common/komponent/KomponentHostScopeImpl;", "Lkntr/common/komponent/KomponentHostScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "parent", "provideLocals", "Lkotlin/Function1;", "Lkntr/common/komponent/ProvideLocalsScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/common/komponent/KomponentHostScopeImpl;Lkotlin/jvm/functions/Function1;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getParent", "()Lkntr/common/komponent/KomponentHostScopeImpl;", "providedValues", "", "Lkntr/common/komponent/KomponentLocal;", "", "embed", "Lkntr/common/komponent/UiComposableLike;", "S", "child", "Lkntr/common/komponent/Komponent;", "launch", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)V", "__sub", "current", "V", "getCurrent", "(Lkntr/common/komponent/KomponentLocal;)Ljava/lang/Object;", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public class KomponentHostScopeImpl implements KomponentHostScope {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final KomponentHostScopeImpl parent;
    private final Map<KomponentLocal<?>, Object> providedValues;

    public KomponentHostScopeImpl(CoroutineScope coroutineScope, KomponentHostScopeImpl parent, Function1<? super ProvideLocalsScope, Unit> function1) {
        final HashMap map;
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.parent = parent;
        final KomponentHostScopeImpl $this$providedValues_u24lambda_u240 = this;
        if (function1 != null) {
            map = new HashMap();
            function1.invoke(new ProvideLocalsScope() { // from class: kntr.common.komponent.KomponentHostScopeImpl$providedValues$1$scope$1
                @Override // kntr.common.komponent.ProvideLocalsScope, kntr.common.komponent.KomponentLocalAccessScope
                public <V> V getCurrent(KomponentLocal<V> komponentLocal) {
                    V v;
                    Intrinsics.checkNotNullParameter(komponentLocal, "<this>");
                    KomponentHostScopeImpl $this$_get_current__u24lambda_u240 = KomponentHostScopeImpl.this.getParent();
                    if ($this$_get_current__u24lambda_u240 != null && (v = (V) $this$_get_current__u24lambda_u240.getCurrent(komponentLocal)) != null) {
                        return v;
                    }
                    return (V) komponentLocal.getDefaultComputation$komponent_debug().invoke(this);
                }

                @Override // kntr.common.komponent.ProvideLocalsScope
                public <V> void provides(KomponentLocal<V> komponentLocal, V v) {
                    Intrinsics.checkNotNullParameter(komponentLocal, "<this>");
                    map.put(komponentLocal, v);
                }
            });
        } else {
            map = null;
        }
        this.providedValues = map;
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final KomponentHostScopeImpl getParent() {
        return this.parent;
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public <S> UiComposableLike<S> embed(Komponent<? extends S> komponent, Function1<? super ProvideLocalsScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(komponent, "child");
        KomponentScopeImpl scope = new KomponentScopeImpl(getCoroutineScope(), komponent, this, function1);
        return scope.getContent();
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public void launch(CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(function2, "block");
        BuildersKt.launch(getCoroutineScope(), context, start, function2);
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public KomponentHostScope __sub(CoroutineScope coroutineScope, Function1<? super ProvideLocalsScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        return new KomponentHostScopeImpl(coroutineScope, this, function1);
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public KomponentHostScope __sub(Function1<? super ProvideLocalsScope, Unit> function1) {
        Ref.ObjectRef result = new Ref.ObjectRef();
        KomponentHostScope.CC.launch$default(this, null, CoroutineStart.UNDISPATCHED, new KomponentHostScopeImpl$__sub$1(result, this, function1, null), 1, null);
        if (result.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
            return null;
        }
        return (KomponentHostScope) result.element;
    }

    @Override // kntr.common.komponent.KomponentLocalAccessScope
    public <V> V getCurrent(KomponentLocal<V> komponentLocal) {
        Intrinsics.checkNotNullParameter(komponentLocal, "<this>");
        for (KomponentHostScopeImpl walking = this; walking != null; walking = walking.parent) {
            Map providedValues = walking.providedValues;
            if (providedValues != null && providedValues.containsKey(komponentLocal)) {
                return (V) providedValues.get(komponentLocal);
            }
        }
        return (V) komponentLocal.getDefaultComputation$komponent_debug().invoke(this);
    }
}