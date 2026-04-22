package tv.danmaku.bili.update.internal.binder;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.exception.ViewNotFoundException;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;

public abstract class DialogViewBinder<T extends BinderParams> {
    private static final String TAG = "update.api.DialogViewBinder";
    protected T mBindParams;

    void setBindParams(T bindParams) {
        this.mBindParams = bindParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity getContext() {
        if (this.mBindParams == null) {
            BLog.w(TAG, "getUpgradeInfo: mBindParams == null");
            return null;
        }
        return this.mBindParams.getActivityRef().get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BiliUpgradeInfo getUpgradeInfo() {
        if (this.mBindParams == null) {
            BLog.w(TAG, "getUpgradeInfo: mBindParams == null");
            return null;
        }
        return this.mBindParams.getBiliUpgradeInfo();
    }

    protected boolean isParamsInvalid() {
        return this.mBindParams == null || this.mBindParams.isInvalid();
    }

    public void bindView(Dialog dialog) throws ViewNotFoundException {
        if (isParamsInvalid()) {
            return;
        }
        setUpWifiView(dialog);
        setUpTitleView(dialog);
        setUpUpdateContentView(dialog);
        setUpIgnoreView(dialog);
        setUpNegativeButton(dialog);
        setUpPositiveButton(dialog);
        setUpOtherView(dialog);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(Landroid/app/Dialog;ILjava/lang/String;)TT; */
    public View requireViewById(Dialog dialog, int viewId, String viewIdName) throws ViewNotFoundException {
        View findViewById = dialog.findViewById(viewId);
        if (findViewById == null) {
            throw new ViewNotFoundException(String.format("Cannot find view by R.id.%s", viewIdName));
        }
        return findViewById;
    }

    public void setUpOtherView(Dialog dialog) throws ViewNotFoundException {
    }

    public void setUpWifiView(Dialog dialog) throws ViewNotFoundException {
    }

    public void setUpTitleView(Dialog dialog) throws ViewNotFoundException {
    }

    public void setUpUpdateContentView(Dialog dialog) throws ViewNotFoundException {
    }

    public void setUpIgnoreView(Dialog dialog) throws ViewNotFoundException {
    }

    public void setUpNegativeButton(Dialog dialog) throws ViewNotFoundException {
    }

    public void setUpPositiveButton(Dialog dialog) throws ViewNotFoundException {
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Decorator<T extends BinderParams> extends DialogViewBinder<T> {
        static final String TAG = "update.api.DialogViewBinder.Decorator";
        DialogViewBinder<T> dialogViewBinder;

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void setBusinessEvent(Dialog dialog) throws ViewNotFoundException;

        public Decorator(DialogViewBinder<T> dialogViewBinder) {
            if (dialogViewBinder == this) {
                throw new AssertionError("dialogViewBinder cannot be itself");
            }
            this.dialogViewBinder = dialogViewBinder;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
        public void setBindParams(T bindParams) {
            if (this.dialogViewBinder != null) {
                this.dialogViewBinder.setBindParams(bindParams);
            }
            super.setBindParams(bindParams);
        }

        @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
        public final void bindView(Dialog dialog) {
            if (isParamsInvalid()) {
                return;
            }
            try {
                super.bindView(dialog);
                setBusinessEvent(dialog);
            } catch (ViewNotFoundException ex) {
                BLog.e(TAG, "bindView/ViewNotFoundException:" + ex);
                ex.printStackTrace();
            }
        }

        @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
        public void setUpTitleView(Dialog dialog) throws ViewNotFoundException {
            if (this.dialogViewBinder != null) {
                this.dialogViewBinder.setUpTitleView(dialog);
            } else {
                BLog.w(TAG, "setUpTitleView: dialogViewBinder == null");
            }
        }

        @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
        public void setUpUpdateContentView(Dialog dialog) throws ViewNotFoundException {
            if (this.dialogViewBinder != null) {
                this.dialogViewBinder.setUpUpdateContentView(dialog);
            } else {
                BLog.w(TAG, "setUpUpdateContentView: dialogViewBinder == null");
            }
        }

        @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
        public void setUpIgnoreView(Dialog dialog) throws ViewNotFoundException {
            if (this.dialogViewBinder != null) {
                this.dialogViewBinder.setUpIgnoreView(dialog);
            } else {
                BLog.w(TAG, "setUpIgnoreView: dialogViewBinder == null");
            }
        }

        @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
        public void setUpWifiView(Dialog dialog) throws ViewNotFoundException {
            if (this.dialogViewBinder != null) {
                this.dialogViewBinder.setUpWifiView(dialog);
            } else {
                BLog.w(TAG, "setUpWifiView: dialogViewBinder == null");
            }
        }

        @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
        public void setUpNegativeButton(Dialog dialog) throws ViewNotFoundException {
            if (this.dialogViewBinder != null) {
                this.dialogViewBinder.setUpNegativeButton(dialog);
            } else {
                BLog.w(TAG, "setUpNegativeButton: dialogViewBinder == null");
            }
        }

        @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
        public void setUpPositiveButton(Dialog dialog) throws ViewNotFoundException {
            if (this.dialogViewBinder != null) {
                this.dialogViewBinder.setUpPositiveButton(dialog);
            } else {
                BLog.w(TAG, "setUpPositiveButton: dialogViewBinder == null");
            }
        }

        @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
        public void setUpOtherView(Dialog dialog) throws ViewNotFoundException {
            if (this.dialogViewBinder != null) {
                this.dialogViewBinder.setUpOtherView(dialog);
            } else {
                BLog.w(TAG, "setUpOtherView: dialogViewBinder == null");
            }
        }
    }
}