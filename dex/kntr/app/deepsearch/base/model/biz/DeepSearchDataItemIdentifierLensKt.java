package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifier;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchDataItemIdentifierLens.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007\"*\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007\"*\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\"*\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010&\u001a\u0004\b\u000b\u0010'\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010&\u001a\u0004\b\u000e\u0010'\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010&\u001a\u0004\b\u0011\u0010'\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00130\u0001\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010&\u001a\u0004\b\u0015\u0010'\"@\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00170\u0001\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010&\u001a\u0004\b\u0019\u0010'\"@\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u001b0\u0001\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010&\u001a\u0004\b\u001d\u0010'\"@\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u001b0\u0001\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010&\u001a\u0004\b \u0010'\"@\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u001b0\u0001\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010&\u001a\u0004\b#\u0010'\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\t0(\"\b\b\u0000\u0010$*\u00020%*\u0010\u0012\u0004\u0012\u0002H$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010&\u001a\u0004\b*\u0010+\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\t0(\"\b\b\u0000\u0010$*\u00020%*\u0010\u0012\u0004\u0012\u0002H$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010&\u001a\u0004\b-\u0010+\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\t0(\"\b\b\u0000\u0010$*\u00020%*\u0010\u0012\u0004\u0012\u0002H$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010&\u001a\u0004\b/\u0010+\"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00130(\"\b\b\u0000\u0010$*\u00020%*\u0010\u0012\u0004\u0012\u0002H$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010&\u001a\u0004\b1\u0010+\"B\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00170(\"\b\b\u0000\u0010$*\u00020%*\u0010\u0012\u0004\u0012\u0002H$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010&\u001a\u0004\b3\u0010+\"B\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u001b0(\"\b\b\u0000\u0010$*\u00020%*\u0010\u0012\u0004\u0012\u0002H$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010&\u001a\u0004\b5\u0010+\"B\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u001b0(\"\b\b\u0000\u0010$*\u00020%*\u0010\u0012\u0004\u0012\u0002H$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010&\u001a\u0004\b7\u0010+\"B\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u001b0(\"\b\b\u0000\u0010$*\u00020%*\u0010\u0012\u0004\u0012\u0002H$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010&\u001a\u0004\b9\u0010+\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\t0(\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020(8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010:\u001a\u0004\b\u000b\u0010;\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\t0(\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020(8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010:\u001a\u0004\b\u000e\u0010;\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\t0(\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020(8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010:\u001a\u0004\b\u0011\u0010;\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00130(\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020(8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010:\u001a\u0004\b\u0015\u0010;\"@\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00170(\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020(8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010:\u001a\u0004\b\u0019\u0010;\"@\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u001b0(\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020(8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010:\u001a\u0004\b\u001d\u0010;\"@\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u001b0(\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020(8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010:\u001a\u0004\b \u0010;\"@\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u001b0(\"\b\b\u0000\u0010$*\u00020%*\u000e\u0012\u0004\u0012\u0002H$\u0012\u0004\u0012\u00020\u00020(8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010:\u001a\u0004\b#\u0010;¨\u0006<"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier$Companion;)Lcom/bilibili/blens/BSimpleLens;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "getSessionId$annotations", "getSessionId", "queryId", "getQueryId$annotations", "getQueryId", "query", "getQuery$annotations", "getQuery", "cardType", "Lkntr/app/deepsearch/base/model/biz/CardType;", "getCardType$annotations", "getCardType", "embed", RoomRecommendViewModel.EMPTY_CURSOR, "getEmbed$annotations", "getEmbed", "dataItemListIndex", RoomRecommendViewModel.EMPTY_CURSOR, "getDataItemListIndex$annotations", "getDataItemListIndex", "embedIndex", "getEmbedIndex$annotations", "getEmbedIndex", "pictureIndex", "getPictureIndex$annotations", "getPictureIndex", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "sessionIdNullable$annotations", "sessionIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "queryIdNullable$annotations", "queryIdNullable", "queryNullable$annotations", "queryNullable", "cardTypeNullable$annotations", "cardTypeNullable", "embedNullable$annotations", "embedNullable", "dataItemListIndexNullable$annotations", "dataItemListIndexNullable", "embedIndexNullable$annotations", "embedIndexNullable", "pictureIndexNullable$annotations", "pictureIndexNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchDataItemIdentifierLensKt {
    public static /* synthetic */ void cardTypeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void dataItemListIndexNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void embedIndexNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void embedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCardType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCardType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCardType$annotations(DeepSearchDataItemIdentifier.Companion companion) {
    }

    public static /* synthetic */ void getDataItemListIndex$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDataItemListIndex$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDataItemListIndex$annotations(DeepSearchDataItemIdentifier.Companion companion) {
    }

    public static /* synthetic */ void getEmbed$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getEmbed$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEmbed$annotations(DeepSearchDataItemIdentifier.Companion companion) {
    }

    public static /* synthetic */ void getEmbedIndex$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getEmbedIndex$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEmbedIndex$annotations(DeepSearchDataItemIdentifier.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(DeepSearchDataItemIdentifier.Companion companion) {
    }

    public static /* synthetic */ void getPictureIndex$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPictureIndex$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPictureIndex$annotations(DeepSearchDataItemIdentifier.Companion companion) {
    }

    public static /* synthetic */ void getQuery$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQuery$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQuery$annotations(DeepSearchDataItemIdentifier.Companion companion) {
    }

    public static /* synthetic */ void getQueryId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(DeepSearchDataItemIdentifier.Companion companion) {
    }

    public static /* synthetic */ void getSessionId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(DeepSearchDataItemIdentifier.Companion companion) {
    }

    public static /* synthetic */ void pictureIndexNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void queryIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void queryNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchDataItemIdentifier, DeepSearchDataItemIdentifier> getLens(DeepSearchDataItemIdentifier.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItemIdentifier, DeepSearchDataItemIdentifier>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifierLensKt$special$$inlined$invoke$1
            public DeepSearchDataItemIdentifier get(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return it;
            }

            public DeepSearchDataItemIdentifier set(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, DeepSearchDataItemIdentifier deepSearchDataItemIdentifier2) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier2;
                return it;
            }

            public DeepSearchDataItemIdentifier modify(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Function1<? super DeepSearchDataItemIdentifier, ? extends DeepSearchDataItemIdentifier> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return (DeepSearchDataItemIdentifier) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItemIdentifier, String> getSessionId(DeepSearchDataItemIdentifier.Companion $this$sessionId) {
        Intrinsics.checkNotNullParameter($this$sessionId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItemIdentifier, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifierLensKt$special$$inlined$invoke$2
            public String get(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return it.getSessionId();
            }

            public DeepSearchDataItemIdentifier set(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, String str) {
                DeepSearchDataItemIdentifier copy;
                String sessionId = str;
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                copy = it.copy((r18 & 1) != 0 ? it.sessionId : sessionId, (r18 & 2) != 0 ? it.queryId : null, (r18 & 4) != 0 ? it.query : null, (r18 & 8) != 0 ? it.cardType : null, (r18 & 16) != 0 ? it.embed : false, (r18 & 32) != 0 ? it.dataItemListIndex : 0, (r18 & 64) != 0 ? it.embedIndex : 0, (r18 & 128) != 0 ? it.pictureIndex : 0);
                return copy;
            }

            public DeepSearchDataItemIdentifier modify(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Function1<? super String, ? extends String> function1) {
                DeepSearchDataItemIdentifier copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                String sessionId = (String) function1.invoke(it.getSessionId());
                DeepSearchDataItemIdentifier it2 = deepSearchDataItemIdentifier;
                copy = it2.copy((r18 & 1) != 0 ? it2.sessionId : sessionId, (r18 & 2) != 0 ? it2.queryId : null, (r18 & 4) != 0 ? it2.query : null, (r18 & 8) != 0 ? it2.cardType : null, (r18 & 16) != 0 ? it2.embed : false, (r18 & 32) != 0 ? it2.dataItemListIndex : 0, (r18 & 64) != 0 ? it2.embedIndex : 0, (r18 & 128) != 0 ? it2.pictureIndex : 0);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItemIdentifier, String> getQueryId(DeepSearchDataItemIdentifier.Companion $this$queryId) {
        Intrinsics.checkNotNullParameter($this$queryId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItemIdentifier, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifierLensKt$special$$inlined$invoke$3
            public String get(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return it.getQueryId();
            }

            public DeepSearchDataItemIdentifier set(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, String str) {
                DeepSearchDataItemIdentifier copy;
                String queryId = str;
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                copy = it.copy((r18 & 1) != 0 ? it.sessionId : null, (r18 & 2) != 0 ? it.queryId : queryId, (r18 & 4) != 0 ? it.query : null, (r18 & 8) != 0 ? it.cardType : null, (r18 & 16) != 0 ? it.embed : false, (r18 & 32) != 0 ? it.dataItemListIndex : 0, (r18 & 64) != 0 ? it.embedIndex : 0, (r18 & 128) != 0 ? it.pictureIndex : 0);
                return copy;
            }

            public DeepSearchDataItemIdentifier modify(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Function1<? super String, ? extends String> function1) {
                DeepSearchDataItemIdentifier copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                String queryId = (String) function1.invoke(it.getQueryId());
                DeepSearchDataItemIdentifier it2 = deepSearchDataItemIdentifier;
                copy = it2.copy((r18 & 1) != 0 ? it2.sessionId : null, (r18 & 2) != 0 ? it2.queryId : queryId, (r18 & 4) != 0 ? it2.query : null, (r18 & 8) != 0 ? it2.cardType : null, (r18 & 16) != 0 ? it2.embed : false, (r18 & 32) != 0 ? it2.dataItemListIndex : 0, (r18 & 64) != 0 ? it2.embedIndex : 0, (r18 & 128) != 0 ? it2.pictureIndex : 0);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItemIdentifier, String> getQuery(DeepSearchDataItemIdentifier.Companion $this$query) {
        Intrinsics.checkNotNullParameter($this$query, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItemIdentifier, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifierLensKt$special$$inlined$invoke$4
            public String get(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return it.getQuery();
            }

            public DeepSearchDataItemIdentifier set(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, String str) {
                DeepSearchDataItemIdentifier copy;
                String query = str;
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                copy = it.copy((r18 & 1) != 0 ? it.sessionId : null, (r18 & 2) != 0 ? it.queryId : null, (r18 & 4) != 0 ? it.query : query, (r18 & 8) != 0 ? it.cardType : null, (r18 & 16) != 0 ? it.embed : false, (r18 & 32) != 0 ? it.dataItemListIndex : 0, (r18 & 64) != 0 ? it.embedIndex : 0, (r18 & 128) != 0 ? it.pictureIndex : 0);
                return copy;
            }

            public DeepSearchDataItemIdentifier modify(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Function1<? super String, ? extends String> function1) {
                DeepSearchDataItemIdentifier copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                String query = (String) function1.invoke(it.getQuery());
                DeepSearchDataItemIdentifier it2 = deepSearchDataItemIdentifier;
                copy = it2.copy((r18 & 1) != 0 ? it2.sessionId : null, (r18 & 2) != 0 ? it2.queryId : null, (r18 & 4) != 0 ? it2.query : query, (r18 & 8) != 0 ? it2.cardType : null, (r18 & 16) != 0 ? it2.embed : false, (r18 & 32) != 0 ? it2.dataItemListIndex : 0, (r18 & 64) != 0 ? it2.embedIndex : 0, (r18 & 128) != 0 ? it2.pictureIndex : 0);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItemIdentifier, CardType> getCardType(DeepSearchDataItemIdentifier.Companion $this$cardType) {
        Intrinsics.checkNotNullParameter($this$cardType, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItemIdentifier, CardType>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifierLensKt$special$$inlined$invoke$5
            public CardType get(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return it.getCardType();
            }

            public DeepSearchDataItemIdentifier set(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, CardType cardType) {
                DeepSearchDataItemIdentifier copy;
                CardType cardType2 = cardType;
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                copy = it.copy((r18 & 1) != 0 ? it.sessionId : null, (r18 & 2) != 0 ? it.queryId : null, (r18 & 4) != 0 ? it.query : null, (r18 & 8) != 0 ? it.cardType : cardType2, (r18 & 16) != 0 ? it.embed : false, (r18 & 32) != 0 ? it.dataItemListIndex : 0, (r18 & 64) != 0 ? it.embedIndex : 0, (r18 & 128) != 0 ? it.pictureIndex : 0);
                return copy;
            }

            public DeepSearchDataItemIdentifier modify(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Function1<? super CardType, ? extends CardType> function1) {
                DeepSearchDataItemIdentifier copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                CardType cardType = (CardType) function1.invoke(it.getCardType());
                DeepSearchDataItemIdentifier it2 = deepSearchDataItemIdentifier;
                copy = it2.copy((r18 & 1) != 0 ? it2.sessionId : null, (r18 & 2) != 0 ? it2.queryId : null, (r18 & 4) != 0 ? it2.query : null, (r18 & 8) != 0 ? it2.cardType : cardType, (r18 & 16) != 0 ? it2.embed : false, (r18 & 32) != 0 ? it2.dataItemListIndex : 0, (r18 & 64) != 0 ? it2.embedIndex : 0, (r18 & 128) != 0 ? it2.pictureIndex : 0);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItemIdentifier, Boolean> getEmbed(DeepSearchDataItemIdentifier.Companion $this$embed) {
        Intrinsics.checkNotNullParameter($this$embed, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItemIdentifier, Boolean>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifierLensKt$special$$inlined$invoke$6
            public Boolean get(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return Boolean.valueOf(it.getEmbed());
            }

            public DeepSearchDataItemIdentifier set(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Boolean bool) {
                DeepSearchDataItemIdentifier copy;
                boolean embed = bool.booleanValue();
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                copy = it.copy((r18 & 1) != 0 ? it.sessionId : null, (r18 & 2) != 0 ? it.queryId : null, (r18 & 4) != 0 ? it.query : null, (r18 & 8) != 0 ? it.cardType : null, (r18 & 16) != 0 ? it.embed : embed, (r18 & 32) != 0 ? it.dataItemListIndex : 0, (r18 & 64) != 0 ? it.embedIndex : 0, (r18 & 128) != 0 ? it.pictureIndex : 0);
                return copy;
            }

            public DeepSearchDataItemIdentifier modify(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Function1<? super Boolean, ? extends Boolean> function1) {
                DeepSearchDataItemIdentifier copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                boolean embed = ((Boolean) function1.invoke(Boolean.valueOf(it.getEmbed()))).booleanValue();
                DeepSearchDataItemIdentifier it2 = deepSearchDataItemIdentifier;
                copy = it2.copy((r18 & 1) != 0 ? it2.sessionId : null, (r18 & 2) != 0 ? it2.queryId : null, (r18 & 4) != 0 ? it2.query : null, (r18 & 8) != 0 ? it2.cardType : null, (r18 & 16) != 0 ? it2.embed : embed, (r18 & 32) != 0 ? it2.dataItemListIndex : 0, (r18 & 64) != 0 ? it2.embedIndex : 0, (r18 & 128) != 0 ? it2.pictureIndex : 0);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItemIdentifier, Integer> getDataItemListIndex(DeepSearchDataItemIdentifier.Companion $this$dataItemListIndex) {
        Intrinsics.checkNotNullParameter($this$dataItemListIndex, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItemIdentifier, Integer>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifierLensKt$special$$inlined$invoke$7
            public Integer get(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return Integer.valueOf(it.getDataItemListIndex());
            }

            public DeepSearchDataItemIdentifier set(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Integer num) {
                DeepSearchDataItemIdentifier copy;
                int dataItemListIndex = num.intValue();
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                copy = it.copy((r18 & 1) != 0 ? it.sessionId : null, (r18 & 2) != 0 ? it.queryId : null, (r18 & 4) != 0 ? it.query : null, (r18 & 8) != 0 ? it.cardType : null, (r18 & 16) != 0 ? it.embed : false, (r18 & 32) != 0 ? it.dataItemListIndex : dataItemListIndex, (r18 & 64) != 0 ? it.embedIndex : 0, (r18 & 128) != 0 ? it.pictureIndex : 0);
                return copy;
            }

            public DeepSearchDataItemIdentifier modify(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Function1<? super Integer, ? extends Integer> function1) {
                DeepSearchDataItemIdentifier copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                int dataItemListIndex = ((Number) function1.invoke(Integer.valueOf(it.getDataItemListIndex()))).intValue();
                DeepSearchDataItemIdentifier it2 = deepSearchDataItemIdentifier;
                copy = it2.copy((r18 & 1) != 0 ? it2.sessionId : null, (r18 & 2) != 0 ? it2.queryId : null, (r18 & 4) != 0 ? it2.query : null, (r18 & 8) != 0 ? it2.cardType : null, (r18 & 16) != 0 ? it2.embed : false, (r18 & 32) != 0 ? it2.dataItemListIndex : dataItemListIndex, (r18 & 64) != 0 ? it2.embedIndex : 0, (r18 & 128) != 0 ? it2.pictureIndex : 0);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItemIdentifier, Integer> getEmbedIndex(DeepSearchDataItemIdentifier.Companion $this$embedIndex) {
        Intrinsics.checkNotNullParameter($this$embedIndex, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItemIdentifier, Integer>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifierLensKt$special$$inlined$invoke$8
            public Integer get(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return Integer.valueOf(it.getEmbedIndex());
            }

            public DeepSearchDataItemIdentifier set(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Integer num) {
                DeepSearchDataItemIdentifier copy;
                int embedIndex = num.intValue();
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                copy = it.copy((r18 & 1) != 0 ? it.sessionId : null, (r18 & 2) != 0 ? it.queryId : null, (r18 & 4) != 0 ? it.query : null, (r18 & 8) != 0 ? it.cardType : null, (r18 & 16) != 0 ? it.embed : false, (r18 & 32) != 0 ? it.dataItemListIndex : 0, (r18 & 64) != 0 ? it.embedIndex : embedIndex, (r18 & 128) != 0 ? it.pictureIndex : 0);
                return copy;
            }

            public DeepSearchDataItemIdentifier modify(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Function1<? super Integer, ? extends Integer> function1) {
                DeepSearchDataItemIdentifier copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                int embedIndex = ((Number) function1.invoke(Integer.valueOf(it.getEmbedIndex()))).intValue();
                DeepSearchDataItemIdentifier it2 = deepSearchDataItemIdentifier;
                copy = it2.copy((r18 & 1) != 0 ? it2.sessionId : null, (r18 & 2) != 0 ? it2.queryId : null, (r18 & 4) != 0 ? it2.query : null, (r18 & 8) != 0 ? it2.cardType : null, (r18 & 16) != 0 ? it2.embed : false, (r18 & 32) != 0 ? it2.dataItemListIndex : 0, (r18 & 64) != 0 ? it2.embedIndex : embedIndex, (r18 & 128) != 0 ? it2.pictureIndex : 0);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItemIdentifier, Integer> getPictureIndex(DeepSearchDataItemIdentifier.Companion $this$pictureIndex) {
        Intrinsics.checkNotNullParameter($this$pictureIndex, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItemIdentifier, Integer>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifierLensKt$special$$inlined$invoke$9
            public Integer get(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                return Integer.valueOf(it.getPictureIndex());
            }

            public DeepSearchDataItemIdentifier set(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Integer num) {
                DeepSearchDataItemIdentifier copy;
                int pictureIndex = num.intValue();
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                copy = it.copy((r18 & 1) != 0 ? it.sessionId : null, (r18 & 2) != 0 ? it.queryId : null, (r18 & 4) != 0 ? it.query : null, (r18 & 8) != 0 ? it.cardType : null, (r18 & 16) != 0 ? it.embed : false, (r18 & 32) != 0 ? it.dataItemListIndex : 0, (r18 & 64) != 0 ? it.embedIndex : 0, (r18 & 128) != 0 ? it.pictureIndex : pictureIndex);
                return copy;
            }

            public DeepSearchDataItemIdentifier modify(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, Function1<? super Integer, ? extends Integer> function1) {
                DeepSearchDataItemIdentifier copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItemIdentifier it = deepSearchDataItemIdentifier;
                int pictureIndex = ((Number) function1.invoke(Integer.valueOf(it.getPictureIndex()))).intValue();
                DeepSearchDataItemIdentifier it2 = deepSearchDataItemIdentifier;
                copy = it2.copy((r18 & 1) != 0 ? it2.sessionId : null, (r18 & 2) != 0 ? it2.queryId : null, (r18 & 4) != 0 ? it2.query : null, (r18 & 8) != 0 ? it2.cardType : null, (r18 & 16) != 0 ? it2.embed : false, (r18 & 32) != 0 ? it2.dataItemListIndex : 0, (r18 & 64) != 0 ? it2.embedIndex : 0, (r18 & 128) != 0 ? it2.pictureIndex : pictureIndex);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getSessionId(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionId(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BSimpleLens<T, String> getQueryId(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getQueryId(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BSimpleLens<T, String> getQuery(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getQuery(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BSimpleLens<T, CardType> getCardType(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCardType(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getEmbed(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getEmbed(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getDataItemListIndex(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getDataItemListIndex(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getEmbedIndex(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getEmbedIndex(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getPictureIndex(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPictureIndex(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, String> sessionIdNullable(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionId(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, String> queryIdNullable(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getQueryId(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, String> queryNullable(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getQuery(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, CardType> cardTypeNullable(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCardType(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> embedNullable(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getEmbed(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, Integer> dataItemListIndexNullable(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getDataItemListIndex(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, Integer> embedIndexNullable(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getEmbedIndex(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, Integer> pictureIndexNullable(BSimpleLens<T, DeepSearchDataItemIdentifier> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPictureIndex(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, String> getSessionId(BNullableLens<T, DeepSearchDataItemIdentifier> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionId(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, String> getQueryId(BNullableLens<T, DeepSearchDataItemIdentifier> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getQueryId(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, String> getQuery(BNullableLens<T, DeepSearchDataItemIdentifier> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getQuery(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, CardType> getCardType(BNullableLens<T, DeepSearchDataItemIdentifier> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCardType(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getEmbed(BNullableLens<T, DeepSearchDataItemIdentifier> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getEmbed(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getDataItemListIndex(BNullableLens<T, DeepSearchDataItemIdentifier> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getDataItemListIndex(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getEmbedIndex(BNullableLens<T, DeepSearchDataItemIdentifier> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getEmbedIndex(DeepSearchDataItemIdentifier.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getPictureIndex(BNullableLens<T, DeepSearchDataItemIdentifier> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPictureIndex(DeepSearchDataItemIdentifier.Companion));
    }
}