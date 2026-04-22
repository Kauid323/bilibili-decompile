package tv.danmaku.bili.push.innerpush.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.module.main.innerpush.InnerPush;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.converter.IParser;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.model.InnerPushConfig;
import tv.danmaku.bili.push.innerpush.model.InnerPushReplayBody;
import tv.danmaku.bili.push.innerpush.model.InnerPushReplayMessage;
import tv.danmaku.bili.push.innerpush.model.InnerPushUploadMessage;

/* compiled from: InnerPushServiceHelper.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\"\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"requestInnerPushConfig", "Ltv/danmaku/bili/push/innerpush/model/InnerPushConfig;", "requestInnerPushDisplay", "", "Ltv/danmaku/bili/push/innerpush/model/InnerPushReplayMessage;", "scene", "", "innerPushList", "Lcom/bilibili/module/main/innerpush/InnerPush;", "displayService", "Ltv/danmaku/bili/push/innerpush/service/InnerPushService;", "getDisplayService", "()Ltv/danmaku/bili/push/innerpush/service/InnerPushService;", "displayService$delegate", "Lkotlin/Lazy;", "TAG", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushServiceHelperKt {
    private static final String TAG = "[InnerPush]InnerPushServiceHelper";
    private static final Lazy displayService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.innerpush.service.InnerPushServiceHelperKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            InnerPushService displayService_delegate$lambda$0;
            displayService_delegate$lambda$0 = InnerPushServiceHelperKt.displayService_delegate$lambda$0();
            return displayService_delegate$lambda$0;
        }
    });

    public static final InnerPushConfig requestInnerPushConfig() {
        try {
            GeneralResponse generalResponse = (GeneralResponse) getDisplayService().requestInnerPushConfig().setParser(new IParser() { // from class: tv.danmaku.bili.push.innerpush.service.InnerPushServiceHelperKt$$ExternalSyntheticLambda0
                public final Object convert(ResponseBody responseBody) {
                    Object requestInnerPushConfig$lambda$0;
                    requestInnerPushConfig$lambda$0 = InnerPushServiceHelperKt.requestInnerPushConfig$lambda$0(responseBody);
                    return requestInnerPushConfig$lambda$0;
                }
            }).execute().body();
            if (generalResponse != null) {
                return (InnerPushConfig) generalResponse.data;
            }
            return null;
        } catch (Exception e) {
            BLog.i(TAG, "requestInnerPushConfig, error : " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object requestInnerPushConfig$lambda$0(ResponseBody body) {
        JSONObject jsonObject = JSON.parseObject(body.string());
        InnerPushConfig replayBody = (InnerPushConfig) new Gson().fromJson(jsonObject.getString("data"), InnerPushConfig.class);
        GeneralResponse $this$requestInnerPushConfig_u24lambda_u240_u240 = new GeneralResponse();
        $this$requestInnerPushConfig_u24lambda_u240_u240.data = replayBody;
        return $this$requestInnerPushConfig_u24lambda_u240_u240;
    }

    public static final List<InnerPushReplayMessage> requestInnerPushDisplay(String scene, List<InnerPush> list) {
        InnerPushReplayBody innerPushReplayBody;
        List<InnerPushReplayMessage> msgs;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(list, "innerPushList");
        try {
            List<InnerPush> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                InnerPush it = (InnerPush) item$iv$iv;
                InnerPushUploadMessage $this$requestInnerPushDisplay_u24lambda_u240_u240 = new InnerPushUploadMessage(0L, 0, 3, null);
                $this$requestInnerPushDisplay_u24lambda_u240_u240.setJob(it.getJob());
                $this$requestInnerPushDisplay_u24lambda_u240_u240.setBid(it.getBid());
                destination$iv$iv.add($this$requestInnerPushDisplay_u24lambda_u240_u240);
            }
            List list2 = (List) destination$iv$iv;
            InnerPushService displayService = getDisplayService();
            String json = new Gson().toJson(list2);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            GeneralResponse generalResponse = (GeneralResponse) displayService.requestInnerPushDisplay(scene, json).setParser(new IParser() { // from class: tv.danmaku.bili.push.innerpush.service.InnerPushServiceHelperKt$$ExternalSyntheticLambda2
                public final Object convert(ResponseBody responseBody) {
                    Object requestInnerPushDisplay$lambda$1;
                    requestInnerPushDisplay$lambda$1 = InnerPushServiceHelperKt.requestInnerPushDisplay$lambda$1(responseBody);
                    return requestInnerPushDisplay$lambda$1;
                }
            }).execute().body();
            return (generalResponse == null || (innerPushReplayBody = (InnerPushReplayBody) generalResponse.data) == null || (msgs = innerPushReplayBody.getMsgs()) == null) ? CollectionsKt.emptyList() : msgs;
        } catch (Exception e) {
            BLog.e(TAG, "requestInnerPushDisplay, error = " + e.getMessage());
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object requestInnerPushDisplay$lambda$1(ResponseBody body) {
        JSONObject jsonObject = JSON.parseObject(body.string());
        InnerPushReplayBody replayBody = (InnerPushReplayBody) new Gson().fromJson(jsonObject.getString("data"), InnerPushReplayBody.class);
        GeneralResponse $this$requestInnerPushDisplay_u24lambda_u241_u240 = new GeneralResponse();
        $this$requestInnerPushDisplay_u24lambda_u241_u240.data = replayBody;
        return $this$requestInnerPushDisplay_u24lambda_u241_u240;
    }

    private static final InnerPushService getDisplayService() {
        return (InnerPushService) displayService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InnerPushService displayService_delegate$lambda$0() {
        return (InnerPushService) ServiceGenerator.createService(InnerPushService.class);
    }
}