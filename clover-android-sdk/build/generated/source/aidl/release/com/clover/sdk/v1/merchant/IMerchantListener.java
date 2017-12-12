/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v1/merchant/IMerchantListener.aidl
 */
package com.clover.sdk.v1.merchant;
/**
 * An interface for receiving events pertaining to a merchant. Add a listener as follows,
 * <pre>
 * <code>
 * iMerchantService.addListener(new IMerchantListener.Stub() {
 *     {@literal @}Override
 *     public void onMerchantChanged(Merchant merchant) {
 *       // merchant has changed, use it here
 *     }
 * };
 * </code>
 * </pre>
 * If using {@link com.clover.sdk.v1.merchant.MerchantConnector} to interact with the merchant
 * serivce, you may add listeners there.
 *
 * @see com.clover.sdk.v1.merchant.IMerchantService
 * @see com.clover.sdk.v1.merchant.IMerchantService#addListener(IMerchantListener,ResultStatus)
 * @see com.clover.sdk.v1.merchant.IMerchantService#removeListener(IMerchantListener,ResultStatus)
 * @see com.clover.sdk.v1.merchant.MerchantConnector
 */
public interface IMerchantListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.merchant.IMerchantListener
{
private static final String DESCRIPTOR = "com.clover.sdk.v1.merchant.IMerchantListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.merchant.IMerchantListener interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.merchant.IMerchantListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.merchant.IMerchantListener))) {
return ((com.clover.sdk.v1.merchant.IMerchantListener)iin);
}
return new com.clover.sdk.v1.merchant.IMerchantListener.Stub.Proxy(obj);
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
case TRANSACTION_onMerchantChanged:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.merchant.Merchant _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.merchant.Merchant.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onMerchantChanged(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v1.merchant.IMerchantListener
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
@Override public void onMerchantChanged(com.clover.sdk.v1.merchant.Merchant merchant) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((merchant!=null)) {
_data.writeInt(1);
merchant.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onMerchantChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onMerchantChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onMerchantChanged(com.clover.sdk.v1.merchant.Merchant merchant) throws android.os.RemoteException;
}
