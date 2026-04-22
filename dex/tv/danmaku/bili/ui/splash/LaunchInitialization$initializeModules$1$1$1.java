package tv.danmaku.bili.ui.splash;

import android.content.Context;
import android.util.Pair;
import androidx.core.os.TraceCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.base.Bootstrap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LaunchInitialization.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.LaunchInitialization$initializeModules$1$1$1", f = "LaunchInitialization.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class LaunchInitialization$initializeModules$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Pair<String, ? extends Bootstrap> $it;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchInitialization$initializeModules$1$1$1(Pair<String, ? extends Bootstrap> pair, Context context, Continuation<? super LaunchInitialization$initializeModules$1$1$1> continuation) {
        super(2, continuation);
        this.$it = pair;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LaunchInitialization$initializeModules$1$1$1(this.$it, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                String name$iv = "module " + this.$it.first;
                Pair<String, ? extends Bootstrap> pair = this.$it;
                Context context = this.$context;
                try {
                    TraceCompat.beginSection(name$iv);
                    Bootstrap bootstrap = (Bootstrap) pair.second;
                    if (bootstrap != null) {
                        bootstrap.bootInProcess(context, BiliContext.currentProcessName());
                    }
                    Unit unit = Unit.INSTANCE;
                    TraceCompat.endSection();
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    TraceCompat.endSection();
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}