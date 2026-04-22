package kntr.app.ad.domain.click.internal.action;

import java.util.List;
import kntr.app.ad.domain.click.ClickArg;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionChain.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bo\u0012f\u0010\u0002\u001ab\u0012^\u0012\\\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\b\u0012\u0004\u0012\u00020\u0007`\u000b0\u00040\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0015Rn\u0010\u0002\u001ab\u0012^\u0012\\\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\b\u0012\u0004\u0012\u00020\u0007`\u000b0\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionChain;", RoomRecommendViewModel.EMPTY_CURSOR, "steps", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/Pair;", "Lkotlin/Function1;", "Lkntr/app/ad/domain/click/ClickArg;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionHandler;", "<init>", "(Ljava/util/List;)V", "proceed", "arg", "(Lkntr/app/ad/domain/click/ClickArg;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "index", RoomRecommendViewModel.EMPTY_CURSOR, "request", "(ILkntr/app/ad/domain/click/ClickArg;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionChain {
    private final List<Pair<Function1<ClickArg, ActionParam>, Function3<ActionParam, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>>> steps;

    public ActionChain(List<? extends Pair<? extends Function1<? super ClickArg, ? extends ActionParam>, ? extends Function3<? super ActionParam, ? super Function1<? super Continuation<? super Boolean>, ? extends Object>, ? super Continuation<? super Boolean>, ? extends Object>>> list) {
        Intrinsics.checkNotNullParameter(list, "steps");
        this.steps = list;
    }

    public final Object proceed(ClickArg arg, Continuation<? super Boolean> continuation) {
        return invoke(0, arg, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object invoke(int index, ClickArg request, Continuation<? super Boolean> continuation) {
        if (index >= this.steps.size()) {
            return Boxing.boxBoolean(false);
        }
        Pair<Function1<ClickArg, ActionParam>, Function3<ActionParam, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>> pair = this.steps.get(index);
        Function1 extractor = (Function1) pair.component1();
        Function3 handler = (Function3) pair.component2();
        ActionParam param = (ActionParam) extractor.invoke(request);
        return handler.invoke(param, new ActionChain$invoke$2(this, index, request, null), continuation);
    }
}