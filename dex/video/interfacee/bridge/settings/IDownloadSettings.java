package video.interfacee.bridge.settings;

import android.content.Context;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IDownloadSettings.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lvideo/interfacee/bridge/settings/IDownloadSettings;", "", "getAutoDownloadConfig", "", "context", "Landroid/content/Context;", "defaultValue", "setAutoDownloadConfig", "", "value", "getPreferredStorageType", "", "setPreferredStorageType", "type", "bridge_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IDownloadSettings {
    boolean getAutoDownloadConfig(Context context, boolean z);

    String getPreferredStorageType(Context context);

    void setAutoDownloadConfig(Context context, boolean z);

    void setPreferredStorageType(Context context, String str);
}