package kntr.app.ad.domain.click.internal.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.ad.domain.click.ClickArg;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: ActionChainBuilder.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jz\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0011*\u00020\t2T\u0010\u0012\u001aP\u0012\u0004\u0012\u00020\n\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\b\u0012\u0004\u0012\u0002H\u0011`\u000e0\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00110\u0007Ju\u0010\u0014\u001ab\u0012^\u0012\\\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\b\u0012\u0004\u0012\u00020\t`\u000e0\u00060\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0017Rz\u0010\u0004\u001an\u0012j\u0012h\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012R\u0012P\u0012\u0004\u0012\u00020\n\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\b\u0012\u0004\u0012\u00020\t`\u000e0\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionChainBuilder;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "factories", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/Pair;", "Lkotlin/Function1;", "Lkntr/app/ad/domain/click/ClickArg;", "Lkntr/app/ad/domain/click/internal/action/ActionParam;", "Lkntr/app/ad/domain/click/internal/ClickContext;", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionHandler;", "add", RoomRecommendViewModel.EMPTY_CURSOR, "P", "factory", "extractor", ReportBuildInParam.BUILD, RoomRecommendViewModel.EMPTY_CURSOR, "context", "build$click_debug", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionChainBuilder {
    private final List<Pair<Function1<ClickArg, ActionParam>, Function1<ClickContext, Function3<ActionParam, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>>>> factories = new ArrayList();

    public final <P extends ActionParam> void add(Function1<? super ClickContext, ? extends Function3<? super P, ? super Function1<? super Continuation<? super Boolean>, ? extends Object>, ? super Continuation<? super Boolean>, ? extends Object>> function1, Function1<? super ClickArg, ? extends P> function12) {
        Intrinsics.checkNotNullParameter(function1, "factory");
        Intrinsics.checkNotNullParameter(function12, "extractor");
        this.factories.add(TuplesKt.to((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function12, 1), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)));
    }

    public final List<Pair<Function1<ClickArg, ActionParam>, Function3<ActionParam, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>>> build$click_debug(ClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Iterable $this$map$iv = this.factories;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Pair pair = (Pair) item$iv$iv;
            Function1 extractor = (Function1) pair.component1();
            Function1 factory = (Function1) pair.component2();
            destination$iv$iv.add(TuplesKt.to(extractor, factory.invoke(context)));
        }
        return (List) destination$iv$iv;
    }
}