package tv.danmaku.video.bilicardplayer.player;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo;

/* compiled from: CardPlayerCallbacksInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u0006\u0010\u000f\u001a\u00020\bR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/CardPlayerCallbacksInfo;", "Callback", "", "<init>", "()V", "mCallbacks", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "add", "", "callback", "(Ljava/lang/Object;)V", "remove", "visit", "visitor", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerCallbacksInfo$Visitor;", "clear", "Visitor", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CardPlayerCallbacksInfo<Callback> {
    private Collections.SafeIteratorList<Callback> mCallbacks;

    /* compiled from: CardPlayerCallbacksInfo.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/CardPlayerCallbacksInfo$Visitor;", "Callback", "", "onVisit", "", "callback", "(Ljava/lang/Object;)V", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Visitor<Callback> {
        void onVisit(Callback callback);
    }

    public final void add(Callback callback) {
        if (this.mCallbacks == null) {
            this.mCallbacks = Collections.safeIteratorList(new ArrayList(2));
        }
        Collections.SafeIteratorList<Callback> safeIteratorList = this.mCallbacks;
        if (safeIteratorList != null) {
            safeIteratorList.add(callback);
        }
    }

    public final void remove(Callback callback) {
        Collections.SafeIteratorList<Callback> safeIteratorList;
        if (this.mCallbacks != null && (safeIteratorList = this.mCallbacks) != null) {
            safeIteratorList.remove(callback);
        }
    }

    public final void visit(final Visitor<Callback> visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Collections.SafeIteratorList<Callback> safeIteratorList = this.mCallbacks;
        if (safeIteratorList != null) {
            safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo$$ExternalSyntheticLambda0
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    CardPlayerCallbacksInfo.Visitor.this.onVisit(obj);
                }
            });
        }
    }

    public final void clear() {
        Collections.SafeIteratorList<Callback> safeIteratorList = this.mCallbacks;
        if (safeIteratorList != null) {
            safeIteratorList.clear();
        }
    }
}