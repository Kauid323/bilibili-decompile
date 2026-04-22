package kntr.common.ouro.core.utils;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: FlowReduxUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0006\u001aI\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\t¢\u0006\u0002\b\n\u001a[\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\f*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\f0\u00062\u0019\b\u0004\u0010\b\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\f0\t¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"noChange", "Lcom/freeletics/flowredux/dsl/ChangedState;", "InputState", "", "Lcom/freeletics/flowredux/dsl/State;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "mutate", "reducer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "override", "S", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FlowReduxUtilsKt {
    public static final <InputState> ChangedState<InputState> noChange(State<InputState> state, final CompletableDeferred<? super InputState> completableDeferred) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return state.mutate(new Function1() { // from class: kntr.common.ouro.core.utils.FlowReduxUtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Object noChange$lambda$0;
                noChange$lambda$0 = FlowReduxUtilsKt.noChange$lambda$0(completableDeferred, obj);
                return noChange$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object noChange$lambda$0(CompletableDeferred $deferred, Object $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        $deferred.complete($this$mutate);
        return $this$mutate;
    }

    public static final <InputState> ChangedState<InputState> mutate(State<InputState> state, final CompletableDeferred<? super InputState> completableDeferred, final Function1<? super InputState, ? extends InputState> function1) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        Intrinsics.checkNotNullParameter(function1, "reducer");
        return state.mutate(new Function1() { // from class: kntr.common.ouro.core.utils.FlowReduxUtilsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Object mutate$lambda$0;
                mutate$lambda$0 = FlowReduxUtilsKt.mutate$lambda$0(function1, completableDeferred, obj);
                return mutate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object mutate$lambda$0(Function1 $reducer, CompletableDeferred $deferred, Object $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Object newState = $reducer.invoke($this$mutate);
        $deferred.complete(newState);
        return newState;
    }

    public static final <InputState, S> ChangedState<S> override(State<InputState> state, final CompletableDeferred<? super S> completableDeferred, final Function1<? super InputState, ? extends S> function1) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        Intrinsics.checkNotNullParameter(function1, "reducer");
        return state.override(new Function1<InputState, S>() { // from class: kntr.common.ouro.core.utils.FlowReduxUtilsKt$override$1
            public final S invoke(InputState inputstate) {
                Intrinsics.checkNotNullParameter(inputstate, "$this$override");
                S s = (S) function1.invoke(inputstate);
                completableDeferred.complete(s);
                return s;
            }
        });
    }
}