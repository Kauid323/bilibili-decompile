package tv.danmaku.biliplayerv2.widget.toast;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class PlayerToastConfig {
    public static final long DURATION_1 = 1000;
    public static final long DURATION_10 = 10000;
    public static final long DURATION_2 = 2000;
    public static final long DURATION_3 = 3000;
    public static final long DURATION_4 = 4000;
    public static final long DURATION_5 = 5000;
    public static final long DURATION_6 = 6000;
    public static final long DURATION_7 = 7000;
    public static final long DURATION_8 = 8000;
    public static final long DURATION_9 = 9000;
    public static final long DURATION_FOREVER = 100000;
    public static final long DURATION_NONE = -1;
    public static final String EXTRA_ACTION_NEED_ANIM = "extra_need_anim";
    public static final String EXTRA_ACTION_NEED_CLOSE = "extra_need_close";
    public static final String EXTRA_ACTION_TEXT = "extra_action_text";
    public static final String EXTRA_ACTION_TEXT_COLOR_INT = "extra_action_text_color_int";
    public static final String EXTRA_ACTION_TEXT_COLOR_RES_ID = "extra_action_text_color_res_id";
    public static final String EXTRA_BG_COLOR_INT = "extra_bg_color_int";
    public static final String EXTRA_BG_DRAWABLE_RES_ID = "extra_background_drawable_res_id";
    public static final String EXTRA_BG_FINAL_COLOR_INT = "extra_bg_final_color_int";
    public static final String EXTRA_BG_FINAL_DRAWABLE_RES_ID = "extra_background_final_drawable_res_id";
    public static final String EXTRA_BG_FINAL_GRADIENT_COLOR_ARRAY = "extra_bg_final_gradient_color_array";
    public static final String EXTRA_FINAL_ACTION_TEXT = "extra_final_action_text";
    public static final String EXTRA_FINAL_ACTION_TEXT_COLOR_INT = "extra_final_action_text_color_int";
    public static final String EXTRA_FINAL_ACTION_TEXT_COLOR_RES_ID = "extra_final_action_text_color_res_id";
    public static final String EXTRA_FRONT_DRAWABLE_RES_ID = "extra_front_drawable_res_id";
    public static final String EXTRA_FRONT_DRAWABLE_URL = "extra_front_drawable_url";
    public static final String EXTRA_SUB_TITLE = "extra_sub_title";
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_TITLE_BOLD = "extra_title_bold";
    public static final String EXTRA_TITLE_SIZE = "extra_title_size";
    public static final int LEVEL_FOURTH = 4;
    public static final int LEVEL_HIGHEST = 5;
    public static final int LEVEL_LOWEST = 1;
    public static final int LEVEL_SECOND = 2;
    public static final int LEVEL_THIRD = 3;
    public static final int LOCAT_CENTER = 33;
    public static final int LOCAT_LEFT_SIDE = 32;
    public static final int LOCAT_TOP_CENTER = 34;
    public static final int QUEUE_INSERT = 48;
    public static final int QUEUE_REFRESH = 49;
    public static final int TYPE_ACTION = 18;
    public static final int TYPE_ACTION_ANIMATION = 21;
    public static final int TYPE_CUSTOM = 19;
    static final int TYPE_END = 22;
    public static final int TYPE_NORMAL = 17;
    static final int TYPE_START = 16;
    public static final int TYPE_SYSTEM = 20;

    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public @interface Level {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public @interface Location {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public @interface QueueType {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public @interface ToastDuration {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public @interface ToastItemType {
    }

    public static String getTitle(PlayerToast toast) {
        return toast.getExtraString(EXTRA_TITLE);
    }

    public static String getActionText(PlayerToast toast) {
        return toast.getExtraString(EXTRA_ACTION_TEXT);
    }

    public static boolean getTitleBold(PlayerToast toast, boolean defaultValue) {
        return toast.getExtraBooleanValue(EXTRA_TITLE_BOLD, defaultValue);
    }
}