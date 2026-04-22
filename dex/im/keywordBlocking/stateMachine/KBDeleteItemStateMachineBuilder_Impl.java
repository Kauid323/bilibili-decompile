package im.keywordBlocking.stateMachine;

import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import im.keywordBlocking.KBListItem;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBDeleteItemStateMachineBuilder_Impl.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachineBuilder_Impl;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachineBuilder;", "delegateFactory", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine_Factory;", "<init>", "(Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine_Factory;)V", "build", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine;", "item", "Lim/keywordBlocking/KBListItem;", "Companion", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBDeleteItemStateMachineBuilder_Impl implements KBDeleteItemStateMachineBuilder {
    public static final Companion Companion = new Companion(null);
    private final KBDeleteItemStateMachine_Factory delegateFactory;

    public KBDeleteItemStateMachineBuilder_Impl(KBDeleteItemStateMachine_Factory delegateFactory) {
        Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
        this.delegateFactory = delegateFactory;
    }

    @Override // im.keywordBlocking.stateMachine.KBDeleteItemStateMachineBuilder
    public KBDeleteItemStateMachine build(KBListItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return this.delegateFactory.get(item);
    }

    /* compiled from: KBDeleteItemStateMachineBuilder_Impl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachineBuilder_Impl$Companion;", "", "<init>", "()V", "create", "Ljavax/inject/Provider;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachineBuilder;", "delegateFactory", "Lim/keywordBlocking/stateMachine/KBDeleteItemStateMachine_Factory;", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Provider<KBDeleteItemStateMachineBuilder> create(KBDeleteItemStateMachine_Factory delegateFactory) {
            Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
            Factory create = InstanceFactory.create(new KBDeleteItemStateMachineBuilder_Impl(delegateFactory));
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }
    }

    @JvmStatic
    public static final Provider<KBDeleteItemStateMachineBuilder> create(KBDeleteItemStateMachine_Factory delegateFactory) {
        return Companion.create(delegateFactory);
    }
}