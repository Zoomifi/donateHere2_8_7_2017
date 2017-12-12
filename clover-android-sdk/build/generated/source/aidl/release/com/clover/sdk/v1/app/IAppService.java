/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v1/app/IAppService.aidl
 */
package com.clover.sdk.v1.app;
/**
    Provides services related to Clover applications.
 */
public interface IAppService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.app.IAppService
{
private static final String DESCRIPTOR = "com.clover.sdk.v1.app.IAppService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.app.IAppService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.app.IAppService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.app.IAppService))) {
return ((com.clover.sdk.v1.app.IAppService)iin);
}
return new com.clover.sdk.v1.app.IAppService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_notify:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.app.AppNotification _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.app.AppNotification.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.notify(_arg0, _arg1);
reply.writeNoException();
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v1.app.IAppService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
        Send a notification to all instances of this app running at the merchant site.
        The notification is queued and sent in the background, so it's safe to make this
        call on the main thread.
    */
@Override public void notify(com.clover.sdk.v1.app.AppNotification notification, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((notification!=null)) {
_data.writeInt(1);
notification.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_notify, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
resultStatus.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_notify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
        Send a notification to all instances of this app running at the merchant site.
        The notification is queued and sent in the background, so it's safe to make this
        call on the main thread.
    */
public void notify(com.clover.sdk.v1.app.AppNotification notification, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
