package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchCopyModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchCopyModelLens.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000e\u001a\u0004\b\u000b\u0010\u000f\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u0010\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015¨\u0006\u0016"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchCopyModel;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchCopyModel$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchCopyModel$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchCopyModel$Companion;)Lcom/bilibili/blens/BSimpleLens;", "content", RoomRecommendViewModel.EMPTY_CURSOR, "getContent$annotations", "getContent", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "contentNullable$annotations", "contentNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchCopyModelLensKt {
    public static /* synthetic */ void contentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(DeepSearchCopyModel.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(DeepSearchCopyModel.Companion companion) {
    }

    public static final BSimpleLens<DeepSearchCopyModel, DeepSearchCopyModel> getLens(DeepSearchCopyModel.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchCopyModel, DeepSearchCopyModel>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchCopyModelLensKt$special$$inlined$invoke$1
            public DeepSearchCopyModel get(DeepSearchCopyModel deepSearchCopyModel) {
                DeepSearchCopyModel it = deepSearchCopyModel;
                return it;
            }

            public DeepSearchCopyModel set(DeepSearchCopyModel deepSearchCopyModel, DeepSearchCopyModel deepSearchCopyModel2) {
                DeepSearchCopyModel it = deepSearchCopyModel2;
                return it;
            }

            public DeepSearchCopyModel modify(DeepSearchCopyModel deepSearchCopyModel, Function1<? super DeepSearchCopyModel, ? extends DeepSearchCopyModel> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchCopyModel it = deepSearchCopyModel;
                return (DeepSearchCopyModel) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchCopyModel, String> getContent(DeepSearchCopyModel.Companion $this$content) {
        Intrinsics.checkNotNullParameter($this$content, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchCopyModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchCopyModelLensKt$special$$inlined$invoke$2
            public String get(DeepSearchCopyModel deepSearchCopyModel) {
                DeepSearchCopyModel it = deepSearchCopyModel;
                return it.getContent();
            }

            public DeepSearchCopyModel set(DeepSearchCopyModel deepSearchCopyModel, String str) {
                String content = str;
                DeepSearchCopyModel it = deepSearchCopyModel;
                return DeepSearchCopyModel.copy$default(it, content, 0L, 2, null);
            }

            public DeepSearchCopyModel modify(DeepSearchCopyModel deepSearchCopyModel, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchCopyModel it = deepSearchCopyModel;
                String content = (String) function1.invoke(it.getContent());
                DeepSearchCopyModel it2 = deepSearchCopyModel;
                return DeepSearchCopyModel.copy$default(it2, content, 0L, 2, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getContent(BSimpleLens<T, DeepSearchCopyModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContent(DeepSearchCopyModel.Companion));
    }

    public static final <T> BNullableLens<T, String> contentNullable(BSimpleLens<T, DeepSearchCopyModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContent(DeepSearchCopyModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getContent(BNullableLens<T, DeepSearchCopyModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContent(DeepSearchCopyModel.Companion));
    }
}