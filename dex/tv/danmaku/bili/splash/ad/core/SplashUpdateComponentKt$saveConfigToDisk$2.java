package tv.danmaku.bili.splash.ad.core;

import java.util.List;
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
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashListResponseKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashUpdateComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.core.SplashUpdateComponentKt$saveConfigToDisk$2", f = "SplashUpdateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashUpdateComponentKt$saveConfigToDisk$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SplashListResponse $response;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashUpdateComponentKt$saveConfigToDisk$2(SplashListResponse splashListResponse, Continuation<? super SplashUpdateComponentKt$saveConfigToDisk$2> continuation) {
        super(2, continuation);
        this.$response = splashListResponse;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashUpdateComponentKt$saveConfigToDisk$2(this.$response, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (this.$response == null) {
                    return Unit.INSTANCE;
                }
                List encryptData = SplashListResponseKt.getEncryptedData(this.$response);
                if (!encryptData.isEmpty()) {
                    SplashListResponseKt.trimEncrypt(this.$response);
                }
                SplashUpdateComponentKt.doSaveToDisk(this.$response, encryptData);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}