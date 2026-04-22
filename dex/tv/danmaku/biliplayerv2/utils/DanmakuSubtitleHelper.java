package tv.danmaku.biliplayerv2.utils;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.bapis.bilibili.community.service.dm.v1.SubtitleItem;
import com.bapis.bilibili.community.service.dm.v1.SubtitleType;
import com.bapis.bilibili.community.service.dm.v1.VideoSubtitle;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuSubtitleHelper.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010J\u0016\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010J$\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0002J$\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0002J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002¨\u0006\u001b"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/DanmakuSubtitleHelper;", "", "<init>", "()V", "containsSubtitle", "Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;", "params", "Lcom/bapis/bilibili/community/service/dm/v1/VideoSubtitle;", "item", "choseLocalSubtitleLan", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "selectByAiStatus", "context", "Landroid/content/Context;", "filterAssistAISubtitle", "", "originList", "needCheckBilingualSubtitle", "", "isAssistAISubtitleVideo", "choseAdaptiveLanguage", "subtitleList", "choseSubtitleByLanguage", "lan", "", "findSubtitleByLan", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuSubtitleHelper {
    public static final DanmakuSubtitleHelper INSTANCE = new DanmakuSubtitleHelper();

    private DanmakuSubtitleHelper() {
    }

    public final SubtitleItem containsSubtitle(VideoSubtitle params, SubtitleItem item) {
        List subtitlesList;
        Object obj = null;
        if (params == null || item == null || (subtitlesList = params.getSubtitlesList()) == null) {
            return null;
        }
        ListIterator listIterator = subtitlesList.listIterator(subtitlesList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            SubtitleItem it = (SubtitleItem) previous;
            if (Intrinsics.areEqual(it.getLan(), item.getLan())) {
                obj = previous;
                break;
            }
        }
        return (SubtitleItem) obj;
    }

    public final SubtitleItem choseLocalSubtitleLan(PlayerContainer playerContainer, VideoSubtitle params) {
        String keySubtitleLanMain;
        if (playerContainer == null || params == null) {
            return null;
        }
        boolean bilingualSwitch = playerContainer.getPlayerSettingService().getBoolean(DanmakuKeys.KEY_DANMAKU_SUBTITLE_MULTI, false);
        boolean hasMatchList = needCheckBilingualSubtitle(params.getSubtitlesList());
        if (bilingualSwitch && hasMatchList) {
            String keySubtitleLanMain2 = playerContainer.getInteractLayerService().getSubtitleKeyConfig().getKeySubtitleLanMain();
            keySubtitleLanMain = playerContainer.getPlayerSettingService().getString(keySubtitleLanMain2, DanmakuConfig.DANMAKU_SUBTITLE_LAN_MAIN_DEFAULT);
        } else {
            keySubtitleLanMain = "";
        }
        if (TextUtils.isEmpty(keySubtitleLanMain)) {
            return selectByAiStatus(playerContainer.getContext(), params);
        }
        if (Intrinsics.areEqual(keySubtitleLanMain, DanmakuConfig.DANMAKU_SUBTITLE_LAN_MAIN_DEFAULT)) {
            List subtitlesList = params.getSubtitlesList();
            Intrinsics.checkNotNullExpressionValue(subtitlesList, "getSubtitlesList(...)");
            return (SubtitleItem) CollectionsKt.firstOrNull(subtitlesList);
        } else if (Intrinsics.areEqual(keySubtitleLanMain, DanmakuConfig.DANMAKU_SUBTITLE_LAN_NODISPLAY)) {
            return null;
        } else {
            List<SubtitleItem> subtitlesList2 = params.getSubtitlesList();
            Intrinsics.checkNotNullExpressionValue(subtitlesList2, "getSubtitlesList(...)");
            SubtitleItem findSubtitleByLan = findSubtitleByLan(subtitlesList2, keySubtitleLanMain);
            if (findSubtitleByLan != null) {
                return findSubtitleByLan;
            }
            return selectByAiStatus(playerContainer.getContext(), params);
        }
    }

    private final SubtitleItem selectByAiStatus(Context context, VideoSubtitle params) {
        return choseAdaptiveLanguage(context, params != null ? params.getSubtitlesList() : null);
    }

    private final List<SubtitleItem> filterAssistAISubtitle(List<SubtitleItem> list) {
        List emptyList;
        Iterable originList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        if (originList == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            Iterable $this$filter$iv = originList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                SubtitleItem it = (SubtitleItem) element$iv$iv;
                boolean z = true;
                if (it.getType() != SubtitleType.CC && it.getAiStatusValue() != 1) {
                    z = false;
                }
                if (z) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            emptyList = (List) destination$iv$iv;
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(emptyList);
    }

    public final boolean needCheckBilingualSubtitle(List<SubtitleItem> list) {
        List originList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        return filterAssistAISubtitle(originList).size() > 1;
    }

    public final boolean isAssistAISubtitleVideo(List<SubtitleItem> list) {
        List originList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        return filterAssistAISubtitle(originList).isEmpty();
    }

    private final SubtitleItem choseAdaptiveLanguage(Context context, List<SubtitleItem> list) {
        Locale locale;
        List subtitleList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List list2 = subtitleList;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        if (context == null) {
            return (SubtitleItem) CollectionsKt.firstOrNull(subtitleList);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
            Intrinsics.checkNotNull(locale);
        } else {
            locale = Locale.getDefault();
            Intrinsics.checkNotNull(locale);
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String systemLan = language + (TextUtils.isEmpty(country) ? "" : "-" + country);
        List matchList = filterAssistAISubtitle(subtitleList);
        SubtitleItem choseSubtitleByLanguage = choseSubtitleByLanguage(systemLan, subtitleList);
        if (choseSubtitleByLanguage == null) {
            SubtitleItem subtitleItem = (SubtitleItem) CollectionsKt.firstOrNull(matchList);
            return subtitleItem == null ? (SubtitleItem) CollectionsKt.firstOrNull(subtitleList) : subtitleItem;
        }
        return choseSubtitleByLanguage;
    }

    private final SubtitleItem choseSubtitleByLanguage(String lan, List<SubtitleItem> list) {
        List subtitleList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List list2 = subtitleList;
        if ((list2 == null || list2.isEmpty()) || Intrinsics.areEqual(DanmakuConfig.DANMAKU_SUBTITLE_LAN_NODISPLAY, lan) || TextUtils.isEmpty(lan)) {
            return null;
        }
        SubtitleItem target = null;
        SubtitleItem like = null;
        SubtitleItem likelike = null;
        Intrinsics.checkNotNull(lan);
        Collection $this$toTypedArray$iv = StringsKt.split$default(lan, new String[]{"-"}, false, 0, 6, (Object) null);
        String onlyLan = ((String[]) $this$toTypedArray$iv.toArray(new String[0]))[0];
        Iterator it = subtitleList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubtitleItem language = (SubtitleItem) it.next();
            if (Intrinsics.areEqual(lan, language.getLan())) {
                target = language;
                break;
            }
            if (like == null && !TextUtils.isEmpty(language.getLan())) {
                String lan2 = language.getLan();
                Intrinsics.checkNotNullExpressionValue(lan2, "getLan(...)");
                if (StringsKt.contains$default(lan, lan2, false, 2, (Object) null)) {
                    like = language;
                }
            }
            if (likelike == null && !TextUtils.isEmpty(language.getLan())) {
                String lan3 = language.getLan();
                Intrinsics.checkNotNullExpressionValue(lan3, "getLan(...)");
                if (StringsKt.contains$default(lan3, onlyLan, false, 2, (Object) null)) {
                    likelike = language;
                }
            }
        }
        return target == null ? like == null ? likelike : like : target;
    }

    public final SubtitleItem choseSubtitleByLanguage(String lan, VideoSubtitle params) {
        if (params == null || params.getSubtitlesList() == null || params.getSubtitlesList().isEmpty() || Intrinsics.areEqual(DanmakuConfig.DANMAKU_SUBTITLE_LAN_NODISPLAY, lan) || TextUtils.isEmpty(lan)) {
            return null;
        }
        SubtitleItem target = null;
        SubtitleItem like = null;
        SubtitleItem likelike = null;
        Intrinsics.checkNotNull(lan);
        Collection $this$toTypedArray$iv = StringsKt.split$default(lan, new String[]{"-"}, false, 0, 6, (Object) null);
        String onlyLan = ((String[]) $this$toTypedArray$iv.toArray(new String[0]))[0];
        Iterator it = params.getSubtitlesList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubtitleItem language = (SubtitleItem) it.next();
            if (language != null) {
                if (Intrinsics.areEqual(lan, language.getLan())) {
                    target = language;
                    break;
                }
                if (like == null && !TextUtils.isEmpty(language.getLan())) {
                    String lan2 = language.getLan();
                    Intrinsics.checkNotNullExpressionValue(lan2, "getLan(...)");
                    if (StringsKt.contains$default(lan, lan2, false, 2, (Object) null)) {
                        like = language;
                    }
                }
                if (likelike == null && !TextUtils.isEmpty(language.getLan())) {
                    String lan3 = language.getLan();
                    Intrinsics.checkNotNullExpressionValue(lan3, "getLan(...)");
                    if (StringsKt.contains$default(lan3, onlyLan, false, 2, (Object) null)) {
                        likelike = language;
                    }
                }
            }
        }
        return target == null ? like == null ? likelike : like : target;
    }

    private final SubtitleItem findSubtitleByLan(List<SubtitleItem> list, String lan) {
        Iterable $this$findSubtitleByLan = EnhancedUnmodifiabilityKt.unmodifiable(list);
        if (TextUtils.isEmpty(lan)) {
            return null;
        }
        Iterable $this$forEach$iv = $this$findSubtitleByLan;
        for (Object element$iv : $this$forEach$iv) {
            SubtitleItem it = (SubtitleItem) element$iv;
            if (Intrinsics.areEqual(it.getLan(), lan)) {
                return it;
            }
        }
        return null;
    }
}