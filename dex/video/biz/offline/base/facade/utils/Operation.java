package video.biz.offline.base.facade.utils;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;

/* compiled from: ProviderHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lvideo/biz/offline/base/facade/utils/Operation;", "", "mClient", "Landroid/content/ContentProviderClient;", "<init>", "(Landroid/content/ContentProviderClient;)V", "update", "uri", "Landroid/net/Uri;", "values", "Landroid/content/ContentValues;", "release", "", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Operation {
    public static final int $stable = 8;
    private ContentProviderClient mClient;

    public Operation(ContentProviderClient mClient) {
        this.mClient = mClient;
    }

    public final Operation update(Uri uri, ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(values, "values");
        ContentProviderClient client = this.mClient;
        if (client == null) {
            return this;
        }
        try {
            client.update(uri, values, null, null);
        } catch (Exception e) {
            LogKt.getVBLog().warn("CANNOT APPLY CHANGES TO PROVIDER! values:" + values.keySet() + " error: " + e);
        }
        return this;
    }

    public final void release() {
        ContentProviderClient client = this.mClient;
        if (client == null) {
            return;
        }
        try {
            client.release();
        } catch (Exception e) {
        }
        this.mClient = null;
    }
}