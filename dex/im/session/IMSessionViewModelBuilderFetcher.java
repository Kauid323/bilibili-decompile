package im.session;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import im.session.di.IMSessionEntryPoint;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IMSessionViewModelFetcher.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lim/session/IMSessionViewModelBuilderFetcher;", "", "<init>", "()V", "homeViewModel", "Lim/session/IMSessionViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "secondaryViewModel", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionViewModelBuilderFetcher {
    public static final IMSessionViewModelBuilderFetcher INSTANCE = new IMSessionViewModelBuilderFetcher();

    private IMSessionViewModelBuilderFetcher() {
    }

    public final IMSessionViewModel homeViewModel(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((IMSessionEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(IMSessionEntryPoint.class))).getHomeComponentFactory().build(scope).viewModel();
    }

    public final IMSessionViewModel secondaryViewModel(CoroutineScope scope, KSessionPageType pageType) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((IMSessionEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(IMSessionEntryPoint.class))).getSecondaryComponentFactory().build(scope, pageType).viewModel();
    }
}