/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v3/employees/IEmployeeService.aidl
 */
package com.clover.sdk.v3.employees;
/**
 * An interface for interacting with the Clover employee service. The employee
 * service is a bound AIDL service. Bind to this service as follows,
 * <pre>
 * <code>
 * Intent serviceIntent = new Intent(EmployeeIntent.ACTION_EMPLOYEE_SERVICE);
 * serviceIntent.putExtra(EmployeeIntent.EXTRA_ACCOUNT, CloverAccount.getAccount(context));
 * serviceIntent.putExtra(EmployeeIntent.EXTRA_VERSION, 1);
 * context.bindService(serviceIntent);
 * </code>
 * </pre>
 * For more information about bound services, refer to
 * the Android documentation:
 * <a href="http://developer.android.com/guide/components/bound-services.html#Binding">
 * Bound Services
 * </a>.
 * <br/><br/>
 * You may also interact with the employee service through the
 * {@link com.clover.sdk.v1.employee.EmployeeConnector} class, which handles binding and
 * asynchronous invocation of service methods.
 *
 * @see com.clover.sdk.v1.employee.EmployeeIntent
 * @see com.clover.sdk.util.CloverAccount
 * @see com.clover.sdk.v1.employee.EmployeeConnector
 */
public interface IEmployeeService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.employees.IEmployeeService
{
private static final String DESCRIPTOR = "com.clover.sdk.v3.employees.IEmployeeService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.employees.IEmployeeService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.employees.IEmployeeService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.employees.IEmployeeService))) {
return ((com.clover.sdk.v3.employees.IEmployeeService)iin);
}
return new com.clover.sdk.v3.employees.IEmployeeService.Stub.Proxy(obj);
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
case TRANSACTION_getActiveEmployee:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.getActiveEmployee(_arg0);
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
case TRANSACTION_getEmployee:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.getEmployee(_arg0, _arg1);
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
case TRANSACTION_getEmployees:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.employees.Employee> _result = this.getEmployees(_arg0);
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
case TRANSACTION_createEmployee:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.employees.Employee _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.createEmployee(_arg0, _arg1);
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
case TRANSACTION_updateEmployee:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.employees.Employee _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.updateEmployee(_arg0, _arg1);
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
case TRANSACTION_setEmployeePin:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.employees.Employee _result = this.setEmployeePin(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteEmployee:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteEmployee(_arg0, _arg1);
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
case TRANSACTION_logout:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
this.logout(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_login:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
this.login(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addListener:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.employees.IEmployeeListener _arg0;
_arg0 = com.clover.sdk.v3.employees.IEmployeeListener.Stub.asInterface(data.readStrongBinder());
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
com.clover.sdk.v3.employees.IEmployeeListener _arg0;
_arg0 = com.clover.sdk.v3.employees.IEmployeeListener.Stub.asInterface(data.readStrongBinder());
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
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v3.employees.IEmployeeService
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
@Override public com.clover.sdk.v3.employees.Employee getActiveEmployee(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getActiveEmployee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.employees.Employee getEmployee(String id, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_getEmployee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
@Override public java.util.List<com.clover.sdk.v3.employees.Employee> getEmployees(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.employees.Employee> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getEmployees, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.employees.Employee.CREATOR);
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
@Override public com.clover.sdk.v3.employees.Employee createEmployee(com.clover.sdk.v3.employees.Employee employee, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((employee!=null)) {
_data.writeInt(1);
employee.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createEmployee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.employees.Employee updateEmployee(com.clover.sdk.v3.employees.Employee employee, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((employee!=null)) {
_data.writeInt(1);
employee.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateEmployee, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.employees.Employee setEmployeePin(String id, String pin, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.employees.Employee _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
_data.writeString(pin);
mRemote.transact(Stub.TRANSACTION_setEmployeePin, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(_reply);
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
@Override public void deleteEmployee(String id, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_deleteEmployee, _data, _reply, 0);
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
@Override public void logout(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_logout, _data, _reply, 0);
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
@Override public void login(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_login, _data, _reply, 0);
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
@Override public void addListener(com.clover.sdk.v3.employees.IEmployeeListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
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
@Override public void removeListener(com.clover.sdk.v3.employees.IEmployeeListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
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
}
static final int TRANSACTION_getActiveEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getEmployees = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_createEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_updateEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setEmployeePin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_deleteEmployee = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_logout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_login = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_addListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_removeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
}
public com.clover.sdk.v3.employees.Employee getActiveEmployee(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v3.employees.Employee getEmployee(String id, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public java.util.List<com.clover.sdk.v3.employees.Employee> getEmployees(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v3.employees.Employee createEmployee(com.clover.sdk.v3.employees.Employee employee, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v3.employees.Employee updateEmployee(com.clover.sdk.v3.employees.Employee employee, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v3.employees.Employee setEmployeePin(String id, String pin, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deleteEmployee(String id, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void logout(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void login(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void addListener(com.clover.sdk.v3.employees.IEmployeeListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void removeListener(com.clover.sdk.v3.employees.IEmployeeListener listener, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
