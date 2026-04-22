package baseverify;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.dtf.face.ToygerConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d {
    public static boolean a(Context context, Map<String, Object> map) {
        try {
            Context startContext = ToygerConfig.getInstance().getStartContext();
            if (startContext != null && (startContext instanceof Activity)) {
                context = startContext;
            }
            Method declaredMethod = Class.forName("com.dtf.ocr.verify.DTFOcrFacade").getDeclaredMethod("startOcr", Context.class, Map.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, context, map);
            return true;
        } catch (Throwable th) {
            RecordService.getInstance().recordEvent(4, "ocrError", new String[]{"status", RecordService.getStackTraceString(th)});
            return false;
        }
    }

    public static boolean b(Context context, Map<String, Object> map) {
        try {
            Context startContext = ToygerConfig.getInstance().getStartContext();
            if (startContext != null && (startContext instanceof Activity)) {
                context = startContext;
            }
            Method declaredMethod = Class.forName("com.dtf.face.verify.DTFaceFacade").getDeclaredMethod("startFace", Context.class, Map.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, context, map);
            return true;
        } catch (Throwable th) {
            RecordService.getInstance().recordEvent(4, "FacError", new String[]{"status", RecordService.getStackTraceString(th)});
            return false;
        }
    }

    public static boolean c(Context context, Map<String, Object> map) {
        RecordService.getInstance().recordEvent(2, "startNFCAuthentication", new String[0]);
        try {
            Context startContext = ToygerConfig.getInstance().getStartContext();
            if (startContext != null && (startContext instanceof Activity)) {
                context = startContext;
            }
            Method declaredMethod = Class.forName("com.dtf.face.nfc.verify.DTFNfcFacade").getDeclaredMethod("startNfc", Context.class, Map.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, context, map);
            return true;
        } catch (Exception e) {
            RecordService.getInstance().recordEvent(4, "nfcError", new String[]{"status", RecordService.getStackTraceString(e)});
            return false;
        }
    }

    public static Map<String, Object> a(String str, String str2, i iVar) {
        HashMap hashMap = new HashMap();
        String updateSgomInfo = SgomInfoManager.updateSgomInfo(1321598775, (Map) null);
        if (!TextUtils.isEmpty(updateSgomInfo)) {
            try {
                JSONObject parseObject = JSON.parseObject(str2);
                parseObject.put("zconfigId", updateSgomInfo);
                str2 = parseObject.toJSONString();
            } catch (Exception e) {
            }
        }
        hashMap.put("zimId", str);
        hashMap.put("metaInfo", str2);
        if (iVar != null) {
            hashMap.put("zimInitCallback", iVar);
        }
        hashMap.put("callback", new g(str, System.currentTimeMillis(), hashMap));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("zimId", str);
        jSONObject.put("metaInfo", str2);
        hashMap.put(TtmlNode.TAG_DATA, jSONObject.toJSONString());
        return hashMap;
    }

    public static Map<String, Object> a(List<String> list, String str, APICallback<String> aPICallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("logs", list);
        hashMap.put(TtmlNode.TAG_DATA, JSONObject.toJSONString(list));
        hashMap.put("logFileName", str);
        if (aPICallback != null) {
            hashMap.put("logCallback", aPICallback);
        }
        hashMap.put("callback", new h(hashMap, str));
        return hashMap;
    }
}