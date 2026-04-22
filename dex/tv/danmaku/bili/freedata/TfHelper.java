package tv.danmaku.bili.freedata;

import android.content.Context;
import com.bapis.bilibili.app.wall.v1.RulesReply;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.gripper.api.buvid.GBuvid;
import com.bilibili.gripper.api.foundation.GFoundation;
import com.bilibili.gripper.api.neuron.GNeurons;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.tf.LogLevel;
import com.bilibili.lib.tf.Tf;
import com.bilibili.lib.tf.TfActivateCallback;
import com.bilibili.lib.tf.TfActivateEvent;
import com.bilibili.lib.tf.TfActivateReq;
import com.bilibili.lib.tf.TfActivateStatus;
import com.bilibili.lib.tf.TfBuilder;
import com.bilibili.lib.tf.TfChangeCallback;
import com.bilibili.lib.tf.TfDelegate;
import com.bilibili.lib.tf.TfProvider;
import com.bilibili.lib.tf.TfQueryReq;
import com.bilibili.lib.tf.TfQueryResp;
import com.bilibili.lib.tf.TfSwitchEvent;
import com.bilibili.lib.tf.TfTrack;
import com.bilibili.lib.tf.TfTransformEvent;
import com.bilibili.lib.tf.TfTransformReq;
import com.bilibili.lib.tf.TfTransformResp;
import com.bilibili.lib.tf.TfTypeExt;
import com.bilibili.lib.tf.freedata.TF;
import com.bilibili.lib.tf.freedata.util.log.TfLog;
import com.bilibili.lib.tf.sp.MobileServiceConfig;
import com.bilibili.lib.tf.sp.TelecomServiceConfig;
import com.bilibili.lib.tf.sp.UnicomServiceConfig;
import java.io.File;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.freedata.internal.config.TfResourceConfigKt;
import tv.danmaku.bili.freedata.internal.delegate.NaTfDelegate;
import tv.danmaku.bili.freedata.internal.ipc.brdcst.TfSyncModelsReceiverKt;
import tv.danmaku.bili.freedata.internal.rpc.WallKt;
import tv.danmaku.bili.freedata.internal.track.TfGNeuronsTrack;
import tv.danmaku.bili.ui.freedata.tracer.TfMultiDomainKt;

/* compiled from: TfHelper.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0003¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/freedata/TfHelper;", "", "<init>", "()V", "initTf", "", "context", "Landroid/content/Context;", "buvidService", "Lcom/bilibili/gripper/api/buvid/GBuvid;", "f", "Lcom/bilibili/gripper/api/foundation/GFoundation;", "neurons", "Lcom/bilibili/gripper/api/neuron/GNeurons;", "getTfStoragePath", "", "updateTfRules", "doUpdateTfRules", "network-ignet-ctr_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TfHelper {
    public static final TfHelper INSTANCE = new TfHelper();

    private TfHelper() {
    }

    public final void initTf(Context context, GBuvid buvidService, GFoundation f, GNeurons neurons) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buvidService, "buvidService");
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(neurons, "neurons");
        UnicomServiceConfig unicom = new UnicomServiceConfig("https://app.bilibili.com/x/wall/unicom/active/state", TfResourceConfigKt.getUnicomCard(), TfResourceConfigKt.getUnicomPackage(), false, false);
        MobileServiceConfig mobile = new MobileServiceConfig("https://app.bilibili.com/x/wall/mobile/active/state", TfResourceConfigKt.getMobileCard(), TfResourceConfigKt.getMobilePackage());
        TelecomServiceConfig telecom = new TelecomServiceConfig("https://app.bilibili.com/x/wall/telecom/active/state", TfResourceConfigKt.getTelecomCard());
        final TfGNeuronsTrack tfTrack = new TfGNeuronsTrack(neurons);
        final NaTfDelegate tfDelegate = new NaTfDelegate(buvidService, f);
        final Tf tf = new TfBuilder(context).enable(true).debug(true).trackEnable(true).ignetCAPIEnable(DeviceDecision.INSTANCE.getBoolean("tf_ignet_c_api_enable", true)).track(new TfTrack() { // from class: tv.danmaku.bili.freedata.TfHelper$initTf$tf$1
            public void trackActivate(TfActivateEvent p0) {
                TfGNeuronsTrack.this.trackActivate(p0);
            }

            public void trackSwitch(TfSwitchEvent p0) {
                TfGNeuronsTrack.this.trackSwitch(p0);
            }

            public void trackTransform(TfTransformEvent p0) {
                TfGNeuronsTrack.this.trackTransform(p0);
            }

            public void trackNetwork(ByteBuffer p0) {
                TfGNeuronsTrack.this.trackNetwork(p0);
            }
        }).delegate(new TfDelegate() { // from class: tv.danmaku.bili.freedata.TfHelper$initTf$tf$2
            public String withCommonParams(String p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return NaTfDelegate.this.withCommonParams(p0);
            }

            public String getBuvid() {
                return NaTfDelegate.this.getBuvid();
            }

            public boolean isDirectBvcConvertEnabled() {
                return NaTfDelegate.this.isDirectBvcConvertEnabled();
            }

            public void maybeSyncModels() {
                NaTfDelegate.this.maybeSyncModels();
            }

            public void log(LogLevel p0, String p1, String p2) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                Intrinsics.checkNotNullParameter(p2, "p2");
                NaTfDelegate.this.log(p0, p1, p2);
            }
        }).storagePath(getTfStoragePath(context)).unicom(unicom).mobile(mobile).telecom(telecom).build();
        Intrinsics.checkNotNullExpressionValue(tf, "build(...)");
        if (FreeDataManager.getInstance().getNewSDK()) {
            FreeDataManager.getInstance().initNewTf(new TF() { // from class: tv.danmaku.bili.freedata.TfHelper$initTf$1
                public void setTfRulesConfig(RulesReply config) {
                    Intrinsics.checkNotNullParameter(config, "config");
                    try {
                        ByteBuffer out = ByteBuffer.allocateDirect(config.getSerializedSize());
                        out.put(config.toByteArray());
                        tf.setTfRulesConfig(out);
                    } catch (Exception e) {
                        TfLog.Companion.e("tf.freedata.holder", "setTfRulesConfig exception=" + e);
                    }
                }

                public RulesReply getTfRulesConfig() {
                    try {
                        ByteBuffer config = tf.getTfRulesConfig();
                        if (config == null) {
                            return null;
                        }
                        return RulesReply.parseFrom(config);
                    } catch (Exception e) {
                        TfLog.Companion.e("tf.freedata.holder", "getTfRulesConfig exception=" + e);
                        return null;
                    }
                }

                public boolean isTfUrl(String url) {
                    Intrinsics.checkNotNullParameter(url, "url");
                    return tf.isTfUrl(url);
                }

                public void removeTfChangeCallback(long handle) {
                    tf.removeTfChangeCallback(handle);
                }

                public long addTfChangeCallback(TfChangeCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
                    return tf.addTfChangeCallback(callback);
                }

                public void onSyncModels() {
                    tf.onSyncModels();
                }

                public void shutdown() {
                    tf.shutdown();
                }

                public void activate(TfActivateReq req, TfActivateCallback callback) {
                    Intrinsics.checkNotNullParameter(req, "req");
                    tf.activate(req, callback);
                }

                public void setActivate(TfActivateStatus status) {
                    Intrinsics.checkNotNullParameter(status, "status");
                    tf.setActivate(status);
                }

                public TfTransformResp transform(TfTransformReq req) {
                    Intrinsics.checkNotNullParameter(req, "req");
                    TfTransformResp transform = tf.transform(req);
                    Intrinsics.checkNotNullExpressionValue(transform, "transform(...)");
                    return transform;
                }

                public TfQueryResp query(TfQueryReq req) {
                    Intrinsics.checkNotNullParameter(req, "req");
                    TfQueryResp query = tf.query(req);
                    Intrinsics.checkNotNullExpressionValue(query, "query(...)");
                    return query;
                }

                public void enable(TfTypeExt typeExt, boolean enabled) {
                    Intrinsics.checkNotNullParameter(typeExt, "typeExt");
                    tf.enable(typeExt, enabled);
                }

                public boolean isEnabled(TfTypeExt typeExt) {
                    Intrinsics.checkNotNullParameter(typeExt, "typeExt");
                    return tf.isEnabled(typeExt);
                }

                public TfActivateStatus getActivate() {
                    return tf.getActivate();
                }

                public TfActivateStatus getCachedActivate(TfProvider provider) {
                    Intrinsics.checkNotNullParameter(provider, "provider");
                    return tf.getCachedActivate(provider);
                }

                public void clearActivate() {
                    tf.clearActivate();
                }

                public void clearCachedActivate(TfProvider provider) {
                    Intrinsics.checkNotNullParameter(provider, "provider");
                    tf.clearCachedActivate(provider);
                }
            });
        }
        updateTfRules();
        TfSyncModelsReceiverKt.registerSyncModelReceiver();
    }

    private final String getTfStoragePath(Context context) {
        File bilitf = context.getDir("bilitf", 0);
        File tf = new File(bilitf, "tfv2");
        if (!tf.exists()) {
            tf.mkdirs();
        }
        String absolutePath = tf.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    private final void updateTfRules() {
        if (BiliContext.isMainProcess()) {
            HandlerThreads.getHandler(2).postDelayed(new Runnable() { // from class: tv.danmaku.bili.freedata.TfHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TfHelper.updateTfRules$lambda$0();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTfRules$lambda$0() {
        INSTANCE.doUpdateTfRules();
    }

    private final void doUpdateTfRules() {
        RulesReply resp = WallKt.getTfRules();
        if (resp != null) {
            TfMultiDomainKt.updateMultiDomainRule(resp);
            FreeDataManager.getInstance().setTfRulesConfig(resp);
        }
    }
}