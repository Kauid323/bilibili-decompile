package kntr.common.photonic.gallery;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kntr.common.photonic.gallery.GalleryLoadConfig;
import kntr.common.photonic.gallery.entity.AndroidAlbumInfo;
import kntr.common.photonic.gallery.entity.AndroidImage;
import kntr.common.photonic.gallery.entity.AndroidVideo;
import kntr.common.photonic.gallery.internal.AndroidImageGallery;
import kntr.common.photonic.gallery.internal.AndroidVideoGallery;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Gallery.android.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\tJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\tJ\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0002¨\u0006\u0016"}, d2 = {"Lkntr/common/photonic/gallery/Gallery;", "", "<init>", "()V", "getAlbumInfos", "", "Lkntr/common/photonic/AlbumInfo;", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/common/photonic/gallery/GalleryLoadConfig;", "(Lkntr/common/photonic/gallery/GalleryLoadConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAsset", "Lkntr/common/photonic/Asset;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAlbums", "loadImageAssets", "Lkntr/common/photonic/gallery/entity/AndroidImage;", "loadVideoAssets", "Lkntr/common/photonic/gallery/entity/AndroidVideo;", "defaultAlbumInfo", "assets", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Gallery {
    public static final int $stable = 0;
    public static final Gallery INSTANCE = new Gallery();

    private Gallery() {
    }

    public static /* synthetic */ Object getAlbumInfos$default(Gallery gallery, GalleryLoadConfig galleryLoadConfig, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            galleryLoadConfig = new GalleryLoadConfig(GalleryLoadConfig.MediaType.ALL, null, null, 6, null);
        }
        return gallery.getAlbumInfos(galleryLoadConfig, continuation);
    }

    public final Object getAlbumInfos(GalleryLoadConfig config, Continuation<? super List<? extends AlbumInfo>> continuation) {
        return loadAlbums(config, continuation);
    }

    public final Object loadAsset(String url, Continuation<? super Asset> continuation) {
        return AndroidImageGallery.INSTANCE.loadAssetWithContentUri(url, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadAlbums(GalleryLoadConfig config, Continuation<? super List<? extends AlbumInfo>> continuation) {
        KLog_androidKt.getKLog().i("Gallery", "Start loadAlbums with config: " + config);
        return BuildersKt.withContext(Dispatchers.getIO(), new Gallery$loadAlbums$2(config, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadImageAssets(GalleryLoadConfig config, Continuation<? super List<AndroidImage>> continuation) {
        return AndroidImageGallery.INSTANCE.load("", config, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadVideoAssets(GalleryLoadConfig config, Continuation<? super List<AndroidVideo>> continuation) {
        return AndroidVideoGallery.INSTANCE.load("", config.getPagination(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlbumInfo defaultAlbumInfo(List<? extends Asset> list) {
        return new AndroidAlbumInfo("所有相片", "", list);
    }
}