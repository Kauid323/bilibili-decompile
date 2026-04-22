package kntr.app.deepsearch.ui.paragraph.text;

import androidx.compose.ui.text.TextStyle;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bilibili.common.paragraph.builder.ParagraphBuilder;
import com.bilibili.common.paragraph.impl.constant.TextParagraphConfig;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchTextParagraphModule.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/DeepSearchTextParagraphModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideDeepSearchTextParagraphBuilder", "Lcom/bilibili/common/paragraph/builder/ParagraphBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$IContent;", "text", "Lkntr/app/deepsearch/ui/paragraph/text/DeepSearchTextParagraphBuilder;", "provideTextConfig", "Lcom/bilibili/common/paragraph/impl/constant/TextParagraphConfig;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {DeepSearchTextNodeModule.class, DeepSearchTextNodeStyleModule.class}, subcomponents = {})
public final class DeepSearchTextParagraphModule {
    public static final int $stable = 0;
    public static final DeepSearchTextParagraphModule INSTANCE = new DeepSearchTextParagraphModule();

    private DeepSearchTextParagraphModule() {
    }

    @Provides
    @IntoMap
    @StringKey("TEXT")
    public final ParagraphBuilder<KParagraph.IContent> provideDeepSearchTextParagraphBuilder(DeepSearchTextParagraphBuilder text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return text;
    }

    @Provides
    public final TextParagraphConfig provideTextConfig(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        return new TextParagraphConfig(textStyle, 0, 0, 6, (DefaultConstructorMarker) null);
    }
}