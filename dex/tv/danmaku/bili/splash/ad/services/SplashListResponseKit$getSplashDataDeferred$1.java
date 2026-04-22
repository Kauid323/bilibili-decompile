package tv.danmaku.bili.splash.ad.services;

import com.bilibili.lib.performance.UtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashListResponseKit.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.services.SplashListResponseKit$getSplashDataDeferred$1", f = "SplashListResponseKit.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashListResponseKit$getSplashDataDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SplashListResponse>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SplashListResponseKit$getSplashDataDeferred$1(Continuation<? super SplashListResponseKit$getSplashDataDeferred$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashListResponseKit$getSplashDataDeferred$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SplashListResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return UtilsKt.measureExe(SplashListResponseKit.INSTANCE.getTAG(), "readSplashListResponseFromDisk", new Function0() { // from class: tv.danmaku.bili.splash.ad.services.SplashListResponseKit$getSplashDataDeferred$1$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        SplashListResponse invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SplashListResponseKit$getSplashDataDeferred$1.invokeSuspend$lambda$0();
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SplashListResponse invokeSuspend$lambda$0() {
        return SplashListStreamReaderWriterHelperKt.readSplashListResponseFromDisk(new Function1() { // from class: tv.danmaku.bili.splash.ad.services.SplashListResponseKit$getSplashDataDeferred$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = SplashListResponseKit$getSplashDataDeferred$1.invokeSuspend$lambda$0$0((String) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(String it) {
        throw new RuntimeException(it);
    }
}