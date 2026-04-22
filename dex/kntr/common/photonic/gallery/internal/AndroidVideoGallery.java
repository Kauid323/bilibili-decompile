package kntr.common.photonic.gallery.internal;

import android.content.Context;
import com.bilibili.lib.foundation.FoundationAlias;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.gallery.Pagination;
import kntr.common.photonic.gallery.entity.AndroidVideo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AndroidVideoGallery.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0014\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lkntr/common/photonic/gallery/internal/AndroidVideoGallery;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "load", "", "Lkntr/common/photonic/gallery/entity/AndroidVideo;", "albumId", "", "pagination", "Lkntr/common/photonic/gallery/Pagination;", "(Ljava/lang/String;Lkntr/common/photonic/gallery/Pagination;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadVideos", "cr", "Landroid/content/ContentResolver;", "(Landroid/content/ContentResolver;Lkntr/common/photonic/gallery/Pagination;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "columnBuckets", "", "getColumnBuckets", "()[Ljava/lang/String;", "MEDIA_COL", "[Ljava/lang/String;", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AndroidVideoGallery {
    private static final String TAG = "video";
    public static final AndroidVideoGallery INSTANCE = new AndroidVideoGallery();
    private static final String[] MEDIA_COL = {"_data", "_id", "bucket_id", "bucket_display_name", "mime_type", "_size", "date_modified", "date_added", "duration", "width", "height", "orientation"};
    public static final int $stable = 8;

    private AndroidVideoGallery() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        return FoundationAlias.getFapp();
    }

    public static /* synthetic */ Object load$default(AndroidVideoGallery androidVideoGallery, String str, Pagination pagination, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            pagination = null;
        }
        return androidVideoGallery.load(str, pagination, continuation);
    }

    public final Object load(String albumId, Pagination pagination, Continuation<? super List<AndroidVideo>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AndroidVideoGallery$load$2(pagination, null), continuation);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Object loadVideos(android.content.ContentResolver r67, kntr.common.photonic.gallery.Pagination r68, kotlin.coroutines.Continuation<? super java.util.List<kntr.common.photonic.gallery.entity.AndroidVideo>> r69) {
        /*
            Method dump skipped, instructions count: 1308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.common.photonic.gallery.internal.AndroidVideoGallery.loadVideos(android.content.ContentResolver, kntr.common.photonic.gallery.Pagination, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String[] getColumnBuckets() {
        return new String[]{"bucket_id", "bucket_display_name"};
    }
}