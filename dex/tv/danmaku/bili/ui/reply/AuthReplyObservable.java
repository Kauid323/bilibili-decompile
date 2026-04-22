package tv.danmaku.bili.ui.reply;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import tv.danmaku.bili.cb.AuthResultCbMsg;

public class AuthReplyObservable extends Observable {
    private static List<Observer> mObservers;

    public AuthReplyObservable() {
        if (mObservers != null) {
            for (Observer observer : mObservers) {
                addObserver(observer);
            }
        }
    }

    public void receiveReplyEvent(AuthResultCbMsg authResultCbMsg) {
        setChanged();
        notifyObservers(authResultCbMsg);
    }

    public static synchronized void registerAuthReplyObserver(Observer observer) {
        synchronized (AuthReplyObservable.class) {
            if (mObservers == null) {
                mObservers = new ArrayList();
            }
            mObservers.add(observer);
        }
    }

    public static synchronized void unRegisterAuthReplyObserver(Observer observer) {
        synchronized (AuthReplyObservable.class) {
            if (mObservers != null) {
                mObservers.remove(observer);
                if (mObservers.size() == 0) {
                    mObservers = null;
                }
            }
        }
    }
}