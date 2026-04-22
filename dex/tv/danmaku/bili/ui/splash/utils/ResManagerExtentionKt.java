package tv.danmaku.bili.ui.splash.utils;

import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResResponse;
import com.bilibili.lib.stagger.ResourcesKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ResManagerExtention.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\"\u0017\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, d2 = {"getSplashRes", "Lcom/bilibili/lib/resmanager/ResResponse;", "Lcom/bilibili/lib/resmanager/ResManager;", "hashKey", "", "isValid", "", "(Lcom/bilibili/lib/resmanager/ResResponse;)Z", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResManagerExtentionKt {
    public static final ResResponse getSplashRes(ResManager $this$getSplashRes, String hashKey) {
        Intrinsics.checkNotNullParameter($this$getSplashRes, "<this>");
        String str = hashKey;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return ResourcesKt.getResource(ResManager.INSTANCE, "splash", hashKey);
    }

    public static final boolean isValid(ResResponse $this$isValid) {
        File file;
        return ($this$isValid == null || (file = $this$isValid.getFile()) == null || !file.exists()) ? false : true;
    }
}