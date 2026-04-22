package im.session.track;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.base.IMLog;
import im.session.IMActionOnLoadFinished;
import im.session.IMState;
import im.session.IMStateLensKt;
import im.session.log.LogTagKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TechTracker.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", AuthActivity.ACTION_KEY, "Lim/session/IMActionOnLoadFinished;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.track.TechTrackerKt$bindTechTracker$1$2$1", f = "TechTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TechTrackerKt$bindTechTracker$1$2$1 extends SuspendLambda implements Function3<IMActionOnLoadFinished, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TechTrackerKt$bindTechTracker$1$2$1(Continuation<? super TechTrackerKt$bindTechTracker$1$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMActionOnLoadFinished iMActionOnLoadFinished, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        TechTrackerKt$bindTechTracker$1$2$1 techTrackerKt$bindTechTracker$1$2$1 = new TechTrackerKt$bindTechTracker$1$2$1(continuation);
        techTrackerKt$bindTechTracker$1$2$1.L$0 = iMActionOnLoadFinished;
        techTrackerKt$bindTechTracker$1$2$1.L$1 = state;
        return techTrackerKt$bindTechTracker$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final IMActionOnLoadFinished action = (IMActionOnLoadFinished) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.session.track.TechTrackerKt$bindTechTracker$1$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TechTrackerKt$bindTechTracker$1$2$1.invokeSuspend$lambda$0(IMActionOnLoadFinished.this, (IMState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$0(final IMActionOnLoadFinished $action, IMState $this$mutate) {
        return (IMState) CopyScopeKt.copy($this$mutate, new Function1() { // from class: im.session.track.TechTrackerKt$bindTechTracker$1$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = TechTrackerKt$bindTechTracker$1$2$1.invokeSuspend$lambda$0$0(IMActionOnLoadFinished.this, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(IMActionOnLoadFinished $action, CopyScope $this$copy) {
        if ($action.isCacheData() && Intrinsics.areEqual(IMSessionLoadTimeTrackLensKt.getCacheLoad(IMStateLensKt.getTechTrack(IMState.Companion)).get($this$copy.getCurrent()), Instant.Companion.getDISTANT_PAST())) {
            IMLog.Companion.i(LogTagKt.getTechTrackLogTag(), "set cache load");
            $this$copy.set(IMSessionLoadTimeTrackLensKt.getCacheLoad(IMStateLensKt.getTechTrack(IMState.Companion)), Clock.System.INSTANCE.now());
            if (IMSessionLoadTimeTrackLensKt.getFirstCacheError(IMStateLensKt.getTechTrack(IMState.Companion)).get($this$copy.getCurrent()) == null) {
                IMLog.Companion.i(LogTagKt.getTechTrackLogTag(), "set first cache error " + $action.getError());
                $this$copy.set(IMSessionLoadTimeTrackLensKt.getFirstCacheError(IMStateLensKt.getTechTrack(IMState.Companion)), $action.getError());
            }
        }
        if (!$action.isCacheData() && Intrinsics.areEqual(IMSessionLoadTimeTrackLensKt.getMossLoad(IMStateLensKt.getTechTrack(IMState.Companion)).get($this$copy.getCurrent()), Instant.Companion.getDISTANT_PAST())) {
            IMLog.Companion.i(LogTagKt.getTechTrackLogTag(), "set moss load");
            $this$copy.set(IMSessionLoadTimeTrackLensKt.getMossLoad(IMStateLensKt.getTechTrack(IMState.Companion)), Clock.System.INSTANCE.now());
            if (IMSessionLoadTimeTrackLensKt.getFirstMossError(IMStateLensKt.getTechTrack(IMState.Companion)).get($this$copy.getCurrent()) == null) {
                IMLog.Companion.i(LogTagKt.getTechTrackLogTag(), "set first moss error " + $action.getError());
                $this$copy.set(IMSessionLoadTimeTrackLensKt.getFirstMossError(IMStateLensKt.getTechTrack(IMState.Companion)), $action.getError());
            }
        }
        return Unit.INSTANCE;
    }
}