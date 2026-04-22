package kntr.common.komponent;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001#\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003BB\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u00107\u001a\u0002082\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0016J\u0016\u00109\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0016\u0010:\u001a\u00020\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014H\u0016J$\u0010;\u001a\u00020\u00032\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\b\u000eH\u0096\u0001J,\u0010;\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\b\u000eH\u0096\u0001JD\u0010<\u001a\b\u0012\u0004\u0012\u0002H\u00010*\"\n\b\u0001\u0010\u0001*\u0004\u0018\u00010=2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00072\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\b\u000eH\u0096\u0001JG\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2'\u0010D\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0F\u0012\u0006\u0012\u0004\u0018\u00010=0E¢\u0006\u0002\b\u000eH\u0096\u0001¢\u0006\u0002\u0010GR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR7\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R!\u0010/\u001a\u0002008VX\u0096\u0084\u0002¢\u0006\u0012\n\u0004\b5\u00106\u0012\u0004\b1\u00102\u001a\u0004\b3\u00104R(\u0010H\u001a\u0002HI\"\n\b\u0001\u0010I*\u0004\u0018\u00010=*\b\u0012\u0004\u0012\u0002HI0JX\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006M"}, d2 = {"Lkntr/common/komponent/KomponentScopeImpl;", "S", "Lkntr/common/komponent/KomponentScope;", "Lkntr/common/komponent/KomponentHostScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "komponent", "Lkntr/common/komponent/Komponent;", "host", "Lkntr/common/komponent/KomponentHostScopeImpl;", "provideLocals", "Lkotlin/Function1;", "Lkntr/common/komponent/ProvideLocalsScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/common/komponent/Komponent;Lkntr/common/komponent/KomponentHostScopeImpl;Lkotlin/jvm/functions/Function1;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "Lkotlin/Function0;", "Lkntr/common/komponent/Orientation;", "orientationProvider", "getOrientationProvider", "()Lkotlin/jvm/functions/Function0;", "setOrientationProvider", "(Lkotlin/jvm/functions/Function0;)V", "orientationProvider$delegate", "Landroidx/compose/runtime/MutableState;", "", "popGestureEnabledProvider", "getPopGestureEnabledProvider", "setPopGestureEnabledProvider", "popGestureEnabledProvider$delegate", "_preferredHostConfiguration", "kntr/common/komponent/KomponentScopeImpl$_preferredHostConfiguration$1", "Lkntr/common/komponent/KomponentScopeImpl$_preferredHostConfiguration$1;", "preferredHostConfiguration", "Lkntr/common/komponent/HostConfiguration;", "getPreferredHostConfiguration", "()Lkntr/common/komponent/HostConfiguration;", "content", "Lkntr/common/komponent/UiComposableLike;", "getContent", "()Lkntr/common/komponent/UiComposableLike;", "setContent", "(Lkntr/common/komponent/UiComposableLike;)V", "key", "Lkotlin/uuid/Uuid;", "getKey$annotations", "()V", "getKey", "()Lkotlin/uuid/Uuid;", "key$delegate", "Lkotlin/Lazy;", "__setContent", "Lkntr/common/komponent/SetContentResult;", "setPreferredOrientation", "setPopGestureEnabled", "__sub", "embed", "", "child", "launch", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)V", "current", "V", "Lkntr/common/komponent/KomponentLocal;", "getCurrent", "(Lkntr/common/komponent/KomponentLocal;)Ljava/lang/Object;", "komponent_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KomponentScopeImpl<S> implements KomponentScope<S>, KomponentHostScope {
    public static final int $stable = 8;
    private final /* synthetic */ KomponentHostScopeImpl $$delegate_0;
    private final KomponentScopeImpl$_preferredHostConfiguration$1 _preferredHostConfiguration;
    public UiComposableLike<? extends S> content;
    private final CoroutineScope coroutineScope;
    private final Lazy key$delegate;
    private final Komponent<S> komponent;
    private final MutableState orientationProvider$delegate;
    private final MutableState popGestureEnabledProvider$delegate;

    public static /* synthetic */ void getKey$annotations() {
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public KomponentHostScope __sub(Function1<? super ProvideLocalsScope, Unit> function1) {
        return this.$$delegate_0.__sub(function1);
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public KomponentHostScope __sub(CoroutineScope coroutineScope, Function1<? super ProvideLocalsScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        return this.$$delegate_0.__sub(coroutineScope, function1);
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public <S> UiComposableLike<S> embed(Komponent<? extends S> komponent, Function1<? super ProvideLocalsScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(komponent, "child");
        return this.$$delegate_0.embed(komponent, function1);
    }

    @Override // kntr.common.komponent.KomponentLocalAccessScope
    public <V> V getCurrent(KomponentLocal<V> komponentLocal) {
        Intrinsics.checkNotNullParameter(komponentLocal, "<this>");
        return (V) this.$$delegate_0.getCurrent(komponentLocal);
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public void launch(CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(coroutineStart, "start");
        Intrinsics.checkNotNullParameter(function2, "block");
        this.$$delegate_0.launch(coroutineContext, coroutineStart, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [kntr.common.komponent.KomponentScopeImpl$_preferredHostConfiguration$1] */
    public KomponentScopeImpl(CoroutineScope coroutineScope, Komponent<? extends S> komponent, KomponentHostScopeImpl host, Function1<? super ProvideLocalsScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(komponent, "komponent");
        this.$$delegate_0 = new KomponentHostScopeImpl(coroutineScope, host, function1);
        this.coroutineScope = coroutineScope;
        this.komponent = komponent;
        this.orientationProvider$delegate = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: kntr.common.komponent.KomponentScopeImpl$$ExternalSyntheticLambda0
            public final Object invoke() {
                Orientation orientation;
                orientation = Orientation.Unspecified;
                return orientation;
            }
        }, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.popGestureEnabledProvider$delegate = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: kntr.common.komponent.KomponentScopeImpl$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean popGestureEnabledProvider_delegate$lambda$0;
                popGestureEnabledProvider_delegate$lambda$0 = KomponentScopeImpl.popGestureEnabledProvider_delegate$lambda$0();
                return Boolean.valueOf(popGestureEnabledProvider_delegate$lambda$0);
            }
        }, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._preferredHostConfiguration = new HostConfiguration(this) { // from class: kntr.common.komponent.KomponentScopeImpl$_preferredHostConfiguration$1
            final /* synthetic */ KomponentScopeImpl<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kntr.common.komponent.HostConfiguration
            public Orientation getOrientation() {
                Function0 orientationProvider;
                orientationProvider = this.this$0.getOrientationProvider();
                return (Orientation) orientationProvider.invoke();
            }

            @Override // kntr.common.komponent.HostConfiguration
            public boolean isPopGestureEnabled() {
                Function0 popGestureEnabledProvider;
                popGestureEnabledProvider = this.this$0.getPopGestureEnabledProvider();
                return ((Boolean) popGestureEnabledProvider.invoke()).booleanValue();
            }
        };
        KomponentKt.getSetup(this.komponent).invoke(this);
        this.key$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.komponent.KomponentScopeImpl$$ExternalSyntheticLambda2
            public final Object invoke() {
                Uuid key_delegate$lambda$0;
                key_delegate$lambda$0 = KomponentScopeImpl.key_delegate$lambda$0();
                return key_delegate$lambda$0;
            }
        });
    }

    @Override // kntr.common.komponent.KomponentHostScope
    public CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function0<Orientation> getOrientationProvider() {
        State $this$getValue$iv = this.orientationProvider$delegate;
        return (Function0) $this$getValue$iv.getValue();
    }

    private final void setOrientationProvider(Function0<? extends Orientation> function0) {
        MutableState $this$setValue$iv = this.orientationProvider$delegate;
        $this$setValue$iv.setValue(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function0<Boolean> getPopGestureEnabledProvider() {
        State $this$getValue$iv = this.popGestureEnabledProvider$delegate;
        return (Function0) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean popGestureEnabledProvider_delegate$lambda$0() {
        return true;
    }

    private final void setPopGestureEnabledProvider(Function0<Boolean> function0) {
        MutableState $this$setValue$iv = this.popGestureEnabledProvider$delegate;
        $this$setValue$iv.setValue(function0);
    }

    @Override // kntr.common.komponent.KomponentScope
    public HostConfiguration getPreferredHostConfiguration() {
        return this._preferredHostConfiguration;
    }

    public final UiComposableLike<S> getContent() {
        UiComposableLike uiComposableLike = (UiComposableLike<? extends S>) this.content;
        if (uiComposableLike != null) {
            return uiComposableLike;
        }
        Intrinsics.throwUninitializedPropertyAccessException("content");
        return null;
    }

    public final void setContent(UiComposableLike<? extends S> uiComposableLike) {
        Intrinsics.checkNotNullParameter(uiComposableLike, "<set-?>");
        this.content = uiComposableLike;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uuid key_delegate$lambda$0() {
        return Uuid.Companion.random();
    }

    @Override // kntr.common.komponent.KomponentScope
    public Uuid getKey() {
        return (Uuid) this.key$delegate.getValue();
    }

    @Override // kntr.common.komponent.KomponentScope
    public SetContentResult __setContent(UiComposableLike<? extends S> uiComposableLike) {
        Intrinsics.checkNotNullParameter(uiComposableLike, "content");
        setContent(uiComposableLike);
        return SetContentResultImpl.INSTANCE;
    }

    @Override // kntr.common.komponent.KomponentScope
    public void setPreferredOrientation(Function0<? extends Orientation> function0) {
        Intrinsics.checkNotNullParameter(function0, "orientationProvider");
        setOrientationProvider(function0);
    }

    @Override // kntr.common.komponent.KomponentScope
    public void setPopGestureEnabled(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "popGestureEnabledProvider");
        setPopGestureEnabledProvider(function0);
    }
}