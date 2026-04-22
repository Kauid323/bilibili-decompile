package im.setting.stateMachine;

import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import im.setting.model.SettingItem;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingItemChangeStateMachineBuilder_Impl.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lim/setting/stateMachine/SettingItemChangeStateMachineBuilder_Impl;", "Lim/setting/stateMachine/SettingItemChangeStateMachineBuilder;", "delegateFactory", "Lim/setting/stateMachine/SettingItemChangeStateMachine_Factory;", "<init>", "(Lim/setting/stateMachine/SettingItemChangeStateMachine_Factory;)V", "build", "Lim/setting/stateMachine/SettingItemChangeStateMachine;", "item", "Lim/setting/model/SettingItem$Setting;", "task", "Lim/setting/stateMachine/IMSettingItemChangeTask;", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingItemChangeStateMachineBuilder_Impl implements SettingItemChangeStateMachineBuilder {
    private final SettingItemChangeStateMachine_Factory delegateFactory;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SettingItemChangeStateMachineBuilder_Impl(SettingItemChangeStateMachine_Factory delegateFactory) {
        Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
        this.delegateFactory = delegateFactory;
    }

    @Override // im.setting.stateMachine.SettingItemChangeStateMachineBuilder
    public SettingItemChangeStateMachine build(SettingItem.Setting item, IMSettingItemChangeTask task) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(task, "task");
        return this.delegateFactory.get(item, task);
    }

    /* compiled from: SettingItemChangeStateMachineBuilder_Impl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lim/setting/stateMachine/SettingItemChangeStateMachineBuilder_Impl$Companion;", "", "<init>", "()V", "create", "Ljavax/inject/Provider;", "Lim/setting/stateMachine/SettingItemChangeStateMachineBuilder;", "delegateFactory", "Lim/setting/stateMachine/SettingItemChangeStateMachine_Factory;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Provider<SettingItemChangeStateMachineBuilder> create(SettingItemChangeStateMachine_Factory delegateFactory) {
            Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
            Factory create = InstanceFactory.create(new SettingItemChangeStateMachineBuilder_Impl(delegateFactory));
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }
    }

    @JvmStatic
    public static final Provider<SettingItemChangeStateMachineBuilder> create(SettingItemChangeStateMachine_Factory delegateFactory) {
        return Companion.create(delegateFactory);
    }
}