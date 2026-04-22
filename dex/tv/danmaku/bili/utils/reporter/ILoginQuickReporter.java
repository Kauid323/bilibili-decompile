package tv.danmaku.bili.utils.reporter;

import android.widget.CheckBox;
import com.bilibili.lib.accountsui.quick.IQuickLoginReporter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ILoginQuickReporter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\"\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/utils/reporter/ILoginQuickReporter;", "Lcom/bilibili/lib/accountsui/quick/IQuickLoginReporter;", "promptScene", "", "<init>", "(Ljava/lang/String;)V", "reportCloseClick", "", "ispReportFlag", "reportLinkClick", "itemId", "", "reportLoginClick", "isShow", "isChecked", "reportChangeLoginWayClick", "reportRegCheckboxClick", "view", "Landroid/widget/CheckBox;", "reportLoginGuideClick", "reportLoginGuideClose", "reportLoginGuideChangeLoginWay", "onGetLoginStatus", "code", "status", "(Ljava/lang/String;Ljava/lang/Integer;)V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class ILoginQuickReporter implements IQuickLoginReporter {
    public static final int $stable = 0;
    private final String promptScene;

    public abstract void reportChangeLoginWayClick(String str);

    public abstract void reportCloseClick(String str);

    public abstract void reportLinkClick(int i, String str);

    public abstract void reportLoginClick(String str, String str2, String str3);

    public abstract void reportRegCheckboxClick(CheckBox checkBox);

    public ILoginQuickReporter(String promptScene) {
        this.promptScene = promptScene;
    }

    public final void reportLoginGuideClick() {
        LoginReporterV2.Click.report("main.homepage.onepass-popup.all.click", LoginReporterV2.generateSingleParamMaps("arg", "1"));
    }

    public final void reportLoginGuideClose() {
        LoginReporterV2.Click.report("main.homepage.onepass-popup.all.click", LoginReporterV2.generateSingleParamMaps("arg", "0"));
    }

    public final void reportLoginGuideChangeLoginWay() {
        LoginReporterV2.Click.report("main.homepage.onepass-popup.all.click", LoginReporterV2.generateSingleParamMaps("arg", "3"));
    }

    public void onGetLoginStatus(String code, Integer status) {
        Intrinsics.checkNotNullParameter(code, "code");
        HashMap $this$onGetLoginStatus_u24lambda_u240 = LoginReporterV2.generateSingleParamMaps("code", code);
        String str = this.promptScene;
        if (str == null) {
            str = "";
        }
        $this$onGetLoginStatus_u24lambda_u240.put("refer_click", str);
        if (status != null) {
            int it = status.intValue();
            $this$onGetLoginStatus_u24lambda_u240.put("login_status", String.valueOf(it));
        }
        LoginReporterV2.Show.report("app.onepass-login.onepass.getstatus.show", $this$onGetLoginStatus_u24lambda_u240);
    }
}