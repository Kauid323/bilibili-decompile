package video.biz.offline.base.facade.utils;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.MediaStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;
import video.base.log.LogKt;

/* compiled from: ProviderHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"COLUMN_TOTAL", "", "COLUMN_DOWNLOADING", "COLUMN_DOWNLOADED", "PATH_VIDEO_COUNT", "acquireProviderOp", "Lvideo/biz/offline/base/facade/utils/Operation;", "context", "Landroid/content/Context;", "authority", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ProviderHelperKt {
    private static final String COLUMN_DOWNLOADED = "downloaded";
    private static final String COLUMN_DOWNLOADING = "downloading";
    private static final String COLUMN_TOTAL = "total";
    private static final String PATH_VIDEO_COUNT = "videoCount";

    public static final Operation acquireProviderOp(Context context, String authority) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authority, "authority");
        ContentResolver resolver = context.getContentResolver();
        ContentProviderClient client = null;
        try {
            client = resolver.acquireContentProviderClient(authority);
        } catch (SecurityException e) {
            IVBLog vBLog = LogKt.getVBLog();
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            vBLog.error(message, e);
        }
        if (client == null) {
            LogKt.getVBLog().info("context is " + context + ", application is " + context.getApplicationContext());
            ContentProviderClient media = resolver.acquireContentProviderClient(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            LogKt.getVBLog().info("images provider is " + media);
            if (media != null) {
                try {
                    media.release();
                } catch (Exception e2) {
                }
            }
            return new Operation(null);
        }
        return new Operation(client);
    }
}