package okhttp3;

public interface NetworkBridgeInterceptor extends Interceptor {

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface Factory {
        NetworkBridgeInterceptor create(OkHttpClient okHttpClient, boolean z);
    }

    void cancel();

    boolean isBridged();

    boolean isCanceled();
}