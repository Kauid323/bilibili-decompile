package tv.danmaku.biliplayerv2.service;

import bili.resource.common.R;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NormalVideoPlayHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$updateMediaResource$1", f = "NormalVideoPlayHandler.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class NormalVideoPlayHandler$updateMediaResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $autoStart;
    final /* synthetic */ int $currentPosition;
    final /* synthetic */ AbsMediaResourceResolveTask $mediaResourceResolveTask;
    final /* synthetic */ ResolveListener $outerResolveListener;
    final /* synthetic */ Video.PlayableParams $playableParams;
    int label;
    final /* synthetic */ NormalVideoPlayHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalVideoPlayHandler$updateMediaResource$1(AbsMediaResourceResolveTask absMediaResourceResolveTask, ResolveListener resolveListener, Video.PlayableParams playableParams, NormalVideoPlayHandler normalVideoPlayHandler, boolean z, int i, Continuation<? super NormalVideoPlayHandler$updateMediaResource$1> continuation) {
        super(2, continuation);
        this.$mediaResourceResolveTask = absMediaResourceResolveTask;
        this.$outerResolveListener = resolveListener;
        this.$playableParams = playableParams;
        this.this$0 = normalVideoPlayHandler;
        this.$autoStart = z;
        this.$currentPosition = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NormalVideoPlayHandler$updateMediaResource$1(this.$mediaResourceResolveTask, this.$outerResolveListener, this.$playableParams, this.this$0, this.$autoStart, this.$currentPosition, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$mediaResourceResolveTask.run();
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$mediaResourceResolveTask, this.$outerResolveListener, this.$playableParams, this.this$0, this.$autoStart, this.$currentPosition, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NormalVideoPlayHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$updateMediaResource$1$1", f = "NormalVideoPlayHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$updateMediaResource$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $autoStart;
        final /* synthetic */ int $currentPosition;
        final /* synthetic */ AbsMediaResourceResolveTask $mediaResourceResolveTask;
        final /* synthetic */ ResolveListener $outerResolveListener;
        final /* synthetic */ Video.PlayableParams $playableParams;
        int label;
        final /* synthetic */ NormalVideoPlayHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AbsMediaResourceResolveTask absMediaResourceResolveTask, ResolveListener resolveListener, Video.PlayableParams playableParams, NormalVideoPlayHandler normalVideoPlayHandler, boolean z, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mediaResourceResolveTask = absMediaResourceResolveTask;
            this.$outerResolveListener = resolveListener;
            this.$playableParams = playableParams;
            this.this$0 = normalVideoPlayHandler;
            this.$autoStart = z;
            this.$currentPosition = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$mediaResourceResolveTask, this.$outerResolveListener, this.$playableParams, this.this$0, this.$autoStart, this.$currentPosition, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    MediaResource it = this.$mediaResourceResolveTask.getResult();
                    if (it != null) {
                        NormalVideoPlayHandler.updateMediaResource$finishResolver(this.this$0, this.$autoStart, this.$playableParams, this.$currentPosition, it);
                    }
                    if (this.$outerResolveListener != null && this.$mediaResourceResolveTask.getResult() != null) {
                        this.$outerResolveListener.onResolveSucceed(this.$playableParams);
                    } else {
                        ResolveListener resolveListener = this.$outerResolveListener;
                        if (resolveListener != null) {
                            resolveListener.onResolveFailed(this.$playableParams, FoundationAlias.getFapp().getString(R.string.common_global_string_91));
                        }
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}