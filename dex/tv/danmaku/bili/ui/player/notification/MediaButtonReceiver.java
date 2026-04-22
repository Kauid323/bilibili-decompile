package tv.danmaku.bili.ui.player.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import tv.danmaku.bili.ui.player.lock.MusicSystemLockScreenManager;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.ijk.media.player.IjkCpuInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class MediaButtonReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        KeyEvent event;
        if (!"android.intent.action.MEDIA_BUTTON".equalsIgnoreCase(intent.getAction()) || intent.getExtras() == null || (event = (KeyEvent) intent.getExtras().get("android.intent.extra.KEY_EVENT")) == null || 1 != event.getAction()) {
            return;
        }
        LocalBroadcastManager broadcast = LocalBroadcastManager.getInstance(context);
        switch (event.getKeyCode()) {
            case 79:
                broadcast.sendBroadcast(new Intent(MusicSystemLockScreenManager.ACTION_SYSTEM_LOCK_PLAY_PAUSE));
                return;
            case 85:
                broadcast.sendBroadcast(new Intent(MusicSystemLockScreenManager.ACTION_SYSTEM_LOCK_PLAY_PAUSE));
                return;
            case IjkCpuInfo.CPU_IMPL_MARVELL /* 86 */:
            case Player.PLAYER_QUALITY_HDR_VIVID /* 129 */:
                broadcast.sendBroadcast(new Intent(MusicSystemLockScreenManager.ACTION_SYSTEM_LOCK_STOP));
                return;
            case 87:
                broadcast.sendBroadcast(new Intent(MusicSystemLockScreenManager.ACTION_SYSTEM_LOCK_NEXT));
                return;
            case IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                broadcast.sendBroadcast(new Intent(MusicSystemLockScreenManager.ACTION_SYSTEM_LOCK_PREV));
                return;
            case Player.PLAYER_QUALITY_DOLBY_VISION /* 126 */:
                broadcast.sendBroadcast(new Intent(MusicSystemLockScreenManager.ACTION_SYSTEM_LOCK_PLAY));
                return;
            case 127:
                broadcast.sendBroadcast(new Intent(MusicSystemLockScreenManager.ACTION_SYSTEM_LOCK_PAUSE));
                return;
            default:
                return;
        }
    }
}