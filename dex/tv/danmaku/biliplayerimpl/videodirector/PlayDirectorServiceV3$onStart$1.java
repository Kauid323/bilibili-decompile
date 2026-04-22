package tv.danmaku.biliplayerimpl.videodirector;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3;
import tv.danmaku.biliplayerv2.service.IToastService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.Scope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCpuInfo;

/* compiled from: PlayDirectorServiceV3.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$onStart$1", f = "PlayDirectorServiceV3.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PlayDirectorServiceV3$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PlayDirectorServiceV3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayDirectorServiceV3$onStart$1(PlayDirectorServiceV3 playDirectorServiceV3, Continuation<? super PlayDirectorServiceV3$onStart$1> continuation) {
        super(2, continuation);
        this.this$0 = playDirectorServiceV3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayDirectorServiceV3$onStart$1(this.this$0, continuation);
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
                Ref.ObjectRef previousItem = new Ref.ObjectRef();
                flow = this.this$0.itemFlow;
                this.label = 1;
                if (FlowKt.collectLatest(flow, new AnonymousClass1(previousItem, this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
    /* compiled from: PlayDirectorServiceV3.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "item", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$onStart$1$1", f = "PlayDirectorServiceV3.kt", i = {}, l = {IjkCpuInfo.CPU_PART_SNAPDRAGON_S4_PRO}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerimpl.videodirector.PlayDirectorServiceV3$onStart$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<IPlayDirectorServiceV3.Item, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<IPlayDirectorServiceV3.Item> $previousItem;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PlayDirectorServiceV3 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<IPlayDirectorServiceV3.Item> objectRef, PlayDirectorServiceV3 playDirectorServiceV3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$previousItem = objectRef;
            this.this$0 = playDirectorServiceV3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$previousItem, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(IPlayDirectorServiceV3.Item item, Continuation<? super Unit> continuation) {
            return create(item, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object processItem;
            AbsFunctionWidgetService absFunctionWidgetService;
            Video.PlayableParams playableParams;
            IPlayerSettingService iPlayerSettingService;
            Video.PlayableParams playableParams2;
            IPlayerSettingService iPlayerSettingService2;
            Video.PlayableParams playableParams3;
            Video.DisplayParams displayParams;
            IToastService iToastService;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    IPlayDirectorServiceV3.Item item = (IPlayDirectorServiceV3.Item) this.L$0;
                    IPlayDirectorServiceV3.Item pi = (IPlayDirectorServiceV3.Item) this.$previousItem.element;
                    AbsFunctionWidgetService absFunctionWidgetService2 = null;
                    if (pi != null && pi.getPlayableParams().getInteractParams() == null) {
                        iToastService = this.this$0.toastService;
                        if (iToastService == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("toastService");
                            iToastService = null;
                        }
                        iToastService.removeAllToast();
                    }
                    if (item == null) {
                        return Unit.INSTANCE;
                    }
                    this.$previousItem.element = item;
                    boolean z = false;
                    if (pi != null && (playableParams3 = pi.getPlayableParams()) != null && (displayParams = playableParams3.getDisplayParams()) != null && item.getPlayableParams().getDisplayParams().getAvid() == displayParams.getAvid()) {
                        z = true;
                    }
                    if (!z) {
                        iPlayerSettingService2 = this.this$0.mPlayerSettingService;
                        if (iPlayerSettingService2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerSettingService");
                            iPlayerSettingService2 = null;
                        }
                        iPlayerSettingService2.removeAll(Scope.Video);
                    }
                    if (!Intrinsics.areEqual(item.getPlayableParams().id(), (pi == null || (playableParams2 = pi.getPlayableParams()) == null) ? null : playableParams2.id())) {
                        iPlayerSettingService = this.this$0.mPlayerSettingService;
                        if (iPlayerSettingService == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerSettingService");
                            iPlayerSettingService = null;
                        }
                        iPlayerSettingService.removeAll(Scope.VideoItem);
                    }
                    if (!Intrinsics.areEqual(item.getPlayableParams().id(), (pi == null || (playableParams = pi.getPlayableParams()) == null) ? null : playableParams.id())) {
                        absFunctionWidgetService = this.this$0.functionService;
                        if (absFunctionWidgetService == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("functionService");
                        } else {
                            absFunctionWidgetService2 = absFunctionWidgetService;
                        }
                        absFunctionWidgetService2.notifyVideoChanged();
                    }
                    this.label = 1;
                    processItem = this.this$0.processItem(item, pi, (Continuation) this);
                    if (processItem == coroutine_suspended) {
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