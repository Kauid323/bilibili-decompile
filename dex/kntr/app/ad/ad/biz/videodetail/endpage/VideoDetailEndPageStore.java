package kntr.app.ad.ad.biz.videodetail.endpage;

import com.bapis.bilibili.app.viewunite.common.KRelateCard;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.ad.ad.biz.videodetail.endpage.VDEndPageEvent;
import kntr.app.ad.ad.biz.videodetail.endpage.VDEndPageUiState;
import kntr.app.ad.common.protocol.IAdInfo;
import kntr.app.ad.domain.click.ClickService;
import kntr.app.ad.domain.click.Clicker;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.udf.Store;
import kntr.base.udf.StoreMachine;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: VDEndPageStore.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0097@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VideoDetailEndPageStore;", "Lkntr/base/udf/Store;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent;", "relateCard", "Lcom/bapis/bilibili/app/viewunite/common/KRelateCard;", "clickService", "Lkntr/app/ad/domain/click/ClickService;", "<init>", "(Lcom/bapis/bilibili/app/viewunite/common/KRelateCard;Lkntr/app/ad/domain/click/ClickService;)V", "clicker", "Lkntr/app/ad/domain/click/Clicker;", "getClicker", "()Lkntr/app/ad/domain/click/Clicker;", "clicker$delegate", "Lkotlin/Lazy;", "adInfo", "Lkntr/app/ad/common/protocol/IAdInfo;", ReportBuildInParam.MACHINE, "Lkntr/base/udf/StoreMachine;", "getMachine$annotations", "()V", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "(Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoDetailEndPageStore implements Store<VDEndPageUiState, VDEndPageEvent> {
    public static final int $stable = 8;
    private final IAdInfo adInfo;
    private final ClickService clickService;
    private final Lazy clicker$delegate;
    private final StoreMachine<VDEndPageUiState, VDEndPageEvent> machine;
    private final KRelateCard relateCard;
    private final Flow<VDEndPageUiState> state;

    private static /* synthetic */ void getMachine$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public VideoDetailEndPageStore(KRelateCard relateCard, ClickService clickService) {
        Intrinsics.checkNotNullParameter(relateCard, "relateCard");
        Intrinsics.checkNotNullParameter(clickService, "clickService");
        this.relateCard = relateCard;
        this.clickService = clickService;
        this.clicker$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.ad.biz.videodetail.endpage.VideoDetailEndPageStore$$ExternalSyntheticLambda0
            public final Object invoke() {
                Clicker clicker_delegate$lambda$0;
                clicker_delegate$lambda$0 = VideoDetailEndPageStore.clicker_delegate$lambda$0(VideoDetailEndPageStore.this);
                return clicker_delegate$lambda$0;
            }
        });
        this.adInfo = KRelateCardExtKt.asIAdInfo(this.relateCard);
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = VDEndPageUiState.Idle.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: kntr.app.ad.ad.biz.videodetail.endpage.VideoDetailEndPageStore$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit machine$lambda$0;
                machine$lambda$0 = VideoDetailEndPageStore.machine$lambda$0(VideoDetailEndPageStore.this, (FlowReduxStoreBuilder) obj);
                return machine$lambda$0;
            }
        };
        this.machine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.state = this.machine.getState();
    }

    public /* bridge */ /* synthetic */ Object dispatch(Object action, Continuation $completion) {
        return dispatch((VDEndPageEvent) action, (Continuation<? super Unit>) $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Clicker clicker_delegate$lambda$0(VideoDetailEndPageStore this$0) {
        return new Clicker(this$0.clickService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Clicker getClicker() {
        return (Clicker) this.clicker$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0(final VideoDetailEndPageStore this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.ad.ad.biz.videodetail.endpage.VideoDetailEndPageStore$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0;
                machine$lambda$0$0 = VideoDetailEndPageStore.machine$lambda$0$0(VideoDetailEndPageStore.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(VDEndPageUiState.Idle.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.ad.ad.biz.videodetail.endpage.VideoDetailEndPageStore$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$1;
                machine$lambda$0$1 = VideoDetailEndPageStore.machine$lambda$0$1(VideoDetailEndPageStore.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$1;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(VDEndPageUiState.Content.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0(VideoDetailEndPageStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new VideoDetailEndPageStore$machine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$1(VideoDetailEndPageStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new VideoDetailEndPageStore$machine$1$2$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(VDEndPageEvent.OnShown.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new VideoDetailEndPageStore$machine$1$2$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(VDEndPageEvent.OnStrictShown.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new VideoDetailEndPageStore$machine$1$2$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(VDEndPageEvent.CardClick.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new VideoDetailEndPageStore$machine$1$2$4(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(VDEndPageEvent.ButtonClick.class), executionPolicy$iv4, handler$iv4);
        return Unit.INSTANCE;
    }

    public Object dispatch(VDEndPageEvent action, Continuation<? super Unit> continuation) {
        Object dispatch = this.machine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public Flow<VDEndPageUiState> getState() {
        return this.state;
    }
}