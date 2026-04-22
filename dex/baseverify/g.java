package baseverify;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.dtf.face.ToygerConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.dtf.face.network.model.ZimInitResponse;
import java.util.Map;

public final class g implements APICallback<Map<String, Object>> {
    public final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f12b;
    public final /* synthetic */ Map c;

    public g(String str, long j, Map map) {
        this.a = str;
        this.f12b = j;
        this.c = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(Map<String, Object> map) {
        ZimInitResponse zimInitResponse;
        if (ToygerConfig.getInstance().expiredCheck(this.a, "zimInit", System.currentTimeMillis() - this.f12b) || map == null || map.size() == 0) {
            return;
        }
        String str = (String) map.get(TtmlNode.TAG_DATA);
        ZimInitResponse zimInitResponse2 = new ZimInitResponse();
        try {
            zimInitResponse = (ZimInitResponse) JSONObject.parseObject(str, ZimInitResponse.class);
            try {
                zimInitResponse.fixParams();
            } catch (Throwable th) {
                zimInitResponse2 = zimInitResponse;
                zimInitResponse2.retCode = null;
                zimInitResponse = zimInitResponse2;
                i iVar = (i) this.c.get("zimInitCallback");
                if ("Z5110".equalsIgnoreCase(zimInitResponse.retCodeSub)) {
                }
                FaceDataFrameInfo.info_cache = "" + this.a + "." + (str == null ? zimInitResponse.retCode : null);
                SgomInfoManager.updateSgomInfo(-779092065, (Map) null);
            }
        } catch (Throwable th2) {
        }
        i iVar2 = (i) this.c.get("zimInitCallback");
        if ("Z5110".equalsIgnoreCase(zimInitResponse.retCodeSub)) {
            if (iVar2 != null) {
                iVar2.onServerError(zimInitResponse.retCodeSub, zimInitResponse.retMessageSub);
            }
        } else if (iVar2 != null) {
            iVar2.onSuccess(zimInitResponse.protocol, zimInitResponse.extParams, zimInitResponse.wishControlBiz);
        } else {
            RecordService.getInstance().recordEvent(2, "faceVerifyInit", new String[]{"status", "success", "content", JSON.toJSONString(str)});
        }
        FaceDataFrameInfo.info_cache = "" + this.a + "." + (str == null ? zimInitResponse.retCode : null);
        SgomInfoManager.updateSgomInfo(-779092065, (Map) null);
    }

    public void onError(String str, String str2, String str3) {
        RecordService.getInstance().recordEvent(4, "faceVerifyInit", new String[]{"status", "error", "errCode", str, "errMsg", str2, "errType", str3});
        if (ToygerConfig.getInstance().expiredCheck(this.a, "zimInit", System.currentTimeMillis() - this.f12b)) {
            return;
        }
        i iVar = (i) this.c.get("zimInitCallback");
        if (iVar != null) {
            if ("SERVER".equals(str)) {
                iVar.onServerError(String.valueOf(2003), str2);
            } else {
                iVar.onError(str, str2);
            }
        }
        FaceDataFrameInfo.info_cache = "" + this.a + "." + str;
        SgomInfoManager.updateSgomInfo(-779092065, (Map) null);
    }
}