package faceverify;

import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.dtf.face.ToygerConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.dtf.face.network.callback.ZimValidateCallback;
import com.dtf.face.network.model.ZimValidateResponse;
import com.dtf.face.network.request.ValidateParams;
import com.tencent.open.SocialConstants;
import im.setting.UtilsKt;
import java.util.Map;

public final class e implements APICallback<Map<String, Object>> {
    public final /* synthetic */ ValidateParams a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Map c;

    public e(ValidateParams validateParams, long j, Map map) {
        this.a = validateParams;
        this.b = j;
        this.c = map;
    }

    public void onError(String str, String str2, String str3) {
        if (ToygerConfig.getInstance().expiredCheck(this.a.getZimId(), "zimValidate", System.currentTimeMillis() - this.b)) {
            return;
        }
        FaceDataFrameInfo.info_cache = a.a("").append(this.a.getZimId()).append(".").append(str).append(".").toString();
        SgomInfoManager.updateSgomInfo(294245281, (Map) null);
        RecordService.getInstance().recordEvent(4, "faceVerifyValidate", new String[]{"status", "error", "errCode", str, "errMsg", str2});
        ZimValidateCallback zimValidateCallback = (ZimValidateCallback) this.c.get("zimValidateCallback");
        if (zimValidateCallback != null) {
            if ("SERVER".equals(str3)) {
                RecordService.getInstance().recordEvent(4, "netVerifyRes", new String[]{"status", "fail", SocialConstants.PARAM_SEND_MSG, "Server Internal onError, code=" + str + " errMsg=" + str2});
                zimValidateCallback.onServerError(str, str2);
                return;
            }
            RecordService.getInstance().recordEvent(4, "netVerifyRes", new String[]{"status", "fail", SocialConstants.PARAM_SEND_MSG, "Face Compare onError, code=" + str + " errMsg=" + str2});
            zimValidateCallback.onError(str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(Object obj) {
        ZimValidateResponse zimValidateResponse;
        ZimValidateCallback zimValidateCallback;
        Map map = (Map) obj;
        if (ToygerConfig.getInstance().expiredCheck(this.a.getZimId(), "zimValidate", System.currentTimeMillis() - this.b) || map == null || map.size() == 0) {
            return;
        }
        String str = (String) map.get(UtilsKt.DATA_KEY);
        ZimValidateResponse zimValidateResponse2 = new ZimValidateResponse();
        String str2 = null;
        try {
            zimValidateResponse = (ZimValidateResponse) JSONObject.parseObject(str, ZimValidateResponse.class);
            try {
                zimValidateResponse.fixParams();
            } catch (Throwable th) {
                zimValidateResponse2 = zimValidateResponse;
                zimValidateResponse2.validationRetCode = null;
                zimValidateResponse = zimValidateResponse2;
                FaceDataFrameInfo.info_cache = a.a("").append(this.a.getZimId()).append(".").append(zimValidateResponse.productRetCode).append(".").append(zimValidateResponse.validationRetCode).toString();
                SgomInfoManager.updateSgomInfo(294245281, (Map) null);
                RecordService.getInstance().recordEvent(1, "faceVerifyValidate", new String[]{"status", "success", q.KEY_RES_9_CONTENT, str});
                zimValidateCallback = (ZimValidateCallback) this.c.get("zimValidateCallback");
                if (zimValidateCallback != null) {
                }
            }
        } catch (Throwable th2) {
        }
        FaceDataFrameInfo.info_cache = a.a("").append(this.a.getZimId()).append(".").append(zimValidateResponse.productRetCode).append(".").append(zimValidateResponse.validationRetCode).toString();
        SgomInfoManager.updateSgomInfo(294245281, (Map) null);
        RecordService.getInstance().recordEvent(1, "faceVerifyValidate", new String[]{"status", "success", q.KEY_RES_9_CONTENT, str});
        zimValidateCallback = (ZimValidateCallback) this.c.get("zimValidateCallback");
        if (zimValidateCallback != null) {
            return;
        }
        if ("Z5120".equalsIgnoreCase(zimValidateResponse.retCodeSub)) {
            RecordService.getInstance().recordEvent(2, "netVerifyRes", new String[]{"status", "success", "verify", "success"});
            zimValidateCallback.onSuccess();
        } else if (String.valueOf(3003).equals(zimValidateResponse.validationRetCode)) {
            JSONObject parseObject = JSONObject.parseObject(zimValidateResponse.extParams);
            if (parseObject != null) {
                str2 = parseObject.getString("phoneNo");
            }
            zimValidateCallback.onNextVerify(3003, str2);
        } else {
            RecordService.getInstance().recordEvent(2, "netVerifyRes", new String[]{"status", "success", "verify", "false", SocialConstants.PARAM_SEND_MSG, a.a("Face Compare onValidateFail, retCodeSub=").append(zimValidateResponse.retCodeSub).append(" retMessageSub=").append(zimValidateResponse.retMessageSub).append(" srvRes=").append(str).toString()});
            zimValidateCallback.onValidateFail(zimValidateResponse.retCodeSub, zimValidateResponse.retMessageSub, str);
        }
    }
}