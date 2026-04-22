package tv.danmaku.bili.utils.list;

import android.app.Application;
import com.bilibili.base.AppListConfig;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blconfig.ConfigManager;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AppListConfigImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/utils/list/AppListConfigImpl;", "Lcom/bilibili/base/AppListConfig;", "<init>", "()V", "disableRegularAppListRequest", "", "getDisableRegularAppListRequest", "()Z", "disableRegularAppListRequest$delegate", "Lkotlin/Lazy;", "reportAppListAfterLogin", "getReportAppListAfterLogin", "reportAppListAfterLogin$delegate", "enableRequestAppList", "getEnableRequestAppList", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AppListConfigImpl implements AppListConfig {
    public static final int $stable = 8;
    private final Lazy disableRegularAppListRequest$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.utils.list.AppListConfigImpl$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean disableRegularAppListRequest_delegate$lambda$0;
            disableRegularAppListRequest_delegate$lambda$0 = AppListConfigImpl.disableRegularAppListRequest_delegate$lambda$0();
            return Boolean.valueOf(disableRegularAppListRequest_delegate$lambda$0);
        }
    });
    private final Lazy reportAppListAfterLogin$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.utils.list.AppListConfigImpl$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean reportAppListAfterLogin_delegate$lambda$0;
            reportAppListAfterLogin_delegate$lambda$0 = AppListConfigImpl.reportAppListAfterLogin_delegate$lambda$0();
            return Boolean.valueOf(reportAppListAfterLogin_delegate$lambda$0);
        }
    });

    public boolean getDisableRegularAppListRequest() {
        return ((Boolean) this.disableRegularAppListRequest$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disableRegularAppListRequest_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_disable_regular_app_list_request", true);
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        boolean $this$disableRegularAppListRequest_delegate_u24lambda_u240_u240 = booleanValue;
        BLog.i("AppListConfigImpl", "ff_disable_regular_app_list_request:" + $this$disableRegularAppListRequest_delegate_u24lambda_u240_u240);
        return booleanValue;
    }

    public boolean getReportAppListAfterLogin() {
        return ((Boolean) this.reportAppListAfterLogin$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportAppListAfterLogin_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_report_app_list_after_login", true);
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        boolean $this$reportAppListAfterLogin_delegate_u24lambda_u240_u240 = booleanValue;
        BLog.i("AppListConfigImpl", "ff_report_app_list_after_login:" + $this$reportAppListAfterLogin_delegate_u24lambda_u240_u240);
        return booleanValue;
    }

    public boolean getEnableRequestAppList() {
        LoginAppListUploaderKt.updateInstallVersionFlag();
        if (LoginAppListUploaderKt.getInstallVersionAbove746()) {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            if (BiliAccounts.get(application).hasFirstLogin()) {
                return true;
            }
            return !getDisableRegularAppListRequest();
        }
        return true;
    }
}