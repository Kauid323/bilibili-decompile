package video.biz.offline.base.infra.utils;

import com.bilibili.commons.io.FileUtils;
import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.model.DeprecatedDramaModel;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;

/* compiled from: DramaHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"DRAMA_DIR", "", "loadAllDrama", "Ljava/util/HashMap;", "", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "Lkotlin/collections/HashMap;", "parseDramaGroupFromFile", "file", "Ljava/io/File;", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DramaHelperKt {
    public static final String DRAMA_DIR = "drama";

    public static final HashMap<Long, DramaGroupModel> loadAllDrama() {
        File root = new File(FoundationAlias.getFapp().getFilesDir(), DRAMA_DIR);
        HashMap map = new HashMap();
        if (!root.exists()) {
            root.mkdirs();
            return map;
        }
        File[] files = root.listFiles();
        boolean z = true;
        if (files != null) {
            if (!(files.length == 0)) {
                z = false;
            }
        }
        if (z) {
            new DataLog().info("loadAllDrama files is empty, path: " + root.getAbsolutePath());
            return map;
        }
        Iterable $this$forEach$iv = ArraysKt.filterNotNull(files);
        for (Object element$iv : $this$forEach$iv) {
            File file = (File) element$iv;
            DramaGroupModel drama = parseDramaGroupFromFile(file);
            if (drama != null) {
                map.put(Long.valueOf(drama.getId()), drama);
            }
        }
        return map;
    }

    public static final DramaGroupModel parseDramaGroupFromFile(File file) {
        String json;
        DeprecatedDramaModel deprecatedDramaModel;
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            json = FileUtils.readFileToString(file, "UTF-8");
        } catch (Exception e) {
            new DataLog().error("parseDramaGroupFromFile read failed, path: " + file.getAbsolutePath() + ", error: " + e);
            json = null;
        }
        String str = json;
        if (str == null || str.length() == 0) {
            new DataLog().info("parseDramaGroupFromFile json is null, path: " + file.getAbsolutePath());
            return null;
        }
        try {
            Json this_$iv = EntryScannerKt.getOfflineJson();
            String string$iv = json;
            this_$iv.getSerializersModule();
            deprecatedDramaModel = (DeprecatedDramaModel) this_$iv.decodeFromString(DeprecatedDramaModel.Companion.serializer(), string$iv);
        } catch (Exception e2) {
            new DataLog().error("parseDramaGroupFromFile failed to decode, path: " + file.getAbsolutePath() + ", " + e2);
            deprecatedDramaModel = null;
        }
        DeprecatedDramaModel dramaGroup = deprecatedDramaModel;
        if (dramaGroup != null) {
            return dramaGroup.transform();
        }
        return null;
    }
}