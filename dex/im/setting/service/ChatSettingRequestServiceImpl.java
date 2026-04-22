package im.setting.service;

import com.bapis.bilibili.app.im.v1.KChatMoss;
import com.bapis.bilibili.app.im.v1.KGetChatSettingsReply;
import com.bapis.bilibili.app.im.v1.KGetChatSettingsReq;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.tencent.open.SocialConstants;
import im.setting.di.SettingScope;
import im.setting.model.IMSettingPageData;
import javax.inject.Inject;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: SettingRequestService.kt */
@SettingScope
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lim/setting/service/ChatSettingRequestServiceImpl;", "Lim/setting/service/SettingRequestService;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;)V", "load", "Lkotlin/Result;", "Lim/setting/model/IMSettingPageData;", "load-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SocialConstants.TYPE_REQUEST, "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatSettingRequestServiceImpl implements SettingRequestService {
    public static final int $stable = 8;
    private final KSessionId sessionId;

    @Inject
    public ChatSettingRequestServiceImpl(KSessionId sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|8|15|16|(1:18)|19|(1:21)|22))|31|6|7|8|15|16|(0)|19|(0)|22) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0071, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    @Override // im.setting.service.SettingRequestService
    /* renamed from: load-IoAF18A  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo3406loadIoAF18A(Continuation<? super Result<IMSettingPageData>> continuation) {
        ChatSettingRequestServiceImpl$load$1 chatSettingRequestServiceImpl$load$1;
        Object obj;
        Throwable it;
        Object request;
        if (continuation instanceof ChatSettingRequestServiceImpl$load$1) {
            chatSettingRequestServiceImpl$load$1 = (ChatSettingRequestServiceImpl$load$1) continuation;
            if ((chatSettingRequestServiceImpl$load$1.label & Integer.MIN_VALUE) != 0) {
                chatSettingRequestServiceImpl$load$1.label -= Integer.MIN_VALUE;
                Object $result = chatSettingRequestServiceImpl$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (chatSettingRequestServiceImpl$load$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("IMSetting", "聊天设置页请求参数: " + this.sessionId);
                        Result.Companion companion = Result.Companion;
                        chatSettingRequestServiceImpl$load$1.I$0 = 0;
                        chatSettingRequestServiceImpl$load$1.I$1 = 0;
                        chatSettingRequestServiceImpl$load$1.label = 1;
                        request = request(chatSettingRequestServiceImpl$load$1);
                        if (request != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = chatSettingRequestServiceImpl$load$1.I$1;
                        int i3 = chatSettingRequestServiceImpl$load$1.I$0;
                        ResultKt.throwOnFailure($result);
                        request = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((IMSettingPageData) request);
                JobKt.ensureActive(chatSettingRequestServiceImpl$load$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    IMSettingPageData iMSettingPageData = (IMSettingPageData) obj;
                    KLog_androidKt.getKLog().i("IMSetting", "已请求成功聊天设置页数据. 参数: " + this.sessionId);
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    KLog_androidKt.getKLog().e("IMSetting", "已请求失败聊天设置页数据. 参数: " + this.sessionId);
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(it));
                }
                return obj;
            }
        }
        chatSettingRequestServiceImpl$load$1 = new ChatSettingRequestServiceImpl$load$1(this, continuation);
        Object $result2 = chatSettingRequestServiceImpl$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (chatSettingRequestServiceImpl$load$1.label) {
        }
        obj = Result.constructor-impl((IMSettingPageData) request);
        JobKt.ensureActive(chatSettingRequestServiceImpl$load$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object request(Continuation<? super IMSettingPageData> continuation) {
        ChatSettingRequestServiceImpl$request$1 chatSettingRequestServiceImpl$request$1;
        Object chatSettings;
        if (continuation instanceof ChatSettingRequestServiceImpl$request$1) {
            chatSettingRequestServiceImpl$request$1 = (ChatSettingRequestServiceImpl$request$1) continuation;
            if ((chatSettingRequestServiceImpl$request$1.label & Integer.MIN_VALUE) != 0) {
                chatSettingRequestServiceImpl$request$1.label -= Integer.MIN_VALUE;
                Object $result = chatSettingRequestServiceImpl$request$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (chatSettingRequestServiceImpl$request$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KGetChatSettingsReq req = new KGetChatSettingsReq(this.sessionId);
                        KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        chatSettingRequestServiceImpl$request$1.L$0 = SpillingKt.nullOutSpilledVariable(req);
                        chatSettingRequestServiceImpl$request$1.label = 1;
                        chatSettings = kChatMoss.getChatSettings(req, chatSettingRequestServiceImpl$request$1);
                        if (chatSettings != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        KGetChatSettingsReq kGetChatSettingsReq = (KGetChatSettingsReq) chatSettingRequestServiceImpl$request$1.L$0;
                        ResultKt.throwOnFailure($result);
                        chatSettings = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                KGetChatSettingsReply response = (KGetChatSettingsReply) chatSettings;
                return new IMSettingPageData(this.sessionId, response);
            }
        }
        chatSettingRequestServiceImpl$request$1 = new ChatSettingRequestServiceImpl$request$1(this, continuation);
        Object $result2 = chatSettingRequestServiceImpl$request$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (chatSettingRequestServiceImpl$request$1.label) {
        }
        KGetChatSettingsReply response2 = (KGetChatSettingsReply) chatSettings;
        return new IMSettingPageData(this.sessionId, response2);
    }
}