package android.adservices.common;

import java.lang.Throwable;

public interface AdServicesOutcomeReceiver<R, E extends Throwable> {
    void onError(E e);

    void onResult(R r);

    /* renamed from: android.adservices.common.AdServicesOutcomeReceiver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public final /* synthetic */ class CC {
        public static void $default$onError(AdServicesOutcomeReceiver adServicesOutcomeReceiver, Throwable th) {
        }
    }
}