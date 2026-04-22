package kntr.common.share.common.ui.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareLog;
import kntr.common.share.common.ui.ShareChannelList;
import kntr.common.share.common.ui.ShareMenuVM;
import kntr.common.share.common.ui.ShareMenuViewState;
import kntr.common.share.domain.model.ShareChannels;
import kntr.common.share.domain.model.ShareResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareMenuProcessor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.common.ui.internal.ShareMenuProcessorKt$processAction$3", f = "ShareMenuProcessor.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ShareMenuProcessorKt$processAction$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ShareChannelList, ShareChannelList> $handler;
    final /* synthetic */ ShareMenuVM $this_processAction;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShareMenuProcessorKt$processAction$3(ShareMenuVM shareMenuVM, Function1<? super ShareChannelList, ShareChannelList> function1, Continuation<? super ShareMenuProcessorKt$processAction$3> continuation) {
        super(2, continuation);
        this.$this_processAction = shareMenuVM;
        this.$handler = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareMenuProcessorKt$processAction$3(this.$this_processAction, this.$handler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object requestShareChannels;
        ShareChannelList defaultChannels;
        Object prevValue$iv;
        Object nextValue$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                requestShareChannels = this.$this_processAction.getDomain$common_ui_debug().requestShareChannels(this.$this_processAction.getSession(), (Continuation) this);
                if (requestShareChannels == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                requestShareChannels = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ShareResponse response = (ShareResponse) requestShareChannels;
        if (response instanceof ShareResponse.Success) {
            ShareLog.Companion.i("MenuViewModel", "load origin channels success.");
            defaultChannels = ShareMenuProcessorKt.toList((ShareChannels) ((ShareResponse.Success) response).getData());
        } else {
            ShareLog.Companion.i("MenuViewModel", "load origin channels failure, use default channels.");
            defaultChannels = ShareLocalResource.INSTANCE.getDefaultChannels(this.$this_processAction.getParams$common_ui_debug().getShareId(), this.$this_processAction.getParams$common_ui_debug().getShareOrigin());
        }
        ShareChannelList channels = defaultChannels;
        MutableStateFlow $this$update$iv = this.$this_processAction.getMState$common_ui_debug();
        Function1<ShareChannelList, ShareChannelList> function1 = this.$handler;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ShareMenuViewState it = (ShareMenuViewState) prevValue$iv;
            nextValue$iv = ShareMenuViewState.copy$default(it, false, false, true, (ShareChannelList) function1.invoke(channels), null, null, null, 113, null);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
        return Unit.INSTANCE;
    }
}