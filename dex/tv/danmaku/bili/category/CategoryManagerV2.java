package tv.danmaku.bili.category;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.teenagersmode.TeenagersMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CategoryManagerV2 extends BaseCategoryManager {
    private static final String CATEGORY_JSON_DIR = "data";
    private static final String CATEGORY_JSON_FILE = "region3.json";
    private static final CategoryLoader LOADER = new CategoryLoader(CATEGORY_JSON_DIR, CATEGORY_JSON_FILE);

    public static CategoryMeta getRootCategory(Context context) {
        return LOADER.getRootCategory(context);
    }

    public static void init(final Context context) {
        TeenagersMode.getInstance().registerListener(new TeenagersMode.OnTeenagersModeChangeListener() { // from class: tv.danmaku.bili.category.CategoryManagerV2.1
            public /* synthetic */ void onStateChange(boolean z, boolean z2, boolean z3) {
                TeenagersMode.OnTeenagersModeChangeListener.-CC.$default$onStateChange(this, z, z2, z3);
            }

            public void onStateChange(boolean isEnable, boolean isBizEnable) {
                CategoryManagerV2.LOADER.autoRefresh(context);
            }

            public void onTeenagerModePageShow(boolean isShow) {
            }
        });
    }

    public static CategoryMeta getPrimaryCategoryBy(Context context, int tid) {
        CategoryMeta child = getRootCategory(context).getChild(tid);
        if (child == null) {
            return null;
        }
        return child.clone();
    }

    public static List<CategoryMeta> getPrimaryCategoryByType(Context context, int... types) {
        if (types == null || types.length < 1) {
            return new ArrayList();
        }
        CategoryMeta root = getRootCategory(context).clone();
        List<CategoryMeta> children = root.getChildren();
        List<CategoryMeta> trash = new ArrayList<>();
        for (CategoryMeta meta : children) {
            boolean find = false;
            int length = types.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                int type = types[i];
                if (meta.mType != type) {
                    i++;
                } else {
                    find = true;
                    break;
                }
            }
            if (!find) {
                trash.add(meta);
            }
        }
        children.removeAll(trash);
        return children;
    }

    public static List<CategoryMeta> getCategoryBySenses(Context context, String senses) {
        if (TextUtils.isEmpty(senses)) {
            return new ArrayList();
        }
        CategoryMeta root = getRootCategory(context).clone();
        List<CategoryMeta> children = root.getChildren();
        List<CategoryMeta> trash = new ArrayList<>();
        for (CategoryMeta meta : children) {
            boolean find = false;
            if (meta.mConfig != null) {
                Iterator<CategorySense> it = meta.mConfig.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CategorySense sense = it.next();
                    if (senses.equalsIgnoreCase(sense.mSensesName)) {
                        find = true;
                        break;
                    }
                }
            }
            if (!find) {
                trash.add(meta);
            }
        }
        children.removeAll(trash);
        return children;
    }

    public static int[] getSubCategoryId(int pid) {
        CategoryMeta region;
        List<CategoryMeta> subRegion;
        CategoryMeta root = LOADER.getCachedRootCategory();
        if (root == null || pid == 0 || (region = root.getChild(pid)) == null || (subRegion = region.getChildren()) == null || subRegion.isEmpty()) {
            return null;
        }
        int[] ids = new int[subRegion.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = subRegion.get(i).mTid;
        }
        return ids;
    }
}