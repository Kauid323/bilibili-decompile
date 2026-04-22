package kntr.common.photonic.gallery.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;

/* compiled from: QueryCompat.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/common/photonic/gallery/internal/QueryCompat;", "Lkntr/common/photonic/gallery/internal/IQueryCompat;", "<init>", "()V", "TAG", "", "query", "Landroid/database/Cursor;", "cr", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "page", "", "pageLimit", "(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toUri", "id", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class QueryCompat implements IQueryCompat {
    public static final int $stable = 0;
    public static final QueryCompat INSTANCE = new QueryCompat();
    public static final String TAG = "gallery-QueryCompat";

    private QueryCompat() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a2  */
    @Override // kntr.common.photonic.gallery.internal.IQueryCompat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object query(ContentResolver cr, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, Integer page, Integer pageLimit, Continuation<? super Cursor> continuation) {
        QueryCompat$query$1 queryCompat$query$1;
        QueryCompat$query$1 queryCompat$query$12;
        Uri uri2;
        String[] projection2;
        String selection2;
        String[] selectionArgs2;
        String sortOrder2;
        Integer page2;
        Integer pageLimit2;
        Throwable th;
        ContentResolver cr2;
        Object query;
        ContentResolver cr3;
        Uri uri3;
        String[] projection3;
        String selection3;
        String[] selectionArgs3;
        String sortOrder3;
        Integer page3;
        Integer pageLimit3;
        Object query2;
        if (continuation instanceof QueryCompat$query$1) {
            queryCompat$query$1 = (QueryCompat$query$1) continuation;
            if ((queryCompat$query$1.label & Integer.MIN_VALUE) != 0) {
                queryCompat$query$1.label -= Integer.MIN_VALUE;
                queryCompat$query$12 = queryCompat$query$1;
                Object $result = queryCompat$query$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (queryCompat$query$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (Build.VERSION.SDK_INT < 26) {
                            QueryCompatDefault queryCompatDefault = QueryCompatDefault.INSTANCE;
                            queryCompat$query$12.L$0 = SpillingKt.nullOutSpilledVariable(cr);
                            queryCompat$query$12.L$1 = SpillingKt.nullOutSpilledVariable(uri);
                            queryCompat$query$12.L$2 = SpillingKt.nullOutSpilledVariable(projection);
                            queryCompat$query$12.L$3 = SpillingKt.nullOutSpilledVariable(selection);
                            queryCompat$query$12.L$4 = SpillingKt.nullOutSpilledVariable(selectionArgs);
                            queryCompat$query$12.L$5 = SpillingKt.nullOutSpilledVariable(sortOrder);
                            queryCompat$query$12.L$6 = SpillingKt.nullOutSpilledVariable(page);
                            queryCompat$query$12.L$7 = SpillingKt.nullOutSpilledVariable(pageLimit);
                            queryCompat$query$12.label = 3;
                            Object query3 = queryCompatDefault.query(cr, uri, projection, selection, selectionArgs, sortOrder, page, pageLimit, queryCompat$query$12);
                            return query3 == coroutine_suspended ? coroutine_suspended : query3;
                        }
                        try {
                            QueryCompatApi26 queryCompatApi26 = QueryCompatApi26.INSTANCE;
                            queryCompat$query$12.L$0 = cr;
                            queryCompat$query$12.L$1 = uri;
                            queryCompat$query$12.L$2 = projection;
                            queryCompat$query$12.L$3 = selection;
                            queryCompat$query$12.L$4 = selectionArgs;
                            queryCompat$query$12.L$5 = sortOrder;
                            queryCompat$query$12.L$6 = page;
                            queryCompat$query$12.L$7 = pageLimit;
                            queryCompat$query$12.label = 1;
                            query = queryCompatApi26.query(cr, uri, projection, selection, selectionArgs, sortOrder, page, pageLimit, queryCompat$query$12);
                            if (query == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            cr3 = cr;
                            uri3 = uri;
                            projection3 = projection;
                            selection3 = selection;
                            selectionArgs3 = selectionArgs;
                            sortOrder3 = sortOrder;
                            page3 = page;
                            pageLimit3 = pageLimit;
                            return (Cursor) query;
                        } catch (Throwable th2) {
                            uri2 = uri;
                            projection2 = projection;
                            selection2 = selection;
                            selectionArgs2 = selectionArgs;
                            sortOrder2 = sortOrder;
                            page2 = page;
                            pageLimit2 = pageLimit;
                            th = th2;
                            cr2 = cr;
                            Throwable e = th;
                            GalleryLog.INSTANCE.e(TAG, "query error, downgrade it", e);
                            QueryCompatDefault queryCompatDefault2 = QueryCompatDefault.INSTANCE;
                            queryCompat$query$12.L$0 = SpillingKt.nullOutSpilledVariable(cr2);
                            queryCompat$query$12.L$1 = SpillingKt.nullOutSpilledVariable(uri2);
                            queryCompat$query$12.L$2 = SpillingKt.nullOutSpilledVariable(projection2);
                            queryCompat$query$12.L$3 = SpillingKt.nullOutSpilledVariable(selection2);
                            queryCompat$query$12.L$4 = SpillingKt.nullOutSpilledVariable(selectionArgs2);
                            queryCompat$query$12.L$5 = SpillingKt.nullOutSpilledVariable(sortOrder2);
                            queryCompat$query$12.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                            queryCompat$query$12.L$7 = SpillingKt.nullOutSpilledVariable(pageLimit2);
                            queryCompat$query$12.L$8 = SpillingKt.nullOutSpilledVariable(e);
                            queryCompat$query$12.label = 2;
                            query2 = queryCompatDefault2.query(cr2, uri2, projection2, selection2, selectionArgs2, sortOrder2, page2, pageLimit2, queryCompat$query$12);
                            if (query2 != coroutine_suspended) {
                            }
                        }
                        break;
                    case 1:
                        pageLimit3 = (Integer) queryCompat$query$12.L$7;
                        page3 = (Integer) queryCompat$query$12.L$6;
                        sortOrder3 = (String) queryCompat$query$12.L$5;
                        selectionArgs3 = (String[]) queryCompat$query$12.L$4;
                        selection3 = (String) queryCompat$query$12.L$3;
                        projection3 = (String[]) queryCompat$query$12.L$2;
                        uri3 = (Uri) queryCompat$query$12.L$1;
                        cr3 = (ContentResolver) queryCompat$query$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            query = $result;
                            return (Cursor) query;
                        } catch (Throwable th3) {
                            pageLimit2 = pageLimit3;
                            page2 = page3;
                            sortOrder2 = sortOrder3;
                            selectionArgs2 = selectionArgs3;
                            selection2 = selection3;
                            projection2 = projection3;
                            uri2 = uri3;
                            th = th3;
                            cr2 = cr3;
                            Throwable e2 = th;
                            GalleryLog.INSTANCE.e(TAG, "query error, downgrade it", e2);
                            QueryCompatDefault queryCompatDefault22 = QueryCompatDefault.INSTANCE;
                            queryCompat$query$12.L$0 = SpillingKt.nullOutSpilledVariable(cr2);
                            queryCompat$query$12.L$1 = SpillingKt.nullOutSpilledVariable(uri2);
                            queryCompat$query$12.L$2 = SpillingKt.nullOutSpilledVariable(projection2);
                            queryCompat$query$12.L$3 = SpillingKt.nullOutSpilledVariable(selection2);
                            queryCompat$query$12.L$4 = SpillingKt.nullOutSpilledVariable(selectionArgs2);
                            queryCompat$query$12.L$5 = SpillingKt.nullOutSpilledVariable(sortOrder2);
                            queryCompat$query$12.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                            queryCompat$query$12.L$7 = SpillingKt.nullOutSpilledVariable(pageLimit2);
                            queryCompat$query$12.L$8 = SpillingKt.nullOutSpilledVariable(e2);
                            queryCompat$query$12.label = 2;
                            query2 = queryCompatDefault22.query(cr2, uri2, projection2, selection2, selectionArgs2, sortOrder2, page2, pageLimit2, queryCompat$query$12);
                            return query2 != coroutine_suspended ? coroutine_suspended : (Cursor) query2;
                        }
                    case 2:
                        Throwable th4 = (Throwable) queryCompat$query$12.L$8;
                        Integer num = (Integer) queryCompat$query$12.L$6;
                        String str = (String) queryCompat$query$12.L$5;
                        String[] strArr = (String[]) queryCompat$query$12.L$4;
                        String str2 = (String) queryCompat$query$12.L$3;
                        String[] strArr2 = (String[]) queryCompat$query$12.L$2;
                        Uri uri4 = (Uri) queryCompat$query$12.L$1;
                        ContentResolver contentResolver = (ContentResolver) queryCompat$query$12.L$0;
                        ResultKt.throwOnFailure($result);
                        pageLimit2 = (Integer) queryCompat$query$12.L$7;
                        query2 = $result;
                    case 3:
                        Integer num2 = (Integer) queryCompat$query$12.L$7;
                        Integer num3 = (Integer) queryCompat$query$12.L$6;
                        String str3 = (String) queryCompat$query$12.L$5;
                        String[] strArr3 = (String[]) queryCompat$query$12.L$4;
                        String str4 = (String) queryCompat$query$12.L$3;
                        String[] strArr4 = (String[]) queryCompat$query$12.L$2;
                        Uri uri5 = (Uri) queryCompat$query$12.L$1;
                        ContentResolver contentResolver2 = (ContentResolver) queryCompat$query$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        queryCompat$query$1 = new QueryCompat$query$1(this, continuation);
        queryCompat$query$12 = queryCompat$query$1;
        Object $result2 = queryCompat$query$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (queryCompat$query$12.label) {
        }
    }

    @JvmStatic
    public static final Uri toUri(String id) {
        if (id == null) {
            return null;
        }
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(id).build();
    }
}