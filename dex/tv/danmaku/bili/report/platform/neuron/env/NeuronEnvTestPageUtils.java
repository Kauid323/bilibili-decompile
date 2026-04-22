package tv.danmaku.bili.report.platform.neuron.env;

import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: NeuronEnvTestPageUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/report/platform/neuron/env/NeuronEnvTestPageUtils;", "", "<init>", "()V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NeuronEnvTestPageUtils {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "neuron.redirect.ui.test";
    private static final int defaultTimeOut = 6000;
    private static final String path = "/scanQrcode/notice/";

    /* compiled from: NeuronEnvTestPageUtils.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/report/platform/neuron/env/NeuronEnvTestPageUtils$Companion;", "", "<init>", "()V", "defaultTimeOut", "", "TAG", "", FileChooserActivity.PATH, "sendScanMessage", "", "uuid", ReportEvent.Tag.HOST, "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void sendScanMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "uuid");
            sendScanMessage$default(this, str, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ void sendScanMessage$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            companion.sendScanMessage(str, str2);
        }

        public final void sendScanMessage(String uuid, String host) {
            String url;
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            OkHttpClient client = OkHttpClientWrapper.get().newBuilder().connectTimeout(6000L, TimeUnit.MILLISECONDS).writeTimeout(6000L, TimeUnit.MILLISECONDS).readTimeout(6000L, TimeUnit.MILLISECONDS).build();
            String str = host;
            if (str == null || StringsKt.isBlank(str)) {
                url = "http://10.221.16.82/scanQrcode/notice/" + uuid;
            } else {
                url = "http://" + host + NeuronEnvTestPageUtils.path + uuid;
            }
            Request request = new Request.Builder().url(url).get().build();
            try {
                Response response = client.newCall(request).execute();
                if (response != null) {
                    response.close();
                }
            } finally {
            }
        }
    }
}