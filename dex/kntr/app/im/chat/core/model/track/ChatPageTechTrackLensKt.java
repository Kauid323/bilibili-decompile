package kntr.app.im.chat.core.model.track;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.im.chat.core.model.track.ChatPageTechTrack;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: ChatPageTechTrackLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\",\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0019\u001a\u0004\b\u000b\u0010\u001a\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u000f\u0010\u001a\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u0012\u0010\u001a\"B\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0016\u0010\u001a\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\t0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001e\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\r0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001e\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\r0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001e\"D\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001a\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\t0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010%\u001a\u0004\b\u000b\u0010&\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\r0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010%\u001a\u0004\b\u000f\u0010&\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\r0\u001b\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010%\u001a\u0004\b\u0012\u0010&\"B\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0001\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010%\u001a\u0004\b\u0016\u0010'¨\u0006("}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/core/model/track/ChatPageTechTrack;", "Lkntr/app/im/chat/core/model/track/ChatPageTechTrack$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/core/model/track/ChatPageTechTrack$Companion;)V", "getLens", "(Lkntr/app/im/chat/core/model/track/ChatPageTechTrack$Companion;)Lcom/bilibili/blens/BSimpleLens;", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "getSessionType$annotations", "getSessionType", "chatInfoLoadStart", "Lkotlinx/datetime/Instant;", "getChatInfoLoadStart$annotations", "getChatInfoLoadStart", "chatInfoLoadEnd", "getChatInfoLoadEnd$annotations", "getChatInfoLoadEnd", "chatInfoError", RoomRecommendViewModel.EMPTY_CURSOR, "getChatInfoError$annotations", "getChatInfoError", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "sessionTypeNullable$annotations", "sessionTypeNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "chatInfoLoadStartNullable$annotations", "chatInfoLoadStartNullable", "chatInfoLoadEndNullable$annotations", "chatInfoLoadEndNullable", "chatInfoErrorNullable$annotations", "chatInfoErrorNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatPageTechTrackLensKt {
    public static /* synthetic */ void chatInfoErrorNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void chatInfoLoadEndNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void chatInfoLoadStartNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatInfoError$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getChatInfoError$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatInfoError$annotations(ChatPageTechTrack.Companion companion) {
    }

    public static /* synthetic */ void getChatInfoLoadEnd$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getChatInfoLoadEnd$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatInfoLoadEnd$annotations(ChatPageTechTrack.Companion companion) {
    }

    public static /* synthetic */ void getChatInfoLoadStart$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getChatInfoLoadStart$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatInfoLoadStart$annotations(ChatPageTechTrack.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(ChatPageTechTrack.Companion companion) {
    }

    public static /* synthetic */ void getSessionType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionType$annotations(ChatPageTechTrack.Companion companion) {
    }

    public static /* synthetic */ void sessionTypeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<ChatPageTechTrack, ChatPageTechTrack> getLens(ChatPageTechTrack.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageTechTrack, ChatPageTechTrack>() { // from class: kntr.app.im.chat.core.model.track.ChatPageTechTrackLensKt$special$$inlined$invoke$1
            public ChatPageTechTrack get(ChatPageTechTrack chatPageTechTrack) {
                ChatPageTechTrack it = chatPageTechTrack;
                return it;
            }

            public ChatPageTechTrack set(ChatPageTechTrack chatPageTechTrack, ChatPageTechTrack chatPageTechTrack2) {
                ChatPageTechTrack it = chatPageTechTrack2;
                return it;
            }

            public ChatPageTechTrack modify(ChatPageTechTrack chatPageTechTrack, Function1<? super ChatPageTechTrack, ? extends ChatPageTechTrack> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageTechTrack it = chatPageTechTrack;
                return (ChatPageTechTrack) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<ChatPageTechTrack, String> getSessionType(ChatPageTechTrack.Companion $this$sessionType) {
        Intrinsics.checkNotNullParameter($this$sessionType, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageTechTrack, String>() { // from class: kntr.app.im.chat.core.model.track.ChatPageTechTrackLensKt$special$$inlined$invoke$2
            public String get(ChatPageTechTrack chatPageTechTrack) {
                ChatPageTechTrack it = chatPageTechTrack;
                return it.getSessionType();
            }

            public ChatPageTechTrack set(ChatPageTechTrack chatPageTechTrack, String str) {
                String sessionType = str;
                ChatPageTechTrack it = chatPageTechTrack;
                return ChatPageTechTrack.copy$default(it, sessionType, null, null, null, 14, null);
            }

            public ChatPageTechTrack modify(ChatPageTechTrack chatPageTechTrack, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageTechTrack it = chatPageTechTrack;
                String sessionType = (String) function1.invoke(it.getSessionType());
                ChatPageTechTrack it2 = chatPageTechTrack;
                return ChatPageTechTrack.copy$default(it2, sessionType, null, null, null, 14, null);
            }
        };
    }

    public static final BSimpleLens<ChatPageTechTrack, Instant> getChatInfoLoadStart(ChatPageTechTrack.Companion $this$chatInfoLoadStart) {
        Intrinsics.checkNotNullParameter($this$chatInfoLoadStart, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageTechTrack, Instant>() { // from class: kntr.app.im.chat.core.model.track.ChatPageTechTrackLensKt$special$$inlined$invoke$3
            public Instant get(ChatPageTechTrack chatPageTechTrack) {
                ChatPageTechTrack it = chatPageTechTrack;
                return it.getChatInfoLoadStart();
            }

            public ChatPageTechTrack set(ChatPageTechTrack chatPageTechTrack, Instant instant) {
                Instant chatInfoLoadStart = instant;
                ChatPageTechTrack it = chatPageTechTrack;
                return ChatPageTechTrack.copy$default(it, null, chatInfoLoadStart, null, null, 13, null);
            }

            public ChatPageTechTrack modify(ChatPageTechTrack chatPageTechTrack, Function1<? super Instant, ? extends Instant> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageTechTrack it = chatPageTechTrack;
                Instant chatInfoLoadStart = (Instant) function1.invoke(it.getChatInfoLoadStart());
                ChatPageTechTrack it2 = chatPageTechTrack;
                return ChatPageTechTrack.copy$default(it2, null, chatInfoLoadStart, null, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<ChatPageTechTrack, Instant> getChatInfoLoadEnd(ChatPageTechTrack.Companion $this$chatInfoLoadEnd) {
        Intrinsics.checkNotNullParameter($this$chatInfoLoadEnd, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageTechTrack, Instant>() { // from class: kntr.app.im.chat.core.model.track.ChatPageTechTrackLensKt$special$$inlined$invoke$4
            public Instant get(ChatPageTechTrack chatPageTechTrack) {
                ChatPageTechTrack it = chatPageTechTrack;
                return it.getChatInfoLoadEnd();
            }

            public ChatPageTechTrack set(ChatPageTechTrack chatPageTechTrack, Instant instant) {
                Instant chatInfoLoadEnd = instant;
                ChatPageTechTrack it = chatPageTechTrack;
                return ChatPageTechTrack.copy$default(it, null, null, chatInfoLoadEnd, null, 11, null);
            }

            public ChatPageTechTrack modify(ChatPageTechTrack chatPageTechTrack, Function1<? super Instant, ? extends Instant> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageTechTrack it = chatPageTechTrack;
                Instant chatInfoLoadEnd = (Instant) function1.invoke(it.getChatInfoLoadEnd());
                ChatPageTechTrack it2 = chatPageTechTrack;
                return ChatPageTechTrack.copy$default(it2, null, null, chatInfoLoadEnd, null, 11, null);
            }
        };
    }

    public static final BSimpleLens<ChatPageTechTrack, Throwable> getChatInfoError(ChatPageTechTrack.Companion $this$chatInfoError) {
        Intrinsics.checkNotNullParameter($this$chatInfoError, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<ChatPageTechTrack, Throwable>() { // from class: kntr.app.im.chat.core.model.track.ChatPageTechTrackLensKt$special$$inlined$invoke$5
            public Throwable get(ChatPageTechTrack chatPageTechTrack) {
                ChatPageTechTrack it = chatPageTechTrack;
                return it.getChatInfoError();
            }

            public ChatPageTechTrack set(ChatPageTechTrack chatPageTechTrack, Throwable th) {
                Throwable chatInfoError = th;
                ChatPageTechTrack it = chatPageTechTrack;
                return ChatPageTechTrack.copy$default(it, null, null, null, chatInfoError, 7, null);
            }

            public ChatPageTechTrack modify(ChatPageTechTrack chatPageTechTrack, Function1<? super Throwable, ? extends Throwable> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                ChatPageTechTrack it = chatPageTechTrack;
                Throwable chatInfoError = (Throwable) function1.invoke(it.getChatInfoError());
                ChatPageTechTrack it2 = chatPageTechTrack;
                return ChatPageTechTrack.copy$default(it2, null, null, null, chatInfoError, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getSessionType(BSimpleLens<T, ChatPageTechTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionType(ChatPageTechTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getChatInfoLoadStart(BSimpleLens<T, ChatPageTechTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getChatInfoLoadStart(ChatPageTechTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Instant> getChatInfoLoadEnd(BSimpleLens<T, ChatPageTechTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getChatInfoLoadEnd(ChatPageTechTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getChatInfoError(BSimpleLens<T, ChatPageTechTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getChatInfoError(ChatPageTechTrack.Companion));
    }

    public static final <T> BNullableLens<T, String> sessionTypeNullable(BSimpleLens<T, ChatPageTechTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionType(ChatPageTechTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> chatInfoLoadStartNullable(BSimpleLens<T, ChatPageTechTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getChatInfoLoadStart(ChatPageTechTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> chatInfoLoadEndNullable(BSimpleLens<T, ChatPageTechTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getChatInfoLoadEnd(ChatPageTechTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> chatInfoErrorNullable(BSimpleLens<T, ChatPageTechTrack> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getChatInfoError(ChatPageTechTrack.Companion));
    }

    public static final <T> BNullableLens<T, String> getSessionType(BNullableLens<T, ChatPageTechTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionType(ChatPageTechTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getChatInfoLoadStart(BNullableLens<T, ChatPageTechTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getChatInfoLoadStart(ChatPageTechTrack.Companion));
    }

    public static final <T> BNullableLens<T, Instant> getChatInfoLoadEnd(BNullableLens<T, ChatPageTechTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getChatInfoLoadEnd(ChatPageTechTrack.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getChatInfoError(BNullableLens<T, ChatPageTechTrack> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getChatInfoError(ChatPageTechTrack.Companion));
    }
}