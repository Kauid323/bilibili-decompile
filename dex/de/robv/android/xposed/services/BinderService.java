package de.robv.android.xposed.services;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import java.io.IOException;

public final class BinderService extends BaseService {
    private static final int ACCESS_FILE_TRANSACTION = 3;
    private static final String INTERFACE_TOKEN = "de.robv.android.xposed.IXposedService";
    private static final int READ_FILE_TRANSACTION = 5;
    private static final int STAT_FILE_TRANSACTION = 4;
    public static final int TARGET_APP = 0;
    public static final int TARGET_SYSTEM = 1;
    private final IBinder mRemote;
    private static final String[] SERVICE_NAMES = {"user.xposed.app", "user.xposed.system"};
    private static final BinderService[] sServices = new BinderService[2];

    public static BinderService getService(int target) {
        BinderService binderService;
        if (target < 0 || target > sServices.length) {
            throw new IllegalArgumentException("Invalid service target " + target);
        }
        synchronized (sServices) {
            if (sServices[target] == null) {
                sServices[target] = new BinderService(target);
            }
            binderService = sServices[target];
        }
        return binderService;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public boolean checkFileAccess(String filename, int mode) {
        ensureAbsolutePath(filename);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(INTERFACE_TOKEN);
        data.writeString(filename);
        data.writeInt(mode);
        try {
            this.mRemote.transact(3, data, reply, 0);
            reply.readException();
            int result = reply.readInt();
            reply.recycle();
            data.recycle();
            return result == 0;
        } catch (RemoteException e2) {
            data.recycle();
            reply.recycle();
            return false;
        }
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult statFile(String filename) throws IOException {
        ensureAbsolutePath(filename);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(INTERFACE_TOKEN);
        data.writeString(filename);
        try {
            this.mRemote.transact(4, data, reply, 0);
            reply.readException();
            int errno = reply.readInt();
            if (errno != 0) {
                throwCommonIOException(errno, null, filename, " while retrieving attributes for ");
            }
            long size = reply.readLong();
            long time = reply.readLong();
            reply.recycle();
            data.recycle();
            return new FileResult(size, time);
        } catch (RemoteException e2) {
            data.recycle();
            reply.recycle();
            throw new IOException(e2);
        }
    }

    @Override // de.robv.android.xposed.services.BaseService
    public byte[] readFile(String filename) throws IOException {
        return readFile(filename, 0, 0, 0L, 0L).content;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String filename, long previousSize, long previousTime) throws IOException {
        return readFile(filename, 0, 0, previousSize, previousTime);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String filename, int offset, int length, long previousSize, long previousTime) throws IOException {
        ensureAbsolutePath(filename);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(INTERFACE_TOKEN);
        data.writeString(filename);
        data.writeInt(offset);
        data.writeInt(length);
        data.writeLong(previousSize);
        data.writeLong(previousTime);
        try {
            this.mRemote.transact(5, data, reply, 0);
            reply.readException();
            int errno = reply.readInt();
            String errorMsg = reply.readString();
            long size = reply.readLong();
            long time = reply.readLong();
            byte[] content = reply.createByteArray();
            reply.recycle();
            data.recycle();
            switch (errno) {
                case 0:
                    return new FileResult(content, size, time);
                case 22:
                    if (errorMsg != null) {
                        IllegalArgumentException iae = new IllegalArgumentException(errorMsg);
                        if (offset == 0 && length == 0) {
                            throw new IOException(iae);
                        }
                        throw iae;
                    }
                    throw new IllegalArgumentException("Offset " + offset + " / Length " + length + " is out of range for " + filename + " with size " + size);
                default:
                    throwCommonIOException(errno, errorMsg, filename, " while reading ");
                    throw new IllegalStateException();
            }
        } catch (RemoteException e2) {
            data.recycle();
            reply.recycle();
            throw new IOException(e2);
        }
    }

    private BinderService(int target) {
        IBinder binder = ServiceManager.getService(SERVICE_NAMES[target]);
        if (binder == null) {
            throw new IllegalStateException("Service " + SERVICE_NAMES[target] + " does not exist");
        }
        this.mRemote = binder;
    }
}