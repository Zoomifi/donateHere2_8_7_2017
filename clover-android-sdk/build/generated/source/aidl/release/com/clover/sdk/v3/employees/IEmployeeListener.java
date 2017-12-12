/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v3/employees/IEmployeeListener.aidl
 */
package com.clover.sdk.v3.employees;
/**
 * An interface for receiving events pertaining to an employee. Add a listener as follows,
 * <pre>
 * <code>
 * iEmployeeService.addListener(new IEmployeeListener.Stub() {
 *     {@literal @}Override
 *     public void onActiveEmployeeChanged(Merchant merchant) {
 *       // active employee has changed, use it here
 *     }
 * };
 * </code>
 * </pre>
 * If using {@link com.clover.sdk.v1.employee.EmployeeConnector} to interact with the employee
 * serivce, you may add listeners there.
 *
 * @see com.clover.sdk.v1.employee.IEmployeeService
 * @see com.clover.sdk.v1.employee.IEmployeeService#addListener(IEmployeeListener,ResultStatus)
 * @see com.clover.sdk.v1.employee.IEmployeeService#removeListener(IEmployeeListener,ResultStatus)
 * @see com.clover.sdk.v1.employee.EmployeeConnector
 */
public interface IEmployeeListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.employees.IEmployeeListener
{
private static final String DESCRIPTOR = "com.clover.sdk.v3.employees.IEmployeeListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.employees.IEmployeeListener interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.employees.IEmployeeListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.employees.IEmployeeListener))) {
return ((com.clover.sdk.v3.employees.IEmployeeListener)iin);
}
return new com.clover.sdk.v3.employees.IEmployeeListener.Stub.Proxy(obj);
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
case TRANSACTION_onActiveEmployeeChanged:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.employees.Employee _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.employees.Employee.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onActiveEmployeeChanged(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v3.employees.IEmployeeListener
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
@Override public void onActiveEmployeeChanged(com.clover.sdk.v3.employees.Employee employee) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((employee!=null)) {
_data.writeInt(1);
employee.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onActiveEmployeeChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onActiveEmployeeChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onActiveEmployeeChanged(com.clover.sdk.v3.employees.Employee employee) throws android.os.RemoteException;
}
