package video.biz.offline.base.facade.utils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ProviderHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J(\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¨\u0006\u0010"}, d2 = {"Lvideo/biz/offline/base/facade/utils/Notifier;", "", "<init>", "()V", "getAuthority", "", "context", "Landroid/content/Context;", "getVideoCountUrl", "Landroid/net/Uri;", "update", "", "total", "", "downloading", "downloaded", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Notifier {
    public static final int $stable = 0;
    public static final Notifier INSTANCE = new Notifier();

    private Notifier() {
    }

    private final String getAuthority(Context context) {
        return context.getPackageName() + ".providers.VideoDownloadProvider";
    }

    private final Uri getVideoCountUrl(Context context) {
        String $this$toUri$iv = "content://" + getAuthority(context) + "/videoCount";
        return Uri.parse($this$toUri$iv);
    }

    public final void update(Context context, int total, int downloading, int downloaded) {
        if (context == null) {
            return;
        }
        ContentValues values = new ContentValues();
        values.put("total", Integer.valueOf(total));
        values.put("downloading", Integer.valueOf(downloading));
        values.put("downloaded", Integer.valueOf(downloaded));
        ProviderHelperKt.acquireProviderOp(context, getAuthority(context)).update(getVideoCountUrl(context), values).release();
    }
}