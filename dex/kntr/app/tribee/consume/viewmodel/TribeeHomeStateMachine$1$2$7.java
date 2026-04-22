package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTitleTagPic;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeContent;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.pagination.KPaginationReply;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.page.model.TribeeDynListState;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$InsertFakeDyn;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$7", f = "TribeeHomeStateMachine.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {402, 466}, m = "invokeSuspend", n = {"action", "state", "action", "state", "currentEntry", "currentDynList", "finalList", "finalContent", "insertIndex"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 1)
public final class TribeeHomeStateMachine$1$2$7 extends SuspendLambda implements Function3<TribeeHomeStateAction.InsertFakeDyn, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$7(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$7> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.InsertFakeDyn insertFakeDyn, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$7 tribeeHomeStateMachine$1$2$7 = new TribeeHomeStateMachine$1$2$7(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$7.L$0 = insertFakeDyn;
        tribeeHomeStateMachine$1$2$7.L$1 = state;
        return tribeeHomeStateMachine$1$2$7.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object] */
    public final Object invokeSuspend(Object $result) {
        final Ref.ObjectRef currentEntry;
        Object obj;
        Iterable $this$any$iv;
        KTribeeDyn it;
        int i;
        final TribeeDynListState finalContent;
        List currentDynList;
        int insertIndex;
        TribeeDynListState finalContent2;
        List finalList;
        boolean z;
        ?? r10;
        Map.Entry it2;
        Map.Entry it3;
        final TribeeHomeStateAction.InsertFakeDyn action = (TribeeHomeStateAction.InsertFakeDyn) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (((TribeeHomeContentState) state.getSnapshot()).getCategoryList().isEmpty()) {
                    this.L$0 = action;
                    this.L$1 = state;
                    this.label = 1;
                    if (this.this$0.dispatch(new TribeeHomeStateAction.FetchCategory(action.getCategoryId()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$7$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            TribeeHomeContentState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$7.invokeSuspend$lambda$0(TribeeHomeStateAction.InsertFakeDyn.this, (TribeeHomeContentState) obj2);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                currentEntry = new Ref.ObjectRef();
                Iterator it4 = ((TribeeHomeContentState) state.getSnapshot()).getCategoryList().entrySet().iterator();
                while (true) {
                    if (it4.hasNext()) {
                        obj = it4.next();
                        Map.Entry it5 = (Map.Entry) obj;
                        if (((KTribeeCategory) it5.getKey()).getId() == action.getCategoryId()) {
                            it3 = 1;
                            continue;
                        } else {
                            it3 = null;
                            continue;
                        }
                        if (it3 != null) {
                        }
                    } else {
                        obj = null;
                    }
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry == null) {
                    Iterator it6 = ((TribeeHomeContentState) state.getSnapshot()).getCategoryList().entrySet().iterator();
                    while (true) {
                        if (it6.hasNext()) {
                            r10 = it6.next();
                            Map.Entry it7 = (Map.Entry) r10;
                            if (((KTribeeCategory) it7.getKey()).getId() == TribeeExtensionsKt.getDEFAULT_CATEGORY().getId()) {
                                it2 = 1;
                                continue;
                            } else {
                                it2 = null;
                                continue;
                            }
                            if (it2 != null) {
                            }
                        } else {
                            r10 = 0;
                        }
                    }
                    entry = r10;
                }
                currentEntry.element = entry;
                if (currentEntry.element == null) {
                    KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "back from publish page : resultKey = " + action.getResultKey() + ", add fake dynamic : id = " + action.getFakeDyn().getDynId() + "，but can not found category.");
                    return state.noChange();
                }
                List items = ((TribeeDynListState) ((Map.Entry) currentEntry.element).getValue()).items();
                List $this$any$iv2 = items;
                if (($this$any$iv2 instanceof Collection) && $this$any$iv2.isEmpty()) {
                    $this$any$iv = null;
                } else {
                    Iterator it8 = $this$any$iv2.iterator();
                    while (true) {
                        if (it8.hasNext()) {
                            Object element$iv = it8.next();
                            KTribeeDyn it9 = (KTribeeDyn) element$iv;
                            if (it9.getDynId() == action.getFakeDyn().getDynId()) {
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
                if ($this$any$iv != null) {
                    return state.noChange();
                }
                List $this$indexOfFirst$iv = !items.isEmpty() ? items : null;
                if ($this$indexOfFirst$iv != null) {
                    int index$iv = 0;
                    Iterator<KTribeeDyn> it10 = $this$indexOfFirst$iv.iterator();
                    while (true) {
                        if (it10.hasNext()) {
                            Object item$iv = it10.next();
                            KTribeeDyn it11 = (KTribeeDyn) item$iv;
                            Iterable $this$any$iv3 = it11.getTitleTags();
                            if (($this$any$iv3 instanceof Collection) && ((Collection) $this$any$iv3).isEmpty()) {
                                z = false;
                            } else {
                                Iterator it12 = $this$any$iv3.iterator();
                                while (true) {
                                    if (it12.hasNext()) {
                                        Object element$iv2 = it12.next();
                                        KTitleTagPic tag = (KTitleTagPic) element$iv2;
                                        if (Intrinsics.areEqual(tag.getType(), KTitleTagPic.KTitleTagPicType.TOP.INSTANCE)) {
                                            z = true;
                                        }
                                    } else {
                                        z = false;
                                    }
                                }
                            }
                            if (z) {
                                index$iv++;
                            } else {
                                i = index$iv;
                            }
                        } else {
                            i = -1;
                        }
                    }
                } else {
                    i = -1;
                }
                Integer boxInt = Boxing.boxInt(i);
                int it13 = boxInt.intValue();
                if (!(it13 >= 0)) {
                    boxInt = null;
                }
                int insertIndex2 = boxInt != null ? boxInt.intValue() : items.size();
                List finalList2 = CollectionsKt.toMutableList(items);
                finalList2.add(RangesKt.coerceAtLeast(insertIndex2, 0), action.getFakeDyn());
                TribeeDynListState tribeeDynListState = (TribeeDynListState) ((Map.Entry) currentEntry.element).getValue();
                KTribeeContent content = ((TribeeDynListState) ((Map.Entry) currentEntry.element).getValue()).getContent();
                TribeeDynListState finalContent3 = TribeeDynListState.copy$default(tribeeDynListState, null, content != null ? KTribeeContent.copy$default(content, finalList2, (KPaginationReply) null, 2, (Object) null) : null, null, 5, null);
                KLog_androidKt.getKLog().d("TribeeHomeStateMachine", "back from publish page : resultKey = " + action.getResultKey() + ", add fake dynamic : id = " + action.getFakeDyn().getDynId() + "，category id = " + action.getCategoryId() + ", insert index = " + insertIndex2);
                if (!items.isEmpty()) {
                    finalContent = finalContent3;
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$7$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2) {
                            TribeeHomeContentState invokeSuspend$lambda$8;
                            invokeSuspend$lambda$8 = TribeeHomeStateMachine$1$2$7.invokeSuspend$lambda$8(TribeeHomeStateAction.InsertFakeDyn.this, currentEntry, finalContent, (TribeeHomeContentState) obj2);
                            return invokeSuspend$lambda$8;
                        }
                    });
                }
                this.L$0 = action;
                this.L$1 = state;
                this.L$2 = currentEntry;
                this.L$3 = SpillingKt.nullOutSpilledVariable(items);
                this.L$4 = SpillingKt.nullOutSpilledVariable(finalList2);
                this.L$5 = finalContent3;
                this.I$0 = insertIndex2;
                this.label = 2;
                if (this.this$0.dispatch(new TribeeHomeStateAction.FetchCategory(action.getCategoryId()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                currentDynList = items;
                insertIndex = insertIndex2;
                finalContent2 = finalContent3;
                finalList = finalList2;
                finalContent = finalContent2;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$7$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        TribeeHomeContentState invokeSuspend$lambda$8;
                        invokeSuspend$lambda$8 = TribeeHomeStateMachine$1$2$7.invokeSuspend$lambda$8(TribeeHomeStateAction.InsertFakeDyn.this, currentEntry, finalContent, (TribeeHomeContentState) obj2);
                        return invokeSuspend$lambda$8;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$7$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        TribeeHomeContentState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$7.invokeSuspend$lambda$0(TribeeHomeStateAction.InsertFakeDyn.this, (TribeeHomeContentState) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 2:
                insertIndex = this.I$0;
                finalContent2 = (TribeeDynListState) this.L$5;
                finalList = (List) this.L$4;
                currentDynList = (List) this.L$3;
                currentEntry = (Ref.ObjectRef) this.L$2;
                ResultKt.throwOnFailure($result);
                finalContent = finalContent2;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$7$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        TribeeHomeContentState invokeSuspend$lambda$8;
                        invokeSuspend$lambda$8 = TribeeHomeStateMachine$1$2$7.invokeSuspend$lambda$8(TribeeHomeStateAction.InsertFakeDyn.this, currentEntry, finalContent, (TribeeHomeContentState) obj2);
                        return invokeSuspend$lambda$8;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$0(TribeeHomeStateAction.InsertFakeDyn $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        Map $this$invokeSuspend_u24lambda_u240_u240 = MapsKt.createMapBuilder();
        $this$invokeSuspend_u24lambda_u240_u240.put(TribeeExtensionsKt.getDEFAULT_CATEGORY(), new TribeeDynListState(new KTribeeContent(CollectionsKt.listOf($action.getFakeDyn()), (KPaginationReply) null, 2, (DefaultConstructorMarker) null), null));
        Unit unit = Unit.INSTANCE;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : MapsKt.build($this$invokeSuspend_u24lambda_u240_u240), (r20 & 16) != 0 ? $this$mutate.categoryId : TribeeExtensionsKt.getDEFAULT_CATEGORY().getId(), (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$8(TribeeHomeStateAction.InsertFakeDyn $action, Ref.ObjectRef $currentEntry, TribeeDynListState $finalContent, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        TribeeHomeUIAction.ScrollToTop scrollToTop = TribeeHomeUIAction.ScrollToTop.INSTANCE;
        long categoryId = $action.getCategoryId();
        Map $this$invokeSuspend_u24lambda_u248_u240 = MapsKt.toMutableMap($this$mutate.getCategoryList());
        $this$invokeSuspend_u24lambda_u248_u240.put(((Map.Entry) $currentEntry.element).getKey(), $finalContent);
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : $this$invokeSuspend_u24lambda_u248_u240, (r20 & 16) != 0 ? $this$mutate.categoryId : categoryId, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : scrollToTop);
        return copy;
    }
}