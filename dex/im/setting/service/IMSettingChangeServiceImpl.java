package im.setting.service;

import com.bapis.bilibili.app.im.v1.KSetImSettingsReply;
import com.bapis.bilibili.app.im.v1.KSetImSettingsReq;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.setting.di.SettingScope;
import im.setting.model.SettingItem;
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
import kotlinx.coroutines.JobKt;

/* compiled from: SettingChangeService.kt */
@SettingScope
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lim/setting/service/IMSettingChangeServiceImpl;", "Lim/setting/service/SettingChangeService;", "<init>", "()V", "change", "Lkotlin/Result;", "", "item", "Lim/setting/model/SettingItem$Setting;", "change-gIAlu-s", "(Lim/setting/model/SettingItem$Setting;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingChangeServiceImpl implements SettingChangeService {
    public static final int $stable = 0;

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|8|15|16|(1:18)|19|(1:21)|22))|31|6|7|8|15|16|(0)|19|(0)|22) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009e, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e2  */
    @Override // im.setting.service.SettingChangeService
    /* renamed from: change-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo3403changegIAlus(SettingItem.Setting item, Continuation<? super Result<String>> continuation) {
        IMSettingChangeServiceImpl$change$1 iMSettingChangeServiceImpl$change$1;
        Object obj;
        Throwable it;
        Object imSettings;
        if (continuation instanceof IMSettingChangeServiceImpl$change$1) {
            iMSettingChangeServiceImpl$change$1 = (IMSettingChangeServiceImpl$change$1) continuation;
            if ((iMSettingChangeServiceImpl$change$1.label & Integer.MIN_VALUE) != 0) {
                iMSettingChangeServiceImpl$change$1.label -= Integer.MIN_VALUE;
                Object $result = iMSettingChangeServiceImpl$change$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSettingChangeServiceImpl$change$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("IMSetting", "开始请求更改消息设置: " + item);
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KSetImSettingsReq kSetImSettingsReq = new KSetImSettingsReq(MapsKt.mapOf(TuplesKt.to(Boxing.boxInt(item.getType().getValue()), item.getSetting())));
                        iMSettingChangeServiceImpl$change$1.L$0 = item;
                        iMSettingChangeServiceImpl$change$1.I$0 = 0;
                        iMSettingChangeServiceImpl$change$1.I$1 = 0;
                        iMSettingChangeServiceImpl$change$1.label = 1;
                        imSettings = kimMoss.setImSettings(kSetImSettingsReq, iMSettingChangeServiceImpl$change$1);
                        if (imSettings != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = iMSettingChangeServiceImpl$change$1.I$1;
                        int i3 = iMSettingChangeServiceImpl$change$1.I$0;
                        item = (SettingItem.Setting) iMSettingChangeServiceImpl$change$1.L$0;
                        ResultKt.throwOnFailure($result);
                        imSettings = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl(((KSetImSettingsReply) imSettings).getToast());
                JobKt.ensureActive(iMSettingChangeServiceImpl$change$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    String str = (String) obj;
                    KLog_androidKt.getKLog().i("IMSetting", "已成功请求更改消息设置: " + item.getType());
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    KLog_androidKt.getKLog().e("IMSetting", "已失败请求更改消息设置: " + item.getType(), it);
                }
                return obj;
            }
        }
        iMSettingChangeServiceImpl$change$1 = new IMSettingChangeServiceImpl$change$1(this, continuation);
        Object $result2 = iMSettingChangeServiceImpl$change$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSettingChangeServiceImpl$change$1.label) {
        }
        obj = Result.constructor-impl(((KSetImSettingsReply) imSettings).getToast());
        JobKt.ensureActive(iMSettingChangeServiceImpl$change$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
        }
        return obj;
    }
}