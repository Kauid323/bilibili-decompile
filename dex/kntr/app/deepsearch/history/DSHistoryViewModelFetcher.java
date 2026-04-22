package kntr.app.deepsearch.history;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.deepsearch.history.di.DSHistoryEntryPoint;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DSHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lkntr/app/deepsearch/history/DSHistoryViewModelFetcher;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "viewModel", "Lkntr/app/deepsearch/history/DSHistoryViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DSHistoryViewModelFetcher {
    public final DSHistoryViewModel viewModel(CoroutineScope scope, String sessionId) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((DSHistoryEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(DSHistoryEntryPoint.class))).getDSHistoryComponentFactory().build(scope, sessionId).viewModel();
    }
}