package tv.danmaku.bili;

import com.bilibili.framework.exposure.core.ExposureEntry;
import com.bilibili.framework.exposure.core.ExposureLayoutInfo;
import com.bilibili.framework.exposure.core.transformer.ExposureAreaVisibilityTransformerKt;
import com.bilibili.framework.exposure.core.transformer.ExposureVisibleDurationTransformerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: ExposeFactory.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010R;\u0010\u0004\u001a/\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005j\u0002`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ExposeFactory;", "", "<init>", "()V", "strategyTransformer", "Lkotlin/Function1;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bilibili/framework/exposure/core/ExposureLayoutInfo;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "prevFlow", "", "Lcom/bilibili/framework/exposure/core/ExposureStrategyTransformer;", "newExposureEntry", "Lcom/bilibili/framework/exposure/core/ExposureEntry;", "onExposure", "Lkotlin/Function0;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ExposeFactory {
    public static final int $stable = 0;
    public static final ExposeFactory INSTANCE = new ExposeFactory();
    private static final Function1<Flow<ExposureLayoutInfo>, Flow<Unit>> strategyTransformer = new Function1() { // from class: tv.danmaku.bili.ExposeFactory$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Flow strategyTransformer$lambda$0;
            strategyTransformer$lambda$0 = ExposeFactory.strategyTransformer$lambda$0((Flow) obj);
            return strategyTransformer$lambda$0;
        }
    };

    private ExposeFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow strategyTransformer$lambda$0(Flow layoutInfoFlow) {
        Intrinsics.checkNotNullParameter(layoutInfoFlow, "layoutInfoFlow");
        return FlowKt.take(ExposureVisibleDurationTransformerKt.exposeImmediatelyWhenNoticeable(ExposureAreaVisibilityTransformerKt.noticeableWhenAreaPixelIsAtLeast(layoutInfoFlow, 1)), 1);
    }

    public final ExposureEntry newExposureEntry(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onExposure");
        return new ExposureEntry(strategyTransformer, function0);
    }
}