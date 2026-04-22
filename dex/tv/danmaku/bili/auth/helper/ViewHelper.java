package tv.danmaku.bili.auth.helper;

import android.net.Uri;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: AlbumHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/auth/helper/ViewHelper;", "", "showTip", "", "resId", "", "message", "", "showProgressDialog", SplashCustomReporterKt.STATE_CANCEL, "", "dismissProgress", "updateUIAfterUpPic", AudioIntentHelper.ARGS_URI, "Landroid/net/Uri;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ViewHelper {
    void dismissProgress();

    void showProgressDialog(String str, boolean z);

    void showTip(int i);

    void showTip(String str);

    void updateUIAfterUpPic(Uri uri);

    /* compiled from: AlbumHelper.kt */
    /* renamed from: tv.danmaku.bili.auth.helper.ViewHelper$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static void $default$updateUIAfterUpPic(ViewHelper _this, Uri uri) {
        }
    }
}