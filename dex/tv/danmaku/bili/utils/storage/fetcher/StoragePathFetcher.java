package tv.danmaku.bili.utils.storage.fetcher;

import android.content.Context;

public interface StoragePathFetcher {
    String getPrimaryPath(Context context);

    String getSecondaryPath(Context context);
}