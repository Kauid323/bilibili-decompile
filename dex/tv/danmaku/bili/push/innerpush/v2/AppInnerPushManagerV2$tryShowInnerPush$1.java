package tv.danmaku.bili.push.innerpush.v2;

import android.app.Activity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$1", f = "AppInnerPushManagerV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AppInnerPushManagerV2$tryShowInnerPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ AppInnerPushManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInnerPushManagerV2$tryShowInnerPush$1(Activity activity, AppInnerPushManagerV2 appInnerPushManagerV2, Continuation<? super AppInnerPushManagerV2$tryShowInnerPush$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.this$0 = appInnerPushManagerV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInnerPushManagerV2$tryShowInnerPush$1(this.$activity, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Lifecycle lifecycle = this.$activity.getLifecycle();
                final Activity activity = this.$activity;
                final AppInnerPushManagerV2 appInnerPushManagerV2 = this.this$0;
                lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$1.1
                    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                        DefaultLifecycleObserver.-CC.$default$onCreate(this, lifecycleOwner);
                    }

                    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                        DefaultLifecycleObserver.-CC.$default$onDestroy(this, lifecycleOwner);
                    }

                    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                        DefaultLifecycleObserver.-CC.$default$onResume(this, lifecycleOwner);
                    }

                    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                        DefaultLifecycleObserver.-CC.$default$onStart(this, lifecycleOwner);
                    }

                    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                        DefaultLifecycleObserver.-CC.$default$onStop(this, lifecycleOwner);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:8:0x0027, code lost:
                        r0 = r2.showJob;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onPause(LifecycleOwner owner) {
                        Job job;
                        Job job2;
                        Intrinsics.checkNotNullParameter(owner, "owner");
                        activity.getLifecycle().removeObserver((LifecycleObserver) this);
                        job = appInnerPushManagerV2.showJob;
                        boolean z = false;
                        if (job != null && job.isActive()) {
                            z = true;
                        }
                        if (!z || job2 == null) {
                            return;
                        }
                        job2.cancel(new CancellationException("tryShowInnerPush, onPause, stop job"));
                    }
                });
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}