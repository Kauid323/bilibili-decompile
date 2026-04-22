package im.session;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import dagger.internal.Factory;
import im.session.observer.IMSessionEventObserver;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IMSessionViewModelImpl_Factory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lim/session/IMSessionViewModelImpl_Factory;", "Ldagger/internal/Factory;", "Lim/session/IMSessionViewModelImpl;", "pageTypeProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "stateMachineProvider", "Lim/session/IMSessionStateMachine;", "observersProvider", "", "Lim/session/observer/IMSessionEventObserver;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionViewModelImpl_Factory implements Factory<IMSessionViewModelImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<Set<IMSessionEventObserver>> observersProvider;
    private final Provider<KSessionPageType> pageTypeProvider;
    private final Provider<CoroutineScope> scopeProvider;
    private final Provider<IMSessionStateMachine> stateMachineProvider;

    public IMSessionViewModelImpl_Factory(Provider<KSessionPageType> provider, Provider<CoroutineScope> provider2, Provider<IMSessionStateMachine> provider3, Provider<Set<IMSessionEventObserver>> provider4) {
        Intrinsics.checkNotNullParameter(provider, "pageTypeProvider");
        Intrinsics.checkNotNullParameter(provider2, "scopeProvider");
        Intrinsics.checkNotNullParameter(provider3, "stateMachineProvider");
        Intrinsics.checkNotNullParameter(provider4, "observersProvider");
        this.pageTypeProvider = provider;
        this.scopeProvider = provider2;
        this.stateMachineProvider = provider3;
        this.observersProvider = provider4;
    }

    /* renamed from: get */
    public IMSessionViewModelImpl m3241get() {
        Companion companion = Companion;
        Object obj = this.pageTypeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.scopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.stateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        Object obj4 = this.observersProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        return companion.newInstance((KSessionPageType) obj, (CoroutineScope) obj2, (IMSessionStateMachine) obj3, (Set) obj4);
    }

    /* compiled from: IMSessionViewModelImpl_Factory.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0007H\u0007J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¨\u0006\u0016"}, d2 = {"Lim/session/IMSessionViewModelImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lim/session/IMSessionViewModelImpl_Factory;", "pageTypeProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "stateMachineProvider", "Lim/session/IMSessionStateMachine;", "observersProvider", "", "Lim/session/observer/IMSessionEventObserver;", "newInstance", "Lim/session/IMSessionViewModelImpl;", "pageType", "scope", "stateMachine", "observers", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMSessionViewModelImpl_Factory create(Provider<KSessionPageType> provider, Provider<CoroutineScope> provider2, Provider<IMSessionStateMachine> provider3, Provider<Set<IMSessionEventObserver>> provider4) {
            Intrinsics.checkNotNullParameter(provider, "pageTypeProvider");
            Intrinsics.checkNotNullParameter(provider2, "scopeProvider");
            Intrinsics.checkNotNullParameter(provider3, "stateMachineProvider");
            Intrinsics.checkNotNullParameter(provider4, "observersProvider");
            return new IMSessionViewModelImpl_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final IMSessionViewModelImpl newInstance(KSessionPageType pageType, CoroutineScope scope, IMSessionStateMachine stateMachine, Set<? extends IMSessionEventObserver> set) {
            Intrinsics.checkNotNullParameter(pageType, "pageType");
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
            Intrinsics.checkNotNullParameter(set, "observers");
            return new IMSessionViewModelImpl(pageType, scope, stateMachine, set);
        }
    }

    @JvmStatic
    public static final IMSessionViewModelImpl_Factory create(Provider<KSessionPageType> provider, Provider<CoroutineScope> provider2, Provider<IMSessionStateMachine> provider3, Provider<Set<IMSessionEventObserver>> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final IMSessionViewModelImpl newInstance(KSessionPageType pageType, CoroutineScope scope, IMSessionStateMachine stateMachine, Set<? extends IMSessionEventObserver> set) {
        return Companion.newInstance(pageType, scope, stateMachine, set);
    }
}