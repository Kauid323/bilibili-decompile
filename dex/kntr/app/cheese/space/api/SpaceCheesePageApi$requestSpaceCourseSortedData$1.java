package kntr.app.cheese.space.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpaceCheesePageApi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.cheese.space.api.SpaceCheesePageApi", f = "SpaceCheesePageApi.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {71, 72}, m = "requestSpaceCourseSortedData", n = {"classification_id", "sort_type", "$this$get$iv", "urlString$iv", "$completion$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "upId", "cond", "filter_type", "pn", "ps", "$i$f$handleApiException", "$i$a$-handleApiException-SpaceCheesePageApi$requestSpaceCourseSortedData$2", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "classification_id", "sort_type", "$this$body$iv", "$completion$iv", "upId", "cond", "filter_type", "pn", "ps", "$i$f$handleApiException", "$i$a$-handleApiException-SpaceCheesePageApi$requestSpaceCourseSortedData$2", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7", "I$8", "I$9", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6"}, v = 1)
public final class SpaceCheesePageApi$requestSpaceCourseSortedData$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    int I$6;
    int I$7;
    int I$8;
    int I$9;
    long J$0;
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
    final /* synthetic */ SpaceCheesePageApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceCheesePageApi$requestSpaceCourseSortedData$1(SpaceCheesePageApi spaceCheesePageApi, Continuation<? super SpaceCheesePageApi$requestSpaceCourseSortedData$1> continuation) {
        super(continuation);
        this.this$0 = spaceCheesePageApi;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.requestSpaceCourseSortedData(0L, null, 0, null, 0, 0, 0, (Continuation) this);
    }
}