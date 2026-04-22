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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.service.resolve.ResolvePlayerSDKTask;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.player.plugin.mod.IjkX86Helper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NormalVideoPlayHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$resolve$1", f = "NormalVideoPlayHandler.kt", i = {}, l = {453, 457, 477}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NormalVideoPlayHandler$resolve$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $autoStart;
    final /* synthetic */ Video.PlayableParams $playableParams;
    final /* synthetic */ int $startPosition;
    final /* synthetic */ Video $video;
    int label;
    final /* synthetic */ NormalVideoPlayHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalVideoPlayHandler$resolve$1(NormalVideoPlayHandler normalVideoPlayHandler, Video.PlayableParams playableParams, Video video2, int i, boolean z, Continuation<? super NormalVideoPlayHandler$resolve$1> continuation) {
        super(2, continuation);
        this.this$0 = normalVideoPlayHandler;
        this.$playableParams = playableParams;
        this.$video = video2;
        this.$startPosition = i;
        this.$autoStart = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NormalVideoPlayHandler$resolve$1(this.this$0, this.$playableParams, this.$video, this.$startPosition, this.$autoStart, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        AbsMediaResourceResolveTask.HistoryProgressReader historyProgressReader;
        MediaResource mediaResource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!ResolvePlayerSDKTask.Companion.getLoadSdkSucceed() && IjkX86Helper.isX86Device()) {
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    new ResolvePlayerSDKTask().run();
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                AbsMediaResourceResolveTask mediaResourceResolveTask = this.this$0.getMPlayerContainer().getVideoPlayDirectorService().getCommonResolveTaskProvider().provideMediaSourceResolveTask(this.this$0.getMPlayerContainer().getContext(), true, true, this.$playableParams);
                historyProgressReader = this.this$0.mHistoryProgressReader;
                if (historyProgressReader == null) {
                    historyProgressReader = new AbsMediaResourceResolveTask.HistoryProgressReader(this.$playableParams, null, 2, null);
                }
                mediaResourceResolveTask.setHistoryProgressReader(historyProgressReader);
                mediaResourceResolveTask.run();
                mediaResource = mediaResourceResolveTask.getResult();
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(mediaResource, this.this$0, this.$video, this.$playableParams, this.$startPosition, this.$autoStart, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                new ResolvePlayerSDKTask().run();
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                }
                AbsMediaResourceResolveTask mediaResourceResolveTask2 = this.this$0.getMPlayerContainer().getVideoPlayDirectorService().getCommonResolveTaskProvider().provideMediaSourceResolveTask(this.this$0.getMPlayerContainer().getContext(), true, true, this.$playableParams);
                historyProgressReader = this.this$0.mHistoryProgressReader;
                if (historyProgressReader == null) {
                }
                mediaResourceResolveTask2.setHistoryProgressReader(historyProgressReader);
                mediaResourceResolveTask2.run();
                mediaResource = mediaResourceResolveTask2.getResult();
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(mediaResource, this.this$0, this.$video, this.$playableParams, this.$startPosition, this.$autoStart, null), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                AbsMediaResourceResolveTask mediaResourceResolveTask22 = this.this$0.getMPlayerContainer().getVideoPlayDirectorService().getCommonResolveTaskProvider().provideMediaSourceResolveTask(this.this$0.getMPlayerContainer().getContext(), true, true, this.$playableParams);
                historyProgressReader = this.this$0.mHistoryProgressReader;
                if (historyProgressReader == null) {
                }
                mediaResourceResolveTask22.setHistoryProgressReader(historyProgressReader);
                mediaResourceResolveTask22.run();
                mediaResource = mediaResourceResolveTask22.getResult();
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(mediaResource, this.this$0, this.$video, this.$playableParams, this.$startPosition, this.$autoStart, null), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NormalVideoPlayHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$resolve$1$1", f = "NormalVideoPlayHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$resolve$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NormalVideoPlayHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NormalVideoPlayHandler normalVideoPlayHandler, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = normalVideoPlayHandler;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    NormalVideoPlayHandler.resolve$startLoadSdk(this.this$0);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NormalVideoPlayHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$resolve$1$2", f = "NormalVideoPlayHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$resolve$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NormalVideoPlayHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(NormalVideoPlayHandler normalVideoPlayHandler, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = normalVideoPlayHandler;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    NormalVideoPlayHandler.resolve$finishLoadSdk(this.this$0);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NormalVideoPlayHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$resolve$1$3", f = "NormalVideoPlayHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler$resolve$1$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $autoStart;
        final /* synthetic */ MediaResource $mediaResource;
        final /* synthetic */ Video.PlayableParams $playableParams;
        final /* synthetic */ int $startPosition;
        final /* synthetic */ Video $video;
        int label;
        final /* synthetic */ NormalVideoPlayHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(MediaResource mediaResource, NormalVideoPlayHandler normalVideoPlayHandler, Video video2, Video.PlayableParams playableParams, int i, boolean z, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$mediaResource = mediaResource;
            this.this$0 = normalVideoPlayHandler;
            this.$video = video2;
            this.$playableParams = playableParams;
            this.$startPosition = i;
            this.$autoStart = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$mediaResource, this.this$0, this.$video, this.$playableParams, this.$startPosition, this.$autoStart, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (this.$mediaResource != null) {
                        NormalVideoPlayHandler.resolve$resolveMediaResourceSucceed(this.$playableParams, this.this$0, this.$startPosition, this.$autoStart, this.$mediaResource);
                        this.this$0.getMVideoPlayEventDispatcher().dispatchResolveSucceed();
                    } else {
                        this.this$0.getMPlayerCoreService().pause();
                        IVideosPlayDirectorService.IVideoPlayEventDispatcher mVideoPlayEventDispatcher = this.this$0.getMVideoPlayEventDispatcher();
                        Video video2 = this.$video;
                        Video.PlayableParams playableParams = this.$playableParams;
                        String string = FoundationAlias.getFapp().getString(R.string.common_global_string_91);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        mVideoPlayEventDispatcher.dispatchResolveFailed(video2, playableParams, string);
                    }
                    this.this$0.getMPlayerContainer().getVideoPlayDirectorService().resolveDanmaku();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}