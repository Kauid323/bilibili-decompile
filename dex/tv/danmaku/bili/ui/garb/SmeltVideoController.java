package tv.danmaku.bili.ui.garb;

import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.ogv.infra.tempfile.DownloadingTempFileFactory;
import com.bilibili.ogv.infra.tempfile.TempFileManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: SmeltVideoController.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/garb/SmeltVideoController;", "", "<init>", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "smeltVideoMap", "Ljava/util/HashMap;", "", "Ltv/danmaku/bili/ui/garb/SmeltVideoController$SmeltVideoPlayTask;", "Lkotlin/collections/HashMap;", "play", "", "url", "key", "startPlay", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, FileChooserActivity.PATH, "onStop", "Lkotlin/Function0;", "stop", "stopAll", BuildConfig.BUILD_TYPE, "SmeltVideoPlayTask", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmeltVideoController {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private final HashMap<String, SmeltVideoPlayTask> smeltVideoMap = new HashMap<>();

    public final void play(String url, final String key, final Function1<? super String, Unit> function1, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function1, "startPlay");
        Intrinsics.checkNotNullParameter(function0, "onStop");
        Map $this$getOrPut$iv = this.smeltVideoMap;
        Object value$iv = $this$getOrPut$iv.get(key);
        if (value$iv != null) {
            return;
        }
        $this$getOrPut$iv.put(key, new SmeltVideoPlayTask(this.coroutineScope, url, new Function1() { // from class: tv.danmaku.bili.ui.garb.SmeltVideoController$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit play$lambda$0$0;
                play$lambda$0$0 = SmeltVideoController.play$lambda$0$0(function1, (String) obj);
                return play$lambda$0$0;
            }
        }, new Function0() { // from class: tv.danmaku.bili.ui.garb.SmeltVideoController$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit play$lambda$0$1;
                play$lambda$0$1 = SmeltVideoController.play$lambda$0$1(function0, this, key);
                return play$lambda$0$1;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit play$lambda$0$0(Function1 $startPlay, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $startPlay.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit play$lambda$0$1(Function0 $onStop, SmeltVideoController this$0, String $key) {
        $onStop.invoke();
        this$0.smeltVideoMap.remove($key);
        return Unit.INSTANCE;
    }

    public final void stop(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SmeltVideoPlayTask task = this.smeltVideoMap.remove(key);
        if (task == null) {
            return;
        }
        task.stop();
    }

    public final void stopAll() {
        Iterable values = this.smeltVideoMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterable $this$forEach$iv = values;
        for (Object element$iv : $this$forEach$iv) {
            SmeltVideoPlayTask task = (SmeltVideoPlayTask) element$iv;
            task.stop();
        }
        this.smeltVideoMap.clear();
    }

    public final void release() {
        CoroutineScopeKt.cancel$default(this.coroutineScope, (CancellationException) null, 1, (Object) null);
        this.smeltVideoMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmeltVideoController.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0012\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/garb/SmeltVideoController$SmeltVideoPlayTask;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "url", "", "startPlay", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, FileChooserActivity.PATH, "", "onStop", "Lkotlin/Function0;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "playJob", "Lkotlinx/coroutines/Job;", "stop", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SmeltVideoPlayTask {
        private final Function0<Unit> onStop;
        private Job playJob;
        private final Function1<String, Unit> startPlay;
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public SmeltVideoPlayTask(CoroutineScope coroutineScope, String url, Function1<? super String, Unit> function1, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(function1, "startPlay");
            Intrinsics.checkNotNullParameter(function0, "onStop");
            this.url = url;
            this.startPlay = function1;
            this.onStop = function0;
            this.playJob = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        }

        /* compiled from: SmeltVideoController.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        @DebugMetadata(c = "tv.danmaku.bili.ui.garb.SmeltVideoController$SmeltVideoPlayTask$1", f = "SmeltVideoController.kt", i = {}, l = {BR.bgImageVisible, BR.bottomDesc}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: tv.danmaku.bili.ui.garb.SmeltVideoController$SmeltVideoPlayTask$1  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
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

            /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x0011, B:23:0x008c, B:24:0x0091, B:7:0x0016, B:15:0x004b, B:17:0x0053, B:20:0x0068, B:12:0x0027), top: B:27:0x0006 }] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[Catch: all -> 0x0021, TRY_ENTER, TryCatch #0 {all -> 0x0021, blocks: (B:6:0x0011, B:23:0x008c, B:24:0x0091, B:7:0x0016, B:15:0x004b, B:17:0x0053, B:20:0x0068, B:12:0x0027), top: B:27:0x0006 }] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                TempFileManager tempFileManager;
                Object result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            tempFileManager = SmeltVideoControllerKt.tempFileManager;
                            this.label = 1;
                            result = tempFileManager.awaitTempFile-gIAlu-s(new DownloadingTempFileFactory(FoundationAlias.getFapp(), SmeltVideoPlayTask.this.url), (Continuation) this);
                            if (result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (Result.isSuccess-impl(result)) {
                                SmeltVideoPlayTask.this.onStop.invoke();
                                return Unit.INSTANCE;
                            }
                            Function1 function1 = SmeltVideoPlayTask.this.startPlay;
                            ResultKt.throwOnFailure(result);
                            String path = ((File) result).getPath();
                            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                            function1.invoke(path);
                            this.label = 2;
                            if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw new KotlinNothingValueException();
                        case 1:
                            ResultKt.throwOnFailure($result);
                            result = ((Result) $result).unbox-impl();
                            if (Result.isSuccess-impl(result)) {
                            }
                            break;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            throw new KotlinNothingValueException();
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } finally {
                    SmeltVideoPlayTask.this.onStop.invoke();
                }
            }
        }

        public final void stop() {
            Job job = this.playJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
    }
}