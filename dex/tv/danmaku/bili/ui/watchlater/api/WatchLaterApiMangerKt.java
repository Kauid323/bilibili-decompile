package tv.danmaku.bili.ui.watchlater.api;

import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Callback;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterAddToast;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterResponse;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterApiManger.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0010\u001a \u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\b\u0001\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0018\u001a>\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00120\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001e\u001a\u00020\n2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010 \u001a4\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00120\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001e\u001a\u00020\n2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010 \"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006#"}, d2 = {"watchLaterApiService", "Ltv/danmaku/bili/ui/watchlater/api/WatchLaterApiService;", "getWatchLaterApiService", "()Ltv/danmaku/bili/ui/watchlater/api/WatchLaterApiService;", "watchLaterApiService$delegate", "Lkotlin/Lazy;", "getWatchLater", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterResponse;", "startKey", "", "asc", "", "sortField", "", "splitKey", "(Ljava/lang/String;ZILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanWatchLater", "Lcom/bilibili/okretro/GeneralResponse;", "Lcom/bilibili/okretro/BaseResponse;", "cleanType", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWatchLater", "resource", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addToWatchLaterV2", "Lcom/bilibili/okretro/call/BiliCall;", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterAddToast;", "avid", "from", "spmid", "callback", "Lcom/bilibili/okretro/BiliApiDataCallback;", "batchAddToWatchLater", "resources", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterApiMangerKt {
    private static final Lazy watchLaterApiService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.watchlater.api.WatchLaterApiMangerKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            WatchLaterApiService watchLaterApiService_delegate$lambda$0;
            watchLaterApiService_delegate$lambda$0 = WatchLaterApiMangerKt.watchLaterApiService_delegate$lambda$0();
            return watchLaterApiService_delegate$lambda$0;
        }
    });

    public static final WatchLaterApiService getWatchLaterApiService() {
        return (WatchLaterApiService) watchLaterApiService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WatchLaterApiService watchLaterApiService_delegate$lambda$0() {
        return (WatchLaterApiService) ServiceGenerator.createService(WatchLaterApiService.class);
    }

    public static final Object getWatchLater(String startKey, boolean asc, int sortField, String splitKey, Continuation<? super Resource<WatchLaterResponse>> continuation) {
        BiliCall parser = getWatchLaterApiService().getWatchLaterList(startKey, asc, sortField, splitKey).setParser(WatchLaterParser.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(parser, "setParser(...)");
        return BiliCallExtKt.getResult(parser, continuation);
    }

    public static final Object cleanWatchLater(int cleanType, Continuation<? super GeneralResponse<BaseResponse>> continuation) {
        return BiliCallExtKt.getResponse(getWatchLaterApiService().cleanWatchLater(cleanType), continuation);
    }

    public static final Object deleteWatchLater(String resource, Continuation<? super GeneralResponse<BaseResponse>> continuation) {
        return BiliCallExtKt.getResponse(getWatchLaterApiService().deleteWatchLater(resource), continuation);
    }

    public static final BiliCall<GeneralResponse<WatchLaterAddToast>> addToWatchLaterV2(String avid, String from, String spmid, BiliApiDataCallback<WatchLaterAddToast> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        BiliCall call = getWatchLaterApiService().addV2(avid, from, spmid, "v2");
        call.enqueue((Callback) biliApiDataCallback);
        return call;
    }

    public static final BiliCall<GeneralResponse<WatchLaterAddToast>> batchAddToWatchLater(String resources, String spmid, BiliApiDataCallback<WatchLaterAddToast> biliApiDataCallback) {
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        BiliCall call = getWatchLaterApiService().batchAddV3(resources, "v2", spmid);
        call.enqueue((Callback) biliApiDataCallback);
        return call;
    }
}