package tv.danmaku.bili.safe;

import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.model.AuthKey;
import com.bilibili.lib.accounts.report.AccountApiTracker;
import com.bilibili.lib.accounts.utils.BiliAccountsReporter;
import com.bilibili.okretro.BiliApiParseException;
import com.bilibili.okretro.BiliUnsafeHttpCodeException;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import tv.danmaku.bili.BR;

/* compiled from: BiliSafeApi.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J+\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u00160\u0015H\u0002¢\u0006\u0002\u0010\u0017J+\u0010\u0018\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\u0014\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u00160\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\f2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/safe/BiliSafeApi;", "", "<init>", "()V", "sBiliSafeService", "Ltv/danmaku/bili/safe/BiliSafeService;", "safeCenterApiService", "getSafeCenterApiService", "()Ltv/danmaku/bili/safe/BiliSafeService;", "callGetKeyForSetPwd", "Lcom/bilibili/lib/accounts/model/AuthKey;", "setPwd", "", "accessToken", "", "pwd", "tryEncryptPasswordForSetPwd", "password", "executeCall", "T", "call", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "(Lcom/bilibili/okretro/call/BiliCall;)Ljava/lang/Object;", "parseObject", "response", "Lretrofit2/Response;", "(Lretrofit2/Response;)Ljava/lang/Object;", "throwException", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliSafeApi {
    private static volatile BiliSafeService sBiliSafeService;
    public static final BiliSafeApi INSTANCE = new BiliSafeApi();
    public static final int $stable = 8;

    private BiliSafeApi() {
    }

    private final BiliSafeService getSafeCenterApiService() {
        if (sBiliSafeService == null) {
            synchronized (BiliSafeApi.class) {
                if (sBiliSafeService == null) {
                    sBiliSafeService = (BiliSafeService) ServiceGenerator.createService(BiliSafeService.class);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        BiliSafeService biliSafeService = sBiliSafeService;
        Intrinsics.checkNotNull(biliSafeService);
        return biliSafeService;
    }

    private final AuthKey callGetKeyForSetPwd() throws AccountException {
        BiliCall<GeneralResponse<AuthKey>> key = getSafeCenterApiService().getKey();
        Intrinsics.checkNotNullExpressionValue(key, "getKey(...)");
        return (AuthKey) executeCall(key);
    }

    @JvmStatic
    public static final void setPwd(String accessToken, String pwd) throws AccountException {
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        BiliSafeApi biliSafeApi = INSTANCE;
        BiliCall<GeneralResponse<Void>> pwd2 = INSTANCE.getSafeCenterApiService().setPwd(accessToken, INSTANCE.tryEncryptPasswordForSetPwd(pwd));
        Intrinsics.checkNotNullExpressionValue(pwd2, "setPwd(...)");
        biliSafeApi.executeCall(pwd2);
    }

    private final String tryEncryptPasswordForSetPwd(String password) throws AccountException {
        AuthKey authKey = callGetKeyForSetPwd();
        if (authKey == null) {
            return password;
        }
        String encryptPassword = authKey.encryptPassword(password);
        Intrinsics.checkNotNullExpressionValue(encryptPassword, "encryptPassword(...)");
        return encryptPassword;
    }

    private final <T> T executeCall(BiliCall<GeneralResponse<T>> biliCall) throws AccountException {
        biliCall.setApiTracker(new AccountApiTracker(biliCall.getApiTracker()));
        try {
            Response response = biliCall.execute();
            Intrinsics.checkNotNullExpressionValue(response, "execute(...)");
            return (T) parseObject(response);
        } catch (IOException e) {
            throw new AccountException(e);
        } catch (BiliApiParseException e2) {
            throw new AccountException(e2);
        }
    }

    private final <T> T parseObject(Response<GeneralResponse<T>> response) throws AccountException {
        if (response.isSuccessful()) {
            GeneralResponse body = (GeneralResponse) response.body();
            Intrinsics.checkNotNull(body);
            if (body.code == 0) {
                return (T) body.data;
            }
            throw new AccountException(body.code, body.message);
        }
        throwException(response);
        return null;
    }

    private final void throwException(Response<?> response) throws AccountException {
        if (response.code() == 412) {
            BiliAccountsReporter.INSTANCE.reportResponse(response.raw());
            throw new AccountException(response.code(), BiliUnsafeHttpCodeException.parseDisplayMsg(response));
        }
        throw new AccountException(response.code());
    }
}