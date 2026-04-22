package tv.danmaku.bili.ui.player.notification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.LruCache;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.api.utils.BfsThumbImageUriGetter;
import com.bilibili.api.utils.ThumbImageUriGetter;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.Callable;
import tv.danmaku.bili.ui.player.R;
import tv.danmaku.bili.ui.player.utils.BitmapUtil;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

public final class MusicCoverImageCache {
    private static final int BIG_BITMAP_INDEX = 0;
    public static final String DEFAULT_LOCKSCREEN = "dummy_url_lock_screen";
    private static final int ICON_BITMAP_INDEX = 1;
    private static final int MAX_ALBUM_ART_CACHE_SIZE = 6291456;
    private static final int MAX_ART_HEIGHT = 480;
    public static final int MAX_ART_HEIGHT_ICON = 300;
    private static final int MAX_ART_WIDTH = 800;
    public static final int MAX_ART_WIDTH_ICON = 300;
    private static final MusicCoverImageCache sInstance = new MusicCoverImageCache();
    private final LruCache<String, Bitmap[]> mCache;

    public static final MusicCoverImageCache getInstance() {
        return sInstance;
    }

    private MusicCoverImageCache() {
        int maxSize = Math.min((int) MAX_ALBUM_ART_CACHE_SIZE, (int) Math.min(2147483647L, Runtime.getRuntime().maxMemory() / 6));
        this.mCache = new LruCache<String, Bitmap[]>(maxSize) { // from class: tv.danmaku.bili.ui.player.notification.MusicCoverImageCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, Bitmap[] value) {
                Bitmap bigBmp = value[0];
                Bitmap smallBmp = value[1];
                return (bigBmp == null ? 0 : bigBmp.getByteCount()) + (smallBmp != null ? smallBmp.getByteCount() : 0);
            }
        };
    }

    public Bitmap getBigImage(String artUrl) {
        Bitmap[] result;
        if (TextUtils.isEmpty(artUrl) || (result = this.mCache.get(artUrl)) == null || result[0] == null || result[0].isRecycled()) {
            return null;
        }
        return result[0];
    }

    public Bitmap getIconImage(String artUrl) {
        Bitmap[] result;
        if (TextUtils.isEmpty(artUrl) || (result = this.mCache.get(artUrl)) == null || result[1] == null || result[1].isRecycled()) {
            return null;
        }
        return result[1];
    }

    public void putLocalBigImage(Context context, Bitmap bmp) {
        if (bmp == null || bmp.isRecycled()) {
            return;
        }
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg_default_music_notification_album);
        Bitmap[] bitmaps = {bmp, icon};
        this.mCache.put(DEFAULT_LOCKSCREEN, bitmaps);
    }

    public void fetch(final Context context, final String imageUrl, final FetchListener listener) {
        final String artUrl = BfsThumbImageUriGetter.getInstance().get(ThumbImageUriGetter.Params.createWebpParam(imageUrl, 800, (int) MAX_ART_HEIGHT, true));
        Bitmap bigBmp = getBigImage(artUrl);
        Bitmap iconBmp = getIconImage(artUrl);
        if (bigBmp != null && iconBmp != null) {
            listener.onFetched(artUrl, bigBmp, iconBmp);
            return;
        }
        if (bigBmp != null && !bigBmp.isRecycled()) {
            bigBmp.recycle();
        }
        if (iconBmp != null && !iconBmp.isRecycled()) {
            iconBmp.recycle();
        }
        Task.callInBackground(new Callable<Bitmap[]>() { // from class: tv.danmaku.bili.ui.player.notification.MusicCoverImageCache.3
            @Override // java.util.concurrent.Callable
            public Bitmap[] call() throws Exception {
                Bitmap bitmap;
                if (TextUtils.equals(MusicCoverImageCache.DEFAULT_LOCKSCREEN, artUrl) || TextUtils.isEmpty(artUrl)) {
                    Bitmap bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg_default_music_lockscreen_cover);
                    Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg_default_music_notification_album);
                    Bitmap[] bitmaps = {bitmap2, icon};
                    MusicCoverImageCache.this.mCache.put(imageUrl, bitmaps);
                    return bitmaps;
                }
                File file = null;
                try {
                    file = BiliImageLoaderHelper.getDiskCacheFile(artUrl);
                    if (file == null || !file.exists()) {
                        file = null;
                        URI uri = URI.create(artUrl);
                        if ("file".equalsIgnoreCase(uri.getScheme())) {
                            file = new File(uri);
                            if (!file.exists()) {
                                return null;
                            }
                        }
                    }
                } catch (Exception e) {
                    PlayerLog.e(PlayerLogModule.BackgroundPlay, "Background play MusicCoverImageCache get has err", e);
                }
                if (file != null) {
                    try {
                        if (file.exists()) {
                            bitmap = BitmapUtil.decodeFile(file.getPath(), 800.0f, 480.0f);
                            Bitmap icon2 = BitmapUtil.scaleBitmap(bitmap, 300, 300);
                            Bitmap[] bitmaps2 = {bitmap, icon2};
                            MusicCoverImageCache.this.mCache.put(imageUrl, bitmaps2);
                            return bitmaps2;
                        }
                    } catch (IOException e2) {
                        return null;
                    }
                }
                bitmap = BitmapUtil.fetchAndRescaleBitmap(artUrl, 800, MusicCoverImageCache.MAX_ART_HEIGHT);
                Bitmap icon22 = BitmapUtil.scaleBitmap(bitmap, 300, 300);
                Bitmap[] bitmaps22 = {bitmap, icon22};
                MusicCoverImageCache.this.mCache.put(imageUrl, bitmaps22);
                return bitmaps22;
            }
        }).continueWith(new Continuation<Bitmap[], Void>() { // from class: tv.danmaku.bili.ui.player.notification.MusicCoverImageCache.2
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1435then((Task<Bitmap[]>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1435then(Task<Bitmap[]> task) throws Exception {
                Bitmap[] bitmaps = (Bitmap[]) task.getResult();
                if (bitmaps == null) {
                    listener.onError(artUrl, new IllegalArgumentException("got null bitmaps"));
                    return null;
                }
                listener.onFetched(artUrl, bitmaps[0], bitmaps[1]);
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class FetchListener {
        public abstract void onFetched(String str, Bitmap bitmap, Bitmap bitmap2);

        public void onError(String artUrl, Exception e) {
        }
    }
}