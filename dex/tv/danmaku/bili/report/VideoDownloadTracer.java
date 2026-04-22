package tv.danmaku.bili.report;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.preferences.Settings;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.media.resolver.exception.ResolveException;
import com.bilibili.lib.media.resolver.exception.ResolveJsonException;
import com.bilibili.lib.media.resolver.exception.ResolveMediaSourceException;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.videodownloader.core.DownloadRequest;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.downloader.connection.VideoDownloadResponse;
import com.bilibili.videodownloader.exceptions.ResolveFreeDataException;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.services.videodownload.exception.ResolveBangumiException;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;
import tv.danmaku.bili.utils.storage.StorageHelper;

public class VideoDownloadTracer {
    private static final String NEURON_CONNECT_TRACE = "main.download.connection.quality";
    private static final String NEURON_FLOW_TRACE = "main.download.flow.track";
    private static final String NEURON_LOAD_ENTRIES_PERFORMANCE_TRACE = "main.download.query.performance.track";
    private static final String NEURON_PERFORMANCE_TRACE = "main.download.performance.track";
    private static final String TAG = "VideoDownloadTracer";

    public static void reportDownloadSuccessFlowTracer(Context context, VideoDownloadEntry entry) {
        reportDownloadFlowTracer(context, entry, 0);
    }

    public static void reportDownloadFailedFlowTracer(Context context, VideoDownloadEntry entry) {
        reportDownloadFlowTracer(context, entry, entry.mLastErrorCode);
    }

    public static void reportDownloadFlowTracer(Context context, VideoDownloadEntry entry, int abortType) {
        int storageType;
        String rootPath = Uri.decode(VideoDownloadStorageStrategy.getDownloadPath(context, entry));
        Uri rootUri = TextUtils.isEmpty(rootPath) ? null : Uri.parse(rootPath);
        if (rootUri == null) {
            storageType = 0;
        } else if ("content".equals(rootUri.getScheme())) {
            storageType = 2;
        } else {
            storageType = StorageHelper.isPrimary(context, rootUri.getPath()) ? 1 : 2;
        }
        VideoFile[] downloadDirArray = VideoDownloadStorageStrategy.getCurrentSortedDownloadDirs(context);
        JSONObject storage = new JSONObject();
        storage.put("storage", Integer.valueOf(Settings.Download.getDownloadStorage(context)));
        if (downloadDirArray != null) {
            JSONArray array = new JSONArray();
            for (VideoFile dir : downloadDirArray) {
                JSONObject item = new JSONObject();
                String path = dir.getAbsolutePath();
                Uri uri = Uri.parse(path);
                item.put(FileChooserActivity.PATH, Uri.decode(path));
                item.put("type", Boolean.valueOf(!"content".equals(uri.getScheme()) && StorageHelper.isPrimary(context, uri.getPath())));
                array.add(item);
            }
            storage.put("locations", array);
        }
        JSONObject additional = new JSONObject();
        additional.put("expected_quality", Integer.valueOf(entry.mPreferredVideoQuality));
        additional.put("expected_quality_str", entry.mQualityPithyDescription);
        additional.put("type_tag", entry.mTypeTag == null ? "" : entry.mTypeTag);
        additional.put("video_type", entry.getKey());
        additional.put("network_type", Integer.valueOf(ConnectivityMonitor.getInstance().getNetworkWithoutCache()));
        additional.put("expected_network_type", Integer.valueOf(entry.mExpectedNetworkType));
        fillErrorInfo(additional, entry);
        String additionalStr = additional.toJSONString();
        InfoEyesReporter.reportOfflineVideoFlow(entry.getFrom(), entry.getAvid(), entry.getCid(), abortType, storageType, rootPath, storage.toString(), additionalStr);
        LogHelper.i(TAG, "download tracer flow, from: %s, avid: %d, cid: %d, abortType: %d,storageType: %d, rootPath: %s, storage: %s, additional: %s", new Object[]{entry.getFrom(), Long.valueOf(entry.getAvid()), Long.valueOf(entry.getCid()), Integer.valueOf(abortType), Integer.valueOf(storageType), rootPath, storage.toString(), additionalStr});
        Map<String, String> params = new HashMap<>();
        params.put("network_type", String.valueOf(ConnectivityMonitor.getInstance().getNetworkWithoutCache()));
        params.put("avid", String.valueOf(entry.getAvid()));
        params.put(ReportUtilKt.POS_TITLE, entry.mTitle == null ? "" : entry.mTitle);
        params.put("cid", String.valueOf(entry.getCid()));
        params.put("from", String.valueOf(entry.getFrom()));
        params.put("storage_type", String.valueOf(Settings.Download.getDownloadStorage(context)));
        params.put("root_path", Uri.decode(VideoDownloadStorageStrategy.getDownloadPath(context, entry)));
        params.put("error_code", String.valueOf(abortType));
        params.put("task_id", String.valueOf(entry.mTimeCreated));
        params.put("error_detail", additionalStr);
        Neurons.trackT(false, NEURON_FLOW_TRACE, params, 1, new Function0() { // from class: tv.danmaku.bili.report.VideoDownloadTracer$$ExternalSyntheticLambda0
            public final Object invoke() {
                return VideoDownloadTracer.lambda$reportDownloadFlowTracer$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$reportDownloadFlowTracer$0() {
        return true;
    }

    public static void reportConnectQualityTracer(Context context, VideoDownloadResponse response, VideoDownloadEntry entry, String url, int id, int downloadErrCode, String md5) {
        String str;
        Integer valueOf;
        boolean z;
        String str2;
        JSONObject additional = new JSONObject();
        additional.put("network_type", Integer.valueOf(ConnectivityMonitor.getInstance().getNetworkWithoutCache()));
        additional.put("video_type", entry.getKey());
        additional.put("index", Integer.valueOf(id));
        additional.put("url", url);
        additional.put("connect_ip", response == null ? "" : response.getConnectIp());
        if (entry.mTypeTag != null) {
            str = entry.mTypeTag;
        } else {
            str = "";
        }
        additional.put("type_tag", str);
        additional.put("content_length", response == null ? "" : Long.valueOf(response.getContentLength()));
        additional.put("total_length", response == null ? "" : Long.valueOf(response.getTotalLength()));
        if (response == null) {
            valueOf = "";
        } else {
            valueOf = Integer.valueOf(response.isChunked() ? 1 : 0);
        }
        additional.put("is_chunked", valueOf);
        additional.put("average_speed", response == null ? "" : getAverageSpeed(response));
        additional.put("connect_flow", response == null ? "" : Integer.valueOf(response.getConnectFlow()));
        String downloadErrMsg = downloadErrCode != 0 ? " Download error code: " + downloadErrCode : "";
        additional.put("error_msg", response == null ? "" : response.getExceptionReason() + downloadErrMsg);
        additional.put("expected_network_type", Integer.valueOf(entry.mExpectedNetworkType));
        additional.put("request_headers", response == null ? "" : getRequestHeaders(response.getDownloadRequest()));
        String additionalStr = additional.toJSONString();
        if (response == null) {
            z = false;
        } else {
            z = false;
            InfoEyesReporter.reportOfflineVideoDownload(entry.getFrom(), entry.getCid(), response.getContentType(), response.getConnectingTime(), response.getResponseCode(), response.getExceptionCode(), response.getResponseHistory(), additionalStr);
            LogHelper.i(TAG, "download tracer quality, from: %s, cid: %d, contentType: %s,connectingTime: %s, responseCode: %d, exceptionCode: %d, responseHistorySize: %d, additional: %s", new Object[]{entry.getFrom(), Long.valueOf(entry.getCid()), response.getContentType(), Long.valueOf(response.getConnectingTime()), Integer.valueOf(response.getResponseCode()), Integer.valueOf(response.getExceptionCode()), Integer.valueOf(response.getResponseHistorySize()), additionalStr});
        }
        Map<String, String> params = new HashMap<>();
        params.put("network_type", String.valueOf(ConnectivityMonitor.getInstance().getNetworkWithoutCache()));
        params.put("avid", String.valueOf(entry.getAvid()));
        if (entry.mTitle != null) {
            str2 = entry.mTitle;
        } else {
            str2 = "";
        }
        params.put(ReportUtilKt.POS_TITLE, str2);
        params.put("cid", String.valueOf(entry.getCid()));
        params.put("from", String.valueOf(entry.getFrom()));
        params.put("storage_type", String.valueOf(Settings.Download.getDownloadStorage(context)));
        params.put("root_path", Uri.decode(VideoDownloadStorageStrategy.getDownloadPath(context, entry)));
        params.put("md5", md5);
        params.put("error_code", String.valueOf(downloadErrCode));
        params.put("url", url);
        Set<String> keySet = additional.keySet();
        for (String s : keySet) {
            Object value = additional.get(s);
            params.put(s, value == null ? "" : value.toString());
        }
        Neurons.trackT(z, NEURON_CONNECT_TRACE, params, 1, new Function0() { // from class: tv.danmaku.bili.report.VideoDownloadTracer$$ExternalSyntheticLambda2
            public final Object invoke() {
                return VideoDownloadTracer.lambda$reportConnectQualityTracer$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$reportConnectQualityTracer$1() {
        return true;
    }

    private static String getRequestHeaders(DownloadRequest downloadRequest) {
        if (downloadRequest == null) {
            return "[]";
        }
        return Arrays.toString(downloadRequest.getHeaders());
    }

    private static String getAverageSpeed(VideoDownloadResponse response) {
        if (response.getDownloadRequest() != null && !response.hasErrorException() && response.getReadStreamTime() > 1000) {
            long totalLength = response.getTotalLength();
            long length = totalLength - response.getStartRange();
            if (length >= 524288) {
                return String.valueOf((int) ((((float) length) / 1.024f) / ((float) response.getReadStreamTime())));
            }
            return "";
        }
        return "";
    }

    private static void fillErrorInfo(JSONObject addition, VideoDownloadEntry entry) {
        String str;
        Exception e = entry.mException;
        if (e != null) {
            StringBuilder sb = new StringBuilder();
            if (-1 == entry.mLastErrorCode) {
                str = e.getClass().getSimpleName() + ":";
            } else {
                str = "";
            }
            addition.put("error_msg", sb.append(str).append(e.getMessage()).toString());
            if (entry.mLastErrorCode == 2001 || entry.mLastErrorCode == 2002) {
                ResolveMediaSourceException cause = e.getCause();
                if (cause instanceof ResolveException) {
                    if (cause instanceof ResolveFreeDataException) {
                        addition.put("resolve_error", AppConfig.HOST_UNICOM);
                    } else if (cause instanceof ResolveMediaSourceException) {
                        int subCode = cause.getCode();
                        if (subCode == 0) {
                            addition.put("resolve_error", "local");
                        } else {
                            addition.put("resolve_error", "lua_response");
                            addition.put("resolve_error_info", Integer.valueOf(subCode));
                        }
                    } else if (cause instanceof ResolveJsonException) {
                        addition.put("resolve_error", "json");
                    } else if (cause instanceof ResolveBangumiException) {
                        addition.put("resolve_error", "bangumi");
                    } else {
                        addition.put("resolve_error", "other");
                    }
                }
            }
        }
        addition.put("error_from", getErrorFrom(entry));
    }

    private static String getErrorFrom(VideoDownloadEntry entry) {
        String from = entry.getFrom();
        return TextUtils.isEmpty(from) ? "bangumi" : from;
    }

    public static void reportDownloadPerformance(int taskCount, long initializeTime) {
        Map<String, String> params = new HashMap<>();
        params.put("initialize_time", String.valueOf(initializeTime));
        params.put("task_count", String.valueOf(taskCount));
        params.put("download_storage", String.valueOf(Settings.Download.getDownloadStorage(BiliContext.application())));
        Neurons.trackT(false, NEURON_PERFORMANCE_TRACE, params, 1, new Function0() { // from class: tv.danmaku.bili.report.VideoDownloadTracer$$ExternalSyntheticLambda3
            public final Object invoke() {
                return VideoDownloadTracer.lambda$reportDownloadPerformance$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$reportDownloadPerformance$2() {
        return true;
    }

    public static void reportDownloadLoadEntryPerformance(int taskCount, long initializeTime, int type) {
        Map<String, String> params = new HashMap<>();
        params.put("cost_time", String.valueOf(initializeTime));
        params.put("entries_count", String.valueOf(taskCount));
        params.put("type", String.valueOf(type));
        params.put("download_storage", String.valueOf(Settings.Download.getDownloadStorage(BiliContext.application())));
        Neurons.trackT(false, NEURON_LOAD_ENTRIES_PERFORMANCE_TRACE, params, 1, new Function0() { // from class: tv.danmaku.bili.report.VideoDownloadTracer$$ExternalSyntheticLambda1
            public final Object invoke() {
                return VideoDownloadTracer.lambda$reportDownloadLoadEntryPerformance$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$reportDownloadLoadEntryPerformance$3() {
        return true;
    }
}