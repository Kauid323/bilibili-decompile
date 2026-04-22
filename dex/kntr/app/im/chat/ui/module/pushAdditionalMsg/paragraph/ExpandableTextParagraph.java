package kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bilibili.common.paragraph.action.ParagraphClickListener;
import com.bilibili.common.paragraph.builder.ParagraphBuilder;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.constant.TextParagraphConfig;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilderProvider;
import com.bilibili.common.paragraph.impl.text.TextParagraphClickListener;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ExpandableTextParagraph.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ<\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableTextParagraph;", "Lcom/bilibili/common/paragraph/builder/ParagraphBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KText;", "textNodeBuilder", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;", "textParagraphConfig", "Lcom/bilibili/common/paragraph/impl/constant/TextParagraphConfig;", "config", "Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableTextConfig;", "<init>", "(Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;Lcom/bilibili/common/paragraph/impl/constant/TextParagraphConfig;Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableTextConfig;)V", "acceptType", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphType;", "getAcceptType", "()Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphType;", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "buildParagraph", "Lcom/bilibili/common/paragraph/builder/ParagraphContent;", "paragraph", "spacing", "Lcom/bapis/bilibili/app/dynamic/v2/KParaSpacing;", "format", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphFormat;", "clickListener", "Lcom/bilibili/common/paragraph/action/ParagraphClickListener;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpandableTextParagraph implements ParagraphBuilder<KParagraph.KText> {
    public static final int $stable = 0;
    private final ExpandableTextConfig config;
    private final TextNodeBuilderProvider textNodeBuilder;
    private final TextParagraphConfig textParagraphConfig;

    @Inject
    public ExpandableTextParagraph(TextNodeBuilderProvider textNodeBuilder, TextParagraphConfig textParagraphConfig, ExpandableTextConfig config) {
        Intrinsics.checkNotNullParameter(textNodeBuilder, "textNodeBuilder");
        Intrinsics.checkNotNullParameter(textParagraphConfig, "textParagraphConfig");
        Intrinsics.checkNotNullParameter(config, "config");
        this.textNodeBuilder = textNodeBuilder;
        this.textParagraphConfig = textParagraphConfig;
        this.config = config;
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
        return new ExpandableTextParagraphContent(paragraph, this.textNodeBuilder, spacing, format, this.textParagraphConfig, this.config, paragraphClickListener instanceof TextParagraphClickListener ? (TextParagraphClickListener) paragraphClickListener : null);
    }
}