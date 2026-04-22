package kntr.app.deepsearch.stub;

import android.app.Activity;
import android.os.Looper;
import androidx.core.app.ActivityCompat$;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.lang.ref.WeakReference;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.android.log.BLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageStub.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.stub.PageStub_androidKt$PushDetailPageStub$1$1", f = "PageStub.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageStub_androidKt$PushDetailPageStub$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $current;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageStub_androidKt$PushDetailPageStub$1$1(Activity activity, String str, Continuation<? super PageStub_androidKt$PushDetailPageStub$1$1> continuation) {
        super(2, continuation);
        this.$current = activity;
        this.$sessionId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageStub_androidKt$PushDetailPageStub$1$1(this.$current, this.$sessionId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((Activity) activity).finish();
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow $this$getAndUpdate$iv;
        Object prevValue$iv;
        Object nextValue$iv;
        WeakReference<Activity> activityRef;
        Activity it;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$getAndUpdate$iv = PageStub_androidKt.detailPageStub;
                Activity activity = this.$current;
                String str = this.$sessionId;
                do {
                    prevValue$iv = $this$getAndUpdate$iv.getValue();
                    PageStub pageStub = (PageStub) prevValue$iv;
                    nextValue$iv = new PageStub(new WeakReference(activity), str);
                } while (!$this$getAndUpdate$iv.compareAndSet(prevValue$iv, nextValue$iv));
                PageStub pageStub2 = (PageStub) prevValue$iv;
                if (pageStub2 != null && (activityRef = pageStub2.getActivityRef()) != null && (it = activityRef.get()) != null) {
                    if (Intrinsics.areEqual(it, this.$current)) {
                        it = null;
                    }
                    if (it != null) {
                        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(it);
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}