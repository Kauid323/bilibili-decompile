package kntr.app.deepsearch.ui.paragraph.text.node;

import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilder;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilderProvider;
import com.bilibili.common.paragraph.impl.text.node.DefaultTextNodeBuilder;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchTextNodeBuilderProviderImpl.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B:\b\u0007\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0002R%\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchTextNodeBuilderProviderImpl;", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;", "map", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$IText;", "Lkotlin/jvm/JvmSuppressWildcards;", "default", "<init>", "(Ljava/util/Map;Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;)V", "getDefault", "()Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "get", "type", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$KTextNodeType;", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTextNodeBuilderProviderImpl implements TextNodeBuilderProvider {
    public static final int $stable = 0;

    /* renamed from: default  reason: not valid java name */
    private final TextNodeBuilder<? super KTextNode.IText> f20default;
    private final Map<String, TextNodeBuilder<KTextNode.IText>> map;

    @Inject
    public DeepSearchTextNodeBuilderProviderImpl(Map<String, TextNodeBuilder<KTextNode.IText>> map, @DefaultTextNodeBuilder TextNodeBuilder<? super KTextNode.IText> textNodeBuilder) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(textNodeBuilder, "default");
        this.map = map;
        this.f20default = textNodeBuilder;
    }

    public TextNodeBuilder<? super KTextNode.IText> getDefault() {
        return this.f20default;
    }

    public TextNodeBuilder<? super KTextNode.IText> get(KTextNode.KTextNodeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TextNodeBuilder result = this.map.get(type.getName());
        return result == null ? getDefault() : result;
    }
}