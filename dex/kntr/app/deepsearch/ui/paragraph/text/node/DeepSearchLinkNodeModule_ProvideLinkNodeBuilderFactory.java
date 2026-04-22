package kntr.app.deepsearch.ui.paragraph.text.node;

import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilder;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\nB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory;", "Ldagger/internal/Factory;", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$IText;", "linkProvider", "Ljavax/inject/Provider;", "Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchLinkNodeBuilder;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory implements Factory<TextNodeBuilder<KTextNode.IText>> {
    private final Provider<DeepSearchLinkNodeBuilder> linkProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory(Provider<DeepSearchLinkNodeBuilder> provider) {
        Intrinsics.checkNotNullParameter(provider, "linkProvider");
        this.linkProvider = provider;
    }

    /* renamed from: get */
    public TextNodeBuilder<KTextNode.IText> m796get() {
        Companion companion = Companion;
        DeepSearchLinkNodeBuilder deepSearchLinkNodeBuilder = this.linkProvider.get();
        Intrinsics.checkNotNullExpressionValue(deepSearchLinkNodeBuilder, "get(...)");
        return companion.provideLinkNodeBuilder(deepSearchLinkNodeBuilder);
    }

    /* compiled from: DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory;", "linkProvider", "Ljavax/inject/Provider;", "Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchLinkNodeBuilder;", "provideLinkNodeBuilder", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$IText;", "link", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory create(Provider<DeepSearchLinkNodeBuilder> provider) {
            Intrinsics.checkNotNullParameter(provider, "linkProvider");
            return new DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory(provider);
        }

        @JvmStatic
        public final TextNodeBuilder<KTextNode.IText> provideLinkNodeBuilder(DeepSearchLinkNodeBuilder link) {
            Intrinsics.checkNotNullParameter(link, "link");
            return DeepSearchLinkNodeModule.INSTANCE.provideLinkNodeBuilder(link);
        }
    }

    @JvmStatic
    public static final DeepSearchLinkNodeModule_ProvideLinkNodeBuilderFactory create(Provider<DeepSearchLinkNodeBuilder> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final TextNodeBuilder<KTextNode.IText> provideLinkNodeBuilder(DeepSearchLinkNodeBuilder link) {
        return Companion.provideLinkNodeBuilder(link);
    }
}