package tv.danmaku.bili.splash.ad.chronos;

import com.bilibili.common.chronoscommon.ChronosPackageManager;
import com.bilibili.cron.ChronosPackage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashChronosView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/cron/ChronosPackage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.chronos.SplashChronosViewKt$tryCreateSplashChronosView$chronosPackage$1", f = "SplashChronosView.kt", i = {}, l = {BR.blurCoverUrl}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashChronosViewKt$tryCreateSplashChronosView$chronosPackage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChronosPackage>, Object> {
    final /* synthetic */ String $packageMd5;
    final /* synthetic */ String $packageUrl;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashChronosViewKt$tryCreateSplashChronosView$chronosPackage$1(String str, String str2, Continuation<? super SplashChronosViewKt$tryCreateSplashChronosView$chronosPackage$1> continuation) {
        super(2, continuation);
        this.$packageUrl = str;
        this.$packageMd5 = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashChronosViewKt$tryCreateSplashChronosView$chronosPackage$1(this.$packageUrl, this.$packageMd5, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChronosPackage> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object suspendLoadPackage$default = ChronosPackageManager.suspendLoadPackage$default(ChronosPackageManager.INSTANCE, this.$packageUrl, this.$packageMd5, (String) null, (ChronosPackageManager.Service) null, (Continuation) this, 8, (Object) null);
                if (suspendLoadPackage$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return suspendLoadPackage$default;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}