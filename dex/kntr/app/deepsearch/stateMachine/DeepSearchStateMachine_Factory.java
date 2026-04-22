package kntr.app.deepsearch.stateMachine;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.deepsearch.base.model.biz.DeepSearchBroadcastService;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.service.DeepSearchTextLinkNodeService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchStateMachine_Factory.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013Bi\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine;", "sessionIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionQueryProvider", "sessionTitleProvider", "dataProcessServiceProvider", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "broadcastServiceProvider", "Lkntr/app/deepsearch/base/model/biz/DeepSearchBroadcastService;", "linkNodeServiceProvider", "Lkntr/app/deepsearch/service/DeepSearchTextLinkNodeService;", "timeoutServiceProvider", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchStateMachine_Factory implements Factory<DeepSearchStateMachine> {
    private final Provider<DeepSearchBroadcastService> broadcastServiceProvider;
    private final Provider<DeepSearchDataProcessService> dataProcessServiceProvider;
    private final Provider<DeepSearchTextLinkNodeService> linkNodeServiceProvider;
    private final Provider<String> sessionIdProvider;
    private final Provider<String> sessionQueryProvider;
    private final Provider<String> sessionTitleProvider;
    private final Provider<DeepSearchTimeoutService> timeoutServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DeepSearchStateMachine_Factory(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<DeepSearchDataProcessService> provider4, Provider<DeepSearchBroadcastService> provider5, Provider<DeepSearchTextLinkNodeService> provider6, Provider<DeepSearchTimeoutService> provider7) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "sessionQueryProvider");
        Intrinsics.checkNotNullParameter(provider3, "sessionTitleProvider");
        Intrinsics.checkNotNullParameter(provider4, "dataProcessServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "broadcastServiceProvider");
        Intrinsics.checkNotNullParameter(provider6, "linkNodeServiceProvider");
        Intrinsics.checkNotNullParameter(provider7, "timeoutServiceProvider");
        this.sessionIdProvider = provider;
        this.sessionQueryProvider = provider2;
        this.sessionTitleProvider = provider3;
        this.dataProcessServiceProvider = provider4;
        this.broadcastServiceProvider = provider5;
        this.linkNodeServiceProvider = provider6;
        this.timeoutServiceProvider = provider7;
    }

    public DeepSearchStateMachine get() {
        Companion companion = Companion;
        String str = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String str2 = this.sessionQueryProvider.get();
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String str3 = this.sessionTitleProvider.get();
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        DeepSearchDataProcessService deepSearchDataProcessService = this.dataProcessServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(deepSearchDataProcessService, "get(...)");
        DeepSearchBroadcastService deepSearchBroadcastService = this.broadcastServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(deepSearchBroadcastService, "get(...)");
        DeepSearchTextLinkNodeService deepSearchTextLinkNodeService = this.linkNodeServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(deepSearchTextLinkNodeService, "get(...)");
        DeepSearchTimeoutService deepSearchTimeoutService = this.timeoutServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(deepSearchTimeoutService, "get(...)");
        return companion.newInstance(str, str2, str3, deepSearchDataProcessService, deepSearchBroadcastService, deepSearchTextLinkNodeService, deepSearchTimeoutService);
    }

    /* compiled from: DeepSearchStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0007J@\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0012H\u0007¨\u0006\u001c"}, d2 = {"Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionQueryProvider", "sessionTitleProvider", "dataProcessServiceProvider", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "broadcastServiceProvider", "Lkntr/app/deepsearch/base/model/biz/DeepSearchBroadcastService;", "linkNodeServiceProvider", "Lkntr/app/deepsearch/service/DeepSearchTextLinkNodeService;", "timeoutServiceProvider", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", "newInstance", "Lkntr/app/deepsearch/stateMachine/DeepSearchStateMachine;", "sessionId", "sessionQuery", "sessionTitle", "dataProcessService", "broadcastService", "linkNodeService", "timeoutService", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DeepSearchStateMachine_Factory create(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<DeepSearchDataProcessService> provider4, Provider<DeepSearchBroadcastService> provider5, Provider<DeepSearchTextLinkNodeService> provider6, Provider<DeepSearchTimeoutService> provider7) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "sessionQueryProvider");
            Intrinsics.checkNotNullParameter(provider3, "sessionTitleProvider");
            Intrinsics.checkNotNullParameter(provider4, "dataProcessServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "broadcastServiceProvider");
            Intrinsics.checkNotNullParameter(provider6, "linkNodeServiceProvider");
            Intrinsics.checkNotNullParameter(provider7, "timeoutServiceProvider");
            return new DeepSearchStateMachine_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
        }

        @JvmStatic
        public final DeepSearchStateMachine newInstance(String sessionId, String sessionQuery, String sessionTitle, DeepSearchDataProcessService dataProcessService, DeepSearchBroadcastService broadcastService, DeepSearchTextLinkNodeService linkNodeService, DeepSearchTimeoutService timeoutService) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(sessionQuery, "sessionQuery");
            Intrinsics.checkNotNullParameter(sessionTitle, "sessionTitle");
            Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
            Intrinsics.checkNotNullParameter(broadcastService, "broadcastService");
            Intrinsics.checkNotNullParameter(linkNodeService, "linkNodeService");
            Intrinsics.checkNotNullParameter(timeoutService, "timeoutService");
            return new DeepSearchStateMachine(sessionId, sessionQuery, sessionTitle, dataProcessService, broadcastService, linkNodeService, timeoutService);
        }
    }

    @JvmStatic
    public static final DeepSearchStateMachine_Factory create(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<DeepSearchDataProcessService> provider4, Provider<DeepSearchBroadcastService> provider5, Provider<DeepSearchTextLinkNodeService> provider6, Provider<DeepSearchTimeoutService> provider7) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @JvmStatic
    public static final DeepSearchStateMachine newInstance(String sessionId, String sessionQuery, String sessionTitle, DeepSearchDataProcessService dataProcessService, DeepSearchBroadcastService broadcastService, DeepSearchTextLinkNodeService linkNodeService, DeepSearchTimeoutService timeoutService) {
        return Companion.newInstance(sessionId, sessionQuery, sessionTitle, dataProcessService, broadcastService, linkNodeService, timeoutService);
    }
}