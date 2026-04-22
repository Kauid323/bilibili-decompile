package tv.danmaku.bili.ui.freedata.tracer;

import com.bilibili.fd_service.report.FreeDataReporter;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.platform.infoeyes.TaskIdConst;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: FreeDataReporterImpl.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J5\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016JI\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0017JD\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016¨\u0006 "}, d2 = {"Ltv/danmaku/bili/ui/freedata/tracer/FreeDataReporterImpl;", "Lcom/bilibili/fd_service/report/FreeDataReporter;", "<init>", "()V", "reportPageClick", "", "button", "", "reportPageShow", "entrance", "order", "", "freeDataType", "message", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "reportOrderResult", "reportUserAction", "reportPlayEvent", "userMob", "step", "result", "checkIp", "errorCode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "reportActive", LoginReporterV2.APP_ONEPASS_KEY_OPERATOR, "freeType", "errorMsg", "activate", "product", "reportFreeDataEntranceShow", "reportFreeDataEntranceClick", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FreeDataReporterImpl implements FreeDataReporter {
    public static final int $stable = 0;

    public void reportPageClick(int button) {
        InfoEyesManager.getInstance().report2(false, TaskIdConst.TABLE_FREE_DATA_PAGE_CLICK, new String[]{String.valueOf(button)});
    }

    public void reportPageShow(Integer entrance, String order, String freeDataType, String message) {
        InfoEyesManager.getInstance().report2(false, TaskIdConst.TABLE_FREE_DATA_PAGE_SHOW, new String[]{String.valueOf(entrance), order, freeDataType, message});
    }

    public void reportOrderResult(String order, String freeDataType, String message) {
        InfoEyesManager.getInstance().report2(false, TaskIdConst.TABLE_FREE_DATA_PAGE_SHOW, new String[]{"", order, freeDataType, message});
    }

    public void reportUserAction(String freeDataType) {
        InfoEyesManager.getInstance().report2(false, TaskIdConst.TABLE_FREE_DATA_ACTION, new String[]{freeDataType});
    }

    public void reportPlayEvent(String userMob, Integer step, Integer result, String message, String checkIp, String errorCode) {
        InfoEyesManager.getInstance().report2(true, TaskIdConst.TABLE_FREE_DATA_PLAY, new String[]{userMob, String.valueOf(step), String.valueOf(result), message, checkIp, errorCode});
    }

    public void reportActive(String operator, String freeType, String order, String errorMsg, String activate, String product) {
        String str;
        HashMap maps = new HashMap();
        maps.put(LoginReporterV2.APP_ONEPASS_KEY_OPERATOR, operator == null ? "" : operator);
        maps.put("freetype", freeType == null ? "" : freeType);
        maps.put("order", order == null ? "" : order);
        maps.put("errormsg", errorMsg == null ? "" : errorMsg);
        maps.put("activate", activate == null ? "" : activate);
        maps.put("product", product != null ? product : "");
        str = FreeDataReporterImplKt.TAG;
        BLog.i(str + "main.freeflow.statup.sys" + maps);
        Neurons.report$default(false, 4, "main.freeflow.statup.sys", maps, (String) null, 0, 48, (Object) null);
    }

    public void reportFreeDataEntranceShow() {
        String str;
        str = FreeDataReporterImplKt.TAG;
        BLog.i(str + "main.my-information.freeflow-entrance.0.show");
        Neurons.reportExposure$default(false, "main.my-information.freeflow-entrance.0.show", (Map) null, (List) null, 12, (Object) null);
    }

    public void reportFreeDataEntranceClick() {
        String str;
        str = FreeDataReporterImplKt.TAG;
        BLog.i(str + "main.my-information.freeflow-entrance.0.click");
        Neurons.reportClick$default(false, "main.my-information.freeflow-entrance.0.click", (Map) null, 4, (Object) null);
    }
}