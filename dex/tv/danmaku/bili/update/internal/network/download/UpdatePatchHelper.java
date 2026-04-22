package tv.danmaku.bili.update.internal.network.download;

import android.content.Context;
import com.bilibili.lib.bilipatch.BiliPatch;
import com.bilibili.lib.bilipatch.PatchEventListener;
import com.bilibili.lib.bilipatch.PatchInfo;
import com.bilibili.lib.bilipatch.PatchItem;
import com.bilibili.lib.bilipatch.PatchResult;
import com.bilibili.lib.bilipatch.UrlTransformer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.update.internal.persist.files.UpdateApk;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.model.Patch;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UpdatePatchHelper.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0007J\b\u0010\u001b\u001a\u00020\u0005H\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ltv/danmaku/bili/update/internal/network/download/UpdatePatchHelper;", "", "<init>", "()V", "TAG", "", "strategy", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "downloadAndPatch", "Lcom/bilibili/lib/bilipatch/PatchResult;", "context", "Landroid/content/Context;", "oldFilePath", "patchInfo", "Lcom/bilibili/lib/bilipatch/PatchInfo;", "newFilePath", "newFileMd5", "eventListener", "Lcom/bilibili/lib/bilipatch/PatchEventListener;", "urlTransformer", "Lcom/bilibili/lib/bilipatch/UrlTransformer;", "getPatchInfo", "Ltv/danmaku/bili/update/model/Patch;", "upgradeInfo", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "patchType", "getPreferPatchSuffix", "patchNewVersion", "", "getPreferPatch", "getPatchItems", "", "Lcom/bilibili/lib/bilipatch/PatchItem;", "getDefaultPatch", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UpdatePatchHelper {
    private static final String TAG = "fawkes.update.UpdatePatchHelper";
    public static final UpdatePatchHelper INSTANCE = new UpdatePatchHelper();
    private static final ArrayList<String> strategy = CollectionsKt.arrayListOf(new String[]{".sdiff", ".patch"});

    private UpdatePatchHelper() {
    }

    @JvmStatic
    public static final PatchResult downloadAndPatch(Context context, String oldFilePath, PatchInfo patchInfo, String newFilePath, String newFileMd5, PatchEventListener eventListener, UrlTransformer urlTransformer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oldFilePath, "oldFilePath");
        Intrinsics.checkNotNullParameter(patchInfo, "patchInfo");
        Intrinsics.checkNotNullParameter(newFilePath, "newFilePath");
        Intrinsics.checkNotNullParameter(newFileMd5, "newFileMd5");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(urlTransformer, "urlTransformer");
        BiliPatch patcher = new BiliPatch(context, eventListener, strategy);
        patcher.setUrlTransformer(urlTransformer);
        return BiliPatch.patch$default(patcher, oldFilePath, patchInfo, newFilePath, newFileMd5, (List) null, 16, (Object) null);
    }

    @JvmStatic
    public static final Patch getPatchInfo(BiliUpgradeInfo upgradeInfo, String patchType) {
        Intrinsics.checkNotNullParameter(upgradeInfo, "upgradeInfo");
        Intrinsics.checkNotNullParameter(patchType, "patchType");
        Map map = upgradeInfo.getPatch_map();
        return map.get(patchType);
    }

    @JvmStatic
    public static final String getPreferPatchSuffix() {
        String str = strategy.get(0);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        return str;
    }

    @JvmStatic
    public static final boolean patchNewVersion() {
        Boolean abtest = RuntimeHelper.abtest("ff_app_upgrade_patch_apkdiff");
        if (abtest != null) {
            return abtest.booleanValue();
        }
        return true;
    }

    @JvmStatic
    public static final Patch getPreferPatch(BiliUpgradeInfo upgradeInfo) {
        Intrinsics.checkNotNullParameter(upgradeInfo, "upgradeInfo");
        if (patchNewVersion()) {
            String str = strategy.get(0);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            String type = StringsKt.removePrefix(str, ".");
            Patch patch = getPatchInfo(upgradeInfo, type);
            if (patch != null) {
                return patch;
            }
            return INSTANCE.getDefaultPatch(upgradeInfo);
        }
        return upgradeInfo.getPatch();
    }

    @JvmStatic
    public static final List<PatchItem> getPatchItems(Context context, BiliUpgradeInfo upgradeInfo) {
        String name;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(upgradeInfo, "upgradeInfo");
        ArrayList result = new ArrayList();
        Map $this$forEach$iv = upgradeInfo.getPatch_map();
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            String key = element$iv.getKey();
            String url = element$iv.getValue().getUrl();
            String str = "";
            if (url == null) {
                url = "";
            }
            File patchItemPath = UpdateApk.getPatchItemPath(context, upgradeInfo, element$iv.getValue(), element$iv.getKey());
            if (patchItemPath != null && (name = patchItemPath.getName()) != null) {
                str = name;
            }
            result.add(new PatchItem(key, url, str, element$iv.getValue().getMd5()));
        }
        return result;
    }

    private final Patch getDefaultPatch(BiliUpgradeInfo upgradeInfo) {
        Map map = upgradeInfo.getPatch_map();
        if (!map.isEmpty()) {
            return map.get(CollectionsKt.first(map.keySet()));
        }
        return null;
    }
}