package kntr.app.deepsearch.ui.paragraph.text.node;

import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilder;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchTextNodeBuilderProviderImpl_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB=\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\b0\u00070\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchTextNodeBuilderProviderImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchTextNodeBuilderProviderImpl;", "mapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$IText;", "defaultProvider", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTextNodeBuilderProviderImpl_Factory implements Factory<DeepSearchTextNodeBuilderProviderImpl> {
    private final Provider<TextNodeBuilder<? super KTextNode.IText>> defaultProvider;
    private final Provider<Map<String, TextNodeBuilder<KTextNode.IText>>> mapProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DeepSearchTextNodeBuilderProviderImpl_Factory(Provider<Map<String, TextNodeBuilder<KTextNode.IText>>> provider, Provider<TextNodeBuilder<? super KTextNode.IText>> provider2) {
        Intrinsics.checkNotNullParameter(provider, "mapProvider");
        Intrinsics.checkNotNullParameter(provider2, "defaultProvider");
        this.mapProvider = provider;
        this.defaultProvider = provider2;
    }

    public DeepSearchTextNodeBuilderProviderImpl get() {
        Companion companion = Companion;
        Map<String, TextNodeBuilder<KTextNode.IText>> map = this.mapProvider.get();
        Intrinsics.checkNotNullExpressionValue(map, "get(...)");
        TextNodeBuilder<? super KTextNode.IText> textNodeBuilder = this.defaultProvider.get();
        Intrinsics.checkNotNullExpressionValue(textNodeBuilder, "get(...)");
        return companion.newInstance(map, textNodeBuilder);
    }

    /* compiled from: DeepSearchTextNodeBuilderProviderImpl_Factory.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u00072\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u000b0\n0\u0007H\u0007J2\u0010\r\u001a\u00020\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000b0\nH\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchTextNodeBuilderProviderImpl_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchTextNodeBuilderProviderImpl_Factory;", "mapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$IText;", "defaultProvider", "newInstance", "Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchTextNodeBuilderProviderImpl;", "map", "p1", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DeepSearchTextNodeBuilderProviderImpl_Factory create(Provider<Map<String, TextNodeBuilder<KTextNode.IText>>> provider, Provider<TextNodeBuilder<? super KTextNode.IText>> provider2) {
            Intrinsics.checkNotNullParameter(provider, "mapProvider");
            Intrinsics.checkNotNullParameter(provider2, "defaultProvider");
            return new DeepSearchTextNodeBuilderProviderImpl_Factory(provider, provider2);
        }

        @JvmStatic
        public final DeepSearchTextNodeBuilderProviderImpl newInstance(Map<String, ? extends TextNodeBuilder<KTextNode.IText>> map, TextNodeBuilder<? super KTextNode.IText> textNodeBuilder) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(textNodeBuilder, "p1");
            return new DeepSearchTextNodeBuilderProviderImpl(map, textNodeBuilder);
        }
    }

    @JvmStatic
    public static final DeepSearchTextNodeBuilderProviderImpl_Factory create(Provider<Map<String, TextNodeBuilder<KTextNode.IText>>> provider, Provider<TextNodeBuilder<? super KTextNode.IText>> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final DeepSearchTextNodeBuilderProviderImpl newInstance(Map<String, ? extends TextNodeBuilder<KTextNode.IText>> map, TextNodeBuilder<? super KTextNode.IText> textNodeBuilder) {
        return Companion.newInstance(map, textNodeBuilder);
    }
}