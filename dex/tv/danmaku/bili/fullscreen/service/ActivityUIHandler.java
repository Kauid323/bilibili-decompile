package tv.danmaku.bili.fullscreen.service;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: ActivityProviderService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J?\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0002\b\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/ActivityUIHandler;", "", "<init>", "()V", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroidx/activity/ComponentActivity;", "provideActivity", "", AudioIntentHelper.FROM_ACTIVITY, "handle", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ActivityUIHandler {
    public static final int $stable = 8;
    private WeakReference<ComponentActivity> activityRef;

    public final void provideActivity(ComponentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        this.activityRef = new WeakReference<>(activity);
    }

    public final <R> Object handle(Function2<? super ComponentActivity, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        LifecycleOwner lifecycleOwner;
        WeakReference<ComponentActivity> weakReference = this.activityRef;
        if (weakReference == null || (lifecycleOwner = (ComponentActivity) weakReference.get()) == null) {
            return null;
        }
        CoroutineContext Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
        final Job job1 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ActivityUIHandler$handle$job1$1(Job$default, null), 3, (Object) null);
        final Job job2 = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(continuation.getContext()), (CoroutineContext) null, (CoroutineStart) null, new ActivityUIHandler$handle$job2$1(Job$default, null), 3, (Object) null);
        Job$default.invokeOnCompletion(new Function1() { // from class: tv.danmaku.bili.fullscreen.service.ActivityUIHandler$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit handle$lambda$0;
                handle$lambda$0 = ActivityUIHandler.handle$lambda$0(job1, job2, (Throwable) obj);
                return handle$lambda$0;
            }
        });
        return BuildersKt.withContext(Dispatchers.getMain().plus(Job$default), new ActivityUIHandler$handle$3(function2, lifecycleOwner, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handle$lambda$0(Job $job1, Job $job2, Throwable it) {
        Job.DefaultImpls.cancel$default($job1, (CancellationException) null, 1, (Object) null);
        Job.DefaultImpls.cancel$default($job2, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}