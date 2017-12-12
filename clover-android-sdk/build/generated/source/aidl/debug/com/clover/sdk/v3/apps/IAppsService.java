/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v3/apps/IAppsService.aidl
 */
package com.clover.sdk.v3.apps;
/**
    Provides services related to Clover applications.
 */
public interface IAppsService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.apps.IAppsService
{
private static final String DESCRIPTOR = "com.clover.sdk.v3.apps.IAppsService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.apps.IAppsService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.apps.IAppsService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.apps.IAppsService))) {
return ((com.clover.sdk.v3.apps.IAppsService)iin);
}
return new com.clover.sdk.v3.apps.IAppsService.Stub.Proxy(obj);
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
case TRANSACTION_getApp:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.apps.App _result = this.getApp(_arg0);
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
case TRANSACTION_logMetered:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.logMetered(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getAppBillingInfo:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.apps.AppBillingInfo _result = this.getAppBillingInfo(_arg0);
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
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v3.apps.IAppsService
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
@Override public com.clover.sdk.v3.apps.App getApp(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.apps.App _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getApp, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.apps.App.CREATOR.createFromParcel(_reply);
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
@Override public void logMetered(String meteredId, int numberOfEvent, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(meteredId);
_data.writeInt(numberOfEvent);
mRemote.transact(Stub.TRANSACTION_logMetered, _data, _reply, 0);
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
@Override public com.clover.sdk.v3.apps.AppBillingInfo getAppBillingInfo(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.apps.AppBillingInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAppBillingInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.apps.AppBillingInfo.CREATOR.createFromParcel(_reply);
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
}
static final int TRANSACTION_getApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_logMetered = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getAppBillingInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public com.clover.sdk.v3.apps.App getApp(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void logMetered(String meteredId, int numberOfEvent, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v3.apps.AppBillingInfo getAppBillingInfo(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
