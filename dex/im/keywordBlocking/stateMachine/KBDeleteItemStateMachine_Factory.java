package im.keywordBlocking.stateMachine;

import im.keywordBlocking.KBListItem;
import im.keywordBlocking.service.KBOperationService;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBDeleteItemStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine_Factory;", "", "operationServiceProvider", "Ljavax/inject/Provider;", "Lim/keywordBlocking/service/KBOperationService;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine;", "item", "Lim/keywordBlocking/KBListItem;", "Companion", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBDeleteItemStateMachine_Factory {
    public static final Companion Companion = new Companion(null);
    private final Provider<KBOperationService> operationServiceProvider;

    public KBDeleteItemStateMachine_Factory(Provider<KBOperationService> provider) {
        Intrinsics.checkNotNullParameter(provider, "operationServiceProvider");
        this.operationServiceProvider = provider;
    }

    public final KBDeleteItemStateMachine get(KBListItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Companion companion = Companion;
        Object obj = this.operationServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance(item, (KBOperationService) obj);
    }

    /* compiled from: KBDeleteItemStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0007¨\u0006\u000e"}, d2 = {"Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine_Factory;", "operationServiceProvider", "Ljavax/inject/Provider;", "Lim/keywordBlocking/service/KBOperationService;", "newInstance", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine;", "item", "Lim/keywordBlocking/KBListItem;", "operationService", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final KBDeleteItemStateMachine_Factory create(Provider<KBOperationService> provider) {
            Intrinsics.checkNotNullParameter(provider, "operationServiceProvider");
            return new KBDeleteItemStateMachine_Factory(provider);
        }

        @JvmStatic
        public final KBDeleteItemStateMachine newInstance(KBListItem item, KBOperationService operationService) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(operationService, "operationService");
            return new KBDeleteItemStateMachine(item, operationService);
        }
    }

    @JvmStatic
    public static final KBDeleteItemStateMachine_Factory create(Provider<KBOperationService> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final KBDeleteItemStateMachine newInstance(KBListItem item, KBOperationService operationService) {
        return Companion.newInstance(item, operationService);
    }
}