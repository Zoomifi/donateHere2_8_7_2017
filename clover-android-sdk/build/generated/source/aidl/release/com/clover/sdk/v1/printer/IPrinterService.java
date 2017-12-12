/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v1/printer/IPrinterService.aidl
 */
package com.clover.sdk.v1.printer;
/**
 * An interface for adding, listing, and removing Clover printers. To print to a Clover printer,
 * use the classes in the {@link com.clover.sdk.v1.printer.job} package. To open a cash
 * drawer connected to a Clover printer, use the {@link com.clover.sdk.v1.printer.CashDrawer} class.
 * To interact with the Clover print queue, use the {@link com.clover.sdk.v1.printer.PrintQueue}
 * class.
 * <br/><br/>
 * The Printer
 * service is a bound AIDL service. Bind to this service as follows,
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(PrinterIntent.ACTION_MERCHANT_SERVICE);
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
 * You may also interact with the printer service through the
 * {@link com.clover.sdk.v1.printer.PrinterConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 *
 * @see com.clover.sdk.v1.printer.PrinterIntent
 * @see com.clover.sdk.util.CloverAccount
 * @see com.clover.sdk.v1.printer.PrinterConnector
 */
public interface IPrinterService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.printer.IPrinterService
{
private static final String DESCRIPTOR = "com.clover.sdk.v1.printer.IPrinterService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.printer.IPrinterService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.printer.IPrinterService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.printer.IPrinterService))) {
return ((com.clover.sdk.v1.printer.IPrinterService)iin);
}
return new com.clover.sdk.v1.printer.IPrinterService.Stub.Proxy(obj);
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
case TRANSACTION_getPrinters:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v1.printer.Printer> _result = this.getPrinters(_arg0);
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
case TRANSACTION_getPrintersByCategory:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.printer.Category _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.printer.Category.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v1.printer.Printer> _result = this.getPrintersByCategory(_arg0, _arg1);
reply.writeNoException();
reply.writeTypedList(_result);
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_isPrinterSet:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.printer.Category _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.printer.Category.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.isPrinterSet(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPrinterById:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.printer.Printer _result = this.getPrinterById(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg1!=null)) {
reply.writeInt(1);
_arg1.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_removePrinter:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.printer.Printer _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.printer.Printer.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.removePrinter(_arg0, _arg1);
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
case TRANSACTION_setPrinter:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.printer.Printer _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v1.printer.Printer.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.printer.Printer _result = this.setPrinter(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
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
private static class Proxy implements com.clover.sdk.v1.printer.IPrinterService
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
@Override public java.util.List<com.clover.sdk.v1.printer.Printer> getPrinters(com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v1.printer.Printer> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrinters, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v1.printer.Printer.CREATOR);
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<com.clover.sdk.v1.printer.Printer> getPrintersByCategory(com.clover.sdk.v1.printer.Category category, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v1.printer.Printer> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((category!=null)) {
_data.writeInt(1);
category.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPrintersByCategory, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v1.printer.Printer.CREATOR);
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isPrinterSet(com.clover.sdk.v1.printer.Category category, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((category!=null)) {
_data.writeInt(1);
category.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_isPrinterSet, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.clover.sdk.v1.printer.Printer getPrinterById(String id, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.printer.Printer _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_getPrinterById, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.printer.Printer.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void removePrinter(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((p!=null)) {
_data.writeInt(1);
p.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_removePrinter, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public com.clover.sdk.v1.printer.Printer setPrinter(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.printer.Printer _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((p!=null)) {
_data.writeInt(1);
p.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setPrinter, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.printer.Printer.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
status.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getPrinters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getPrintersByCategory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_isPrinterSet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getPrinterById = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_removePrinter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setPrinter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
}
public java.util.List<com.clover.sdk.v1.printer.Printer> getPrinters(com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public java.util.List<com.clover.sdk.v1.printer.Printer> getPrintersByCategory(com.clover.sdk.v1.printer.Category category, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public boolean isPrinterSet(com.clover.sdk.v1.printer.Category category, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v1.printer.Printer getPrinterById(String id, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public void removePrinter(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v1.printer.Printer setPrinter(com.clover.sdk.v1.printer.Printer p, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
}
