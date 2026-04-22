package tv.danmaku.ijk.media.player;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bilibili.lib.p2p.DeviceRelease;
import com.bilibili.lib.p2p.DeviceType;
import com.bilibili.lib.p2p.EncryptType;
import com.bilibili.lib.p2p.ErrorCode;
import com.bilibili.lib.p2p.GetPeerInfoRequest;
import com.bilibili.lib.p2p.GetPeerInfoResponse;
import com.bilibili.lib.p2p.HeartbeatRequest;
import com.bilibili.lib.p2p.HeartbeatResponse;
import com.bilibili.lib.p2p.LoginRequest;
import com.bilibili.lib.p2p.LoginResponse;
import com.bilibili.lib.p2p.LogoutRequest;
import com.bilibili.lib.p2p.MagicAndJsonEncryptLevel;
import com.bilibili.lib.p2p.ManuscriptType;
import com.bilibili.lib.p2p.NATType;
import com.bilibili.lib.p2p.NetworkType;
import com.bilibili.lib.p2p.OverLoadType;
import com.bilibili.lib.p2p.P2PStrategy;
import com.bilibili.lib.p2p.PeerInfo;
import com.bilibili.lib.p2p.PlayKind;
import com.bilibili.lib.p2p.PlayType;
import com.bilibili.lib.p2p.ReflexAddr;
import com.bilibili.lib.p2p.RegisterGrpc;
import com.bilibili.lib.p2p.ReleasePeerInfoRequest;
import com.bilibili.lib.p2p.ReleaseType;
import com.bilibili.lib.p2p.ReportRequest;
import com.bilibili.lib.p2p.Resource;
import com.bilibili.lib.p2p.ResourceType;
import com.bilibili.lib.p2p.SegmentSection;
import com.bilibili.lib.p2p.SuperNodeRelease;
import com.bilibili.lib.p2p.UploadPriorityType;
import com.bilibili.lib.p2p.WatchConnectRequest;
import com.bilibili.lib.p2p.WatchConnectResponse;
import com.bilibili.lib.p2p.WatchHotPushRequest;
import com.bilibili.lib.p2p.WatchHotPushResponse;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.StreamObserver;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.utils.P2PManuscriptInfo;
import tv.danmaku.ijk.media.player.utils.P2PServerResolver;

public class P2PTrackerClientProxy {
    private static final String K_ENCRYPT_MAGIC_LEVEL = "subscribe_reserved";
    private static final String K_HOT_PUSH_TYPE = "hot_push_type";
    private static final String K_MSG_TYPE = "msg_type";
    private static final String K_P2P_DOWNLOAD_TYPE = "p2p_download_type";
    private static final String K_P2P_HOT_PUSH_TIME = "p2p_hot_push_time";
    private static final String K_P2P_SEGMENT_ID_END = "segment_id_end";
    private static final String K_P2P_SEGMENT_ID_START = "segment_id_start";
    private static final String K_P2P_STREAM_TOTAL_COUNT = "p2p_stream_total_count";
    private static final String K_P2P_SUPER_NODE_DOWNLOAD_GIVEN_GAP_TIME_COST = "p2p_super_node_download_given_gap_time_cost";
    private static final String K_P2P_SUPER_NODE_ERROR_CODE = "p2p_super_node_error_code";
    private static final String K_P2P_SUPER_NODE_ERROR_DETAIL = "p2p_super_node_error_detail";
    private static final String K_P2P_SUPER_NODE_FIRST_PACKET_TIME_MS = "p2p_super_node_first_packet_time";
    private static final String K_P2P_SUPER_NODE_IP = "p2p_super_node_ip";
    private static final String K_P2P_SUPER_NODE_RESOURCE_BITRATE = "p2p_super_node_resource_bitrate";
    private static final String K_P2P_TRACKER_REQUEST_URL = "p2p_tracker_request_url";
    private static final String K_PEER_DEVICE_ID = "device_id";
    private static final String K_PEER_DEVICE_IDS = "device_ids";
    private static final String K_PEER_DEVICE_TYPE = "device_type";
    private static final String K_PEER_ENCRYPT_TYPE = "encrypt_type";
    private static final String K_PEER_EXTRA_REFLEX_ADDRS = "extra_reflex_addrs";
    private static final String K_PEER_INFO = "peer_info";
    private static final String K_PEER_INFOS = "peer_infos";
    private static final String K_PEER_IPV6_IP = "ipv6_ip";
    private static final String K_PEER_IPV6_PORT = "ipv6_port";
    private static final String K_PEER_KCP_VERSION = "kcp_version";
    private static final String K_PEER_LOCAL_IP = "local_ip";
    private static final String K_PEER_LOCAL_PORT = "local_port";
    private static final String K_PEER_NAT_TYPE = "nat_type";
    private static final String K_PEER_NEED_COUNT = "peer_need_count";
    private static final String K_PEER_NETWORK_TYPE = "network_type";
    private static final String K_PEER_OVERLOAD_OR_NOT = "overload_or_not";
    private static final String K_PEER_P2P_STRATEGY = "p2p_strategy";
    private static final String K_PEER_P2P_VERSION = "p2p_version";
    private static final String K_PEER_REFLEX_IP = "reflex_ip";
    private static final String K_PEER_REFLEX_PORT = "reflex_port";
    private static final String K_PEER_RELEASE_DEVICE = "release_device";
    private static final String K_PEER_ROUTER_IP = "router_ip";
    private static final String K_PEER_ROUTER_PORT = "router_port";
    private static final String K_PEER_STORAGE_CAP = "storage_cap";
    private static final String K_PEER_SUB_STREAM_INDEX = "sub_stream_index";
    private static final String K_PEER_TCP_LISTEN_IP = "tcp_listen_ip";
    private static final String K_PEER_TCP_LISTEN_PORT = "tcp_listen_port";
    private static final String K_PEER_TOTAL_SUB_STREAMS = "total_sub_streams";
    private static final String K_PEER_UPLOAD_SPEED = "upload_speed";
    private static final String K_PLAY_KIND = "play_kind";
    private static final String K_QUALITY_SCORE = "quality_score";
    private static final String K_RESOURCE_AID = "resource_aid";
    private static final String K_RESOURCE_BITRATE = "resource_bitrate";
    private static final String K_RESOURCE_ID = "resource_id";
    private static final String K_RESOURCE_ID_ADD = "resource_id_add";
    private static final String K_RESOURCE_ID_DELETE = "resource_id_delete";
    private static final String K_RESOURCE_TYPE = "resource_type";
    private static final String K_RESOURCE_URL = "resource_url";
    private static final String K_RID_POINT = "rid_point";
    private static final String K_SEGMENTS = "segments";
    private static final String K_SESSION_ID = "session_id";
    private static final String K_UPLOAD_PRIORITY = "upload_priority";
    private static final int MSG_DO_RELEASE = 4;
    private static final int MSG_READ_DESCRIPTOR = 1;
    private static final int MSG_SWITCH_NEW_TRACKER = 5;
    private static final int MSG_SWITCH_TRACKER = 3;
    private static final int MSG_WRITE_DESCRIPTOR = 2;
    public static final int PROTOCOL_BUFFER_VERSION = 3;
    private static final int SWITCH_TRACKER_INTERVAL_MS = 5000;
    private static final String TAG = "IJKMEDIA_P2PTrackerClientProxy";
    private static final int TRACKER_MAX_ERROR_COUNTER = 2;
    private ManagedChannel mChannel;
    private FdEventLister mFdEventLister;
    private DescriptorMessageHandler mHandler;
    private HandlerThread mHandlerThread;
    private FileInputStream mInput;
    private boolean mIsLive;
    private FileOutputStream mOutput;
    private P2PServerResolver mP2PServerResolver;
    private ParcelFileDescriptor mParcelFileDescriptor;
    private PeerInfo mPeerInfo;
    private boolean mStickyTrackerServerError;
    private String mTag;
    private int mTrackerServerErrorCounter;
    private boolean mTrackerServerHasError;
    private List<String> mTrackerServers;
    private final int LIVE_DASH = 0;
    private final int LIVE_FLV = 1;
    private final int LIVE_HLS = 2;
    private final int VOD_DASH = 3;
    private final int VOD_FLV = 4;
    private final String K_PARAM_DEVICE_ID = K_PEER_DEVICE_ID;
    private final String K_PARAM_RESOURCE_ID = K_RESOURCE_ID;
    private final String K_PARAM_RESOURCE_TYPE = K_RESOURCE_TYPE;
    private final String K_PARAM_RESOURCE_SIZE = "resource_size";
    private final String K_PARAM_SESSION_ID = K_SESSION_ID;
    private final String K_PARAM_BITRATE = K_RESOURCE_BITRATE;
    private final String K_PARAM_SUB_SEGMENT = "sub_segment";
    private final String K_PARAM_RESOURCE_AVID = K_RESOURCE_AID;
    private final String K_SEGMENT_ID = "segment_id";
    private final String K_P2P_PLAY_TYPE = "p2p_play_type";
    private final String K_P2P_LIVE_SEGMENT = "live_segment";
    private String mTransId = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum TRACKER_MSG_TYPE {
        TRACKER_RESPONSE_PEERINFO,
        TRACKER_PUSH_PEER_CONNECT,
        TRACKER_PUSH_DOWNLOAD_TASK,
        TRACKER_RESPONSE_DOWNLOAD_PRIORITY,
        TRACKER_GET_PEER_INFO,
        TRACKER_LOGIN,
        TRACKER_LOGOUT,
        TRACKER_HEARTBEAT,
        TRACKER_REPORT_PEERINFO,
        TRACKER_RELEASE_PEERINFO
    }

    public P2PTrackerClientProxy(ParcelFileDescriptor pfd, P2PServerResolver resolver, boolean isLive) {
        if (isLive) {
            this.mTag = "IJKMEDIA_P2PTrackerClientProxy[live][" + GrpcClient.getInstance().getLiveTrackerServerHost() + "]";
        } else {
            this.mTag = "IJKMEDIA_P2PTrackerClientProxy[vod][" + GrpcClient.getInstance().getTrackerServerHost() + "]";
        }
        if (pfd == null) {
            BLog.w(this.mTag, "ParcelFileDescriptor is null!!!");
            return;
        }
        this.mIsLive = isLive;
        this.mP2PServerResolver = resolver;
        this.mHandlerThread = new HandlerThread("ijk_cts_tcpy");
        this.mHandlerThread.start();
        this.mHandler = new DescriptorMessageHandler(this, this.mHandlerThread.getLooper());
        this.mParcelFileDescriptor = pfd;
        this.mInput = new FileInputStream(this.mParcelFileDescriptor.getFileDescriptor());
        this.mOutput = new FileOutputStream(this.mParcelFileDescriptor.getFileDescriptor());
        this.mFdEventLister = new FdEventLister(this);
        this.mHandlerThread.getLooper().getQueue().addOnFileDescriptorEventListener(this.mParcelFileDescriptor.getFileDescriptor(), 1, this.mFdEventLister);
        this.mChannel = GrpcClient.getInstance().getChannel(this.mIsLive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DescriptorMessageHandler extends Handler {
        private final WeakReference<P2PTrackerClientProxy> mWeakProxy;

        public DescriptorMessageHandler(P2PTrackerClientProxy proxy, Looper looper) {
            super(looper);
            this.mWeakProxy = new WeakReference<>(proxy);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            P2PTrackerClientProxy proxy = this.mWeakProxy.get();
            if (proxy == null) {
                return;
            }
            switch (msg.what) {
                case 1:
                    sendEmptyMessageDelayed(1, 10L);
                    try {
                        if (proxy.mInput.available() > 0) {
                            proxy.handleClientRequest(proxy.handleTrackerFdRead());
                            return;
                        }
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                case 2:
                    JSONObject json = (JSONObject) msg.obj;
                    String jsonStr = json.toString();
                    try {
                        int length = jsonStr.length();
                        BLog.d(proxy.mTag, "response client length " + length);
                        byte[] value = new byte[4];
                        for (int i = 0; i < 4; i++) {
                            value[i] = (byte) (length & 255);
                            length >>= 8;
                        }
                        proxy.mOutput.write(value);
                        proxy.mOutput.write(jsonStr.getBytes());
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                case 3:
                    if (proxy.mTrackerServers == null || proxy.mTrackerServers.size() <= 0) {
                        proxy.mP2PServerResolver.setNeedResolved();
                        if (proxy.mP2PServerResolver.resolve()) {
                            List<String> trackers = proxy.mIsLive ? proxy.mP2PServerResolver.getLiveTrackerServers() : proxy.mP2PServerResolver.getTrackerServers();
                            if (trackers != null && trackers.size() > 0 && !TextUtils.isEmpty(trackers.get(0))) {
                                proxy.mTrackerServers = trackers;
                            }
                        }
                    }
                    if (proxy.mTrackerServers != null && proxy.mTrackerServers.size() > 0) {
                        proxy.mChannel = GrpcClient.getInstance().switchChannel((String) proxy.mTrackerServers.get(0), proxy.mIsLive);
                        proxy.mTrackerServers.remove(0);
                        proxy.mTrackerServerErrorCounter = 0;
                        if (proxy.mIsLive) {
                            proxy.mTag = "IJKMEDIA_P2PTrackerClientProxy[live][" + GrpcClient.getInstance().getLiveTrackerServerHost() + "]";
                            return;
                        } else {
                            proxy.mTag = "IJKMEDIA_P2PTrackerClientProxy[vod][" + GrpcClient.getInstance().getTrackerServerHost() + "]";
                            return;
                        }
                    } else if (!hasMessages(3)) {
                        sendMessageDelayed(obtainMessage(3), 60000L);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    proxy.mHandler.removeCallbacksAndMessages(null);
                    proxy.mHandlerThread.quit();
                    try {
                        proxy.mInput.close();
                        proxy.mOutput.close();
                        proxy.mParcelFileDescriptor.close();
                        return;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return;
                    }
                case 5:
                    if (proxy.mP2PServerResolver.resolve()) {
                        proxy.mTrackerServers = proxy.mIsLive ? proxy.mP2PServerResolver.getLiveTrackerServers() : proxy.mP2PServerResolver.getTrackerServers();
                        if (proxy.mTrackerServers != null && proxy.mTrackerServers.size() > 0) {
                            proxy.mChannel = GrpcClient.getInstance().switchChannel((String) proxy.mTrackerServers.get(0), proxy.mIsLive);
                            proxy.mTrackerServers.remove(0);
                            if (proxy.mIsLive) {
                                proxy.mTag = "IJKMEDIA_P2PTrackerClientProxy[live][" + GrpcClient.getInstance().getLiveTrackerServerHost() + "]";
                                return;
                            } else {
                                proxy.mTag = "IJKMEDIA_P2PTrackerClientProxy[vod][" + GrpcClient.getInstance().getTrackerServerHost() + "]";
                                return;
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class FdEventLister implements MessageQueue.OnFileDescriptorEventListener {
        private final WeakReference<P2PTrackerClientProxy> mWeakProxy;

        public FdEventLister(P2PTrackerClientProxy proxy) {
            this.mWeakProxy = new WeakReference<>(proxy);
        }

        @Override // android.os.MessageQueue.OnFileDescriptorEventListener
        public int onFileDescriptorEvents(FileDescriptor fileDescriptor, int i) {
            P2PTrackerClientProxy proxy = this.mWeakProxy.get();
            if (proxy == null || proxy.mHandlerThread.isInterrupted() || (i & 1) == 0) {
                return 0;
            }
            try {
                if (proxy.mInput.available() <= 0) {
                    return 0;
                }
                proxy.handleClientRequest(proxy.handleTrackerFdRead());
                return 1;
            } catch (IOException e) {
                e.printStackTrace();
                return 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class TrackerStreamObserver implements StreamObserver {
        private TRACKER_MSG_TYPE mMsgType;
        private final WeakReference<P2PTrackerClientProxy> mWeakProxy;

        public TrackerStreamObserver(P2PTrackerClientProxy proxy, TRACKER_MSG_TYPE msg) {
            this.mMsgType = msg;
            this.mWeakProxy = new WeakReference<>(proxy);
        }

        public void onNext(Object value) {
            P2PTrackerClientProxy proxy = this.mWeakProxy.get();
            if (proxy == null || value == null) {
                return;
            }
            JSONObject json = new JSONObject();
            switch (this.mMsgType) {
                case TRACKER_PUSH_PEER_CONNECT:
                    WatchConnectResponse watchConnectResponse = (WatchConnectResponse) value;
                    json = P2PTrackerClientProxy.PushConnectRespToJson(watchConnectResponse);
                    break;
                case TRACKER_GET_PEER_INFO:
                    GetPeerInfoResponse getPeerInfoResponse = (GetPeerInfoResponse) value;
                    json = P2PTrackerClientProxy.GetPeerInfoRespToJson(getPeerInfoResponse);
                    break;
                case TRACKER_HEARTBEAT:
                    HeartbeatResponse heartbeatResponse = (HeartbeatResponse) value;
                    json = P2PTrackerClientProxy.HeartbeatRespToJson(heartbeatResponse);
                    break;
                case TRACKER_PUSH_DOWNLOAD_TASK:
                    WatchHotPushResponse hostpush = (WatchHotPushResponse) value;
                    json = P2PTrackerClientProxy.HotPushRespToJson(hostpush);
                    break;
            }
            if (json.length() > 0) {
                Message msg = proxy.mHandler.obtainMessage(2);
                msg.obj = json;
                BLog.d(proxy.mTag, "TrackerStreamObserver " + this.mMsgType + " onNext " + json.toString());
                proxy.mHandler.sendMessage(msg);
            }
        }

        public void onError(Throwable t) {
            P2PTrackerClientProxy proxy = this.mWeakProxy.get();
            if (proxy == null || proxy.mTrackerServerHasError) {
                return;
            }
            BLog.w(proxy.mTag, "TrackerStreamObserver " + this.mMsgType + " onError " + t);
            proxy.mTrackerServerHasError = true;
            proxy.mTrackerServerErrorCounter++;
            if (P2PTrackerClientProxy.this.mTrackerServerErrorCounter >= 2 && !P2PTrackerClientProxy.this.mHandler.hasMessages(3)) {
                Message msg = P2PTrackerClientProxy.this.mHandler.obtainMessage(3);
                P2PTrackerClientProxy.this.mHandler.sendMessageDelayed(msg, PlayerToastConfig.DURATION_5);
            }
        }

        public void onCompleted() {
            P2PTrackerClientProxy proxy = this.mWeakProxy.get();
            if (proxy == null) {
                return;
            }
            BLog.d(proxy.mTag, "TrackerStreamObserver " + this.mMsgType + " onCompleted");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClientRequest(String jsonMsg) {
        try {
            BLog.d(this.mTag, jsonMsg);
            JSONObject jsonObject = new JSONObject(jsonMsg);
            int type = jsonObject.optInt(K_MSG_TYPE);
            TRACKER_MSG_TYPE msgType = TRACKER_MSG_TYPE.values()[type];
            if (this.mStickyTrackerServerError) {
                BLog.i(this.mTag, "sticky tracker server error , ignore all msg!!");
            } else if (this.mTrackerServerHasError && (this.mTrackerServerErrorCounter >= 2 || msgType != TRACKER_MSG_TYPE.TRACKER_LOGIN)) {
                BLog.i(this.mTag, "tracker server error , ignore msg " + msgType);
            } else {
                if (this.mChannel == null) {
                    this.mChannel = GrpcClient.getInstance().getChannel(this.mIsLive);
                }
                try {
                    switch (msgType) {
                        case TRACKER_GET_PEER_INFO:
                            BLog.d(this.mTag, "TRACKER_GET_PEER_INFO");
                            GetPeerInfo get = new GetPeerInfo(jsonObject);
                            ClientCalls.asyncUnaryCall(this.mChannel.newCall(RegisterGrpc.getGetPeerInfoMethod(), CallOptions.DEFAULT), get.mRequest, new TrackerStreamObserver(this, msgType));
                            if (this.mPeerInfo != null) {
                                JSONObject json = new JSONObject();
                                JSONArray array = new JSONArray();
                                JSONObject object = new JSONObject();
                                PeerInfoHelper.writeToJson(this.mPeerInfo, object);
                                array.put(object);
                                json.put(K_MSG_TYPE, TRACKER_MSG_TYPE.TRACKER_RESPONSE_PEERINFO.ordinal());
                                json.put(K_SESSION_ID, get.mRequest.getSessionId());
                                json.put(K_PEER_INFOS, array);
                                Message msg = this.mHandler.obtainMessage(2);
                                msg.obj = json;
                                this.mHandler.sendMessage(msg);
                                break;
                            }
                            break;
                        case TRACKER_HEARTBEAT:
                            Heartbeat heartbeat = new Heartbeat(jsonObject);
                            ClientCalls.asyncUnaryCall(this.mChannel.newCall(RegisterGrpc.getHeartbeatMethod(), CallOptions.DEFAULT), heartbeat.mRequest, new TrackerStreamObserver(this, msgType));
                            break;
                        case TRACKER_LOGIN:
                            BLog.d(this.mTag, "TRACKER_LOGIN");
                            this.mTrackerServerHasError = false;
                            Login login = new Login(jsonObject);
                            LoginResponse response = (LoginResponse) ClientCalls.blockingUnaryCall(this.mChannel.newCall(RegisterGrpc.getLoginMethod(), CallOptions.DEFAULT), login.mRequest);
                            ErrorCode errorCode = response.getStatus().getStatusCode();
                            if (errorCode != ErrorCode.BadRequest && errorCode != ErrorCode.UNRECOGNIZED && errorCode != ErrorCode.VersionNotSupported && response.getVersion() <= 3) {
                                if (errorCode != ErrorCode.OK) {
                                    BLog.w(this.mTag, " error " + errorCode + " retry !!");
                                    this.mTrackerServerHasError = true;
                                    break;
                                } else {
                                    this.mTrackerServerErrorCounter = 0;
                                    this.mTransId = response.getTransId();
                                    BLog.i(this.mTag, "tiantian response.getTransId() " + response.getTransId());
                                    if (login.mRequest.getPeer().getP2PStrategy() != P2PStrategy.STRATEGY_DOWNLOAD_NO_UPLOAD) {
                                        ClientCalls.asyncServerStreamingCall(this.mChannel.newCall(RegisterGrpc.getWatchConnectMethod(), CallOptions.DEFAULT), WatchConnectRequest.newBuilder().setDeviceId(login.mDeviceId).setTransId(this.mTransId).build(), new TrackerStreamObserver(this, TRACKER_MSG_TYPE.TRACKER_PUSH_PEER_CONNECT));
                                    }
                                    if (login.mRequest.getPeer().getP2PStrategy() == P2PStrategy.STRATEGY_HOT_PUSH) {
                                        ClientCalls.asyncServerStreamingCall(this.mChannel.newCall(RegisterGrpc.getWatchHotPushMethod(), CallOptions.DEFAULT), WatchHotPushRequest.newBuilder().setDeviceId(login.mDeviceId).setTransId(this.mTransId).build(), new TrackerStreamObserver(this, TRACKER_MSG_TYPE.TRACKER_PUSH_DOWNLOAD_TASK));
                                        break;
                                    }
                                }
                            }
                            BLog.w(this.mTag, "tracker server pb version " + response.getVersion() + " client version 3 error " + errorCode);
                            this.mStickyTrackerServerError = true;
                            break;
                        case TRACKER_LOGOUT:
                            BLog.d(this.mTag, "TRACKER_LOGOUT");
                            new Logout(jsonObject);
                            ClientCalls.asyncUnaryCall(this.mChannel.newCall(RegisterGrpc.getLogoutMethod(), CallOptions.DEFAULT), LogoutRequest.newBuilder().build(), new TrackerStreamObserver(this, msgType));
                            break;
                        case TRACKER_RELEASE_PEERINFO:
                            BLog.d(this.mTag, "TRACKER_RELEASE_PEERINFO");
                            ReleasePeerInfo release = new ReleasePeerInfo(jsonObject);
                            ClientCalls.asyncUnaryCall(this.mChannel.newCall(RegisterGrpc.getReleasePeerInfoMethod(), CallOptions.DEFAULT), release.mRequest, new TrackerStreamObserver(this, msgType));
                            break;
                        case TRACKER_REPORT_PEERINFO:
                            BLog.d(this.mTag, "TRACKER_REPORT_PEERINFO");
                            ReportResource report = new ReportResource(jsonObject);
                            ClientCalls.asyncUnaryCall(this.mChannel.newCall(RegisterGrpc.getReportMethod(), CallOptions.DEFAULT), report.mRequest, new TrackerStreamObserver(this, msgType));
                            break;
                    }
                } catch (Exception e) {
                    this.mTrackerServerHasError = true;
                    if (this.mChannel == null) {
                        this.mTrackerServerErrorCounter = 2;
                    }
                    BLog.w(this.mTag, e);
                }
                if (this.mTrackerServerHasError) {
                    this.mTrackerServerErrorCounter++;
                    if (this.mTrackerServerErrorCounter >= 2 && !this.mHandler.hasMessages(3)) {
                        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), this.mChannel == null ? 0L : PlayerToastConfig.DURATION_5);
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class ClientReq {
        public String mDeviceId;
        public String mRequestUrl;

        public ClientReq(JSONObject jsonObject) {
            this.mRequestUrl = jsonObject.optString(P2PTrackerClientProxy.K_P2P_TRACKER_REQUEST_URL);
            Uri uri = Uri.parse(this.mRequestUrl);
            this.mDeviceId = uri.getQueryParameter(P2PTrackerClientProxy.K_PEER_DEVICE_ID);
        }

        public String toString() {
            return this.mRequestUrl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class PeerInfoHelper {
        private PeerInfoHelper() {
        }

        public static PeerInfo fromJson(JSONObject jsonObject) {
            PeerInfo.Builder builder = PeerInfo.newBuilder();
            builder.setDeviceId(jsonObject.optString(P2PTrackerClientProxy.K_PEER_DEVICE_ID));
            builder.setReflexIp(jsonObject.optString(P2PTrackerClientProxy.K_PEER_REFLEX_IP));
            builder.setReflexPort(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_REFLEX_PORT));
            JSONArray reflexAddrs = jsonObject.optJSONArray(P2PTrackerClientProxy.K_PEER_EXTRA_REFLEX_ADDRS);
            if (reflexAddrs != null) {
                for (int i = 0; i < reflexAddrs.length(); i++) {
                    JSONObject jsonObject1 = reflexAddrs.optJSONObject(i);
                    ReflexAddr reflexAddr = ReflexAddr.newBuilder().setReflexIp(jsonObject1.optString(P2PTrackerClientProxy.K_PEER_REFLEX_IP)).setReflexPort(jsonObject1.optInt(P2PTrackerClientProxy.K_PEER_REFLEX_PORT)).build();
                    builder.addExtraReflexAddr(reflexAddr);
                }
            }
            builder.setRouterIp(jsonObject.optString(P2PTrackerClientProxy.K_PEER_ROUTER_IP));
            builder.setRouterPort(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_ROUTER_PORT));
            builder.setLocalIp(jsonObject.optString(P2PTrackerClientProxy.K_PEER_LOCAL_IP));
            builder.setLocalPort(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_LOCAL_PORT));
            builder.setNatType(NATType.forNumber(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_NAT_TYPE)));
            builder.setDeviceType(DeviceType.forNumber(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_DEVICE_TYPE)));
            builder.setNetworkType(NetworkType.forNumber(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_NETWORK_TYPE)));
            builder.setP2PVersion(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_P2P_VERSION));
            builder.setUploadSpeed(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_UPLOAD_SPEED));
            builder.setP2PStrategy(P2PStrategy.forNumber(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_P2P_STRATEGY)));
            builder.setStorageCap(jsonObject.optLong(P2PTrackerClientProxy.K_PEER_STORAGE_CAP));
            builder.setSubStreamIndex(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_SUB_STREAM_INDEX));
            builder.setTotalSubStreams(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_TOTAL_SUB_STREAMS));
            builder.setOverloadType(OverLoadType.forNumber(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_OVERLOAD_OR_NOT)));
            builder.setTcpListenPort(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_TCP_LISTEN_PORT));
            builder.setEncryptType(EncryptType.forNumber(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_ENCRYPT_TYPE)));
            builder.setQualityScore(jsonObject.optInt(P2PTrackerClientProxy.K_QUALITY_SCORE));
            builder.setTcpListenIp(jsonObject.optString(P2PTrackerClientProxy.K_PEER_TCP_LISTEN_IP));
            builder.setMagicAndJsonEncryptLevel(MagicAndJsonEncryptLevel.forNumber(jsonObject.optInt(P2PTrackerClientProxy.K_ENCRYPT_MAGIC_LEVEL)));
            builder.setKcpVersion(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_KCP_VERSION));
            builder.setIpv6Ip(jsonObject.optString(P2PTrackerClientProxy.K_PEER_IPV6_IP));
            builder.setIpv6Port(jsonObject.optInt(P2PTrackerClientProxy.K_PEER_IPV6_PORT));
            return builder.build();
        }

        public static void writeToJson(PeerInfo info, JSONObject jsonObject) {
            try {
                jsonObject.put(P2PTrackerClientProxy.K_PEER_DEVICE_ID, info.getDeviceId());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_REFLEX_IP, info.getReflexIp());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_REFLEX_PORT, info.getReflexPort());
                JSONArray array = new JSONArray();
                for (ReflexAddr addr : info.getExtraReflexAddrList()) {
                    JSONObject object = new JSONObject();
                    object.put(P2PTrackerClientProxy.K_PEER_REFLEX_IP, addr.getReflexIp());
                    object.put(P2PTrackerClientProxy.K_PEER_REFLEX_PORT, addr.getReflexPort());
                    array.put(object);
                }
                if (array.length() > 0) {
                    jsonObject.put(P2PTrackerClientProxy.K_PEER_EXTRA_REFLEX_ADDRS, array);
                }
                jsonObject.put(P2PTrackerClientProxy.K_PEER_ROUTER_IP, info.getRouterIp());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_ROUTER_PORT, info.getRouterPort());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_LOCAL_IP, info.getLocalIp());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_LOCAL_PORT, info.getLocalPort());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_NAT_TYPE, info.getNatTypeValue());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_DEVICE_TYPE, info.getDeviceTypeValue());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_NETWORK_TYPE, info.getNetworkTypeValue());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_P2P_VERSION, info.getP2PVersion());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_UPLOAD_SPEED, info.getUploadSpeed());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_P2P_STRATEGY, info.getP2PStrategyValue());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_STORAGE_CAP, info.getStorageCap());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_SUB_STREAM_INDEX, info.getSubStreamIndex());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_TOTAL_SUB_STREAMS, info.getTotalSubStreams());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_OVERLOAD_OR_NOT, info.getOverloadTypeValue());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_TCP_LISTEN_PORT, info.getTcpListenPort());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_ENCRYPT_TYPE, info.getEncryptTypeValue());
                jsonObject.put(P2PTrackerClientProxy.K_QUALITY_SCORE, info.getQualityScore());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_TCP_LISTEN_IP, info.getTcpListenIp());
                jsonObject.put(P2PTrackerClientProxy.K_ENCRYPT_MAGIC_LEVEL, info.getMagicAndJsonEncryptLevelValue());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_KCP_VERSION, info.getKcpVersion());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_IPV6_IP, info.getIpv6Ip());
                jsonObject.put(P2PTrackerClientProxy.K_PEER_IPV6_PORT, info.getIpv6Port());
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class Login extends ClientReq {
        public LoginRequest mRequest;

        public Login(JSONObject jsonObject) {
            super(jsonObject);
            PeerInfo peerInfo = PeerInfoHelper.fromJson(jsonObject);
            this.mRequest = LoginRequest.newBuilder().setPeer(peerInfo).setVersion(3).setPlayKind(PlayKind.forNumber(jsonObject.optInt(P2PTrackerClientProxy.K_PLAY_KIND))).build();
            BLog.d(P2PTrackerClientProxy.this.mTag, "Login " + this.mRequest.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class Logout extends ClientReq {
        public LogoutRequest mRequest;

        public Logout(JSONObject jsonObject) {
            super(jsonObject);
            this.mRequest = LogoutRequest.newBuilder().setDeviceId(this.mDeviceId).setTransId(P2PTrackerClientProxy.this.mTransId).build();
            BLog.d(P2PTrackerClientProxy.this.mTag, "Logout " + this.mRequest.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class GetPeerInfo extends ClientReq {
        public GetPeerInfoRequest mRequest;

        public GetPeerInfo(JSONObject jsonObject) {
            super(jsonObject);
            String[] split;
            Uri uri = Uri.parse(this.mRequestUrl);
            GetPeerInfoRequest.Builder builder = GetPeerInfoRequest.newBuilder();
            builder.setDeviceId(this.mDeviceId);
            builder.setTransId(P2PTrackerClientProxy.this.mTransId);
            builder.setResourceAvid(uri.getQueryParameter(P2PTrackerClientProxy.K_RESOURCE_AID));
            builder.setResourceId(uri.getQueryParameter(P2PTrackerClientProxy.K_RESOURCE_ID));
            if (!TextUtils.isEmpty(uri.getQueryParameter(P2PTrackerClientProxy.K_RESOURCE_URL))) {
                builder.setResourceUrl(uri.getQueryParameter(P2PTrackerClientProxy.K_RESOURCE_URL));
            }
            if (uri.getQueryParameter(P2PTrackerClientProxy.K_RESOURCE_TYPE) != null) {
                builder.setResourceType(ResourceType.forNumber(Integer.parseInt(uri.getQueryParameter(P2PTrackerClientProxy.K_RESOURCE_TYPE))));
            }
            if (uri.getQueryParameter("p2p_play_type") != null) {
                builder.setPlayType(PlayType.forNumber(Integer.parseInt(uri.getQueryParameter("p2p_play_type"))));
            }
            if (uri.getQueryParameter(P2PTrackerClientProxy.K_PEER_NAT_TYPE) != null) {
                builder.setNatType(NATType.forNumber(Integer.parseInt(uri.getQueryParameter(P2PTrackerClientProxy.K_PEER_NAT_TYPE))));
            }
            if (uri.getQueryParameter("resource_size") != null) {
                builder.setResourceSize(Long.parseLong(uri.getQueryParameter("resource_size")));
            }
            if (uri.getQueryParameter(P2PTrackerClientProxy.K_SESSION_ID) != null) {
                builder.setSessionId(Integer.parseInt(uri.getQueryParameter(P2PTrackerClientProxy.K_SESSION_ID)));
            }
            if (uri.getQueryParameter(P2PTrackerClientProxy.K_RESOURCE_BITRATE) != null) {
                builder.setBitrate(Integer.parseInt(uri.getQueryParameter(P2PTrackerClientProxy.K_RESOURCE_BITRATE)));
            }
            if (uri.getQueryParameter("segment_id") != null) {
                builder.setSegmentId(Integer.parseInt(uri.getQueryParameter("segment_id")));
            }
            if (uri.getQueryParameter("live_segment") != null) {
                builder.setLiveSegment(Integer.parseInt(uri.getQueryParameter("live_segment")));
            }
            if (uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_SEASON_ID) != null) {
                builder.setSeasonId(Long.parseLong(uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_SEASON_ID)));
            }
            if (uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_EPISODE_ID) != null) {
                builder.setEpisodeId(Long.parseLong(uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_EPISODE_ID)));
            }
            if (uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_UP_MID) != null) {
                builder.setUpMid(Long.parseLong(uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_UP_MID)));
            }
            if (uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_UPLOAD_UTC_TIMESTAMP) != null) {
                builder.setUploadUtcTimestamp(Long.parseLong(uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_UPLOAD_UTC_TIMESTAMP)));
            }
            if (uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_TYPE) != null) {
                builder.setManuscriptType(ManuscriptType.forNumber(Integer.parseInt(uri.getQueryParameter(P2PManuscriptInfo.K_P2P_MANUSCRIPT_TYPE))));
            }
            if (uri.getQueryParameter(P2PTrackerClientProxy.K_PEER_NEED_COUNT) != null) {
                builder.setPeerNeedCount(Integer.parseInt(uri.getQueryParameter(P2PTrackerClientProxy.K_PEER_NEED_COUNT)));
            }
            if (uri.getQueryParameter(P2PTrackerClientProxy.K_UPLOAD_PRIORITY) != null) {
                builder.setUploadPriority(UploadPriorityType.forNumber(Integer.parseInt(uri.getQueryParameter(P2PTrackerClientProxy.K_UPLOAD_PRIORITY))));
            }
            String subSegments = uri.getQueryParameter("sub_segment");
            if (subSegments != null) {
                for (String subSegment : subSegments.split(",")) {
                    builder.addSubSegment(Integer.valueOf(subSegment).intValue());
                }
            }
            this.mRequest = builder.build();
            BLog.d(P2PTrackerClientProxy.this.mTag, "GetPeerInfo " + this.mRequest.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class ReleasePeerInfo extends ClientReq {
        public ReleasePeerInfoRequest mRequest;

        public ReleasePeerInfo(JSONObject jsonObject) {
            super(jsonObject);
            Uri uri = Uri.parse(this.mRequestUrl);
            ReleasePeerInfoRequest.Builder builder = ReleasePeerInfoRequest.newBuilder();
            builder.setSessionId(Integer.parseInt(uri.getQueryParameter(P2PTrackerClientProxy.K_SESSION_ID)));
            JSONArray devices = jsonObject.optJSONArray(P2PTrackerClientProxy.K_PEER_DEVICE_IDS);
            JSONArray devicesWithReason = jsonObject.optJSONArray(P2PTrackerClientProxy.K_PEER_RELEASE_DEVICE);
            if (devicesWithReason != null) {
                for (int i = 0; i < devicesWithReason.length(); i++) {
                    String deviceInfo = devicesWithReason.optString(i);
                    String[] deviceInfoArray = deviceInfo.split("\"");
                    if (deviceInfoArray.length == 3) {
                        DeviceRelease device = DeviceRelease.newBuilder().setDeviceId(deviceInfoArray[1]).setReleaseType(ReleaseType.forNumber(deviceInfoArray[2].charAt(1) - '0')).build();
                        builder.addReleaseDevice(device);
                    }
                }
            } else if (devices != null) {
                for (int i2 = 0; i2 < devices.length(); i2++) {
                    builder.addReleaseDeviceId(devices.optString(i2));
                }
            }
            if (!TextUtils.isEmpty(jsonObject.optString(P2PTrackerClientProxy.K_P2P_SUPER_NODE_IP)) || !TextUtils.isEmpty(jsonObject.optString(P2PTrackerClientProxy.K_P2P_SUPER_NODE_ERROR_DETAIL))) {
                SuperNodeRelease superNodeRelase = SuperNodeRelease.newBuilder().setIp(jsonObject.optString(P2PTrackerClientProxy.K_P2P_SUPER_NODE_IP)).setFirstPacketTimeMs(jsonObject.optInt(P2PTrackerClientProxy.K_P2P_SUPER_NODE_FIRST_PACKET_TIME_MS)).setErrorCode(jsonObject.optInt(P2PTrackerClientProxy.K_P2P_SUPER_NODE_ERROR_CODE)).setErrorDetail(jsonObject.optString(P2PTrackerClientProxy.K_P2P_SUPER_NODE_ERROR_DETAIL)).setDownloadGivenGapTimeCost(jsonObject.optInt(P2PTrackerClientProxy.K_P2P_SUPER_NODE_DOWNLOAD_GIVEN_GAP_TIME_COST)).setResourceBitrate(jsonObject.optInt(P2PTrackerClientProxy.K_P2P_SUPER_NODE_RESOURCE_BITRATE)).build();
                builder.setReleaseSuperNode(superNodeRelase);
            }
            builder.setDeviceId(this.mDeviceId);
            builder.setTransId(P2PTrackerClientProxy.this.mTransId);
            this.mRequest = builder.build();
            BLog.d(P2PTrackerClientProxy.this.mTag, "ReleasePeerInfo " + this.mRequest.toString());
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class ResourceHelper {
        private ResourceHelper() {
        }

        public static Resource fromJson(JSONObject jsonObject) {
            Resource.Builder builder = Resource.newBuilder();
            builder.setResourceId(jsonObject.optString(P2PTrackerClientProxy.K_RESOURCE_ID));
            builder.setType(ResourceType.forNumber(jsonObject.optInt(P2PTrackerClientProxy.K_RESOURCE_TYPE)));
            builder.setResourceTotalSegmentCount(jsonObject.optInt(P2PTrackerClientProxy.K_P2P_STREAM_TOTAL_COUNT));
            JSONArray segments = jsonObject.optJSONArray(P2PTrackerClientProxy.K_SEGMENTS);
            if (segments != null) {
                for (int i = 0; i < segments.length(); i++) {
                    String segmentInfo = segments.optString(i);
                    String[] segmentArray = segmentInfo.split("-");
                    if (segmentArray.length == 2) {
                        SegmentSection section = SegmentSection.newBuilder().setStart(Integer.valueOf(segmentArray[0]).intValue()).setEnd(Integer.valueOf(segmentArray[1]).intValue()).build();
                        builder.addSegmentSections(section);
                    }
                }
            }
            return builder.build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class ReportResource extends ClientReq {
        public ReportRequest mRequest;

        public ReportResource(JSONObject jsonObject) {
            super(jsonObject);
            ReportRequest.Builder builder = ReportRequest.newBuilder();
            builder.setTransId(P2PTrackerClientProxy.this.mTransId);
            JSONArray resourceAdds = jsonObject.optJSONArray(P2PTrackerClientProxy.K_RESOURCE_ID_ADD);
            if (resourceAdds != null) {
                for (int i = 0; i < resourceAdds.length(); i++) {
                    builder.addResourceAdd(ResourceHelper.fromJson(resourceAdds.optJSONObject(i)));
                }
            }
            JSONArray resourceDels = jsonObject.optJSONArray(P2PTrackerClientProxy.K_RESOURCE_ID_DELETE);
            if (resourceDels != null) {
                for (int i2 = 0; i2 < resourceDels.length(); i2++) {
                    builder.addResourceDelete(ResourceHelper.fromJson(resourceDels.optJSONObject(i2)));
                }
            }
            builder.setPeerInfo(PeerInfoHelper.fromJson(jsonObject.optJSONObject(P2PTrackerClientProxy.K_PEER_INFO)));
            this.mRequest = builder.build();
            BLog.d(P2PTrackerClientProxy.this.mTag, "ReportResource " + this.mRequest.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class Heartbeat extends ClientReq {
        public HeartbeatRequest mRequest;

        public Heartbeat(JSONObject jsonObject) {
            super(jsonObject);
            this.mRequest = HeartbeatRequest.newBuilder().setDeviceId(this.mDeviceId).setTransId(P2PTrackerClientProxy.this.mTransId).build();
            BLog.d(P2PTrackerClientProxy.TAG, "Heartbeat " + this.mRequest.toString());
        }
    }

    public static JSONObject PushConnectRespToJson(WatchConnectResponse response) {
        BLog.d(TAG, "WatchConnectResponse " + response.toString());
        JSONObject jsonObject = new JSONObject();
        JSONObject peerInfo = new JSONObject();
        PeerInfoHelper.writeToJson(response.getPeer(), peerInfo);
        try {
            jsonObject.put(K_PEER_INFO, peerInfo);
            jsonObject.put(K_MSG_TYPE, TRACKER_MSG_TYPE.TRACKER_PUSH_PEER_CONNECT.ordinal());
        } catch (JSONException e) {
        }
        return jsonObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject HotPushRespToJson(WatchHotPushResponse response) {
        BLog.d(TAG, "HotPushHelper " + response.toString());
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(K_RESOURCE_ID, response.getResourceId());
            jsonObject.put(K_RESOURCE_AID, response.getResourceAvid());
            jsonObject.put(K_RESOURCE_TYPE, response.getTypeValue());
            jsonObject.put(K_P2P_HOT_PUSH_TIME, response.getTimestamp());
            jsonObject.put(K_RESOURCE_BITRATE, response.getBitrate());
            jsonObject.put(K_RESOURCE_URL, response.getResourceUrl());
            jsonObject.put(K_P2P_DOWNLOAD_TYPE, response.getDownloadTypeValue());
            jsonObject.put(K_RID_POINT, response.getRidPoint());
            jsonObject.put(K_HOT_PUSH_TYPE, response.getHotpushTypeValue());
            JSONArray array = new JSONArray();
            for (SegmentSection section : response.getSegmentSectionsList()) {
                JSONObject object = new JSONObject();
                object.put(K_P2P_SEGMENT_ID_START, section.getStart());
                object.put(K_P2P_SEGMENT_ID_END, section.getEnd());
                array.put(object);
            }
            jsonObject.put(K_SEGMENTS, array);
            jsonObject.put(K_MSG_TYPE, TRACKER_MSG_TYPE.TRACKER_PUSH_DOWNLOAD_TASK.ordinal());
        } catch (JSONException e) {
        }
        return jsonObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject GetPeerInfoRespToJson(GetPeerInfoResponse response) {
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        BLog.d(TAG, "GetPeerInfoResponse " + response.toString());
        for (PeerInfo info : response.getPeersList()) {
            JSONObject object = new JSONObject();
            PeerInfoHelper.writeToJson(info, object);
            array.put(object);
        }
        try {
            jsonObject.put(K_MSG_TYPE, TRACKER_MSG_TYPE.TRACKER_RESPONSE_PEERINFO.ordinal());
            jsonObject.put(K_SESSION_ID, response.getSessionId());
            jsonObject.put(K_PEER_INFOS, array);
        } catch (JSONException e) {
        }
        return jsonObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject HeartbeatRespToJson(HeartbeatResponse response) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(K_MSG_TYPE, TRACKER_MSG_TYPE.TRACKER_HEARTBEAT.ordinal());
        } catch (JSONException e) {
        }
        return jsonObject;
    }

    private int readWrapper(byte[] buf, int off, int len) {
        int ret;
        int readed = 0;
        while (readed < len && len > 0) {
            try {
                ret = this.mInput.read(buf, off + readed, len - readed);
            } catch (InterruptedIOException e) {
                BLog.w(this.mTag, "readWrapper interrupt " + e);
            } catch (IOException e2) {
                BLog.w(this.mTag, "readWrapper " + e2);
            }
            if (ret <= 0) {
                break;
            }
            readed += ret;
        }
        return readed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String handleTrackerFdRead() {
        byte[] buf = new byte[1024];
        int bodyLen = 0;
        int totalReadLen = 0;
        ByteArrayOutputStream bos = null;
        do {
            if (bodyLen == 0) {
                byte[] header = new byte[4];
                if (readWrapper(header, 0, 4) != 4) {
                    return "";
                }
                bodyLen = ((((((bodyLen | (header[3] & 255)) << 8) | (header[2] & 255)) << 8) | (header[1] & 255)) << 8) | (header[0] & 255);
                BLog.d(this.mTag, "bodylen " + bodyLen + " " + ((int) header[3]) + " " + ((int) header[2]) + " " + ((int) header[1]) + " " + ((int) header[0]));
                if (bodyLen < 0 || bodyLen > 262144) {
                    BLog.w(this.mTag, "handleTrackerFdRead invalid bodyLen " + bodyLen);
                    return "";
                }
                bos = new ByteArrayOutputStream(bodyLen);
            }
            int toRead = Math.min(buf.length, bodyLen - totalReadLen);
            int ret = readWrapper(buf, 0, toRead);
            if (ret != toRead) {
                return "";
            }
            bos.write(buf, 0, ret);
            totalReadLen += ret;
        } while (totalReadLen != bodyLen);
        if (bos == null) {
            return "";
        }
        return new String(bos.toByteArray());
    }

    public void release() {
        if (this.mParcelFileDescriptor == null) {
            return;
        }
        this.mHandler.obtainMessage(4).sendToTarget();
    }

    public void switchNewTrackerAsyn() {
        if (!this.mHandler.hasMessages(5)) {
            Message msg = this.mHandler.obtainMessage(5);
            this.mHandler.sendMessage(msg);
        }
    }
}