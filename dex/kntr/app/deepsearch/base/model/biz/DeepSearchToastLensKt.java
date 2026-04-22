package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchToast;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchToastLens.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000e\u001a\u0004\b\u000b\u0010\u000f\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u0010\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015¨\u0006\u0016"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchToast;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchToast$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchToast$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchToast$Companion;)Lcom/bilibili/blens/BSimpleLens;", "content", RoomRecommendViewModel.EMPTY_CURSOR, "getContent$annotations", "getContent", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "contentNullable$annotations", "contentNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchToastLensKt {
    public static /* synthetic */ void contentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(DeepSearchToast.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(DeepSearchToast.Companion companion) {
    }

    public static final BSimpleLens<DeepSearchToast, DeepSearchToast> getLens(DeepSearchToast.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchToast, DeepSearchToast>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchToastLensKt$special$$inlined$invoke$1
            public DeepSearchToast get(DeepSearchToast deepSearchToast) {
                DeepSearchToast it = deepSearchToast;
                return it;
            }

            public DeepSearchToast set(DeepSearchToast deepSearchToast, DeepSearchToast deepSearchToast2) {
                DeepSearchToast it = deepSearchToast2;
                return it;
            }

            public DeepSearchToast modify(DeepSearchToast deepSearchToast, Function1<? super DeepSearchToast, ? extends DeepSearchToast> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchToast it = deepSearchToast;
                return (DeepSearchToast) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchToast, String> getContent(DeepSearchToast.Companion $this$content) {
        Intrinsics.checkNotNullParameter($this$content, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchToast, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchToastLensKt$special$$inlined$invoke$2
            public String get(DeepSearchToast deepSearchToast) {
                DeepSearchToast it = deepSearchToast;
                return it.getContent();
            }

            public DeepSearchToast set(DeepSearchToast deepSearchToast, String str) {
                String content = str;
                DeepSearchToast it = deepSearchToast;
                return DeepSearchToast.copy$default(it, content, 0L, 2, null);
            }

            public DeepSearchToast modify(DeepSearchToast deepSearchToast, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchToast it = deepSearchToast;
                String content = (String) function1.invoke(it.getContent());
                DeepSearchToast it2 = deepSearchToast;
                return DeepSearchToast.copy$default(it2, content, 0L, 2, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getContent(BSimpleLens<T, DeepSearchToast> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContent(DeepSearchToast.Companion));
    }

    public static final <T> BNullableLens<T, String> contentNullable(BSimpleLens<T, DeepSearchToast> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContent(DeepSearchToast.Companion));
    }

    public static final <T> BNullableLens<T, String> getContent(BNullableLens<T, DeepSearchToast> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContent(DeepSearchToast.Companion));
    }
}