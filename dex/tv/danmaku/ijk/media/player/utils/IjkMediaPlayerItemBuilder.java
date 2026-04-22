package tv.danmaku.ijk.media.player.utils;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import tv.danmaku.ijk.media.player.IjkLibLoader;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.ijk.media.player.IjkMediaConfigParams;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;

public class IjkMediaPlayerItemBuilder {
    private Context mContext;
    private int mScheme;
    private IjkLibLoader mLibLoader = null;
    private Looper mLooper = null;
    private IjkMediaConfigParams mConfig = new IjkMediaConfigParams();
    private IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener mAssetListener = null;
    private ArrayList<IjkMediaAsset.MediaAssetStream> mStreams = new ArrayList<>();
    private int mDefaultVideoIdentifier = -1;
    private int mDefaultAudioIdentifier = -1;

    public IjkMediaPlayerItemBuilder(Context context, int scheme) {
        this.mContext = null;
        this.mScheme = 0;
        this.mContext = context;
        this.mScheme = scheme;
        switch (this.mScheme) {
            case 1:
            case 9:
                this.mConfig.mEnableP2PDownload = false;
                this.mConfig.mEnableHwCodec = true;
                this.mConfig.mEnableEarlyFrameDrop = true;
                this.mConfig.mMultiBufferingControl = 1;
                break;
            case 2:
            case 3:
            case 6:
                this.mConfig.mEnableHwCodec = true;
                this.mConfig.mEnableEarlyFrameDrop = true;
                this.mConfig.mEnableP2PDownload = true;
                break;
            case 5:
                this.mConfig.mEnableHwCodec = true;
                this.mConfig.mEnableEarlyFrameDrop = true;
                this.mConfig.mEnableP2PDownload = false;
                break;
            case 7:
            case 8:
                this.mConfig.mEnableEarlyFrameDrop = false;
                this.mConfig.mEnableHwCodec = false;
                this.mConfig.mEnableP2PDownload = false;
                break;
        }
        this.mConfig.mStartOnPrepared = true;
    }

    public void addNormalStream(String url) {
        if (!this.mStreams.isEmpty() || TextUtils.isEmpty(url)) {
            return;
        }
        String[] urls = {url};
        addNormalStream(urls, 0, 0L, 0L);
    }

    public void addVideoStream(String url, int identifier) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        String[] urls = {url};
        addVideoStream(urls, identifier, IjkMediaAsset.VideoCodecType.H264, 0L, 0L);
    }

    public void addAudioStream(String url, int identifier) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        String[] urls = {url};
        addAudioStream(urls, identifier, IjkMediaAsset.AudioCodecType.UNKNOWN, 0L, 0L);
    }

    public void addDrmStream(String url, int drmType, String drmKid) {
        if (!this.mStreams.isEmpty() || TextUtils.isEmpty(url)) {
            return;
        }
        String[] urls = {url};
        addDrmStream(urls, 0, 0L, 0L, drmType, drmKid);
    }

    public void addDrmVideoStream(String url, int identifier, int drmType, String drmKid) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        String[] urls = {url};
        addDrmVideoStream(urls, identifier, IjkMediaAsset.VideoCodecType.H264, 0L, 0L, drmType, drmKid);
    }

    public void addDrmAudioStream(String url, int identifier, int drmType, String drmKid) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        String[] urls = {url};
        addDrmAudioStream(urls, identifier, IjkMediaAsset.AudioCodecType.UNKNOWN, 0L, 0L, drmType, drmKid);
    }

    public void addNormalStream(String[] url, int identifier, long size, long duration) {
        if (!this.mStreams.isEmpty() || url.length == 0) {
            return;
        }
        IjkMediaAsset.MediaAssetStream.Builder builder = new IjkMediaAsset.MediaAssetStream.Builder(IjkMediaAsset.StreamType.NORMAL, IjkMediaAsset.VideoCodecType.UNKNOWN, identifier);
        ArrayList<String> backup = null;
        if (url.length > 1) {
            backup = new ArrayList<>();
            for (int i = 1; i < url.length; i++) {
                backup.add(url[i]);
            }
        }
        IjkMediaAsset.MediaAssertSegment segment = new IjkMediaAsset.MediaAssertSegment.Builder(url[0], (int) duration).setBackupUrls(backup).setSize(size).build();
        builder.setMediaAssertSegments(Collections.singletonList(segment));
        this.mStreams.add(builder.build());
    }

    public void addVideoStream(String[] url, int identifier, IjkMediaAsset.VideoCodecType codecType, long size, long duration) {
        if (url.length == 0) {
            return;
        }
        IjkMediaAsset.MediaAssetStream.Builder builder = new IjkMediaAsset.MediaAssetStream.Builder(IjkMediaAsset.StreamType.DASH_VIDEO, codecType, identifier);
        ArrayList<String> backup = null;
        if (url.length > 1) {
            backup = new ArrayList<>();
            for (int i = 1; i < url.length; i++) {
                backup.add(url[i]);
            }
        }
        IjkMediaAsset.MediaAssertSegment segment = new IjkMediaAsset.MediaAssertSegment.Builder(url[0], (int) duration).setBackupUrls(backup).setSize(size).build();
        builder.setMediaAssertSegments(Collections.singletonList(segment));
        this.mStreams.add(builder.build());
    }

    public void addAudioStream(String[] url, int identifier, IjkMediaAsset.AudioCodecType codecType, long size, long duration) {
        if (url.length == 0) {
            return;
        }
        IjkMediaAsset.MediaAssetStream.Builder builder = new IjkMediaAsset.MediaAssetStream.Builder(IjkMediaAsset.StreamType.DASH_AUDIO, codecType, identifier);
        ArrayList<String> backup = null;
        if (url.length > 1) {
            backup = new ArrayList<>();
            for (int i = 1; i < url.length; i++) {
                backup.add(url[i]);
            }
        }
        IjkMediaAsset.MediaAssertSegment segment = new IjkMediaAsset.MediaAssertSegment.Builder(url[0], (int) duration).setBackupUrls(backup).setSize(size).build();
        builder.setMediaAssertSegments(Collections.singletonList(segment));
        this.mStreams.add(builder.build());
    }

    public void addDrmStream(String[] url, int identifier, long size, long duration, int drmType, String drmKid) {
        if (!this.mStreams.isEmpty() || url.length == 0) {
            return;
        }
        IjkMediaAsset.MediaAssetStream.Builder builder = new IjkMediaAsset.MediaAssetStream.Builder(IjkMediaAsset.StreamType.NORMAL, IjkMediaAsset.VideoCodecType.UNKNOWN, identifier, drmType, drmKid);
        ArrayList<String> backup = null;
        if (url.length > 1) {
            backup = new ArrayList<>();
            for (int i = 1; i < url.length; i++) {
                backup.add(url[i]);
            }
        }
        IjkMediaAsset.MediaAssertSegment segment = new IjkMediaAsset.MediaAssertSegment.Builder(url[0], (int) duration).setBackupUrls(backup).setSize(size).build();
        builder.setMediaAssertSegments(Collections.singletonList(segment));
        this.mStreams.add(builder.build());
    }

    public void addDrmVideoStream(String[] url, int identifier, IjkMediaAsset.VideoCodecType codecType, long size, long duration, int drmType, String drmKid) {
        if (url.length == 0) {
            return;
        }
        IjkMediaAsset.MediaAssetStream.Builder builder = new IjkMediaAsset.MediaAssetStream.Builder(IjkMediaAsset.StreamType.DASH_VIDEO, codecType, identifier, drmType, drmKid);
        ArrayList<String> backup = null;
        if (url.length > 1) {
            backup = new ArrayList<>();
            for (int i = 1; i < url.length; i++) {
                backup.add(url[i]);
            }
        }
        IjkMediaAsset.MediaAssertSegment segment = new IjkMediaAsset.MediaAssertSegment.Builder(url[0], (int) duration).setBackupUrls(backup).setSize(size).build();
        builder.setMediaAssertSegments(Collections.singletonList(segment));
        this.mStreams.add(builder.build());
    }

    public void addDrmAudioStream(String[] url, int identifier, IjkMediaAsset.AudioCodecType codecType, long size, long duration, int drmType, String drmKid) {
        if (url.length == 0) {
            return;
        }
        IjkMediaAsset.MediaAssetStream.Builder builder = new IjkMediaAsset.MediaAssetStream.Builder(IjkMediaAsset.StreamType.DASH_AUDIO, codecType, identifier, drmType, drmKid);
        ArrayList<String> backup = null;
        if (url.length > 1) {
            backup = new ArrayList<>();
            for (int i = 1; i < url.length; i++) {
                backup.add(url[i]);
            }
        }
        IjkMediaAsset.MediaAssertSegment segment = new IjkMediaAsset.MediaAssertSegment.Builder(url[0], (int) duration).setBackupUrls(backup).setSize(size).build();
        builder.setMediaAssertSegments(Collections.singletonList(segment));
        this.mStreams.add(builder.build());
    }

    public void setDefaultVideoIdentifier(int identifier) {
        this.mDefaultVideoIdentifier = identifier;
    }

    public void setDefaultAudioIdentifier(int identifier) {
        this.mDefaultAudioIdentifier = identifier;
    }

    public void setAssetListener(IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener listener) {
        this.mAssetListener = listener;
    }

    public void setConfig(IjkMediaConfigParams config) {
        this.mConfig = config;
    }

    public IjkMediaConfigParams getConfig() {
        return this.mConfig;
    }

    public IjkMediaPlayerItem build() {
        IjkMediaPlayerItem item = new IjkMediaPlayerItem(this.mLibLoader, this.mContext, this.mLooper, this.mScheme);
        IjkMediaAsset asset = new IjkMediaAsset.Builder(this.mStreams, this.mDefaultVideoIdentifier, this.mDefaultAudioIdentifier).build();
        item.init(asset, this.mConfig);
        if (this.mAssetListener != null) {
            item.setAssetUpdateListener(this.mAssetListener);
        }
        return item;
    }
}