package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchTreadPopContentLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\",\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017\"D\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0013\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001c¨\u0006\u001d"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "getQueryId$annotations", "getQueryId", "treadModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel;", "getTreadModel$annotations", "getTreadModel", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "queryIdNullable$annotations", "queryIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "treadModelNullable$annotations", "treadModelNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTreadPopContentLensKt {
    public static /* synthetic */ void getLens$annotations(DeepSearchTreadPopContent.Companion companion) {
    }

    public static /* synthetic */ void getQueryId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(DeepSearchTreadPopContent.Companion companion) {
    }

    public static /* synthetic */ void getTreadModel$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTreadModel$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTreadModel$annotations(DeepSearchTreadPopContent.Companion companion) {
    }

    public static /* synthetic */ void queryIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void treadModelNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchTreadPopContent, DeepSearchTreadPopContent> getLens(DeepSearchTreadPopContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchTreadPopContent, DeepSearchTreadPopContent>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopContentLensKt$special$$inlined$invoke$1
            public DeepSearchTreadPopContent get(DeepSearchTreadPopContent deepSearchTreadPopContent) {
                DeepSearchTreadPopContent it = deepSearchTreadPopContent;
                return it;
            }

            public DeepSearchTreadPopContent set(DeepSearchTreadPopContent deepSearchTreadPopContent, DeepSearchTreadPopContent deepSearchTreadPopContent2) {
                DeepSearchTreadPopContent it = deepSearchTreadPopContent2;
                return it;
            }

            public DeepSearchTreadPopContent modify(DeepSearchTreadPopContent deepSearchTreadPopContent, Function1<? super DeepSearchTreadPopContent, ? extends DeepSearchTreadPopContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchTreadPopContent it = deepSearchTreadPopContent;
                return (DeepSearchTreadPopContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchTreadPopContent, String> getQueryId(DeepSearchTreadPopContent.Companion $this$queryId) {
        Intrinsics.checkNotNullParameter($this$queryId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchTreadPopContent, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopContentLensKt$special$$inlined$invoke$2
            public String get(DeepSearchTreadPopContent deepSearchTreadPopContent) {
                DeepSearchTreadPopContent it = deepSearchTreadPopContent;
                return it.getQueryId();
            }

            public DeepSearchTreadPopContent set(DeepSearchTreadPopContent deepSearchTreadPopContent, String str) {
                String queryId = str;
                DeepSearchTreadPopContent it = deepSearchTreadPopContent;
                return DeepSearchTreadPopContent.copy$default(it, queryId, null, 2, null);
            }

            public DeepSearchTreadPopContent modify(DeepSearchTreadPopContent deepSearchTreadPopContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchTreadPopContent it = deepSearchTreadPopContent;
                String queryId = (String) function1.invoke(it.getQueryId());
                DeepSearchTreadPopContent it2 = deepSearchTreadPopContent;
                return DeepSearchTreadPopContent.copy$default(it2, queryId, null, 2, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchTreadPopContent, DeepSearchTreadPopModel> getTreadModel(DeepSearchTreadPopContent.Companion $this$treadModel) {
        Intrinsics.checkNotNullParameter($this$treadModel, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchTreadPopContent, DeepSearchTreadPopModel>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopContentLensKt$special$$inlined$invoke$3
            public DeepSearchTreadPopModel get(DeepSearchTreadPopContent deepSearchTreadPopContent) {
                DeepSearchTreadPopContent it = deepSearchTreadPopContent;
                return it.getTreadModel();
            }

            public DeepSearchTreadPopContent set(DeepSearchTreadPopContent deepSearchTreadPopContent, DeepSearchTreadPopModel deepSearchTreadPopModel) {
                DeepSearchTreadPopModel treadModel = deepSearchTreadPopModel;
                DeepSearchTreadPopContent it = deepSearchTreadPopContent;
                return DeepSearchTreadPopContent.copy$default(it, null, treadModel, 1, null);
            }

            public DeepSearchTreadPopContent modify(DeepSearchTreadPopContent deepSearchTreadPopContent, Function1<? super DeepSearchTreadPopModel, ? extends DeepSearchTreadPopModel> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchTreadPopContent it = deepSearchTreadPopContent;
                DeepSearchTreadPopModel treadModel = (DeepSearchTreadPopModel) function1.invoke(it.getTreadModel());
                DeepSearchTreadPopContent it2 = deepSearchTreadPopContent;
                return DeepSearchTreadPopContent.copy$default(it2, null, treadModel, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getQueryId(BSimpleLens<T, DeepSearchTreadPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getQueryId(DeepSearchTreadPopContent.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchTreadPopModel> getTreadModel(BSimpleLens<T, DeepSearchTreadPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getTreadModel(DeepSearchTreadPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> queryIdNullable(BSimpleLens<T, DeepSearchTreadPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getQueryId(DeepSearchTreadPopContent.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchTreadPopModel> treadModelNullable(BSimpleLens<T, DeepSearchTreadPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getTreadModel(DeepSearchTreadPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getQueryId(BNullableLens<T, DeepSearchTreadPopContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getQueryId(DeepSearchTreadPopContent.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchTreadPopModel> getTreadModel(BNullableLens<T, DeepSearchTreadPopContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getTreadModel(DeepSearchTreadPopContent.Companion));
    }
}