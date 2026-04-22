package kntr.app.deepsearch;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.deepsearch.di.DeepSearchEntryPoint;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeepSearchViewModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/DeepSearchViewModelFetcher;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "viewModel", "Lkntr/app/deepsearch/DeepSearchViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "sessionQuery", "sessionTitle", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchViewModelFetcher {
    public static final int $stable = 0;

    public final DeepSearchViewModel viewModel(CoroutineScope scope, String sessionId, String sessionQuery, String sessionTitle) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionQuery, "sessionQuery");
        Intrinsics.checkNotNullParameter(sessionTitle, "sessionTitle");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((DeepSearchEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(DeepSearchEntryPoint.class))).getDeepSearchComponentFactory().build(scope, sessionId, sessionQuery, sessionTitle).viewModel();
    }
}