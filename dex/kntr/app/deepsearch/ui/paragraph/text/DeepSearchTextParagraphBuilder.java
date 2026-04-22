package kntr.app.deepsearch.ui.paragraph.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bilibili.common.paragraph.action.ParagraphClickListener;
import com.bilibili.common.paragraph.builder.ParagraphBuilder;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilderProvider;
import javax.inject.Inject;
import kntr.app.deepsearch.ui.paragraph.constants.ParagraphTextDrawParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: DeepSearchTextParagraphBuilder.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ<\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/DeepSearchTextParagraphBuilder;", "Lcom/bilibili/common/paragraph/builder/ParagraphBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KText;", "textNodeBuilder", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;", "textDrawParams", "Lkntr/app/deepsearch/ui/paragraph/constants/ParagraphTextDrawParams;", "<init>", "(Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;Lkntr/app/deepsearch/ui/paragraph/constants/ParagraphTextDrawParams;)V", "acceptType", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphType;", "getAcceptType", "()Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphType;", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "buildParagraph", "Lcom/bilibili/common/paragraph/builder/ParagraphContent;", "paragraph", "spacing", "Lcom/bapis/bilibili/app/dynamic/v2/KParaSpacing;", "format", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphFormat;", "clickListener", "Lcom/bilibili/common/paragraph/action/ParagraphClickListener;", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTextParagraphBuilder implements ParagraphBuilder<KParagraph.KText> {
    public static final int $stable = 0;
    private final ParagraphTextDrawParams textDrawParams;
    private final TextNodeBuilderProvider textNodeBuilder;

    @Inject
    public DeepSearchTextParagraphBuilder(TextNodeBuilderProvider textNodeBuilder, ParagraphTextDrawParams textDrawParams) {
        Intrinsics.checkNotNullParameter(textNodeBuilder, "textNodeBuilder");
        Intrinsics.checkNotNullParameter(textDrawParams, "textDrawParams");
        this.textNodeBuilder = textNodeBuilder;
        this.textDrawParams = textDrawParams;
    }

    public /* bridge */ ParagraphContent<KParagraph.KText> ParagraphContent(KParagraph.KText paragraph, KParaSpacing spacing, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3) {
        return ParagraphBuilder.-CC.$default$ParagraphContent(this, (KParagraph.IContent) paragraph, spacing, function3);
    }

    public KParagraph.KParagraphType getAcceptType() {
        return KParagraph.KParagraphType.TEXT.INSTANCE;
    }

    public KClass<KParagraph.KText> getAcceptClass() {
        return Reflection.getOrCreateKotlinClass(KParagraph.KText.class);
    }

    public ParagraphContent<KParagraph.KText> buildParagraph(KParagraph.KText paragraph, KParaSpacing spacing, KParagraph.KParagraphFormat format, ParagraphClickListener<? super KParagraph.KText> paragraphClickListener) {
        return new TextParagraphContent(paragraph, this.textNodeBuilder, spacing, paragraphClickListener != null ? DeepSearchTextParagraphBuilderKt.asTextClickListener(paragraphClickListener) : null, this.textDrawParams, format);
    }
}