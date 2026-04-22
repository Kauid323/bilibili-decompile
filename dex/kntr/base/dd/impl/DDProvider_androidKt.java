package kntr.base.dd.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: DDProvider.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u00042\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001a\b\u0010\u0007\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DEVICE_DECISION_PRESET_DIR", "", "DEVICE_DECISION_CACHE_DIR", "provideArgs", "Lkntr/base/dd/impl/IDDConstArgs;", "envProvider", "Lkntr/base/dd/impl/IAppDDEnvProvider;", "getCurrentProcessName", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDProvider_androidKt {
    public static final String DEVICE_DECISION_CACHE_DIR = "device_decision2";
    private static final String DEVICE_DECISION_PRESET_DIR = "device_decision";

    public static final IDDConstArgs provideArgs(IAppDDEnvProvider envProvider) {
        return new DDNativeArgs(envProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getCurrentProcessName() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("/proc/self/cmdline")), Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            BufferedReader it = bufferedReader;
            String readLine = it.readLine();
            String str = (readLine == null || (str = StringsKt.trim(readLine).toString()) == null) ? "" : "";
            CloseableKt.closeFinally(bufferedReader, (Throwable) null);
            return str;
        } catch (Exception e) {
            return "";
        }
    }
}