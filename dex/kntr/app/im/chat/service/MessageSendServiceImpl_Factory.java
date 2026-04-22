package kntr.app.im.chat.service;

import dagger.internal.Factory;
import im.base.config.IMConfigSetting;
import javax.inject.Provider;
import kntr.app.im.chat.network.ChatSendEvent;
import kntr.app.im.chat.service.sender.TextMessageSender;
import kntr.app.im.chat.service.sender.image.ImageMessageSender;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageSendServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/service/MessageSendServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/service/MessageSendServiceImpl;", "imageMessageSenderProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/service/sender/image/ImageMessageSender;", "textMessageSenderProvider", "Lkntr/app/im/chat/service/sender/TextMessageSender;", "sendEventProvider", "Lkntr/app/im/chat/network/ChatSendEvent;", "imConfigSettingProvider", "Lim/base/config/IMConfigSetting;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageSendServiceImpl_Factory implements Factory<MessageSendServiceImpl> {
    private final Provider<IMConfigSetting> imConfigSettingProvider;
    private final Provider<ImageMessageSender> imageMessageSenderProvider;
    private final Provider<ChatSendEvent> sendEventProvider;
    private final Provider<TextMessageSender> textMessageSenderProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public MessageSendServiceImpl_Factory(Provider<ImageMessageSender> provider, Provider<TextMessageSender> provider2, Provider<ChatSendEvent> provider3, Provider<IMConfigSetting> provider4) {
        Intrinsics.checkNotNullParameter(provider, "imageMessageSenderProvider");
        Intrinsics.checkNotNullParameter(provider2, "textMessageSenderProvider");
        Intrinsics.checkNotNullParameter(provider3, "sendEventProvider");
        Intrinsics.checkNotNullParameter(provider4, "imConfigSettingProvider");
        this.imageMessageSenderProvider = provider;
        this.textMessageSenderProvider = provider2;
        this.sendEventProvider = provider3;
        this.imConfigSettingProvider = provider4;
    }

    public MessageSendServiceImpl get() {
        Companion companion = Companion;
        ImageMessageSender imageMessageSender = this.imageMessageSenderProvider.get();
        Intrinsics.checkNotNullExpressionValue(imageMessageSender, "get(...)");
        TextMessageSender textMessageSender = this.textMessageSenderProvider.get();
        Intrinsics.checkNotNullExpressionValue(textMessageSender, "get(...)");
        ChatSendEvent chatSendEvent = this.sendEventProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatSendEvent, "get(...)");
        IMConfigSetting iMConfigSetting = this.imConfigSettingProvider.get();
        Intrinsics.checkNotNullExpressionValue(iMConfigSetting, "get(...)");
        return companion.newInstance(imageMessageSender, textMessageSender, chatSendEvent, iMConfigSetting);
    }

    /* compiled from: MessageSendServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/service/MessageSendServiceImpl_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/service/MessageSendServiceImpl_Factory;", "imageMessageSenderProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/service/sender/image/ImageMessageSender;", "textMessageSenderProvider", "Lkntr/app/im/chat/service/sender/TextMessageSender;", "sendEventProvider", "Lkntr/app/im/chat/network/ChatSendEvent;", "imConfigSettingProvider", "Lim/base/config/IMConfigSetting;", "newInstance", "Lkntr/app/im/chat/service/MessageSendServiceImpl;", "imageMessageSender", "textMessageSender", "sendEvent", "imConfigSetting", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MessageSendServiceImpl_Factory create(Provider<ImageMessageSender> provider, Provider<TextMessageSender> provider2, Provider<ChatSendEvent> provider3, Provider<IMConfigSetting> provider4) {
            Intrinsics.checkNotNullParameter(provider, "imageMessageSenderProvider");
            Intrinsics.checkNotNullParameter(provider2, "textMessageSenderProvider");
            Intrinsics.checkNotNullParameter(provider3, "sendEventProvider");
            Intrinsics.checkNotNullParameter(provider4, "imConfigSettingProvider");
            return new MessageSendServiceImpl_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final MessageSendServiceImpl newInstance(ImageMessageSender imageMessageSender, TextMessageSender textMessageSender, ChatSendEvent sendEvent, IMConfigSetting imConfigSetting) {
            Intrinsics.checkNotNullParameter(imageMessageSender, "imageMessageSender");
            Intrinsics.checkNotNullParameter(textMessageSender, "textMessageSender");
            Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
            Intrinsics.checkNotNullParameter(imConfigSetting, "imConfigSetting");
            return new MessageSendServiceImpl(imageMessageSender, textMessageSender, sendEvent, imConfigSetting);
        }
    }

    @JvmStatic
    public static final MessageSendServiceImpl_Factory create(Provider<ImageMessageSender> provider, Provider<TextMessageSender> provider2, Provider<ChatSendEvent> provider3, Provider<IMConfigSetting> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final MessageSendServiceImpl newInstance(ImageMessageSender imageMessageSender, TextMessageSender textMessageSender, ChatSendEvent sendEvent, IMConfigSetting imConfigSetting) {
        return Companion.newInstance(imageMessageSender, textMessageSender, sendEvent, imConfigSetting);
    }
}