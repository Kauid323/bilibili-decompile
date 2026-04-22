package im.keywordBlocking;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import im.keywordBlocking.di.KBEntryPoint;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KBViewModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lim/keywordBlocking/KBViewModelFetcher;", "", "<init>", "()V", "buildViewModel", "Lim/keywordBlocking/KBViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBViewModelFetcher {
    public static final KBViewModelFetcher INSTANCE = new KBViewModelFetcher();

    private KBViewModelFetcher() {
    }

    public final KBViewModel buildViewModel(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((KBEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(KBEntryPoint.class))).getKBComponentFactory().create(scope).viewModel();
    }
}