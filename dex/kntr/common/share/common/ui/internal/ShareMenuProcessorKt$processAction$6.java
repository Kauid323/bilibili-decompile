package kntr.common.share.common.ui.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareLog;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.ShareKt;
import kntr.common.share.common.ui.ShareMenuEffect;
import kntr.common.share.common.ui.ShareMenuVM;
import kntr.common.share.common.ui.ShareMenuViewAction;
import kntr.common.share.common.ui.ShareMenuViewState;
import kntr.common.share.common.ui.ShareToTargetState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareMenuProcessor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.common.ui.internal.ShareMenuProcessorKt$processAction$6", f = "ShareMenuProcessor.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ShareMenuProcessorKt$processAction$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShareMenuViewAction $action;
    final /* synthetic */ ShareTarget $target;
    final /* synthetic */ ShareMenuVM $this_processAction;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareMenuProcessorKt$processAction$6(ShareTarget shareTarget, ShareMenuVM shareMenuVM, ShareMenuViewAction shareMenuViewAction, Continuation<? super ShareMenuProcessorKt$processAction$6> continuation) {
        super(2, continuation);
        this.$target = shareTarget;
        this.$this_processAction = shareMenuVM;
        this.$action = shareMenuViewAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareMenuProcessorKt$processAction$6(this.$target, this.$this_processAction, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ShareLog.Companion.i("MenuViewModel", "start loading share content...");
                Flow<ShareToTargetState> shareToTargetWithFetch = ShareKt.shareToTargetWithFetch(ShareKt.gShare(), this.$target, this.$this_processAction.getSession(), (ShareContent) this.$this_processAction.getShareContentProvider$common_ui_debug().invoke(this.$target), ((ShareMenuViewAction.Click) this.$action).getContext(), ((Boolean) this.$this_processAction.getDisableFetchShareContent$common_ui_debug().invoke(this.$target)).booleanValue() ? null : this.$this_processAction.getDomain$common_ui_debug(), null);
                final ShareMenuVM shareMenuVM = this.$this_processAction;
                final ShareTarget shareTarget = this.$target;
                this.label = 1;
                if (shareToTargetWithFetch.collect(new FlowCollector() { // from class: kntr.common.share.common.ui.internal.ShareMenuProcessorKt$processAction$6.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((ShareToTargetState) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(ShareToTargetState state, Continuation<? super Unit> continuation) {
                        Object prevValue$iv;
                        Object nextValue$iv;
                        Object prevValue$iv2;
                        Object nextValue$iv2;
                        if (Intrinsics.areEqual(state, ShareToTargetState.Loading.INSTANCE)) {
                            MutableStateFlow $this$update$iv = ShareMenuVM.this.getMState$common_ui_debug();
                            do {
                                prevValue$iv2 = $this$update$iv.getValue();
                                ShareMenuViewState it = (ShareMenuViewState) prevValue$iv2;
                                nextValue$iv2 = ShareMenuViewState.copy$default(it, false, true, false, null, null, null, null, 125, null);
                            } while (!$this$update$iv.compareAndSet(prevValue$iv2, nextValue$iv2));
                        } else if (state instanceof ShareToTargetState.Loaded) {
                            MutableStateFlow $this$update$iv2 = ShareMenuVM.this.getMState$common_ui_debug();
                            do {
                                prevValue$iv = $this$update$iv2.getValue();
                                ShareMenuViewState it2 = (ShareMenuViewState) prevValue$iv;
                                nextValue$iv = ShareMenuViewState.copy$default(it2, false, false, false, null, null, ((ShareToTargetState.Loaded) state).getContent(), null, 93, null);
                            } while (!$this$update$iv2.compareAndSet(prevValue$iv, nextValue$iv));
                            ShareLog.Companion.i("MenuViewModel", "loaded share content.");
                            ShareMenuVM.this.getReporter$common_ui_debug().reportClickChannel(ShareMenuVM.this.getSession(), shareTarget, ((ShareToTargetState.Loaded) state).getContent().getMode(), ShareMenuVM.this.getExtraReportFields$common_ui_debug());
                        } else if (state instanceof ShareToTargetState.ShareFinish) {
                            MutableStateFlow $this$update$iv3 = ShareMenuVM.this.getMState$common_ui_debug();
                            while (true) {
                                Object prevValue$iv3 = $this$update$iv3.getValue();
                                ShareMenuViewState it3 = (ShareMenuViewState) prevValue$iv3;
                                Object nextValue$iv3 = ShareMenuViewState.copy$default(it3, false, false, false, null, null, null, ((ShareToTargetState.ShareFinish) state).getResult(), 63, null);
                                if ($this$update$iv3.compareAndSet(prevValue$iv3, nextValue$iv3)) {
                                    break;
                                }
                            }
                            ShareLog.Companion.i("MenuViewModel", "share completed : " + ((ShareToTargetState.ShareFinish) state).getResult() + ", " + ((ShareToTargetState.ShareFinish) state).getMessage());
                            Object emit = ShareMenuVM.this.getMEffect$common_ui_debug().emit(new ShareMenuEffect.ShowToast(((ShareToTargetState.ShareFinish) state).getMessage()), continuation);
                            return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        return Unit.INSTANCE;
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
        return Unit.INSTANCE;
    }
}