package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchBubbleContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchBubbleContentLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b¨\u0006\u001c"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchBubbleContent;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchBubbleContent$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchBubbleContent$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchBubbleContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "idModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "getIdModel$annotations", "getIdModel", "rangeString", RoomRecommendViewModel.EMPTY_CURSOR, "getRangeString$annotations", "getRangeString", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "idModelNullable$annotations", "idModelNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "rangeStringNullable$annotations", "rangeStringNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchBubbleContentLensKt {
    public static /* synthetic */ void getIdModel$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getIdModel$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getIdModel$annotations(DeepSearchBubbleContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(DeepSearchBubbleContent.Companion companion) {
    }

    public static /* synthetic */ void getRangeString$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRangeString$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRangeString$annotations(DeepSearchBubbleContent.Companion companion) {
    }

    public static /* synthetic */ void idModelNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void rangeStringNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchBubbleContent, DeepSearchBubbleContent> getLens(DeepSearchBubbleContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchBubbleContent, DeepSearchBubbleContent>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchBubbleContentLensKt$special$$inlined$invoke$1
            public DeepSearchBubbleContent get(DeepSearchBubbleContent deepSearchBubbleContent) {
                DeepSearchBubbleContent it = deepSearchBubbleContent;
                return it;
            }

            public DeepSearchBubbleContent set(DeepSearchBubbleContent deepSearchBubbleContent, DeepSearchBubbleContent deepSearchBubbleContent2) {
                DeepSearchBubbleContent it = deepSearchBubbleContent2;
                return it;
            }

            public DeepSearchBubbleContent modify(DeepSearchBubbleContent deepSearchBubbleContent, Function1<? super DeepSearchBubbleContent, ? extends DeepSearchBubbleContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchBubbleContent it = deepSearchBubbleContent;
                return (DeepSearchBubbleContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchBubbleContent, DeepSearchDataItemIdentifier> getIdModel(DeepSearchBubbleContent.Companion $this$idModel) {
        Intrinsics.checkNotNullParameter($this$idModel, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchBubbleContent, DeepSearchDataItemIdentifier>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchBubbleContentLensKt$special$$inlined$invoke$2
            public DeepSearchDataItemIdentifier get(DeepSearchBubbleContent deepSearchBubbleContent) {
                DeepSearchBubbleContent it = deepSearchBubbleContent;
                return it.getIdModel();
            }

            public DeepSearchBubbleContent set(DeepSearchBubbleContent deepSearchBubbleContent, DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier idModel = deepSearchDataItemIdentifier;
                DeepSearchBubbleContent it = deepSearchBubbleContent;
                return DeepSearchBubbleContent.copy$default(it, idModel, null, 2, null);
            }

            public DeepSearchBubbleContent modify(DeepSearchBubbleContent deepSearchBubbleContent, Function1<? super DeepSearchDataItemIdentifier, ? extends DeepSearchDataItemIdentifier> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchBubbleContent it = deepSearchBubbleContent;
                DeepSearchDataItemIdentifier idModel = (DeepSearchDataItemIdentifier) function1.invoke(it.getIdModel());
                DeepSearchBubbleContent it2 = deepSearchBubbleContent;
                return DeepSearchBubbleContent.copy$default(it2, idModel, null, 2, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchBubbleContent, String> getRangeString(DeepSearchBubbleContent.Companion $this$rangeString) {
        Intrinsics.checkNotNullParameter($this$rangeString, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchBubbleContent, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchBubbleContentLensKt$special$$inlined$invoke$3
            public String get(DeepSearchBubbleContent deepSearchBubbleContent) {
                DeepSearchBubbleContent it = deepSearchBubbleContent;
                return it.getRangeString();
            }

            public DeepSearchBubbleContent set(DeepSearchBubbleContent deepSearchBubbleContent, String str) {
                String rangeString = str;
                DeepSearchBubbleContent it = deepSearchBubbleContent;
                return DeepSearchBubbleContent.copy$default(it, null, rangeString, 1, null);
            }

            public DeepSearchBubbleContent modify(DeepSearchBubbleContent deepSearchBubbleContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchBubbleContent it = deepSearchBubbleContent;
                String rangeString = (String) function1.invoke(it.getRangeString());
                DeepSearchBubbleContent it2 = deepSearchBubbleContent;
                return DeepSearchBubbleContent.copy$default(it2, null, rangeString, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, DeepSearchDataItemIdentifier> getIdModel(BSimpleLens<T, DeepSearchBubbleContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getIdModel(DeepSearchBubbleContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> getRangeString(BSimpleLens<T, DeepSearchBubbleContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRangeString(DeepSearchBubbleContent.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchDataItemIdentifier> idModelNullable(BSimpleLens<T, DeepSearchBubbleContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getIdModel(DeepSearchBubbleContent.Companion));
    }

    public static final <T> BNullableLens<T, String> rangeStringNullable(BSimpleLens<T, DeepSearchBubbleContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRangeString(DeepSearchBubbleContent.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchDataItemIdentifier> getIdModel(BNullableLens<T, DeepSearchBubbleContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getIdModel(DeepSearchBubbleContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getRangeString(BNullableLens<T, DeepSearchBubbleContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRangeString(DeepSearchBubbleContent.Companion));
    }
}