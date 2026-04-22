package tv.danmaku.bili.ui.splash.brand.service;

import android.app.Application;
import android.util.DisplayMetrics;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.converter.IParser;
import com.google.gson.Gson;
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
import okhttp3.ResponseBody;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingMoreData;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashServiceHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingMoreData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper$fetchNextPage$2", f = "BrandSplashServiceHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashServiceHelper$fetchNextPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrandSplashSettingMoreData>, Object> {
    final /* synthetic */ String $groupNo;
    final /* synthetic */ String $keyword;
    final /* synthetic */ long $lastSplashBizId;
    final /* synthetic */ String $source;
    final /* synthetic */ int $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashServiceHelper$fetchNextPage$2(String str, long j, String str2, int i, String str3, Continuation<? super BrandSplashServiceHelper$fetchNextPage$2> continuation) {
        super(2, continuation);
        this.$source = str;
        this.$lastSplashBizId = j;
        this.$groupNo = str2;
        this.$type = i;
        this.$keyword = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashServiceHelper$fetchNextPage$2(this.$source, this.$lastSplashBizId, this.$groupNo, this.$type, this.$keyword, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BrandSplashSettingMoreData> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        BrandSplashService api;
        String network;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Application context = BiliContext.application();
                if (context == null) {
                    return null;
                }
                DisplayMetrics metrics = context.getResources().getDisplayMetrics();
                int min = Math.min(metrics.widthPixels, metrics.heightPixels);
                int max = Math.max(metrics.widthPixels, metrics.heightPixels);
                String accessKey = BiliAccounts.get(context).getAccessKey();
                if (accessKey == null) {
                    accessKey = "";
                }
                String str = accessKey;
                try {
                    api = BrandSplashServiceHelper.INSTANCE.getApi();
                    int versionCode = Foundation.Companion.instance().getApps().getVersionCode();
                    network = BrandSplashServiceHelper.INSTANCE.getNetwork();
                    GeneralResponse generalResponse = (GeneralResponse) api.fetchNextPage(str, "android", versionCode, "phone", network, min, max, this.$source, this.$lastSplashBizId, this.$groupNo, this.$type, this.$keyword).setParser(new IParser() { // from class: tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper$fetchNextPage$2$$ExternalSyntheticLambda0
                        public final Object convert(ResponseBody responseBody) {
                            Object invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = BrandSplashServiceHelper$fetchNextPage$2.invokeSuspend$lambda$0(responseBody);
                            return invokeSuspend$lambda$0;
                        }
                    }).execute().body();
                    if (generalResponse != null) {
                        return (BrandSplashSettingMoreData) generalResponse.data;
                    }
                    return null;
                } catch (Exception e) {
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invokeSuspend$lambda$0(ResponseBody body) {
        JSONObject jsonObject = JSON.parseObject(body.string());
        Object fromJson = new Gson().fromJson(jsonObject.getString("data"), BrandSplashSettingMoreData.class);
        Intrinsics.checkNotNull(fromJson, "null cannot be cast to non-null type tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingMoreData");
        BrandSplashSettingMoreData brandData = (BrandSplashSettingMoreData) fromJson;
        GeneralResponse resp = new GeneralResponse();
        resp.data = brandData;
        return resp;
    }
}