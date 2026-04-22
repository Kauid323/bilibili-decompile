package tv.danmaku.bili.ui.webview;

import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.IJsBridgeBehavior;
import com.bilibili.common.webview.js.HostCallHandler;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.jsbridge.common.BaseJsBridgeCallHandlerV2;
import com.bilibili.moduleservice.annual.GRJSONObjectCallback;
import com.bilibili.moduleservice.annual.UgcTemplateRenderService;
import tv.danmaku.android.log.BLog;

public class MJsBridgeCallHandlerAnnualReport extends BaseJsBridgeCallHandlerV2<JsBridgeBehavior> implements HostCallHandler {
    private static final String HANDLER_METHOD_UGC_TEMPLATE_GET_RESOURCE = "ugcTemplateGetResourceInfo";
    private static final String HANDLER_METHOD_UGC_TEMPLATE_LOAD_RESOURCE = "ugcTemplateLoadResource";
    private static final String HANDLER_METHOD_UGC_TEMPLATE_PRE_PROCESS = "ugcTemplatePreprocess";
    private static final String HANDLER_METHOD_UGC_TEMPLATE_REUSE_RESOURCE = "ugcTemplateReuseResource";
    private static final String HANDLER_TEMPLATE_METHOD_UGC_CANCEL_STEP = "ugcTemplateCancelStep";
    private static final String HANDLER_TEMPLATE_METHOD_UGC_RENDER_STATUS = "ugcTemplateGetRenderTaskStatus";
    private static final String HANDLER_TEMPLATE_METHOD_UGC_RENDER_VIDEO = "ugcTemplateRenderVideo";
    private static final String HANDLER_TEMPLATE_METHOD_UGC_SAVE_VIDEO = "ugcTemplateSaveVideoToAlbum";
    private static final String HANDLER_TEMPLATE_METHOD_UGC_TEMPLATE_CONTRIBUTE = "ugcTemplateContribute";
    private static final String HANDLER_TEMPLATE_METHOD_UGC_UPLOAD_VIDEO = "ugcTemplateUploadVideo";
    private static final String TAG = "MJsBridgeCallHandlerAnnualReportDebug";

    public MJsBridgeCallHandlerAnnualReport(JsBridgeBehavior behavior) {
        super(behavior);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void invokeNative(String method, JSONObject data, final String callbackId) {
        BLog.d(TAG, "invokeNative:thread=" + Thread.currentThread() + "; method = " + method + "; callbackId = " + callbackId);
        JsBridgeBehavior behavior = (JsBridgeBehavior) getJBBehavior();
        char c = 65535;
        if (behavior != null) {
            if (behavior.isDestroyed()) {
                BLog.d(TAG, "behavior has destroyed");
                m1818lambda$invokeNative$7$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, behavior.obtainJSBError("behavior has destroyed"));
                return;
            }
            try {
                switch (method.hashCode()) {
                    case -1739341352:
                        if (method.equals(HANDLER_TEMPLATE_METHOD_UGC_RENDER_STATUS)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1420999560:
                        if (method.equals(HANDLER_TEMPLATE_METHOD_UGC_TEMPLATE_CONTRIBUTE)) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -842245158:
                        if (method.equals(HANDLER_TEMPLATE_METHOD_UGC_RENDER_VIDEO)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -214227361:
                        if (method.equals(HANDLER_METHOD_UGC_TEMPLATE_LOAD_RESOURCE)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -163990927:
                        if (method.equals(HANDLER_TEMPLATE_METHOD_UGC_CANCEL_STEP)) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 498992311:
                        if (method.equals(HANDLER_METHOD_UGC_TEMPLATE_REUSE_RESOURCE)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1436980343:
                        if (method.equals(HANDLER_METHOD_UGC_TEMPLATE_PRE_PROCESS)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1850317391:
                        if (method.equals(HANDLER_TEMPLATE_METHOD_UGC_UPLOAD_VIDEO)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1956098343:
                        if (method.equals(HANDLER_METHOD_UGC_TEMPLATE_GET_RESOURCE)) {
                            c = 6;
                            break;
                        }
                        break;
                    case 2029226913:
                        if (method.equals(HANDLER_TEMPLATE_METHOD_UGC_SAVE_VIDEO)) {
                            c = 7;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        behavior.ugcTemplateRenderVideo(data, new GRJSONObjectCallback() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerAnnualReport$$ExternalSyntheticLambda0
                            public final void callback(JSONObject jSONObject) {
                                MJsBridgeCallHandlerAnnualReport.this.m1811lambda$invokeNative$0$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, jSONObject);
                            }
                        });
                        return;
                    case 1:
                        behavior.ugcTemplatePreProcess(data, new GRJSONObjectCallback() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerAnnualReport$$ExternalSyntheticLambda1
                            public final void callback(JSONObject jSONObject) {
                                MJsBridgeCallHandlerAnnualReport.this.m1812lambda$invokeNative$1$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, jSONObject);
                            }
                        });
                        return;
                    case 2:
                        behavior.ugcTemplateGetRenderTaskStatus(data, new GRJSONObjectCallback() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerAnnualReport$$ExternalSyntheticLambda2
                            public final void callback(JSONObject jSONObject) {
                                MJsBridgeCallHandlerAnnualReport.this.m1813lambda$invokeNative$2$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, jSONObject);
                            }
                        });
                        return;
                    case 3:
                        behavior.ugcTemplateLoadResource(data, new GRJSONObjectCallback() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerAnnualReport$$ExternalSyntheticLambda3
                            public final void callback(JSONObject jSONObject) {
                                MJsBridgeCallHandlerAnnualReport.this.m1814lambda$invokeNative$3$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, jSONObject);
                            }
                        });
                        return;
                    case 4:
                        behavior.ugcTemplateReuseResource(data, new GRJSONObjectCallback() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerAnnualReport$$ExternalSyntheticLambda4
                            public final void callback(JSONObject jSONObject) {
                                MJsBridgeCallHandlerAnnualReport.this.m1815lambda$invokeNative$4$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, jSONObject);
                            }
                        });
                        return;
                    case 5:
                        behavior.ugcTemplateUploadVideo(data, new GRJSONObjectCallback() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerAnnualReport$$ExternalSyntheticLambda5
                            public final void callback(JSONObject jSONObject) {
                                MJsBridgeCallHandlerAnnualReport.this.m1816lambda$invokeNative$5$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, jSONObject);
                            }
                        });
                        return;
                    case 6:
                        m1818lambda$invokeNative$7$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, behavior.ugcTemplateGetResourceInfo(data));
                        return;
                    case 7:
                        behavior.ugcTemplateSaveVideoToAlbum(data, new GRJSONObjectCallback() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerAnnualReport$$ExternalSyntheticLambda6
                            public final void callback(JSONObject jSONObject) {
                                MJsBridgeCallHandlerAnnualReport.this.m1817lambda$invokeNative$6$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, jSONObject);
                            }
                        });
                        return;
                    case '\b':
                        behavior.ugcTemplateCancelStep(data);
                        return;
                    case '\t':
                        behavior.ugcTemplateContribute(data, new GRJSONObjectCallback() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerAnnualReport$$ExternalSyntheticLambda7
                            public final void callback(JSONObject jSONObject) {
                                MJsBridgeCallHandlerAnnualReport.this.m1818lambda$invokeNative$7$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, jSONObject);
                            }
                        });
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                BLog.e(TAG, "invokeNative error: " + e.getMessage());
                return;
            }
        }
        JSONObject ret = new JSONObject();
        ret.put("code", -1);
        ret.put("message", "Data is invalid, the reason is : behavior is null");
        m1818lambda$invokeNative$7$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(callbackId, ret);
    }

    /* renamed from: safeCallback */
    public void m1818lambda$invokeNative$7$tvdanmakubiliuiwebviewMJsBridgeCallHandlerAnnualReport(String callbackId, JSONObject responseJson) {
        BLog.d(TAG, "safeCallback:thread=" + Thread.currentThread() + "; isDestroyed() = " + isDestroyed() + "; callbackId = " + callbackId + "; responseJson = " + responseJson);
        if (isDestroyed() || TextUtils.isEmpty(callbackId) || responseJson == null) {
            return;
        }
        callbackToJs(new Object[]{callbackId, responseJson});
    }

    public String[] getSupportFunctions() {
        return new String[]{HANDLER_METHOD_UGC_TEMPLATE_LOAD_RESOURCE, HANDLER_METHOD_UGC_TEMPLATE_REUSE_RESOURCE, HANDLER_METHOD_UGC_TEMPLATE_PRE_PROCESS, HANDLER_METHOD_UGC_TEMPLATE_GET_RESOURCE, HANDLER_TEMPLATE_METHOD_UGC_RENDER_STATUS, HANDLER_TEMPLATE_METHOD_UGC_RENDER_VIDEO, HANDLER_TEMPLATE_METHOD_UGC_UPLOAD_VIDEO, HANDLER_TEMPLATE_METHOD_UGC_SAVE_VIDEO, HANDLER_TEMPLATE_METHOD_UGC_CANCEL_STEP, HANDLER_TEMPLATE_METHOD_UGC_TEMPLATE_CONTRIBUTE};
    }

    protected String getTag() {
        return "MJsBridgeCallHandlerAnnualReport";
    }

    public boolean onHandler(String methodName, Object... params) {
        JsBridgeBehavior behavior = (JsBridgeBehavior) getJBBehavior();
        if (behavior != null && "onActivityResult".equals(methodName)) {
            return behavior.onActivityResult(params);
        }
        return false;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class JsBridgeHandlerFactory implements JsBridgeCallHandlerFactoryV2 {
        private final JsBridgeBehavior mBehavior;

        public JsBridgeHandlerFactory(MWebActivity activity) {
            this.mBehavior = new JsBridgeBehavior(activity);
        }

        public MJsBridgeCallHandlerAnnualReport create() {
            return new MJsBridgeCallHandlerAnnualReport(this.mBehavior);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class JsBridgeBehavior implements IJsBridgeBehavior {
        private static final int JSB_ERROR_CODE_DATA_INVALID = -1;
        private static final int JSB_ERROR_CODE_SUCCESS = 0;
        private static final String TAG = "JsBridgeBehavior";
        private MWebActivity mActivity;

        public JsBridgeBehavior(MWebActivity activity) {
            this.mActivity = activity;
        }

        private String getJSONString(JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            String jsonStr = null;
            try {
                jsonStr = jsonObject.toJSONString();
            } catch (Exception e) {
                BLog.e(TAG, e);
            }
            if (TextUtils.isEmpty(jsonStr)) {
                return null;
            }
            return jsonStr;
        }

        private JSONObject obtainJSBSuccess(JSONObject data) {
            JSONObject ret = new JSONObject();
            ret.put("code", 0);
            ret.put("message", "success");
            if (data == null) {
                ret.put("data", new JSONObject());
            } else {
                ret.put("data", data);
            }
            return ret;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject obtainJSBError(String msg) {
            JSONObject ret = new JSONObject();
            ret.put("code", -1);
            ret.put("message", "Data is invalid, the reason is :" + msg);
            return ret;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ugcTemplateLoadResource(JSONObject data, GRJSONObjectCallback callback) {
            UgcTemplateRenderService service = checkUgcGRService(callback);
            if (service != null) {
                service.ugcTemplateLoadResource(this.mActivity, data, callback);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ugcTemplateReuseResource(JSONObject data, GRJSONObjectCallback callback) {
            UgcTemplateRenderService service = checkUgcGRService(callback);
            if (service != null) {
                service.ugcTemplateReuseResource(this.mActivity, data, callback);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject ugcTemplateGetResourceInfo(JSONObject data) {
            UgcTemplateRenderService service = getUgcTemplateRenderService();
            if (service == null) {
                return getUgcGRSError();
            }
            return service.ugcTemplateGetResourceInfo(this.mActivity, data);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ugcTemplatePreProcess(JSONObject data, GRJSONObjectCallback callback) {
            UgcTemplateRenderService service = checkUgcGRService(callback);
            if (service != null) {
                service.ugcTemplatePreProcess(this.mActivity, data, callback);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ugcTemplateRenderVideo(JSONObject data, GRJSONObjectCallback callback) {
            UgcTemplateRenderService service = checkUgcGRService(callback);
            if (service != null) {
                service.ugcTemplateRenderVideo(this.mActivity, data, callback);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ugcTemplateGetRenderTaskStatus(JSONObject data, GRJSONObjectCallback callback) {
            UgcTemplateRenderService service = checkUgcGRService(callback);
            if (service != null) {
                service.ugcTemplateGetRenderTaskStatus(this.mActivity, data, callback);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ugcTemplateUploadVideo(JSONObject data, GRJSONObjectCallback callback) {
            UgcTemplateRenderService service = checkUgcGRService(callback);
            if (service != null) {
                service.ugcTemplateUploadVideo(this.mActivity, data, callback);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ugcTemplateSaveVideoToAlbum(JSONObject data, GRJSONObjectCallback callback) {
            UgcTemplateRenderService service = checkUgcGRService(callback);
            if (service != null) {
                service.ugcTemplateSaveVideoToAlbum(this.mActivity, data, callback);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ugcTemplateCancelStep(JSONObject data) {
            UgcTemplateRenderService service = getUgcTemplateRenderService();
            if (service != null) {
                service.ugcTemplateCancelStep(this.mActivity, data);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ugcTemplateContribute(JSONObject data, GRJSONObjectCallback callback) {
            UgcTemplateRenderService service = getUgcTemplateRenderService();
            if (service != null) {
                service.ugcTemplateContribute(this.mActivity, data, callback);
            }
        }

        private JSONObject getUgcGRSError() {
            return obtainJSBError("Inner error!!! UgcGeneralRenderService is null!!!");
        }

        private UgcTemplateRenderService checkUgcGRService(GRJSONObjectCallback callback) {
            UgcTemplateRenderService service = getUgcTemplateRenderService();
            if (service == null) {
                callback.callback(getUgcGRSError());
                return null;
            }
            return service;
        }

        private UgcTemplateRenderService getUgcTemplateRenderService() {
            return (UgcTemplateRenderService) BLRouter.INSTANCE.get(UgcTemplateRenderService.class, "default");
        }

        public boolean onActivityResult(Object... params) {
            if (params != null && (params.length == 2 || params.length == 3)) {
                try {
                    int requestCode = ((Integer) params[0]).intValue();
                    int resultCode = ((Integer) params[1]).intValue();
                    Intent data = (Intent) params[2];
                    return getUgcTemplateRenderService().onActivityResult(this.mActivity, requestCode, resultCode, data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        public void release() {
            UgcTemplateRenderService ugcTemplateRenderService = getUgcTemplateRenderService();
            if (ugcTemplateRenderService != null) {
                ugcTemplateRenderService.release(this.mActivity);
            }
            this.mActivity = null;
        }

        public boolean isDestroyed() {
            return this.mActivity == null || this.mActivity.isDestroyed() || this.mActivity.isFinishing();
        }
    }
}