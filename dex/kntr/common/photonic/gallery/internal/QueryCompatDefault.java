package kntr.common.photonic.gallery.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: QueryCompat.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkntr/common/photonic/gallery/internal/QueryCompatDefault;", "Lkntr/common/photonic/gallery/internal/IQueryCompat;", "<init>", "()V", "query", "Landroid/database/Cursor;", "cr", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "page", "", "pageLimit", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class QueryCompatDefault implements IQueryCompat {
    public static final int $stable = 0;
    public static final QueryCompatDefault INSTANCE = new QueryCompatDefault();

    private QueryCompatDefault() {
    }

    @Override // kntr.common.photonic.gallery.internal.IQueryCompat
    public Object query(ContentResolver cr, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, Integer page, Integer pageLimit, Continuation<? super Cursor> continuation) {
        String sortOrderInner;
        if (cr != null) {
            if (page != null && pageLimit != null) {
                sortOrderInner = sortOrder + " LIMIT " + (page.intValue() * pageLimit.intValue()) + " , " + pageLimit;
            } else {
                sortOrderInner = sortOrder;
            }
            Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            Continuation continuation2 = (CancellableContinuation) cancellableContinuationImpl;
            final CancellationSignal cancellationSignal = new CancellationSignal();
            continuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kntr.common.photonic.gallery.internal.QueryCompatDefault$query$2$1$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((Throwable) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable it) {
                    cancellationSignal.cancel();
                }
            });
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m2636constructorimpl(cr.query(uri, projection, selection, selectionArgs, sortOrderInner, cancellationSignal)));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : (Cursor) result;
        }
        return null;
    }
}