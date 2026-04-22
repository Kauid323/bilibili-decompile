package im.session.base;

import im.base.IMLog;
import im.base.config.IMConfigSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMConversationDraftService.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0006"}, d2 = {"provideDraftService", "Lim/session/base/IMConversationDraftService;", "imConfigSetting", "Lim/base/config/IMConfigSetting;", "bffService", "nativeService", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMConversationDraftServiceKt {
    @IMSessionDraftService
    public static final IMConversationDraftService provideDraftService(IMConfigSetting imConfigSetting, @IMBffSessionDraftService IMConversationDraftService bffService, @IMNativeSessionDraftService IMConversationDraftService nativeService) {
        Intrinsics.checkNotNullParameter(imConfigSetting, "imConfigSetting");
        Intrinsics.checkNotNullParameter(bffService, "bffService");
        IMLog.Companion.i("IMSessionDraftService", "provideDraftService: bffChatEnabled=" + imConfigSetting.getBffChatEnabled() + ", nativeService=" + (nativeService != null));
        if (imConfigSetting.getBffChatEnabled() || nativeService == null) {
            return bffService;
        }
        return nativeService;
    }
}