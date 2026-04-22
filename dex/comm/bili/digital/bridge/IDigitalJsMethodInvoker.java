package comm.bili.digital.bridge;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import im.setting.UtilsKt;
import kotlin.Metadata;

/* compiled from: IDigitalJsMethodInvoker.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH&J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H&¢\u0006\u0002\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcomm/bili/digital/bridge/IDigitalJsMethodInvoker;", "", "invokeNative", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "handlerV2", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "method", "", UtilsKt.DATA_KEY, "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "getSupportFunctions", "", "()[Ljava/lang/String;", "digital-bridge_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IDigitalJsMethodInvoker {
    String[] getSupportFunctions();

    void invokeNative(Activity activity, Fragment fragment, JsBridgeCallHandlerV2 jsBridgeCallHandlerV2, String str, JSONObject jSONObject, String str2);
}