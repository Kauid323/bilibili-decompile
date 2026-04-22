package kntr.app.im.chat.ui.page.assistant;

import dagger.Module;
import kntr.app.im.chat.ui.module.author.di.ChatMsgAuthorModuleModule;
import kntr.app.im.chat.ui.module.autoReply.AutoReplyModuleModule;
import kntr.app.im.chat.ui.module.banner.ChatMsgBannerImgModule;
import kntr.app.im.chat.ui.module.hintText.HintTextModuleModule;
import kntr.app.im.chat.ui.module.invalidResource.InvalidResourceModuleContentModule;
import kntr.app.im.chat.ui.module.localPicture.di.ChatMsgLocalPictureModuleModule;
import kntr.app.im.chat.ui.module.notifyDetail.di.ChatMsgNotifyDetailModuleModule;
import kntr.app.im.chat.ui.module.notifyInteractive.di.ChatMsgNotifyInteractiveModuleModule;
import kntr.app.im.chat.ui.module.notifyTitle.di.ChatMsgNotifyTitleModuleModule;
import kntr.app.im.chat.ui.module.picture.di.ChatMsgPictureModuleModule;
import kntr.app.im.chat.ui.module.pushAdditionalMsg.di.ChatMsgPushAdditionalMsgModuleModule;
import kntr.app.im.chat.ui.module.pushArticle.di.ChatMsgPushArticleModuleModule;
import kntr.app.im.chat.ui.module.pushVideo.di.ChatMsgPushVideoModuleModule;
import kntr.app.im.chat.ui.module.shareApplet.di.ChatMsgShareAppletModuleModule;
import kntr.app.im.chat.ui.module.shareArticle.di.ChatMsgShareArticleModuleModule;
import kntr.app.im.chat.ui.module.shareCommon.di.ChatMsgShareCommonModuleModule;
import kntr.app.im.chat.ui.module.shareDynamic.di.ChatMsgShareDynamicModuleModule;
import kntr.app.im.chat.ui.module.shareDynamicForward.di.ChatMsgShareDynamicForwardModuleModule;
import kntr.app.im.chat.ui.module.shareType.di.ChatMsgShareTypeModuleModule;
import kntr.app.im.chat.ui.module.shareVideo.di.ChatMsgShareVideoModuleModule;
import kntr.app.im.chat.ui.module.text.di.ChatMsgTextModuleModule;
import kntr.app.im.chat.ui.module.unknown.UnknownModuleContentModule;
import kntr.app.im.chat.ui.page.CommonMsgModuleSet;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: AssistantChatModuleSet.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/ui/page/assistant/AssistantChatModuleSet;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {CommonMsgModuleSet.class, ChatMsgTextModuleModule.class, ChatMsgPictureModuleModule.class, ChatMsgLocalPictureModuleModule.class, ChatMsgShareVideoModuleModule.class, ChatMsgShareArticleModuleModule.class, ChatMsgShareTypeModuleModule.class, ChatMsgShareDynamicModuleModule.class, ChatMsgShareDynamicForwardModuleModule.class, ChatMsgShareCommonModuleModule.class, ChatMsgShareAppletModuleModule.class, ChatMsgPushVideoModuleModule.class, ChatMsgPushArticleModuleModule.class, ChatMsgPushAdditionalMsgModuleModule.class, ChatMsgAuthorModuleModule.class, ChatMsgNotifyTitleModuleModule.class, ChatMsgNotifyDetailModuleModule.class, ChatMsgNotifyInteractiveModuleModule.class, ChatMsgBannerImgModule.class, HintTextModuleModule.class, AutoReplyModuleModule.class, InvalidResourceModuleContentModule.class, UnknownModuleContentModule.class}, subcomponents = {})
public final class AssistantChatModuleSet {
    public static final int $stable = 0;
    public static final AssistantChatModuleSet INSTANCE = new AssistantChatModuleSet();

    private AssistantChatModuleSet() {
    }
}