package kntr.common.share.common.ui.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.common.share.common.ShareLog;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.ShareChannelList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: ShareLocalResource.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/common/share/common/ui/internal/ShareLocalResource;", "", "<init>", "()V", "metaInfo", "", "", "Lkntr/common/share/common/ui/internal/ChannelMetaInfo;", "getMetaInfo", "()Ljava/util/Map;", "metaInfo$delegate", "Lkotlin/Lazy;", "pictureHost", "getDefaultChannels", "Lkntr/common/share/common/ui/ShareChannelList;", "shareId", "shareOrigin", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareLocalResource {
    public static final int $stable;
    public static final ShareLocalResource INSTANCE = new ShareLocalResource();
    private static final Lazy metaInfo$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.share.common.ui.internal.ShareLocalResource$$ExternalSyntheticLambda0
        public final Object invoke() {
            Map metaInfo_delegate$lambda$0;
            metaInfo_delegate$lambda$0 = ShareLocalResource.metaInfo_delegate$lambda$0();
            return metaInfo_delegate$lambda$0;
        }
    });
    private static final String pictureHost;

    private ShareLocalResource() {
    }

    static {
        String config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "business_share_channel.picture_path", null, 2, null);
        if (config$default == null) {
            config$default = "http://i0.hdslb.com/bfs/share/";
        }
        pictureHost = config$default;
        $stable = 8;
    }

    private final Map<String, ChannelMetaInfo> getMetaInfo() {
        return (Map) metaInfo$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map metaInfo_delegate$lambda$0() {
        String jsonString = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "business_share_channel.meta", null, 2, null);
        if (jsonString == null) {
            jsonString = "{}";
        }
        try {
            Json this_$iv = Json.Default;
            String string$iv = jsonString;
            this_$iv.getSerializersModule();
            return (Map) this_$iv.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, ChannelMetaInfo.Companion.serializer()), string$iv);
        } catch (SerializationException e) {
            ShareLog.Companion.e("ShareLocalResource", "decode meta resource(" + jsonString + ") error ", e);
            return MapsKt.emptyMap();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
        if (r0 == null) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ShareChannelList getDefaultChannels(String shareId, String shareOrigin) {
        ChannelListMeta channelsMeta;
        ChannelListMeta channelsMeta2;
        String configJson;
        ArrayList arrayList;
        String configJson2;
        ShareChannelList.Item item;
        Object m2636constructorimpl;
        Intrinsics.checkNotNullParameter(shareId, "shareId");
        String config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "business_share_channel." + shareId + ":" + (shareOrigin == null ? "" : shareOrigin), null, 2, null);
        if (config$default == null) {
            config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "business_share_channel.default", null, 2, null);
        }
        String configJson3 = config$default;
        if (configJson3 != null) {
            String str = !StringsKt.isBlank(configJson3) ? configJson3 : null;
            if (str != null) {
                String it = str;
                ShareLocalResource shareLocalResource = INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    Json this_$iv = Json.Default;
                    this_$iv.getSerializersModule();
                    m2636constructorimpl = Result.m2636constructorimpl((ChannelListMeta) this_$iv.decodeFromString(ChannelListMeta.Companion.serializer(), it));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                }
                Throwable e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                if (e != null) {
                    ShareLog.Companion.e("ShareLocalResource", "decode channelListMeta(" + it + ") error", e);
                }
                if (Result.m2642isFailureimpl(m2636constructorimpl)) {
                    m2636constructorimpl = null;
                }
                channelsMeta = (ChannelListMeta) m2636constructorimpl;
            }
        }
        channelsMeta = new ChannelListMeta((List) null, (List) null, 3, (DefaultConstructorMarker) null);
        Iterable $this$mapNotNull$iv = CollectionsKt.listOf(new List[]{channelsMeta.getAboveChannels(), channelsMeta.getBelowChannels()});
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Iterable list = (List) element$iv$iv$iv;
            if (list != null) {
                Iterable $this$mapNotNull$iv2 = list;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                    ChannelItemMeta item2 = (ChannelItemMeta) element$iv$iv$iv2;
                    ChannelListMeta channelsMeta3 = channelsMeta;
                    String name = item2.getShareChannel();
                    ChannelMetaInfo meta = INSTANCE.getMetaInfo().get(name);
                    if (meta != null) {
                        configJson2 = configJson3;
                        item = new ShareChannelList.Item(ShareTarget.Companion.fromName(name), meta.getName(), null, pictureHost + meta.getPicture(), null, 20, null);
                    } else {
                        configJson2 = configJson3;
                        item = null;
                    }
                    if (item != null) {
                        destination$iv$iv2.add(item);
                    }
                    channelsMeta = channelsMeta3;
                    configJson3 = configJson2;
                }
                channelsMeta2 = channelsMeta;
                configJson = configJson3;
                arrayList = (List) destination$iv$iv2;
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
            } else {
                channelsMeta2 = channelsMeta;
                configJson = configJson3;
                arrayList = null;
            }
            if (arrayList != null) {
                destination$iv$iv.add(arrayList);
            }
            channelsMeta = channelsMeta2;
            configJson3 = configJson;
        }
        List channels = (List) destination$iv$iv;
        return new ShareChannelList(channels);
    }
}