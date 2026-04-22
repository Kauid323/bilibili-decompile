package kntr.common.photonic.gallery.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.gallery.entity.AndroidImage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidImageGallery.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/common/photonic/gallery/entity/AndroidImage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.internal.AndroidImageGallery$loadAssetWithContentUri$2", f = "AndroidImageGallery.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AndroidImageGallery$loadAssetWithContentUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AndroidImage>, Object> {
    final /* synthetic */ String $uri;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidImageGallery$loadAssetWithContentUri$2(String str, Continuation<? super AndroidImageGallery$loadAssetWithContentUri$2> continuation) {
        super(2, continuation);
        this.$uri = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidImageGallery$loadAssetWithContentUri$2(this.$uri, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AndroidImage> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Context context;
        String[] columns;
        Object query;
        List addItem;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                GalleryLog.INSTANCE.i("image", "loadAssetWithContentUri: " + this.$uri);
                QueryCompat queryCompat = QueryCompat.INSTANCE;
                context = AndroidImageGallery.INSTANCE.getContext();
                ContentResolver contentResolver = context.getContentResolver();
                String $this$toUri$iv = this.$uri;
                Uri parse = Uri.parse($this$toUri$iv);
                columns = AndroidImageGallery.INSTANCE.getColumns();
                this.label = 1;
                query = queryCompat.query(contentResolver, parse, columns, null, null, null, null, null, (Continuation) this);
                if (query == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                query = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Cursor cursor = (Cursor) query;
        addItem = AndroidImageGallery.INSTANCE.addItem(cursor);
        return CollectionsKt.singleOrNull(addItem);
    }
}