package kntr.app.im.chat.core.model;

import com.bapis.bilibili.app.im.v1.KChatInfoReply;
import com.bapis.bilibili.app.im.v1.KChatStickyModule;
import com.bapis.bilibili.app.im.v1.KUserTalkerInfo;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatInfoLens.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\",\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\",\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"0\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\",\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"*\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010#\u001a\u0004\b\u000b\u0010$\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010#\u001a\u0004\b\u000f\u0010$\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010#\u001a\u0004\b\u0013\u0010$\"F\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0001\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010#\u001a\u0004\b\u0018\u0010$\"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010#\u001a\u0004\b\u001c\u0010$\"@\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u001e0\u0001\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010#\u001a\u0004\b \u0010$\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\t0%\"\b\b\u0000\u0010!*\u00020\"*\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010#\u001a\u0004\b'\u0010(\"D\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010!*\u00020\"*\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010#\u001a\u0004\b*\u0010$\"D\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010!*\u00020\"*\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010#\u001a\u0004\b,\u0010$\"H\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150%\"\b\b\u0000\u0010!*\u00020\"*\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010#\u001a\u0004\b.\u0010(\"D\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010!*\u00020\"*\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010#\u001a\u0004\b0\u0010$\"B\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u001e0%\"\b\b\u0000\u0010!*\u00020\"*\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010#\u001a\u0004\b2\u0010(\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\t0%\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00103\u001a\u0004\b\u000b\u00104\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u00103\u001a\u0004\b\u000f\u00105\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u00103\u001a\u0004\b\u0013\u00105\"F\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150%\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u00103\u001a\u0004\b\u0018\u00104\"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H!\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u00103\u001a\u0004\b\u001c\u00105\"@\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u001e0%\"\b\b\u0000\u0010!*\u00020\"*\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u00103\u001a\u0004\b \u00104¨\u00066"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/core/model/ChatInfo;", "Lkntr/app/im/chat/core/model/ChatInfo$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/core/model/ChatInfo$Companion;)V", "getLens", "(Lkntr/app/im/chat/core/model/ChatInfo$Companion;)Lcom/bilibili/blens/BSimpleLens;", "reply", "Lcom/bapis/bilibili/app/im/v1/KChatInfoReply;", "getReply$annotations", "getReply", "navigationBar", "Lkntr/app/im/chat/core/model/NavigationBar;", "getNavigationBar$annotations", "getNavigationBar", "inputBoxConfig", "Lkntr/app/im/chat/core/model/InputBoxConfig;", "getInputBoxConfig$annotations", "getInputBoxConfig", "userTalkerInfos", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/im/v1/KUserTalkerInfo;", "getUserTalkerInfos$annotations", "getUserTalkerInfos", "stickyModule", "Lcom/bapis/bilibili/app/im/v1/KChatStickyModule;", "getStickyModule$annotations", "getStickyModule", "backgroundImg", RoomRecommendViewModel.EMPTY_CURSOR, "getBackgroundImg$annotations", "getBackgroundImg", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "replyNullable$annotations", "replyNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "navigationBarNullable$annotations", "navigationBarNullable", "inputBoxConfigNullable$annotations", "inputBoxConfigNullable", "userTalkerInfosNullable$annotations", "userTalkerInfosNullable", "stickyModuleNullable$annotations", "stickyModuleNullable", "backgroundImgNullable$annotations", "backgroundImgNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatInfoLensKt {
    public static /* synthetic */ void backgroundImgNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getBackgroundImg$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getBackgroundImg$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getBackgroundImg$annotations(ChatInfo.Companion companion) {
    }

    public static /* synthetic */ void getInputBoxConfig$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInputBoxConfig$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInputBoxConfig$annotations(ChatInfo.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(ChatInfo.Companion companion) {
    }

    public static /* synthetic */ void getNavigationBar$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getNavigationBar$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getNavigationBar$annotations(ChatInfo.Companion companion) {
    }

    public static /* synthetic */ void getReply$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getReply$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getReply$annotations(ChatInfo.Companion companion) {
    }

    public static /* synthetic */ void getStickyModule$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStickyModule$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStickyModule$annotations(ChatInfo.Companion companion) {
    }

    public static /* synthetic */ void getUserTalkerInfos$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUserTalkerInfos$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUserTalkerInfos$annotations(ChatInfo.Companion companion) {
    }

    public static /* synthetic */ void inputBoxConfigNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void navigationBarNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void replyNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void stickyModuleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void userTalkerInfosNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<ChatInfo, ChatInfo> getLens(ChatInfo.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatInfo, ChatInfo>() { // from class: kntr.app.im.chat.core.model.ChatInfoLensKt$special$$inlined$invoke$1
            public ChatInfo get(ChatInfo chatInfo) {
                ChatInfo it = chatInfo;
                return it;
            }

            public ChatInfo set(ChatInfo chatInfo, ChatInfo chatInfo2) {
                ChatInfo it = chatInfo2;
                return it;
            }

            public ChatInfo modify(ChatInfo chatInfo, Function1<? super ChatInfo, ? extends ChatInfo> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatInfo it = chatInfo;
                return (ChatInfo) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<ChatInfo, KChatInfoReply> getReply(ChatInfo.Companion $this$reply) {
        Intrinsics.checkNotNullParameter($this$reply, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatInfo, KChatInfoReply>() { // from class: kntr.app.im.chat.core.model.ChatInfoLensKt$special$$inlined$invoke$2
            public KChatInfoReply get(ChatInfo chatInfo) {
                ChatInfo it = chatInfo;
                return it.getReply();
            }

            public ChatInfo set(ChatInfo chatInfo, KChatInfoReply kChatInfoReply) {
                KChatInfoReply reply = kChatInfoReply;
                ChatInfo it = chatInfo;
                return ChatInfo.copy$default(it, reply, null, null, null, null, null, 62, null);
            }

            public ChatInfo modify(ChatInfo chatInfo, Function1<? super KChatInfoReply, ? extends KChatInfoReply> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatInfo it = chatInfo;
                KChatInfoReply reply = (KChatInfoReply) function1.invoke(it.getReply());
                ChatInfo it2 = chatInfo;
                return ChatInfo.copy$default(it2, reply, null, null, null, null, null, 62, null);
            }
        };
    }

    public static final BSimpleLens<ChatInfo, NavigationBar> getNavigationBar(ChatInfo.Companion $this$navigationBar) {
        Intrinsics.checkNotNullParameter($this$navigationBar, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatInfo, NavigationBar>() { // from class: kntr.app.im.chat.core.model.ChatInfoLensKt$special$$inlined$invoke$3
            public NavigationBar get(ChatInfo chatInfo) {
                ChatInfo it = chatInfo;
                return it.getNavigationBar();
            }

            public ChatInfo set(ChatInfo chatInfo, NavigationBar navigationBar) {
                NavigationBar navigationBar2 = navigationBar;
                ChatInfo it = chatInfo;
                return ChatInfo.copy$default(it, null, navigationBar2, null, null, null, null, 61, null);
            }

            public ChatInfo modify(ChatInfo chatInfo, Function1<? super NavigationBar, ? extends NavigationBar> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatInfo it = chatInfo;
                NavigationBar navigationBar = (NavigationBar) function1.invoke(it.getNavigationBar());
                ChatInfo it2 = chatInfo;
                return ChatInfo.copy$default(it2, null, navigationBar, null, null, null, null, 61, null);
            }
        };
    }

    public static final BSimpleLens<ChatInfo, InputBoxConfig> getInputBoxConfig(ChatInfo.Companion $this$inputBoxConfig) {
        Intrinsics.checkNotNullParameter($this$inputBoxConfig, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatInfo, InputBoxConfig>() { // from class: kntr.app.im.chat.core.model.ChatInfoLensKt$special$$inlined$invoke$4
            public InputBoxConfig get(ChatInfo chatInfo) {
                ChatInfo it = chatInfo;
                return it.getInputBoxConfig();
            }

            public ChatInfo set(ChatInfo chatInfo, InputBoxConfig inputBoxConfig) {
                InputBoxConfig inputBoxConfig2 = inputBoxConfig;
                ChatInfo it = chatInfo;
                return ChatInfo.copy$default(it, null, null, inputBoxConfig2, null, null, null, 59, null);
            }

            public ChatInfo modify(ChatInfo chatInfo, Function1<? super InputBoxConfig, ? extends InputBoxConfig> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatInfo it = chatInfo;
                InputBoxConfig inputBoxConfig = (InputBoxConfig) function1.invoke(it.getInputBoxConfig());
                ChatInfo it2 = chatInfo;
                return ChatInfo.copy$default(it2, null, null, inputBoxConfig, null, null, null, 59, null);
            }
        };
    }

    public static final BSimpleLens<ChatInfo, List<KUserTalkerInfo>> getUserTalkerInfos(ChatInfo.Companion $this$userTalkerInfos) {
        Intrinsics.checkNotNullParameter($this$userTalkerInfos, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatInfo, List<? extends KUserTalkerInfo>>() { // from class: kntr.app.im.chat.core.model.ChatInfoLensKt$special$$inlined$invoke$5
            public List<? extends KUserTalkerInfo> get(ChatInfo chatInfo) {
                ChatInfo it = chatInfo;
                return it.getUserTalkerInfos();
            }

            public ChatInfo set(ChatInfo chatInfo, List<? extends KUserTalkerInfo> list) {
                List<? extends KUserTalkerInfo> userTalkerInfos = list;
                ChatInfo it = chatInfo;
                return ChatInfo.copy$default(it, null, null, null, userTalkerInfos, null, null, 55, null);
            }

            public ChatInfo modify(ChatInfo chatInfo, Function1<? super List<? extends KUserTalkerInfo>, ? extends List<? extends KUserTalkerInfo>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatInfo it = chatInfo;
                List userTalkerInfos = (List) function1.invoke(it.getUserTalkerInfos());
                ChatInfo it2 = chatInfo;
                return ChatInfo.copy$default(it2, null, null, null, userTalkerInfos, null, null, 55, null);
            }
        };
    }

    public static final BSimpleLens<ChatInfo, KChatStickyModule> getStickyModule(ChatInfo.Companion $this$stickyModule) {
        Intrinsics.checkNotNullParameter($this$stickyModule, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatInfo, KChatStickyModule>() { // from class: kntr.app.im.chat.core.model.ChatInfoLensKt$special$$inlined$invoke$6
            public KChatStickyModule get(ChatInfo chatInfo) {
                ChatInfo it = chatInfo;
                return it.getStickyModule();
            }

            public ChatInfo set(ChatInfo chatInfo, KChatStickyModule kChatStickyModule) {
                KChatStickyModule stickyModule = kChatStickyModule;
                ChatInfo it = chatInfo;
                return ChatInfo.copy$default(it, null, null, null, null, stickyModule, null, 47, null);
            }

            public ChatInfo modify(ChatInfo chatInfo, Function1<? super KChatStickyModule, ? extends KChatStickyModule> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatInfo it = chatInfo;
                KChatStickyModule stickyModule = (KChatStickyModule) function1.invoke(it.getStickyModule());
                ChatInfo it2 = chatInfo;
                return ChatInfo.copy$default(it2, null, null, null, null, stickyModule, null, 47, null);
            }
        };
    }

    public static final BSimpleLens<ChatInfo, String> getBackgroundImg(ChatInfo.Companion $this$backgroundImg) {
        Intrinsics.checkNotNullParameter($this$backgroundImg, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatInfo, String>() { // from class: kntr.app.im.chat.core.model.ChatInfoLensKt$special$$inlined$invoke$7
            public String get(ChatInfo chatInfo) {
                ChatInfo it = chatInfo;
                return it.getBackgroundImg();
            }

            public ChatInfo set(ChatInfo chatInfo, String str) {
                String backgroundImg = str;
                ChatInfo it = chatInfo;
                return ChatInfo.copy$default(it, null, null, null, null, null, backgroundImg, 31, null);
            }

            public ChatInfo modify(ChatInfo chatInfo, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatInfo it = chatInfo;
                String backgroundImg = (String) function1.invoke(it.getBackgroundImg());
                ChatInfo it2 = chatInfo;
                return ChatInfo.copy$default(it2, null, null, null, null, null, backgroundImg, 31, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, KChatInfoReply> getReply(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getReply(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, NavigationBar> getNavigationBar(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getNavigationBar(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, InputBoxConfig> getInputBoxConfig(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getInputBoxConfig(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, List<KUserTalkerInfo>> getUserTalkerInfos(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getUserTalkerInfos(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, KChatStickyModule> getStickyModule(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getStickyModule(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, String> getBackgroundImg(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getBackgroundImg(ChatInfo.Companion));
    }

    public static final <T> BNullableLens<T, KChatInfoReply> replyNullable(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getReply(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, NavigationBar> navigationBarNullable(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getNavigationBar(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, InputBoxConfig> inputBoxConfigNullable(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getInputBoxConfig(ChatInfo.Companion));
    }

    public static final <T> BNullableLens<T, List<KUserTalkerInfo>> userTalkerInfosNullable(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getUserTalkerInfos(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, KChatStickyModule> stickyModuleNullable(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getStickyModule(ChatInfo.Companion));
    }

    public static final <T> BNullableLens<T, String> backgroundImgNullable(BSimpleLens<T, ChatInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getBackgroundImg(ChatInfo.Companion));
    }

    public static final <T> BNullableLens<T, KChatInfoReply> getReply(BNullableLens<T, ChatInfo> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getReply(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, NavigationBar> getNavigationBar(BNullableLens<T, ChatInfo> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getNavigationBar(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, InputBoxConfig> getInputBoxConfig(BNullableLens<T, ChatInfo> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getInputBoxConfig(ChatInfo.Companion));
    }

    public static final <T> BNullableLens<T, List<KUserTalkerInfo>> getUserTalkerInfos(BNullableLens<T, ChatInfo> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getUserTalkerInfos(ChatInfo.Companion));
    }

    public static final <T> BSimpleLens<T, KChatStickyModule> getStickyModule(BNullableLens<T, ChatInfo> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getStickyModule(ChatInfo.Companion));
    }

    public static final <T> BNullableLens<T, String> getBackgroundImg(BNullableLens<T, ChatInfo> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getBackgroundImg(ChatInfo.Companion));
    }
}