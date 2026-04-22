package kntr.app.deepsearch.ui.paragraph.text;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import com.bapis.bilibili.app.dynamic.v2.KWordNode;
import com.bilibili.common.paragraph.builder.ParagraphScope;
import com.bilibili.common.paragraph.impl.text.DefaultTextSpanFactory;
import com.bilibili.common.paragraph.impl.text.TextSpanFactory;
import com.bilibili.common.paragraph.impl.text.TextSpanFactoryKt;
import dagger.Module;
import dagger.Provides;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchTextNodeStyleModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/DeepSearchTextNodeStyleModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideTextNodeStyle", "Lcom/bilibili/common/paragraph/impl/text/TextSpanFactory;", "defaultTextSpanFactory", "Lcom/bilibili/common/paragraph/impl/text/DefaultTextSpanFactory;", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class DeepSearchTextNodeStyleModule {
    public static final int $stable = 0;
    public static final DeepSearchTextNodeStyleModule INSTANCE = new DeepSearchTextNodeStyleModule();

    private DeepSearchTextNodeStyleModule() {
    }

    @Provides
    @ParagraphScope
    public final TextSpanFactory provideTextNodeStyle(final DefaultTextSpanFactory defaultTextSpanFactory) {
        Intrinsics.checkNotNullParameter(defaultTextSpanFactory, "defaultTextSpanFactory");
        return TextSpanFactoryKt.TextSpanFactory$default(new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.text.DeepSearchTextNodeStyleModule$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                TextStyle provideTextNodeStyle$lambda$0;
                provideTextNodeStyle$lambda$0 = DeepSearchTextNodeStyleModule.provideTextNodeStyle$lambda$0(defaultTextSpanFactory, (KWordNode) obj);
                return provideTextNodeStyle$lambda$0;
            }
        }, (Function1) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle provideTextNodeStyle$lambda$0(DefaultTextSpanFactory $defaultTextSpanFactory, KWordNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        TextStyle style = $defaultTextSpanFactory.buildTextStyleFor(it);
        TextDecoration textDecoration = style.getTextDecoration();
        return TextStyle.merge-dA7vx0o$default(style, 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration != null ? DeepSearchTextNodeStyleModuleKt.minus(textDecoration, TextDecoration.Companion.getUnderline()) : null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16773119, (Object) null);
    }
}