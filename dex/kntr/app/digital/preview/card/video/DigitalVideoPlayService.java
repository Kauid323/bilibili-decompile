package kntr.app.digital.preview.card.video;

import androidx.compose.runtime.LongState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import java.io.IOException;
import java.util.Iterator;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.video.DigitalVideoPlayService;
import kntr.app.digital.preview.card.video.VideoCaptions;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: DigitalVideoPlayService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001=\b\u0001\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ,\u0010?\u001a\u00020@2\u001c\u0010A\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0C\u0012\u0006\u0012\u0004\u0018\u00010\u00010BH\u0086@¢\u0006\u0002\u0010DR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R/\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u00178B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R+\u0010$\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0016\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R+\u0010(\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u001f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0016\u001a\u0004\b)\u0010!\"\u0004\b*\u0010+R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R+\u00102\u001a\u0002012\u0006\u0010\u000e\u001a\u0002018F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00109\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>¨\u0006E"}, d2 = {"Lkntr/app/digital/preview/card/video/DigitalVideoPlayService;", RoomRecommendViewModel.EMPTY_CURSOR, "lifecycle", "Landroidx/lifecycle/Lifecycle;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "downloadCaptions", "Lkntr/app/digital/preview/card/video/DownloadCaptions;", "volumeService", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/CoroutineScope;Lkntr/app/digital/preview/card/DigitalCardStateService;Lkntr/app/digital/preview/card/video/DownloadCaptions;Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;)V", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "videoViewVisible", "getVideoViewVisible", "()Z", "setVideoViewVisible", "(Z)V", "videoViewVisible$delegate", "Landroidx/compose/runtime/MutableState;", "Lkntr/app/digital/preview/card/video/VideoCaptions;", "captions", "getCaptions", "()Lkntr/app/digital/preview/card/video/VideoCaptions;", "setCaptions", "(Lkntr/app/digital/preview/card/video/VideoCaptions;)V", "captions$delegate", "currentCaption", RoomRecommendViewModel.EMPTY_CURSOR, "getCurrentCaption", "()Ljava/lang/String;", "currentCaption$delegate", "Landroidx/compose/runtime/State;", "intendToPlay", "getIntendToPlay", "setIntendToPlay", "intendToPlay$delegate", "url", "getUrl", "setUrl", "(Ljava/lang/String;)V", "url$delegate", "simplePlayer", "Lcom/bilibili/framework/simpleplayer/SimplePlayer;", "getSimplePlayer", "()Lcom/bilibili/framework/simpleplayer/SimplePlayer;", RoomRecommendViewModel.EMPTY_CURSOR, "currentProgress", "getCurrentProgress", "()J", "setCurrentProgress", "(J)V", "currentProgress$delegate", "Landroidx/compose/runtime/MutableLongState;", "lastIntentToPlay", "getLastIntentToPlay", "setLastIntentToPlay", "lifecycleObserver", "kntr/app/digital/preview/card/video/DigitalVideoPlayService$lifecycleObserver$1", "Lkntr/app/digital/preview/card/video/DigitalVideoPlayService$lifecycleObserver$1;", "pauseAndResumeState", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalVideoPlayService {
    public static final int $stable = 8;
    private final MutableState captions$delegate;
    private final DigitalCardStateService cardStateService;
    private final CoroutineScope coroutineScope;
    private final State currentCaption$delegate;
    private final MutableLongState currentProgress$delegate;
    private final DownloadCaptions downloadCaptions;
    private final MutableState intendToPlay$delegate;
    private boolean lastIntentToPlay;
    private final Lifecycle lifecycle;
    private final DigitalVideoPlayService$lifecycleObserver$1 lifecycleObserver;
    private final SimplePlayer simplePlayer;
    private final MutableState url$delegate;
    private final MutableState videoViewVisible$delegate;
    private final DigitalVideoCardVolumeService volumeService;

    /* JADX WARN: Type inference failed for: r6v18, types: [kntr.app.digital.preview.card.video.DigitalVideoPlayService$lifecycleObserver$1] */
    @Inject
    public DigitalVideoPlayService(Lifecycle lifecycle, @BusinessCoroutineScope CoroutineScope coroutineScope, DigitalCardStateService cardStateService, DownloadCaptions downloadCaptions, DigitalVideoCardVolumeService volumeService) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(downloadCaptions, "downloadCaptions");
        Intrinsics.checkNotNullParameter(volumeService, "volumeService");
        this.lifecycle = lifecycle;
        this.coroutineScope = coroutineScope;
        this.cardStateService = cardStateService;
        this.downloadCaptions = downloadCaptions;
        this.volumeService = volumeService;
        this.videoViewVisible$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.captions$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.currentCaption$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.digital.preview.card.video.DigitalVideoPlayService$$ExternalSyntheticLambda0
            public final Object invoke() {
                String currentCaption_delegate$lambda$0;
                currentCaption_delegate$lambda$0 = DigitalVideoPlayService.currentCaption_delegate$lambda$0(DigitalVideoPlayService.this);
                return currentCaption_delegate$lambda$0;
            }
        });
        this.intendToPlay$delegate = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.url$delegate = SnapshotStateKt.mutableStateOf(RoomRecommendViewModel.EMPTY_CURSOR, SnapshotStateKt.neverEqualPolicy());
        final CoroutineScope coroutineScope2 = this.coroutineScope;
        this.simplePlayer = new SimplePlayer(coroutineScope2) { // from class: kntr.app.digital.preview.card.video.DigitalVideoPlayService$simplePlayer$1
            public String getUrl() {
                return DigitalVideoPlayService.this.getUrl();
            }

            public boolean getIntendToPlay() {
                return DigitalVideoPlayService.this.getIntendToPlay();
            }

            public float getVolume() {
                DigitalVideoCardVolumeService digitalVideoCardVolumeService;
                digitalVideoCardVolumeService = DigitalVideoPlayService.this.volumeService;
                return digitalVideoCardVolumeService.getVolumeOn() ? 1.0f : 0.0f;
            }

            public boolean getLoop() {
                return true;
            }

            /* renamed from: firstFrameRendered-LRDsOJo  reason: not valid java name */
            public void m945firstFrameRenderedLRDsOJo(long j2) {
                DigitalVideoPlayService.this.setVideoViewVisible(true);
            }
        };
        this.currentProgress$delegate = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.lifecycleObserver = new DefaultLifecycleObserver() { // from class: kntr.app.digital.preview.card.video.DigitalVideoPlayService$lifecycleObserver$1
            public /* bridge */ void onCreate(LifecycleOwner owner) {
                DefaultLifecycleObserver.-CC.$default$onCreate(this, owner);
            }

            public /* bridge */ void onDestroy(LifecycleOwner owner) {
                DefaultLifecycleObserver.-CC.$default$onDestroy(this, owner);
            }

            public /* bridge */ void onStart(LifecycleOwner owner) {
                DefaultLifecycleObserver.-CC.$default$onStart(this, owner);
            }

            public /* bridge */ void onStop(LifecycleOwner owner) {
                DefaultLifecycleObserver.-CC.$default$onStop(this, owner);
            }

            public void onPause(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                DigitalVideoPlayService.this.setLastIntentToPlay(DigitalVideoPlayService.this.getSimplePlayer().getIntendToPlay());
                DigitalVideoPlayService.this.setIntendToPlay(false);
            }

            public void onResume(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                DigitalVideoPlayService.this.setIntendToPlay(DigitalVideoPlayService.this.getLastIntentToPlay());
            }
        };
        this.lifecycle.addObserver(this.lifecycleObserver);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVideoViewVisible(boolean z) {
        MutableState $this$setValue$iv = this.videoViewVisible$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    public final boolean getVideoViewVisible() {
        State $this$getValue$iv = this.videoViewVisible$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private final VideoCaptions getCaptions() {
        State $this$getValue$iv = this.captions$delegate;
        return (VideoCaptions) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCaptions(VideoCaptions videoCaptions) {
        MutableState $this$setValue$iv = this.captions$delegate;
        $this$setValue$iv.setValue(videoCaptions);
    }

    public final String getCurrentCaption() {
        State $this$getValue$iv = this.currentCaption$delegate;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String currentCaption_delegate$lambda$0(DigitalVideoPlayService this$0) {
        Iterable captions;
        Object element$iv;
        VideoCaptions captions2 = this$0.getCaptions();
        if (captions2 == null || (captions = captions2.getCaptions()) == null) {
            return null;
        }
        Iterable $this$firstOrNull$iv = captions;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                VideoCaptions.Caption it2 = (VideoCaptions.Caption) element$iv;
                int startTime = it2.getStartTime();
                int endTime = it2.getEndTime();
                long currentProgress = this$0.getCurrentProgress();
                boolean z = false;
                if (startTime <= currentProgress && currentProgress <= endTime) {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        VideoCaptions.Caption caption = (VideoCaptions.Caption) element$iv;
        if (caption != null) {
            return caption.getTranscript();
        }
        return null;
    }

    public final boolean getIntendToPlay() {
        State $this$getValue$iv = this.intendToPlay$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setIntendToPlay(boolean z) {
        MutableState $this$setValue$iv = this.intendToPlay$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    public final String getUrl() {
        State $this$getValue$iv = this.url$delegate;
        return (String) $this$getValue$iv.getValue();
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        MutableState $this$setValue$iv = this.url$delegate;
        $this$setValue$iv.setValue(str);
    }

    public final SimplePlayer getSimplePlayer() {
        return this.simplePlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentProgress(long j2) {
        MutableLongState $this$setValue$iv = this.currentProgress$delegate;
        $this$setValue$iv.setLongValue(j2);
    }

    public final long getCurrentProgress() {
        LongState $this$getValue$iv = this.currentProgress$delegate;
        return $this$getValue$iv.getLongValue();
    }

    public final boolean getLastIntentToPlay() {
        return this.lastIntentToPlay;
    }

    public final void setLastIntentToPlay(boolean z) {
        this.lastIntentToPlay = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pauseAndResumeState(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        DigitalVideoPlayService$pauseAndResumeState$1 digitalVideoPlayService$pauseAndResumeState$1;
        try {
            if (continuation instanceof DigitalVideoPlayService$pauseAndResumeState$1) {
                digitalVideoPlayService$pauseAndResumeState$1 = (DigitalVideoPlayService$pauseAndResumeState$1) continuation;
                if ((digitalVideoPlayService$pauseAndResumeState$1.label & Integer.MIN_VALUE) != 0) {
                    digitalVideoPlayService$pauseAndResumeState$1.label -= Integer.MIN_VALUE;
                    Object $result = digitalVideoPlayService$pauseAndResumeState$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (digitalVideoPlayService$pauseAndResumeState$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.lastIntentToPlay = getIntendToPlay();
                            setIntendToPlay(false);
                            digitalVideoPlayService$pauseAndResumeState$1.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                            digitalVideoPlayService$pauseAndResumeState$1.label = 1;
                            if (function1.invoke(digitalVideoPlayService$pauseAndResumeState$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            Function1 function12 = (Function1) digitalVideoPlayService$pauseAndResumeState$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    setIntendToPlay(this.lastIntentToPlay);
                    return Unit.INSTANCE;
                }
            }
            switch (digitalVideoPlayService$pauseAndResumeState$1.label) {
            }
            setIntendToPlay(this.lastIntentToPlay);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            setIntendToPlay(this.lastIntentToPlay);
            throw th;
        }
        digitalVideoPlayService$pauseAndResumeState$1 = new DigitalVideoPlayService$pauseAndResumeState$1(this, continuation);
        Object $result2 = digitalVideoPlayService$pauseAndResumeState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* compiled from: DigitalVideoPlayService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.digital.preview.card.video.DigitalVideoPlayService$1", f = "DigitalVideoPlayService.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.digital.preview.card.video.DigitalVideoPlayService$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final DigitalVideoPlayService digitalVideoPlayService = DigitalVideoPlayService.this;
                        this.label = 1;
                        if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                CardItem invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = DigitalVideoPlayService.AnonymousClass1.invokeSuspend$lambda$0(DigitalVideoPlayService.this);
                                return invokeSuspend$lambda$0;
                            }
                        }), new AnonymousClass2(DigitalVideoPlayService.this, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                DigitalVideoPlayService.this.lifecycle.removeObserver(DigitalVideoPlayService.this.lifecycleObserver);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                DigitalVideoPlayService.this.lifecycle.removeObserver(DigitalVideoPlayService.this.lifecycleObserver);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DigitalVideoPlayService.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "cardData", "Lkntr/app/digital/preview/cardlistmapper/CardItem;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$2", f = "DigitalVideoPlayService.kt", i = {0, 0}, l = {99}, m = "invokeSuspend", n = {"cardData", "videoData"}, s = {"L$0", "L$1"}, v = 1)
        /* renamed from: kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$2  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CardItem<?>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ DigitalVideoPlayService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DigitalVideoPlayService digitalVideoPlayService, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = digitalVideoPlayService;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            public final Object invoke(CardItem<?> cardItem, Continuation<? super Unit> continuation) {
                return create(cardItem, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                CardItem cardData = (CardItem) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (cardData.getData() instanceof VideoCard) {
                            VideoCard videoData = (VideoCard) cardData.getData();
                            Snapshot.Companion this_$iv = Snapshot.Companion;
                            DigitalVideoPlayService digitalVideoPlayService = this.this$0;
                            Snapshot takeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(this_$iv, (Function1) null, (Function1) null, 3, (Object) null);
                            try {
                                Snapshot this_$iv$iv = takeMutableSnapshot$default;
                                Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                                digitalVideoPlayService.setUrl((String) CollectionsKt.first(videoData.getVideoUrls()));
                                digitalVideoPlayService.setIntendToPlay(true);
                                Unit unit = Unit.INSTANCE;
                                this_$iv$iv.restoreCurrent(previous$iv$iv);
                                takeMutableSnapshot$default.apply().check();
                                takeMutableSnapshot$default.dispose();
                                this.L$0 = SpillingKt.nullOutSpilledVariable(cardData);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(videoData);
                                this.label = 1;
                                if (CoroutineScopeKt.coroutineScope(new C00022(videoData, this.this$0, null), (Continuation) this) != coroutine_suspended) {
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            } finally {
                            }
                        }
                        break;
                    case 1:
                        VideoCard videoCard = (VideoCard) this.L$1;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DigitalVideoPlayService.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$2$2", f = "DigitalVideoPlayService.kt", i = {0}, l = {124}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"}, v = 1)
            /* renamed from: kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$2$2  reason: invalid class name and collision with other inner class name */
            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            public static final class C00022 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ VideoCard $videoData;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ DigitalVideoPlayService this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00022(VideoCard videoCard, DigitalVideoPlayService digitalVideoPlayService, Continuation<? super C00022> continuation) {
                    super(2, continuation);
                    this.$videoData = videoCard;
                    this.this$0 = digitalVideoPlayService;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c00022 = new C00022(this.$videoData, this.this$0, continuation);
                    c00022.L$0 = obj;
                    return c00022;
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: DigitalVideoPlayService.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$2$2$1", f = "DigitalVideoPlayService.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                /* renamed from: kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$2$2$1  reason: invalid class name and collision with other inner class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class C00031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ VideoCard $videoData;
                    int label;
                    final /* synthetic */ DigitalVideoPlayService this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00031(VideoCard videoCard, DigitalVideoPlayService digitalVideoPlayService, Continuation<? super C00031> continuation) {
                        super(2, continuation);
                        this.$videoData = videoCard;
                        this.this$0 = digitalVideoPlayService;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00031(this.$videoData, this.this$0, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object $result) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                if (this.$videoData.getTrial()) {
                                    final DigitalVideoPlayService digitalVideoPlayService = this.this$0;
                                    Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$2$2$1$$ExternalSyntheticLambda0
                                        public final Object invoke() {
                                            long currentProgress;
                                            currentProgress = DigitalVideoPlayService.this.getCurrentProgress();
                                            return Long.valueOf(currentProgress);
                                        }
                                    });
                                    final VideoCard videoCard = this.$videoData;
                                    final DigitalVideoPlayService digitalVideoPlayService2 = this.this$0;
                                    this.label = 1;
                                    if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.digital.preview.card.video.DigitalVideoPlayService.1.2.2.1.2
                                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                            return emit(((Number) value).longValue(), $completion);
                                        }

                                        public final Object emit(long progress, Continuation<? super Unit> continuation) {
                                            if (progress >= VideoCard.this.getTrialDuration()) {
                                                digitalVideoPlayService2.setIntendToPlay(false);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
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

                /* JADX WARN: Finally extract failed */
                public final Object invokeSuspend(Object $result) {
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    try {
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00031(this.$videoData, this.this$0, null), 3, (Object) null);
                                BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00052(this.this$0, this.$videoData, null), 3, (Object) null);
                                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
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
                        Snapshot.Companion this_$iv = Snapshot.Companion;
                        DigitalVideoPlayService digitalVideoPlayService = this.this$0;
                        Snapshot takeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(this_$iv, (Function1) null, (Function1) null, 3, (Object) null);
                        try {
                            Snapshot this_$iv$iv = takeMutableSnapshot$default;
                            Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                            digitalVideoPlayService.setIntendToPlay(false);
                            digitalVideoPlayService.setVideoViewVisible(false);
                            digitalVideoPlayService.setUrl(RoomRecommendViewModel.EMPTY_CURSOR);
                            Unit unit = Unit.INSTANCE;
                            this_$iv$iv.restoreCurrent(previous$iv$iv);
                            takeMutableSnapshot$default.apply().check();
                            takeMutableSnapshot$default.dispose();
                            throw th;
                        } catch (Throwable e$iv) {
                            try {
                                throw e$iv;
                            } catch (Throwable e$iv2) {
                                if (1 == 0) {
                                    takeMutableSnapshot$default.apply().check();
                                }
                                takeMutableSnapshot$default.dispose();
                                throw e$iv2;
                            }
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: DigitalVideoPlayService.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$2$2$2", f = "DigitalVideoPlayService.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                /* renamed from: kntr.app.digital.preview.card.video.DigitalVideoPlayService$1$2$2$2  reason: invalid class name and collision with other inner class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class C00052 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ VideoCard $videoData;
                    Object L$0;
                    Object L$1;
                    int label;
                    final /* synthetic */ DigitalVideoPlayService this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00052(DigitalVideoPlayService digitalVideoPlayService, VideoCard videoCard, Continuation<? super C00052> continuation) {
                        super(2, continuation);
                        this.this$0 = digitalVideoPlayService;
                        this.$videoData = videoCard;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00052(this.this$0, this.$videoData, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r1v4 */
                    /* JADX WARN: Type inference failed for: r1v8 */
                    /* JADX WARN: Type inference failed for: r1v9 */
                    public final Object invokeSuspend(Object $result) {
                        Object invoke;
                        DigitalVideoPlayService digitalVideoPlayService;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        DigitalVideoPlayService digitalVideoPlayService2 = this.label;
                        VideoCaptions videoCaptions = null;
                        try {
                            switch (digitalVideoPlayService2) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    digitalVideoPlayService2 = this.this$0;
                                    if (this.$videoData.getShowCaptions()) {
                                        this.L$0 = digitalVideoPlayService2;
                                        this.L$1 = digitalVideoPlayService2;
                                        this.label = 1;
                                        invoke = this.this$0.downloadCaptions.invoke(this.$videoData.getCaptionsUrl(), (Continuation) this);
                                        if (invoke == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        digitalVideoPlayService = digitalVideoPlayService2;
                                        digitalVideoPlayService2 = digitalVideoPlayService2;
                                        digitalVideoPlayService2 = digitalVideoPlayService;
                                        videoCaptions = (VideoCaptions) invoke;
                                        break;
                                    }
                                    break;
                                case 1:
                                    digitalVideoPlayService = (DigitalVideoPlayService) this.L$1;
                                    DigitalVideoPlayService digitalVideoPlayService3 = (DigitalVideoPlayService) this.L$0;
                                    ResultKt.throwOnFailure($result);
                                    invoke = $result;
                                    digitalVideoPlayService2 = digitalVideoPlayService3;
                                    digitalVideoPlayService2 = digitalVideoPlayService;
                                    videoCaptions = (VideoCaptions) invoke;
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } catch (IOException e) {
                        }
                        digitalVideoPlayService2.setCaptions(videoCaptions);
                        return Unit.INSTANCE;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CardItem invokeSuspend$lambda$0(DigitalVideoPlayService this$0) {
            return this$0.cardStateService.getCurrentCardItem();
        }
    }

    /* compiled from: DigitalVideoPlayService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.digital.preview.card.video.DigitalVideoPlayService$2", f = "DigitalVideoPlayService.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.digital.preview.card.video.DigitalVideoPlayService$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0027 -> B:11:0x002a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                switch(r1) {
                    case 0: goto L16;
                    case 1: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L11:
                kotlin.ResultKt.throwOnFailure(r8)
                r1 = r7
                goto L2a
            L16:
                kotlin.ResultKt.throwOnFailure(r8)
                r1 = r7
            L1a:
                r2 = r1
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r3 = 1
                r1.label = r3
                r3 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r3, r2)
                if (r2 != r0) goto L2a
                return r0
            L2a:
                kntr.app.digital.preview.card.video.DigitalVideoPlayService r2 = kntr.app.digital.preview.card.video.DigitalVideoPlayService.this
                com.bilibili.framework.simpleplayer.SimplePlayer r2 = r2.getSimplePlayer()
                long r2 = r2.getDuration-UwyO8pc()
                boolean r4 = kotlin.time.Duration.isPositive-impl(r2)
                if (r4 == 0) goto L1a
                kntr.app.digital.preview.card.video.DigitalVideoPlayService r4 = kntr.app.digital.preview.card.video.DigitalVideoPlayService.this
                kntr.app.digital.preview.card.video.DigitalVideoPlayService r5 = kntr.app.digital.preview.card.video.DigitalVideoPlayService.this
                com.bilibili.framework.simpleplayer.SimplePlayer r5 = r5.getSimplePlayer()
                long r5 = r5.getCurrentProgress-UwyO8pc()
                long r5 = kotlin.time.Duration.getInWholeMilliseconds-impl(r5)
                kntr.app.digital.preview.card.video.DigitalVideoPlayService.access$setCurrentProgress(r4, r5)
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: kntr.app.digital.preview.card.video.DigitalVideoPlayService.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}