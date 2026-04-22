package kntr.app.deepsearch;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.deepsearch.base.model.biz.DeepSearchTransformListService;
import kntr.app.deepsearch.stateMachine.DeepSearchStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeepSearchViewModel_Factory.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010BM\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/DeepSearchViewModel_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/deepsearch/DeepSearchViewModel;", "sessionIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionQueryProvider", "stateMachineProvider", "Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine;", "transformListServiceProvider", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTransformListService;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchViewModel_Factory implements Factory<DeepSearchViewModel> {
    private final Provider<CoroutineScope> scopeProvider;
    private final Provider<String> sessionIdProvider;
    private final Provider<String> sessionQueryProvider;
    private final Provider<DeepSearchStateMachine> stateMachineProvider;
    private final Provider<DeepSearchTransformListService> transformListServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DeepSearchViewModel_Factory(Provider<String> provider, Provider<String> provider2, Provider<DeepSearchStateMachine> provider3, Provider<DeepSearchTransformListService> provider4, Provider<CoroutineScope> provider5) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "sessionQueryProvider");
        Intrinsics.checkNotNullParameter(provider3, "stateMachineProvider");
        Intrinsics.checkNotNullParameter(provider4, "transformListServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "scopeProvider");
        this.sessionIdProvider = provider;
        this.sessionQueryProvider = provider2;
        this.stateMachineProvider = provider3;
        this.transformListServiceProvider = provider4;
        this.scopeProvider = provider5;
    }

    public DeepSearchViewModel get() {
        Companion companion = Companion;
        String str = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String str2 = this.sessionQueryProvider.get();
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        DeepSearchStateMachine deepSearchStateMachine = this.stateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(deepSearchStateMachine, "get(...)");
        DeepSearchTransformListService deepSearchTransformListService = this.transformListServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(deepSearchTransformListService, "get(...)");
        CoroutineScope coroutineScope = this.scopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        return companion.newInstance(str, str2, deepSearchStateMachine, deepSearchTransformListService, coroutineScope);
    }

    /* compiled from: DeepSearchViewModel_Factory.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0007J0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/DeepSearchViewModel_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/deepsearch/DeepSearchViewModel_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionQueryProvider", "stateMachineProvider", "Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine;", "transformListServiceProvider", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTransformListService;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "newInstance", "Lkntr/app/deepsearch/DeepSearchViewModel;", "sessionId", "sessionQuery", "stateMachine", "transformListService", "scope", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DeepSearchViewModel_Factory create(Provider<String> provider, Provider<String> provider2, Provider<DeepSearchStateMachine> provider3, Provider<DeepSearchTransformListService> provider4, Provider<CoroutineScope> provider5) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "sessionQueryProvider");
            Intrinsics.checkNotNullParameter(provider3, "stateMachineProvider");
            Intrinsics.checkNotNullParameter(provider4, "transformListServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "scopeProvider");
            return new DeepSearchViewModel_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final DeepSearchViewModel newInstance(String sessionId, String sessionQuery, DeepSearchStateMachine stateMachine, DeepSearchTransformListService transformListService, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(sessionQuery, "sessionQuery");
            Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
            Intrinsics.checkNotNullParameter(transformListService, "transformListService");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new DeepSearchViewModel(sessionId, sessionQuery, stateMachine, transformListService, scope);
        }
    }

    @JvmStatic
    public static final DeepSearchViewModel_Factory create(Provider<String> provider, Provider<String> provider2, Provider<DeepSearchStateMachine> provider3, Provider<DeepSearchTransformListService> provider4, Provider<CoroutineScope> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final DeepSearchViewModel newInstance(String sessionId, String sessionQuery, DeepSearchStateMachine stateMachine, DeepSearchTransformListService transformListService, CoroutineScope scope) {
        return Companion.newInstance(sessionId, sessionQuery, stateMachine, transformListService, scope);
    }
}