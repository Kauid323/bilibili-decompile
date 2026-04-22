package tv.danmaku.bili.category;

import android.content.Context;
import java.util.List;

@Deprecated
public final class CategoryManager extends BaseCategoryManager {
    public static CategoryMeta getPrimaryCategoryBy(Context context, int tid) {
        return CategoryManagerV2.getPrimaryCategoryBy(context, tid);
    }

    public static List<CategoryMeta> getRealPrimaryCategories(Context context) {
        CategoryMeta root = getRootCategory(context).clone();
        root.remove(BaseCategoryManager.T1_LIVE, BaseCategoryManager.T1_PROMO, BaseCategoryManager.T1_GAME_CENTER, 165, BaseCategoryManager.T1_CLIP_VIDEO, BaseCategoryManager.T1_COLUMN, BaseCategoryManager.T1_AUDIO, BaseCategoryManager.T1_ALBUM, BaseCategoryManager.T1_CINEMA, BaseCategoryManager.T1_MALL);
        return root.getChildren();
    }

    public static int[] getSubCategoryId(int pid) {
        return CategoryManagerV2.getSubCategoryId(pid);
    }

    public static CategoryMeta getRootCategory(Context context) {
        return CategoryManagerV2.getRootCategory(context);
    }
}