package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.text.TextUtils;
import io.grpc.ManagedChannel;
import p2p.io.grpc.ignet.IgnetChannelBuilder;
import tv.danmaku.android.log.BLog;

public class GrpcClient {
    private static final String TAG = "IJKMEDIA_GrpcClient";
    private static GrpcClient sGrpcClient;
    boolean mIsInited;
    private ManagedChannel mLiveManagedChannel;
    private String mLiveTrackerServerHost;
    private ManagedChannel mManagedChannel;
    private String mTrackerServerHost;
    private final int port = 443;

    private GrpcClient() {
    }

    public static synchronized GrpcClient getInstance(Context context) {
        GrpcClient grpcClient;
        synchronized (GrpcClient.class) {
            if (sGrpcClient == null) {
                sGrpcClient = new GrpcClient();
            }
            grpcClient = sGrpcClient;
        }
        return grpcClient;
    }

    public static synchronized GrpcClient getInstance() {
        GrpcClient grpcClient;
        synchronized (GrpcClient.class) {
            grpcClient = sGrpcClient;
        }
        return grpcClient;
    }

    public void init(String host, String liveHost) {
        if (TextUtils.isEmpty(host) && TextUtils.isEmpty(liveHost)) {
            return;
        }
        synchronized (this) {
            if (this.mIsInited) {
                return;
            }
            this.mIsInited = true;
            this.mTrackerServerHost = host;
            this.mLiveTrackerServerHost = liveHost;
            BLog.i(TAG, "tracker server " + host);
            BLog.i(TAG, "live tracker server " + liveHost);
            this.mManagedChannel = IgnetChannelBuilder.forAddress(host, 443, "").build();
            if (!TextUtils.isEmpty(this.mLiveTrackerServerHost)) {
                this.mLiveManagedChannel = IgnetChannelBuilder.forAddress(liveHost, 443, "").build();
            }
        }
    }

    public ManagedChannel getChannel(boolean isLive) {
        ManagedChannel managedChannel;
        synchronized (this) {
            managedChannel = isLive ? this.mLiveManagedChannel : this.mManagedChannel;
        }
        return managedChannel;
    }

    public ManagedChannel switchChannel(String host, boolean isLive) {
        synchronized (this) {
            if (!this.mIsInited) {
                this.mIsInited = true;
            }
            if (!isLive) {
                if (this.mManagedChannel != null) {
                    this.mManagedChannel.shutdownNow();
                }
                BLog.i(TAG, "tracker server switch " + host);
                this.mTrackerServerHost = host;
                this.mManagedChannel = IgnetChannelBuilder.forAddress(host, 443, "").build();
                return this.mManagedChannel;
            }
            if (this.mLiveManagedChannel != null) {
                this.mLiveManagedChannel.shutdownNow();
            }
            BLog.i(TAG, "live tracker server switch " + host);
            this.mLiveTrackerServerHost = host;
            this.mLiveManagedChannel = IgnetChannelBuilder.forAddress(host, 443, "").build();
            return this.mLiveManagedChannel;
        }
    }

    public String getTrackerServerHost() {
        String str;
        synchronized (this) {
            str = this.mTrackerServerHost;
        }
        return str;
    }

    public String getLiveTrackerServerHost() {
        String str;
        synchronized (this) {
            str = this.mLiveTrackerServerHost;
        }
        return str;
    }
}