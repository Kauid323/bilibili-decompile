package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchDataItemLens.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"*\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"*\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007\"*\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007\"*\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010,\u001a\u0004\b\u000b\u0010-\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010,\u001a\u0004\b\u000f\u0010-\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010,\u001a\u0004\b\u0010\u0010-\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010,\u001a\u0004\b\u0012\u0010-\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00150\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010,\u001a\u0004\b\u0017\u0010-\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00190\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010,\u001a\u0004\b\u001b\u0010-\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u001d0\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010,\u001a\u0004\b\u001f\u0010-\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u001d0\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010,\u001a\u0004\b\"\u0010-\"@\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020$0\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010,\u001a\u0004\b&\u0010-\"@\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00190\u0001\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010,\u001a\u0004\b)\u0010-\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\t0.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010,\u001a\u0004\b0\u00101\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\r0.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010,\u001a\u0004\b3\u00101\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\r0.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010,\u001a\u0004\b5\u00101\"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\r0.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010,\u001a\u0004\b7\u00101\"B\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00150.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010,\u001a\u0004\b9\u00101\"B\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00190.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010,\u001a\u0004\b;\u00101\"B\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u001d0.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b<\u0010,\u001a\u0004\b=\u00101\"B\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u001d0.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010,\u001a\u0004\b?\u00101\"B\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020$0.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010,\u001a\u0004\bA\u00101\"B\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00190.\"\b\b\u0000\u0010**\u00020+*\u0010\u0012\u0004\u0012\u0002H*\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010,\u001a\u0004\bC\u00101\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\t0.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010D\u001a\u0004\b\u000b\u0010E\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\r0.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010D\u001a\u0004\b\u000f\u0010E\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\r0.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010D\u001a\u0004\b\u0010\u0010E\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\r0.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010D\u001a\u0004\b\u0012\u0010E\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00150.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010D\u001a\u0004\b\u0017\u0010E\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00190.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010D\u001a\u0004\b\u001b\u0010E\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u001d0.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010D\u001a\u0004\b\u001f\u0010E\"@\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u001d0.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010D\u001a\u0004\b\"\u0010E\"@\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020$0.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010D\u001a\u0004\b&\u0010E\"@\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00190.\"\b\b\u0000\u0010**\u00020+*\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00020.8FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010D\u001a\u0004\b)\u0010E¨\u0006F"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem$Companion;)Lcom/bilibili/blens/BSimpleLens;", "idModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "getIdModel$annotations", "getIdModel", "embed", RoomRecommendViewModel.EMPTY_CURSOR, "getEmbed$annotations", "getEmbed", "isFirst", "isFirst$annotations", "isLast", "isLast$annotations", "cardType", "Lkntr/app/deepsearch/base/model/biz/CardType;", "getCardType$annotations", "getCardType", "containerWidth", RoomRecommendViewModel.EMPTY_CURSOR, "getContainerWidth$annotations", "getContainerWidth", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "getSessionId$annotations", "getSessionId", "queryId", "getQueryId$annotations", "getQueryId", "content", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "getContent$annotations", "getContent", "height", "getHeight$annotations", "getHeight", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "idModelNullable$annotations", "idModelNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "embedNullable$annotations", "embedNullable", "isFirstNullable$annotations", "isFirstNullable", "isLastNullable$annotations", "isLastNullable", "cardTypeNullable$annotations", "cardTypeNullable", "containerWidthNullable$annotations", "containerWidthNullable", "sessionIdNullable$annotations", "sessionIdNullable", "queryIdNullable$annotations", "queryIdNullable", "contentNullable$annotations", "contentNullable", "heightNullable$annotations", "heightNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchDataItemLensKt {
    public static /* synthetic */ void cardTypeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void containerWidthNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void contentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void embedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCardType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCardType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCardType$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void getContainerWidth$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContainerWidth$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContainerWidth$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void getContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void getEmbed$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getEmbed$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEmbed$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void getHeight$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getHeight$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getHeight$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void getIdModel$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getIdModel$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getIdModel$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void getQueryId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void getSessionId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void heightNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void idModelNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isFirst$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isFirst$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isFirst$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void isFirstNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isLast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isLast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isLast$annotations(DeepSearchDataItem.Companion companion) {
    }

    public static /* synthetic */ void isLastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void queryIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchDataItem, DeepSearchDataItem> getLens(DeepSearchDataItem.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, DeepSearchDataItem>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$1
            public DeepSearchDataItem get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return it;
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, DeepSearchDataItem deepSearchDataItem2) {
                DeepSearchDataItem it = deepSearchDataItem2;
                return it;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super DeepSearchDataItem, ? extends DeepSearchDataItem> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it = deepSearchDataItem;
                return (DeepSearchDataItem) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, DeepSearchDataItemIdentifier> getIdModel(DeepSearchDataItem.Companion $this$idModel) {
        Intrinsics.checkNotNullParameter($this$idModel, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, DeepSearchDataItemIdentifier>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$2
            public DeepSearchDataItemIdentifier get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return it.getIdModel();
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, DeepSearchDataItemIdentifier deepSearchDataItemIdentifier) {
                DeepSearchDataItem copy;
                DeepSearchDataItemIdentifier idModel = deepSearchDataItemIdentifier;
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : idModel, (r27 & 2) != 0 ? it.embed : false, (r27 & 4) != 0 ? it.isFirst : false, (r27 & 8) != 0 ? it.isLast : false, (r27 & 16) != 0 ? it.cardType : null, (r27 & 32) != 0 ? it.containerWidth : 0.0d, (r27 & 64) != 0 ? it.sessionId : null, (r27 & 128) != 0 ? it.queryId : null, (r27 & 256) != 0 ? it.content : null, (r27 & 512) != 0 ? it.height : 0.0d);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super DeepSearchDataItemIdentifier, ? extends DeepSearchDataItemIdentifier> function1) {
                DeepSearchDataItem copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it = deepSearchDataItem;
                DeepSearchDataItemIdentifier idModel = (DeepSearchDataItemIdentifier) function1.invoke(it.getIdModel());
                DeepSearchDataItem it2 = deepSearchDataItem;
                copy = it2.copy((r27 & 1) != 0 ? it2.idModel : idModel, (r27 & 2) != 0 ? it2.embed : false, (r27 & 4) != 0 ? it2.isFirst : false, (r27 & 8) != 0 ? it2.isLast : false, (r27 & 16) != 0 ? it2.cardType : null, (r27 & 32) != 0 ? it2.containerWidth : 0.0d, (r27 & 64) != 0 ? it2.sessionId : null, (r27 & 128) != 0 ? it2.queryId : null, (r27 & 256) != 0 ? it2.content : null, (r27 & 512) != 0 ? it2.height : 0.0d);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, Boolean> getEmbed(DeepSearchDataItem.Companion $this$embed) {
        Intrinsics.checkNotNullParameter($this$embed, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, Boolean>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$3
            public Boolean get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return Boolean.valueOf(it.getEmbed());
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, Boolean bool) {
                DeepSearchDataItem copy;
                boolean embed = bool.booleanValue();
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : null, (r27 & 2) != 0 ? it.embed : embed, (r27 & 4) != 0 ? it.isFirst : false, (r27 & 8) != 0 ? it.isLast : false, (r27 & 16) != 0 ? it.cardType : null, (r27 & 32) != 0 ? it.containerWidth : 0.0d, (r27 & 64) != 0 ? it.sessionId : null, (r27 & 128) != 0 ? it.queryId : null, (r27 & 256) != 0 ? it.content : null, (r27 & 512) != 0 ? it.height : 0.0d);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super Boolean, ? extends Boolean> function1) {
                DeepSearchDataItem copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it = deepSearchDataItem;
                boolean embed = ((Boolean) function1.invoke(Boolean.valueOf(it.getEmbed()))).booleanValue();
                DeepSearchDataItem it2 = deepSearchDataItem;
                copy = it2.copy((r27 & 1) != 0 ? it2.idModel : null, (r27 & 2) != 0 ? it2.embed : embed, (r27 & 4) != 0 ? it2.isFirst : false, (r27 & 8) != 0 ? it2.isLast : false, (r27 & 16) != 0 ? it2.cardType : null, (r27 & 32) != 0 ? it2.containerWidth : 0.0d, (r27 & 64) != 0 ? it2.sessionId : null, (r27 & 128) != 0 ? it2.queryId : null, (r27 & 256) != 0 ? it2.content : null, (r27 & 512) != 0 ? it2.height : 0.0d);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, Boolean> isFirst(DeepSearchDataItem.Companion $this$isFirst) {
        Intrinsics.checkNotNullParameter($this$isFirst, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, Boolean>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$4
            public Boolean get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return Boolean.valueOf(it.isFirst());
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, Boolean bool) {
                DeepSearchDataItem copy;
                boolean isFirst = bool.booleanValue();
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : null, (r27 & 2) != 0 ? it.embed : false, (r27 & 4) != 0 ? it.isFirst : isFirst, (r27 & 8) != 0 ? it.isLast : false, (r27 & 16) != 0 ? it.cardType : null, (r27 & 32) != 0 ? it.containerWidth : 0.0d, (r27 & 64) != 0 ? it.sessionId : null, (r27 & 128) != 0 ? it.queryId : null, (r27 & 256) != 0 ? it.content : null, (r27 & 512) != 0 ? it.height : 0.0d);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super Boolean, ? extends Boolean> function1) {
                DeepSearchDataItem copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it = deepSearchDataItem;
                boolean isFirst = ((Boolean) function1.invoke(Boolean.valueOf(it.isFirst()))).booleanValue();
                DeepSearchDataItem it2 = deepSearchDataItem;
                copy = it2.copy((r27 & 1) != 0 ? it2.idModel : null, (r27 & 2) != 0 ? it2.embed : false, (r27 & 4) != 0 ? it2.isFirst : isFirst, (r27 & 8) != 0 ? it2.isLast : false, (r27 & 16) != 0 ? it2.cardType : null, (r27 & 32) != 0 ? it2.containerWidth : 0.0d, (r27 & 64) != 0 ? it2.sessionId : null, (r27 & 128) != 0 ? it2.queryId : null, (r27 & 256) != 0 ? it2.content : null, (r27 & 512) != 0 ? it2.height : 0.0d);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, Boolean> isLast(DeepSearchDataItem.Companion $this$isLast) {
        Intrinsics.checkNotNullParameter($this$isLast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, Boolean>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$5
            public Boolean get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return Boolean.valueOf(it.isLast());
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, Boolean bool) {
                DeepSearchDataItem copy;
                boolean isLast = bool.booleanValue();
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : null, (r27 & 2) != 0 ? it.embed : false, (r27 & 4) != 0 ? it.isFirst : false, (r27 & 8) != 0 ? it.isLast : isLast, (r27 & 16) != 0 ? it.cardType : null, (r27 & 32) != 0 ? it.containerWidth : 0.0d, (r27 & 64) != 0 ? it.sessionId : null, (r27 & 128) != 0 ? it.queryId : null, (r27 & 256) != 0 ? it.content : null, (r27 & 512) != 0 ? it.height : 0.0d);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super Boolean, ? extends Boolean> function1) {
                DeepSearchDataItem copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it = deepSearchDataItem;
                boolean isLast = ((Boolean) function1.invoke(Boolean.valueOf(it.isLast()))).booleanValue();
                DeepSearchDataItem it2 = deepSearchDataItem;
                copy = it2.copy((r27 & 1) != 0 ? it2.idModel : null, (r27 & 2) != 0 ? it2.embed : false, (r27 & 4) != 0 ? it2.isFirst : false, (r27 & 8) != 0 ? it2.isLast : isLast, (r27 & 16) != 0 ? it2.cardType : null, (r27 & 32) != 0 ? it2.containerWidth : 0.0d, (r27 & 64) != 0 ? it2.sessionId : null, (r27 & 128) != 0 ? it2.queryId : null, (r27 & 256) != 0 ? it2.content : null, (r27 & 512) != 0 ? it2.height : 0.0d);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, CardType> getCardType(DeepSearchDataItem.Companion $this$cardType) {
        Intrinsics.checkNotNullParameter($this$cardType, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, CardType>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$6
            public CardType get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return it.getCardType();
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, CardType cardType) {
                DeepSearchDataItem copy;
                CardType cardType2 = cardType;
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : null, (r27 & 2) != 0 ? it.embed : false, (r27 & 4) != 0 ? it.isFirst : false, (r27 & 8) != 0 ? it.isLast : false, (r27 & 16) != 0 ? it.cardType : cardType2, (r27 & 32) != 0 ? it.containerWidth : 0.0d, (r27 & 64) != 0 ? it.sessionId : null, (r27 & 128) != 0 ? it.queryId : null, (r27 & 256) != 0 ? it.content : null, (r27 & 512) != 0 ? it.height : 0.0d);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super CardType, ? extends CardType> function1) {
                DeepSearchDataItem copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it = deepSearchDataItem;
                CardType cardType = (CardType) function1.invoke(it.getCardType());
                DeepSearchDataItem it2 = deepSearchDataItem;
                copy = it2.copy((r27 & 1) != 0 ? it2.idModel : null, (r27 & 2) != 0 ? it2.embed : false, (r27 & 4) != 0 ? it2.isFirst : false, (r27 & 8) != 0 ? it2.isLast : false, (r27 & 16) != 0 ? it2.cardType : cardType, (r27 & 32) != 0 ? it2.containerWidth : 0.0d, (r27 & 64) != 0 ? it2.sessionId : null, (r27 & 128) != 0 ? it2.queryId : null, (r27 & 256) != 0 ? it2.content : null, (r27 & 512) != 0 ? it2.height : 0.0d);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, Double> getContainerWidth(DeepSearchDataItem.Companion $this$containerWidth) {
        Intrinsics.checkNotNullParameter($this$containerWidth, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, Double>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$7
            public Double get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return Double.valueOf(it.getContainerWidth());
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, Double d) {
                DeepSearchDataItem copy;
                double containerWidth = d.doubleValue();
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : null, (r27 & 2) != 0 ? it.embed : false, (r27 & 4) != 0 ? it.isFirst : false, (r27 & 8) != 0 ? it.isLast : false, (r27 & 16) != 0 ? it.cardType : null, (r27 & 32) != 0 ? it.containerWidth : containerWidth, (r27 & 64) != 0 ? it.sessionId : null, (r27 & 128) != 0 ? it.queryId : null, (r27 & 256) != 0 ? it.content : null, (r27 & 512) != 0 ? it.height : 0.0d);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super Double, ? extends Double> function1) {
                DeepSearchDataItem it;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it2 = deepSearchDataItem;
                double containerWidth = ((Number) function1.invoke(Double.valueOf(it2.getContainerWidth()))).doubleValue();
                DeepSearchDataItem it3 = deepSearchDataItem;
                it = it3.copy((r27 & 1) != 0 ? it3.idModel : null, (r27 & 2) != 0 ? it3.embed : false, (r27 & 4) != 0 ? it3.isFirst : false, (r27 & 8) != 0 ? it3.isLast : false, (r27 & 16) != 0 ? it3.cardType : null, (r27 & 32) != 0 ? it3.containerWidth : containerWidth, (r27 & 64) != 0 ? it3.sessionId : null, (r27 & 128) != 0 ? it3.queryId : null, (r27 & 256) != 0 ? it3.content : null, (r27 & 512) != 0 ? it3.height : 0.0d);
                return it;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, String> getSessionId(DeepSearchDataItem.Companion $this$sessionId) {
        Intrinsics.checkNotNullParameter($this$sessionId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$8
            public String get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return it.getSessionId();
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, String str) {
                DeepSearchDataItem copy;
                String sessionId = str;
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : null, (r27 & 2) != 0 ? it.embed : false, (r27 & 4) != 0 ? it.isFirst : false, (r27 & 8) != 0 ? it.isLast : false, (r27 & 16) != 0 ? it.cardType : null, (r27 & 32) != 0 ? it.containerWidth : 0.0d, (r27 & 64) != 0 ? it.sessionId : sessionId, (r27 & 128) != 0 ? it.queryId : null, (r27 & 256) != 0 ? it.content : null, (r27 & 512) != 0 ? it.height : 0.0d);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super String, ? extends String> function1) {
                DeepSearchDataItem copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it = deepSearchDataItem;
                String sessionId = (String) function1.invoke(it.getSessionId());
                DeepSearchDataItem it2 = deepSearchDataItem;
                copy = it2.copy((r27 & 1) != 0 ? it2.idModel : null, (r27 & 2) != 0 ? it2.embed : false, (r27 & 4) != 0 ? it2.isFirst : false, (r27 & 8) != 0 ? it2.isLast : false, (r27 & 16) != 0 ? it2.cardType : null, (r27 & 32) != 0 ? it2.containerWidth : 0.0d, (r27 & 64) != 0 ? it2.sessionId : sessionId, (r27 & 128) != 0 ? it2.queryId : null, (r27 & 256) != 0 ? it2.content : null, (r27 & 512) != 0 ? it2.height : 0.0d);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, String> getQueryId(DeepSearchDataItem.Companion $this$queryId) {
        Intrinsics.checkNotNullParameter($this$queryId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$9
            public String get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return it.getQueryId();
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, String str) {
                DeepSearchDataItem copy;
                String queryId = str;
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : null, (r27 & 2) != 0 ? it.embed : false, (r27 & 4) != 0 ? it.isFirst : false, (r27 & 8) != 0 ? it.isLast : false, (r27 & 16) != 0 ? it.cardType : null, (r27 & 32) != 0 ? it.containerWidth : 0.0d, (r27 & 64) != 0 ? it.sessionId : null, (r27 & 128) != 0 ? it.queryId : queryId, (r27 & 256) != 0 ? it.content : null, (r27 & 512) != 0 ? it.height : 0.0d);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super String, ? extends String> function1) {
                DeepSearchDataItem copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it = deepSearchDataItem;
                String queryId = (String) function1.invoke(it.getQueryId());
                DeepSearchDataItem it2 = deepSearchDataItem;
                copy = it2.copy((r27 & 1) != 0 ? it2.idModel : null, (r27 & 2) != 0 ? it2.embed : false, (r27 & 4) != 0 ? it2.isFirst : false, (r27 & 8) != 0 ? it2.isLast : false, (r27 & 16) != 0 ? it2.cardType : null, (r27 & 32) != 0 ? it2.containerWidth : 0.0d, (r27 & 64) != 0 ? it2.sessionId : null, (r27 & 128) != 0 ? it2.queryId : queryId, (r27 & 256) != 0 ? it2.content : null, (r27 & 512) != 0 ? it2.height : 0.0d);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, DeepSearchContent> getContent(DeepSearchDataItem.Companion $this$content) {
        Intrinsics.checkNotNullParameter($this$content, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, DeepSearchContent>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$10
            public DeepSearchContent get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return it.getContent();
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, DeepSearchContent deepSearchContent) {
                DeepSearchDataItem copy;
                DeepSearchContent content = deepSearchContent;
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : null, (r27 & 2) != 0 ? it.embed : false, (r27 & 4) != 0 ? it.isFirst : false, (r27 & 8) != 0 ? it.isLast : false, (r27 & 16) != 0 ? it.cardType : null, (r27 & 32) != 0 ? it.containerWidth : 0.0d, (r27 & 64) != 0 ? it.sessionId : null, (r27 & 128) != 0 ? it.queryId : null, (r27 & 256) != 0 ? it.content : content, (r27 & 512) != 0 ? it.height : 0.0d);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super DeepSearchContent, ? extends DeepSearchContent> function1) {
                DeepSearchDataItem copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it = deepSearchDataItem;
                DeepSearchContent content = (DeepSearchContent) function1.invoke(it.getContent());
                DeepSearchDataItem it2 = deepSearchDataItem;
                copy = it2.copy((r27 & 1) != 0 ? it2.idModel : null, (r27 & 2) != 0 ? it2.embed : false, (r27 & 4) != 0 ? it2.isFirst : false, (r27 & 8) != 0 ? it2.isLast : false, (r27 & 16) != 0 ? it2.cardType : null, (r27 & 32) != 0 ? it2.containerWidth : 0.0d, (r27 & 64) != 0 ? it2.sessionId : null, (r27 & 128) != 0 ? it2.queryId : null, (r27 & 256) != 0 ? it2.content : content, (r27 & 512) != 0 ? it2.height : 0.0d);
                return copy;
            }
        };
    }

    public static final BSimpleLens<DeepSearchDataItem, Double> getHeight(DeepSearchDataItem.Companion $this$height) {
        Intrinsics.checkNotNullParameter($this$height, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchDataItem, Double>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchDataItemLensKt$special$$inlined$invoke$11
            public Double get(DeepSearchDataItem deepSearchDataItem) {
                DeepSearchDataItem it = deepSearchDataItem;
                return Double.valueOf(it.getHeight());
            }

            public DeepSearchDataItem set(DeepSearchDataItem deepSearchDataItem, Double d) {
                DeepSearchDataItem copy;
                double height = d.doubleValue();
                DeepSearchDataItem it = deepSearchDataItem;
                copy = it.copy((r27 & 1) != 0 ? it.idModel : null, (r27 & 2) != 0 ? it.embed : false, (r27 & 4) != 0 ? it.isFirst : false, (r27 & 8) != 0 ? it.isLast : false, (r27 & 16) != 0 ? it.cardType : null, (r27 & 32) != 0 ? it.containerWidth : 0.0d, (r27 & 64) != 0 ? it.sessionId : null, (r27 & 128) != 0 ? it.queryId : null, (r27 & 256) != 0 ? it.content : null, (r27 & 512) != 0 ? it.height : height);
                return copy;
            }

            public DeepSearchDataItem modify(DeepSearchDataItem deepSearchDataItem, Function1<? super Double, ? extends Double> function1) {
                DeepSearchDataItem it;
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchDataItem it2 = deepSearchDataItem;
                double height = ((Number) function1.invoke(Double.valueOf(it2.getHeight()))).doubleValue();
                DeepSearchDataItem it3 = deepSearchDataItem;
                it = it3.copy((r27 & 1) != 0 ? it3.idModel : null, (r27 & 2) != 0 ? it3.embed : false, (r27 & 4) != 0 ? it3.isFirst : false, (r27 & 8) != 0 ? it3.isLast : false, (r27 & 16) != 0 ? it3.cardType : null, (r27 & 32) != 0 ? it3.containerWidth : 0.0d, (r27 & 64) != 0 ? it3.sessionId : null, (r27 & 128) != 0 ? it3.queryId : null, (r27 & 256) != 0 ? it3.content : null, (r27 & 512) != 0 ? it3.height : height);
                return it;
            }
        };
    }

    public static final <T> BSimpleLens<T, DeepSearchDataItemIdentifier> getIdModel(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getIdModel(DeepSearchDataItem.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getEmbed(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getEmbed(DeepSearchDataItem.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isFirst(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isFirst(DeepSearchDataItem.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isLast(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isLast(DeepSearchDataItem.Companion));
    }

    public static final <T> BSimpleLens<T, CardType> getCardType(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCardType(DeepSearchDataItem.Companion));
    }

    public static final <T> BSimpleLens<T, Double> getContainerWidth(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContainerWidth(DeepSearchDataItem.Companion));
    }

    public static final <T> BSimpleLens<T, String> getSessionId(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionId(DeepSearchDataItem.Companion));
    }

    public static final <T> BSimpleLens<T, String> getQueryId(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getQueryId(DeepSearchDataItem.Companion));
    }

    public static final <T> BSimpleLens<T, DeepSearchContent> getContent(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContent(DeepSearchDataItem.Companion));
    }

    public static final <T> BSimpleLens<T, Double> getHeight(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getHeight(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchDataItemIdentifier> idModelNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getIdModel(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> embedNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getEmbed(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isFirstNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isFirst(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isLastNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isLast(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, CardType> cardTypeNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCardType(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Double> containerWidthNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContainerWidth(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, String> sessionIdNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionId(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, String> queryIdNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getQueryId(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchContent> contentNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContent(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Double> heightNullable(BSimpleLens<T, DeepSearchDataItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getHeight(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchDataItemIdentifier> getIdModel(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getIdModel(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getEmbed(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getEmbed(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isFirst(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isFirst(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isLast(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isLast(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, CardType> getCardType(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCardType(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Double> getContainerWidth(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContainerWidth(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, String> getSessionId(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionId(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, String> getQueryId(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getQueryId(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, DeepSearchContent> getContent(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContent(DeepSearchDataItem.Companion));
    }

    public static final <T> BNullableLens<T, Double> getHeight(BNullableLens<T, DeepSearchDataItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getHeight(DeepSearchDataItem.Companion));
    }
}