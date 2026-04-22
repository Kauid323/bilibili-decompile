package video.interfacee.bridge.settings;

import android.content.Context;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: KDownloadSettings.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"KDownloadSettings", "Lvideo/interfacee/bridge/settings/IDownloadSettings;", "getKDownloadSettings", "()Lvideo/interfacee/bridge/settings/IDownloadSettings;", "downloadSettingsBridge", "getDownloadSettingsBridge", "downloadSettingsBridge$delegate", "Lkotlin/Lazy;", "bridge_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class KDownloadSettingsKt {
    private static final IDownloadSettings KDownloadSettings = new IDownloadSettings() { // from class: video.interfacee.bridge.settings.KDownloadSettingsKt$KDownloadSettings$1
        @Override // video.interfacee.bridge.settings.IDownloadSettings
        public boolean getAutoDownloadConfig(Context context, boolean defaultValue) {
            Intrinsics.checkNotNullParameter(context, "context");
            return KDownloadSettingsKt.getDownloadSettingsBridge().getAutoDownloadConfig(context, defaultValue);
        }

        @Override // video.interfacee.bridge.settings.IDownloadSettings
        public void setAutoDownloadConfig(Context context, boolean value) {
            Intrinsics.checkNotNullParameter(context, "context");
            KDownloadSettingsKt.getDownloadSettingsBridge().setAutoDownloadConfig(context, value);
        }

        @Override // video.interfacee.bridge.settings.IDownloadSettings
        public String getPreferredStorageType(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return KDownloadSettingsKt.getDownloadSettingsBridge().getPreferredStorageType(context);
        }

        @Override // video.interfacee.bridge.settings.IDownloadSettings
        public void setPreferredStorageType(Context context, String type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            KDownloadSettingsKt.getDownloadSettingsBridge().setPreferredStorageType(context, type);
        }
    };
    private static final Lazy downloadSettingsBridge$delegate = LazyKt.lazy(new Function0() { // from class: video.interfacee.bridge.settings.KDownloadSettingsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            IDownloadSettings downloadSettingsBridge_delegate$lambda$0;
            downloadSettingsBridge_delegate$lambda$0 = KDownloadSettingsKt.downloadSettingsBridge_delegate$lambda$0();
            return downloadSettingsBridge_delegate$lambda$0;
        }
    });

    public static final IDownloadSettings getKDownloadSettings() {
        return KDownloadSettings;
    }

    public static final IDownloadSettings getDownloadSettingsBridge() {
        return (IDownloadSettings) downloadSettingsBridge$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IDownloadSettings downloadSettingsBridge_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((KDownloadSettingsEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(KDownloadSettingsEntryPoint.class))).getDownloadSettings();
    }
}