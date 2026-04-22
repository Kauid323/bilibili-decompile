package kntr.app.im.chat.ui.page;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider;
import kntr.app.im.chat.ui.builder.ChatTimeLabelBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fBK\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\b0\u00070\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/ui/page/CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;", "mapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "Lkntr/app/im/chat/core/model/MsgFrame;", "defaultBuilderProvider", "chatTimeLabelBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory implements Factory<ChatMsgFrameBuilderProvider> {
    private final Provider<ChatTimeLabelBuilder> chatTimeLabelBuilderProvider;
    private final Provider<ChatMsgFrameBuilder<? super MsgFrame>> defaultBuilderProvider;
    private final Provider<Map<String, ChatMsgFrameBuilder<MsgFrame>>> mapProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory(Provider<Map<String, ChatMsgFrameBuilder<MsgFrame>>> provider, Provider<ChatMsgFrameBuilder<? super MsgFrame>> provider2, Provider<ChatTimeLabelBuilder> provider3) {
        Intrinsics.checkNotNullParameter(provider, "mapProvider");
        Intrinsics.checkNotNullParameter(provider2, "defaultBuilderProvider");
        Intrinsics.checkNotNullParameter(provider3, "chatTimeLabelBuilderProvider");
        this.mapProvider = provider;
        this.defaultBuilderProvider = provider2;
        this.chatTimeLabelBuilderProvider = provider3;
    }

    public ChatMsgFrameBuilderProvider get() {
        Companion companion = Companion;
        Map<String, ChatMsgFrameBuilder<MsgFrame>> map = this.mapProvider.get();
        Intrinsics.checkNotNullExpressionValue(map, "get(...)");
        ChatMsgFrameBuilder<? super MsgFrame> chatMsgFrameBuilder = this.defaultBuilderProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatMsgFrameBuilder, "get(...)");
        ChatTimeLabelBuilder chatTimeLabelBuilder = this.chatTimeLabelBuilderProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatTimeLabelBuilder, "get(...)");
        return companion.bindsChatMsgFrameBuilderProvider(map, chatMsgFrameBuilder, chatTimeLabelBuilder);
    }

    /* compiled from: CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JL\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u00072\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u000b0\n0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J:\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000b0\n2\u0006\u0010\u0013\u001a\u00020\u000eH\u0007¨\u0006\u0014"}, d2 = {"Lkntr/app/im/chat/ui/page/CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/ui/page/CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory;", "mapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "Lkntr/app/im/chat/core/model/MsgFrame;", "defaultBuilderProvider", "chatTimeLabelBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", "bindsChatMsgFrameBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;", "map", "defaultBuilder", "chatTimeLabelBuilder", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory create(Provider<Map<String, ChatMsgFrameBuilder<MsgFrame>>> provider, Provider<ChatMsgFrameBuilder<? super MsgFrame>> provider2, Provider<ChatTimeLabelBuilder> provider3) {
            Intrinsics.checkNotNullParameter(provider, "mapProvider");
            Intrinsics.checkNotNullParameter(provider2, "defaultBuilderProvider");
            Intrinsics.checkNotNullParameter(provider3, "chatTimeLabelBuilderProvider");
            return new CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ChatMsgFrameBuilderProvider bindsChatMsgFrameBuilderProvider(Map<String, ? extends ChatMsgFrameBuilder<MsgFrame>> map, ChatMsgFrameBuilder<? super MsgFrame> chatMsgFrameBuilder, ChatTimeLabelBuilder chatTimeLabelBuilder) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(chatMsgFrameBuilder, "defaultBuilder");
            Intrinsics.checkNotNullParameter(chatTimeLabelBuilder, "chatTimeLabelBuilder");
            return CommonMsgFrameSet.INSTANCE.bindsChatMsgFrameBuilderProvider(map, chatMsgFrameBuilder, chatTimeLabelBuilder);
        }
    }

    @JvmStatic
    public static final CommonMsgFrameSet_BindsChatMsgFrameBuilderProviderFactory create(Provider<Map<String, ChatMsgFrameBuilder<MsgFrame>>> provider, Provider<ChatMsgFrameBuilder<? super MsgFrame>> provider2, Provider<ChatTimeLabelBuilder> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ChatMsgFrameBuilderProvider bindsChatMsgFrameBuilderProvider(Map<String, ? extends ChatMsgFrameBuilder<MsgFrame>> map, ChatMsgFrameBuilder<? super MsgFrame> chatMsgFrameBuilder, ChatTimeLabelBuilder chatTimeLabelBuilder) {
        return Companion.bindsChatMsgFrameBuilderProvider(map, chatMsgFrameBuilder, chatTimeLabelBuilder);
    }
}