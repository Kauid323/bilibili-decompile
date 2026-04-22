package tv.danmaku.bili.quick.core;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LoginSceneProcessor.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0007J\u0006\u0010\u001c\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/quick/core/LoginSceneProcessor;", "", "<init>", "()V", "SCENE_KEY", "", "SceneComment", "SceneDanmaku", "SceneMain", "SceneMainNew", "mScene", "getMScene", "()Ljava/lang/String;", "setMScene", "(Ljava/lang/String;)V", "setScene", "", "scene", "answerGuideEnable", "", "sceneAnswerGuideEnable", "mBiz", "BIZ_KEY", "BIZ_FISSION", "setBiz", "biz", "bizGuideEnable", "followingGuideEnable", "answerGuideEnableUnLimit", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginSceneProcessor {
    private static final String BIZ_FISSION = "fission";
    public static final String BIZ_KEY = "business";
    public static final String SCENE_KEY = "scene";
    private static final String SceneComment = "comment";
    private static final String SceneDanmaku = "danmaku";
    private static final String SceneMain = "main";
    private static final String SceneMainNew = "main_new";
    private static String mBiz;
    private static String mScene;
    public static final LoginSceneProcessor INSTANCE = new LoginSceneProcessor();
    public static final int $stable = 8;

    private LoginSceneProcessor() {
    }

    public final String getMScene() {
        return mScene;
    }

    public final void setMScene(String str) {
        mScene = str;
    }

    public final void setScene(String scene) {
        mScene = scene;
    }

    public final boolean answerGuideEnable() {
        return sceneAnswerGuideEnable() && bizGuideEnable();
    }

    private final boolean sceneAnswerGuideEnable() {
        String str = mScene;
        if (str != null) {
            switch (str.hashCode()) {
                case -8103398:
                    if (!str.equals(SceneMainNew)) {
                    }
                    return false;
                case 3343801:
                    if (!str.equals("main")) {
                    }
                    return false;
                case 950398559:
                    return str.equals(SceneComment);
                case 1438013711:
                    return str.equals(SceneDanmaku);
                default:
                    return false;
            }
        }
        return false;
    }

    public final void setBiz(String biz) {
        mBiz = biz;
    }

    private final boolean bizGuideEnable() {
        return !Intrinsics.areEqual(mBiz, BIZ_FISSION);
    }

    @JvmStatic
    public static final boolean followingGuideEnable() {
        return INSTANCE.bizGuideEnable();
    }

    public final boolean answerGuideEnableUnLimit() {
        return (Intrinsics.areEqual(BIZ_FISSION, mBiz) || Intrinsics.areEqual("main", mScene) || Intrinsics.areEqual(SceneMainNew, mScene)) ? false : true;
    }
}