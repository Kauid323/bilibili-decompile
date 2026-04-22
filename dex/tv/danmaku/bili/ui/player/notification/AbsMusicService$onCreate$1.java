package tv.danmaku.bili.ui.player.notification;

import android.support.v4.media.session.MediaSessionCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AbsMusicService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
final /* synthetic */ class AbsMusicService$onCreate$1 extends FunctionReferenceImpl implements Function0<MediaSessionCompat> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsMusicService$onCreate$1(Object obj) {
        super(0, obj, AbsMusicService.class, "getMediaSession", "getMediaSession()Landroid/support/v4/media/session/MediaSessionCompat;", 0);
    }

    /* renamed from: invoke */
    public final MediaSessionCompat m1431invoke() {
        return ((AbsMusicService) this.receiver).getMediaSession();
    }
}