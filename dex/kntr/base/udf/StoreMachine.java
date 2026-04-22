package kntr.base.udf;

import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: StoreMachine.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0011*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u0011B6\b\u0001\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012#\u0010\u0006\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkntr/base/udf/StoreMachine;", "State", "", "Event", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "initialState", "specBlock", "Lkotlin/Function1;", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "state", "Lkotlinx/coroutines/flow/Flow;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "udf_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class StoreMachine<State, Event> extends FlowReduxStateMachine<State, Event> {
    public static final Companion Companion = new Companion(null);
    private final Flow<State> state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMachine(State state, final Function1<? super FlowReduxStoreBuilder<State, Event>, Unit> function1) {
        super(state);
        Intrinsics.checkNotNullParameter(state, "initialState");
        Intrinsics.checkNotNullParameter(function1, "specBlock");
        spec(new Function1() { // from class: kntr.base.udf.StoreMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = StoreMachine._init_$lambda$0(function1, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
        this.state = super.getState();
    }

    /* compiled from: StoreMachine.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\n\b\u0002\u0010\u0006\u0018\u0001*\u00020\u0001\"\b\b\u0003\u0010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u0002H\u00062%\b\b\u0010\t\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086\nø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"Lkntr/base/udf/StoreMachine$Companion;", "", "<init>", "()V", "invoke", "Lkntr/base/udf/StoreMachine;", "State", "Event", "initialState", "specBlock", "Lkotlin/Function1;", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkntr/base/udf/StoreMachine;", "udf_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ <State, Event> StoreMachine<State, Event> invoke(State state, Function1<? super FlowReduxStoreBuilder<State, Event>, Unit> function1) {
            Intrinsics.checkNotNullParameter(state, "initialState");
            Intrinsics.checkNotNullParameter(function1, "specBlock");
            return new StoreMachine<>(state, function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(Function1 $specBlock, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        $specBlock.invoke($this$spec);
        return Unit.INSTANCE;
    }

    public Flow<State> getState() {
        return this.state;
    }
}