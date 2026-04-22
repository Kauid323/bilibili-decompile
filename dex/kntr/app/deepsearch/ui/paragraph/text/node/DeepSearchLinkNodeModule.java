package kntr.app.deepsearch.ui.paragraph.text.node;

import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilder;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchLinkNodeModule.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchLinkNodeModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideLinkNodeBuilder", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$IText;", "link", "Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchLinkNodeBuilder;", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class DeepSearchLinkNodeModule {
    public static final int $stable = 0;
    public static final DeepSearchLinkNodeModule INSTANCE = new DeepSearchLinkNodeModule();

    private DeepSearchLinkNodeModule() {
    }

    @Provides
    @IntoMap
    @StringKey("BIZ_LINK")
    public final TextNodeBuilder<KTextNode.IText> provideLinkNodeBuilder(DeepSearchLinkNodeBuilder link) {
        Intrinsics.checkNotNullParameter(link, "link");
        return link;
    }
}