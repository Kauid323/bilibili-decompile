package im.setting;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import im.setting.di.SettingEntryPoint;
import im.setting.model.IMSettingPageData;
import im.setting.model.param.IMSettingInitializeDataParam;
import im.setting.model.param.IMSettingInitializeTypeParam;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SettingViewModelFetcher.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lim/setting/SettingViewModelFetcher;", "", "<init>", "()V", "imSettingViewModel", "Lim/setting/SettingViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "dataSourceHex", "", "chatSettingViewModel", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingViewModelFetcher {
    public static final int $stable = 0;
    public static final SettingViewModelFetcher INSTANCE = new SettingViewModelFetcher();

    private SettingViewModelFetcher() {
    }

    public final SettingViewModel imSettingViewModel(CoroutineScope scope, KIMSettingType type) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(type, "type");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((SettingEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(SettingEntryPoint.class))).getIMSettingComponentFactory().build(scope, new IMSettingInitializeTypeParam(type)).viewModel();
    }

    public final SettingViewModel imSettingViewModel(CoroutineScope scope, String dataSourceHex) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(dataSourceHex, "dataSourceHex");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((SettingEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(SettingEntryPoint.class))).getIMSettingComponentFactory().build(scope, new IMSettingInitializeDataParam(IMSettingPageData.Companion.decodeFromHex(dataSourceHex))).viewModel();
    }

    public final SettingViewModel chatSettingViewModel(CoroutineScope scope, KSessionId sessionId) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((SettingEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(SettingEntryPoint.class))).getChatSettingComponentFactory().build(scope, sessionId).viewModel();
    }
}