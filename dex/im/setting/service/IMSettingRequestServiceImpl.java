package im.setting.service;

import com.bapis.bilibili.app.im.v1.KGetImSettingsReply;
import com.bapis.bilibili.app.im.v1.KGetImSettingsReq;
import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KimMoss;
import com.tencent.open.SocialConstants;
import im.setting.di.SettingScope;
import im.setting.model.IMSettingPageData;
import im.setting.model.param.IMSettingInitializeDataParam;
import im.setting.model.param.IMSettingInitializeParam;
import im.setting.model.param.IMSettingInitializeTypeParam;
import javax.inject.Inject;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lim/setting/service/IMSettingRequestServiceImpl;", "Lim/setting/service/SettingRequestService;", "param", "Lim/setting/model/param/IMSettingInitializeParam;", "<init>", "(Lim/setting/model/param/IMSettingInitializeParam;)V", "load", "Lkotlin/Result;", "Lim/setting/model/IMSettingPageData;", "load-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SocialConstants.TYPE_REQUEST, "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingRequestServiceImpl implements SettingRequestService {
    public static final int $stable = 8;
    private final IMSettingInitializeParam param;

    @Inject
    public IMSettingRequestServiceImpl(IMSettingInitializeParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|8|15|16|(1:18)|19|(2:21|22)(1:23)))|40|6|7|8|15|16|(0)|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008d, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // im.setting.service.SettingRequestService
    /* renamed from: load-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo3406loadIoAF18A(Continuation<? super Result<IMSettingPageData>> continuation) {
        IMSettingRequestServiceImpl$load$1 iMSettingRequestServiceImpl$load$1;
        Object obj;
        Throwable it;
        Object request;
        if (continuation instanceof IMSettingRequestServiceImpl$load$1) {
            iMSettingRequestServiceImpl$load$1 = (IMSettingRequestServiceImpl$load$1) continuation;
            if ((iMSettingRequestServiceImpl$load$1.label & Integer.MIN_VALUE) != 0) {
                iMSettingRequestServiceImpl$load$1.label -= Integer.MIN_VALUE;
                Object $result = iMSettingRequestServiceImpl$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSettingRequestServiceImpl$load$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("IMSetting", "列表数据请求参数: " + this.param);
                        IMSettingInitializeParam iMSettingInitializeParam = this.param;
                        if (iMSettingInitializeParam instanceof IMSettingInitializeDataParam) {
                            Result.Companion companion = Result.Companion;
                            return Result.constructor-impl(((IMSettingInitializeDataParam) this.param).getData());
                        } else if (iMSettingInitializeParam instanceof IMSettingInitializeTypeParam) {
                            Result.Companion companion2 = Result.Companion;
                            iMSettingRequestServiceImpl$load$1.I$0 = 0;
                            iMSettingRequestServiceImpl$load$1.I$1 = 0;
                            iMSettingRequestServiceImpl$load$1.label = 1;
                            request = request(iMSettingRequestServiceImpl$load$1);
                            if (request != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    case 1:
                        int i2 = iMSettingRequestServiceImpl$load$1.I$1;
                        int i3 = iMSettingRequestServiceImpl$load$1.I$0;
                        ResultKt.throwOnFailure($result);
                        request = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((IMSettingPageData) request);
                JobKt.ensureActive(iMSettingRequestServiceImpl$load$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    IMSettingPageData iMSettingPageData = (IMSettingPageData) obj;
                    KLog_androidKt.getKLog().i("IMSetting", "已请求成功列表数据. 参数: " + this.param);
                }
                it = Result.exceptionOrNull-impl(obj);
                if (it == null) {
                    KLog_androidKt.getKLog().e("IMSetting", "已请求失败列表数据. 参数: " + this.param, it);
                    Result.Companion companion3 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(it));
                    return obj;
                }
                return obj;
            }
        }
        iMSettingRequestServiceImpl$load$1 = new IMSettingRequestServiceImpl$load$1(this, continuation);
        Object $result2 = iMSettingRequestServiceImpl$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSettingRequestServiceImpl$load$1.label) {
        }
        obj = Result.constructor-impl((IMSettingPageData) request);
        JobKt.ensureActive(iMSettingRequestServiceImpl$load$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        it = Result.exceptionOrNull-impl(obj);
        if (it == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object request(Continuation<? super IMSettingPageData> continuation) {
        IMSettingRequestServiceImpl$request$1 iMSettingRequestServiceImpl$request$1;
        KIMSettingType type;
        Object imSettings;
        if (continuation instanceof IMSettingRequestServiceImpl$request$1) {
            iMSettingRequestServiceImpl$request$1 = (IMSettingRequestServiceImpl$request$1) continuation;
            if ((iMSettingRequestServiceImpl$request$1.label & Integer.MIN_VALUE) != 0) {
                iMSettingRequestServiceImpl$request$1.label -= Integer.MIN_VALUE;
                Object $result = iMSettingRequestServiceImpl$request$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSettingRequestServiceImpl$request$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        type = this.param.getPageType();
                        if (type == null) {
                            throw new IllegalArgumentException("页面不存在");
                        }
                        KGetImSettingsReq req = new KGetImSettingsReq(type);
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        iMSettingRequestServiceImpl$request$1.L$0 = type;
                        iMSettingRequestServiceImpl$request$1.L$1 = SpillingKt.nullOutSpilledVariable(req);
                        iMSettingRequestServiceImpl$request$1.label = 1;
                        imSettings = kimMoss.getImSettings(req, iMSettingRequestServiceImpl$request$1);
                        if (imSettings != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        KGetImSettingsReq kGetImSettingsReq = (KGetImSettingsReq) iMSettingRequestServiceImpl$request$1.L$1;
                        type = (KIMSettingType) iMSettingRequestServiceImpl$request$1.L$0;
                        ResultKt.throwOnFailure($result);
                        imSettings = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                KGetImSettingsReply response = (KGetImSettingsReply) imSettings;
                return new IMSettingPageData(type, response);
            }
        }
        iMSettingRequestServiceImpl$request$1 = new IMSettingRequestServiceImpl$request$1(this, continuation);
        Object $result2 = iMSettingRequestServiceImpl$request$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSettingRequestServiceImpl$request$1.label) {
        }
        KGetImSettingsReply response2 = (KGetImSettingsReply) imSettings;
        return new IMSettingPageData(type, response2);
    }
}