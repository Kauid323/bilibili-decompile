package kntr.app.im.chat.di;

import dagger.Module;
import kntr.app.im.chat.db.di.ChatDatabaseModule;
import kntr.app.im.chat.di.module.common.ChatJsonModule;
import kntr.app.im.chat.di.module.common.ChatSendEventModule;
import kntr.app.im.chat.di.module.common.ChatSessionEntityModule;
import kntr.app.im.chat.di.module.common.ChatUploadModule;
import kntr.app.im.chat.di.module.common.CommonKSessionModule;
import kntr.app.im.chat.di.module.common.IMChatModule;
import kntr.app.im.chat.di.module.common.MsgFrameTransformerModule;
import kntr.app.im.chat.di.module.common.MsgModuleTransformerModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: CommonChatModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/CommonChatModule;", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {IMChatModule.class, ChatJsonModule.class, ChatDatabaseModule.class, ChatUploadModule.class, ChatSessionEntityModule.class, MsgFrameTransformerModule.class, MsgModuleTransformerModule.class, CommonKSessionModule.class, ChatSendEventModule.class})
public interface CommonChatModule {
}