package kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import com.bapis.bilibili.app.dynamic.v2.KEmoteNode;
import com.bilibili.common.paragraph.impl.text.TextSpanFactory;
import com.bilibili.common.paragraph.impl.text.node.emote.EmoteNodeBuilder;
import com.bilibili.compose.theme.ThemeDayNight;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpandableEmoteNodeBuilder.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableEmoteNodeBuilder;", "Lcom/bilibili/common/paragraph/impl/text/node/emote/EmoteNodeBuilder;", "density", "Landroidx/compose/ui/unit/Density;", "themeDayNight", "Lcom/bilibili/compose/theme/ThemeDayNight;", "styleFactory", "Lcom/bilibili/common/paragraph/impl/text/TextSpanFactory;", "<init>", "(Landroidx/compose/ui/unit/Density;Lcom/bilibili/compose/theme/ThemeDayNight;Lcom/bilibili/common/paragraph/impl/text/TextSpanFactory;)V", "nodeImageSize", "Landroidx/compose/ui/unit/DpSize;", "node", "Lcom/bapis/bilibili/app/dynamic/v2/KEmoteNode;", "nodeImageSize-Gh9hcWk", "(Lcom/bapis/bilibili/app/dynamic/v2/KEmoteNode;)J", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpandableEmoteNodeBuilder extends EmoteNodeBuilder {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ExpandableEmoteNodeBuilder(Density density, ThemeDayNight themeDayNight, TextSpanFactory styleFactory) {
        super(density, themeDayNight, styleFactory);
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        Intrinsics.checkNotNullParameter(styleFactory, "styleFactory");
    }

    /* renamed from: nodeImageSize-Gh9hcWk  reason: not valid java name */
    public long m1828nodeImageSizeGh9hcWk(KEmoteNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isInlineImg()) {
            return super.nodeImageSize-Gh9hcWk(node);
        }
        return DpKt.DpSize-YgX7TsA(Dp.constructor-impl(20), Dp.constructor-impl(20));
    }
}