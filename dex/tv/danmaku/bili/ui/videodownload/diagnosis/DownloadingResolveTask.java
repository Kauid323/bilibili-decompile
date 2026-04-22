package tv.danmaku.bili.ui.videodownload.diagnosis;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import bili.resource.downloads.R;
import bolts.CancellationToken;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.app.preferences.utils.Zone;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.media.resolver.exception.ResolveException;
import com.bilibili.lib.media.resolver.exception.ResolveMediaSourceException;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resolver2.MediaResolveClientV2;
import com.bilibili.lib.media.resource.DashMediaIndex;
import com.bilibili.lib.media.resource.DashResource;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.media.resource.Segment;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.utils.ExBilowUtil;
import com.bilibili.videodownloader.directory.VideoDownloadDirectory;
import com.bilibili.videodownloader.directory.VideoDownloadDirectoryFactory;
import com.bilibili.videodownloader.downloader.connection.VideoDownloadConnection;
import com.bilibili.videodownloader.downloader.connection.VideoDownloadResponse;
import com.bilibili.videodownloader.exceptions.DownloadAbortException;
import com.bilibili.videodownloader.exceptions.DownloadException;
import com.bilibili.videodownloader.manager.Cancelable;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import com.bilibili.videodownloader.resolver.playurl.MediaResolverImplV2;
import com.bilibili.videodownloader.utils.VideoDownloadUtils;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tv.danmaku.android.ConnectivityManagerHelper;
import tv.danmaku.bili.services.videodownload.interceptor.VideoDownloadResolveClientCreator;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.services.videodownload.utils.FreeDataMediaDownloadHelper;
import tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask;
import tv.danmaku.bili.update.internal.UpdaterKt;
import tv.danmaku.bili.videopage.common.widget.TripleCustomBubble;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;
import video.biz.offline.list.logic.tree.VideoFile;

public class DownloadingResolveTask extends ResolveTask {
    private static final String RESOLVE_AVID = "avid";
    private static final String RESOLVE_CID = "cid";
    private static final String RESOLVE_DOWNLOAD_URL = "download_url";
    private static final String RESOLVE_EID = "episode_id";
    private static final String RESOLVE_FROM = "from";
    private static final String RESOLVE_GEO = "geo";
    private static final String RESOLVE_MY_IP = "my_ip";
    private static final String RESOLVE_OLD_TYPETAG = "old_type_tag";
    private static final String RESOLVE_QUALITY = "quality";
    private static final String RESOLVE_REMOTE_HOST = "remote_host";
    private static final String RESOLVE_REMOTE_IP = "remote_ip";
    private static final String RESOLVE_SUB_ERROR_INFO = "sub_error_info";
    private static final String RESOLVE_SUB_ERROR_TYPE = "sub_error_type";
    private static final String RESOLVE_TYPETAG = "type_tag";
    private static final String RESOLVE_UA = "ua";
    private CancellationTokenSource mCancelSource;
    private String mUserAgent;

    /* JADX INFO: Access modifiers changed from: package-private */
    @BaseUrl(UpdaterKt.HTTPS_APP_BILIBILI_COM)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface DisplayZoneApi {
        @GET("/x/v2/display/zone")
        BiliCall<GeneralResponse<Zone>> getDisplayZone(@Query("access_key") String str);
    }

    public DownloadingResolveTask(ScanEntry entry, ResolveTask.ResolveTaskListener listener) {
        super(entry, listener);
        this.mCancelSource = new CancellationTokenSource();
    }

    @Override // tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask
    public void startResolve(final Context context) {
        super.startResolve(context);
        if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
            progressContent(context, 3, R.string.downloads_global_string_98);
            progressContent(context, 4, R.string.downloads_global_string_90);
            finish(context, null, 0);
            return;
        }
        CancellationToken token = this.mCancelSource.getToken();
        Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.DownloadingResolveTask.4
            @Override // java.util.concurrent.Callable
            public Void call() {
                DownloadingResolveTask.this.getMyIp(context);
                return null;
            }
        }, token).continueWith(new Continuation<Void, MediaResource>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.DownloadingResolveTask.3
            /* renamed from: then  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1728then(Task task) throws Exception {
                return then((Task<Void>) task);
            }

            public MediaResource then(Task<Void> task) {
                return DownloadingResolveTask.this.resolveMediaResource(context);
            }
        }, token).continueWith(new Continuation<MediaResource, MediaResource>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.DownloadingResolveTask.2
            /* renamed from: then  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1727then(Task task) throws Exception {
                return then((Task<MediaResource>) task);
            }

            public MediaResource then(Task<MediaResource> task) {
                if (task == null || task.getResult() == null) {
                    DownloadingResolveTask.this.mCancelSource.cancel();
                    return null;
                }
                return DownloadingResolveTask.this.resolveRemoteIp(context, (MediaResource) task.getResult());
            }
        }, token).continueWith(new Continuation<MediaResource, Void>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.DownloadingResolveTask.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1726then((Task<MediaResource>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1726then(Task<MediaResource> task) {
                DownloadingResolveTask.this.connectVideo(context, (MediaResource) task.getResult());
                return null;
            }
        }, token);
    }

    @Override // tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask
    public void cancelResolve() {
        this.mCancelSource.cancel();
    }

    @Override // tv.danmaku.bili.ui.videodownload.diagnosis.ResolveTask
    public String getErrorContent(Context context, int errorCode) {
        switch (errorCode) {
            case 10:
                return context.getString(R.string.downloads_global_string_70);
            case IjkMediaPlayerTracker.BLIJK_EV_HTTP_WILL_REBUILD /* 2001 */:
                String content = getContent(context, getRecordInfoValue(RESOLVE_SUB_ERROR_TYPE));
                return context.getString(tv.danmaku.bili.R.string.diagonsis_downloading_report_content_resolve, getRecordInfoValue("avid"), getRecordInfoValue("cid"), getRecordInfoValue("from"), getRecordInfoValue("quality"), getRecordInfoValue(RESOLVE_EID), content);
            default:
                return context.getString(tv.danmaku.bili.R.string.diagonsis_downloading_report_content_resolve, getRecordInfoValue("avid"), getRecordInfoValue("cid"), getRecordInfoValue("from"), getRecordInfoValue("quality"), getRecordInfoValue(RESOLVE_EID), context.getString(R.string.downloads_global_string_106));
        }
    }

    private String getContent(Context context, String subTypeStr) {
        if (TextUtils.isEmpty(subTypeStr)) {
            return "";
        }
        int subType = 0;
        try {
            subType = Integer.parseInt(subTypeStr);
        } catch (NumberFormatException e) {
        }
        switch (subType) {
            case 1:
                return context.getString(R.string.downloads_global_string_67);
            case 2:
                return context.getString(R.string.downloads_global_string_39);
            case 3:
                return context.getString(R.string.downloads_global_string_36);
            case 4:
                return context.getString(R.string.downloads_global_string_80);
            case 5:
                return context.getString(R.string.downloads_global_string_115);
            case 6:
                return context.getString(R.string.downloads_global_string_77);
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMyIp(Context context) {
        try {
            Zone zone = (Zone) ExBilowUtil.extractResponseData(((DisplayZoneApi) ServiceGenerator.createService(DisplayZoneApi.class)).getDisplayZone(BiliAccounts.get(context).getAccessKey()).execute());
            if (zone != null) {
                progressContent(2, context.getString(R.string.downloads_global_string_27, zone.ip, zone.getGeoString()));
                recordInfo(RESOLVE_MY_IP, zone.ip);
                recordInfo(RESOLVE_GEO, zone.getGeoString());
            } else {
                progressContent(2, context.getString(R.string.downloads_global_string_101));
            }
        } catch (Exception e) {
            progressContent(2, context.getString(R.string.downloads_global_string_101));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaResource resolveMediaResource(Context context) {
        MediaResource mediaResource;
        String typeTag;
        String format;
        progressContent(context, 2, R.string.downloads_global_string_76);
        String str = null;
        if (!this.mScanEntry.isValid()) {
            progressContent(context, 2, R.string.downloads_global_string_88);
            finish(context, new ResolveException("invalid entry"), 10);
            return null;
        }
        VideoDownloadSeasonEpEntry videoDownloadSeasonEpEntry = this.mScanEntry.entry;
        IResolveParams params = MediaResolverImplV2.resolveEntry(videoDownloadSeasonEpEntry);
        progressContent(2, "   " + context.getString(bili.resource.homepage.R.string.homepage_global_string_226) + videoDownloadSeasonEpEntry.getAvid() + VideoFile.TREE_END);
        progressContent(2, "   from=" + videoDownloadSeasonEpEntry.getFrom() + VideoFile.TREE_END);
        recordInfo("avid", videoDownloadSeasonEpEntry.getAvid() + "");
        recordInfo("quality", ((VideoDownloadEntry) videoDownloadSeasonEpEntry).mPreferredVideoQuality + "");
        recordInfo("from", videoDownloadSeasonEpEntry.getFrom());
        if (videoDownloadSeasonEpEntry instanceof VideoDownloadSeasonEpEntry) {
            recordInfo(RESOLVE_EID, videoDownloadSeasonEpEntry.mEpisode.id + "");
        }
        try {
            try {
                MediaResolveClientV2 client = new VideoDownloadResolveClientCreator(context).createV2(videoDownloadSeasonEpEntry, (Cancelable) null);
                mediaResource = null;
                if (params != null) {
                    mediaResource = client.resolve(context, params);
                }
            } catch (ResolveException e) {
                e = e;
                str = "";
            }
            try {
                if (mediaResource != null) {
                    DashResource dashResource = mediaResource.getDashResource();
                    if (dashResource == null) {
                        PlayIndex playIndex = mediaResource.getPlayIndex();
                        if (playIndex == null) {
                            throw new ResolveException("PlayIndex null");
                        }
                        if (TextUtils.isEmpty(playIndex.mTypeTag)) {
                            throw new ResolveException(context.getString(R.string.downloads_global_string_112));
                        }
                        if (playIndex.isSegmentListEmpty()) {
                            throw new ResolveException("PlayIndex no segment");
                        }
                        typeTag = playIndex.mTypeTag;
                        format = "flv";
                    } else {
                        List<DashMediaIndex> videoList = dashResource.getVideoList();
                        if (videoList == null || videoList.isEmpty()) {
                            throw new ResolveException("DashResource no video");
                        }
                        if (videoList.size() != 1) {
                            throw new ResolveException("DashResource multi video");
                        }
                        DashMediaIndex videoDash = videoList.get(0);
                        if (videoDash == null) {
                            throw new ResolveException("DashResource null video");
                        }
                        if (videoDash.codecId != 7) {
                            throw new ResolveException("h264 support only");
                        }
                        String typeTag2 = String.valueOf(videoDash.id);
                        typeTag = typeTag2;
                        format = "dash";
                    }
                    this.mUserAgent = VideoDownloadUtils.getUserAgent(mediaResource.getPlayIndex());
                    recordInfo(RESOLVE_UA, this.mUserAgent);
                    recordInfo("cid", videoDownloadSeasonEpEntry.getCid() + "");
                    recordInfo(RESOLVE_TYPETAG, typeTag);
                    progressContent(2, "   cid=" + videoDownloadSeasonEpEntry.getCid() + VideoFile.TREE_END);
                    progressContent(2, "   format=" + format + VideoFile.TREE_END);
                    if (!TextUtils.isEmpty(((VideoDownloadEntry) videoDownloadSeasonEpEntry).mTypeTag) && !"any".equals(((VideoDownloadEntry) videoDownloadSeasonEpEntry).mTypeTag) && !((VideoDownloadEntry) videoDownloadSeasonEpEntry).mTypeTag.equals(typeTag)) {
                        recordInfo(RESOLVE_OLD_TYPETAG, ((VideoDownloadEntry) videoDownloadSeasonEpEntry).mTypeTag);
                        throw new ResolveException(context.getString(R.string.downloads_global_string_116));
                    }
                    progressContent(context, 2, R.string.downloads_global_string_91);
                    return mediaResource;
                }
                throw new ResolveException("null MediaResource");
            } catch (ResolveException e2) {
                e = e2;
                if (videoDownloadSeasonEpEntry.getCid() != 0) {
                    recordInfo("cid", videoDownloadSeasonEpEntry.getCid() + str);
                }
                if (params.getFrom() != null) {
                    recordInfo("from", params.getFrom());
                }
                progressContent(context, 3, R.string.downloads_global_string_58);
                if ((e instanceof ResolveMediaSourceException) && e.getCode() == 0) {
                    progressContent(context, 4, R.string.downloads_global_string_117);
                }
                finish(context, e, IjkMediaPlayerTracker.BLIJK_EV_HTTP_WILL_REBUILD);
                return null;
            }
        } catch (InterruptedException e3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaResource resolveRemoteIp(Context context, MediaResource mediaResource) {
        Uri uri;
        progressContent(context, 2, R.string.downloads_global_string_30);
        DashResource dashResource = mediaResource.getDashResource();
        if (dashResource == null) {
            PlayIndex playIndex = mediaResource.getPlayIndex();
            if (playIndex == null) {
                return mediaResource;
            }
            int segmentId = playIndex.mSegmentList.size() - 1;
            Segment segment = playIndex.getSegment(segmentId);
            if (segment == null || TextUtils.isEmpty(segment.mUrl)) {
                return mediaResource;
            }
            uri = Uri.parse(segment.mUrl);
        } else {
            String videoUrl = ((DashMediaIndex) dashResource.getVideoList().get(0)).baseUrl;
            if (TextUtils.isEmpty(videoUrl)) {
                return mediaResource;
            }
            uri = Uri.parse(videoUrl);
        }
        String host = uri.getHost();
        progressContent(2, "   " + host + VideoFile.TREE_END);
        recordInfo(RESOLVE_REMOTE_HOST, host);
        try {
            InetAddress address = InetAddress.getByName(host);
            String hostAddress = address.getHostAddress();
            progressContent(2, "   " + hostAddress + VideoFile.TREE_END);
            recordInfo(RESOLVE_REMOTE_IP, hostAddress);
        } catch (UnknownHostException e) {
            progressContent(context, 2, R.string.downloads_global_string_33);
        }
        return mediaResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectVideo(Context context, MediaResource mediaResource) {
        FileOutputStream outputStream;
        String url;
        long cachedSegmentOffset;
        if (ConnectivityManagerHelper.isActiveNetworkMetered(context) && FreeDataMediaDownloadHelper.getNetworkType(context) != 10010) {
            progressContent(context, 3, R.string.downloads_global_string_55);
            finish(context, null, 0);
            return;
        }
        VideoDownloadEntry entry = this.mScanEntry.entry;
        progressContent(context, 2, R.string.downloads_global_string_38);
        String rootPath = VideoDownloadStorageStrategy.getDownloadPath(context, entry);
        VideoDownloadDirectory directory = VideoDownloadDirectoryFactory.create(com.bilibili.videodownloader.directory.file.VideoFile.fromPath(context, rootPath), entry);
        FileOutputStream outputStream2 = null;
        int index = 0;
        String url2 = null;
        long cachedSegmentOffset2 = 0;
        try {
            try {
                DashResource dashResource = mediaResource.getDashResource();
                if (dashResource == null) {
                    PlayIndex playIndex = mediaResource.getPlayIndex();
                    if (playIndex == null) {
                        throw new IOException("can not get downloading url:no play info");
                    }
                    int n = playIndex.mSegmentList.size();
                    for (int i = 0; i < n; i++) {
                        com.bilibili.videodownloader.directory.file.VideoFile segmentFile = directory.getSegmentFile(context, i, false);
                        if (!segmentFile.exists() || !segmentFile.isFile()) {
                            index = i;
                            url2 = playIndex.getSegment(i).mUrl;
                            com.bilibili.videodownloader.directory.file.VideoFile downloadingFile = directory.getDownloadingFile(context, segmentFile);
                            if (downloadingFile.exists() && downloadingFile.isFile()) {
                                outputStream2 = downloadingFile.getFileOutputStream(true);
                                cachedSegmentOffset2 = outputStream2.getChannel().size();
                                outputStream2.close();
                            } else {
                                cachedSegmentOffset2 = 0;
                            }
                            outputStream = outputStream2;
                            url = url2;
                            cachedSegmentOffset = cachedSegmentOffset2;
                        }
                    }
                    outputStream = outputStream2;
                    url = url2;
                    cachedSegmentOffset = cachedSegmentOffset2;
                } else {
                    com.bilibili.videodownloader.directory.file.VideoFile videoFile = directory.getVideoDashFile(context, false);
                    if (videoFile.exists() && videoFile.isFile()) {
                        List<DashMediaIndex> audioList = dashResource.getAudioList();
                        if (audioList != null && audioList.size() == 1 && audioList.get(0) != null) {
                            com.bilibili.videodownloader.directory.file.VideoFile audioFile = directory.getAudioDashFile(context, false);
                            if (!audioFile.exists()) {
                                com.bilibili.videodownloader.directory.file.VideoFile downloadingAudioFile = directory.getDownloadingFile(context, audioFile);
                                index = 1;
                                url2 = audioList.get(0).baseUrl;
                                if (downloadingAudioFile.exists() && downloadingAudioFile.isFile()) {
                                    outputStream2 = downloadingAudioFile.getFileOutputStream(true);
                                    cachedSegmentOffset2 = outputStream2.getChannel().size();
                                    outputStream2.close();
                                } else {
                                    cachedSegmentOffset2 = 0;
                                }
                            }
                        }
                        outputStream = outputStream2;
                        url = url2;
                        cachedSegmentOffset = cachedSegmentOffset2;
                    } else {
                        com.bilibili.videodownloader.directory.file.VideoFile downloadingVideoFile = directory.getDownloadingFile(context, videoFile);
                        index = 0;
                        String url3 = ((DashMediaIndex) dashResource.getVideoList().get(0)).baseUrl;
                        if (downloadingVideoFile.exists() && downloadingVideoFile.isFile()) {
                            FileOutputStream outputStream3 = downloadingVideoFile.getFileOutputStream(true);
                            long cachedSegmentOffset3 = outputStream3.getChannel().size();
                            outputStream3.close();
                            outputStream = outputStream3;
                            url = url3;
                            cachedSegmentOffset = cachedSegmentOffset3;
                        } else {
                            outputStream = null;
                            url = url3;
                            cachedSegmentOffset = 0;
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            if (TextUtils.isEmpty(url)) {
                throw new IOException("can not get downloading url");
            }
            recordInfo("download_url", url);
            VideoDownloadResponse response = VideoDownloadConnection.getVideoDownloadResponse(context, url, this.mUserAgent, cachedSegmentOffset, new Cancelable() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.DownloadingResolveTask$$ExternalSyntheticLambda0
                public final void checkCancellation(String str) {
                    DownloadingResolveTask.lambda$connectVideo$0(str);
                }
            });
            if (response.hasErrorException()) {
                DownloadException e2 = response.getErrorException();
                progressContent(context, 3, R.string.downloads_global_string_5);
                finish(context, e2, e2.getErrorCode());
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(response);
                return;
            }
            progressContent(context, 2, R.string.downloads_global_string_82);
            long currentSegmentOffset = response.getStartRange();
            response.getTotalLength();
            if (cachedSegmentOffset != currentSegmentOffset) {
                DownloadAbortException downloadAbortException = new DownloadAbortException((int) IjkMediaPlayerTracker.BLIJK_EV_FIRST_AUDIO_DATA, context.getString(tv.danmaku.bili.R.string.diagonsis_downloading_dec_breakpoint_offset, Integer.valueOf(index), Long.valueOf(cachedSegmentOffset), Long.valueOf(currentSegmentOffset), entry.mTypeTag, Integer.valueOf(entry.mPreferredVideoQuality), url));
                progressContent(context, 3, R.string.downloads_global_string_109);
                finish(context, downloadAbortException, downloadAbortException.getErrorCode());
            } else {
                progressContent(context, 2, R.string.downloads_global_string_94);
                if (testSpeed(context, response.getInputStream(), TripleCustomBubble.SUC_ANIM_TIME)) {
                    progressContent(context, 3, R.string.downloads_global_string_119);
                    finish(context, null, 0);
                }
            }
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(response);
        } catch (Exception e3) {
            e = e3;
            outputStream2 = outputStream;
            progressContent(context, 3, R.string.downloads_global_string_5);
            finish(context, e, IjkMediaPlayerTracker.BLIJK_EV_TRANSPORT_BUILD);
            IOUtils.closeQuietly(outputStream2);
            IOUtils.closeQuietly((Closeable) null);
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            IOUtils.closeQuietly(outputStream2);
            IOUtils.closeQuietly((Closeable) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$connectVideo$0(String taskId) throws InterruptedException {
    }

    private boolean testSpeed(Context context, InputStream in, long time) {
        int currentTimeMillis;
        progressContent(context, 2, R.string.downloads_global_string_42);
        byte[] buffer = new byte[8192];
        try {
            try {
                long startTime = System.currentTimeMillis();
                long count = 0;
                int dtime = 0;
                do {
                    int len = in.read(buffer);
                    if (len == -1) {
                        break;
                    }
                    count += len;
                    currentTimeMillis = (int) (System.currentTimeMillis() - startTime);
                    dtime = currentTimeMillis;
                } while (currentTimeMillis < time);
                float speed = ((((float) count) * 1000.0f) / 1024.0f) / dtime;
                progressContent(2, speed + " kB/s");
                IOUtils.closeQuietly(in);
                return true;
            } catch (IOException e) {
                progressContent(context, 2, R.string.downloads_global_string_23);
                progressContent(context, 3, R.string.downloads_global_string_61);
                finish(context, e, IjkMediaPlayerTracker.BLIJK_EV_ASSET_ITEM_START);
                IOUtils.closeQuietly(in);
                return false;
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(in);
            throw th;
        }
    }

    private void finish(Context context, Exception e, int code) {
        if (this.mListener != null) {
            try {
                String fileStructure = this.mScanEntry.getDirectoryTree(context);
                recordInfo("file_structure", fileStructure);
                if (e != null) {
                    this.mInfo.put("error_code", code);
                    this.mInfo.put("error_info", buildErrorMessage(e));
                    if (e instanceof ResolveException) {
                        String[] result = DiagnosisTagHelper.getSubErrorCodeAndInfo(e);
                        this.mInfo.put(RESOLVE_SUB_ERROR_TYPE, result[0]);
                        if (!TextUtils.isEmpty(result[1])) {
                            this.mInfo.put(RESOLVE_SUB_ERROR_INFO, result[1]);
                        }
                    }
                }
            } catch (JSONException e2) {
            }
            this.mListener.onFinish(code);
        }
    }

    private String buildErrorMessage(Exception e) {
        StackTraceElement[] stackTrace;
        StringBuilder builder = new StringBuilder();
        for (StackTraceElement trace : e.getStackTrace()) {
            builder.append(trace.toString()).append(":");
        }
        builder.append(e.getMessage());
        return builder.toString();
    }
}