package kntr.common.ouro.core.dsl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.node.OuroLink;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeDSL.kt */
@OuroNodeDslMarker
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ3\u0010\u000f\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\u0002\b\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/core/dsl/LinkBuilder;", "", "builder", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "link", "Lkntr/common/ouro/core/model/node/OuroLink;", "<init>", "(Lkntr/common/ouro/core/model/OuroNodeMutableStorage;Lkntr/common/ouro/core/model/node/OuroLink;)V", "Plain", "", "content", "", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "InlineContent", "size", "Lkotlin/Pair;", "", "block", "Lkotlin/Function1;", "Lkntr/common/ouro/core/dsl/InlineContentBuilder;", "Lkotlin/ExtensionFunctionType;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LinkBuilder {
    private final OuroNodeMutableStorage<?> builder;
    private final OuroLink<?> link;

    public LinkBuilder(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroLink<?> ouroLink) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "builder");
        Intrinsics.checkNotNullParameter(ouroLink, "link");
        this.builder = ouroNodeMutableStorage;
        this.link = ouroLink;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Plain$default(LinkBuilder linkBuilder, String str, OuroMarks ouroMarks, int i, Object obj) {
        OuroMarks<OuroTextMark> ouroMarks2 = ouroMarks;
        if ((i & 2) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getTextMarks();
        }
        linkBuilder.Plain(str, ouroMarks2);
    }

    public final void Plain(String content, OuroMarks<OuroTextMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        OuroTextElement.Plain plain = new OuroTextElement.Plain(content, ouroMarks);
        OuroNodeMutableStorage $this$Plain_u24lambda_u240 = this.builder;
        $this$Plain_u24lambda_u240.addChild(this.link, (OuroLink<?>) plain);
    }

    public final void InlineContent(Pair<Float, Float> pair, Function1<? super InlineContentBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(pair, "size");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroMarks marks = new OuroMarks(new OuroDrawableMark.Size.Specified(pair.getFirst().floatValue(), pair.getSecond().floatValue()));
        OuroInlineContent inlineContent = new OuroInlineContent(marks);
        OuroNodeMutableStorage $this$InlineContent_u24lambda_u240 = this.builder;
        $this$InlineContent_u24lambda_u240.addChild(this.link, (OuroLink<?>) inlineContent);
        function1.invoke(new InlineContentBuilder(this.builder, inlineContent));
    }
}