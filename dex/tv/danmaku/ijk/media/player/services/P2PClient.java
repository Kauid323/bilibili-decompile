package tv.danmaku.ijk.media.player.services;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IP2P;

public class P2PClient extends IP2P.Stub {
    private static final String K_P2P_LIVE_TRACKER_CHANNEL_FD = "p2p_live_tracker_channel_fd";
    private static final String K_P2P_VOD_TRACKER_CHANNEL_FD = "p2p_vod_tracker_channel_fd";
    private boolean mIsInitSuccess;
    private ParcelFileDescriptor[] mTrackerChannelFd = new ParcelFileDescriptor[2];

    private native void _create(String str);

    private native void _dump(int i);

    private native int _getHttpServerPort();

    private native void _nofityConfigChange(String str, boolean z);

    private native void _nofityNetWorkChange(int i, int i2);

    private native int _openTrackerChannelPair(int[] iArr);

    public P2PClient(Bundle configs) {
        this.mIsInitSuccess = false;
        JSONObject object = createJsonConfig(configs);
        int[] sockets = new int[2];
        if (_openTrackerChannelPair(sockets) >= 0) {
            this.mTrackerChannelFd[0] = ParcelFileDescriptor.adoptFd(sockets[0]);
            try {
                object.put(K_P2P_VOD_TRACKER_CHANNEL_FD, sockets[1]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            int[] liveSockets = new int[2];
            if (_openTrackerChannelPair(liveSockets) >= 0) {
                this.mTrackerChannelFd[1] = ParcelFileDescriptor.adoptFd(liveSockets[0]);
                try {
                    object.put(K_P2P_LIVE_TRACKER_CHANNEL_FD, liveSockets[1]);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.mIsInitSuccess = true;
                _create(object.toString());
            }
        }
    }

    private JSONObject createJsonConfig(Bundle configs) {
        JSONObject object = new JSONObject();
        if (configs == null) {
            return object;
        }
        try {
            for (String key : configs.keySet()) {
                Object value = configs.get(key);
                if (value instanceof String) {
                    object.put(key, (String) value);
                } else if (value instanceof Long) {
                    object.put(key, ((Long) value).longValue());
                } else if (value instanceof Integer) {
                    object.put(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    object.put(key, ((Long) value).longValue());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override // tv.danmaku.ijk.media.player.IP2P
    public void nofityNetWorkChange(int newType, int oldType) throws RemoteException {
        _nofityNetWorkChange(newType, oldType);
    }

    @Override // tv.danmaku.ijk.media.player.IP2P
    public void notifyConfigChange(Bundle config) throws RemoteException {
        JSONObject jsonObject = createJsonConfig(config);
        _nofityConfigChange(jsonObject.toString(), config == null);
    }

    @Override // tv.danmaku.ijk.media.player.IP2P
    public ParcelFileDescriptor[] getTrackerChannelFd() {
        if (this.mIsInitSuccess) {
            try {
                ParcelFileDescriptor[] channels = {this.mTrackerChannelFd[0].dup(), this.mTrackerChannelFd[1].dup()};
                return channels;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // tv.danmaku.ijk.media.player.IP2P
    public int getHttpServerPort() throws RemoteException {
        return _getHttpServerPort();
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        try {
            ParcelFileDescriptor pfd = ParcelFileDescriptor.dup(fd);
            _dump(pfd.getFd());
            pfd.close();
        } catch (IOException e) {
        }
    }
}