package kntr.app.upcomingEpisode.base.stateMachine;

import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CancelReserveCardHandlerKt;
import kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt;
import kntr.app.upcomingEpisode.base.handler.ReserveCardHandlerKt;
import kntr.app.upcomingEpisode.base.handler.UpcomingEpisodeTrackerHandlerKt;
import kntr.app.upcomingEpisode.base.handler.WatchCalendarHandlerKt;
import kntr.app.upcomingEpisode.base.stateMachine.PageStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: UpcomingEpisodeStateMachine.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0002J\u001e\u0010\t\u001a\u00020\u0007*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0002¨\u0006\f"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "<init>", "()V", "build", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "initialLoad", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeStateMachine extends FlowReduxStateMachine<UpcomingEpisodeData, UpcomingEpisodeAction> {
    private static final String TAG = "UpcomingEpisodeStateMachine";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public UpcomingEpisodeStateMachine() {
        super(new UpcomingEpisodeData(false, null, null, null, null, null, null, null, false, 511, null));
        spec(new Function1() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = UpcomingEpisodeStateMachine._init_$lambda$0(UpcomingEpisodeStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(UpcomingEpisodeStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        UpcomingEpisodeTrackerHandlerKt.bindTrackerAction($this$spec);
        this$0.build($this$spec);
        return Unit.INSTANCE;
    }

    private final void build(FlowReduxStoreBuilder<UpcomingEpisodeData, UpcomingEpisodeAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit build$lambda$0;
                build$lambda$0 = UpcomingEpisodeStateMachine.build$lambda$0(UpcomingEpisodeStateMachine.this, (InStateBuilderBlock) obj);
                return build$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(UpcomingEpisodeData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit build$lambda$0(UpcomingEpisodeStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.initialLoad($this$inState);
        DeleteCalendarCardHandlerKt.bindDeleteAction($this$inState);
        WatchCalendarHandlerKt.bindCalendarAction($this$inState);
        ReserveCardHandlerKt.bindReserveCardAction($this$inState);
        CancelReserveCardHandlerKt.bindCancelReserveCardAction($this$inState);
        return Unit.INSTANCE;
    }

    private final void initialLoad(InStateBuilderBlock<UpcomingEpisodeData, UpcomingEpisodeData, UpcomingEpisodeAction> inStateBuilderBlock) {
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$0;
                initialLoad$lambda$0 = UpcomingEpisodeStateMachine.initialLoad$lambda$0((UpcomingEpisodeData) obj);
                return Boolean.valueOf(initialLoad$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$1;
                initialLoad$lambda$1 = UpcomingEpisodeStateMachine.initialLoad$lambda$1((ConditionBuilderBlock) obj);
                return initialLoad$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                boolean initialLoad$lambda$2;
                initialLoad$lambda$2 = UpcomingEpisodeStateMachine.initialLoad$lambda$2((UpcomingEpisodeData) obj);
                return Boolean.valueOf(initialLoad$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit initialLoad$lambda$3;
                initialLoad$lambda$3 = UpcomingEpisodeStateMachine.initialLoad$lambda$3(UpcomingEpisodeStateMachine.this, (ConditionBuilderBlock) obj);
                return initialLoad$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$0(UpcomingEpisodeData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getPageStatus(), PageStatus.Idle.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new UpcomingEpisodeStateMachine$initialLoad$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialLoad$lambda$2(UpcomingEpisodeData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getHasRequestCalendarApi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialLoad$lambda$3(UpcomingEpisodeStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnterEffect(new UpcomingEpisodeStateMachine$initialLoad$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* compiled from: UpcomingEpisodeStateMachine.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeStateMachine$Companion;", "", "<init>", "()V", "TAG", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}