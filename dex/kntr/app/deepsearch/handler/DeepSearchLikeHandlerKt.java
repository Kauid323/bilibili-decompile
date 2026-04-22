package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.app.search.deepsearch.v1.KDeepSearchMoss;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeStateReq;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.ArrayList;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.RequestParam;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchLikeHandler.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0007\u001a\u001e\u0010\b\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0000\u001a$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, d2 = {"reqLikeState", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "likeType", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindLikeAction", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "likeSuccessUpdateList", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "list", "likeParam", "Lkntr/app/deepsearch/base/model/biz/RequestParam$LikeReqParam;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchLikeHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object reqLikeState(String sessionId, String queryId, KLikeType likeType, Continuation<? super Unit> continuation) {
        KLikeStateReq req = new KLikeStateReq(likeType, sessionId, queryId);
        Object likeState = new KDeepSearchMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).likeState(req, continuation);
        return likeState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? likeState : Unit.INSTANCE;
    }

    public static final void bindLikeAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindLikeAction$lambda$0;
                bindLikeAction$lambda$0 = DeepSearchLikeHandlerKt.bindLikeAction$lambda$0((DeepSearchPageData) obj);
                return Boolean.valueOf(bindLikeAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindLikeAction$lambda$1;
                bindLikeAction$lambda$1 = DeepSearchLikeHandlerKt.bindLikeAction$lambda$1((ConditionBuilderBlock) obj);
                return bindLikeAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindLikeAction$lambda$2;
                bindLikeAction$lambda$2 = DeepSearchLikeHandlerKt.bindLikeAction$lambda$2((DeepSearchPageData) obj);
                return Boolean.valueOf(bindLikeAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchLikeHandlerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindLikeAction$lambda$3;
                bindLikeAction$lambda$3 = DeepSearchLikeHandlerKt.bindLikeAction$lambda$3((ConditionBuilderBlock) obj);
                return bindLikeAction$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindLikeAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getRequestModel().getLikeReqState().getStatus() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLikeAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeepSearchLikeHandlerKt$bindLikeAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.LikeAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindLikeAction$lambda$2(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getLikeReqState().getStatus() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLikeAction$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DeepSearchLikeHandlerKt$bindLikeAction$4$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KChatHistoryItem> likeSuccessUpdateList(List<KChatHistoryItem> list, RequestParam.LikeReqParam likeParam) {
        List tempList = new ArrayList();
        List<KChatHistoryItem> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            KChatHistoryItem item = (KChatHistoryItem) element$iv;
            KDeepSearchResponse response = item.getContent();
            if (response != null) {
                if (Intrinsics.areEqual(response.getQueryId(), likeParam.getQueryId())) {
                    KChatHistoryItem tempItem = new KChatHistoryItem(item.getQuery(), response, likeParam.getLikeType());
                    tempList.add(tempItem);
                } else {
                    tempList.add(item);
                }
            }
        }
        return tempList;
    }
}