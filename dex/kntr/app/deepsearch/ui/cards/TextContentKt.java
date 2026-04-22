package kntr.app.deepsearch.ui.cards;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.broadcast.message.deepsearch.KTextCard;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.ui.paragraph.ParagraphKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextContent.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"TextContent", RoomRecommendViewModel.EMPTY_CURSOR, "text", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KTextCard;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KTextCard;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextContent$lambda$0(KTextCard kTextCard, String str, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        TextContent(kTextCard, str, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TextContent(final KTextCard text, final String queryId, Modifier modifier, final Function1<? super DeepSearchAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Composer $composer2 = $composer.startRestartGroup(-1433738006);
        ComposerKt.sourceInformation($composer2, "C(TextContent)N(text,queryId,modifier,dispatcher)15@450L170:TextContent.kt#pp6rt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(queryId) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1433738006, $dirty, -1, "kntr.app.deepsearch.ui.cards.TextContent (TextContent.kt:14)");
            }
            KModuleParagraph p0 = text.getParagraph();
            List listOf = p0 != null ? CollectionsKt.listOf(p0) : null;
            if (listOf == null) {
                listOf = CollectionsKt.emptyList();
            }
            ParagraphKt.Paragraph(listOf, modifier3, null, null, queryId, false, function1, $composer2, (($dirty >> 3) & 112) | (($dirty << 9) & 57344) | (3670016 & ($dirty << 9)), 44);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.TextContentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextContent$lambda$0;
                    TextContent$lambda$0 = TextContentKt.TextContent$lambda$0(text, queryId, modifier4, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextContent$lambda$0;
                }
            });
        }
    }
}