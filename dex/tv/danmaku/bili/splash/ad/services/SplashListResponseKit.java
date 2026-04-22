package tv.danmaku.bili.splash.ad.services;

import com.bilibili.lib.performance.UtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashOrder;

/* compiled from: SplashListResponseKit.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0014\u001a\u0004\u0018\u00010\u00112#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0016J\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013J\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/splash/ad/services/SplashListResponseKit;", "", "<init>", "()V", "opt", "", "getOpt", "()Z", "setOpt", "(Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "cache", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "deferred", "Lkotlinx/coroutines/Deferred;", "getSplashListResponse", "onError", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "errMsg", "", "getSplashDataDeferred", "disableOpt", "saveResource", "data", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashListResponseKit {
    private static SplashListResponse cache;
    private static Deferred<SplashListResponse> deferred;
    private static boolean opt;
    public static final SplashListResponseKit INSTANCE = new SplashListResponseKit();
    private static String TAG = "SplashListResponseKit";
    public static final int $stable = 8;

    private SplashListResponseKit() {
    }

    public final boolean getOpt() {
        return opt;
    }

    public final void setOpt(boolean z) {
        opt = z;
    }

    public final String getTAG() {
        return TAG;
    }

    public final void setTAG(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        TAG = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SplashListResponse getSplashListResponse$default(SplashListResponseKit splashListResponseKit, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: tv.danmaku.bili.splash.ad.services.SplashListResponseKit$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit splashListResponse$lambda$0;
                    splashListResponse$lambda$0 = SplashListResponseKit.getSplashListResponse$lambda$0((String) obj2);
                    return splashListResponse$lambda$0;
                }
            };
        }
        return splashListResponseKit.getSplashListResponse(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSplashListResponse$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final SplashListResponse getSplashListResponse(final Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onError");
        if (!opt) {
            return SplashListStreamReaderWriterHelperKt.readSplashListResponseFromDisk(function1);
        }
        SplashListResponse it = cache;
        if (it == null) {
            it = (SplashListResponse) UtilsKt.measureExe(TAG, "getSplashListResponse", new Function0() { // from class: tv.danmaku.bili.splash.ad.services.SplashListResponseKit$$ExternalSyntheticLambda0
                public final Object invoke() {
                    SplashListResponse splashListResponse$lambda$1;
                    splashListResponse$lambda$1 = SplashListResponseKit.getSplashListResponse$lambda$1(function1);
                    return splashListResponse$lambda$1;
                }
            });
        }
        SplashListResponse it2 = null;
        if (it != null) {
            List<SplashOrder> splashList = it.getSplashList();
            it2 = r1.copy((r20 & 1) != 0 ? r1.maxCount : 0, (r20 & 2) != 0 ? r1.intervalForShow : 0, (r20 & 4) != 0 ? r1.intervalForUpdate : 0, (r20 & 8) != 0 ? r1.disperseInterval : 0L, (r20 & 16) != 0 ? r1.splashList : splashList != null ? CollectionsKt.toMutableList(splashList) : null, (r20 & 32) != 0 ? r1.strategyList : null, (r20 & 64) != 0 ? r1.keepIds : null, (r20 & BR.cover) != 0 ? it.splashRequestId : null);
        }
        return it2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SplashListResponse getSplashListResponse$lambda$1(Function1 $onError) {
        return (SplashListResponse) BuildersKt.runBlocking$default((CoroutineContext) null, new SplashListResponseKit$getSplashListResponse$2$1($onError, null), 1, (Object) null);
    }

    public final Deferred<SplashListResponse> getSplashDataDeferred() {
        opt = true;
        Deferred<SplashListResponse> deferred2 = deferred;
        if (deferred2 != null) {
            return deferred2;
        }
        Deferred it = BuildersKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new SplashListResponseKit$getSplashDataDeferred$1(null), 3, (Object) null);
        deferred = it;
        return it;
    }

    public final void disableOpt() {
        opt = false;
    }

    public final void saveResource(SplashListResponse data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (opt) {
            cache = data;
        }
    }
}