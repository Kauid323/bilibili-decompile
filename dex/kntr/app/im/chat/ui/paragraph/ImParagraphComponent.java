package kntr.app.im.chat.ui.paragraph;

import androidx.compose.ui.unit.Density;
import com.bilibili.common.paragraph.builder.ParagraphBuilderModule;
import com.bilibili.common.paragraph.builder.ParagraphBuilderProvider;
import com.bilibili.common.paragraph.builder.ParagraphScope;
import com.bilibili.common.paragraph.impl.constant.SortedListDrawParams;
import com.bilibili.common.paragraph.impl.constant.TextParagraphConfig;
import com.bilibili.common.paragraph.impl.line.LineParagraphModule;
import com.bilibili.common.paragraph.impl.pic.PicParagraphModule;
import com.bilibili.common.paragraph.impl.sortedlist.SortedListParagraphModule;
import com.bilibili.common.paragraph.impl.text.TextParagraphModule;
import com.bilibili.common.paragraph.impl.text.TextSpanFactoryModule;
import com.bilibili.common.paragraph.impl.unsortedlist.UnsortedListParagraphModule;
import com.bilibili.compose.theme.ThemeDayNight;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: ImParagraphComponent.kt */
@ParagraphScope
@Subcomponent(modules = {ImTextNodeModule.class, TextSpanFactoryModule.class, ParagraphBuilderModule.class, TextParagraphModule.class, PicParagraphModule.class, LineParagraphModule.class, SortedListParagraphModule.class, UnsortedListParagraphModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/paragraph/ImParagraphComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "paragraphBuilderProvider", "Lcom/bilibili/common/paragraph/builder/ParagraphBuilderProvider;", "Builder", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ImParagraphComponent {

    /* compiled from: ImParagraphComponent.kt */
    @Subcomponent.Builder
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/paragraph/ImParagraphComponent$Builder;", RoomRecommendViewModel.EMPTY_CURSOR, "bindDensity", "density", "Landroidx/compose/ui/unit/Density;", "bindDayNight", "dayNight", "Lcom/bilibili/compose/theme/ThemeDayNight;", "bindSortedListDrawParams", "drawParams", "Lcom/bilibili/common/paragraph/impl/constant/SortedListDrawParams;", "bindTextConfig", "textConfig", "Lcom/bilibili/common/paragraph/impl/constant/TextParagraphConfig;", ReportBuildInParam.BUILD, "Lkntr/app/im/chat/ui/paragraph/ImParagraphComponent;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Builder {
        Builder bindDayNight(@BindsInstance ThemeDayNight themeDayNight);

        Builder bindDensity(@BindsInstance Density density);

        Builder bindSortedListDrawParams(@BindsInstance SortedListDrawParams sortedListDrawParams);

        Builder bindTextConfig(@BindsInstance TextParagraphConfig textParagraphConfig);

        ImParagraphComponent build();
    }

    ParagraphBuilderProvider paragraphBuilderProvider();
}