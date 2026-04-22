package tv.danmaku.biliplayerimpl.videodirector;

import bili.resource.common.R;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService;
import tv.danmaku.biliplayerv2.DisplayOrientation;
import tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.VideoDirectorObserver;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.report.PlayerReportCommonField;
import tv.danmaku.biliplayerv2.service.report.heartbeat.ReportStrategy;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayDirectorServiceV3.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$processItem$2", f = "PlayDirectorServiceV3.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PlayDirectorServiceV3$processItem$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IPlayDirectorServiceV3.Item $item;
    final /* synthetic */ IPlayDirectorServiceV3.Item $previousItem;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlayDirectorServiceV3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayDirectorServiceV3$processItem$2(IPlayDirectorServiceV3.Item item, PlayDirectorServiceV3 playDirectorServiceV3, IPlayDirectorServiceV3.Item item2, Continuation<? super PlayDirectorServiceV3$processItem$2> continuation) {
        super(2, continuation);
        this.$item = item;
        this.this$0 = playDirectorServiceV3;
        this.$previousItem = item2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> playDirectorServiceV3$processItem$2 = new PlayDirectorServiceV3$processItem$2(this.$item, this.this$0, this.$previousItem, continuation);
        playDirectorServiceV3$processItem$2.L$0 = obj;
        return playDirectorServiceV3$processItem$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayDirectorServiceV3.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$processItem$2$1", f = "PlayDirectorServiceV3.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$processItem$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IPlayDirectorServiceV3.Item $item;
        final /* synthetic */ IPlayDirectorServiceV3.Item $previousItem;
        int label;
        final /* synthetic */ PlayDirectorServiceV3 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IPlayDirectorServiceV3.Item item, PlayDirectorServiceV3 playDirectorServiceV3, IPlayDirectorServiceV3.Item item2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$item = item;
            this.this$0 = playDirectorServiceV3;
            this.$previousItem = item2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$item, this.this$0, this.$previousItem, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IRenderContainerService iRenderContainerService;
            HeartbeatService heartbeatService;
            PlayerReportCommonField playerReportCommonField;
            IReporterService iReporterService;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    BLog.i("processItem");
                    Video.PlayableParams playableParams = this.$item.getPlayableParams();
                    PlayDirectorServiceV3 playDirectorServiceV3 = this.this$0;
                    IPlayDirectorServiceV3.Item item = this.$previousItem;
                    IReporterService iReporterService2 = null;
                    playDirectorServiceV3.dispatchItemWillChange(playableParams, item != null ? item.getPlayableParams() : null);
                    iRenderContainerService = this.this$0.renderContainerService;
                    if (iRenderContainerService == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("renderContainerService");
                        iRenderContainerService = null;
                    }
                    iRenderContainerService.notifyVideoChanged();
                    this.this$0.dispatchItemStart(playableParams);
                    Video.ReportCommonParams reportCommonParams = playableParams.getReportCommonParams();
                    heartbeatService = this.this$0.heartbeatService;
                    if (heartbeatService == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("heartbeatService");
                        heartbeatService = null;
                    }
                    heartbeatService.notifyMetaInfoChanged(reportCommonParams);
                    if (reportCommonParams != null) {
                        reportCommonParams.setReportStrategy(!Intrinsics.areEqual(playableParams.getFrom(), "live") ? ReportStrategy.NORMAL.INSTANCE : ReportStrategy.LIVE.INSTANCE);
                    }
                    if (reportCommonParams != null) {
                        playerReportCommonField = new PlayerReportCommonField(reportCommonParams.getAvid(), !Intrinsics.areEqual(playableParams.getFrom(), "live") ? reportCommonParams.getCid() : reportCommonParams.getRoomId(), reportCommonParams.getSeasonId(), reportCommonParams.getEpId(), reportCommonParams.getFromSpmid(), reportCommonParams.getSpmid(), reportCommonParams.getType(), reportCommonParams.getSubType(), reportCommonParams.getTrackId(), playableParams.getDisplayParams().getDisplayOrientation() == DisplayOrientation.VERTICAL, null, null, null, null, 15360, null);
                    } else {
                        playerReportCommonField = null;
                    }
                    PlayerReportCommonField reportCommonField = playerReportCommonField;
                    iReporterService = this.this$0.reportService;
                    if (iReporterService == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("reportService");
                    } else {
                        iReporterService2 = iReporterService;
                    }
                    iReporterService2.notifyVideoChanged(reportCommonField);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$item, this.this$0, this.$previousItem, null), 3, (Object) null);
                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$item, this.this$0, null), 3, (Object) null);
                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(this.this$0, null), 3, (Object) null);
                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass4(this.$item, this.this$0, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayDirectorServiceV3.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$processItem$2$2", f = "PlayDirectorServiceV3.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$processItem$2$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IPlayDirectorServiceV3.Item $item;
        int label;
        final /* synthetic */ PlayDirectorServiceV3 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(IPlayDirectorServiceV3.Item item, PlayDirectorServiceV3 playDirectorServiceV3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$item = item;
            this.this$0 = playDirectorServiceV3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$item, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<IPlayDirectorServiceV3.ItemEvent> internalEventFlow = this.$item.getInternalEventFlow();
                    final PlayDirectorServiceV3 playDirectorServiceV3 = this.this$0;
                    final IPlayDirectorServiceV3.Item item = this.$item;
                    this.label = 1;
                    if (internalEventFlow.collect(new FlowCollector() { // from class: tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3.processItem.2.2.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((IPlayDirectorServiceV3.ItemEvent) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(IPlayDirectorServiceV3.ItemEvent event, Continuation<? super Unit> continuation) {
                            Iterable iterable;
                            Iterable iterable2;
                            Iterable iterable3;
                            if (event instanceof IPlayDirectorServiceV3.ItemEvent.ResolveFailed) {
                                iterable3 = PlayDirectorServiceV3.this.observers;
                                Iterable $this$forEach$iv = iterable3;
                                IPlayDirectorServiceV3.Item item2 = item;
                                for (Object element$iv : $this$forEach$iv) {
                                    VideoDirectorObserver it = (VideoDirectorObserver) element$iv;
                                    it.onResolveFailed(item2.getPlayableParams(), FoundationAlias.getFapp().getString(R.string.common_global_string_91));
                                }
                            } else if (Intrinsics.areEqual(event, IPlayDirectorServiceV3.ItemEvent.Completed.INSTANCE)) {
                                iterable2 = PlayDirectorServiceV3.this.observers;
                                Iterable $this$forEach$iv2 = iterable2;
                                IPlayDirectorServiceV3.Item item3 = item;
                                for (Object element$iv2 : $this$forEach$iv2) {
                                    VideoDirectorObserver it2 = (VideoDirectorObserver) element$iv2;
                                    it2.onItemCompleted(item3.getPlayableParams());
                                }
                            } else if (Intrinsics.areEqual(event, IPlayDirectorServiceV3.ItemEvent.ResolveSuccess.INSTANCE)) {
                                iterable = PlayDirectorServiceV3.this.observers;
                                Iterable $this$forEach$iv3 = iterable;
                                IPlayDirectorServiceV3.Item item4 = item;
                                for (Object element$iv3 : $this$forEach$iv3) {
                                    VideoDirectorObserver it3 = (VideoDirectorObserver) element$iv3;
                                    it3.onResolveSucceed(item4.getPlayableParams());
                                }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayDirectorServiceV3.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$processItem$2$3", f = "PlayDirectorServiceV3.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$processItem$2$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PlayDirectorServiceV3 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PlayDirectorServiceV3 playDirectorServiceV3, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = playDirectorServiceV3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            HeartbeatService heartbeatService;
            IPlayerCoreService iPlayerCoreService;
            IPlayerCoreService iPlayerCoreService2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
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
            } catch (Throwable th) {
                BLog.i("end processItem");
                heartbeatService = this.this$0.heartbeatService;
                IPlayerCoreService iPlayerCoreService3 = null;
                if (heartbeatService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("heartbeatService");
                    heartbeatService = null;
                }
                iPlayerCoreService = this.this$0.playerCoreService;
                if (iPlayerCoreService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerCoreService");
                    iPlayerCoreService = null;
                }
                int currentQuality = iPlayerCoreService.getCurrentQuality();
                iPlayerCoreService2 = this.this$0.playerCoreService;
                if (iPlayerCoreService2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerCoreService");
                } else {
                    iPlayerCoreService3 = iPlayerCoreService2;
                }
                heartbeatService.notifyVideoEnd(currentQuality, iPlayerCoreService3.getRealCurrentPosition());
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayDirectorServiceV3.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$processItem$2$4", f = "PlayDirectorServiceV3.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$processItem$2$4  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IPlayDirectorServiceV3.Item $item;
        int label;
        final /* synthetic */ PlayDirectorServiceV3 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(IPlayDirectorServiceV3.Item item, PlayDirectorServiceV3 playDirectorServiceV3, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$item = item;
            this.this$0 = playDirectorServiceV3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$item, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow drop = FlowKt.drop(this.$item.getPlayableParamsFlow(), 1);
                    final PlayDirectorServiceV3 playDirectorServiceV3 = this.this$0;
                    this.label = 1;
                    if (drop.collect(new FlowCollector() { // from class: tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3.processItem.2.4.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((Video.PlayableParams) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(Video.PlayableParams playableParams, Continuation<? super Unit> continuation) {
                            Iterable iterable;
                            iterable = PlayDirectorServiceV3.this.observers;
                            Iterable $this$forEach$iv = iterable;
                            for (Object element$iv : $this$forEach$iv) {
                                VideoDirectorObserver it = (VideoDirectorObserver) element$iv;
                                it.onPlayableParamsChanged(playableParams);
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
}