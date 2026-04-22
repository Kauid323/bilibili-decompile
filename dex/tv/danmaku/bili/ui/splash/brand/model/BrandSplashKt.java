package tv.danmaku.bili.ui.splash.brand.model;

import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.resmanager.ResResponse;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.splash.utils.ResManagerExtentionKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplash.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0004\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0004\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"MODE_HALF", "", "MODE_FULL", "uniqueId", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "getUniqueId", "(Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;)Ljava/lang/String;", "isResValid", "", "isThumbExists", "loadLocalImagePath", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashKt {
    public static final String MODE_FULL = "full";
    public static final String MODE_HALF = "half";

    public static final String getUniqueId(BrandSplash $this$uniqueId) {
        Intrinsics.checkNotNullParameter($this$uniqueId, "<this>");
        long id = $this$uniqueId.getId();
        return id + "-" + $this$uniqueId.getSource();
    }

    public static final boolean isResValid(BrandSplash $this$isResValid) {
        Intrinsics.checkNotNullParameter($this$isResValid, "<this>");
        boolean $this$isResValid_u24lambda_u240 = ResManagerExtentionKt.isValid(ResManagerExtentionKt.getSplashRes(ResManager.INSTANCE, $this$isResValid.getThumbHash()));
        String thumb = $this$isResValid.getThumb();
        BLog.i("BrandSplashHelper", "res is valid:" + $this$isResValid_u24lambda_u240 + " url:" + thumb + " hash:" + $this$isResValid.getThumbHash());
        return $this$isResValid_u24lambda_u240;
    }

    public static final boolean isThumbExists(BrandSplash $this$isThumbExists) {
        File file;
        Intrinsics.checkNotNullParameter($this$isThumbExists, "<this>");
        ResResponse fetch = ResManager.fetch(new ResRequest((String) null, $this$isThumbExists.getThumbHash()));
        return (fetch == null || (file = fetch.getFile()) == null || !file.exists()) ? false : true;
    }

    public static final String loadLocalImagePath(BrandSplash $this$loadLocalImagePath) {
        File it;
        String path;
        Intrinsics.checkNotNullParameter($this$loadLocalImagePath, "<this>");
        ResResponse fetch = ResManager.fetch(new ResRequest((String) null, $this$loadLocalImagePath.getThumbHash()));
        if (fetch != null && (it = fetch.getFile()) != null) {
            if (!it.exists()) {
                it = null;
            }
            if (it != null && (path = it.getAbsolutePath()) != null) {
                return BusinessSplashDefine.FILE_URI_PREFIX + path;
            }
        }
        return null;
    }
}