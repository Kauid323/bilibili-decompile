package tv.danmaku.bili.bilow.debug;

import android.util.Log;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.bilow.debug.DebugLog;

/* compiled from: DebugLog.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/bilow/debug/DebugLog;", "", "<init>", "()V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DebugLog {
    public static final int $stable = 0;
    private static final String EP = "Bili-EP-Fuzz";
    public static final Companion Companion = new Companion(null);
    private static final boolean enable = BuildConfig.DEBUG;

    /* compiled from: DebugLog.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/bilow/debug/DebugLog$Companion;", "", "<init>", "()V", "enable", "", "EP", "", "inject", "", "wrapper", "Lcom/bilibili/lib/okhttp/OkHttpClientWrapper;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void inject(OkHttpClientWrapper wrapper) {
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            if (DebugLog.enable) {
                wrapper.addInterceptor(new Interceptor() { // from class: tv.danmaku.bili.bilow.debug.DebugLog$Companion$$ExternalSyntheticLambda0
                    public final Response intercept(Interceptor.Chain chain) {
                        Response inject$lambda$0;
                        inject$lambda$0 = DebugLog.Companion.inject$lambda$0(chain);
                        return inject$lambda$0;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:11:0x00a3 A[Catch: Exception -> 0x00cb, TryCatch #0 {Exception -> 0x00cb, blocks: (B:3:0x0019, B:5:0x0097, B:11:0x00a3, B:13:0x00ae, B:14:0x00b2), top: B:19:0x0019 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final Response inject$lambda$0(Interceptor.Chain chain) {
            boolean z;
            Intrinsics.checkNotNullParameter(chain, "chain");
            Request request = chain.request();
            HttpUrl url = request.url();
            int code = url.hashCode();
            try {
                Log.d("API", code + ">>> " + request.method() + " " + url);
                Response response = chain.proceed(request);
                Intrinsics.checkNotNullExpressionValue(response, "proceed(...)");
                int code2 = response.code();
                Log.d("API", code + "<<< " + code2 + " " + response.message() + " (" + (response.receivedResponseAtMillis() - response.sentRequestAtMillis()) + "ms)");
                String header = response.header(DebugLog.EP, (String) null);
                if (header != null && !StringsKt.isBlank(header)) {
                    z = false;
                    if (!z) {
                        ResponseBody peekBody = response.peekBody(Long.MAX_VALUE);
                        Log.d("API", code + "<<< " + (peekBody != null ? peekBody.string() : null));
                    }
                    return response;
                }
                z = true;
                if (!z) {
                }
                return response;
            } catch (Exception e) {
                Log.d("API", code + "<<< Failed on " + e.getClass().getSimpleName());
                throw e;
            }
        }
    }

    @JvmStatic
    public static final void inject(OkHttpClientWrapper wrapper) {
        Companion.inject(wrapper);
    }
}