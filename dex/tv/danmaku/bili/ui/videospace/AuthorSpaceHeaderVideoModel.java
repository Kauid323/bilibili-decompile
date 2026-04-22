package tv.danmaku.bili.ui.videospace;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.provider.UtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthorSpaceHeaderVideoModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<J\u001a\u0010=\u001a\u00020:2\b\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020&J\b\u0010A\u001a\u00020:H\u0002J\b\u0010B\u001a\u00020:H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u00100\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u001e\u00103\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b4\u0010,\"\u0004\b5\u0010.R\u001c\u00106\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012¨\u0006D"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderVideoModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "avid", "", "getAvid", "()J", "setAvid", "(J)V", "cid", "getCid", "setCid", "bvid", "", "getBvid", "()Ljava/lang/String;", "setBvid", "(Ljava/lang/String;)V", "fromSpmid", "getFromSpmid", "setFromSpmid", "spmid", "getSpmid", "setSpmid", "fastPlayInfo", "getFastPlayInfo", "setFastPlayInfo", "fastPlayCid", "getFastPlayCid", "setFastPlayCid", "fastPlayQuality", "", "getFastPlayQuality", "()I", "setFastPlayQuality", "(I)V", "isFastPlayEnable", "", "()Z", "setFastPlayEnable", "(Z)V", "playerWidth", "getPlayerWidth", "()Ljava/lang/Integer;", "setPlayerWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "playerHeight", "getPlayerHeight", "setPlayerHeight", "playerRotate", "getPlayerRotate", "setPlayerRotate", "directPlayUrl", "getDirectPlayUrl", "setDirectPlayUrl", "extractIntent", "", "activity", "Landroid/app/Activity;", "extractUri", "uri", "Landroid/net/Uri;", "isDirectUrl", "extractFastPlayInfo", "resetFastPlayInfo", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthorSpaceHeaderVideoModel extends ViewModel {
    public static final String EXTRA_PARAM_AID = "aid";
    public static final String EXTRA_PARAM_BVID = "player_bvid";
    public static final String EXTRA_PARAM_CID = "cid";
    public static final String EXTRA_PARAM_FAST_CID = "cid";
    public static final String EXTRA_PARAM_FAST_PLAYING_INFO = "player_preload";
    public static final String EXTRA_PARAM_FROM_SPMID = "from_spmid";
    public static final String EXTRA_PARAM_IS_DIRECT_PLAY_URL = "is_direct_play_url";
    public static final String EXTRA_PARAM_IS_HIDE_LOADING = "is_hide_loading";
    public static final String EXTRA_PARAM_IS_LOOPING = "is_looping";
    public static final String EXTRA_PARAM_PLAYER_HEIGHT = "player_height";
    public static final String EXTRA_PARAM_PLAYER_ROTATE = "player_rotate";
    public static final String EXTRA_PARAM_PLAYER_WIDTH = "player_width";
    public static final String EXTRA_PARAM_QUALITY = "quality";
    public static final long INVALID_LONG_VALUE = -1;
    public static final int INVALID_VALUE = -1;
    public static final String SPMID = "main.space-top-video.0.0";
    private static final String TAG = "AuthorSpaceHeaderVideoModel";
    private String directPlayUrl;
    private String fastPlayInfo;
    private boolean isFastPlayEnable;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private long avid = -1;
    private long cid = -1;
    private String bvid = "";
    private String fromSpmid = "";
    private String spmid = "";
    private long fastPlayCid = -1;
    private int fastPlayQuality = -1;
    private Integer playerWidth = -1;
    private Integer playerHeight = -1;
    private Integer playerRotate = -1;

    public final long getAvid() {
        return this.avid;
    }

    public final void setAvid(long j) {
        this.avid = j;
    }

    public final long getCid() {
        return this.cid;
    }

    public final void setCid(long j) {
        this.cid = j;
    }

    public final String getBvid() {
        return this.bvid;
    }

    public final void setBvid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bvid = str;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final void setFromSpmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromSpmid = str;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final void setSpmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spmid = str;
    }

    public final String getFastPlayInfo() {
        return this.fastPlayInfo;
    }

    public final void setFastPlayInfo(String str) {
        this.fastPlayInfo = str;
    }

    public final long getFastPlayCid() {
        return this.fastPlayCid;
    }

    public final void setFastPlayCid(long j) {
        this.fastPlayCid = j;
    }

    public final int getFastPlayQuality() {
        return this.fastPlayQuality;
    }

    public final void setFastPlayQuality(int i) {
        this.fastPlayQuality = i;
    }

    public final boolean isFastPlayEnable() {
        return this.isFastPlayEnable;
    }

    public final void setFastPlayEnable(boolean z) {
        this.isFastPlayEnable = z;
    }

    public final Integer getPlayerWidth() {
        return this.playerWidth;
    }

    public final void setPlayerWidth(Integer num) {
        this.playerWidth = num;
    }

    public final Integer getPlayerHeight() {
        return this.playerHeight;
    }

    public final void setPlayerHeight(Integer num) {
        this.playerHeight = num;
    }

    public final Integer getPlayerRotate() {
        return this.playerRotate;
    }

    public final void setPlayerRotate(Integer num) {
        this.playerRotate = num;
    }

    public final String getDirectPlayUrl() {
        return this.directPlayUrl;
    }

    public final void setDirectPlayUrl(String str) {
        this.directPlayUrl = str;
    }

    public final void extractIntent(Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        Long longOrNull = StringsKt.toLongOrNull(String.valueOf(extras != null ? extras.get("aid") : null));
        this.avid = longOrNull != null ? longOrNull.longValue() : -1L;
        Long longOrNull2 = StringsKt.toLongOrNull(String.valueOf(extras != null ? extras.get("cid") : null));
        this.cid = longOrNull2 != null ? longOrNull2.longValue() : -1L;
        this.fastPlayInfo = String.valueOf(extras != null ? extras.get(EXTRA_PARAM_FAST_PLAYING_INFO) : null);
        int intOrNull = StringsKt.toIntOrNull(String.valueOf(extras != null ? extras.get(EXTRA_PARAM_PLAYER_WIDTH) : null));
        if (intOrNull == null) {
            intOrNull = -1;
        }
        this.playerWidth = intOrNull;
        int intOrNull2 = StringsKt.toIntOrNull(String.valueOf(extras != null ? extras.get(EXTRA_PARAM_PLAYER_HEIGHT) : null));
        if (intOrNull2 == null) {
            intOrNull2 = -1;
        }
        this.playerHeight = intOrNull2;
        int intOrNull3 = StringsKt.toIntOrNull(String.valueOf(extras != null ? extras.get(EXTRA_PARAM_PLAYER_ROTATE) : null));
        if (intOrNull3 == null) {
            intOrNull3 = -1;
        }
        this.playerRotate = intOrNull3;
        this.bvid = String.valueOf(extras != null ? extras.get(EXTRA_PARAM_BVID) : null);
        this.fromSpmid = String.valueOf(extras != null ? extras.get("from_spmid") : null);
        this.spmid = SPMID;
        extractFastPlayInfo();
    }

    public static /* synthetic */ void extractUri$default(AuthorSpaceHeaderVideoModel authorSpaceHeaderVideoModel, Uri uri, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        authorSpaceHeaderVideoModel.extractUri(uri, z);
    }

    public final void extractUri(Uri uri, boolean isDirectUrl) {
        if (isDirectUrl) {
            this.directPlayUrl = uri != null ? uri.toString() : null;
            return;
        }
        this.directPlayUrl = null;
        if (uri == null || uri.getPathSegments().size() < 3) {
            return;
        }
        Long longOrNull = StringsKt.toLongOrNull(uri.getPathSegments().get(1).toString());
        this.avid = longOrNull != null ? longOrNull.longValue() : -1L;
        Long longOrNull2 = StringsKt.toLongOrNull(uri.getPathSegments().get(2).toString());
        this.cid = longOrNull2 != null ? longOrNull2.longValue() : -1L;
        this.fastPlayInfo = String.valueOf(uri.getQueryParameter(EXTRA_PARAM_FAST_PLAYING_INFO));
        int intOrNull = StringsKt.toIntOrNull(String.valueOf(uri.getQueryParameter(EXTRA_PARAM_PLAYER_WIDTH)));
        if (intOrNull == null) {
            intOrNull = -1;
        }
        this.playerWidth = intOrNull;
        int intOrNull2 = StringsKt.toIntOrNull(String.valueOf(uri.getQueryParameter(EXTRA_PARAM_PLAYER_HEIGHT)));
        if (intOrNull2 == null) {
            intOrNull2 = -1;
        }
        this.playerHeight = intOrNull2;
        int intOrNull3 = StringsKt.toIntOrNull(String.valueOf(uri.getQueryParameter(EXTRA_PARAM_PLAYER_ROTATE)));
        if (intOrNull3 == null) {
            intOrNull3 = -1;
        }
        this.playerRotate = intOrNull3;
        this.bvid = String.valueOf(uri.getQueryParameter(EXTRA_PARAM_BVID));
        this.fromSpmid = String.valueOf(uri.getQueryParameter("from_spmid"));
        this.spmid = SPMID;
        extractFastPlayInfo();
    }

    private final void extractFastPlayInfo() {
        this.fastPlayInfo = Uri.decode(this.fastPlayInfo);
        try {
            JSONObject jsonObject = JSON.parseObject(this.fastPlayInfo);
            this.fastPlayCid = jsonObject.getLongValue("cid");
            this.fastPlayQuality = jsonObject.getIntValue(EXTRA_PARAM_QUALITY);
            this.isFastPlayEnable = true;
            BLog.i(TAG, "preloadData get success");
        } catch (Exception e) {
            BLog.i(TAG, "preloadData parse failed");
            resetFastPlayInfo();
            this.isFastPlayEnable = false;
        }
    }

    private final void resetFastPlayInfo() {
        this.fastPlayInfo = null;
        this.fastPlayCid = -1L;
        this.fastPlayQuality = -1;
        this.isFastPlayEnable = false;
    }

    /* compiled from: AuthorSpaceHeaderVideoModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderVideoModel$Companion;", "", "<init>", "()V", "TAG", "", "INVALID_VALUE", "", "INVALID_LONG_VALUE", "", "EXTRA_PARAM_AID", "EXTRA_PARAM_CID", "EXTRA_PARAM_FAST_CID", "EXTRA_PARAM_BVID", "EXTRA_PARAM_FAST_PLAYING_INFO", "EXTRA_PARAM_QUALITY", "EXTRA_PARAM_PLAYER_WIDTH", "EXTRA_PARAM_PLAYER_HEIGHT", "EXTRA_PARAM_PLAYER_ROTATE", "EXTRA_PARAM_FROM_SPMID", "EXTRA_PARAM_IS_DIRECT_PLAY_URL", "EXTRA_PARAM_IS_LOOPING", "EXTRA_PARAM_IS_HIDE_LOADING", "SPMID", "get", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderVideoModel;", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AuthorSpaceHeaderVideoModel get(Context context) {
            ViewModelStoreOwner findFragmentActivityOrNull = UtilKt.findFragmentActivityOrNull(context);
            if (findFragmentActivityOrNull == null) {
                return null;
            }
            return (AuthorSpaceHeaderVideoModel) new ViewModelProvider(findFragmentActivityOrNull).get(AuthorSpaceHeaderVideoModel.class);
        }
    }

    @JvmStatic
    public static final AuthorSpaceHeaderVideoModel get(Context context) {
        return Companion.get(context);
    }
}