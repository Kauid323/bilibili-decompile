package video.biz.offline.base.infra.utils;

import com.bilibili.lib.foundation.FoundationAlias;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.interfacee.bridge.settings.KDownloadSettingsKt;

/* compiled from: ConfigImpl.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"getAutoDownloadConfig", "", "setAutoDownloadConfig", "", "value", "retryErrorCodes", "", "", "getRetryErrorCodes", "()Ljava/util/List;", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ConfigImpl_androidKt {
    public static final boolean getAutoDownloadConfig() {
        return KDownloadSettingsKt.getKDownloadSettings().getAutoDownloadConfig(FoundationAlias.getFapp(), true);
    }

    public static final void setAutoDownloadConfig(boolean value) {
        KDownloadSettingsKt.getKDownloadSettings().setAutoDownloadConfig(FoundationAlias.getFapp(), value);
    }

    public static final List<Integer> getRetryErrorCodes() {
        String subStr = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "videodetail.retry_code", (String) null, 2, (Object) null);
        if (subStr == null) {
            subStr = "";
        }
        Iterable $this$mapNotNull$iv = StringsKt.split$default(subStr, new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            String it = (String) element$iv$iv$iv;
            Integer intOrNull = StringsKt.toIntOrNull(StringsKt.trim(it).toString());
            if (intOrNull != null) {
                destination$iv$iv.add(intOrNull);
            }
        }
        return (List) destination$iv$iv;
    }
}