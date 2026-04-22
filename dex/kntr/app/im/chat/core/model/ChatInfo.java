package kntr.app.im.chat.core.model;

import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bapis.bilibili.app.im.v1.KBizInfo;
import com.bapis.bilibili.app.im.v1.KChatHintMessages;
import com.bapis.bilibili.app.im.v1.KChatInfoReply;
import com.bapis.bilibili.app.im.v1.KChatStickyModule;
import com.bapis.bilibili.app.im.v1.KInputBox;
import com.bapis.bilibili.app.im.v1.KNavButton;
import com.bapis.bilibili.app.im.v1.KSessionTag;
import com.bapis.bilibili.app.im.v1.KUserTalkerInfo;
import com.bilibili.blens.Lens;
import java.util.List;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ChatInfo.kt */
@Lens
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001.BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003JQ\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lkntr/app/im/chat/core/model/ChatInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "reply", "Lcom/bapis/bilibili/app/im/v1/KChatInfoReply;", "navigationBar", "Lkntr/app/im/chat/core/model/NavigationBar;", "inputBoxConfig", "Lkntr/app/im/chat/core/model/InputBoxConfig;", "userTalkerInfos", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/im/v1/KUserTalkerInfo;", "stickyModule", "Lcom/bapis/bilibili/app/im/v1/KChatStickyModule;", "backgroundImg", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bapis/bilibili/app/im/v1/KChatInfoReply;Lkntr/app/im/chat/core/model/NavigationBar;Lkntr/app/im/chat/core/model/InputBoxConfig;Ljava/util/List;Lcom/bapis/bilibili/app/im/v1/KChatStickyModule;Ljava/lang/String;)V", "getReply", "()Lcom/bapis/bilibili/app/im/v1/KChatInfoReply;", "getNavigationBar", "()Lkntr/app/im/chat/core/model/NavigationBar;", "getInputBoxConfig", "()Lkntr/app/im/chat/core/model/InputBoxConfig;", "getUserTalkerInfos", "()Ljava/util/List;", "getStickyModule", "()Lcom/bapis/bilibili/app/im/v1/KChatStickyModule;", "getBackgroundImg", "()Ljava/lang/String;", "hintMessages", "Lcom/bapis/bilibili/app/im/v1/KChatHintMessages;", "getHintMessages", "()Lcom/bapis/bilibili/app/im/v1/KChatHintMessages;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String backgroundImg;
    private final KChatHintMessages hintMessages;
    private final InputBoxConfig inputBoxConfig;
    private final NavigationBar navigationBar;
    private final KChatInfoReply reply;
    private final KChatStickyModule stickyModule;
    private final List<KUserTalkerInfo> userTalkerInfos;

    public ChatInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ChatInfo copy$default(ChatInfo chatInfo, KChatInfoReply kChatInfoReply, NavigationBar navigationBar, InputBoxConfig inputBoxConfig, List list, KChatStickyModule kChatStickyModule, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            kChatInfoReply = chatInfo.reply;
        }
        if ((i & 2) != 0) {
            navigationBar = chatInfo.navigationBar;
        }
        NavigationBar navigationBar2 = navigationBar;
        if ((i & 4) != 0) {
            inputBoxConfig = chatInfo.inputBoxConfig;
        }
        InputBoxConfig inputBoxConfig2 = inputBoxConfig;
        List<KUserTalkerInfo> list2 = list;
        if ((i & 8) != 0) {
            list2 = chatInfo.userTalkerInfos;
        }
        List list3 = list2;
        if ((i & 16) != 0) {
            kChatStickyModule = chatInfo.stickyModule;
        }
        KChatStickyModule kChatStickyModule2 = kChatStickyModule;
        if ((i & 32) != 0) {
            str = chatInfo.backgroundImg;
        }
        return chatInfo.copy(kChatInfoReply, navigationBar2, inputBoxConfig2, list3, kChatStickyModule2, str);
    }

    public final KChatInfoReply component1() {
        return this.reply;
    }

    public final NavigationBar component2() {
        return this.navigationBar;
    }

    public final InputBoxConfig component3() {
        return this.inputBoxConfig;
    }

    public final List<KUserTalkerInfo> component4() {
        return this.userTalkerInfos;
    }

    public final KChatStickyModule component5() {
        return this.stickyModule;
    }

    public final String component6() {
        return this.backgroundImg;
    }

    public final ChatInfo copy(KChatInfoReply kChatInfoReply, NavigationBar navigationBar, InputBoxConfig inputBoxConfig, List<KUserTalkerInfo> list, KChatStickyModule kChatStickyModule, String str) {
        Intrinsics.checkNotNullParameter(kChatInfoReply, "reply");
        Intrinsics.checkNotNullParameter(list, "userTalkerInfos");
        Intrinsics.checkNotNullParameter(str, "backgroundImg");
        return new ChatInfo(kChatInfoReply, navigationBar, inputBoxConfig, list, kChatStickyModule, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatInfo) {
            ChatInfo chatInfo = (ChatInfo) obj;
            return Intrinsics.areEqual(this.reply, chatInfo.reply) && Intrinsics.areEqual(this.navigationBar, chatInfo.navigationBar) && Intrinsics.areEqual(this.inputBoxConfig, chatInfo.inputBoxConfig) && Intrinsics.areEqual(this.userTalkerInfos, chatInfo.userTalkerInfos) && Intrinsics.areEqual(this.stickyModule, chatInfo.stickyModule) && Intrinsics.areEqual(this.backgroundImg, chatInfo.backgroundImg);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.reply.hashCode() * 31) + (this.navigationBar == null ? 0 : this.navigationBar.hashCode())) * 31) + (this.inputBoxConfig == null ? 0 : this.inputBoxConfig.hashCode())) * 31) + this.userTalkerInfos.hashCode()) * 31) + (this.stickyModule != null ? this.stickyModule.hashCode() : 0)) * 31) + this.backgroundImg.hashCode();
    }

    public String toString() {
        KChatInfoReply kChatInfoReply = this.reply;
        NavigationBar navigationBar = this.navigationBar;
        InputBoxConfig inputBoxConfig = this.inputBoxConfig;
        List<KUserTalkerInfo> list = this.userTalkerInfos;
        KChatStickyModule kChatStickyModule = this.stickyModule;
        return "ChatInfo(reply=" + kChatInfoReply + ", navigationBar=" + navigationBar + ", inputBoxConfig=" + inputBoxConfig + ", userTalkerInfos=" + list + ", stickyModule=" + kChatStickyModule + ", backgroundImg=" + this.backgroundImg + ")";
    }

    public ChatInfo(KChatInfoReply reply, NavigationBar navigationBar, InputBoxConfig inputBoxConfig, List<KUserTalkerInfo> list, KChatStickyModule stickyModule, String backgroundImg) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(list, "userTalkerInfos");
        Intrinsics.checkNotNullParameter(backgroundImg, "backgroundImg");
        this.reply = reply;
        this.navigationBar = navigationBar;
        this.inputBoxConfig = inputBoxConfig;
        this.userTalkerInfos = list;
        this.stickyModule = stickyModule;
        this.backgroundImg = backgroundImg;
        this.hintMessages = this.reply.getChatHintMessages();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ChatInfo(KChatInfoReply kChatInfoReply, NavigationBar navigationBar, InputBoxConfig inputBoxConfig, List list, KChatStickyModule kChatStickyModule, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r0, (i & 2) != 0 ? Companion.navigationBar(r0) : navigationBar, (i & 4) != 0 ? Companion.inputBox(r0) : inputBoxConfig, (i & 8) != 0 ? r0.getTalkerInfos() : list, (i & 16) != 0 ? r0.getStickyModule() : kChatStickyModule, (i & 32) != 0 ? r0.getBackgroundImg() : str);
        KChatInfoReply kChatInfoReply2 = (i & 1) != 0 ? new KChatInfoReply((String) null, (KSessionTag) null, (KNavButton) null, (KInputBox) null, (List) null, (String) null, (KBizInfo) null, (KChatStickyModule) null, (Map) null, (KBehaviorAlertToast) null, (KChatHintMessages) null, (String) null, 4095, (DefaultConstructorMarker) null) : kChatInfoReply;
    }

    public final KChatInfoReply getReply() {
        return this.reply;
    }

    public final NavigationBar getNavigationBar() {
        return this.navigationBar;
    }

    public final InputBoxConfig getInputBoxConfig() {
        return this.inputBoxConfig;
    }

    public final List<KUserTalkerInfo> getUserTalkerInfos() {
        return this.userTalkerInfos;
    }

    public final KChatStickyModule getStickyModule() {
        return this.stickyModule;
    }

    public final String getBackgroundImg() {
        return this.backgroundImg;
    }

    /* compiled from: ChatInfo.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/core/model/ChatInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "navigationBar", "Lkntr/app/im/chat/core/model/NavigationBar;", "Lcom/bapis/bilibili/app/im/v1/KChatInfoReply;", "inputBox", "Lkntr/app/im/chat/core/model/InputBoxConfig;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final NavigationBar navigationBar(KChatInfoReply $this$navigationBar) {
            return new NavigationBar($this$navigationBar.getSessionName(), $this$navigationBar.getSessionHandle(), $this$navigationBar.getSessionTag(), $this$navigationBar.getNavButton());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final InputBoxConfig inputBox(KChatInfoReply $this$inputBox) {
            KInputBox it = $this$inputBox.getInputBox();
            String str = null;
            if (it != null) {
                String hint = it.getHint();
                if (!StringsKt.isBlank(hint)) {
                    str = hint;
                }
                return new InputBoxConfig(str, it.getEnablePic(), it.getEnableVideo(), it.getEnableSticker());
            }
            return null;
        }
    }

    public final KChatHintMessages getHintMessages() {
        return this.hintMessages;
    }
}