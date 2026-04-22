package kntr.app.im.chat.di.module.common;

import dagger.Module;
import kntr.app.im.chat.module.AiIntroduceModule;
import kntr.app.im.chat.module.AuthorModuleTransformerModule;
import kntr.app.im.chat.module.AutoReplyModuleTransformerModule;
import kntr.app.im.chat.module.BannerImageModuleTransformerModule;
import kntr.app.im.chat.module.InvalidResourceModuleModule;
import kntr.app.im.chat.module.NotifyDetailModuleTransformerModule;
import kntr.app.im.chat.module.NotifyGameModuleTransformerModule;
import kntr.app.im.chat.module.NotifyInteractiveModuleTransformerModule;
import kntr.app.im.chat.module.NotifyTitleModuleTransformerModule;
import kntr.app.im.chat.module.PictureModuleTransformerModule;
import kntr.app.im.chat.module.PushAdditionalMsgModuleTransformerModule;
import kntr.app.im.chat.module.PushArticleModuleTransformerModule;
import kntr.app.im.chat.module.PushPastWorksModuleTransformerModule;
import kntr.app.im.chat.module.PushVideoModuleTransformerModule;
import kntr.app.im.chat.module.ShareAppletModuleTransformerModule;
import kntr.app.im.chat.module.ShareArticleModuleTransformerModule;
import kntr.app.im.chat.module.ShareCommonModuleTransformerModule;
import kntr.app.im.chat.module.ShareDynamicForwardModuleTransformerModule;
import kntr.app.im.chat.module.ShareDynamicModuleTransformerModule;
import kntr.app.im.chat.module.ShareTypeModuleTransformerModule;
import kntr.app.im.chat.module.ShareVideoModuleTransformerModule;
import kntr.app.im.chat.module.TextModuleTransformerModule;
import kntr.app.im.chat.module.localPicture.LocalPictureSerializerModule;
import kntr.app.im.chat.module.notifyText.HintTextModuleTransformerModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: MsgModuleTransformerSet.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/module/common/MsgModuleTransformerSet;", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {AuthorModuleTransformerModule.class, AutoReplyModuleTransformerModule.class, BannerImageModuleTransformerModule.class, NotifyDetailModuleTransformerModule.class, NotifyInteractiveModuleTransformerModule.class, NotifyTitleModuleTransformerModule.class, PictureModuleTransformerModule.class, PushAdditionalMsgModuleTransformerModule.class, PushArticleModuleTransformerModule.class, PushPastWorksModuleTransformerModule.class, PushVideoModuleTransformerModule.class, ShareAppletModuleTransformerModule.class, ShareArticleModuleTransformerModule.class, ShareCommonModuleTransformerModule.class, ShareDynamicForwardModuleTransformerModule.class, ShareDynamicModuleTransformerModule.class, ShareTypeModuleTransformerModule.class, ShareVideoModuleTransformerModule.class, TextModuleTransformerModule.class, HintTextModuleTransformerModule.class, LocalPictureSerializerModule.class, AiIntroduceModule.class, InvalidResourceModuleModule.class, NotifyGameModuleTransformerModule.class}, subcomponents = {})
public interface MsgModuleTransformerSet {
}