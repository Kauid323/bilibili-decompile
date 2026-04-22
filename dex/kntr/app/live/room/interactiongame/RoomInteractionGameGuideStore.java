package kntr.app.live.room.interactiongame;

import kntr.app.live.room.interactiongame.LiveRoomInteractionGuideEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.udf.Store;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: RoomInteractionGameGuideStore.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0097@¢\u0006\u0002\u0010\u001cR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lkntr/app/live/room/interactiongame/RoomInteractionGameGuideStore;", "Lkntr/base/udf/Store;", "Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideState;", "Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideEvent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "stateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "actionFlow", "dataList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/live/room/interactiongame/GuideModel;", "[Lkntr/app/live/room/interactiongame/GuideModel;", "currentIndex", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "(Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "interactiongame_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RoomInteractionGameGuideStore implements Store<LiveRoomInteractionGuideState, LiveRoomInteractionGuideEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "RoomInteractionGameGuideStore";
    private final MutableSharedFlow<LiveRoomInteractionGuideState> _stateFlow;
    private final MutableSharedFlow<LiveRoomInteractionGuideEvent> actionFlow;
    private int currentIndex;
    private final GuideModel[] dataList;
    private final Flow<LiveRoomInteractionGuideState> state;
    private final SharedFlow<LiveRoomInteractionGuideState> stateFlow;

    public static /* synthetic */ void getState$annotations() {
    }

    public RoomInteractionGameGuideStore(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this._stateFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.stateFlow = FlowKt.asSharedFlow(this._stateFlow);
        this.actionFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.dataList = new GuideModel[]{new GuideModel("live_interaction_game_guide_step1", new GuideLayoutInfo(GuideLayoutType.Bottom)), new GuideModel("live_interaction_game_guide_step2", new GuideLayoutInfo(GuideLayoutType.Center)), new GuideModel("live_interaction_game_guide_step3", new GuideLayoutInfo(GuideLayoutType.Bottom)), new GuideModel("live_interaction_game_guide_step4", new GuideLayoutInfo(GuideLayoutType.Bottom))};
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        this.state = this.stateFlow;
    }

    public /* bridge */ /* synthetic */ Object dispatch(Object action, Continuation $completion) {
        return dispatch((LiveRoomInteractionGuideEvent) action, (Continuation<? super Unit>) $completion);
    }

    /* compiled from: RoomInteractionGameGuideStore.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.live.room.interactiongame.RoomInteractionGameGuideStore$1", f = "RoomInteractionGameGuideStore.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.live.room.interactiongame.RoomInteractionGameGuideStore$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MutableSharedFlow mutableSharedFlow = RoomInteractionGameGuideStore.this.actionFlow;
                    final RoomInteractionGameGuideStore roomInteractionGameGuideStore = RoomInteractionGameGuideStore.this;
                    this.label = 1;
                    if (mutableSharedFlow.collect(new FlowCollector() { // from class: kntr.app.live.room.interactiongame.RoomInteractionGameGuideStore.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((LiveRoomInteractionGuideEvent) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(LiveRoomInteractionGuideEvent it, Continuation<? super Unit> continuation) {
                            boolean z = it instanceof LiveRoomInteractionGuideEvent.DidPopOutGuideView;
                            String str = RoomRecommendViewModel.EMPTY_CURSOR;
                            if (z) {
                                boolean dismiss = RoomInteractionGameGuideStore.this.dataList.length == 0;
                                MutableSharedFlow mutableSharedFlow2 = RoomInteractionGameGuideStore.this._stateFlow;
                                if (!dismiss) {
                                    str = ((GuideModel) ArraysKt.first(RoomInteractionGameGuideStore.this.dataList)).getImgName();
                                }
                                Object emit = mutableSharedFlow2.emit(new LiveRoomInteractionGuideState(dismiss, new GuideModel(str, dismiss ? new GuideLayoutInfo(null, 1, null) : ((GuideModel) ArraysKt.first(RoomInteractionGameGuideStore.this.dataList)).getLayoutInfo())), continuation);
                                return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
                            } else if (it instanceof LiveRoomInteractionGuideEvent.DidClickActionButton) {
                                RoomInteractionGameGuideStore.this.currentIndex++;
                                boolean dismiss2 = RoomInteractionGameGuideStore.this.currentIndex >= RoomInteractionGameGuideStore.this.dataList.length;
                                MutableSharedFlow mutableSharedFlow3 = RoomInteractionGameGuideStore.this._stateFlow;
                                if (!dismiss2) {
                                    str = RoomInteractionGameGuideStore.this.dataList[RoomInteractionGameGuideStore.this.currentIndex].getImgName();
                                }
                                Object emit2 = mutableSharedFlow3.emit(new LiveRoomInteractionGuideState(dismiss2, new GuideModel(str, dismiss2 ? new GuideLayoutInfo(null, 1, null) : RoomInteractionGameGuideStore.this.dataList[RoomInteractionGameGuideStore.this.currentIndex].getLayoutInfo())), continuation);
                                return emit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit2 : Unit.INSTANCE;
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }

    public Flow<LiveRoomInteractionGuideState> getState() {
        return this.state;
    }

    public Object dispatch(LiveRoomInteractionGuideEvent action, Continuation<? super Unit> continuation) {
        Object emit = this.actionFlow.emit(action, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    /* compiled from: RoomInteractionGameGuideStore.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/live/room/interactiongame/RoomInteractionGameGuideStore$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "interactiongame_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}