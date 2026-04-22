package tv.danmaku.bili.ui.comment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.comment2.CommentContext;
import com.bilibili.app.comm.comment2.comments.view.input.CommentInputBarManager;
import com.bilibili.app.comm.comment2.comments.view.input.InputBarParam;
import com.bilibili.app.comm.comment2.input.CommentSendController;
import com.bilibili.app.comm.comment2.input.following.ButtonEnable;
import com.bilibili.app.comm.comment2.input.following.InputBackground;
import com.bilibili.app.comm.comment2.input.following.InputBarVisibleRectChangeListener;
import com.bilibili.app.comm.comment2.input.following.InputOnSendListener;
import com.bilibili.app.comm.comment2.input.following.InputSupplementaryButtonEnable;
import com.bilibili.app.comm.comment2.input.following.InputSupplementaryConfig;
import com.bilibili.app.comm.comment2.input.view.AttachedCommentInfo;
import com.bilibili.app.comm.comment2.model.BiliComment;
import com.bilibili.app.comm.comment2.model.BiliCommentAddResult;
import com.bilibili.app.comm.comment2.model.BiliCommentControl;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.moduleservice.main.CommentInputCallback;
import com.bilibili.moduleservice.main.CommentService;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.ui.IntentHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: CommentServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J>\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J>\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&H\u0002Jb\u0010'\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u00132\b\u0010+\u001a\u0004\u0018\u00010\u00132\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\f\u0010.\u001a\u00020/*\u00020-H\u0002J\u0012\u00100\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Ltv/danmaku/bili/ui/comment/CommentServiceImpl;", "Lcom/bilibili/moduleservice/main/CommentService;", "<init>", "()V", "mInputManagerPair", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/comment/CommentServiceImpl$InputBarTag;", "Lcom/bilibili/app/comm/comment2/comments/view/input/CommentInputBarManager;", "callbackActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "commentIntentInterceptor", "context", "Landroid/content/Context;", "link", "", "scene", "initPair", "oid", "", "type", "upperId", "followingType", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "checkLogin", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "getPair", "buildSendCallback", "Lcom/bilibili/app/comm/comment2/input/CommentSendController$Callback;", "manager", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/moduleservice/main/CommentInputCallback;", "openCommentInputBar", "info", "Lcom/bilibili/moduleservice/main/CommentService$ReplyCommentInfo;", "placeHolder", "order", "config", "Lcom/bilibili/moduleservice/main/CommentService$IInputSupplementaryConfig;", "toInputSupplementaryConfig", "Lcom/bilibili/app/comm/comment2/input/following/InputSupplementaryConfig;", BuildConfig.BUILD_TYPE, "InputBarTag", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CommentServiceImpl implements CommentService {
    public static final int $stable = 8;
    private Pair<InputBarTag, CommentInputBarManager> mInputManagerPair;

    public void callbackActivityResult(int requestCode, int resultCode, Intent data) {
        CommentInputBarManager commentInputBarManager;
        Pair<InputBarTag, CommentInputBarManager> pair = this.mInputManagerPair;
        if (pair == null || (commentInputBarManager = (CommentInputBarManager) pair.getSecond()) == null) {
            return;
        }
        commentInputBarManager.onActivityResult(requestCode, resultCode, data);
    }

    public void commentIntentInterceptor(Context context, String link, String scene) {
        String linkLocal = link;
        if (TextUtils.isEmpty(linkLocal) || context == null) {
            return;
        }
        if (TextUtils.equals(scene, "scene_notice")) {
            linkLocal = AudioIntentHelper.appendFromIfCan(link, AudioIntentHelper.FROM_ACTIVITY);
        }
        IntentHelper.intentTo(context, Uri.parse(linkLocal));
    }

    private final Pair<InputBarTag, CommentInputBarManager> initPair(long oid, int type, long upperId, int followingType, FragmentActivity fragmentActivity) {
        CommentContext $this$initPair_u24lambda_u240 = new CommentContext(oid, type);
        $this$initPair_u24lambda_u240.setScene(MainRouteUris.MODULE_MAIN);
        $this$initPair_u24lambda_u240.setOrder($this$initPair_u24lambda_u240.getOrder());
        $this$initPair_u24lambda_u240.setUpperId(upperId);
        $this$initPair_u24lambda_u240.setFollowingType(followingType);
        Pair pair = new Pair(new InputBarTag(oid, type, fragmentActivity.hashCode()), new CommentInputBarManager((Context) fragmentActivity, $this$initPair_u24lambda_u240, new InputBarParam(true, false, false), new CommentSendController(fragmentActivity, $this$initPair_u24lambda_u240)));
        this.mInputManagerPair = pair;
        return pair;
    }

    private final boolean checkLogin(Activity activity) {
        if (!BiliAccounts.get(activity).isLogin()) {
            Uri parse = Uri.parse("activity://main/login/");
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            BLRouter.routeTo(new RouteRequest.Builder(parse).build(), activity);
            return false;
        }
        return true;
    }

    private final Pair<InputBarTag, CommentInputBarManager> getPair(long oid, int type, long upperId, int followingType, FragmentActivity fragmentActivity) {
        Pair pair = this.mInputManagerPair;
        if (pair == null) {
            return initPair(oid, type, upperId, followingType, fragmentActivity);
        }
        InputBarTag inputBarTag = (InputBarTag) pair.getFirst();
        CommentInputBarManager manager = (CommentInputBarManager) pair.getSecond();
        boolean dataIsRight = manager != null && oid == inputBarTag.getId() && inputBarTag.getType() == type && inputBarTag.getHash() == fragmentActivity.hashCode();
        if (!dataIsRight) {
            return initPair(oid, type, upperId, followingType, fragmentActivity);
        }
        return pair;
    }

    private final CommentSendController.Callback buildSendCallback(final CommentInputBarManager manager, final CommentInputCallback callback) {
        return new CommentSendController.Callback() { // from class: tv.danmaku.bili.ui.comment.CommentServiceImpl$buildSendCallback$1
            public void onSendSuccess(BiliComment comment, CommentSendController.SendParams params) {
                manager.onSendSuccess(comment, params);
            }

            public void onSendSuccessWithResult(BiliComment comment, CommentSendController.SendParams params, BiliCommentAddResult result) {
                String str;
                Intrinsics.checkNotNullParameter(result, "result");
                CommentInputCallback commentInputCallback = callback;
                if (commentInputCallback != null) {
                    String str2 = null;
                    if (comment == null) {
                        str = null;
                    } else {
                        str = JSON.toJSONString(comment);
                    }
                    if (params != null) {
                        str2 = JSONObject.toJSONString(params);
                    }
                    commentInputCallback.onSendSuccessWithResult(str, str2, JSONObject.toJSONString(result));
                }
            }
        };
    }

    public boolean openCommentInputBar(FragmentActivity fragmentActivity, long oid, int type, long upperId, int followingType, CommentService.ReplyCommentInfo info, String placeHolder, String order, CommentInputCallback callback, CommentService.IInputSupplementaryConfig config) {
        CommentInputBarManager inputBarManager;
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        if (checkLogin((Activity) fragmentActivity) && (inputBarManager = (CommentInputBarManager) getPair(oid, type, upperId, followingType, fragmentActivity).getSecond()) != null) {
            CommentSendController $this$openCommentInputBar_u24lambda_u240_u240 = inputBarManager.getSendController();
            if ($this$openCommentInputBar_u24lambda_u240_u240 != null) {
                $this$openCommentInputBar_u24lambda_u240_u240.setCallback(buildSendCallback(inputBarManager, callback));
                $this$openCommentInputBar_u24lambda_u240_u240.onHostAlive();
                CommentContext commentContext = inputBarManager.getCommentContext();
                if (commentContext != null) {
                    commentContext.setOrder(order);
                }
                $this$openCommentInputBar_u24lambda_u240_u240.update(info != null ? info.getRpid() : 0L);
                if (info != null) {
                    inputBarManager.bindPrimaryComment(new AttachedCommentInfo(info.getNickName(), info.getRpid()));
                }
            }
            if (placeHolder != null) {
                BiliCommentControl control = new BiliCommentControl();
                control.inputText = placeHolder;
                inputBarManager.enableInput(control);
            }
            if (config != null) {
                inputBarManager.setConfig(toInputSupplementaryConfig(config));
            }
            inputBarManager.showInputBar(false, false);
            return true;
        }
        return false;
    }

    private final InputSupplementaryConfig toInputSupplementaryConfig(final CommentService.IInputSupplementaryConfig $this$toInputSupplementaryConfig) {
        return new InputSupplementaryConfig($this$toInputSupplementaryConfig) { // from class: tv.danmaku.bili.ui.comment.CommentServiceImpl$toInputSupplementaryConfig$1
            private final CommentServiceImpl$toInputSupplementaryConfig$1$background$1 background;
            private final CommentServiceImpl$toInputSupplementaryConfig$1$buttonEnable$1 buttonEnable;
            private final DialogInterface.OnDismissListener onDismissListener;
            private final InputOnSendListener onSendListener;
            private final DialogInterface.OnShowListener onShowListener;
            private final CommentServiceImpl$toInputSupplementaryConfig$1$visibleRectChangeListener$1 visibleRectChangeListener;

            public /* synthetic */ void onNotesSendSuccess() {
                InputSupplementaryConfig.-CC.$default$onNotesSendSuccess(this);
            }

            public /* synthetic */ void onSendFail() {
                InputSupplementaryConfig.-CC.$default$onSendFail(this);
            }

            public /* synthetic */ void onSendReturnOrCancelAfterStart() {
                InputSupplementaryConfig.-CC.$default$onSendReturnOrCancelAfterStart(this);
            }

            public /* synthetic */ void onSendStart(InputOnSendListener.Params params) {
                InputSupplementaryConfig.-CC.$default$onSendStart(this, params);
            }

            public /* synthetic */ void onSendSuccess(InputOnSendListener.SuccessResult successResult) {
                InputSupplementaryConfig.-CC.$default$onSendSuccess(this, successResult);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Type inference failed for: r0v0, types: [tv.danmaku.bili.ui.comment.CommentServiceImpl$toInputSupplementaryConfig$1$buttonEnable$1] */
            /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.bili.ui.comment.CommentServiceImpl$toInputSupplementaryConfig$1$visibleRectChangeListener$1] */
            /* JADX WARN: Type inference failed for: r0v2, types: [tv.danmaku.bili.ui.comment.CommentServiceImpl$toInputSupplementaryConfig$1$background$1] */
            {
                this.buttonEnable = new InputSupplementaryButtonEnable($this$toInputSupplementaryConfig) { // from class: tv.danmaku.bili.ui.comment.CommentServiceImpl$toInputSupplementaryConfig$1$buttonEnable$1
                    private final ButtonEnable checkBox;
                    private final ButtonEnable contentSearchButton;
                    private final ButtonEnable emoticonButton;
                    private final ButtonEnable lotteryButton;
                    private final ButtonEnable noteButton;
                    private final ButtonEnable noteGuidePop;
                    private final ButtonEnable userAtButton;
                    private final ButtonEnable voteButton;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.checkBox = new ButtonEnable($this$toInputSupplementaryConfig.getButtonEnable().getCheckBox().getNormal(), $this$toInputSupplementaryConfig.getButtonEnable().getCheckBox().getReply());
                        this.emoticonButton = new ButtonEnable($this$toInputSupplementaryConfig.getButtonEnable().getEmoticonButton().getNormal(), $this$toInputSupplementaryConfig.getButtonEnable().getEmoticonButton().getReply());
                        this.userAtButton = new ButtonEnable($this$toInputSupplementaryConfig.getButtonEnable().getUserAtButton().getNormal(), $this$toInputSupplementaryConfig.getButtonEnable().getUserAtButton().getReply());
                        this.voteButton = new ButtonEnable($this$toInputSupplementaryConfig.getButtonEnable().getVoteButton().getNormal(), $this$toInputSupplementaryConfig.getButtonEnable().getVoteButton().getReply());
                        this.lotteryButton = new ButtonEnable($this$toInputSupplementaryConfig.getButtonEnable().getLotteryButton().getNormal(), $this$toInputSupplementaryConfig.getButtonEnable().getLotteryButton().getReply());
                        this.contentSearchButton = new ButtonEnable($this$toInputSupplementaryConfig.getButtonEnable().getContentSearchButton().getNormal(), $this$toInputSupplementaryConfig.getButtonEnable().getContentSearchButton().getReply());
                        this.noteButton = new ButtonEnable($this$toInputSupplementaryConfig.getButtonEnable().getNoteButton().getNormal(), $this$toInputSupplementaryConfig.getButtonEnable().getNoteButton().getReply());
                        this.noteGuidePop = new ButtonEnable($this$toInputSupplementaryConfig.getButtonEnable().getNoteGuidePop().getNormal(), $this$toInputSupplementaryConfig.getButtonEnable().getNoteGuidePop().getReply());
                    }

                    public ButtonEnable getCheckBox() {
                        return this.checkBox;
                    }

                    public ButtonEnable getEmoticonButton() {
                        return this.emoticonButton;
                    }

                    public ButtonEnable getUserAtButton() {
                        return this.userAtButton;
                    }

                    public ButtonEnable getVoteButton() {
                        return this.voteButton;
                    }

                    public ButtonEnable getLotteryButton() {
                        return this.lotteryButton;
                    }

                    public ButtonEnable getContentSearchButton() {
                        return this.contentSearchButton;
                    }

                    public ButtonEnable getNoteButton() {
                        return this.noteButton;
                    }

                    public ButtonEnable getNoteGuidePop() {
                        return this.noteGuidePop;
                    }
                };
                this.visibleRectChangeListener = new InputBarVisibleRectChangeListener() { // from class: tv.danmaku.bili.ui.comment.CommentServiceImpl$toInputSupplementaryConfig$1$visibleRectChangeListener$1
                    public void onGlobalVisibleRectChanged(Rect globalRect) {
                        Intrinsics.checkNotNullParameter(globalRect, "globalRect");
                        $this$toInputSupplementaryConfig.getVisibleRectChangeListener().onGlobalVisibleRectChanged(globalRect);
                    }
                };
                this.background = new InputBackground($this$toInputSupplementaryConfig) { // from class: tv.danmaku.bili.ui.comment.CommentServiceImpl$toInputSupplementaryConfig$1$background$1
                    private final int backColor;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.backColor = $this$toInputSupplementaryConfig.getBackground().getBackColor();
                    }

                    public int getBackColor() {
                        return this.backColor;
                    }
                };
                this.onDismissListener = $this$toInputSupplementaryConfig.getOnDismissListener();
                this.onShowListener = $this$toInputSupplementaryConfig.getOnShowListener();
                this.onSendListener = new InputOnSendListener() { // from class: tv.danmaku.bili.ui.comment.CommentServiceImpl$toInputSupplementaryConfig$1$onSendListener$1
                    public void onSendStart(InputOnSendListener.Params params) {
                        Intrinsics.checkNotNullParameter(params, "params");
                        CommentService.IInputOnSendListener onSendListener = $this$toInputSupplementaryConfig.getOnSendListener();
                        if (onSendListener != null) {
                            onSendListener.onSendStart(new CommentService.IInputOnSendListener.Params());
                        }
                    }

                    public void onSendReturnOrCancelAfterStart() {
                        CommentService.IInputOnSendListener onSendListener = $this$toInputSupplementaryConfig.getOnSendListener();
                        if (onSendListener != null) {
                            onSendListener.onSendReturnOrCancelAfterStart();
                        }
                    }

                    public void onSendFail() {
                        CommentService.IInputOnSendListener onSendListener = $this$toInputSupplementaryConfig.getOnSendListener();
                        if (onSendListener != null) {
                            onSendListener.onSendFail();
                        }
                    }

                    public void onSendSuccess(InputOnSendListener.SuccessResult successResult) {
                        String commentJSONString;
                        String sendParamsJSONString;
                        Intrinsics.checkNotNullParameter(successResult, "successResult");
                        CommentService.IInputOnSendListener onSendListener = $this$toInputSupplementaryConfig.getOnSendListener();
                        if (onSendListener != null) {
                            if (successResult.getComment() != null) {
                                commentJSONString = JSON.toJSONString(successResult.getComment());
                            } else {
                                commentJSONString = null;
                            }
                            if (successResult.getSendParams() != null) {
                                sendParamsJSONString = JSONObject.toJSONString(successResult.getSendParams());
                            } else {
                                sendParamsJSONString = null;
                            }
                            String resultJSONString = successResult.getResult() != null ? JSONObject.toJSONString(successResult.getResult()) : null;
                            onSendListener.onSendSuccess(new CommentService.IInputOnSendListener.SuccessResult(commentJSONString, sendParamsJSONString, resultJSONString));
                        }
                    }

                    public void onNotesSendSuccess() {
                        CommentService.IInputOnSendListener onSendListener = $this$toInputSupplementaryConfig.getOnSendListener();
                        if (onSendListener != null) {
                            onSendListener.onNotesSendSuccess();
                        }
                    }
                };
            }

            public CommentServiceImpl$toInputSupplementaryConfig$1$buttonEnable$1 getButtonEnable() {
                return this.buttonEnable;
            }

            public CommentServiceImpl$toInputSupplementaryConfig$1$visibleRectChangeListener$1 getVisibleRectChangeListener() {
                return this.visibleRectChangeListener;
            }

            public CommentServiceImpl$toInputSupplementaryConfig$1$background$1 getBackground() {
                return this.background;
            }

            public DialogInterface.OnDismissListener getOnDismissListener() {
                return this.onDismissListener;
            }

            public DialogInterface.OnShowListener getOnShowListener() {
                return this.onShowListener;
            }

            public InputOnSendListener getOnSendListener() {
                return this.onSendListener;
            }
        };
    }

    public void release(Activity activity) {
        Pair pair = this.mInputManagerPair;
        if (pair == null) {
            return;
        }
        boolean z = false;
        if (activity != null && ((InputBarTag) pair.getFirst()).getHash() == activity.hashCode()) {
            z = true;
        }
        if (z) {
            this.mInputManagerPair = null;
        }
    }

    /* compiled from: CommentServiceImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/comment/CommentServiceImpl$InputBarTag;", "", "id", "", "type", "", "hash", "<init>", "(JII)V", "getId", "()J", "getType", "()I", "getHash", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class InputBarTag {
        public static final int $stable = 0;
        private final int hash;
        private final long id;
        private final int type;

        public InputBarTag(long id, int type, int hash) {
            this.id = id;
            this.type = type;
            this.hash = hash;
        }

        public final int getHash() {
            return this.hash;
        }

        public final long getId() {
            return this.id;
        }

        public final int getType() {
            return this.type;
        }
    }
}