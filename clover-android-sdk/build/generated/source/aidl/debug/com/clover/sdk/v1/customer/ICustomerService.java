/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v1/customer/ICustomerService.aidl
 */
package com.clover.sdk.v1.customer;
public interface ICustomerService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v1.customer.ICustomerService
{
private static final String DESCRIPTOR = "com.clover.sdk.v1.customer.ICustomerService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v1.customer.ICustomerService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v1.customer.ICustomerService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v1.customer.ICustomerService))) {
return ((com.clover.sdk.v1.customer.ICustomerService)iin);
}
return new com.clover.sdk.v1.customer.ICustomerService.Stub.Proxy(obj);
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
case TRANSACTION_getCustomers:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v1.customer.Customer> _result = this.getCustomers(_arg0, _arg1);
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
case TRANSACTION_getCustomer:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.Customer _result = this.getCustomer(_arg0, _arg1);
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
case TRANSACTION_createCustomer:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.Customer _result = this.createCustomer(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setName:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
String _arg2;
_arg2 = data.readString();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
this.setName(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setMarketingAllowed:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.setMarketingAllowed(_arg0, _arg1, _arg2);
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
case TRANSACTION_addPhoneNumber:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.PhoneNumber _result = this.addPhoneNumber(_arg0, _arg1, _arg2);
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
case TRANSACTION_setPhoneNumber:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
String _arg2;
_arg2 = data.readString();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
this.setPhoneNumber(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deletePhoneNumber:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.deletePhoneNumber(_arg0, _arg1, _arg2);
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
case TRANSACTION_addEmailAddress:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.EmailAddress _result = this.addEmailAddress(_arg0, _arg1, _arg2);
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
case TRANSACTION_setEmailAddress:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
String _arg2;
_arg2 = data.readString();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
this.setEmailAddress(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteEmailAddress:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.deleteEmailAddress(_arg0, _arg1, _arg2);
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
case TRANSACTION_addAddress:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
String _arg2;
_arg2 = data.readString();
String _arg3;
_arg3 = data.readString();
String _arg4;
_arg4 = data.readString();
String _arg5;
_arg5 = data.readString();
String _arg6;
_arg6 = data.readString();
com.clover.sdk.v1.ResultStatus _arg7;
_arg7 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v1.customer.Address _result = this.addAddress(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg7!=null)) {
reply.writeInt(1);
_arg7.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setAddress:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
String _arg2;
_arg2 = data.readString();
String _arg3;
_arg3 = data.readString();
String _arg4;
_arg4 = data.readString();
String _arg5;
_arg5 = data.readString();
String _arg6;
_arg6 = data.readString();
String _arg7;
_arg7 = data.readString();
com.clover.sdk.v1.ResultStatus _arg8;
_arg8 = new com.clover.sdk.v1.ResultStatus();
this.setAddress(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
reply.writeNoException();
if ((_arg8!=null)) {
reply.writeInt(1);
_arg8.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteAddress:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.deleteAddress(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteCustomer:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteCustomer(_arg0, _arg1);
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
private static class Proxy implements com.clover.sdk.v1.customer.ICustomerService
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
@Override public java.util.List<com.clover.sdk.v1.customer.Customer> getCustomers(String query, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v1.customer.Customer> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(query);
mRemote.transact(Stub.TRANSACTION_getCustomers, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v1.customer.Customer.CREATOR);
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
@Override public com.clover.sdk.v1.customer.Customer getCustomer(String customerId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.Customer _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
mRemote.transact(Stub.TRANSACTION_getCustomer, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.Customer.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v1.customer.Customer createCustomer(String firstName, String lastName, boolean marketingAllowed, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.Customer _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(firstName);
_data.writeString(lastName);
_data.writeInt(((marketingAllowed)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_createCustomer, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.Customer.CREATOR.createFromParcel(_reply);
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
@Override public void setName(String customerId, String firstName, String lastName, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(firstName);
_data.writeString(lastName);
mRemote.transact(Stub.TRANSACTION_setName, _data, _reply, 0);
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
@Override public void setMarketingAllowed(String customerId, boolean marketingAllowed, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeInt(((marketingAllowed)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setMarketingAllowed, _data, _reply, 0);
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
@Override public com.clover.sdk.v1.customer.PhoneNumber addPhoneNumber(String customerId, String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.PhoneNumber _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(phoneNumber);
mRemote.transact(Stub.TRANSACTION_addPhoneNumber, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.PhoneNumber.CREATOR.createFromParcel(_reply);
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
@Override public void setPhoneNumber(String customerId, String phoneNumberId, String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(phoneNumberId);
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
@Override public void deletePhoneNumber(String customerId, String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(phoneNumber);
mRemote.transact(Stub.TRANSACTION_deletePhoneNumber, _data, _reply, 0);
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
@Override public com.clover.sdk.v1.customer.EmailAddress addEmailAddress(String customerId, String emailAddress, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.EmailAddress _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(emailAddress);
mRemote.transact(Stub.TRANSACTION_addEmailAddress, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.EmailAddress.CREATOR.createFromParcel(_reply);
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
@Override public void setEmailAddress(String customerId, String emailAddressId, String emailAddress, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(emailAddressId);
_data.writeString(emailAddress);
mRemote.transact(Stub.TRANSACTION_setEmailAddress, _data, _reply, 0);
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
@Override public void deleteEmailAddress(String customerId, String emailAddressId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(emailAddressId);
mRemote.transact(Stub.TRANSACTION_deleteEmailAddress, _data, _reply, 0);
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
@Override public com.clover.sdk.v1.customer.Address addAddress(String customerId, String address1, String address2, String address3, String city, String state, String zip, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v1.customer.Address _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(address1);
_data.writeString(address2);
_data.writeString(address3);
_data.writeString(city);
_data.writeString(state);
_data.writeString(zip);
mRemote.transact(Stub.TRANSACTION_addAddress, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v1.customer.Address.CREATOR.createFromParcel(_reply);
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
@Override public void setAddress(String customerId, String addressId, String address1, String address2, String address3, String city, String state, String zip, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(addressId);
_data.writeString(address1);
_data.writeString(address2);
_data.writeString(address3);
_data.writeString(city);
_data.writeString(state);
_data.writeString(zip);
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
@Override public void deleteAddress(String customerId, String addressId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
_data.writeString(addressId);
mRemote.transact(Stub.TRANSACTION_deleteAddress, _data, _reply, 0);
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
@Override public void deleteCustomer(String customerId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(customerId);
mRemote.transact(Stub.TRANSACTION_deleteCustomer, _data, _reply, 0);
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
static final int TRANSACTION_getCustomers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getCustomer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_createCustomer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_setName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setMarketingAllowed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_addPhoneNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_setPhoneNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_deletePhoneNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_addEmailAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_setEmailAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_deleteEmailAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_addAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_setAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_deleteAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_deleteCustomer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
}
public java.util.List<com.clover.sdk.v1.customer.Customer> getCustomers(String query, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.Customer getCustomer(String customerId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.Customer createCustomer(String firstName, String lastName, boolean marketingAllowed, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setName(String customerId, String firstName, String lastName, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setMarketingAllowed(String customerId, boolean marketingAllowed, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.PhoneNumber addPhoneNumber(String customerId, String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setPhoneNumber(String customerId, String phoneNumberId, String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deletePhoneNumber(String customerId, String phoneNumber, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.EmailAddress addEmailAddress(String customerId, String emailAddress, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setEmailAddress(String customerId, String emailAddressId, String emailAddress, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deleteEmailAddress(String customerId, String emailAddressId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public com.clover.sdk.v1.customer.Address addAddress(String customerId, String address1, String address2, String address3, String city, String state, String zip, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void setAddress(String customerId, String addressId, String address1, String address2, String address3, String city, String state, String zip, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deleteAddress(String customerId, String addressId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
public void deleteCustomer(String customerId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
