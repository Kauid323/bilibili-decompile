package tv.danmaku.bili.ui.player.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NotificationStyle {
    public static final int NOTIFICATION_TYPE_NEW = 1;
    public static final int NOTIFICATION_TYPE_NORMAL = 0;
    public int backgroundColor;
    @Deprecated
    public int mode;
    public int notificationType;
    public boolean isFixedPlayMode = false;
    public boolean forceShowNextAndPrev = false;
    public boolean forbiddenPlayerAction = false;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public @interface NotificationType {
    }

    public String toString() {
        return "NotificationStyle{notificationType=" + this.notificationType + ", backgroundColor=" + this.backgroundColor + ", isFixedPlayMode=" + this.isFixedPlayMode + '}';
    }
}