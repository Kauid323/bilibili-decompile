package tv.danmaku.videoplayer.core.media.ijk;

import android.text.TextUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.rpc.report.HttpReporter;
import com.bilibili.lib.rpc.track.model.Metrics;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import com.bilibili.lib.rpc.track.model.Tunnel;
import java.net.URL;
import java.util.Map;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

public class IjkMediaPlayerTrackerHelp implements IMediaPlayer.OnTrackerListener {
    private static IjkMediaPlayerTrackerHelp sInstance;
    private HttpReporter mReporter = null;

    public static synchronized IjkMediaPlayerTrackerHelp getInstance() {
        IjkMediaPlayerTrackerHelp ijkMediaPlayerTrackerHelp;
        synchronized (IjkMediaPlayerTrackerHelp.class) {
            if (sInstance == null) {
                sInstance = new IjkMediaPlayerTrackerHelp();
            }
            ijkMediaPlayerTrackerHelp = sInstance;
        }
        return ijkMediaPlayerTrackerHelp;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTrackerListener
    public void onTrackerReport(final boolean force, final String simplyEventId, final Map<String, String> simplyExtensions) {
        HandlerThreads.post(1, new Runnable() { // from class: tv.danmaku.videoplayer.core.media.ijk.IjkMediaPlayerTrackerHelp$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                IjkMediaPlayerTrackerHelp.this.m2703lambda$onTrackerReport$0$tvdanmakuvideoplayercoremediaijkIjkMediaPlayerTrackerHelp(simplyEventId, simplyExtensions, force);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onTrackerReport$0$tv-danmaku-videoplayer-core-media-ijk-IjkMediaPlayerTrackerHelp  reason: not valid java name */
    public /* synthetic */ void m2703lambda$onTrackerReport$0$tvdanmakuvideoplayercoremediaijkIjkMediaPlayerTrackerHelp(String simplyEventId, Map simplyExtensions, boolean force) {
        if (!TextUtils.isEmpty(simplyEventId) && simplyExtensions != null) {
            if (simplyEventId.equals("main.ijk.liveheartbeat.tracker")) {
                if (ConfigManager.ab().get("ijkplayer.enable_live_heartbeat_report", false) == Boolean.TRUE) {
                    Neurons.reportIjk(force, "002879", simplyEventId, simplyExtensions);
                    return;
                }
                return;
            }
            String mode = (String) simplyExtensions.get("mode");
            boolean isLive = mode.equals("2") || mode.equals(ConstsKt.ARG_FULL_PKG_DOWNLOAD_FAILURE);
            if (ConfigManager.ab().get("ff_net_monitor_wl", false) == Boolean.TRUE) {
                Neurons.reportIjk(force, "002879", simplyEventId, simplyExtensions);
            } else if (simplyEventId.equals("main.ijk.p2p_status.tracker") && ConfigManager.ab().get("ijkplayer.p2p_simply_report", false) == Boolean.TRUE) {
                simplyExtensions.put(MediaItemParams.IJK_REPORT_KEY_FORCE_REPORT, String.valueOf(0));
                Neurons.reportIjk(force, "002879", simplyEventId, simplyExtensions);
                if (ConfigManager.ab().get("ijkplayer.p2p_status_gray_report", false) == Boolean.TRUE) {
                    Neurons.reportIjk(force, "002879", "main.ijk.p2p.status.gray.tracker", simplyExtensions);
                }
            } else if (ConfigManager.ab().get("ijkplayer.simply_report", false) == Boolean.TRUE || ConfigManager.ab().get("ijkplayer.gray_simply_report", false) == Boolean.TRUE || (isLive && ConfigManager.ab().get("ijkplayer.live_simply_report", false) == Boolean.TRUE)) {
                simplyExtensions.put(MediaItemParams.IJK_REPORT_KEY_FORCE_REPORT, String.valueOf(0));
                Neurons.reportIjk(force, "002879", simplyEventId, simplyExtensions);
            } else if (ConfigManager.ab().get("ijkplayer.force_error_report", false) == Boolean.TRUE && simplyEventId.equals("main.ijk.asset_item_stop.tracker")) {
                String forceReport = (String) simplyExtensions.get(MediaItemParams.IJK_REPORT_KEY_FORCE_REPORT);
                if (!TextUtils.isEmpty(forceReport)) {
                    int forceReportInt = Integer.parseInt(forceReport);
                    if (forceReportInt > 0) {
                        Neurons.reportIjk(force, "002879", simplyEventId, simplyExtensions);
                    }
                }
            }
            if (simplyEventId.equals("main.ijk.asset_item_stop.tracker")) {
                String videoIP = "";
                String realUrl = "";
                int httpCode = 0;
                Long readBytes = 0L;
                Long p2pUploadBytes = 0L;
                Long p2pReadBytes = 0L;
                try {
                    String cid = (String) simplyExtensions.get("cid");
                    if (cid == null) {
                    }
                    String videoIP2 = (String) simplyExtensions.get("video_ip");
                    String videoIP3 = videoIP2 == null ? "" : videoIP2;
                    try {
                        String realUrl2 = (String) simplyExtensions.get("video_url");
                        if (realUrl2 == null) {
                            realUrl = "";
                        } else {
                            realUrl = realUrl2;
                        }
                        int httpCode2 = Integer.valueOf((String) simplyExtensions.get("video_http_code")).intValue();
                        if (httpCode2 != 0) {
                            httpCode = httpCode2;
                        } else {
                            httpCode = -1;
                        }
                        p2pReadBytes = Long.valueOf((String) simplyExtensions.get("p2p_download_size"));
                        readBytes = Long.valueOf(Long.valueOf((String) simplyExtensions.get("audio_read_bytes")).longValue() + Long.valueOf((String) simplyExtensions.get("video_read_bytes")).longValue());
                        p2pUploadBytes = Long.valueOf((String) simplyExtensions.get("p2p_uploaded_bytes"));
                        videoIP = videoIP3;
                    } catch (Exception e) {
                        videoIP = videoIP3;
                    }
                } catch (Exception e2) {
                }
                try {
                    URL url = new URL(realUrl);
                    Metrics httpMetrics = Metrics.newBuilder().setReqPackageSize(0L).setRespPackageSize(readBytes.longValue()).setRemoteIp(videoIP).build();
                    NetworkEvent httpEvent = NetworkEvent.newBuilder().setScheme("http").setUrl(realUrl).setHost(url.getHost()).setPath(url.getPath()).setRealUrl(realUrl).setHttpCode(httpCode).setTunnel(Tunnel.IJK_HTTP).setPersistent(false).setMetrics(httpMetrics).build();
                    Metrics p2pMetrics = Metrics.newBuilder().setReqPackageSize(p2pUploadBytes.longValue()).setRespPackageSize(p2pReadBytes.longValue()).setRemoteIp(videoIP).build();
                    NetworkEvent p2pEvent = NetworkEvent.newBuilder().setScheme("http").setHost(url.getHost()).setPath(url.getPath()).setRealUrl(realUrl).setHttpCode(httpCode).setTunnel(Tunnel.IJK_P2P).setPersistent(false).setMetrics(p2pMetrics).build();
                    if (this.mReporter != null) {
                        this.mReporter.report(httpEvent);
                        if (p2pUploadBytes.longValue() > 0 || p2pReadBytes.longValue() > 0) {
                            this.mReporter.report(p2pEvent);
                        }
                    }
                } catch (Exception e3) {
                }
            }
        }
    }

    public void setHttpReporter(HttpReporter reporter) {
        this.mReporter = reporter;
    }
}