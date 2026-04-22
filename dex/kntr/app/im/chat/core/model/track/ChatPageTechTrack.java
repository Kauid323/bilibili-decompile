package kntr.app.im.chat.core.model.track;

import com.bilibili.blens.Lens;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlinx.datetime.Instant;

/* compiled from: ChatPageTechTrack.kt */
@Lens
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lkntr/app/im/chat/core/model/track/ChatPageTechTrack;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "chatInfoLoadStart", "Lkotlinx/datetime/Instant;", "chatInfoLoadEnd", "chatInfoError", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Ljava/lang/Throwable;)V", "getSessionType", "()Ljava/lang/String;", "getChatInfoLoadStart", "()Lkotlinx/datetime/Instant;", "getChatInfoLoadEnd", "getChatInfoError", "()Ljava/lang/Throwable;", "buildReportMap", RoomRecommendViewModel.EMPTY_CURSOR, "readyToReport", RoomRecommendViewModel.EMPTY_CURSOR, "getReadyToReport", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatPageTechTrack {
    private final Throwable chatInfoError;
    private final Instant chatInfoLoadEnd;
    private final Instant chatInfoLoadStart;
    private final String sessionType;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ ChatPageTechTrack copy$default(ChatPageTechTrack chatPageTechTrack, String str, Instant instant, Instant instant2, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatPageTechTrack.sessionType;
        }
        if ((i & 2) != 0) {
            instant = chatPageTechTrack.chatInfoLoadStart;
        }
        if ((i & 4) != 0) {
            instant2 = chatPageTechTrack.chatInfoLoadEnd;
        }
        if ((i & 8) != 0) {
            th = chatPageTechTrack.chatInfoError;
        }
        return chatPageTechTrack.copy(str, instant, instant2, th);
    }

    public final String component1() {
        return this.sessionType;
    }

    public final Instant component2() {
        return this.chatInfoLoadStart;
    }

    public final Instant component3() {
        return this.chatInfoLoadEnd;
    }

    public final Throwable component4() {
        return this.chatInfoError;
    }

    public final ChatPageTechTrack copy(String str, Instant instant, Instant instant2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "sessionType");
        Intrinsics.checkNotNullParameter(instant, "chatInfoLoadStart");
        Intrinsics.checkNotNullParameter(instant2, "chatInfoLoadEnd");
        return new ChatPageTechTrack(str, instant, instant2, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatPageTechTrack) {
            ChatPageTechTrack chatPageTechTrack = (ChatPageTechTrack) obj;
            return Intrinsics.areEqual(this.sessionType, chatPageTechTrack.sessionType) && Intrinsics.areEqual(this.chatInfoLoadStart, chatPageTechTrack.chatInfoLoadStart) && Intrinsics.areEqual(this.chatInfoLoadEnd, chatPageTechTrack.chatInfoLoadEnd) && Intrinsics.areEqual(this.chatInfoError, chatPageTechTrack.chatInfoError);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.sessionType.hashCode() * 31) + this.chatInfoLoadStart.hashCode()) * 31) + this.chatInfoLoadEnd.hashCode()) * 31) + (this.chatInfoError == null ? 0 : this.chatInfoError.hashCode());
    }

    public String toString() {
        String str = this.sessionType;
        Instant instant = this.chatInfoLoadStart;
        Instant instant2 = this.chatInfoLoadEnd;
        return "ChatPageTechTrack(sessionType=" + str + ", chatInfoLoadStart=" + instant + ", chatInfoLoadEnd=" + instant2 + ", chatInfoError=" + this.chatInfoError + ")";
    }

    public ChatPageTechTrack(String sessionType, Instant chatInfoLoadStart, Instant chatInfoLoadEnd, Throwable chatInfoError) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(chatInfoLoadStart, "chatInfoLoadStart");
        Intrinsics.checkNotNullParameter(chatInfoLoadEnd, "chatInfoLoadEnd");
        this.sessionType = sessionType;
        this.chatInfoLoadStart = chatInfoLoadStart;
        this.chatInfoLoadEnd = chatInfoLoadEnd;
        this.chatInfoError = chatInfoError;
    }

    public /* synthetic */ ChatPageTechTrack(String str, Instant instant, Instant instant2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Instant.Companion.getDISTANT_PAST() : instant, (i & 4) != 0 ? Instant.Companion.getDISTANT_PAST() : instant2, (i & 8) != 0 ? null : th);
    }

    public final String getSessionType() {
        return this.sessionType;
    }

    public final Instant getChatInfoLoadStart() {
        return this.chatInfoLoadStart;
    }

    public final Instant getChatInfoLoadEnd() {
        return this.chatInfoLoadEnd;
    }

    public final Throwable getChatInfoError() {
        return this.chatInfoError;
    }

    /* compiled from: ChatPageTechTrack.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/core/model/track/ChatPageTechTrack$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Map<String, String> buildReportMap() {
        Map map = new LinkedHashMap();
        map.put("session_type", this.sessionType);
        map.put("chat_info_load_time_ms", String.valueOf(Duration.getInWholeMilliseconds-impl(this.chatInfoLoadEnd.minus-5sfh64U(this.chatInfoLoadStart))));
        Throwable it = this.chatInfoError;
        if (it != null) {
            String simpleName = Reflection.getOrCreateKotlinClass(it.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "UnknownError";
            }
            map.put("chat_info_error_type", simpleName);
            String message = it.getMessage();
            if (message == null) {
                message = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            map.put("chat_info_error_message", message);
        }
        return map;
    }

    public final boolean getReadyToReport() {
        return !Intrinsics.areEqual(this.chatInfoLoadEnd, Instant.Companion.getDISTANT_PAST());
    }
}