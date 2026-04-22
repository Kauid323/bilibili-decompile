package kntr.common.komponent;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Komponent.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\u001a;\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00070\u0006H\u0007¢\u0006\u0002\b\b\u001aV\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\u0004\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\n2\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\b\u000f2\u001d\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0002\b\u000f\u001a6\u0010\u0012\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u000e0\n2\u0019\b\u0004\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aD\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\n2\u0006\u0010\u0017\u001a\u0002H\u00032\u0019\b\u0004\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0002H\u0086\b\u001a3\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u00032\u001f\b\u0001\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0002\b\u000f\u001aA\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\b\u000f\";\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0002\b\u000f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"embedFlow", "Landroidx/compose/runtime/State;", "Lkntr/common/komponent/UiComposableLike;", "S", "Lkntr/common/komponent/KomponentHostScope;", "flow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/common/komponent/Komponent;", "embedFlowNullable", "embed", "Lkntr/common/komponent/KomponentScope;", "provideLocals", "Lkotlin/Function1;", "Lkntr/common/komponent/ProvideLocalsScope;", "", "Lkotlin/ExtensionFunctionType;", "setup", "Lkntr/common/komponent/SetContentResult;", "setContent", "content", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "(Lkntr/common/komponent/KomponentScope;Lkotlin/jvm/functions/Function3;)Lkntr/common/komponent/SetContentResult;", "state", "(Lkntr/common/komponent/KomponentScope;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkntr/common/komponent/SetContentResult;", "Komponent", "getSetup", "(Lkntr/common/komponent/Komponent;)Lkotlin/jvm/functions/Function1;", "actIn", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "komponent_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KomponentKt {
    public static final <S> State<UiComposableLike<S>> embedFlow(KomponentHostScope $this$embedFlow, Flow<? extends Komponent<? extends S>> flow) {
        Intrinsics.checkNotNullParameter($this$embedFlow, "<this>");
        Intrinsics.checkNotNullParameter(flow, "flow");
        State<UiComposableLike<S>> mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(PseudoUiComposableLike.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        FlowKt.launchIn(FlowKt.onEach(FlowKt.transformLatest(flow, new KomponentKt$embedFlow$1($this$embedFlow, null)), new KomponentKt$embedFlow$2(mutableStateOf$default, null)), $this$embedFlow.getCoroutineScope());
        return mutableStateOf$default;
    }

    public static final <S> State<UiComposableLike<S>> embedFlowNullable(KomponentHostScope $this$embedFlow, Flow<? extends Komponent<? extends S>> flow) {
        Intrinsics.checkNotNullParameter($this$embedFlow, "<this>");
        Intrinsics.checkNotNullParameter(flow, "flow");
        State<UiComposableLike<S>> mutableStateOf$default = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        FlowKt.launchIn(FlowKt.onEach(FlowKt.transformLatest(flow, new KomponentKt$embedFlow$3($this$embedFlow, null)), new KomponentKt$embedFlow$4(mutableStateOf$default, null)), $this$embedFlow.getCoroutineScope());
        return mutableStateOf$default;
    }

    public static /* synthetic */ UiComposableLike embed$default(KomponentScope komponentScope, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return embed(komponentScope, function1, function12);
    }

    public static final <S> UiComposableLike<S> embed(KomponentScope<?> komponentScope, Function1<? super ProvideLocalsScope, Unit> function1, Function1<? super KomponentScope<? super S>, ? extends SetContentResult> function12) {
        Intrinsics.checkNotNullParameter(komponentScope, "<this>");
        Intrinsics.checkNotNullParameter(function12, "setup");
        return (UiComposableLike<S>) komponentScope.embed(Komponent(function12), function1);
    }

    public static final SetContentResult setContent(KomponentScope<? super Unit> komponentScope, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(komponentScope, "<this>");
        Intrinsics.checkNotNullParameter(function3, "content");
        Object state$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv = new KomponentKt$setContent$1(state$iv, function3, komponentScope);
        return komponentScope.__setContent(content$iv$iv);
    }

    public static final <S> SetContentResult setContent(KomponentScope<? super S> komponentScope, S s, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(komponentScope, "<this>");
        Intrinsics.checkNotNullParameter(function3, "content");
        UiComposableLike content$iv = new KomponentKt$setContent$1(s, function3, komponentScope);
        return komponentScope.__setContent(content$iv);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <S> SetContentResult setContent(KomponentScope<? super S> komponentScope, UiComposableLike<? extends S> uiComposableLike) {
        Intrinsics.checkNotNullParameter(komponentScope, "<this>");
        Intrinsics.checkNotNullParameter(uiComposableLike, "content");
        return komponentScope.__setContent(uiComposableLike);
    }

    public static final <S> Komponent<S> Komponent(Function1<? super KomponentScope<? super S>, ? extends SetContentResult> function1) {
        Intrinsics.checkNotNullParameter(function1, "setup");
        return new KomponentImpl(function1);
    }

    public static final <S> Function1<KomponentScope<? super S>, SetContentResult> getSetup(Komponent<? extends S> komponent) {
        Intrinsics.checkNotNullParameter(komponent, "<this>");
        return ((KomponentImpl) komponent).getSetup();
    }

    public static /* synthetic */ UiComposableLike actIn$default(Komponent komponent, CoroutineScope coroutineScope, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return actIn(komponent, coroutineScope, function1);
    }

    public static final <S> UiComposableLike<S> actIn(Komponent<? extends S> komponent, CoroutineScope coroutineScope, Function1<? super ProvideLocalsScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(komponent, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        KomponentScopeImpl scope = new KomponentScopeImpl(coroutineScope, komponent, null, function1);
        return scope.getContent();
    }
}