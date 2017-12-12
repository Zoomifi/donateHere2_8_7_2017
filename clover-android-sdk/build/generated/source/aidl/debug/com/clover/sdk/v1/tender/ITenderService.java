/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v1/tender/ITenderService.aidl
 */
package com.clover.sdk.v1.tender;
/**
 * An interface for interacting with the Clover tender service. The tender
 * service is a bound AIDL service.
 */
public interface ITenderService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.tender.ITenderService
{
private static final String DESCRIPTOR = "com.clover.sdk.v1.tender.ITenderService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.tender.ITenderService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.tender.ITenderService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.tender.ITenderService))) {
return ((com.clover.sdk.v1.tender.ITenderService)iin);
}
return new com.clover.sdk.v1.tender.ITenderService.Stub.Proxy(obj);
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
case TRANSACTION_getTenders:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v1.tender.Tender> _result = this.getTenders(_arg0);
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
case TRANSACTION_checkAndCreateTender:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _arg3;
_arg3 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.tender.Tender _result = this.checkAndCreateTender(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg4!=null)) {
reply.writeInt(1);
_arg4.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setEnabled:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.tender.Tender _result = this.setEnabled(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_delete:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.delete(_arg0, _arg1);
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
case TRANSACTION_setOpensCashDrawer:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.setOpensCashDrawer(_arg0, _arg1, _arg2);
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
case TRANSACTION_setLabel:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.setLabel(_arg0, _arg1, _arg2);
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
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v1.tender.ITenderService
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
@Override public java.util.List<com.clover.sdk.v1.tender.Tender> getTenders(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v1.tender.Tender> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTenders, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v1.tender.Tender.CREATOR);
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
@Override public com.clover.sdk.v1.tender.Tender checkAndCreateTender(String label, String labelKey, boolean enabled, boolean opensCashDrawer, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.tender.Tender _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(label);
_data.writeString(labelKey);
_data.writeInt(((enabled)?(1):(0)));
_data.writeInt(((opensCashDrawer)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_checkAndCreateTender, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.tender.Tender.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v1.tender.Tender setEnabled(String tenderId, boolean enabled, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.tender.Tender _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tenderId);
_data.writeInt(((enabled)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setEnabled, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.tender.Tender.CREATOR.createFromParcel(_reply);
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
@Override public void delete(String tenderId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tenderId);
mRemote.transact(Stub.TRANSACTION_delete, _data, _reply, 0);
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
@Override public void setOpensCashDrawer(String tenderId, boolean opensCashDrawer, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tenderId);
_data.writeInt(((opensCashDrawer)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setOpensCashDrawer, _data, _reply, 0);
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
@Override public void setLabel(String tenderId, String tenderLable, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tenderId);
_data.writeString(tenderLable);
mRemote.transact(Stub.TRANSACTION_setLabel, _data, _reply, 0);
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
static final int TRANSACTION_getTenders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_checkAndCreateTender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_delete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setOpensCashDrawer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setLabel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
}
public java.util.List<com.clover.sdk.v1.tender.Tender> getTenders(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.tender.Tender checkAndCreateTender(String label, String labelKey, boolean enabled, boolean opensCashDrawer, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.tender.Tender setEnabled(String tenderId, boolean enabled, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void delete(String tenderId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setOpensCashDrawer(String tenderId, boolean opensCashDrawer, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setLabel(String tenderId, String tenderLable, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
