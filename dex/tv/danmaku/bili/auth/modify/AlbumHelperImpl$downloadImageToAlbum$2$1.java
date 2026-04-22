package tv.danmaku.bili.auth.modify;

import android.content.Context;
import android.net.Uri;
import bili.resource.account.R;
import com.bilibili.droid.MediaUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.image2.bean.DownloadOnlyResponse;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.helper.ViewHelper;

/* compiled from: AlbumHelperImpl.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"tv/danmaku/bili/auth/modify/AlbumHelperImpl$downloadImageToAlbum$2$1", "Lcom/bilibili/lib/image2/bean/ImageDataSubscriber;", "Lcom/bilibili/lib/image2/bean/DownloadOnlyResponse;", "onResult", "", "imageDataSource", "Lcom/bilibili/lib/image2/bean/ImageDataSource;", "onFailure", "onCancellation", "dataSource", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AlbumHelperImpl$downloadImageToAlbum$2$1 implements ImageDataSubscriber<DownloadOnlyResponse> {
    final /* synthetic */ Context $it;
    final /* synthetic */ AlbumHelperImpl this$0;

    public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
        ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlbumHelperImpl$downloadImageToAlbum$2$1(Context $it, AlbumHelperImpl $receiver) {
        this.$it = $it;
        this.this$0 = $receiver;
    }

    public void onResult(ImageDataSource<DownloadOnlyResponse> imageDataSource) {
        DownloadOnlyResponse downloadOnlyResponse;
        File cacheFile = (imageDataSource == null || (downloadOnlyResponse = (DownloadOnlyResponse) imageDataSource.getResult()) == null) ? null : downloadOnlyResponse.getFile();
        try {
            if (cacheFile == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Can not find image %s !", Arrays.copyOf(new Object[]{String.valueOf(cacheFile)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                throw new FileNotFoundException(format);
            }
            String destFileName = "bili_realname_template" + System.currentTimeMillis() + ".jpg";
            Uri uri = MediaUtils.insertMediaToPictureFolderSync(this.$it, cacheFile, destFileName, "image/jpeg");
            String mImagePath = MediaUtils.getPathByUri(this.$it, uri);
            if (mImagePath == null) {
                onFailure(imageDataSource);
                return;
            }
            final AlbumHelperImpl albumHelperImpl = this.this$0;
            HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.AlbumHelperImpl$downloadImageToAlbum$2$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AlbumHelperImpl$downloadImageToAlbum$2$1.onResult$lambda$0(AlbumHelperImpl.this);
                }
            });
        } catch (Exception e) {
            onFailure(imageDataSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResult$lambda$0(AlbumHelperImpl this$0) {
        ViewHelper $this$onResult_u24lambda_u240_u240;
        try {
            $this$onResult_u24lambda_u240_u240 = this$0.mView;
            if ($this$onResult_u24lambda_u240_u240 != null) {
                $this$onResult_u24lambda_u240_u240.dismissProgress();
                $this$onResult_u24lambda_u240_u240.showTip(R.string.account_global_string_214);
            }
        } catch (Exception e) {
        }
    }

    public void onFailure(ImageDataSource<DownloadOnlyResponse> imageDataSource) {
        final AlbumHelperImpl albumHelperImpl = this.this$0;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.modify.AlbumHelperImpl$downloadImageToAlbum$2$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AlbumHelperImpl$downloadImageToAlbum$2$1.onFailure$lambda$1(AlbumHelperImpl.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$1(AlbumHelperImpl this$0) {
        ViewHelper $this$onFailure_u24lambda_u241_u240;
        try {
            $this$onFailure_u24lambda_u241_u240 = this$0.mView;
            if ($this$onFailure_u24lambda_u241_u240 != null) {
                $this$onFailure_u24lambda_u241_u240.dismissProgress();
                $this$onFailure_u24lambda_u241_u240.showTip(R.string.account_global_string_303);
            }
        } catch (Exception e) {
        }
    }

    public void onCancellation(ImageDataSource<DownloadOnlyResponse> imageDataSource) {
        onFailure(imageDataSource);
    }
}