package de.robv.android.xposed;

import de.robv.android.xposed.XC_MethodHook;

public abstract class XC_MethodReplacement extends XC_MethodHook {
    public static final XC_MethodReplacement DO_NOTHING = new XC_MethodReplacement(20000) { // from class: de.robv.android.xposed.XC_MethodReplacement.1
        @Override // de.robv.android.xposed.XC_MethodReplacement
        protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
            return null;
        }
    };

    protected abstract Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable;

    public XC_MethodReplacement() {
    }

    public XC_MethodReplacement(int priority) {
        super(priority);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // de.robv.android.xposed.XC_MethodHook
    public final void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
        try {
            Object result = replaceHookedMethod(param);
            param.setResult(result);
        } catch (Throwable t) {
            param.setThrowable(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // de.robv.android.xposed.XC_MethodHook
    public final void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
    }

    public static XC_MethodReplacement returnConstant(Object result) {
        return returnConstant(50, result);
    }

    public static XC_MethodReplacement returnConstant(int priority, final Object result) {
        return new XC_MethodReplacement(priority) { // from class: de.robv.android.xposed.XC_MethodReplacement.2
            @Override // de.robv.android.xposed.XC_MethodReplacement
            protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                return result;
            }
        };
    }
}