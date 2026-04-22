package tv.danmaku.bili.report.umeng;

import android.content.SharedPreferences;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.bili.BR;

/* compiled from: UmengReportUtil.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\f\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"TAG", "", "SP_UMENG_REPORT_DEVICE_INFO_SUCCESS", "<set-?>", "", "hasReportUmengDeviceInfo", "getHasReportUmengDeviceInfo", "()Z", "setHasReportUmengDeviceInfo", "(Z)V", "hasReportUmengDeviceInfo$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "reportUmengDeviceInfo", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UmengReportUtilKt {
    private static final String TAG = "UmengReportUtil";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(UmengReportUtilKt.class, "hasReportUmengDeviceInfo", "getHasReportUmengDeviceInfo()Z", 1))};
    private static final String SP_UMENG_REPORT_DEVICE_INFO_SUCCESS = "sp_umeng_report_device_info_success";
    private static final SharedPreferencesField hasReportUmengDeviceInfo$delegate = new SharedPreferencesField(SP_UMENG_REPORT_DEVICE_INFO_SUCCESS, false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    private static final boolean getHasReportUmengDeviceInfo() {
        return ((Boolean) hasReportUmengDeviceInfo$delegate.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHasReportUmengDeviceInfo(boolean z) {
        hasReportUmengDeviceInfo$delegate.setValue((Object) null, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public static final void reportUmengDeviceInfo() {
        if (getHasReportUmengDeviceInfo()) {
            return;
        }
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new UmengReportUtilKt$reportUmengDeviceInfo$1(null), 3, (Object) null);
    }
}