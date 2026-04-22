package im.session.track;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import im.session.IMAction;
import im.session.IMActionOnLoadFinished;
import im.session.IMActionPageReady;
import im.session.IMState;
import kntr.base.moss.api.KBusinessException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: TechTracker.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¨\u0006\t"}, d2 = {"errorType", "", "", "errorCode", "bindTechTracker", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lim/session/IMState;", "Lim/session/IMAction;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TechTrackerKt {
    public static final String errorType(Throwable $this$errorType) {
        String simpleName = Reflection.getOrCreateKotlinClass($this$errorType.getClass()).getSimpleName();
        return simpleName == null ? "Unknown" : simpleName;
    }

    public static final String errorCode(Throwable $this$errorCode) {
        KBusinessException kBusinessException = $this$errorCode instanceof KBusinessException ? (KBusinessException) $this$errorCode : null;
        return String.valueOf(kBusinessException != null ? kBusinessException.getCode() : -1);
    }

    public static final void bindTechTracker(FlowReduxStoreBuilder<IMState, IMAction> flowReduxStoreBuilder) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Function1 block$iv = new Function1() { // from class: im.session.track.TechTrackerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit bindTechTracker$lambda$0;
                bindTechTracker$lambda$0 = TechTrackerKt.bindTechTracker$lambda$0((InStateBuilderBlock) obj);
                return bindTechTracker$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(IMState.class), block$iv);
    }

    public static final Unit bindTechTracker$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.condition(new Function1() { // from class: im.session.track.TechTrackerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean bindTechTracker$lambda$0$0;
                bindTechTracker$lambda$0$0 = TechTrackerKt.bindTechTracker$lambda$0$0((IMState) obj);
                return Boolean.valueOf(bindTechTracker$lambda$0$0);
            }
        }, new Function1() { // from class: im.session.track.TechTrackerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit bindTechTracker$lambda$0$1;
                bindTechTracker$lambda$0$1 = TechTrackerKt.bindTechTracker$lambda$0$1((ConditionBuilderBlock) obj);
                return bindTechTracker$lambda$0$1;
            }
        });
        $this$inState.condition(new Function1() { // from class: im.session.track.TechTrackerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean bindTechTracker$lambda$0$2;
                bindTechTracker$lambda$0$2 = TechTrackerKt.bindTechTracker$lambda$0$2((IMState) obj);
                return Boolean.valueOf(bindTechTracker$lambda$0$2);
            }
        }, new Function1() { // from class: im.session.track.TechTrackerKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit bindTechTracker$lambda$0$3;
                bindTechTracker$lambda$0$3 = TechTrackerKt.bindTechTracker$lambda$0$3((ConditionBuilderBlock) obj);
                return bindTechTracker$lambda$0$3;
            }
        });
        return Unit.INSTANCE;
    }

    public static final boolean bindTechTracker$lambda$0$0(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.getTechTrack$session_debug().getReadyToReport();
    }

    public static final Unit bindTechTracker$lambda$0$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new TechTrackerKt$bindTechTracker$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IMActionOnLoadFinished.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new TechTrackerKt$bindTechTracker$1$2$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IMActionPageReady.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    public static final boolean bindTechTracker$lambda$0$2(IMState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTechTrack$session_debug().getReadyToReport();
    }

    public static final Unit bindTechTracker$lambda$0$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnterEffect(new TechTrackerKt$bindTechTracker$1$4$1(null));
        return Unit.INSTANCE;
    }
}