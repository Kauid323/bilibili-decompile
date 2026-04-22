package kntr.app.im.chat.ui.page;

import dagger.internal.Factory;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002H\u0016¨\u0006\b"}, d2 = {"Lkntr/app/im/chat/ui/page/CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "Lkntr/app/im/chat/core/model/MsgFrame;", "<init>", "()V", "get", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory implements Factory<ChatMsgFrameBuilder<? super MsgFrame>> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory INSTANCE = new CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory();

    public ChatMsgFrameBuilder<? super MsgFrame> get() {
        return Companion.bindsDefaultChatMsgFrameBuilder();
    }

    /* compiled from: CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00020\t0\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/ui/page/CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "INSTANCE", "Lkntr/app/im/chat/ui/page/CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory;", "create", "bindsDefaultChatMsgFrameBuilder", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "Lkntr/app/im/chat/core/model/MsgFrame;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory create() {
            return CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory.INSTANCE;
        }

        @JvmStatic
        public final ChatMsgFrameBuilder<? super MsgFrame> bindsDefaultChatMsgFrameBuilder() {
            return CommonMsgFrameSet.INSTANCE.bindsDefaultChatMsgFrameBuilder();
        }
    }

    @JvmStatic
    public static final CommonMsgFrameSet_BindsDefaultChatMsgFrameBuilderFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final ChatMsgFrameBuilder<? super MsgFrame> bindsDefaultChatMsgFrameBuilder() {
        return Companion.bindsDefaultChatMsgFrameBuilder();
    }
}