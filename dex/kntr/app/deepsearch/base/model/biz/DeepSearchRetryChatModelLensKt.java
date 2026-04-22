package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchRetryChatModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchRetryChatModelLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0018\u001a\u0004\b\u000b\u0010\u0019\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0018\u001a\u0004\b\u000e\u0010\u0019\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00100\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00130\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0015\u0010\u0019\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\t0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001d\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\t0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001d\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00100\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001d\"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00130\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001d\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\t0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010$\u001a\u0004\b\u000b\u0010%\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\t0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010$\u001a\u0004\b\u000e\u0010%\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00100\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010$\u001a\u0004\b\u000f\u0010%\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00130\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010$\u001a\u0004\b\u0015\u0010%¨\u0006&"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel$Companion;)Lcom/bilibili/blens/BSimpleLens;", "query", RoomRecommendViewModel.EMPTY_CURSOR, "getQuery$annotations", "getQuery", "queryId", "getQueryId$annotations", "getQueryId", "isShowRetryBtn", RoomRecommendViewModel.EMPTY_CURSOR, "isShowRetryBtn$annotations", "likeType", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;", "getLikeType$annotations", "getLikeType", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "queryNullable$annotations", "queryNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "queryIdNullable$annotations", "queryIdNullable", "isShowRetryBtnNullable$annotations", "isShowRetryBtnNullable", "likeTypeNullable$annotations", "likeTypeNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchRetryChatModelLensKt {
    public static /* synthetic */ void getLens$annotations(DeepSearchRetryChatModel.Companion companion) {
    }

    public static /* synthetic */ void getLikeType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLikeType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLikeType$annotations(DeepSearchRetryChatModel.Companion companion) {
    }

    public static /* synthetic */ void getQuery$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQuery$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQuery$annotations(DeepSearchRetryChatModel.Companion companion) {
    }

    public static /* synthetic */ void getQueryId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(DeepSearchRetryChatModel.Companion companion) {
    }

    public static /* synthetic */ void isShowRetryBtn$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isShowRetryBtn$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isShowRetryBtn$annotations(DeepSearchRetryChatModel.Companion companion) {
    }

    public static /* synthetic */ void isShowRetryBtnNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void likeTypeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void queryIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void queryNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchRetryChatModel, DeepSearchRetryChatModel> getLens(DeepSearchRetryChatModel.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchRetryChatModel, DeepSearchRetryChatModel>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchRetryChatModelLensKt$special$$inlined$invoke$1
            public DeepSearchRetryChatModel get(DeepSearchRetryChatModel deepSearchRetryChatModel) {
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return it;
            }

            public DeepSearchRetryChatModel set(DeepSearchRetryChatModel deepSearchRetryChatModel, DeepSearchRetryChatModel deepSearchRetryChatModel2) {
                DeepSearchRetryChatModel it = deepSearchRetryChatModel2;
                return it;
            }

            public DeepSearchRetryChatModel modify(DeepSearchRetryChatModel deepSearchRetryChatModel, Function1<? super DeepSearchRetryChatModel, ? extends DeepSearchRetryChatModel> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return (DeepSearchRetryChatModel) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchRetryChatModel, String> getQuery(DeepSearchRetryChatModel.Companion $this$query) {
        Intrinsics.checkNotNullParameter($this$query, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchRetryChatModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchRetryChatModelLensKt$special$$inlined$invoke$2
            public String get(DeepSearchRetryChatModel deepSearchRetryChatModel) {
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return it.getQuery();
            }

            public DeepSearchRetryChatModel set(DeepSearchRetryChatModel deepSearchRetryChatModel, String str) {
                String query = str;
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return DeepSearchRetryChatModel.copy$default(it, query, null, false, null, 14, null);
            }

            public DeepSearchRetryChatModel modify(DeepSearchRetryChatModel deepSearchRetryChatModel, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                String query = (String) function1.invoke(it.getQuery());
                DeepSearchRetryChatModel it2 = deepSearchRetryChatModel;
                return DeepSearchRetryChatModel.copy$default(it2, query, null, false, null, 14, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchRetryChatModel, String> getQueryId(DeepSearchRetryChatModel.Companion $this$queryId) {
        Intrinsics.checkNotNullParameter($this$queryId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchRetryChatModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchRetryChatModelLensKt$special$$inlined$invoke$3
            public String get(DeepSearchRetryChatModel deepSearchRetryChatModel) {
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return it.getQueryId();
            }

            public DeepSearchRetryChatModel set(DeepSearchRetryChatModel deepSearchRetryChatModel, String str) {
                String queryId = str;
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return DeepSearchRetryChatModel.copy$default(it, null, queryId, false, null, 13, null);
            }

            public DeepSearchRetryChatModel modify(DeepSearchRetryChatModel deepSearchRetryChatModel, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                String queryId = (String) function1.invoke(it.getQueryId());
                DeepSearchRetryChatModel it2 = deepSearchRetryChatModel;
                return DeepSearchRetryChatModel.copy$default(it2, null, queryId, false, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchRetryChatModel, Boolean> isShowRetryBtn(DeepSearchRetryChatModel.Companion $this$isShowRetryBtn) {
        Intrinsics.checkNotNullParameter($this$isShowRetryBtn, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchRetryChatModel, Boolean>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchRetryChatModelLensKt$special$$inlined$invoke$4
            public Boolean get(DeepSearchRetryChatModel deepSearchRetryChatModel) {
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return Boolean.valueOf(it.isShowRetryBtn());
            }

            public DeepSearchRetryChatModel set(DeepSearchRetryChatModel deepSearchRetryChatModel, Boolean bool) {
                boolean isShowRetryBtn = bool.booleanValue();
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return DeepSearchRetryChatModel.copy$default(it, null, null, isShowRetryBtn, null, 11, null);
            }

            public DeepSearchRetryChatModel modify(DeepSearchRetryChatModel deepSearchRetryChatModel, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                boolean isShowRetryBtn = ((Boolean) function1.invoke(Boolean.valueOf(it.isShowRetryBtn()))).booleanValue();
                DeepSearchRetryChatModel it2 = deepSearchRetryChatModel;
                return DeepSearchRetryChatModel.copy$default(it2, null, null, isShowRetryBtn, null, 11, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchRetryChatModel, KLikeType> getLikeType(DeepSearchRetryChatModel.Companion $this$likeType) {
        Intrinsics.checkNotNullParameter($this$likeType, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchRetryChatModel, KLikeType>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchRetryChatModelLensKt$special$$inlined$invoke$5
            public KLikeType get(DeepSearchRetryChatModel deepSearchRetryChatModel) {
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return it.getLikeType();
            }

            public DeepSearchRetryChatModel set(DeepSearchRetryChatModel deepSearchRetryChatModel, KLikeType kLikeType) {
                KLikeType likeType = kLikeType;
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                return DeepSearchRetryChatModel.copy$default(it, null, null, false, likeType, 7, null);
            }

            public DeepSearchRetryChatModel modify(DeepSearchRetryChatModel deepSearchRetryChatModel, Function1<? super KLikeType, ? extends KLikeType> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchRetryChatModel it = deepSearchRetryChatModel;
                KLikeType likeType = (KLikeType) function1.invoke(it.getLikeType());
                DeepSearchRetryChatModel it2 = deepSearchRetryChatModel;
                return DeepSearchRetryChatModel.copy$default(it2, null, null, false, likeType, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getQuery(BSimpleLens<T, DeepSearchRetryChatModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getQuery(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getQueryId(BSimpleLens<T, DeepSearchRetryChatModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getQueryId(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isShowRetryBtn(BSimpleLens<T, DeepSearchRetryChatModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isShowRetryBtn(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BSimpleLens<T, KLikeType> getLikeType(BSimpleLens<T, DeepSearchRetryChatModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getLikeType(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BNullableLens<T, String> queryNullable(BSimpleLens<T, DeepSearchRetryChatModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getQuery(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BNullableLens<T, String> queryIdNullable(BSimpleLens<T, DeepSearchRetryChatModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getQueryId(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isShowRetryBtnNullable(BSimpleLens<T, DeepSearchRetryChatModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isShowRetryBtn(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BNullableLens<T, KLikeType> likeTypeNullable(BSimpleLens<T, DeepSearchRetryChatModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getLikeType(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getQuery(BNullableLens<T, DeepSearchRetryChatModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getQuery(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getQueryId(BNullableLens<T, DeepSearchRetryChatModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getQueryId(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isShowRetryBtn(BNullableLens<T, DeepSearchRetryChatModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isShowRetryBtn(DeepSearchRetryChatModel.Companion));
    }

    public static final <T> BNullableLens<T, KLikeType> getLikeType(BNullableLens<T, DeepSearchRetryChatModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getLikeType(DeepSearchRetryChatModel.Companion));
    }
}