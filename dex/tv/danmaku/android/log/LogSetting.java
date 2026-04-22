package tv.danmaku.android.log;

import android.content.Context;
import android.util.Log;
import java.io.File;
import tv.danmaku.android.log.internal.NativeLogger;
import tv.danmaku.bili.auth.BiliAuthActivity;

public class LogSetting {
    static final String DEFAULT_DIR = "blog_v3";
    static final String DEFAULT_DIR_OLD = "blog";
    public static final long DEFAULT_MAX_LOG_SIZE = 5242880;
    public static final int EVENT = 16;
    public static final int LOG = 1;
    static final String TAG = "blog";
    private boolean disableNativeLogger;
    private int mAutoFlushMillis;
    private int mBlockAmount;
    private File mCacheDir;
    private int mCompressionCoreSize;
    private Context mContext;
    private boolean mDebuggable;
    private String mDefaultTag;
    private int mExpiredDay;
    private File mLogDir;
    private int mLogcatPriority;
    private int mLogfilePriority;
    private int mPageAmountInBlock;
    private long maxLogSize;
    private boolean useLollipopAPI;
    private int useMemoryCacheSize;

    private LogSetting() {
    }

    public Context getContext() {
        return this.mContext;
    }

    public int useMemoryCacheSize() {
        return this.useMemoryCacheSize;
    }

    public int getBlockAmount() {
        return this.mBlockAmount;
    }

    public int getPageAmountInBlock() {
        return this.mPageAmountInBlock;
    }

    public int getCompressionCoreSize() {
        return this.mCompressionCoreSize;
    }

    public boolean isDisableNativeLogger() {
        return this.disableNativeLogger;
    }

    public int getLogcatPriority() {
        return this.mLogcatPriority;
    }

    public int getLogfilePriority() {
        return this.mLogfilePriority;
    }

    public File getLogDir() {
        return this.mLogDir;
    }

    public File getCacheDir() {
        return this.mCacheDir;
    }

    public int getExpiredDay() {
        return this.mExpiredDay;
    }

    public String getDefaultTag() {
        return this.mDefaultTag;
    }

    public int getAutoFlushMillis() {
        return this.mAutoFlushMillis;
    }

    public boolean debuggable() {
        return this.mDebuggable;
    }

    public long maxLogSize() {
        return this.maxLogSize;
    }

    public boolean useLollipopAPI() {
        return this.useLollipopAPI;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Builder {
        private static final int MIN_AUTO_FLUSH_MILLIS = 500;
        private File mCacheDir;
        private Context mContext;
        private File mLogDir;
        private int mLogcatPriority = -1;
        private int mLogfilePriority = -1;
        private int mAutoFlushMillis = BiliAuthActivity.PERMISSION_REQUEST_CODE;
        private int mBlockAmount = 8;
        private int mPageAmountInBlock = 8;
        private boolean useLollipopAPI = true;
        private long maxLogSize = LogSetting.DEFAULT_MAX_LOG_SIZE;
        private int useMemoryCacheSize = 0;
        private int compressionCoreSize = -1;
        private boolean disableNativeLogger = false;
        private int mExpiredDay = 2;
        private String mDefaultTag = NativeLogger.DEFAULT_TAG;
        private boolean mDebuggable = false;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder useLollipopAPI(boolean useLollipopAPI) {
            this.useLollipopAPI = useLollipopAPI;
            return this;
        }

        public Builder disableNativeLogger() {
            this.disableNativeLogger = true;
            return this;
        }

        public Builder setCacheDir(File path) {
            this.mCacheDir = path;
            return this;
        }

        public Builder useMemoryCacheSize(int useMemoryCacheSize) {
            this.useMemoryCacheSize = useMemoryCacheSize;
            return this;
        }

        public Builder setMaxLogSize(long maxLogSize) {
            this.maxLogSize = maxLogSize;
            return this;
        }

        public Builder setLogDir(File path) {
            this.mLogDir = path;
            return this;
        }

        public Builder setBufferOptions(int blockAmount, int pageAmountInBlock) {
            this.mBlockAmount = blockAmount;
            this.mPageAmountInBlock = pageAmountInBlock;
            return this;
        }

        public Builder setDefaultTag(String defaultTag) {
            this.mDefaultTag = defaultTag;
            return this;
        }

        public Builder setAutoFlushMillis(int autoFlushMillis) {
            if (autoFlushMillis < 500) {
                Log.w("blog", "autoFlushMillis too fast! Just set to 500");
                this.mAutoFlushMillis = 500;
            } else {
                this.mAutoFlushMillis = autoFlushMillis;
            }
            return this;
        }

        public Builder setLogcatPriority(int priority) {
            if (LogPriority.isValid(priority)) {
                this.mLogcatPriority = priority;
            }
            return this;
        }

        public Builder setCompressionCoreSize(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Core size must > 0 .");
            }
            this.compressionCoreSize = size;
            return this;
        }

        public Builder setLogfilePriority(int priority) {
            if (LogPriority.isValid(priority)) {
                this.mLogfilePriority = priority;
            }
            return this;
        }

        public Builder setExpiredDay(int expiredDay) {
            if (this.mExpiredDay > 0) {
                this.mExpiredDay = expiredDay;
            }
            return this;
        }

        public Builder setDebuggable(boolean debuggable) {
            this.mDebuggable = debuggable;
            return this;
        }

        public LogSetting build() {
            LogSetting setting = new LogSetting();
            setting.mContext = this.mContext;
            setting.mLogDir = this.mLogDir;
            setting.mCacheDir = this.mCacheDir;
            setting.mDebuggable = this.mDebuggable;
            setting.mExpiredDay = this.mExpiredDay;
            setting.mLogcatPriority = this.mLogcatPriority;
            setting.mLogfilePriority = this.mLogfilePriority;
            setting.mAutoFlushMillis = this.mAutoFlushMillis;
            setting.mDefaultTag = this.mDefaultTag;
            setting.useLollipopAPI = this.useLollipopAPI;
            setting.mBlockAmount = this.mBlockAmount;
            setting.mPageAmountInBlock = this.mPageAmountInBlock;
            setting.useMemoryCacheSize = this.useMemoryCacheSize;
            setting.mCompressionCoreSize = this.compressionCoreSize;
            setting.disableNativeLogger = this.disableNativeLogger;
            if (this.maxLogSize > 0) {
                setting.maxLogSize = this.maxLogSize;
                if (setting.mLogcatPriority == -1) {
                    setting.mLogcatPriority = this.mDebuggable ? 2 : 6;
                }
                if (setting.mLogfilePriority == -1) {
                    setting.mLogfilePriority = this.mDebuggable ? 3 : 4;
                }
                if (setting.mLogDir == null) {
                    ensureLogDir(setting);
                }
                if (setting.mCompressionCoreSize <= 0) {
                    if (Runtime.getRuntime().availableProcessors() >= 4) {
                        setting.mCompressionCoreSize = 3;
                    } else {
                        setting.mCompressionCoreSize = 2;
                    }
                }
                if (setting.mCacheDir == null) {
                    File dir = new File(setting.mLogDir, "cache");
                    dir.mkdirs();
                    setting.mCacheDir = dir;
                }
                return setting;
            }
            throw new IllegalArgumentException("Illegal max log size: " + this.maxLogSize);
        }

        private void ensureLogDir(LogSetting setting) {
            setting.mLogDir = this.mContext.getDir(LogSetting.DEFAULT_DIR, 0);
        }
    }
}