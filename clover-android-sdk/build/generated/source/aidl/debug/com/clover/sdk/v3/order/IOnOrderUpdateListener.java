/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v3/order/IOnOrderUpdateListener.aidl
 */
package com.clover.sdk.v3.order;
public interface IOnOrderUpdateListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.order.IOnOrderUpdateListener
{
private static final String DESCRIPTOR = "com.clover.sdk.v3.order.IOnOrderUpdateListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.order.IOnOrderUpdateListener interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.order.IOnOrderUpdateListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.order.IOnOrderUpdateListener))) {
return ((com.clover.sdk.v3.order.IOnOrderUpdateListener)iin);
}
return new com.clover.sdk.v3.order.IOnOrderUpdateListener.Stub.Proxy(obj);
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
case TRANSACTION_onOrderUpdated:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.onOrderUpdated(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v3.order.IOnOrderUpdateListener
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
@Override public void onOrderUpdated(String orderId, boolean selfChange) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeInt(((selfChange)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onOrderUpdated, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onOrderUpdated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onOrderUpdated(String orderId, boolean selfChange) throws android.os.RemoteException;
}
