package tv.danmaku.bili.ui.main.event.model;

import android.text.TextUtils;
import com.airbnb.lottie.LottieComposition;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.garb.model.GarbData;

/* compiled from: EventEntranceModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006 "}, d2 = {"Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel;", "", "<init>", "()V", "online", "Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$Online;", "getOnline", "()Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$Online;", "setOnline", "(Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$Online;)V", "hash", "", "getHash", "()Ljava/lang/String;", "setHash", "(Ljava/lang/String;)V", "lottieAnim", "Lcom/airbnb/lottie/LottieComposition;", "getLottieAnim", "()Lcom/airbnb/lottie/LottieComposition;", "setLottieAnim", "(Lcom/airbnb/lottie/LottieComposition;)V", "iconLocalPath", "getIconLocalPath", "setIconLocalPath", "hasAnimate", "", "checkParams", "toString", "Online", "Animate", "RedDot", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EventEntranceModel {
    public static final int $stable = 8;
    private String hash;
    private String iconLocalPath;
    private transient LottieComposition lottieAnim;
    private Online online;

    public final Online getOnline() {
        return this.online;
    }

    public final void setOnline(Online online) {
        this.online = online;
    }

    public final String getHash() {
        return this.hash;
    }

    public final void setHash(String str) {
        this.hash = str;
    }

    public final LottieComposition getLottieAnim() {
        return this.lottieAnim;
    }

    public final void setLottieAnim(LottieComposition lottieComposition) {
        this.lottieAnim = lottieComposition;
    }

    public final String getIconLocalPath() {
        return this.iconLocalPath;
    }

    public final void setIconLocalPath(String str) {
        this.iconLocalPath = str;
    }

    /* compiled from: EventEntranceModel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010-\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$Online;", "", "<init>", "()V", ChannelRoutes.CHANNEL_NAME, "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "icon", "getIcon", "setIcon", AudioIntentHelper.ARGS_URI, "getUri", "setUri", "uniqueId", "getUniqueId", "setUniqueId", "interval", "", "getInterval", "()Ljava/lang/Long;", "setInterval", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "animate", "Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$Animate;", "getAnimate", "()Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$Animate;", "setAnimate", "(Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$Animate;)V", "redDot", "Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$RedDot;", "getRedDot", "()Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$RedDot;", "setRedDot", "(Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$RedDot;)V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Online {
        public static final int $stable = 8;
        private Animate animate;
        private String icon;
        private Long interval = -1L;
        private String name;
        @JSONField(name = "red_dot")
        private RedDot redDot;
        private Integer type;
        @JSONField(name = "unique_id")
        private String uniqueId;
        private String uri;

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final String getUri() {
            return this.uri;
        }

        public final void setUri(String str) {
            this.uri = str;
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        public final void setUniqueId(String str) {
            this.uniqueId = str;
        }

        public final Long getInterval() {
            return this.interval;
        }

        public final void setInterval(Long l) {
            this.interval = l;
        }

        public final Animate getAnimate() {
            return this.animate;
        }

        public final void setAnimate(Animate animate) {
            this.animate = animate;
        }

        public final RedDot getRedDot() {
            return this.redDot;
        }

        public final void setRedDot(RedDot redDot) {
            this.redDot = redDot;
        }

        public final Integer getType() {
            return this.type;
        }

        public final void setType(Integer num) {
            this.type = num;
        }

        public String toString() {
            String str = this.name;
            String str2 = this.icon;
            String str3 = this.uri;
            String str4 = this.uniqueId;
            Long l = this.interval;
            Animate animate = this.animate;
            RedDot redDot = this.redDot;
            return "Online(name=" + str + ", icon=" + str2 + ", uri=" + str3 + ", uniqueId=" + str4 + ", interval=" + l + ", animate=" + animate + ", redDot=" + redDot + ", type=" + this.type + ")";
        }
    }

    public final boolean hasAnimate() {
        Animate animate;
        Animate animate2;
        Online online = this.online;
        String str = null;
        if (TextUtils.isEmpty((online == null || (animate2 = online.getAnimate()) == null) ? null : animate2.getJson())) {
            Online online2 = this.online;
            if (online2 != null && (animate = online2.getAnimate()) != null) {
                str = animate.getSvg();
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    /* compiled from: EventEntranceModel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$Animate;", "", "<init>", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "json", "getJson", "setJson", "svg", "getSvg", "setSvg", GarbData.ColorDetail.LOOP_ANIMATE, "", "getLoop", "()I", "setLoop", "(I)V", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Animate {
        public static final int $stable = 8;
        private String icon;
        private String json;
        private int loop;
        private String svg;

        public final String getIcon() {
            return this.icon;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final String getJson() {
            return this.json;
        }

        public final void setJson(String str) {
            this.json = str;
        }

        public final String getSvg() {
            return this.svg;
        }

        public final void setSvg(String str) {
            this.svg = str;
        }

        public final int getLoop() {
            return this.loop;
        }

        public final void setLoop(int i) {
            this.loop = i;
        }

        public String toString() {
            String str = this.icon;
            String str2 = this.json;
            String str3 = this.svg;
            return "Animate(icon=" + str + ", json=" + str2 + ", svg=" + str3 + ", loop=" + this.loop + ")";
        }
    }

    /* compiled from: EventEntranceModel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$RedDot;", "", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "number", "getNumber", "setNumber", "toString", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class RedDot {
        public static final int TYPE_MOLE = 1;
        public static final int TYPE_NUMBER = 2;
        private int number = -1;
        private int type;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* compiled from: EventEntranceModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/main/event/model/EventEntranceModel$RedDot$Companion;", "", "<init>", "()V", "TYPE_MOLE", "", "TYPE_NUMBER", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final int getNumber() {
            return this.number;
        }

        public final void setNumber(int i) {
            this.number = i;
        }

        public String toString() {
            int i = this.type;
            return "RedDot(type=" + i + ", number=" + this.number + ")";
        }
    }

    public final boolean checkParams() {
        if (this.online != null) {
            Online online = this.online;
            if (!TextUtils.isEmpty(online != null ? online.getUri() : null)) {
                Online online2 = this.online;
                if (!TextUtils.isEmpty(online2 != null ? online2.getIcon() : null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        Online online = this.online;
        String str = this.hash;
        LottieComposition lottieComposition = this.lottieAnim;
        return "EventEntranceModel(online=" + online + ", hash=" + str + ", lottieAnim=" + lottieComposition + "), iconpath=" + this.iconLocalPath;
    }
}