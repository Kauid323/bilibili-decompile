package tv.danmaku.bili.auth.helper;

import android.net.Uri;
import com.bilibili.lib.ui.BaseFragment;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: AlbumHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/auth/helper/AlbumHelper;", "", "uploadCardPic", "", "photoUri", "Landroid/net/Uri;", "listener", "Ltv/danmaku/bili/auth/helper/RequestUploadPhotoListener;", "startCamera", "", "fragment", "Lcom/bilibili/lib/ui/BaseFragment;", "openAlbum", "downloadImageToAlbum", "url", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface AlbumHelper {
    void downloadImageToAlbum(BaseFragment baseFragment, String str);

    void openAlbum(BaseFragment baseFragment);

    void startCamera(BaseFragment baseFragment);

    boolean uploadCardPic(Uri uri, RequestUploadPhotoListener requestUploadPhotoListener);
}