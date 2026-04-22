package tv.danmaku.video.playerservice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RecyclableObjectPool.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J'\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0011RV\u0010\u0004\u001aJ\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\bj\b\u0012\u0004\u0012\u00020\u0007`\t0\u0005j$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\bj\b\u0012\u0004\u0012\u00020\u0007`\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/video/playerservice/RecyclableObjectPool;", "", "<init>", "()V", "mRecyclableObjects", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Ltv/danmaku/video/playerservice/RecyclableObject;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "put", "", "o", "get", "T", "clazz", "(Ljava/lang/Class;)Ltv/danmaku/video/playerservice/RecyclableObject;", "Companion", "playerservice_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RecyclableObjectPool {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_COUNT_BY_TYPE = 8;
    private final HashMap<Class<RecyclableObject>, HashSet<RecyclableObject>> mRecyclableObjects = new HashMap<>();

    /* compiled from: RecyclableObjectPool.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/video/playerservice/RecyclableObjectPool$Companion;", "", "<init>", "()V", "MAX_COUNT_BY_TYPE", "", "playerservice_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void put(RecyclableObject o) {
        Intrinsics.checkNotNullParameter(o, "o");
        o.recycle();
        o.setRecycled(true);
        HashSet obs = this.mRecyclableObjects.get(o.getClass());
        if (obs == null) {
            obs = new HashSet();
            this.mRecyclableObjects.put(o.getClass(), obs);
        }
        if (obs.contains(o) || obs.size() >= 8) {
            return;
        }
        obs.add(o);
    }

    public final <T extends RecyclableObject> T get(Class<? extends RecyclableObject> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        HashSet obs = this.mRecyclableObjects.get(cls);
        if (obs == null) {
            return null;
        }
        Iterator it = obs.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        RecyclableObject result = null;
        if (it.hasNext()) {
            RecyclableObject result2 = it.next();
            result = result2;
            it.remove();
        }
        if (result != null) {
            result.setRecycled(false);
        }
        if (result instanceof RecyclableObject) {
            return (T) result;
        }
        return null;
    }
}