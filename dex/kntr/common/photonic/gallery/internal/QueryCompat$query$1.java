package kntr.common.photonic.gallery.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueryCompat.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.internal.QueryCompat", f = "QueryCompat.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {34, 46, 58}, m = "query", n = {"cr", "uri", "projection", "selection", "selectionArgs", "sortOrder", "page", "pageLimit", "cr", "uri", "projection", "selection", "selectionArgs", "sortOrder", "page", "pageLimit", "e", "cr", "uri", "projection", "selection", "selectionArgs", "sortOrder", "page", "pageLimit"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 1)
public final class QueryCompat$query$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QueryCompat this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryCompat$query$1(QueryCompat queryCompat, Continuation<? super QueryCompat$query$1> continuation) {
        super(continuation);
        this.this$0 = queryCompat;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.query(null, null, null, null, null, null, null, null, (Continuation) this);
    }
}