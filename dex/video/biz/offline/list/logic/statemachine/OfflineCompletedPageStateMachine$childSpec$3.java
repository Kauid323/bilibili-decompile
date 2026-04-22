package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.list.logic.model.DialogType;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* compiled from: OfflineCompletedPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$Delete;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$childSpec$3", f = "OfflineCompletedPageStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineCompletedPageStateMachine$childSpec$3 extends SuspendLambda implements Function3<OfflineListAction.Delete, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineCompletedPageStateMachine$childSpec$3(Continuation<? super OfflineCompletedPageStateMachine$childSpec$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OfflineListAction.Delete delete, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineCompletedPageStateMachine$childSpec$3 offlineCompletedPageStateMachine$childSpec$3 = new OfflineCompletedPageStateMachine$childSpec$3(continuation);
        offlineCompletedPageStateMachine$childSpec$3.L$0 = delete;
        offlineCompletedPageStateMachine$childSpec$3.L$1 = state;
        return offlineCompletedPageStateMachine$childSpec$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Iterable $this$any$iv;
        OfflineCachedCardModel it;
        OfflineListAction.Delete action = (OfflineListAction.Delete) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable tasks = ((OfflinePageState) state.getSnapshot()).selectedCompletedTask(action.getKey());
                Iterable $this$map$iv = tasks;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    OfflineCachedCardModel it2 = (OfflineCachedCardModel) item$iv$iv;
                    destination$iv$iv.add(it2.getKeys());
                }
                final List taskKeys = CollectionsKt.flatten((List) destination$iv$iv);
                Iterable $this$any$iv2 = tasks;
                if (($this$any$iv2 instanceof Collection) && ((Collection) $this$any$iv2).isEmpty()) {
                    $this$any$iv = null;
                } else {
                    Iterator<T> it3 = $this$any$iv2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            Object element$iv = it3.next();
                            OfflineCachedCardModel it4 = (OfflineCachedCardModel) element$iv;
                            if (it4.getChildCount() > 1) {
                                it = 1;
                                continue;
                            } else {
                                it = null;
                                continue;
                            }
                            if (it != null) {
                                $this$any$iv = 1;
                            }
                        } else {
                            $this$any$iv = null;
                        }
                    }
                }
                LogKt.getVBLog().info("OfflineCompletedPageStateMachine delete action: " + action + ", taskKeys: " + taskKeys + ", hasGroup: " + ($this$any$iv != null));
                final boolean z = $this$any$iv != null;
                return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$childSpec$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflinePageState invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = OfflineCompletedPageStateMachine$childSpec$3.invokeSuspend$lambda$2(taskKeys, z, (OfflinePageState) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState invokeSuspend$lambda$2(List $taskKeys, boolean $hasGroup, OfflinePageState $this$override) {
        OfflinePageState copy;
        copy = $this$override.copy((r18 & 1) != 0 ? $this$override.downloading : null, (r18 & 2) != 0 ? $this$override.completed : null, (r18 & 4) != 0 ? $this$override.dataState : null, (r18 & 8) != 0 ? $this$override.selectionState : null, (r18 & 16) != 0 ? $this$override.config : null, (r18 & 32) != 0 ? $this$override.storageInfo : null, (r18 & 64) != 0 ? $this$override.reserveInfo : null, (r18 & 128) != 0 ? $this$override.dialogType : new DialogType.DeleteAlert($taskKeys, $hasGroup));
        return copy;
    }
}