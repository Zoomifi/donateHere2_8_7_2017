/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v1/merchant/IMerchantService.aidl
 */
package com.clover.sdk.v1.merchant;
/**
 * An interface for interacting with the Clover merchant service. The merchant
 * service is a bound AIDL service. Bind to this service as follows,
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(MerchantIntent.ACTION_MERCHANT_SERVICE);
 * serviceIntent.putExtra(MerchantIntent.EXTRA_ACCOUNT, CloverAccount.getAccount(context));
 * serviceIntent.putExtra(MerchantIntent.EXTRA_VERSION, 1);
 * context.bindService(serviceIntent);
 * </code>
 * </pre>
 * For more information about bound services, refer to
 * the Android documentation:
 * <a href="http://developer.android.com/guide/components/bound-services.html#Binding">
 * Bound Services
 * </a>.
 * <br/><br/>
 * You may also interact with the merchant service through the
 * {@link com.clover.sdk.v1.merchant.MerchantConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 *
 * @see com.clover.sdk.v1.merchant.MerchantIntent
 * @see com.clover.sdk.util.CloverAccount
 * @see com.clover.sdk.v1.merchant.MerchantConnector
 */
public interface IMerchantService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.merchant.IMerchantService
{
private static final String DESCRIPTOR = "com.clover.sdk.v1.merchant.IMerchantService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.merchant.IMerchantService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.merchant.IMerchantService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.merchant.IMerchantService))) {
return ((com.clover.sdk.v1.merchant.IMerchantService)iin);
}
return new com.clover.sdk.v1.merchant.IMerchantService.Stub.Proxy(obj);
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
case TRANSACTION_getMerchant:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.merchant.Merchant _result = this.getMerchant(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setAddress:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.merchant.MerchantAddress _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.merchant.MerchantAddress.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.setAddress(_arg0, _arg1);
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
case TRANSACTION_setPhoneNumber:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.setPhoneNumber(_arg0, _arg1);
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
case TRANSACTION_addListener:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.merchant.IMerchantListener _arg0;
_arg0 = com.clover.sdk.v1.merchant.IMerchantListener.Stub.asInterface(data.readStrongBinder());
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.addListener(_arg0, _arg1);
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
case TRANSACTION_removeListener:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.merchant.IMerchantListener _arg0;
_arg0 = com.clover.sdk.v1.merchant.IMerchantListener.Stub.asInterface(data.readStrongBinder());
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.removeListener(_arg0, _arg1);
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
case TRANSACTION_setUpdateStock:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.setUpdateStock(_arg0, _arg1);
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
case TRANSACTION_setTrackStock:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.setTrackStock(_arg0, _arg1);
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
private static class Proxy implements com.clover.sdk.v1.merchant.IMerchantService
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
     * Get the merchant object. The merchant returned corresponds to the Clover
     * {@link android.accounts.Account} that was passed when binding to to the
     * service.
     *
     * @param resultStatus The result of the service method call.
     */
@Override public com.clover.sdk.v1.merchant.Merchant getMerchant(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.merchant.Merchant _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMerchant, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.merchant.Merchant.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
resultStatus.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setAddress(com.clover.sdk.v1.merchant.MerchantAddress address, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((address!=null)) {
_data.writeInt(1);
address.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setAddress, _data, _reply, 0);
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
@Override public void setPhoneNumber(String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(phoneNumber);
mRemote.transact(Stub.TRANSACTION_setPhoneNumber, _data, _reply, 0);
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
@Override public void addListener(com.clover.sdk.v1.merchant.IMerchantListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addListener, _data, _reply, 0);
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
@Override public void removeListener(com.clover.sdk.v1.merchant.IMerchantListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeListener, _data, _reply, 0);
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
@Override public void setUpdateStock(boolean updateStock, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((updateStock)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setUpdateStock, _data, _reply, 0);
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
@Override public void setTrackStock(boolean trackStock, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((trackStock)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setTrackStock, _data, _reply, 0);
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
static final int TRANSACTION_getMerchant = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_setAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setPhoneNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_addListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_removeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setUpdateStock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_setTrackStock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
}
/**
     * Get the merchant object. The merchant returned corresponds to the Clover
     * {@link android.accounts.Account} that was passed when binding to to the
     * service.
     *
     * @param resultStatus The result of the service method call.
     */
public com.clover.sdk.v1.merchant.Merchant getMerchant(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setAddress(com.clover.sdk.v1.merchant.MerchantAddress address, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setPhoneNumber(String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void addListener(com.clover.sdk.v1.merchant.IMerchantListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void removeListener(com.clover.sdk.v1.merchant.IMerchantListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setUpdateStock(boolean updateStock, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setTrackStock(boolean trackStock, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
