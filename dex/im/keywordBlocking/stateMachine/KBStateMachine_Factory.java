package im.keywordBlocking.stateMachine;

import dagger.internal.Factory;
import im.keywordBlocking.service.KBPageLoadService;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lim/keywordBlocking/stateMachine/KBStateMachine_Factory;", "Ldagger/internal/Factory;", "Lim/keywordBlocking/stateMachine/KBStateMachine;", "loadServiceProvider", "Ljavax/inject/Provider;", "Lim/keywordBlocking/service/KBPageLoadService;", "addItemStateMachineBuilderProvider", "Lim/keywordBlocking/stateMachine/KBAddItemStateMachineBuilder;", "deleteItemStateMachineBuilderProvider", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachineBuilder;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBStateMachine_Factory implements Factory<KBStateMachine> {
    public static final Companion Companion = new Companion(null);
    private final Provider<KBAddItemStateMachineBuilder> addItemStateMachineBuilderProvider;
    private final Provider<KBDeleteItemStateMachineBuilder> deleteItemStateMachineBuilderProvider;
    private final Provider<KBPageLoadService> loadServiceProvider;

    public KBStateMachine_Factory(Provider<KBPageLoadService> provider, Provider<KBAddItemStateMachineBuilder> provider2, Provider<KBDeleteItemStateMachineBuilder> provider3) {
        Intrinsics.checkNotNullParameter(provider, "loadServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "addItemStateMachineBuilderProvider");
        Intrinsics.checkNotNullParameter(provider3, "deleteItemStateMachineBuilderProvider");
        this.loadServiceProvider = provider;
        this.addItemStateMachineBuilderProvider = provider2;
        this.deleteItemStateMachineBuilderProvider = provider3;
    }

    /* renamed from: get */
    public KBStateMachine m3217get() {
        Companion companion = Companion;
        Object obj = this.loadServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.addItemStateMachineBuilderProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.deleteItemStateMachineBuilderProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        return companion.newInstance((KBPageLoadService) obj, (KBAddItemStateMachineBuilder) obj2, (KBDeleteItemStateMachineBuilder) obj3);
    }

    /* compiled from: KBStateMachine_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lim/keywordBlocking/stateMachine/KBStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lim/keywordBlocking/stateMachine/KBStateMachine_Factory;", "loadServiceProvider", "Ljavax/inject/Provider;", "Lim/keywordBlocking/service/KBPageLoadService;", "addItemStateMachineBuilderProvider", "Lim/keywordBlocking/stateMachine/KBAddItemStateMachineBuilder;", "deleteItemStateMachineBuilderProvider", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachineBuilder;", "newInstance", "Lim/keywordBlocking/stateMachine/KBStateMachine;", "loadService", "addItemStateMachineBuilder", "deleteItemStateMachineBuilder", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final KBStateMachine_Factory create(Provider<KBPageLoadService> provider, Provider<KBAddItemStateMachineBuilder> provider2, Provider<KBDeleteItemStateMachineBuilder> provider3) {
            Intrinsics.checkNotNullParameter(provider, "loadServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "addItemStateMachineBuilderProvider");
            Intrinsics.checkNotNullParameter(provider3, "deleteItemStateMachineBuilderProvider");
            return new KBStateMachine_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final KBStateMachine newInstance(KBPageLoadService loadService, KBAddItemStateMachineBuilder addItemStateMachineBuilder, KBDeleteItemStateMachineBuilder deleteItemStateMachineBuilder) {
            Intrinsics.checkNotNullParameter(loadService, "loadService");
            Intrinsics.checkNotNullParameter(addItemStateMachineBuilder, "addItemStateMachineBuilder");
            Intrinsics.checkNotNullParameter(deleteItemStateMachineBuilder, "deleteItemStateMachineBuilder");
            return new KBStateMachine(loadService, addItemStateMachineBuilder, deleteItemStateMachineBuilder);
        }
    }

    @JvmStatic
    public static final KBStateMachine_Factory create(Provider<KBPageLoadService> provider, Provider<KBAddItemStateMachineBuilder> provider2, Provider<KBDeleteItemStateMachineBuilder> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final KBStateMachine newInstance(KBPageLoadService loadService, KBAddItemStateMachineBuilder addItemStateMachineBuilder, KBDeleteItemStateMachineBuilder deleteItemStateMachineBuilder) {
        return Companion.newInstance(loadService, addItemStateMachineBuilder, deleteItemStateMachineBuilder);
    }
}