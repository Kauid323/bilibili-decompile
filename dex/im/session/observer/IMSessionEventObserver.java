package im.session.observer;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionEventObserver.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lim/session/observer/IMSessionEventObserver;", "", "onPageInitialed", "", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "onPageFirstLoaded", "onPageClosed", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSessionEventObserver {
    void onPageClosed(KSessionPageType kSessionPageType);

    void onPageFirstLoaded(KSessionPageType kSessionPageType);

    void onPageInitialed(KSessionPageType kSessionPageType);

    /* compiled from: IMSessionEventObserver.kt */
    /* renamed from: im.session.observer.IMSessionEventObserver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final /* synthetic */ class CC {
    }

    /* compiled from: IMSessionEventObserver.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onPageInitialed(IMSessionEventObserver $this, KSessionPageType pageType) {
            Intrinsics.checkNotNullParameter(pageType, "pageType");
            Intrinsics.checkNotNullParameter(pageType, "pageType");
        }

        @Deprecated
        public static void onPageFirstLoaded(IMSessionEventObserver $this, KSessionPageType pageType) {
            Intrinsics.checkNotNullParameter(pageType, "pageType");
            Intrinsics.checkNotNullParameter(pageType, "pageType");
        }

        @Deprecated
        public static void onPageClosed(IMSessionEventObserver $this, KSessionPageType pageType) {
            Intrinsics.checkNotNullParameter(pageType, "pageType");
            Intrinsics.checkNotNullParameter(pageType, "pageType");
        }
    }
}