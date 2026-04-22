package tv.danmaku.bili.report.pv.spm;

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.danmaku.android.log.BLog;

class PatternMatcher {
    private static final int CACHE_SIZE = 6;
    private static final String TAG = "PVM-PatternMatcher";
    private List<PositionModel> mMatchTargets = Collections.emptyList();
    private List<PositionModel> mMatchCache = new ArrayList(6);
    private int mCacheIndex = 0;

    PatternMatcher() {
    }

    public void setMatchTarget(List<PositionModel> targets) {
        if (targets != null) {
            this.mMatchTargets = targets;
        }
    }

    public PositionModel getMatchedPosModel(String pattern) {
        try {
            Uri targetUri = Uri.parse(pattern);
            if (this.mMatchTargets.size() >= 12) {
                for (PositionModel cacheData : this.mMatchCache) {
                    if (matchPattern(targetUri, cacheData)) {
                        BLog.d(TAG, "hit cache data");
                        return cacheData;
                    }
                }
            }
            for (PositionModel data : this.mMatchTargets) {
                if (matchPattern(targetUri, data)) {
                    updateCache(data);
                    return data;
                }
            }
            return null;
        } catch (Exception e) {
            BLog.e(TAG, e.getMessage());
            return null;
        }
    }

    private void updateCache(PositionModel data) {
        if (data == null) {
            return;
        }
        if (this.mCacheIndex < 6 && this.mCacheIndex >= 0) {
            if (this.mMatchCache.size() == 6) {
                this.mMatchCache.set(this.mCacheIndex, data);
            } else {
                this.mMatchCache.add(data);
            }
            this.mCacheIndex++;
        } else {
            this.mCacheIndex = 0;
        }
        BLog.d(TAG, "cache data updated, index = " + this.mCacheIndex);
    }

    private boolean matchPattern(Uri targetUri, PositionModel data) {
        try {
            Uri dataUri = Uri.parse(data.getPattern());
            String dataScheme = dataUri.getScheme();
            String dataHost = dataUri.getHost();
            if (TextUtils.isEmpty(dataScheme) || TextUtils.isEmpty(dataHost) || !dataScheme.equalsIgnoreCase(targetUri.getScheme())) {
                return false;
            }
            return dataHost.equalsIgnoreCase(targetUri.getHost());
        } catch (Exception e) {
            BLog.e(TAG, e.getMessage());
        }
        return false;
    }
}