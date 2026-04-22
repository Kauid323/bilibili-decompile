package tv.danmaku.bili.utils;

import android.app.Application;
import android.text.TextUtils;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.biliid.internal.storage.prefs.EnvironmentPrefHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.utils.IPreAssembleChannelChecker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChannelNameUtil.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/utils/ChannelNameUtil;", "", "<init>", "()V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChannelNameUtil {
    public static final int $stable = 0;
    private static String CHANNEL;
    private static String PREASSEMBLE_CHANNEL;
    public static final Companion Companion = new Companion(null);
    private static final String KEY_CHANNEL_PREASSEMBLE = "bili.channel.preassemble";
    private static final String DEFAULT_CHANNEL = "master";
    private static final String DEFALUT_PREASSEMBLE_CHANNEL = "NONE";

    /* compiled from: ChannelNameUtil.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u0005H\u0007J\b\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/utils/ChannelNameUtil$Companion;", "", "<init>", "()V", "KEY_CHANNEL_PREASSEMBLE", "", "DEFAULT_CHANNEL", "DEFALUT_PREASSEMBLE_CHANNEL", "CHANNEL", "PREASSEMBLE_CHANNEL", "isPreAssembleChannel", "", "getPackageChannel", "getChannelFromApk", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isPreAssembleChannel() {
            if (!TextUtils.isEmpty(ChannelNameUtil.PREASSEMBLE_CHANNEL)) {
                return !StringsKt.equals$default(ChannelNameUtil.PREASSEMBLE_CHANNEL, ChannelNameUtil.DEFALUT_PREASSEMBLE_CHANNEL, false, 2, (Object) null);
            }
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            ChannelNameUtil.PREASSEMBLE_CHANNEL = BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).getString(ChannelNameUtil.KEY_CHANNEL_PREASSEMBLE, null);
            if (!TextUtils.isEmpty(ChannelNameUtil.PREASSEMBLE_CHANNEL)) {
                return !StringsKt.equals$default(ChannelNameUtil.PREASSEMBLE_CHANNEL, ChannelNameUtil.DEFALUT_PREASSEMBLE_CHANNEL, false, 2, (Object) null);
            }
            getPackageChannel();
            return (TextUtils.isEmpty(ChannelNameUtil.PREASSEMBLE_CHANNEL) || StringsKt.equals$default(ChannelNameUtil.PREASSEMBLE_CHANNEL, ChannelNameUtil.DEFALUT_PREASSEMBLE_CHANNEL, false, 2, (Object) null)) ? false : true;
        }

        @JvmStatic
        public final String getPackageChannel() {
            Application context = BiliContext.application();
            Intrinsics.checkNotNull(context);
            if (TextUtils.isEmpty(ChannelNameUtil.CHANNEL)) {
                EnvironmentPrefHelper env = EnvironmentManager.getInstance().getPrefHelper();
                String name = env.getChannelName();
                if (TextUtils.isEmpty(name)) {
                    String channelInApk = getChannelFromApk();
                    name = channelInApk;
                    IPreAssembleChannelChecker preAssembleChannelChecker = new IPreAssembleChannelChecker.Builder().setContext(context).setApkChannel(channelInApk).build();
                    String preChannel = preAssembleChannelChecker != null ? preAssembleChannelChecker.getPreAssembleChannel() : null;
                    if (TextUtils.isEmpty(preChannel)) {
                        ChannelNameUtil.PREASSEMBLE_CHANNEL = ChannelNameUtil.DEFALUT_PREASSEMBLE_CHANNEL;
                    } else {
                        name = preChannel;
                        Intrinsics.checkNotNull(preChannel);
                        ChannelNameUtil.PREASSEMBLE_CHANNEL = preChannel;
                    }
                    env.setChannelName(name);
                    Application application = BiliContext.application();
                    Intrinsics.checkNotNull(application);
                    BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).edit().putString(ChannelNameUtil.KEY_CHANNEL_PREASSEMBLE, ChannelNameUtil.PREASSEMBLE_CHANNEL).commit();
                }
                ChannelNameUtil.CHANNEL = name;
            }
            String str = ChannelNameUtil.CHANNEL;
            Intrinsics.checkNotNull(str);
            return str;
        }

        private final String getChannelFromApk() {
            return FoundationAlias.getFapps().getChannel();
        }
    }

    @JvmStatic
    public static final boolean isPreAssembleChannel() {
        return Companion.isPreAssembleChannel();
    }

    @JvmStatic
    public static final String getPackageChannel() {
        return Companion.getPackageChannel();
    }
}