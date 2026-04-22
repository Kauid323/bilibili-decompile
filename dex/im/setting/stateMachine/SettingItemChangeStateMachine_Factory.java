package im.setting.stateMachine;

import im.setting.model.SettingItem;
import im.setting.service.SettingChangeService;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingItemChangeStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lim/setting/stateMachine/SettingItemChangeStateMachine_Factory;", "", "changeServiceProvider", "Ljavax/inject/Provider;", "Lim/setting/service/SettingChangeService;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Lim/setting/stateMachine/SettingItemChangeStateMachine;", "item", "Lim/setting/model/SettingItem$Setting;", "task", "Lim/setting/stateMachine/IMSettingItemChangeTask;", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingItemChangeStateMachine_Factory {
    private final Provider<SettingChangeService> changeServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SettingItemChangeStateMachine_Factory(Provider<SettingChangeService> provider) {
        Intrinsics.checkNotNullParameter(provider, "changeServiceProvider");
        this.changeServiceProvider = provider;
    }

    public final SettingItemChangeStateMachine get(SettingItem.Setting item, IMSettingItemChangeTask task) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(task, "task");
        Companion companion = Companion;
        Object obj = this.changeServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance(item, task, (SettingChangeService) obj);
    }

    /* compiled from: SettingItemChangeStateMachine_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0007¨\u0006\u0010"}, d2 = {"Lim/setting/stateMachine/SettingItemChangeStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lim/setting/stateMachine/SettingItemChangeStateMachine_Factory;", "changeServiceProvider", "Ljavax/inject/Provider;", "Lim/setting/service/SettingChangeService;", "newInstance", "Lim/setting/stateMachine/SettingItemChangeStateMachine;", "item", "Lim/setting/model/SettingItem$Setting;", "task", "Lim/setting/stateMachine/IMSettingItemChangeTask;", "changeService", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SettingItemChangeStateMachine_Factory create(Provider<SettingChangeService> provider) {
            Intrinsics.checkNotNullParameter(provider, "changeServiceProvider");
            return new SettingItemChangeStateMachine_Factory(provider);
        }

        @JvmStatic
        public final SettingItemChangeStateMachine newInstance(SettingItem.Setting item, IMSettingItemChangeTask task, SettingChangeService changeService) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(changeService, "changeService");
            return new SettingItemChangeStateMachine(item, task, changeService);
        }
    }

    @JvmStatic
    public static final SettingItemChangeStateMachine_Factory create(Provider<SettingChangeService> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final SettingItemChangeStateMachine newInstance(SettingItem.Setting item, IMSettingItemChangeTask task, SettingChangeService changeService) {
        return Companion.newInstance(item, task, changeService);
    }
}