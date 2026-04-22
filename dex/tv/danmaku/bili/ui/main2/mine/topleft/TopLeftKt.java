package tv.danmaku.bili.ui.main2.mine.topleft;

import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentManager;
import com.bilibili.app.comm.restrict.utils.TeenagersModeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterViewModel;

/* compiled from: TopLeft.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"setTopLeft", "", "viewModel", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterViewModel;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "topLeftCompose", "Landroidx/compose/ui/platform/ComposeView;", "legacyAnswer", "Lkotlin/Function0;", "(Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterViewModel;Landroidx/fragment/app/FragmentManager;Landroidx/compose/ui/platform/ComposeView;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopLeftKt {
    public static final Object setTopLeft(HomeUserCenterViewModel viewModel, FragmentManager fragmentManager, ComposeView topLeftCompose, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object collectLatest = FlowKt.collectLatest(FlowKt.flowCombine(viewModel.getMineData(), TeenagersModeKt.getTeenagersModeState(), new TopLeftKt$setTopLeft$2(null)), new TopLeftKt$setTopLeft$3(function0, topLeftCompose, fragmentManager, null), continuation);
        return collectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectLatest : Unit.INSTANCE;
    }
}