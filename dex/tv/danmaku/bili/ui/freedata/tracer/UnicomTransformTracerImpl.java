package tv.danmaku.bili.ui.freedata.tracer;

import com.bilibili.fd_service.FreeDataConfig;
import com.bilibili.fd_service.FreeDataResult;
import com.bilibili.fd_service.unicom.UnicomTransformTracer;

public class UnicomTransformTracerImpl implements UnicomTransformTracer {
    private static final String TAG = "tf.UnicomTransformTracerImpl";
    private static final UnicomTransformTracerImpl instance = new UnicomTransformTracerImpl();

    private UnicomTransformTracerImpl() {
    }

    public static UnicomTransformTracerImpl getInstance() {
        return instance;
    }

    public void onUrlTransform(UnicomTransformTracer.TransformType type, int httpCode, String respCode, FreeDataResult transResult) {
        int result = transResult.isSuccess() ? 1 : 2;
        transResult.appendMessage("trans_httpcode:", false).appendMessage(String.valueOf(httpCode)).appendMessage("trans_respcode:", false).appendMessage(respCode);
        FreeDataConfig.getReporter().reportPlayEvent(transResult.mPlainUserId, 2, Integer.valueOf(result), transResult.getMessages(), transResult.mCheckedIp, String.valueOf(transResult.mErrorCode));
    }

    public void onNetIpCheck(int httpCode, String respCode, boolean isIpValide, FreeDataResult transResult) {
        boolean success = (transResult.resultType == FreeDataResult.ResultType.FAILED || transResult.resultType == FreeDataResult.ResultType.IP_INVALIDE) ? false : true;
        int result = success ? 1 : 2;
        transResult.appendMessage("ip_httpcode:", false).appendMessage(String.valueOf(httpCode)).appendMessage("ip_respcode:", false).appendMessage(respCode);
        FreeDataConfig.getReporter().reportPlayEvent(transResult.mPlainUserId, 1, Integer.valueOf(result), transResult.getMessages(), transResult.mCheckedIp, String.valueOf(transResult.mErrorCode));
    }
}