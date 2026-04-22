package kntr.common.photonic.gallery.internal;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.ContentSizeKt;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.gallery.GalleryLoadConfig;
import kntr.common.photonic.gallery.Pagination;
import kntr.common.photonic.gallery.entity.AndroidAlbumInfo;
import kntr.common.photonic.gallery.entity.AndroidImage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.datetime.Instant;

/* compiled from: AndroidImageGallery.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002Jn\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\t2\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u0006\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0082@¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010'J\u0014\u0010-\u001a\u00020\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\tJ\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\tJ\u0014\u00100\u001a\u00020\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\tR\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u000e\u0010,\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lkntr/common/photonic/gallery/internal/AndroidImageGallery;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "load", "", "Lkntr/common/photonic/gallery/entity/AndroidImage;", "albumId", "", "options", "Lkntr/common/photonic/gallery/GalleryLoadConfig;", "(Ljava/lang/String;Lkntr/common/photonic/gallery/GalleryLoadConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildAlbumList", "cr", "Landroid/content/ContentResolver;", "bucketId", "(Landroid/content/ContentResolver;Ljava/lang/String;Lkntr/common/photonic/gallery/GalleryLoadConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addItem", "cursor", "Landroid/database/Cursor;", "query", "forType", "Lkntr/common/photonic/MimeType;", "columns", "", "isDefaultAlbum", "", "imageMimeType", "args", "order", "pagination", "Lkntr/common/photonic/gallery/Pagination;", "(Landroid/content/ContentResolver;Ljava/util/List;Ljava/lang/String;[Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lkntr/common/photonic/gallery/Pagination;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAssetWithContentUri", "uri", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getColumns", "()[Ljava/lang/String;", "columnBuckets", "getColumnBuckets", "TAG", "buildQuerySelection", "types", "buildQueryArgs", "buildSelectionId", "DESC", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AndroidImageGallery {
    public static final int $stable = 0;
    public static final String DESC = " desc";
    public static final AndroidImageGallery INSTANCE = new AndroidImageGallery();
    private static final String TAG = "image";

    private AndroidImageGallery() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        return FoundationAlias.getFapp();
    }

    public final Object load(String albumId, GalleryLoadConfig options, Continuation<? super List<AndroidImage>> continuation) {
        ContentResolver cr = getContext().getContentResolver();
        Intrinsics.checkNotNull(cr);
        return buildAlbumList(cr, albumId, options, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object buildAlbumList(ContentResolver cr, String bucketId, GalleryLoadConfig options, Continuation<? super List<AndroidImage>> continuation) {
        AndroidImageGallery$buildAlbumList$1 androidImageGallery$buildAlbumList$1;
        AndroidImageGallery$buildAlbumList$1 androidImageGallery$buildAlbumList$12;
        Cursor cursor;
        String imageMimeType;
        String[] columns;
        boolean z;
        String[] strArr;
        Pagination pagination;
        Object query;
        if (continuation instanceof AndroidImageGallery$buildAlbumList$1) {
            androidImageGallery$buildAlbumList$1 = (AndroidImageGallery$buildAlbumList$1) continuation;
            if ((androidImageGallery$buildAlbumList$1.label & Integer.MIN_VALUE) != 0) {
                androidImageGallery$buildAlbumList$1.label -= Integer.MIN_VALUE;
                androidImageGallery$buildAlbumList$12 = androidImageGallery$buildAlbumList$1;
                Object $result = androidImageGallery$buildAlbumList$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (androidImageGallery$buildAlbumList$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        List forType = options.getMediaType().getForType();
                        try {
                            int i = bucketId.length() == 0 ? 1 : 0;
                            imageMimeType = buildQuerySelection(forType);
                            Collection args = buildQueryArgs(forType);
                            columns = getColumns();
                            z = i != 0;
                            Collection $this$toTypedArray$iv = args;
                            strArr = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
                            pagination = options.getPagination();
                            androidImageGallery$buildAlbumList$12.L$0 = SpillingKt.nullOutSpilledVariable(cr);
                            androidImageGallery$buildAlbumList$12.L$1 = SpillingKt.nullOutSpilledVariable(bucketId);
                            androidImageGallery$buildAlbumList$12.L$2 = SpillingKt.nullOutSpilledVariable(options);
                            androidImageGallery$buildAlbumList$12.L$3 = SpillingKt.nullOutSpilledVariable(forType);
                            androidImageGallery$buildAlbumList$12.L$4 = SpillingKt.nullOutSpilledVariable(imageMimeType);
                            androidImageGallery$buildAlbumList$12.L$5 = SpillingKt.nullOutSpilledVariable(args);
                            androidImageGallery$buildAlbumList$12.L$6 = SpillingKt.nullOutSpilledVariable("date_modified desc");
                            androidImageGallery$buildAlbumList$12.I$0 = i;
                            androidImageGallery$buildAlbumList$12.label = 1;
                        } catch (Exception e) {
                            e = e;
                            cursor = null;
                        } catch (Throwable th) {
                            e = th;
                            cursor = null;
                        }
                        try {
                            query = query(cr, forType, bucketId, columns, z, imageMimeType, strArr, "date_modified desc", pagination, androidImageGallery$buildAlbumList$12);
                            if (query == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            cursor = (Cursor) query;
                            List<AndroidImage> addItem = addItem(cursor);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return addItem;
                        } catch (Exception e2) {
                            e = e2;
                            cursor = null;
                            GalleryLog.INSTANCE.e(TAG, "query error", e);
                            List emptyList = CollectionsKt.emptyList();
                            if (cursor != null) {
                            }
                            return emptyList;
                        } catch (Throwable th2) {
                            e = th2;
                            cursor = null;
                            if (cursor != null) {
                            }
                            throw e;
                        }
                    case 1:
                        int i2 = androidImageGallery$buildAlbumList$12.I$0;
                        String str = (String) androidImageGallery$buildAlbumList$12.L$6;
                        List list = (List) androidImageGallery$buildAlbumList$12.L$5;
                        String str2 = (String) androidImageGallery$buildAlbumList$12.L$4;
                        List list2 = (List) androidImageGallery$buildAlbumList$12.L$3;
                        cursor = null;
                        GalleryLoadConfig galleryLoadConfig = (GalleryLoadConfig) androidImageGallery$buildAlbumList$12.L$2;
                        String str3 = (String) androidImageGallery$buildAlbumList$12.L$1;
                        ContentResolver contentResolver = (ContentResolver) androidImageGallery$buildAlbumList$12.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure($result);
                                query = $result;
                                cursor = (Cursor) query;
                                List<AndroidImage> addItem2 = addItem(cursor);
                                if (cursor != null) {
                                }
                                return addItem2;
                            } catch (Exception e3) {
                                e = e3;
                                GalleryLog.INSTANCE.e(TAG, "query error", e);
                                List emptyList2 = CollectionsKt.emptyList();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return emptyList2;
                            }
                        } catch (Throwable th3) {
                            e = th3;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw e;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        androidImageGallery$buildAlbumList$1 = new AndroidImageGallery$buildAlbumList$1(this, continuation);
        androidImageGallery$buildAlbumList$12 = androidImageGallery$buildAlbumList$1;
        Object $result2 = androidImageGallery$buildAlbumList$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (androidImageGallery$buildAlbumList$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AndroidImage> addItem(Cursor cursor) {
        int pathColumn;
        int bucketIdColumn;
        int bucketNameColumn;
        int idColumn;
        Resolution size;
        LinkedHashSet result = new LinkedHashSet(cursor != null ? cursor.getCount() : 16);
        if (cursor != null && cursor.moveToFirst()) {
            int pathColumn2 = cursor.getColumnIndex("_data");
            int bucketIdColumn2 = cursor.getColumnIndex("bucket_id");
            int bucketNameColumn2 = cursor.getColumnIndex("bucket_display_name");
            int idColumn2 = cursor.getColumnIndex("_id");
            int fileSizeColumn = cursor.getColumnIndex("_size");
            int mimeTypeColumn = cursor.getColumnIndex("mime_type");
            int dateColumn = cursor.getColumnIndex("date_modified");
            int cTimeColumn = cursor.getColumnIndex("date_added");
            int widthColumn = cursor.getColumnIndex("width");
            int heightColumn = cursor.getColumnIndex("height");
            int orientationColumn = cursor.getColumnIndex("orientation");
            while (true) {
                int index$iv = pathColumn2;
                String string = cursor.isNull(index$iv) ? null : cursor.getString(index$iv);
                if (string == null) {
                    string = "";
                }
                String picPath = string;
                if (picPath.length() == 0) {
                    pathColumn = pathColumn2;
                    bucketIdColumn = bucketIdColumn2;
                    bucketNameColumn = bucketNameColumn2;
                    idColumn = idColumn2;
                } else if (new File(picPath).exists()) {
                    int index$iv2 = bucketIdColumn2;
                    String string2 = cursor.isNull(index$iv2) ? null : cursor.getString(index$iv2);
                    String bucketId = string2 == null ? "" : string2;
                    int index$iv3 = bucketNameColumn2;
                    String string3 = cursor.isNull(index$iv3) ? null : cursor.getString(index$iv3);
                    String bucketName = string3 == null ? "" : string3;
                    int index$iv4 = idColumn2;
                    Long valueOf = cursor.isNull(index$iv4) ? null : Long.valueOf(cursor.getLong(index$iv4));
                    long id = valueOf != null ? valueOf.longValue() : -1L;
                    Long valueOf2 = cursor.isNull(fileSizeColumn) ? null : Long.valueOf(cursor.getLong(fileSizeColumn));
                    long fileSize = valueOf2 != null ? valueOf2.longValue() : -1L;
                    String string4 = cursor.isNull(mimeTypeColumn) ? null : cursor.getString(mimeTypeColumn);
                    String mimeType = string4 != null ? string4 : "";
                    Long valueOf3 = cursor.isNull(dateColumn) ? null : Long.valueOf(cursor.getLong(dateColumn));
                    long date = valueOf3 != null ? valueOf3.longValue() : -1L;
                    Long valueOf4 = cursor.isNull(cTimeColumn) ? null : Long.valueOf(cursor.getLong(cTimeColumn));
                    long cTime = valueOf4 != null ? valueOf4.longValue() : -1L;
                    Integer valueOf5 = cursor.isNull(widthColumn) ? null : Integer.valueOf(cursor.getInt(widthColumn));
                    int width = valueOf5 != null ? valueOf5.intValue() : -1;
                    pathColumn = pathColumn2;
                    Integer valueOf6 = cursor.isNull(heightColumn) ? null : Integer.valueOf(cursor.getInt(heightColumn));
                    int height = valueOf6 != null ? valueOf6.intValue() : -1;
                    bucketIdColumn = bucketIdColumn2;
                    Integer valueOf7 = cursor.isNull(orientationColumn) ? null : Integer.valueOf(cursor.getInt(orientationColumn));
                    int orientation = valueOf7 != null ? valueOf7.intValue() : 0;
                    if (width > 0 && height > 0) {
                        bucketNameColumn = bucketNameColumn2;
                        idColumn = idColumn2;
                        size = new Resolution(width, height);
                    } else {
                        bucketNameColumn = bucketNameColumn2;
                        GalleryLog.INSTANCE.w(TAG, "Failed to load size of file " + picPath + ", fallback to bitmap factory");
                        BitmapFactory.Options bitmapOption = new BitmapFactory.Options();
                        idColumn = idColumn2;
                        bitmapOption.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(picPath, bitmapOption);
                        size = new Resolution(bitmapOption.outWidth, bitmapOption.outHeight);
                    }
                    Uri uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
                    Intrinsics.checkNotNullExpressionValue(uri, "withAppendedId(...)");
                    AndroidImage imageItem = new AndroidImage(uri, picPath, ContentSizeKt.bytes(Long.valueOf(fileSize)), Instant.Companion.fromEpochSeconds$default(Instant.Companion, cTime, 0L, 2, (Object) null), Instant.Companion.fromEpochSeconds$default(Instant.Companion, date, 0L, 2, (Object) null), size, Orientation.Companion.fromDegree(orientation), MimeType.Companion.fromString(mimeType), new AndroidAlbumInfo(bucketName, bucketId, null, 4, null), null);
                    result.add(imageItem);
                } else {
                    pathColumn = pathColumn2;
                    bucketIdColumn = bucketIdColumn2;
                    bucketNameColumn = bucketNameColumn2;
                    idColumn = idColumn2;
                }
                if (cursor.isLast() || !cursor.moveToNext()) {
                    break;
                }
                bucketNameColumn2 = bucketNameColumn;
                pathColumn2 = pathColumn;
                bucketIdColumn2 = bucketIdColumn;
                idColumn2 = idColumn;
            }
        }
        return CollectionsKt.toList(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object query(ContentResolver cr, List<MimeType> list, String bucketId, String[] columns, boolean isDefaultAlbum, String imageMimeType, String[] args, String order, Pagination pagination, Continuation<? super Cursor> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AndroidImageGallery$query$2(isDefaultAlbum, cr, columns, imageMimeType, args, order, pagination, list, bucketId, null), continuation);
    }

    public final Object loadAssetWithContentUri(String uri, Continuation<? super AndroidImage> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AndroidImageGallery$loadAssetWithContentUri$2(uri, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] getColumns() {
        return new String[]{"_id", "bucket_id", "bucket_display_name", "_data", "_size", "mime_type", "width", "height", "date_modified", "date_added", "orientation"};
    }

    private final String[] getColumnBuckets() {
        return new String[]{"bucket_id", "bucket_display_name"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildQuerySelection$lambda$0(MimeType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "mime_type=?";
    }

    public final String buildQuerySelection(List<MimeType> list) {
        Intrinsics.checkNotNullParameter(list, "types");
        return CollectionsKt.joinToString$default(list, " or ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.common.photonic.gallery.internal.AndroidImageGallery$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence buildQuerySelection$lambda$0;
                buildQuerySelection$lambda$0 = AndroidImageGallery.buildQuerySelection$lambda$0((MimeType) obj);
                return buildQuerySelection$lambda$0;
            }
        }, 30, (Object) null);
    }

    public final List<String> buildQueryArgs(List<MimeType> list) {
        Intrinsics.checkNotNullParameter(list, "types");
        List<MimeType> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MimeType it = (MimeType) item$iv$iv;
            destination$iv$iv.add(it.toString());
        }
        return (List) destination$iv$iv;
    }

    public final String buildSelectionId(List<MimeType> list) {
        Intrinsics.checkNotNullParameter(list, "types");
        return "bucket_id=? and (" + buildQuerySelection(list) + " )";
    }
}