package kntr.common.photonic.gallery.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.gallery.Pagination;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidImageGallery.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.internal.AndroidImageGallery$query$2", f = "AndroidImageGallery.kt", i = {1}, l = {153, 166}, m = "invokeSuspend", n = {"selectionId"}, s = {"L$0"}, v = 1)
public final class AndroidImageGallery$query$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Cursor>, Object> {
    final /* synthetic */ String[] $args;
    final /* synthetic */ String $bucketId;
    final /* synthetic */ String[] $columns;
    final /* synthetic */ ContentResolver $cr;
    final /* synthetic */ List<MimeType> $forType;
    final /* synthetic */ String $imageMimeType;
    final /* synthetic */ boolean $isDefaultAlbum;
    final /* synthetic */ String $order;
    final /* synthetic */ Pagination $pagination;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidImageGallery$query$2(boolean z, ContentResolver contentResolver, String[] strArr, String str, String[] strArr2, String str2, Pagination pagination, List<MimeType> list, String str3, Continuation<? super AndroidImageGallery$query$2> continuation) {
        super(2, continuation);
        this.$isDefaultAlbum = z;
        this.$cr = contentResolver;
        this.$columns = strArr;
        this.$imageMimeType = str;
        this.$args = strArr2;
        this.$order = str2;
        this.$pagination = pagination;
        this.$forType = list;
        this.$bucketId = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidImageGallery$query$2(this.$isDefaultAlbum, this.$cr, this.$columns, this.$imageMimeType, this.$args, this.$order, this.$pagination, this.$forType, this.$bucketId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Cursor> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object query;
        Object query2;
        Cursor cursor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                GalleryLog.INSTANCE.i("image", "start query image");
                if (this.$isDefaultAlbum) {
                    QueryCompat queryCompat = QueryCompat.INSTANCE;
                    ContentResolver contentResolver = this.$cr;
                    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    Intrinsics.checkNotNullExpressionValue(uri, "EXTERNAL_CONTENT_URI");
                    String[] strArr = this.$columns;
                    String str = this.$imageMimeType;
                    String[] strArr2 = this.$args;
                    String str2 = this.$order;
                    Pagination pagination = this.$pagination;
                    Integer boxInt = pagination != null ? Boxing.boxInt(pagination.getPage()) : null;
                    Pagination pagination2 = this.$pagination;
                    Integer boxInt2 = pagination2 != null ? Boxing.boxInt(pagination2.getPageSize()) : null;
                    this.label = 1;
                    query2 = queryCompat.query(contentResolver, uri, strArr, str, strArr2, str2, boxInt, boxInt2, (Continuation) this);
                    if (query2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cursor = (Cursor) query2;
                    Cursor resultCursor = cursor;
                    GalleryLog.INSTANCE.i("image", "query find count > " + (resultCursor == null ? Boxing.boxInt(resultCursor.getCount()) : ""));
                    return resultCursor;
                }
                String selectionId = AndroidImageGallery.INSTANCE.buildSelectionId(this.$forType);
                QueryCompat queryCompat2 = QueryCompat.INSTANCE;
                ContentResolver contentResolver2 = this.$cr;
                Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Intrinsics.checkNotNullExpressionValue(uri2, "EXTERNAL_CONTENT_URI");
                String[] strArr3 = this.$columns;
                String[] strArr4 = {this.$bucketId};
                Iterable $this$map$iv = this.$forType;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    MimeType it = (MimeType) item$iv$iv;
                    destination$iv$iv.add(it.toString());
                }
                Collection $this$toTypedArray$iv = (List) destination$iv$iv;
                String[] strArr5 = (String[]) ArraysKt.plus(strArr4, $this$toTypedArray$iv.toArray(new String[0]));
                String str3 = this.$order;
                Pagination pagination3 = this.$pagination;
                Integer boxInt3 = pagination3 != null ? Boxing.boxInt(pagination3.getPage()) : null;
                Pagination pagination4 = this.$pagination;
                Integer boxInt4 = pagination4 != null ? Boxing.boxInt(pagination4.getPageSize()) : null;
                this.L$0 = SpillingKt.nullOutSpilledVariable(selectionId);
                this.label = 2;
                query = queryCompat2.query(contentResolver2, uri2, strArr3, selectionId, strArr5, str3, boxInt3, boxInt4, (Continuation) this);
                if (query == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cursor = (Cursor) query;
                Cursor resultCursor2 = cursor;
                GalleryLog.INSTANCE.i("image", "query find count > " + (resultCursor2 == null ? Boxing.boxInt(resultCursor2.getCount()) : ""));
                return resultCursor2;
            case 1:
                ResultKt.throwOnFailure($result);
                query2 = $result;
                cursor = (Cursor) query2;
                Cursor resultCursor22 = cursor;
                GalleryLog.INSTANCE.i("image", "query find count > " + (resultCursor22 == null ? Boxing.boxInt(resultCursor22.getCount()) : ""));
                return resultCursor22;
            case 2:
                String str4 = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                query = $result;
                cursor = (Cursor) query;
                Cursor resultCursor222 = cursor;
                GalleryLog.INSTANCE.i("image", "query find count > " + (resultCursor222 == null ? Boxing.boxInt(resultCursor222.getCount()) : ""));
                return resultCursor222;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}