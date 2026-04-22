package kntr.app.im.chat.frame.bubble;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.network.MsgFrameTransformer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0001\u000bB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/frame/bubble/ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/MsgFrameTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "implProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/frame/bubble/ChatBubbleFrameTransformer;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory implements Factory<MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame>> {
    private final Provider<ChatBubbleFrameTransformer> implProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory(Provider<ChatBubbleFrameTransformer> provider) {
        Intrinsics.checkNotNullParameter(provider, "implProvider");
        this.implProvider = provider;
    }

    public MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame> get() {
        Companion companion = Companion;
        ChatBubbleFrameTransformer chatBubbleFrameTransformer = this.implProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatBubbleFrameTransformer, "get(...)");
        return companion.bindChatBubbleFrameBuilder(chatBubbleFrameTransformer);
    }

    /* compiled from: ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\bH\u0007¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/frame/bubble/ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/frame/bubble/ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory;", "implProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/frame/bubble/ChatBubbleFrameTransformer;", "bindChatBubbleFrameBuilder", "Lkntr/app/im/chat/network/MsgFrameTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "impl", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory create(Provider<ChatBubbleFrameTransformer> provider) {
            Intrinsics.checkNotNullParameter(provider, "implProvider");
            return new ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory(provider);
        }

        @JvmStatic
        public final MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame> bindChatBubbleFrameBuilder(ChatBubbleFrameTransformer impl) {
            Intrinsics.checkNotNullParameter(impl, "impl");
            return ChatBubbleFrameModule.INSTANCE.bindChatBubbleFrameBuilder(impl);
        }
    }

    @JvmStatic
    public static final ChatBubbleFrameModule_BindChatBubbleFrameBuilderFactory create(Provider<ChatBubbleFrameTransformer> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame> bindChatBubbleFrameBuilder(ChatBubbleFrameTransformer impl) {
        return Companion.bindChatBubbleFrameBuilder(impl);
    }
}