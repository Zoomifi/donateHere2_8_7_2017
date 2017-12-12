/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v3/order/IOnOrderUpdateListener2.aidl
 */
package com.clover.sdk.v3.order;
public interface IOnOrderUpdateListener2 extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.order.IOnOrderUpdateListener2
{
private static final String DESCRIPTOR = "com.clover.sdk.v3.order.IOnOrderUpdateListener2";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.order.IOnOrderUpdateListener2 interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.order.IOnOrderUpdateListener2 asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.order.IOnOrderUpdateListener2))) {
return ((com.clover.sdk.v3.order.IOnOrderUpdateListener2)iin);
}
return new com.clover.sdk.v3.order.IOnOrderUpdateListener2.Stub.Proxy(obj);
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
case TRANSACTION_onOrderCreated:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
this.onOrderCreated(_arg0);
return true;
}
case TRANSACTION_onOrderDeleted:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
this.onOrderDeleted(_arg0);
return true;
}
case TRANSACTION_onOrderDiscountAdded:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
this.onOrderDiscountAdded(_arg0, _arg1);
return true;
}
case TRANSACTION_onOrderDiscountsDeleted:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
this.onOrderDiscountsDeleted(_arg0, _arg1);
return true;
}
case TRANSACTION_onLineItemsAdded:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
this.onLineItemsAdded(_arg0, _arg1);
return true;
}
case TRANSACTION_onLineItemsUpdated:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
this.onLineItemsUpdated(_arg0, _arg1);
return true;
}
case TRANSACTION_onLineItemsDeleted:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
this.onLineItemsDeleted(_arg0, _arg1);
return true;
}
case TRANSACTION_onLineItemModificationsAdded:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
java.util.List<String> _arg2;
_arg2 = data.createStringArrayList();
this.onLineItemModificationsAdded(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_onLineItemDiscountsAdded:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
java.util.List<String> _arg2;
_arg2 = data.createStringArrayList();
this.onLineItemDiscountsAdded(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_onLineItemExchanged:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
String _arg2;
_arg2 = data.readString();
this.onLineItemExchanged(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_onPaymentProcessed:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
this.onPaymentProcessed(_arg0, _arg1);
return true;
}
case TRANSACTION_onRefundProcessed:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
this.onRefundProcessed(_arg0, _arg1);
return true;
}
case TRANSACTION_onCreditProcessed:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
this.onCreditProcessed(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v3.order.IOnOrderUpdateListener2
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
@Override public void onOrderCreated(String orderId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_onOrderCreated, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onOrderDeleted(String orderId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_onOrderDeleted, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onOrderDiscountAdded(String orderId, String discountId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(discountId);
mRemote.transact(Stub.TRANSACTION_onOrderDiscountAdded, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onOrderDiscountsDeleted(String orderId, java.util.List<String> discountIds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(discountIds);
mRemote.transact(Stub.TRANSACTION_onOrderDiscountsDeleted, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onLineItemsAdded(String orderId, java.util.List<String> lineItemIds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_onLineItemsAdded, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onLineItemsUpdated(String orderId, java.util.List<String> lineItemIds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_onLineItemsUpdated, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onLineItemsDeleted(String orderId, java.util.List<String> lineItemIds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_onLineItemsDeleted, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onLineItemModificationsAdded(String orderId, java.util.List<String> lineItemIds, java.util.List<String> modificationIds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
_data.writeStringList(modificationIds);
mRemote.transact(Stub.TRANSACTION_onLineItemModificationsAdded, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onLineItemDiscountsAdded(String orderId, java.util.List<String> lineItemIds, java.util.List<String> discountIds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
_data.writeStringList(discountIds);
mRemote.transact(Stub.TRANSACTION_onLineItemDiscountsAdded, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onLineItemExchanged(String orderId, String oldLineItemId, String newLineItemId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(oldLineItemId);
_data.writeString(newLineItemId);
mRemote.transact(Stub.TRANSACTION_onLineItemExchanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onPaymentProcessed(String orderId, String paymentId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
mRemote.transact(Stub.TRANSACTION_onPaymentProcessed, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onRefundProcessed(String orderId, String refundId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(refundId);
mRemote.transact(Stub.TRANSACTION_onRefundProcessed, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
@Override public void onCreditProcessed(String orderId, String creditId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(creditId);
mRemote.transact(Stub.TRANSACTION_onCreditProcessed, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onOrderUpdated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onOrderCreated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onOrderDeleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onOrderDiscountAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onOrderDiscountsDeleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_onLineItemsAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_onLineItemsUpdated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_onLineItemsDeleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_onLineItemModificationsAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_onLineItemDiscountsAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_onLineItemExchanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_onPaymentProcessed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_onRefundProcessed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_onCreditProcessed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
}
public void onOrderUpdated(String orderId, boolean selfChange) throws android.os.RemoteException;
public void onOrderCreated(String orderId) throws android.os.RemoteException;
public void onOrderDeleted(String orderId) throws android.os.RemoteException;
public void onOrderDiscountAdded(String orderId, String discountId) throws android.os.RemoteException;
public void onOrderDiscountsDeleted(String orderId, java.util.List<String> discountIds) throws android.os.RemoteException;
public void onLineItemsAdded(String orderId, java.util.List<String> lineItemIds) throws android.os.RemoteException;
public void onLineItemsUpdated(String orderId, java.util.List<String> lineItemIds) throws android.os.RemoteException;
public void onLineItemsDeleted(String orderId, java.util.List<String> lineItemIds) throws android.os.RemoteException;
public void onLineItemModificationsAdded(String orderId, java.util.List<String> lineItemIds, java.util.List<String> modificationIds) throws android.os.RemoteException;
public void onLineItemDiscountsAdded(String orderId, java.util.List<String> lineItemIds, java.util.List<String> discountIds) throws android.os.RemoteException;
public void onLineItemExchanged(String orderId, String oldLineItemId, String newLineItemId) throws android.os.RemoteException;
public void onPaymentProcessed(String orderId, String paymentId) throws android.os.RemoteException;
public void onRefundProcessed(String orderId, String refundId) throws android.os.RemoteException;
public void onCreditProcessed(String orderId, String creditId) throws android.os.RemoteException;
}
