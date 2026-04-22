package tv.danmaku.bili.ui.splash.utils;

import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import androidx.compose.ui.unit.Dp;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UiUtils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\t\u001a\f\u0010\n\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u001a \u0010\u000f\u001a\u00020\u0010*\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0013\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"toDp", "Landroidx/compose/ui/unit/Dp;", "", "getToDp", "(F)F", "parseColorSafely", "", "color", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "dp", "isFileExistByHash", "", "Lcom/bilibili/lib/resmanager/ResManager;", "hash", "delete", "", "url", "key", "TAG", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UiUtilsKt {
    private static final String TAG = "[Splash]UiUtils";

    public static final float getToDp(float $this$toDp) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float $this$dp$iv = $this$toDp / (displayMetrics != null ? displayMetrics.density : 2.0f);
        return Dp.constructor-impl($this$dp$iv);
    }

    public static final Integer parseColorSafely(String color) {
        try {
            return Integer.valueOf(Color.parseColor(color));
        } catch (Exception e) {
            return null;
        }
    }

    public static final int dp(int $this$dp) {
        return UiUtils.dp2Px($this$dp);
    }

    public static final boolean isFileExistByHash(ResManager $this$isFileExistByHash, String hash) {
        Intrinsics.checkNotNullParameter($this$isFileExistByHash, "<this>");
        if (hash == null) {
            return false;
        }
        return ResManager.isFileExist(new ResRequest((String) null, hash));
    }

    public static /* synthetic */ void delete$default(ResManager resManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        delete(resManager, str, str2);
    }

    public static final void delete(ResManager $this$delete, String url, String key) {
        Intrinsics.checkNotNullParameter($this$delete, "<this>");
        String str = url;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        BLog.i("TAG", "DELETE url:" + url + " key:" + key);
        ResManager.delete(new ResRequest(url, key));
    }
}