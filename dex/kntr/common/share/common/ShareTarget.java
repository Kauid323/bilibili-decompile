package kntr.common.share.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareTarget.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001d2\u00020\u0001:\u0014\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0001\u0013\u001e\u001f !\"#$%&'()*+,-./0¨\u00061"}, d2 = {"Lkntr/common/share/common/ShareTarget;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "WeChat", "WeChatMoment", "QQ", "QZone", "WeiBo", "Facebook", "Line", "WhatsApp", "Twitter", "Messenger", "Pic", "SaveImage", "Copy", "Generic", "IM", "Dynamic", "MarkPoint", "Cancel", "Custom", "Companion", "Lkntr/common/share/common/ShareTarget$Cancel;", "Lkntr/common/share/common/ShareTarget$Copy;", "Lkntr/common/share/common/ShareTarget$Custom;", "Lkntr/common/share/common/ShareTarget$Dynamic;", "Lkntr/common/share/common/ShareTarget$Facebook;", "Lkntr/common/share/common/ShareTarget$Generic;", "Lkntr/common/share/common/ShareTarget$IM;", "Lkntr/common/share/common/ShareTarget$Line;", "Lkntr/common/share/common/ShareTarget$MarkPoint;", "Lkntr/common/share/common/ShareTarget$Messenger;", "Lkntr/common/share/common/ShareTarget$Pic;", "Lkntr/common/share/common/ShareTarget$QQ;", "Lkntr/common/share/common/ShareTarget$QZone;", "Lkntr/common/share/common/ShareTarget$SaveImage;", "Lkntr/common/share/common/ShareTarget$Twitter;", "Lkntr/common/share/common/ShareTarget$WeChat;", "Lkntr/common/share/common/ShareTarget$WeChatMoment;", "Lkntr/common/share/common/ShareTarget$WeiBo;", "Lkntr/common/share/common/ShareTarget$WhatsApp;", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class ShareTarget {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name;

    public /* synthetic */ ShareTarget(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public static /* synthetic */ void getName$annotations() {
    }

    private ShareTarget(String name) {
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$WeChat;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class WeChat extends ShareTarget {
        public static final int $stable = 0;
        public static final WeChat INSTANCE = new WeChat();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WeChat) {
                WeChat weChat = (WeChat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1593914338;
        }

        public String toString() {
            return "WeChat";
        }

        private WeChat() {
            super("WEIXIN", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$WeChatMoment;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class WeChatMoment extends ShareTarget {
        public static final int $stable = 0;
        public static final WeChatMoment INSTANCE = new WeChatMoment();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WeChatMoment) {
                WeChatMoment weChatMoment = (WeChatMoment) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1963176066;
        }

        public String toString() {
            return "WeChatMoment";
        }

        private WeChatMoment() {
            super("WEIXIN_MONMENT", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$QQ;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class QQ extends ShareTarget {
        public static final int $stable = 0;
        public static final QQ INSTANCE = new QQ();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof QQ) {
                QQ qq = (QQ) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1114370204;
        }

        public String toString() {
            return "QQ";
        }

        private QQ() {
            super("QQ", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$QZone;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class QZone extends ShareTarget {
        public static final int $stable = 0;
        public static final QZone INSTANCE = new QZone();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof QZone) {
                QZone qZone = (QZone) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1894072415;
        }

        public String toString() {
            return "QZone";
        }

        private QZone() {
            super("QZONE", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$WeiBo;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class WeiBo extends ShareTarget {
        public static final int $stable = 0;
        public static final WeiBo INSTANCE = new WeiBo();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WeiBo) {
                WeiBo weiBo = (WeiBo) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1888210708;
        }

        public String toString() {
            return "WeiBo";
        }

        private WeiBo() {
            super("SINA", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$Facebook;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Facebook extends ShareTarget {
        public static final int $stable = 0;
        public static final Facebook INSTANCE = new Facebook();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Facebook) {
                Facebook facebook = (Facebook) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 543692898;
        }

        public String toString() {
            return "Facebook";
        }

        private Facebook() {
            super("FACEBOOK", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$Line;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Line extends ShareTarget {
        public static final int $stable = 0;
        public static final Line INSTANCE = new Line();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Line) {
                Line line = (Line) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1462786960;
        }

        public String toString() {
            return "Line";
        }

        private Line() {
            super("LINE", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$WhatsApp;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class WhatsApp extends ShareTarget {
        public static final int $stable = 0;
        public static final WhatsApp INSTANCE = new WhatsApp();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WhatsApp) {
                WhatsApp whatsApp = (WhatsApp) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1981312782;
        }

        public String toString() {
            return "WhatsApp";
        }

        private WhatsApp() {
            super("WHATSAPP", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$Twitter;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Twitter extends ShareTarget {
        public static final int $stable = 0;
        public static final Twitter INSTANCE = new Twitter();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Twitter) {
                Twitter twitter = (Twitter) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 54987095;
        }

        public String toString() {
            return "Twitter";
        }

        private Twitter() {
            super("TWITTER", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$Messenger;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Messenger extends ShareTarget {
        public static final int $stable = 0;
        public static final Messenger INSTANCE = new Messenger();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Messenger) {
                Messenger messenger = (Messenger) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 7336183;
        }

        public String toString() {
            return "Messenger";
        }

        private Messenger() {
            super("MESSENGER", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$Pic;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Pic extends ShareTarget {
        public static final int $stable = 0;
        public static final Pic INSTANCE = new Pic();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Pic) {
                Pic pic = (Pic) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 185737838;
        }

        public String toString() {
            return "Pic";
        }

        private Pic() {
            super("PIC", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$SaveImage;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SaveImage extends ShareTarget {
        public static final int $stable = 0;
        public static final SaveImage INSTANCE = new SaveImage();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SaveImage) {
                SaveImage saveImage = (SaveImage) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1607046082;
        }

        public String toString() {
            return "SaveImage";
        }

        private SaveImage() {
            super("save_img", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$Copy;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Copy extends ShareTarget {
        public static final int $stable = 0;
        public static final Copy INSTANCE = new Copy();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Copy) {
                Copy copy = (Copy) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1462524689;
        }

        public String toString() {
            return "Copy";
        }

        private Copy() {
            super("COPY", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$Generic;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Generic extends ShareTarget {
        public static final int $stable = 0;
        public static final Generic INSTANCE = new Generic();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Generic) {
                Generic generic = (Generic) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 891185339;
        }

        public String toString() {
            return "Generic";
        }

        private Generic() {
            super("GENERIC", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$IM;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class IM extends ShareTarget {
        public static final int $stable = 0;
        public static final IM INSTANCE = new IM();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IM) {
                IM im = (IM) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1114369952;
        }

        public String toString() {
            return "IM";
        }

        private IM() {
            super("biliIm", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$Dynamic;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Dynamic extends ShareTarget {
        public static final int $stable = 0;
        public static final Dynamic INSTANCE = new Dynamic();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Dynamic) {
                Dynamic dynamic = (Dynamic) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1198866653;
        }

        public String toString() {
            return "Dynamic";
        }

        private Dynamic() {
            super("biliDynamic", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$MarkPoint;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MarkPoint extends ShareTarget {
        public static final int $stable = 0;
        public static final MarkPoint INSTANCE = new MarkPoint();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MarkPoint) {
                MarkPoint markPoint = (MarkPoint) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 490130599;
        }

        public String toString() {
            return "MarkPoint";
        }

        private MarkPoint() {
            super("MARK_POINT", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/common/share/common/ShareTarget$Cancel;", "Lkntr/common/share/common/ShareTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Cancel extends ShareTarget {
        public static final int $stable = 0;
        public static final Cancel INSTANCE = new Cancel();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Cancel) {
                Cancel cancel = (Cancel) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1018913558;
        }

        public String toString() {
            return "Cancel";
        }

        private Cancel() {
            super("11", null);
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkntr/common/share/common/ShareTarget$Custom;", "Lkntr/common/share/common/ShareTarget;", "name", "", "<init>", "(Ljava/lang/String;)V", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Custom extends ShareTarget {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String name) {
            super(name, null);
            Intrinsics.checkNotNullParameter(name, "name");
        }
    }

    /* compiled from: ShareTarget.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/common/share/common/ShareTarget$Companion;", "", "<init>", "()V", "fromName", "Lkntr/common/share/common/ShareTarget;", "name", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShareTarget fromName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return Intrinsics.areEqual(name, WeChat.INSTANCE.getName()) ? WeChat.INSTANCE : Intrinsics.areEqual(name, WeChatMoment.INSTANCE.getName()) ? WeChatMoment.INSTANCE : Intrinsics.areEqual(name, QQ.INSTANCE.getName()) ? QQ.INSTANCE : Intrinsics.areEqual(name, QZone.INSTANCE.getName()) ? QZone.INSTANCE : Intrinsics.areEqual(name, WeiBo.INSTANCE.getName()) ? WeiBo.INSTANCE : Intrinsics.areEqual(name, Facebook.INSTANCE.getName()) ? Facebook.INSTANCE : Intrinsics.areEqual(name, Line.INSTANCE.getName()) ? Line.INSTANCE : Intrinsics.areEqual(name, WhatsApp.INSTANCE.getName()) ? WhatsApp.INSTANCE : Intrinsics.areEqual(name, Twitter.INSTANCE.getName()) ? Twitter.INSTANCE : Intrinsics.areEqual(name, Messenger.INSTANCE.getName()) ? Messenger.INSTANCE : Intrinsics.areEqual(name, Pic.INSTANCE.getName()) ? Pic.INSTANCE : Intrinsics.areEqual(name, SaveImage.INSTANCE.getName()) ? SaveImage.INSTANCE : Intrinsics.areEqual(name, Copy.INSTANCE.getName()) ? Copy.INSTANCE : Intrinsics.areEqual(name, Generic.INSTANCE.getName()) ? Generic.INSTANCE : Intrinsics.areEqual(name, IM.INSTANCE.getName()) ? IM.INSTANCE : Intrinsics.areEqual(name, Dynamic.INSTANCE.getName()) ? Dynamic.INSTANCE : Intrinsics.areEqual(name, MarkPoint.INSTANCE.getName()) ? MarkPoint.INSTANCE : Intrinsics.areEqual(name, Cancel.INSTANCE.getName()) ? Cancel.INSTANCE : new Custom(name);
        }
    }
}