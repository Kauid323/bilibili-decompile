package tv.danmaku.bili.ui.theme.api;

import com.bilibili.moduleservice.coldstart.ThemeSkinList;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ColdStartSkinListService.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/theme/api/ColdStartSkinListService;", "Lcom/bilibili/moduleservice/coldstart/ThemeSkinList;", "<init>", "()V", "getParams", "", "", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ColdStartSkinListService implements ThemeSkinList {
    public Map<String, String> getParams() {
        return MapsKt.mapOf(TuplesKt.to("actionKey", "appkey"));
    }
}