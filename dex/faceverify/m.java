package faceverify;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.text.TextUtils;
import com.dtf.face.ToygerConfig;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.thread.ThreadControl;
import com.dtf.face.utils.FileUtil;
import com.dtf.face.utils.MiscUtil;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class m {
    public static SoundPool a = null;
    public static Map<String, Integer> b = null;
    public static String c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f1964d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static volatile List<Integer> f1965e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1966f = false;

    /* renamed from: g  reason: collision with root package name */
    public static final File f1967g = new File(ToygerConfig.getInstance().getContext().getCacheDir(), "dtf/face-audio/");

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class a implements SoundPool.OnLoadCompleteListener {
        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i2, int i3) {
            if (!m.f1965e.contains(Integer.valueOf(i2))) {
                m.f1965e.add(Integer.valueOf(i2));
            }
            Integer valueOf = Integer.valueOf((m.c == null || m.b.get(m.c) == null) ? 0 : m.b.get(m.c).intValue());
            if (i2 == 0 || valueOf.intValue() != i2) {
                return;
            }
            m.a(i2);
        }
    }

    public static void b() {
        SoundPool soundPool = a;
        if (soundPool != null) {
            soundPool.autoPause();
        }
    }

    public static synchronized void a() {
        HashMap hashMap;
        synchronized (m.class) {
            b = new HashMap();
            f1965e = new ArrayList();
            a = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).build();
            a.setOnLoadCompleteListener(new a());
            if (a != null) {
                Context context = ToygerConfig.getInstance().getContext();
                try {
                    String[] list = context.getAssets().list("dtf/audio/");
                    int i2 = 0;
                    if (list != null && list.length > 0) {
                        for (String str : list) {
                            String replace = str.replace(".mp3", "");
                            if (!b.containsKey(replace)) {
                                a("dtf/audio/", replace, false);
                            }
                        }
                    } else {
                        File file = new File(context.getCacheDir(), "dtf/face-audio/");
                        if (file.exists() && file.isDirectory()) {
                            String[] list2 = file.list();
                            int i3 = list2.length > 0 ? 1 : 0;
                            int length = list2.length;
                            while (i2 < length) {
                                String str2 = list2[i2];
                                if (a(str2)) {
                                    a(file.getAbsolutePath(), str2, true);
                                }
                                i2++;
                            }
                            i2 = i3;
                        }
                        if (i2 == 0 && !f1966f && (hashMap = ToygerConfig.getInstance().getAndroidClientConfig().suitable) != null && hashMap.size() > 0) {
                            ThreadControl.runOnMultiThread(new n(hashMap));
                        }
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static int a(String str, String str2, boolean z) {
        int i2 = 0;
        if (z) {
            try {
                i2 = a.load(str + File.separator + str2 + ".mp3", 1);
            } catch (Throwable th) {
                th = th;
                RecordService.getInstance().recordException(th);
                return i2;
            }
        } else {
            try {
                i2 = a.load(ToygerConfig.getInstance().getContext().getAssets().openFd(str + str2 + ".mp3"), 1);
            } catch (Throwable th2) {
                th = th2;
                RecordService.getInstance().recordException(th);
                return i2;
            }
        }
        if (i2 != 0) {
            b.put(str2, Integer.valueOf(i2));
        }
        return i2;
    }

    public static int a(int i2) {
        if (f1964d != 0) {
            a.stop(i2);
        }
        f1964d = a.play(i2, 1.0f, 1.0f, 1, 0, 1.0f);
        return f1964d;
    }

    public static boolean a(String str) {
        HashMap hashMap;
        Context context = ToygerConfig.getInstance().getContext();
        AndroidClientConfig androidClientConfig = ToygerConfig.getInstance().getAndroidClientConfig();
        if (androidClientConfig != null && (hashMap = androidClientConfig.suitable) != null && context != null) {
            String str2 = (String) hashMap.get("sig" + str);
            File file = new File(context.getCacheDir(), faceverify.a.a("dtf/face-audio/").append(File.separator).append(str).append(".mp3").toString());
            if (file.exists()) {
                if (TextUtils.equals(MiscUtil.getFileMd5(file.getAbsolutePath()), str2)) {
                    return true;
                }
                RecordService.getInstance().recordEvent(2, "suitableError", new String[]{SocialConstants.PARAM_SEND_MSG, "md5 check fail", "fileName", str});
                FileUtil.deleteFile(file);
            }
        }
        return false;
    }
}