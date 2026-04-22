package tv.danmaku.bili.antiaddiction.data;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: AddictionConfigData.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData;", "", "<init>", "()V", "rules", "", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules;", "getRules", "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "Rules", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AddictionConfigData {
    @JSONField(name = "rules")
    private List<Rules> rules;

    public final List<Rules> getRules() {
        return this.rules;
    }

    public final void setRules(List<Rules> list) {
        this.rules = list;
    }

    /* compiled from: AddictionConfigData.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules;", "", "<init>", "()V", "id", "", "getId", "()I", "setId", "(I)V", "version", "", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "frequency", "getFrequency", "setFrequency", "conditions", "", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Conditions;", "getConditions", "()Ljava/util/List;", "setConditions", "(Ljava/util/List;)V", "control", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control;", "getControl", "()Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control;", "setControl", "(Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control;)V", "Conditions", "Control", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Rules {
        @JSONField(name = "conditions")
        private List<Conditions> conditions;
        @JSONField(name = "frequency")
        private int frequency;
        @JSONField(name = "id")
        private int id;
        @JSONField(name = "version")
        private String version = "";
        @JSONField(name = "control")
        private Control control = new Control();

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public final String getVersion() {
            return this.version;
        }

        public final void setVersion(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.version = str;
        }

        public final int getFrequency() {
            return this.frequency;
        }

        public final void setFrequency(int i) {
            this.frequency = i;
        }

        public final List<Conditions> getConditions() {
            return this.conditions;
        }

        public final void setConditions(List<Conditions> list) {
            this.conditions = list;
        }

        public final Control getControl() {
            return this.control;
        }

        public final void setControl(Control control) {
            this.control = control;
        }

        /* compiled from: AddictionConfigData.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Conditions;", "", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "series", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Conditions$Series;", "getSeries", "()Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Conditions$Series;", "setSeries", "(Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Conditions$Series;)V", "Series", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Conditions {
            @JSONField(name = "series")
            private Series series;
            @JSONField(name = "type")
            private String type = "";

            public final String getType() {
                return this.type;
            }

            public final void setType(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.type = str;
            }

            public final Series getSeries() {
                return this.series;
            }

            public final void setSeries(Series series) {
                this.series = series;
            }

            /* compiled from: AddictionConfigData.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Conditions$Series;", "", "<init>", "()V", "maxDuration", "", "getMaxDuration", "()I", "setMaxDuration", "(I)V", "interval", "getInterval", "setInterval", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class Series {
                @JSONField(name = "interval")
                private int interval;
                @JSONField(name = "max_duration")
                private int maxDuration;

                public final int getMaxDuration() {
                    return this.maxDuration;
                }

                public final void setMaxDuration(int i) {
                    this.maxDuration = i;
                }

                public final int getInterval() {
                    return this.interval;
                }

                public final void setInterval(int i) {
                    this.interval = i;
                }
            }
        }

        /* compiled from: AddictionConfigData.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control;", "", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "push", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control$Push;", "getPush", "()Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control$Push;", "setPush", "(Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control$Push;)V", "Push", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Control {
            @JSONField(name = "push")
            private Push push;
            @JSONField(name = "type")
            private String type = "";

            public final String getType() {
                return this.type;
            }

            public final void setType(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.type = str;
            }

            public final Push getPush() {
                return this.push;
            }

            public final void setPush(Push push) {
                this.push = push;
            }

            /* compiled from: AddictionConfigData.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control$Push;", "", "<init>", "()V", "message", "Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control$Push$Message;", "getMessage", "()Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control$Push$Message;", "setMessage", "(Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control$Push$Message;)V", "Message", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class Push {
                @JSONField(name = "message")
                private Message message;

                public final Message getMessage() {
                    return this.message;
                }

                public final void setMessage(Message message) {
                    this.message = message;
                }

                /* compiled from: AddictionConfigData.kt */
                @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/AddictionConfigData$Rules$Control$Push$Message;", "", "<init>", "()V", ReportUtilKt.POS_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "img", "getImg", "setImg", "summary", "getSummary", "setSummary", "expire", "", "getExpire", "()J", "setExpire", "(J)V", "duration", "getDuration", "setDuration", "hideArrow", "", "getHideArrow", "()Z", "setHideArrow", "(Z)V", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final class Message {
                    @JSONField(name = "duration")
                    private int duration;
                    @JSONField(name = "expire")
                    private long expire;
                    @JSONField(name = "hide_arrow")
                    private boolean hideArrow;
                    @JSONField(name = "position")
                    private int position;
                    @JSONField(name = ReportUtilKt.POS_TITLE)
                    private String title = "";
                    @JSONField(name = "img")
                    private String img = "";
                    @JSONField(name = "summary")
                    private String summary = "";

                    public final String getTitle() {
                        return this.title;
                    }

                    public final void setTitle(String str) {
                        Intrinsics.checkNotNullParameter(str, "<set-?>");
                        this.title = str;
                    }

                    public final int getPosition() {
                        return this.position;
                    }

                    public final void setPosition(int i) {
                        this.position = i;
                    }

                    public final String getImg() {
                        return this.img;
                    }

                    public final void setImg(String str) {
                        Intrinsics.checkNotNullParameter(str, "<set-?>");
                        this.img = str;
                    }

                    public final String getSummary() {
                        return this.summary;
                    }

                    public final void setSummary(String str) {
                        Intrinsics.checkNotNullParameter(str, "<set-?>");
                        this.summary = str;
                    }

                    public final long getExpire() {
                        return this.expire;
                    }

                    public final void setExpire(long j) {
                        this.expire = j;
                    }

                    public final int getDuration() {
                        return this.duration;
                    }

                    public final void setDuration(int i) {
                        this.duration = i;
                    }

                    public final boolean getHideArrow() {
                        return this.hideArrow;
                    }

                    public final void setHideArrow(boolean z) {
                        this.hideArrow = z;
                    }
                }
            }
        }
    }
}