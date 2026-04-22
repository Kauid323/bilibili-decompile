package tv.danmaku.bili.push.pushsetting.system;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.droid.NotificationSettingHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: SystemDialogMigrate.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\"+\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"+\u0010\n\u001a\u00020\t2\u0006\u0010\u0000\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"<set-?>", "", "migrated", "getMigrated", "()Z", "setMigrated", "(Z)V", "migrated$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "", "installAppVersion", "getInstallAppVersion", "()I", "setInstallAppVersion", "(I)V", "installAppVersion$delegate", "migrateSystemPushDialogShowTimes", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SystemDialogMigrateKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(SystemDialogMigrateKt.class, "migrated", "getMigrated()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(SystemDialogMigrateKt.class, "installAppVersion", "getInstallAppVersion()I", 1))};
    private static final SharedPreferencesField migrated$delegate = new SharedPreferencesField("sp_key_system_notification_dialog_migrated", false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
    private static final SharedPreferencesField installAppVersion$delegate = new SharedPreferencesField("sp_key_install_app_version_code", 0, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    private static final boolean getMigrated() {
        return ((Boolean) migrated$delegate.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    private static final void setMigrated(boolean z) {
        migrated$delegate.setValue((Object) null, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    private static final int getInstallAppVersion() {
        return ((Number) installAppVersion$delegate.getValue((Object) null, $$delegatedProperties[1])).intValue();
    }

    private static final void setInstallAppVersion(int i) {
        installAppVersion$delegate.setValue((Object) null, $$delegatedProperties[1], Integer.valueOf(i));
    }

    public static final void migrateSystemPushDialogShowTimes(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (EnvironmentManager.getInstance().isFirstStart()) {
            setInstallAppVersion(FoundationAlias.getFapps().getVersionCode());
        }
        if (Build.VERSION.SDK_INT < 33 || NotificationSettingHelper.isNotificationEnable(activity)) {
            return;
        }
        if (getInstallAppVersion() >= 7520000) {
            setMigrated(true);
        }
        if (getMigrated()) {
            return;
        }
        boolean shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS");
        if (SystemPushDialogHelperKt.getRequestPermissionTimes() == 0) {
            if (shouldShowRequestPermissionRationale) {
                SystemPushDialogHelperKt.setFirstSystemDialogShowTimeConsumed(true);
            }
        } else if (SystemPushDialogHelperKt.getRequestPermissionTimes() == 1) {
            SystemPushDialogHelperKt.setFirstSystemDialogShowTimeConsumed(shouldShowRequestPermissionRationale);
        } else if (SystemPushDialogHelperKt.getRequestPermissionTimes() >= 2) {
            SystemPushDialogHelperKt.setFirstSystemDialogShowTimeConsumed(true);
        }
        boolean firstSystemDialogShowTimeConsumed = SystemPushDialogHelperKt.getFirstSystemDialogShowTimeConsumed();
        BLog.i("SystemDialogMigrate", "migrate result, firstSystemDialogShowTimeConsumed " + firstSystemDialogShowTimeConsumed + " , requestPermissionTimes = " + SystemPushDialogHelperKt.getRequestPermissionTimes() + " , shouldShowRequestPermissionRationale = " + shouldShowRequestPermissionRationale);
        setMigrated(true);
    }
}