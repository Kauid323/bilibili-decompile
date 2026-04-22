package im.setting.service;

import com.bapis.bilibili.app.im.v1.KChatMoss;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSetChatSettingsReply;
import com.bapis.bilibili.app.im.v1.KSetChatSettingsReq;
import im.setting.di.SettingScope;
import im.setting.model.SettingItem;
import javax.inject.Inject;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: SettingChangeService.kt */
@SettingScope
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lim/setting/service/ChatSettingChangeServiceImpl;", "Lim/setting/service/SettingChangeService;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;)V", "change", "Lkotlin/Result;", "", "item", "Lim/setting/model/SettingItem$Setting;", "change-gIAlu-s", "(Lim/setting/model/SettingItem$Setting;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatSettingChangeServiceImpl implements SettingChangeService {
    public static final int $stable = 8;
    private final KSessionId sessionId;

    @Inject
    public ChatSettingChangeServiceImpl(KSessionId sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|8|15|16|(1:18)|19|(1:21)|22))|31|6|7|8|15|16|(0)|19|(0)|22) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009f, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a0, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e4  */
    @Override // im.setting.service.SettingChangeService
    /* renamed from: change-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo3403changegIAlus(SettingItem.Setting item, Continuation<? super Result<String>> continuation) {
        ChatSettingChangeServiceImpl$change$1 chatSettingChangeServiceImpl$change$1;
        Object obj;
        Throwable it;
        Object chatSettings;
        if (continuation instanceof ChatSettingChangeServiceImpl$change$1) {
            chatSettingChangeServiceImpl$change$1 = (ChatSettingChangeServiceImpl$change$1) continuation;
            if ((chatSettingChangeServiceImpl$change$1.label & Integer.MIN_VALUE) != 0) {
                chatSettingChangeServiceImpl$change$1.label -= Integer.MIN_VALUE;
                Object $result = chatSettingChangeServiceImpl$change$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (chatSettingChangeServiceImpl$change$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("IMSetting", "开始请求更改聊天设置: " + item);
                        Result.Companion companion = Result.Companion;
                        KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KSetChatSettingsReq kSetChatSettingsReq = new KSetChatSettingsReq(this.sessionId, MapsKt.mapOf(TuplesKt.to(Boxing.boxInt(item.getType().getValue()), item.getSetting())));
                        chatSettingChangeServiceImpl$change$1.L$0 = item;
                        chatSettingChangeServiceImpl$change$1.I$0 = 0;
                        chatSettingChangeServiceImpl$change$1.I$1 = 0;
                        chatSettingChangeServiceImpl$change$1.label = 1;
                        chatSettings = kChatMoss.setChatSettings(kSetChatSettingsReq, chatSettingChangeServiceImpl$change$1);
                        if (chatSettings != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = chatSettingChangeServiceImpl$change$1.I$1;
                        int i3 = chatSettingChangeServiceImpl$change$1.I$0;
                        item = (SettingItem.Setting) chatSettingChangeServiceImpl$change$1.L$0;
                        ResultKt.throwOnFailure($result);
                        chatSettings = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl(((KSetChatSettingsReply) chatSettings).getToast());
                JobKt.ensureActive(chatSettingChangeServiceImpl$change$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    String str = (String) obj;
                    KLog_androidKt.getKLog().i("IMSetting", "已成功请求更改聊天设置: " + item.getType());
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    KLog_androidKt.getKLog().e("IMSetting", "已失败请求更改聊天设置: " + item.getType(), it);
                }
                return obj;
            }
        }
        chatSettingChangeServiceImpl$change$1 = new ChatSettingChangeServiceImpl$change$1(this, continuation);
        Object $result2 = chatSettingChangeServiceImpl$change$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (chatSettingChangeServiceImpl$change$1.label) {
        }
        obj = Result.constructor-impl(((KSetChatSettingsReply) chatSettings).getToast());
        JobKt.ensureActive(chatSettingChangeServiceImpl$change$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return obj;
    }
}