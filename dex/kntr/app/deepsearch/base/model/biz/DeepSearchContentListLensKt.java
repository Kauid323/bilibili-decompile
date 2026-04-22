package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentList;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchContentListLens.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\",\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014\"D\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0014\"H\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0017\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0017\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u0010\u0010\u001d¨\u0006\u001e"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList$Companion;)Lcom/bilibili/blens/BSimpleLens;", "sessionEndModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "getSessionEndModel$annotations", "getSessionEndModel", "list", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "getList$annotations", "getList", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "sessionEndModelNullable$annotations", "sessionEndModelNullable", "Lcom/bilibili/blens/BNullableLens;", "listNullable$annotations", "listNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchContentListLensKt {
    public static /* synthetic */ void getLens$annotations(DeepSearchContentList.Companion companion) {
    }

    public static /* synthetic */ void getList$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getList$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getList$annotations(DeepSearchContentList.Companion companion) {
    }

    public static /* synthetic */ void getSessionEndModel$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionEndModel$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionEndModel$annotations(DeepSearchContentList.Companion companion) {
    }

    public static /* synthetic */ void listNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionEndModelNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchContentList, DeepSearchContentList> getLens(DeepSearchContentList.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchContentList, DeepSearchContentList>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchContentListLensKt$special$$inlined$invoke$1
            public DeepSearchContentList get(DeepSearchContentList deepSearchContentList) {
                DeepSearchContentList it = deepSearchContentList;
                return it;
            }

            public DeepSearchContentList set(DeepSearchContentList deepSearchContentList, DeepSearchContentList deepSearchContentList2) {
                DeepSearchContentList it = deepSearchContentList2;
                return it;
            }

            public DeepSearchContentList modify(DeepSearchContentList deepSearchContentList, Function1<? super DeepSearchContentList, ? extends DeepSearchContentList> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchContentList it = deepSearchContentList;
                return (DeepSearchContentList) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchContentList, DeepSearchSessionEndModel> getSessionEndModel(DeepSearchContentList.Companion $this$sessionEndModel) {
        Intrinsics.checkNotNullParameter($this$sessionEndModel, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchContentList, DeepSearchSessionEndModel>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchContentListLensKt$special$$inlined$invoke$2
            public DeepSearchSessionEndModel get(DeepSearchContentList deepSearchContentList) {
                DeepSearchContentList it = deepSearchContentList;
                return it.getSessionEndModel();
            }

            public DeepSearchContentList set(DeepSearchContentList deepSearchContentList, DeepSearchSessionEndModel deepSearchSessionEndModel) {
                DeepSearchSessionEndModel sessionEndModel = deepSearchSessionEndModel;
                DeepSearchContentList it = deepSearchContentList;
                return DeepSearchContentList.copy$default(it, sessionEndModel, null, 2, null);
            }

            public DeepSearchContentList modify(DeepSearchContentList deepSearchContentList, Function1<? super DeepSearchSessionEndModel, ? extends DeepSearchSessionEndModel> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchContentList it = deepSearchContentList;
                DeepSearchSessionEndModel sessionEndModel = (DeepSearchSessionEndModel) function1.invoke(it.getSessionEndModel());
                DeepSearchContentList it2 = deepSearchContentList;
                return DeepSearchContentList.copy$default(it2, sessionEndModel, null, 2, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchContentList, List<KChatHistoryItem>> getList(DeepSearchContentList.Companion $this$list) {
        Intrinsics.checkNotNullParameter($this$list, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchContentList, List<? extends KChatHistoryItem>>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchContentListLensKt$special$$inlined$invoke$3
            public List<? extends KChatHistoryItem> get(DeepSearchContentList deepSearchContentList) {
                DeepSearchContentList it = deepSearchContentList;
                return it.getList();
            }

            public DeepSearchContentList set(DeepSearchContentList deepSearchContentList, List<? extends KChatHistoryItem> list) {
                List<? extends KChatHistoryItem> list2 = list;
                DeepSearchContentList it = deepSearchContentList;
                return DeepSearchContentList.copy$default(it, null, list2, 1, null);
            }

            public DeepSearchContentList modify(DeepSearchContentList deepSearchContentList, Function1<? super List<? extends KChatHistoryItem>, ? extends List<? extends KChatHistoryItem>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchContentList it = deepSearchContentList;
                List list = (List) function1.invoke(it.getList());
                DeepSearchContentList it2 = deepSearchContentList;
                return DeepSearchContentList.copy$default(it2, null, list, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, DeepSearchSessionEndModel> getSessionEndModel(BSimpleLens<T, DeepSearchContentList> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getSessionEndModel(DeepSearchContentList.Companion));
    }

    public static final <T> BSimpleLens<T, List<KChatHistoryItem>> getList(BSimpleLens<T, DeepSearchContentList> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getList(DeepSearchContentList.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchSessionEndModel> sessionEndModelNullable(BSimpleLens<T, DeepSearchContentList> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getSessionEndModel(DeepSearchContentList.Companion));
    }

    public static final <T> BNullableLens<T, List<KChatHistoryItem>> listNullable(BSimpleLens<T, DeepSearchContentList> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getList(DeepSearchContentList.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchSessionEndModel> getSessionEndModel(BNullableLens<T, DeepSearchContentList> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getSessionEndModel(DeepSearchContentList.Companion));
    }

    public static final <T> BNullableLens<T, List<KChatHistoryItem>> getList(BNullableLens<T, DeepSearchContentList> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getList(DeepSearchContentList.Companion));
    }
}