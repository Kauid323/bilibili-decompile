package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote;

import com.bilibili.lib.media.resource.ExtraInfo;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosMessageSender;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PlaybackStatusChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RemoteServiceHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$onBindPlayerContainer$1", f = "RemoteServiceHandler.kt", i = {}, l = {391}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RemoteServiceHandler$onBindPlayerContainer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayerContainer $playerContainer;
    int label;
    final /* synthetic */ RemoteServiceHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteServiceHandler$onBindPlayerContainer$1(RemoteServiceHandler remoteServiceHandler, PlayerContainer playerContainer, Continuation<? super RemoteServiceHandler$onBindPlayerContainer$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteServiceHandler;
        this.$playerContainer = playerContainer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteServiceHandler$onBindPlayerContainer$1(this.this$0, this.$playerContainer, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Flow flow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Ref.BooleanRef wasCompletionState = new Ref.BooleanRef();
                flow = this.this$0.playbackStatusRequestFlow;
                final PlayerContainer playerContainer = this.$playerContainer;
                Flow debounce = FlowKt.debounce(flow, new Function1() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$onBindPlayerContainer$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        long invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RemoteServiceHandler$onBindPlayerContainer$1.invokeSuspend$lambda$0(PlayerContainer.this, wasCompletionState, (PlaybackStatusChange.Request) obj);
                        return Long.valueOf(invokeSuspend$lambda$0);
                    }
                });
                final RemoteServiceHandler remoteServiceHandler = this.this$0;
                this.label = 1;
                if (debounce.collect(new FlowCollector() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$onBindPlayerContainer$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((PlaybackStatusChange.Request) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(PlaybackStatusChange.Request req, Continuation<? super Unit> continuation) {
                        ChronosMessageSender chronosMessageSender;
                        chronosMessageSender = RemoteServiceHandler.this.mChronosRpcSender;
                        IChronosRpcSender.CC.sendAsyncMessage$default(chronosMessageSender, req, null, 2, null);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invokeSuspend$lambda$0(PlayerContainer $playerContainer, Ref.BooleanRef $wasCompletionState, PlaybackStatusChange.Request it) {
        ExtraInfo extraInfo;
        MediaResource mediaResource = $playerContainer.getPlayerCoreService().getMediaResource();
        if ((mediaResource == null || (extraInfo = mediaResource.getExtraInfo()) == null || !extraInfo.shouldFilterProgressForDanmaku()) ? false : true) {
            int playerState = $playerContainer.getPlayerCoreService().getState();
            boolean shouldFilter = Intrinsics.areEqual(it.getPlaybackRate(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) && (playerState == 6 || playerState == 4 || (playerState == 5 && $wasCompletionState.element));
            long result = shouldFilter ? 500L : 0L;
            $wasCompletionState.element = playerState == 6;
            return result;
        }
        return 0L;
    }
}