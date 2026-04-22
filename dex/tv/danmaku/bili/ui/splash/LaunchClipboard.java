package tv.danmaku.bili.ui.splash;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bilibili.app.preferences.Settings;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.BVCompat;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.teenagersmode.TeenagersMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.clipboard.BvResult;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: LaunchClipboard.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0006'()*+,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0015J\u0010\u0010 \u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010!J$\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard;", "", "<init>", "()V", "TIMEOUT", "", "PATTERN_OPEN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PATTERN_AV", "getPATTERN_AV$core_apinkDebug", "()Ljava/util/regex/Pattern;", "PATTERN_SS", "PATTERN_EP", "PATTERN_URL", "SCHEME", "", "recognizeOpenData", "content", "", "parseOpenData", "Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;", "recognizeBvData", "text", "regex", "parseBvData", "Ltv/danmaku/bili/ui/splash/LaunchClipboard$BvData;", "result", "decode", "report", "", "playData", "checkBvData", "Ltv/danmaku/bili/ui/clipboard/BvResult;", "covertToPlayData", "url", "query", "available", "", "PlayData", "BvData", "VideoData", "SeasonData", "EpData", "UrlData", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LaunchClipboard {
    private static final String SCHEME = "bilibili://";
    private static final int TIMEOUT = 1800000;
    public static final LaunchClipboard INSTANCE = new LaunchClipboard();
    private static final Pattern PATTERN_OPEN = Pattern.compile("FromUriOpen@bilibili://(([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==))");
    private static final Pattern PATTERN_AV = Pattern.compile("^av(\\d+)?.+");
    private static final Pattern PATTERN_SS = Pattern.compile("^ss(\\d+)?.+");
    private static final Pattern PATTERN_EP = Pattern.compile("^ep(\\d+)?.+");
    private static final Pattern PATTERN_URL = Pattern.compile("^(http(s)?://)?([a-z-0-9A-Z]+.)?(bilibili.(com|tv|cn)|biligame.(com|cn|net)|(bilibiliyoo|im9).com|b23.tv|(bili2233|bili23|bili33|bili22).cn)($|/|)", 2);
    public static final int $stable = 8;

    private LaunchClipboard() {
    }

    public final Pattern getPATTERN_AV$core_apinkDebug() {
        return PATTERN_AV;
    }

    public final String recognizeOpenData(CharSequence content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Matcher m = PATTERN_OPEN.matcher(StringsKt.trim(content));
        Intrinsics.checkNotNullExpressionValue(m, "matcher(...)");
        if (m.find()) {
            String encodedContent = m.group(1);
            String decodedContent = decode(encodedContent);
            if (TextUtils.isEmpty(decodedContent) || Intrinsics.areEqual(encodedContent, decodedContent)) {
                return null;
            }
            return decodedContent;
        }
        return "";
    }

    public final PlayData parseOpenData(CharSequence content) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(content, "content");
        String url = SCHEME + ((Object) content);
        Uri uri = Uri.parse(url);
        if (uri == null) {
            return null;
        }
        String queryParameter = uri.getQueryParameter("ts");
        long ts = ((queryParameter == null || (longOrNull = StringsKt.toLongOrNull(queryParameter)) == null) ? 0L : longOrNull.longValue()) * ((long) IjkMediaCodecInfo.RANK_MAX);
        long currentTime = System.currentTimeMillis();
        boolean available = currentTime - ts <= 1800000 && Intrinsics.areEqual("E", uri.getQueryParameter("abtest"));
        return covertToPlayData(url, uri.getQuery(), available);
    }

    public final String recognizeBvData(CharSequence text, String regex) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(regex, "regex");
        CharSequence clipText = StringsKt.trim(text);
        if (BVCompat.isBvOpen() && !TeenagersMode.getInstance().isEnable() && Settings.General.isClipAutoJumpBvEnable(BiliContext.application())) {
            try {
                Pattern finalPattern = Pattern.compile(regex);
                Intrinsics.checkNotNullExpressionValue(finalPattern, "compile(...)");
                Matcher bvMatcher = finalPattern.matcher(clipText);
                Intrinsics.checkNotNullExpressionValue(bvMatcher, "matcher(...)");
                if (bvMatcher.find()) {
                    return bvMatcher.group();
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public final BvData parseBvData(String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        BvData bvData = new BvData();
        if (StringsKt.startsWith$default(result, "http", false, 2, (Object) null)) {
            bvData.setBvUrl(result);
        } else {
            bvData.setBvId(result);
        }
        return bvData;
    }

    private final String decode(String content) {
        byte[] bytes;
        if (TextUtils.isEmpty(content)) {
            return content;
        }
        if (content == null) {
            bytes = null;
        } else {
            try {
                bytes = content.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            } catch (Exception e) {
                return content;
            }
        }
        byte[] data = Base64.decode(bytes, 0);
        Intrinsics.checkNotNull(data);
        return Uri.decode(new String(data, Charsets.UTF_8));
    }

    public final void report(PlayData playData) {
        if (playData == null) {
            return;
        }
        HashMap params = new HashMap();
        String url = playData.getDecodedUrl();
        params.put("copy_url", url == null ? "" : url);
        String expGroup = null;
        if (url != null) {
            expGroup = Uri.parse(url).getQueryParameter("abtest");
        }
        params.put("exp_group", expGroup != null ? expGroup : "");
        params.put("is_open_success", playData.getAvailable() ? "1" : "0");
        Neurons.report$default(false, 0, "main.GrowthHacker.fromCopyLink.other", params, (String) null, 0, 48, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkBvData(BvResult result) {
        BvData playData;
        boolean z;
        boolean z2;
        if (result == null || (playData = result.getBvData()) == null) {
            return;
        }
        final Application context = BiliContext.application();
        boolean jumpSuccess = false;
        String bvUrl = playData.getBvUrl();
        if (bvUrl != null) {
            if (bvUrl.length() > 0) {
                z = true;
                if (!z) {
                    String bvUrl2 = playData.getBvUrl();
                    Intrinsics.checkNotNull(bvUrl2);
                    RouteRequest requestUrl = new RouteRequest.Builder(bvUrl2).build();
                    RouteResponse resp = BLRouter.routeTo(requestUrl, context);
                    jumpSuccess = resp.isSuccess();
                    if (!jumpSuccess) {
                        BLog.i("ClipboardChecker", "bvUrl jump fail, url=" + playData.getBvUrl() + ", error=" + resp.getMessage());
                    }
                } else {
                    String bvId = playData.getBvId();
                    if (bvId != null) {
                        if (bvId.length() > 0) {
                            z2 = true;
                            if (!z2) {
                                RouteRequest requestBv = new RouteRequest.Builder("bilibili://video/" + playData.getBvId()).build();
                                RouteResponse resp2 = BLRouter.routeTo(requestBv, context);
                                jumpSuccess = resp2.isSuccess();
                                if (!jumpSuccess) {
                                    BLog.i("ClipboardChecker", "bvId jump fail, url=" + playData.getBvId() + ", error=" + resp2.getMessage());
                                }
                            } else {
                                BLog.i("ClipboardChecker", "bvUrl and bvId is null");
                            }
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
                if (jumpSuccess) {
                    HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.splash.LaunchClipboard$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            LaunchClipboard.checkBvData$lambda$0(context);
                        }
                    }, 1000L);
                    Neurons.reportExposure$default(false, "main.ugc-video-detail.read-clipboard.0.show", (Map) null, (List) null, 12, (Object) null);
                    ClipboardChecker.INSTANCE.reportClipboardJump(1L);
                    ClipboardJumpHelper.onClipboardJumped(true);
                }
                ClipboardChecker.resetResult();
            }
        }
        z = false;
        if (!z) {
        }
        if (jumpSuccess) {
        }
        ClipboardChecker.resetResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkBvData$lambda$0(Application $context) {
        ToastHelper.showToastShort($context, bili.resource.homepage.R.string.homepage_global_string_327);
    }

    private final PlayData covertToPlayData(String url, String query, boolean available) {
        String decodedUrl = StringsKt.removePrefix(url, SCHEME);
        Matcher mAv = PATTERN_AV.matcher(decodedUrl);
        Intrinsics.checkNotNullExpressionValue(mAv, "matcher(...)");
        Matcher mSs = PATTERN_SS.matcher(decodedUrl);
        Intrinsics.checkNotNullExpressionValue(mSs, "matcher(...)");
        Matcher mEp = PATTERN_EP.matcher(decodedUrl);
        Intrinsics.checkNotNullExpressionValue(mEp, "matcher(...)");
        Matcher mUrl = PATTERN_URL.matcher(decodedUrl);
        Intrinsics.checkNotNullExpressionValue(mUrl, "matcher(...)");
        if (mAv.find()) {
            String id = mAv.group(1);
            PlayData playData = new VideoData();
            ((VideoData) playData).setId(id);
            ((VideoData) playData).setQuery(query);
            ((VideoData) playData).setAvailable(available);
            ((VideoData) playData).setDecodedUrl(url);
            return playData;
        } else if (mSs.find()) {
            String id2 = mSs.group(1);
            PlayData playData2 = new SeasonData();
            ((SeasonData) playData2).setId(id2);
            ((SeasonData) playData2).setQuery(query);
            ((SeasonData) playData2).setAvailable(available);
            ((SeasonData) playData2).setDecodedUrl(url);
            return playData2;
        } else if (mEp.find()) {
            String id3 = mEp.group(1);
            PlayData playData3 = new EpData();
            ((EpData) playData3).setId(id3);
            ((EpData) playData3).setQuery(query);
            ((EpData) playData3).setAvailable(available);
            ((EpData) playData3).setDecodedUrl(url);
            return playData3;
        } else if (!mUrl.find()) {
            return null;
        } else {
            PlayData playData4 = new UrlData();
            ((UrlData) playData4).setQuery(query);
            ((UrlData) playData4).setAvailable(available);
            ((UrlData) playData4).setDecodedUrl(decodedUrl);
            return playData4;
        }
    }

    /* compiled from: LaunchClipboard.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "query", "getQuery", "setQuery", "available", "", "getAvailable", "()Z", "setAvailable", "(Z)V", "decodedUrl", "getDecodedUrl", "setDecodedUrl", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "valid", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class PlayData {
        public static final int $stable = 8;
        private boolean available;
        private String decodedUrl;
        private String id;
        private String query;

        public abstract Uri getUri();

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final String getQuery() {
            return this.query;
        }

        public final void setQuery(String str) {
            this.query = str;
        }

        public final boolean getAvailable() {
            return this.available;
        }

        public final void setAvailable(boolean z) {
            this.available = z;
        }

        public final String getDecodedUrl() {
            return this.decodedUrl;
        }

        public final void setDecodedUrl(String str) {
            this.decodedUrl = str;
        }

        public final boolean valid() {
            return this.available && getUri() != null;
        }
    }

    /* compiled from: LaunchClipboard.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard$BvData;", "Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;", "<init>", "()V", "bvId", "", "getBvId", "()Ljava/lang/String;", "setBvId", "(Ljava/lang/String;)V", "bvUrl", "getBvUrl", "setBvUrl", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BvData extends PlayData {
        public static final int $stable = 8;
        private String bvId;
        private String bvUrl;

        public final String getBvId() {
            return this.bvId;
        }

        public final void setBvId(String str) {
            this.bvId = str;
        }

        public final String getBvUrl() {
            return this.bvUrl;
        }

        public final void setBvUrl(String str) {
            this.bvUrl = str;
        }

        @Override // tv.danmaku.bili.ui.splash.LaunchClipboard.PlayData
        public Uri getUri() {
            if (!TextUtils.isEmpty(this.bvUrl)) {
                return Uri.parse(this.bvUrl);
            }
            if (!TextUtils.isEmpty(this.bvId)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, "bilibili://video/%s", Arrays.copyOf(new Object[]{getId()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return Uri.parse(format);
            }
            return null;
        }
    }

    /* compiled from: LaunchClipboard.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard$VideoData;", "Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;", "<init>", "()V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VideoData extends PlayData {
        private static final String FMT_ROUTE = "bilibili://video/%s";
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        @Override // tv.danmaku.bili.ui.splash.LaunchClipboard.PlayData
        public Uri getUri() {
            if (TextUtils.isEmpty(getId())) {
                return null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, FMT_ROUTE, Arrays.copyOf(new Object[]{getId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return Uri.parse(format).buildUpon().encodedQuery(getQuery()).build();
        }

        /* compiled from: LaunchClipboard.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard$VideoData$Companion;", "", "<init>", "()V", "FMT_ROUTE", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: LaunchClipboard.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard$SeasonData;", "Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;", "<init>", "()V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SeasonData extends PlayData {
        private static final String FMT_ROUTE = "bilibili://pgc/season/%s";
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        @Override // tv.danmaku.bili.ui.splash.LaunchClipboard.PlayData
        public Uri getUri() {
            if (getId() == null) {
                return null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, FMT_ROUTE, Arrays.copyOf(new Object[]{getId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return Uri.parse(format).buildUpon().encodedQuery(getQuery()).build();
        }

        /* compiled from: LaunchClipboard.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard$SeasonData$Companion;", "", "<init>", "()V", "FMT_ROUTE", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: LaunchClipboard.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard$EpData;", "Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;", "<init>", "()V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class EpData extends PlayData {
        private static final String FMT_ROUTE = "http://www.bilibili.com/bangumi/play/ep%s";
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        @Override // tv.danmaku.bili.ui.splash.LaunchClipboard.PlayData
        public Uri getUri() {
            if (TextUtils.isEmpty(getId())) {
                return null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, FMT_ROUTE, Arrays.copyOf(new Object[]{getId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return Uri.parse(format).buildUpon().encodedQuery(getQuery()).build();
        }

        /* compiled from: LaunchClipboard.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard$EpData$Companion;", "", "<init>", "()V", "FMT_ROUTE", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: LaunchClipboard.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchClipboard$UrlData;", "Ltv/danmaku/bili/ui/splash/LaunchClipboard$PlayData;", "<init>", "()V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class UrlData extends PlayData {
        public static final int $stable = 8;

        @Override // tv.danmaku.bili.ui.splash.LaunchClipboard.PlayData
        public Uri getUri() {
            if (getDecodedUrl() == null) {
                return null;
            }
            return Uri.parse(getDecodedUrl());
        }
    }
}