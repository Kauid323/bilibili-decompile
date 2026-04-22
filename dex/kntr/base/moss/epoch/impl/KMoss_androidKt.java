package kntr.base.moss.epoch.impl;

import com.bilibili.gripper.api.moss.GBusinessException;
import com.bilibili.gripper.api.moss.GCallOptions;
import com.bilibili.gripper.api.moss.GHttpBinding;
import com.bilibili.gripper.api.moss.GHttpVerb;
import com.bilibili.gripper.api.moss.GMethodDescriptor;
import com.bilibili.gripper.api.moss.GMossException;
import com.bilibili.gripper.api.moss.GMossHttpRule;
import com.bilibili.gripper.api.moss.GMossService;
import com.bilibili.gripper.api.moss.GMossServiceBuilder;
import com.bilibili.gripper.api.moss.GMossServiceComponent;
import com.bilibili.gripper.api.moss.GNetworkException;
import com.bilibili.gripper.api.moss.GRestReqContentType;
import com.bilibili.gripper.api.moss.GRestRespContentType;
import com.bilibili.gripper.api.moss.GUnhealthyException;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KBusinessException;
import kntr.base.moss.api.KCallOptions;
import kntr.base.moss.api.KHttpBinding;
import kntr.base.moss.api.KHttpVerb;
import kntr.base.moss.api.KMethodDescriptor;
import kntr.base.moss.api.KMossException;
import kntr.base.moss.api.KMossHttpRule;
import kntr.base.moss.api.KMossServiceComponent;
import kntr.base.moss.api.KNetworkException;
import kntr.base.moss.api.KPlatformException;
import kntr.base.moss.api.KRestReqContentType;
import kntr.base.moss.api.KRestRespContentType;
import kntr.base.moss.api.KUnhealthyException;
import kntr.base.moss.platform.IPlatformMoss;
import kntr.base.moss.platform.IPlatformResponseHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMoss.android.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\b*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002\u001a\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0000\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0002\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0000\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001fH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006 "}, d2 = {"platformMoss", "Lkntr/base/moss/platform/IPlatformMoss;", "getPlatformMoss", "()Lkntr/base/moss/platform/IPlatformMoss;", "toGMossServiceComponent", "Lcom/bilibili/gripper/api/moss/GMossServiceComponent;", "Lkntr/base/moss/api/KMossServiceComponent;", "toGMethodDescriptor", "Lcom/bilibili/gripper/api/moss/GMethodDescriptor;", "Lkntr/base/moss/api/KMethodDescriptor;", "toGCallOptions", "Lcom/bilibili/gripper/api/moss/GCallOptions;", "Lkntr/base/moss/api/KCallOptions;", "toGMossHttpRule", "Lcom/bilibili/gripper/api/moss/GMossHttpRule;", "Lkntr/base/moss/api/KMossHttpRule;", "toGHttpVerb", "Lcom/bilibili/gripper/api/moss/GHttpVerb;", "Lkntr/base/moss/api/KHttpVerb;", "toGHttpBinding", "Lcom/bilibili/gripper/api/moss/GHttpBinding;", "Lkntr/base/moss/api/KHttpBinding;", "toGRestReqContentType", "Lcom/bilibili/gripper/api/moss/GRestReqContentType;", "Lkntr/base/moss/api/KRestReqContentType;", "toGRestRespContentType", "Lcom/bilibili/gripper/api/moss/GRestRespContentType;", "Lkntr/base/moss/api/KRestRespContentType;", "toKMossException", "Lkntr/base/moss/api/KMossException;", "Lcom/bilibili/gripper/api/moss/GMossException;", "", "moss_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KMoss_androidKt {
    private static final IPlatformMoss platformMoss = new IPlatformMoss() { // from class: kntr.base.moss.epoch.impl.KMoss_androidKt$platformMoss$1
        private final GMossServiceBuilder builder;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), GMossServiceBuilder.class, (String) null, 2, (Object) null);
            Intrinsics.checkNotNull(suspendProducer);
            this.builder = (GMossServiceBuilder) suspendProducer.get();
        }

        public final GMossServiceBuilder getBuilder() {
            return this.builder;
        }

        @Override // kntr.base.moss.platform.IPlatformMoss
        public void asyncUnaryCall(KMossServiceComponent service, KMethodDescriptor<?, ?> kMethodDescriptor, byte[] request, IPlatformResponseHandler handler, KMossHttpRule rule) {
            KMossException kMossException;
            GMossServiceComponent gMossServiceComponent;
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
            Intrinsics.checkNotNullParameter(request, "request");
            try {
                GMossServiceBuilder gMossServiceBuilder = this.builder;
                gMossServiceComponent = KMoss_androidKt.toGMossServiceComponent(service);
                GMossService moss = gMossServiceBuilder.build(gMossServiceComponent);
                RespHandlerAdapter respHandler = new RespHandlerAdapter(handler);
                moss.asyncUnaryCall(KMoss_androidKt.toGMethodDescriptor(kMethodDescriptor), request, respHandler, rule != null ? KMoss_androidKt.toGMossHttpRule(rule) : null);
            } catch (Throwable t) {
                if (handler != null) {
                    kMossException = KMoss_androidKt.toKMossException(t);
                    handler.onError(kMossException);
                }
            }
        }
    };

    /* compiled from: KMoss.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[KHttpVerb.values().length];
            try {
                iArr[KHttpVerb.GET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[KHttpVerb.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[KHttpVerb.POST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[KHttpVerb.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[KHttpVerb.PATCH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[KRestReqContentType.values().length];
            try {
                iArr2[KRestReqContentType.FORM.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[KRestReqContentType.JSON.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[KRestRespContentType.values().length];
            try {
                iArr3[KRestRespContentType.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr3[KRestRespContentType.PROTO.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final IPlatformMoss getPlatformMoss() {
        return platformMoss;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GMossServiceComponent toGMossServiceComponent(KMossServiceComponent $this$toGMossServiceComponent) {
        return new GMossServiceComponent($this$toGMossServiceComponent.getHost(), $this$toGMossServiceComponent.getPort(), toGCallOptions($this$toGMossServiceComponent.getCallOptions()));
    }

    public static final GMethodDescriptor toGMethodDescriptor(KMethodDescriptor<?, ?> kMethodDescriptor) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "<this>");
        return new GMethodDescriptor(kMethodDescriptor.getPackageName(), kMethodDescriptor.getServiceName(), kMethodDescriptor.getMethodName(), kMethodDescriptor.getReqJavaClassName(), kMethodDescriptor.getRespJavaClassName());
    }

    private static final GCallOptions toGCallOptions(KCallOptions $this$toGCallOptions) {
        return new GCallOptions($this$toGCallOptions.getTimeoutInMs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GMossHttpRule toGMossHttpRule(KMossHttpRule $this$toGMossHttpRule) {
        GHttpVerb gHttpVerb = toGHttpVerb($this$toGMossHttpRule.getVerb());
        String pattern = $this$toGMossHttpRule.getPattern();
        Iterable $this$map$iv = $this$toGMossHttpRule.getPathBindings();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KHttpBinding it = (KHttpBinding) item$iv$iv;
            destination$iv$iv.add(toGHttpBinding(it));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        KHttpBinding bodyBinding = $this$toGMossHttpRule.getBodyBinding();
        return new GMossHttpRule(gHttpVerb, pattern, arrayList, bodyBinding != null ? toGHttpBinding(bodyBinding) : null, $this$toGMossHttpRule.isAsteriskBody());
    }

    private static final GHttpVerb toGHttpVerb(KHttpVerb $this$toGHttpVerb) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toGHttpVerb.ordinal()]) {
            case 1:
                return GHttpVerb.GET;
            case 2:
                return GHttpVerb.PUT;
            case 3:
                return GHttpVerb.POST;
            case 4:
                return GHttpVerb.DELETE;
            case 5:
                return GHttpVerb.PATCH;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final GHttpBinding toGHttpBinding(KHttpBinding $this$toGHttpBinding) {
        return new GHttpBinding($this$toGHttpBinding.getField(), $this$toGHttpBinding.getValuePattern());
    }

    public static final GRestReqContentType toGRestReqContentType(KRestReqContentType $this$toGRestReqContentType) {
        Intrinsics.checkNotNullParameter($this$toGRestReqContentType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$toGRestReqContentType.ordinal()]) {
            case 1:
                return GRestReqContentType.FORM;
            case 2:
                return GRestReqContentType.JSON;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final GRestRespContentType toGRestRespContentType(KRestRespContentType $this$toGRestRespContentType) {
        switch (WhenMappings.$EnumSwitchMapping$2[$this$toGRestRespContentType.ordinal()]) {
            case 1:
                return GRestRespContentType.JSON;
            case 2:
                return GRestRespContentType.PROTO;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final KMossException toKMossException(GMossException $this$toKMossException) {
        Intrinsics.checkNotNullParameter($this$toKMossException, "<this>");
        return $this$toKMossException instanceof GNetworkException ? new KNetworkException($this$toKMossException.getMessage(), $this$toKMossException.getCause()) : $this$toKMossException instanceof GBusinessException ? new KBusinessException(((GBusinessException) $this$toKMossException).getCode(), $this$toKMossException.getMessage(), $this$toKMossException.getCause(), ((GBusinessException) $this$toKMossException).getReason()) : $this$toKMossException instanceof GUnhealthyException ? new KUnhealthyException($this$toKMossException.getMessage(), $this$toKMossException.getCause()) : new KPlatformException($this$toKMossException.getMessage(), $this$toKMossException.getCause());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KMossException toKMossException(Throwable $this$toKMossException) {
        return new KPlatformException($this$toKMossException.getMessage(), $this$toKMossException.getCause());
    }
}