package kntr.app.im.chat.di.module.common;

import dagger.Module;
import kntr.app.im.chat.frame.bubble.ChatBubbleFrameModule;
import kntr.app.im.chat.frame.hint.SystemHintModule;
import kntr.app.im.chat.frame.nil.NilFrameModule;
import kntr.app.im.chat.frame.push.PushEmptyFrameModule;
import kntr.app.im.chat.frame.rounded.RoundedCornerFrameModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: MsgFrameModuleSet.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/module/common/MsgFrameModuleSet;", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {ChatBubbleFrameModule.class, PushEmptyFrameModule.class, RoundedCornerFrameModule.class, SystemHintModule.class, NilFrameModule.class}, subcomponents = {})
public interface MsgFrameModuleSet {
}