package kntr.app.im.chat.ui.paragraph;

import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.impl.text.EmptyTextNodeBuilder;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilder;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilderProvider;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilderProviderImpl;
import com.bilibili.common.paragraph.impl.text.node.DefaultTextNodeBuilder;
import com.bilibili.common.paragraph.impl.text.node.link.LinkNodeModule;
import com.bilibili.common.paragraph.impl.text.node.word.WordNodeModule;
import dagger.Binds;
import dagger.Module;
import kntr.app.im.chat.ui.paragraph.node.emote.ImEmoteNodeModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: ImTextNodeModule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/paragraph/ImTextNodeModule;", RoomRecommendViewModel.EMPTY_CURSOR, "bindTextNodeBuilder", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;", "impl", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProviderImpl;", "provideDefaultTextNodeBuilder", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$IText;", "text", "Lcom/bilibili/common/paragraph/impl/text/EmptyTextNodeBuilder;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {WordNodeModule.class, LinkNodeModule.class, ImEmoteNodeModule.class}, subcomponents = {})
public interface ImTextNodeModule {
    @Binds
    TextNodeBuilderProvider bindTextNodeBuilder(TextNodeBuilderProviderImpl textNodeBuilderProviderImpl);

    @Binds
    @DefaultTextNodeBuilder
    TextNodeBuilder<? super KTextNode.IText> provideDefaultTextNodeBuilder(EmptyTextNodeBuilder emptyTextNodeBuilder);
}