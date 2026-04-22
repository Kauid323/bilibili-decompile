package kntr.app.im.chat.core.service;

import im.base.model.SessionId;
import kntr.app.im.base.SettingNotifyItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ConversationSettingNotifier.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/ConversationSettingNotifier;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lim/base/model/SessionId;", "getSessionId", "()Lim/base/model/SessionId;", "settingChangeFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/im/base/SettingNotifyItem$ChatSetting;", "getSettingChangeFlow", "()Lkotlinx/coroutines/flow/Flow;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationSettingNotifier {
    SessionId getSessionId();

    Flow<SettingNotifyItem.ChatSetting> getSettingChangeFlow();
}