package tv.danmaku.bili.utils.storage.fetcher;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.Locale;
import tv.danmaku.android.log.BLog;
import video.biz.offline.base.infra.utils.EntryScannerKt;

class KitkatFetcher extends LegacyFetcher {
    @Override // tv.danmaku.bili.utils.storage.fetcher.LegacyFetcher, tv.danmaku.bili.utils.storage.fetcher.StoragePathFetcher
    public String getPrimaryPath(Context context) {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @Override // tv.danmaku.bili.utils.storage.fetcher.LegacyFetcher, tv.danmaku.bili.utils.storage.fetcher.StoragePathFetcher
    public String getSecondaryPath(Context context) {
        String data = getSecondaryDataPath(context);
        BLog.i("videodownloader", "getSecondaryDataPath:" + data);
        if (data != null) {
            String[] fragments = data.split(EntryScannerKt.PATH_SEPARATOR);
            StringBuilder sb = new StringBuilder();
            for (String s : fragments) {
                if (s.toLowerCase(Locale.getDefault()).equals("android")) {
                    return sb.toString();
                }
                if (s.length() == 0 || s.charAt(0) == '/') {
                    sb.append(s);
                } else {
                    sb.append(EntryScannerKt.PATH_SEPARATOR).append(s);
                }
            }
        }
        return super.getSecondaryPath(context);
    }

    private String getSecondaryDataPath(Context context) {
        File[] files = context.getExternalFilesDirs(null);
        String primaryPath = getPrimaryPath(context);
        if (!TextUtils.isEmpty(primaryPath) && files != null && files.length > 0) {
            for (File file : files) {
                if (file != null) {
                    String path = file.getAbsolutePath();
                    if (!TextUtils.isEmpty(path) && !path.startsWith(primaryPath)) {
                        return path;
                    }
                }
            }
        }
        return null;
    }
}