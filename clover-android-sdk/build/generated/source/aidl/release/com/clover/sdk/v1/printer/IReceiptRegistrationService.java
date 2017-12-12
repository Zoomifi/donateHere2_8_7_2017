/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v1/printer/IReceiptRegistrationService.aidl
 */
package com.clover.sdk.v1.printer;
/**
 * An interface for registering components that wish to add additional data to customer receipts.
 * <br/><br/>
 * Developers that wish to add additional data to customer receipts should call the
 * {@link #register(Uri,ResultStatus)} method to register the URI of a content provider
 * that will provide receipt data.  Said content provider must conform to the
 * {@link ReceiptContract} contract.
 * <br/><br/>
 * The ReceiptRegistration
 * service is a bound AIDL service. Bind to this service as follows,
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(PrinterIntent.ACTION_RECEIPT_REGISTRATION);
 * serviceIntent.putExtra(PrinterIntent.EXTRA_ACCOUNT, CloverAccount.getAccount(context));
 * serviceIntent.putExtra(PrinterIntent.EXTRA_VERSION, 1);
 * context.bindService(serviceIntent);
 * </code>
 * </pre>
 * For more information about bound services, refer to
 * the Android documentation:
 * <a href="http://developer.android.com/guide/components/bound-services.html#Binding">
 * Bound Services
 * </a>.
 * <br/><br/>
 * You may also interact with the receipt registration service through the
 * {@link com.clover.sdk.v1.printer.ReceiptRegistrationConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 *
 * @see com.clover.sdk.v1.printer.PrinterIntent
 * @see com.clover.sdk.util.CloverAccount
 * @see com.clover.sdk.v1.printer.ReceiptRegistrationConnector
 * @see ReceiptContract
 */
public interface IReceiptRegistrationService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.printer.IReceiptRegistrationService
{
private static final String DESCRIPTOR = "com.clover.sdk.v1.printer.IReceiptRegistrationService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.printer.IReceiptRegistrationService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.printer.IReceiptRegistrationService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.printer.IReceiptRegistrationService))) {
return ((com.clover.sdk.v1.printer.IReceiptRegistrationService)iin);
}
return new com.clover.sdk.v1.printer.IReceiptRegistrationService.Stub.Proxy(obj);
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
case TRANSACTION_register:
{
data.enforceInterface(DESCRIPTOR);
android.net.Uri _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.Uri.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.register(_arg0, _arg1);
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
case TRANSACTION_unregister:
{
data.enforceInterface(DESCRIPTOR);
android.net.Uri _arg0;
if ((0!=data.readInt())) {
_arg0 = android.net.Uri.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.unregister(_arg0, _arg1);
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
case TRANSACTION_getRegistrations:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v1.printer.ReceiptRegistration> _result = this.getRegistrations(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v1.printer.IReceiptRegistrationService
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
@Override public void register(android.net.Uri uri, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((uri!=null)) {
_data.writeInt(1);
uri.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_register, _data, _reply, 0);
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
@Override public void unregister(android.net.Uri uri, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((uri!=null)) {
_data.writeInt(1);
uri.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_unregister, _data, _reply, 0);
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
@Override public java.util.List<com.clover.sdk.v1.printer.ReceiptRegistration> getRegistrations(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v1.printer.ReceiptRegistration> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRegistrations, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v1.printer.ReceiptRegistration.CREATOR);
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
}
static final int TRANSACTION_register = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_unregister = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getRegistrations = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void register(android.net.Uri uri, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void unregister(android.net.Uri uri, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public java.util.List<com.clover.sdk.v1.printer.ReceiptRegistration> getRegistrations(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
