package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchTreadPopModelLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0019\u001a\u0004\b\u000b\u0010\u001a\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u000f\u0010\u001a\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0016\u0010\u001a\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\t0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001e\"H\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001e\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00110\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001e\"B\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\t0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001e\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\t0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010%\u001a\u0004\b\u000b\u0010&\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010%\u001a\u0004\b\u000f\u0010&\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00110\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010%\u001a\u0004\b\u0013\u0010&\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\t0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010%\u001a\u0004\b\u0016\u0010&¨\u0006'"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel$Companion;)Lcom/bilibili/blens/BSimpleLens;", "title", RoomRecommendViewModel.EMPTY_CURSOR, "getTitle$annotations", "getTitle", "reasons", RoomRecommendViewModel.EMPTY_CURSOR, "getReasons$annotations", "getReasons", "maxCountWords", RoomRecommendViewModel.EMPTY_CURSOR, "getMaxCountWords$annotations", "getMaxCountWords", "inputPlaceholder", "getInputPlaceholder$annotations", "getInputPlaceholder", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "titleNullable$annotations", "titleNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "reasonsNullable$annotations", "reasonsNullable", "maxCountWordsNullable$annotations", "maxCountWordsNullable", "inputPlaceholderNullable$annotations", "inputPlaceholderNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTreadPopModelLensKt {
    public static /* synthetic */ void getInputPlaceholder$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInputPlaceholder$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInputPlaceholder$annotations(DeepSearchTreadPopModel.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(DeepSearchTreadPopModel.Companion companion) {
    }

    public static /* synthetic */ void getMaxCountWords$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMaxCountWords$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMaxCountWords$annotations(DeepSearchTreadPopModel.Companion companion) {
    }

    public static /* synthetic */ void getReasons$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getReasons$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getReasons$annotations(DeepSearchTreadPopModel.Companion companion) {
    }

    public static /* synthetic */ void getTitle$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTitle$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTitle$annotations(DeepSearchTreadPopModel.Companion companion) {
    }

    public static /* synthetic */ void inputPlaceholderNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void maxCountWordsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void reasonsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void titleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchTreadPopModel, DeepSearchTreadPopModel> getLens(DeepSearchTreadPopModel.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchTreadPopModel, DeepSearchTreadPopModel>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopModelLensKt$special$$inlined$invoke$1
            public DeepSearchTreadPopModel get(DeepSearchTreadPopModel deepSearchTreadPopModel) {
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return it;
            }

            public DeepSearchTreadPopModel set(DeepSearchTreadPopModel deepSearchTreadPopModel, DeepSearchTreadPopModel deepSearchTreadPopModel2) {
                DeepSearchTreadPopModel it = deepSearchTreadPopModel2;
                return it;
            }

            public DeepSearchTreadPopModel modify(DeepSearchTreadPopModel deepSearchTreadPopModel, Function1<? super DeepSearchTreadPopModel, ? extends DeepSearchTreadPopModel> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return (DeepSearchTreadPopModel) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchTreadPopModel, String> getTitle(DeepSearchTreadPopModel.Companion $this$title) {
        Intrinsics.checkNotNullParameter($this$title, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchTreadPopModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopModelLensKt$special$$inlined$invoke$2
            public String get(DeepSearchTreadPopModel deepSearchTreadPopModel) {
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return it.getTitle();
            }

            public DeepSearchTreadPopModel set(DeepSearchTreadPopModel deepSearchTreadPopModel, String str) {
                String title = str;
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return DeepSearchTreadPopModel.copy$default(it, title, null, 0, null, 14, null);
            }

            public DeepSearchTreadPopModel modify(DeepSearchTreadPopModel deepSearchTreadPopModel, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                String title = (String) function1.invoke(it.getTitle());
                DeepSearchTreadPopModel it2 = deepSearchTreadPopModel;
                return DeepSearchTreadPopModel.copy$default(it2, title, null, 0, null, 14, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<DeepSearchTreadPopModel, List<String>> getReasons(DeepSearchTreadPopModel.Companion $this$reasons) {
        Intrinsics.checkNotNullParameter($this$reasons, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchTreadPopModel, List<? extends String>>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopModelLensKt$special$$inlined$invoke$3
            public List<? extends String> get(DeepSearchTreadPopModel deepSearchTreadPopModel) {
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return it.getReasons();
            }

            public DeepSearchTreadPopModel set(DeepSearchTreadPopModel deepSearchTreadPopModel, List<? extends String> list) {
                List<? extends String> reasons = list;
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return DeepSearchTreadPopModel.copy$default(it, null, reasons, 0, null, 13, null);
            }

            public DeepSearchTreadPopModel modify(DeepSearchTreadPopModel deepSearchTreadPopModel, Function1<? super List<? extends String>, ? extends List<? extends String>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                List reasons = (List) function1.invoke(it.getReasons());
                DeepSearchTreadPopModel it2 = deepSearchTreadPopModel;
                return DeepSearchTreadPopModel.copy$default(it2, null, reasons, 0, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchTreadPopModel, Integer> getMaxCountWords(DeepSearchTreadPopModel.Companion $this$maxCountWords) {
        Intrinsics.checkNotNullParameter($this$maxCountWords, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchTreadPopModel, Integer>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopModelLensKt$special$$inlined$invoke$4
            public Integer get(DeepSearchTreadPopModel deepSearchTreadPopModel) {
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return Integer.valueOf(it.getMaxCountWords());
            }

            public DeepSearchTreadPopModel set(DeepSearchTreadPopModel deepSearchTreadPopModel, Integer num) {
                int maxCountWords = num.intValue();
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return DeepSearchTreadPopModel.copy$default(it, null, null, maxCountWords, null, 11, null);
            }

            public DeepSearchTreadPopModel modify(DeepSearchTreadPopModel deepSearchTreadPopModel, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                int maxCountWords = ((Number) function1.invoke(Integer.valueOf(it.getMaxCountWords()))).intValue();
                DeepSearchTreadPopModel it2 = deepSearchTreadPopModel;
                return DeepSearchTreadPopModel.copy$default(it2, null, null, maxCountWords, null, 11, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchTreadPopModel, String> getInputPlaceholder(DeepSearchTreadPopModel.Companion $this$inputPlaceholder) {
        Intrinsics.checkNotNullParameter($this$inputPlaceholder, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchTreadPopModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopModelLensKt$special$$inlined$invoke$5
            public String get(DeepSearchTreadPopModel deepSearchTreadPopModel) {
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return it.getInputPlaceholder();
            }

            public DeepSearchTreadPopModel set(DeepSearchTreadPopModel deepSearchTreadPopModel, String str) {
                String inputPlaceholder = str;
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                return DeepSearchTreadPopModel.copy$default(it, null, null, 0, inputPlaceholder, 7, null);
            }

            public DeepSearchTreadPopModel modify(DeepSearchTreadPopModel deepSearchTreadPopModel, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchTreadPopModel it = deepSearchTreadPopModel;
                String inputPlaceholder = (String) function1.invoke(it.getInputPlaceholder());
                DeepSearchTreadPopModel it2 = deepSearchTreadPopModel;
                return DeepSearchTreadPopModel.copy$default(it2, null, null, 0, inputPlaceholder, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getTitle(BSimpleLens<T, DeepSearchTreadPopModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTitle(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BSimpleLens<T, List<String>> getReasons(BSimpleLens<T, DeepSearchTreadPopModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getReasons(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getMaxCountWords(BSimpleLens<T, DeepSearchTreadPopModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMaxCountWords(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getInputPlaceholder(BSimpleLens<T, DeepSearchTreadPopModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getInputPlaceholder(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BNullableLens<T, String> titleNullable(BSimpleLens<T, DeepSearchTreadPopModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTitle(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BNullableLens<T, List<String>> reasonsNullable(BSimpleLens<T, DeepSearchTreadPopModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getReasons(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BNullableLens<T, Integer> maxCountWordsNullable(BSimpleLens<T, DeepSearchTreadPopModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMaxCountWords(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BNullableLens<T, String> inputPlaceholderNullable(BSimpleLens<T, DeepSearchTreadPopModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getInputPlaceholder(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getTitle(BNullableLens<T, DeepSearchTreadPopModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTitle(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BNullableLens<T, List<String>> getReasons(BNullableLens<T, DeepSearchTreadPopModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getReasons(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getMaxCountWords(BNullableLens<T, DeepSearchTreadPopModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMaxCountWords(DeepSearchTreadPopModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getInputPlaceholder(BNullableLens<T, DeepSearchTreadPopModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getInputPlaceholder(DeepSearchTreadPopModel.Companion));
    }
}