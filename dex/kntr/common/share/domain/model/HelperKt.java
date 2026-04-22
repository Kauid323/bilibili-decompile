package kntr.common.share.domain.model;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.share.common.ShareMode;
import kntr.common.share.common.ShareParams;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: Helper.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0004H\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0005H\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0006H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a*\u0010\b\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\r\u001a\u00020\u0002*\u0004\u0018\u00010\u000eH\u0000\u001a\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"asMap", "", "", "Lkntr/common/share/common/ShareParams;", "Lkntr/common/share/domain/model/ShareSession;", "Lkntr/common/share/domain/model/ShareClickParams;", "Lkntr/common/share/domain/model/ShareFinishParams;", "toJsonSafely", "putIfNotBlank", "", "", "key", "value", "toValue", "Lkntr/common/share/common/ShareMode;", "toShareMode", "", "(Ljava/lang/Integer;)Lkntr/common/share/common/ShareMode;", "domain_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class HelperKt {

    /* compiled from: Helper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShareMode.values().length];
            try {
                iArr[ShareMode.Text.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ShareMode.Image.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ShareMode.Link.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ShareMode.Audio.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ShareMode.Video.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ShareMode.WeChatMiniProgram.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ShareMode.QQMiniProgram.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ShareMode.PureImage.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ShareMode.Placard.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Map<String, String> asMap(ShareParams $this$asMap) {
        String it;
        Intrinsics.checkNotNullParameter($this$asMap, "<this>");
        Map $this$asMap_u24lambda_u240 = MapsKt.createMapBuilder();
        putIfNotBlank($this$asMap_u24lambda_u240, "share_id", $this$asMap.getShareId());
        putIfNotBlank($this$asMap_u24lambda_u240, "oid", $this$asMap.getOid());
        putIfNotBlank($this$asMap_u24lambda_u240, "share_origin", $this$asMap.getShareOrigin());
        putIfNotBlank($this$asMap_u24lambda_u240, "sid", $this$asMap.getSid());
        putIfNotBlank($this$asMap_u24lambda_u240, "spm_id", $this$asMap.getPageInfo().getSpmid());
        String from = $this$asMap.getPageInfo().getFrom();
        if (from == null) {
            from = "";
        }
        putIfNotBlank($this$asMap_u24lambda_u240, "from", from);
        String fromSpmid = $this$asMap.getPageInfo().getFromSpmid();
        if (fromSpmid == null) {
            fromSpmid = "";
        }
        putIfNotBlank($this$asMap_u24lambda_u240, "from_spmid", fromSpmid);
        String tag = $this$asMap.getPageInfo().getTag();
        putIfNotBlank($this$asMap_u24lambda_u240, "tag", tag != null ? tag : "");
        Map<String, String> extraFields = $this$asMap.getPageInfo().getExtraFields();
        if (extraFields != null && (it = toJsonSafely(extraFields)) != null) {
            if (!(it.length() > 0)) {
                it = null;
            }
            if (it != null) {
                $this$asMap_u24lambda_u240.put("object_extra_fields", it);
            }
        }
        return MapsKt.build($this$asMap_u24lambda_u240);
    }

    public static final Map<String, String> asMap(ShareSession $this$asMap) {
        Intrinsics.checkNotNullParameter($this$asMap, "<this>");
        Map $this$asMap_u24lambda_u241 = MapsKt.createMapBuilder();
        $this$asMap_u24lambda_u241.putAll(asMap($this$asMap.getParams()));
        putIfNotBlank($this$asMap_u24lambda_u241, "share_session_id", $this$asMap.getIdentifier());
        putIfNotBlank($this$asMap_u24lambda_u241, "action_id", $this$asMap.getActionId());
        putIfNotBlank($this$asMap_u24lambda_u241, "panel_type", $this$asMap.getPageType());
        return MapsKt.build($this$asMap_u24lambda_u241);
    }

    public static final Map<String, String> asMap(ShareClickParams $this$asMap) {
        Intrinsics.checkNotNullParameter($this$asMap, "<this>");
        Map $this$asMap_u24lambda_u242 = MapsKt.createMapBuilder();
        putIfNotBlank($this$asMap_u24lambda_u242, "share_mode", toValue($this$asMap.getMode()));
        putIfNotBlank($this$asMap_u24lambda_u242, "share_channel", $this$asMap.getTarget().getName());
        putIfNotBlank($this$asMap_u24lambda_u242, "tid", $this$asMap.getTid());
        putIfNotBlank($this$asMap_u24lambda_u242, "share_title", $this$asMap.getTitle());
        putIfNotBlank($this$asMap_u24lambda_u242, "share_content", $this$asMap.getContent());
        String pattern = $this$asMap.getPattern();
        if (pattern == null) {
            pattern = ($this$asMap.getMode() == ShareMode.Image || $this$asMap.getMode() == ShareMode.Placard) ? "1" : "0";
        }
        putIfNotBlank($this$asMap_u24lambda_u242, "share_pattern", pattern);
        return MapsKt.build($this$asMap_u24lambda_u242);
    }

    public static final Map<String, String> asMap(ShareFinishParams $this$asMap) {
        Intrinsics.checkNotNullParameter($this$asMap, "<this>");
        Map $this$asMap_u24lambda_u243 = MapsKt.createMapBuilder();
        $this$asMap_u24lambda_u243.put("success", "true");
        putIfNotBlank($this$asMap_u24lambda_u243, "share_channel", $this$asMap.getTarget().getName());
        putIfNotBlank($this$asMap_u24lambda_u243, "link", $this$asMap.getLink());
        return MapsKt.build($this$asMap_u24lambda_u243);
    }

    public static final String toJsonSafely(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        try {
            StringFormat $this$encodeToString$iv = Json.Default;
            $this$encodeToString$iv.getSerializersModule();
            return $this$encodeToString$iv.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), map);
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("Share", "failed to encode map " + map, e);
            return "";
        }
    }

    public static final void putIfNotBlank(Map<String, String> map, String key, String value) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String str = value;
        if (!(str == null || StringsKt.isBlank(str))) {
            map.put(key, value);
        }
    }

    public static final String toValue(ShareMode $this$toValue) {
        switch ($this$toValue == null ? -1 : WhenMappings.$EnumSwitchMapping$0[$this$toValue.ordinal()]) {
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
            default:
                return WatchLaterReporterKt.CLEAN_INVALID;
            case 4:
                return "5";
            case 5:
                return "4";
            case 6:
                return "6";
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                return "7";
            case 8:
                return "21";
            case ConstantsKt.SPACER_9 /* 9 */:
                return "10";
        }
    }

    public static final ShareMode toShareMode(Integer $this$toShareMode) {
        if ($this$toShareMode != null && $this$toShareMode.intValue() == 1) {
            return ShareMode.Text;
        }
        if ($this$toShareMode != null && $this$toShareMode.intValue() == 2) {
            return ShareMode.Image;
        }
        if ($this$toShareMode != null && $this$toShareMode.intValue() == 3) {
            return ShareMode.Link;
        }
        if ($this$toShareMode != null && $this$toShareMode.intValue() == 5) {
            return ShareMode.Audio;
        }
        if ($this$toShareMode != null && $this$toShareMode.intValue() == 4) {
            return ShareMode.Video;
        }
        if ($this$toShareMode != null && $this$toShareMode.intValue() == 6) {
            return ShareMode.WeChatMiniProgram;
        }
        if ($this$toShareMode != null && $this$toShareMode.intValue() == 7) {
            return ShareMode.QQMiniProgram;
        }
        if ($this$toShareMode != null && $this$toShareMode.intValue() == 21) {
            return ShareMode.PureImage;
        }
        if ($this$toShareMode != null && $this$toShareMode.intValue() == 10) {
            return ShareMode.Placard;
        }
        return null;
    }
}