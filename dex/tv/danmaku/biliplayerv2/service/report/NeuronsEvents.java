package tv.danmaku.biliplayerv2.service.report;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IReporterService.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\u0018\u0000 \u00042\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents;", "", "<init>", "()V", "Companion", "Event", "Start", "SeekStart", "SeekEnd", "Pause", "Resume", "Switch", "SwitchSpeed", "End", "NormalEvent", "NormalEventV2", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NeuronsEvents {
    public static final String END = "player.player.end.all.player";
    public static final String PAUSE = "player.player.pause.all.player";
    public static final String PLAYER_EVENT_EX_KEY_DM_SERVICE_SWITCH = "$dm_service_switch";
    public static final String PLAYER_EVENT_EX_KEY_IS_BACKGROUND = "$is_background_play";
    public static final String PLAYER_EVENT_EX_KEY_IS_LANGUAGE = "$cur_language";
    public static final String PLAYER_EVENT_EX_KEY_IS_LOCAL_VIDEO = "$is_local_video";
    public static final String PLAYER_EVENT_EX_KEY_IS_VERTICAL_VIDEO = "$player_is_vertical";
    public static final String PLAYER_EVENT_EX_KEY_SCENE = "$player_scene";
    public static final String PLAYER_EVENT_EX_KEY_SEQUENCE = "$player_event_seq";
    public static final String PLAYER_EVENT_EX_KEY_SPMID = "$playerSpmid";
    public static final String PLAYER_EVENT_EX_KEY_STATE = "$player_playback_state";
    public static final String QN_STRATEGY = "player.player.qn-strategy.0.player";
    public static final String RESUME = "player.player.resume.all.player";
    public static final String SEEK = "player.player.seek.all.player";
    public static final String START = "player.player.start.all.player";
    public static final String SWITCH = "player.player.switch.all.player";
    public static final String SWITCH_SPEED = "player.player.switch-speed.0.player";
    public static final Companion Companion = new Companion(null);
    private static final SparseArray<String> mAliveSessionIds = new SparseArray<>();

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Companion;", "", "<init>", "()V", "PLAYER_EVENT_EX_KEY_STATE", "", "PLAYER_EVENT_EX_KEY_SEQUENCE", "PLAYER_EVENT_EX_KEY_IS_BACKGROUND", "PLAYER_EVENT_EX_KEY_IS_LOCAL_VIDEO", "PLAYER_EVENT_EX_KEY_DM_SERVICE_SWITCH", "PLAYER_EVENT_EX_KEY_IS_VERTICAL_VIDEO", "PLAYER_EVENT_EX_KEY_IS_LANGUAGE", "PLAYER_EVENT_EX_KEY_SPMID", "PLAYER_EVENT_EX_KEY_SCENE", "START", "SEEK", "PAUSE", "RESUME", "SWITCH", "SWITCH_SPEED", "END", "QN_STRATEGY", "mAliveSessionIds", "Landroid/util/SparseArray;", "getSessionId", "playerContextHash", "", "clear", "", "createSessionId", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized String getSessionId(int playerContextHash) {
            String id;
            id = (String) NeuronsEvents.mAliveSessionIds.get(playerContextHash);
            if (id == null) {
                id = createSessionId();
                NeuronsEvents.mAliveSessionIds.put(playerContextHash, id);
            }
            return id;
        }

        public final synchronized void clear(int playerContextHash) {
            NeuronsEvents.mAliveSessionIds.remove(playerContextHash);
        }

        private final String createSessionId() {
            Random random = new Random();
            String randomStr = BuvidHelper.getBuvid() + System.currentTimeMillis() + random.nextInt(1000000);
            String sha1 = DigestUtils.signSHA1(randomStr);
            if (TextUtils.isEmpty(sha1)) {
                return randomStr;
            }
            Intrinsics.checkNotNull(sha1);
            return sha1;
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\b&\u0018\u00002\u00020\u0001B%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "", "event", "", "args", "", "<init>", "(Ljava/lang/String;[Ljava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "[Ljava/lang/String;", "dumpTo", "", "out", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Event {
        private final String[] args;
        private final String event;

        protected Event(String event, String... args) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(args, "args");
            this.event = event;
            this.args = args;
        }

        public final String getEvent() {
            return this.event;
        }

        public void dumpTo(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "out");
            for (int i = 0; this.args.length >= i + 2; i += 2) {
                map.put(this.args[i], this.args[i + 1]);
            }
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Start;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Start extends Event {
        public static final Start INSTANCE = new Start();

        private Start() {
            super(NeuronsEvents.START, new String[0]);
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$SeekStart;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SeekStart extends Event {
        public SeekStart() {
            super(NeuronsEvents.SEEK, "seek_type", "1");
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$SeekEnd;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SeekEnd extends Event {
        public SeekEnd() {
            super(NeuronsEvents.SEEK, "seek_type", "2");
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Pause;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Pause extends Event {
        public static final Pause INSTANCE = new Pause();

        private Pause() {
            super(NeuronsEvents.PAUSE, new String[0]);
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Resume;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Resume extends Event {
        public static final Resume INSTANCE = new Resume();

        private Resume() {
            super(NeuronsEvents.RESUME, new String[0]);
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Switch;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "type", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Switch$Type;", "extra", "", "", "<init>", "(Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Switch$Type;[Ljava/lang/String;)V", "[Ljava/lang/String;", "Type", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Switch extends Event {
        private final String[] extra;

        /* compiled from: IReporterService.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Switch$Type;", "", "typeCode", "", "<init>", "(Ljava/lang/String;II)V", "getTypeCode", "()I", "INLINE_PAGE", "PAGE_BACKGROUND", "BACKGROUND_PAGE", "HALF_FULL_SCREEN", "FULL_HALF_SCREEN", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public enum Type {
            INLINE_PAGE(1),
            PAGE_BACKGROUND(2),
            BACKGROUND_PAGE(3),
            HALF_FULL_SCREEN(4),
            FULL_HALF_SCREEN(5);
            
            private final int typeCode;
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            Type(int typeCode) {
                this.typeCode = typeCode;
            }

            public final int getTypeCode() {
                return this.typeCode;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Switch(Type type, String... extra) {
            super(NeuronsEvents.SWITCH, (String[]) r0.toArray(new String[r0.size()]));
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(extra, "extra");
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.add("switch_type");
            spreadBuilder.add(String.valueOf(type.getTypeCode()));
            spreadBuilder.addSpread(extra);
            this.extra = extra;
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$SwitchSpeed;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SwitchSpeed extends Event {
        public static final SwitchSpeed INSTANCE = new SwitchSpeed();

        private SwitchSpeed() {
            super(NeuronsEvents.SWITCH_SPEED, new String[0]);
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$End;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "type", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$End$Type;", "<init>", "(Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$End$Type;)V", "Type", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class End extends Event {

        /* compiled from: IReporterService.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$End$Type;", "", "typeCode", "", "<init>", "(Ljava/lang/String;II)V", "getTypeCode", "()I", "NORMAL", "DLNA", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public enum Type {
            NORMAL(1),
            DLNA(2);
            
            private final int typeCode;
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            Type(int typeCode) {
                this.typeCode = typeCode;
            }

            public final int getTypeCode() {
                return this.typeCode;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public End(Type type) {
            super(NeuronsEvents.END, "end_type", String.valueOf(type.getTypeCode()));
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$NormalEvent;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "eventId", "", "args", "", "<init>", "(Ljava/lang/String;[Ljava/lang/String;)V", "getEventId", "()Ljava/lang/String;", "getArgs", "()[Ljava/lang/String;", "[Ljava/lang/String;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class NormalEvent extends Event {
        private final String[] args;
        private final String eventId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NormalEvent(String eventId, String... args) {
            super(eventId, (String[]) Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(args, "args");
            this.eventId = eventId;
            this.args = args;
        }

        public final String[] getArgs() {
            return this.args;
        }

        public final String getEventId() {
            return this.eventId;
        }
    }

    /* compiled from: IReporterService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$NormalEventV2;", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "eventId", "", "map", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventId", "()Ljava/lang/String;", "dumpTo", "", "out", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class NormalEventV2 extends Event {
        private final String eventId;
        private final Map<String, String> map;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NormalEventV2(String eventId, Map<String, String> map) {
            super(eventId, new String[0]);
            Map map2 = EnhancedUnmodifiabilityKt.unmodifiable(map);
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            this.eventId = eventId;
            this.map = map2;
        }

        public /* synthetic */ NormalEventV2(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : map);
        }

        public final String getEventId() {
            return this.eventId;
        }

        @Override // tv.danmaku.biliplayerv2.service.report.NeuronsEvents.Event
        public void dumpTo(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "out");
            Map p0 = this.map;
            if (p0 != null) {
                map.putAll(p0);
            }
        }
    }
}