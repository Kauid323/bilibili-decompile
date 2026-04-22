package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchPageData.android.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a@\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00012\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fj\u0004\u0018\u0001`\u0012\u001a\"\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\b¨\u0006\u0018"}, d2 = {"calHeight", RoomRecommendViewModel.EMPTY_CURSOR, "cardType", "Lkntr/app/deepsearch/base/model/biz/CardType;", "containerWidth", "content", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "textLayout", "Lkntr/app/deepsearch/base/model/biz/TextLayout;", "idModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "moduleParagraph", "Lcom/bapis/bilibili/app/dynamic/v2/KModuleParagraph;", "contentWidth", "linkNodeCallback", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/biz/LinkNodeCallback;", "bubbleActionForUnderlineChangeColor", "isShowBubble", RoomRecommendViewModel.EMPTY_CURSOR, "bubbleData", "originLayout", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchPageData_androidKt {
    public static final double calHeight(CardType cardType, double containerWidth, DeepSearchContent content) {
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(content, "content");
        return 0.0d;
    }

    public static final TextLayout textLayout(DeepSearchDataItemIdentifier idModel, KModuleParagraph moduleParagraph, double contentWidth, Function1<? super LinkNodeData, Unit> function1) {
        return null;
    }

    public static final TextLayout bubbleActionForUnderlineChangeColor(boolean isShowBubble, LinkNodeData bubbleData, TextLayout originLayout) {
        Intrinsics.checkNotNullParameter(bubbleData, "bubbleData");
        return null;
    }
}