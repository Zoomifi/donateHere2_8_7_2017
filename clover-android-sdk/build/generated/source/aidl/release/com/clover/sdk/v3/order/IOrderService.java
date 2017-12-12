/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v3/order/IOrderService.aidl
 */
package com.clover.sdk.v3.order;
public interface IOrderService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.order.IOrderService
{
private static final String DESCRIPTOR = "com.clover.sdk.v3.order.IOrderService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.order.IOrderService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.order.IOrderService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.order.IOrderService))) {
return ((com.clover.sdk.v3.order.IOrderService)iin);
}
return new com.clover.sdk.v3.order.IOrderService.Stub.Proxy(obj);
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
case TRANSACTION_addOnOrderUpdatedListener:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.order.IOnOrderUpdateListener _arg0;
_arg0 = com.clover.sdk.v3.order.IOnOrderUpdateListener.Stub.asInterface(data.readStrongBinder());
this.addOnOrderUpdatedListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeOnOrderUpdatedListener:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.order.IOnOrderUpdateListener _arg0;
_arg0 = com.clover.sdk.v3.order.IOnOrderUpdateListener.Stub.asInterface(data.readStrongBinder());
this.removeOnOrderUpdatedListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getOrder:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.getOrder(_arg0, _arg1);
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
case TRANSACTION_getOrders:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<String> _arg0;
_arg0 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.order.Order> _result = this.getOrders(_arg0, _arg1);
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
case TRANSACTION_createOrder:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.order.Order _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.createOrder(_arg0, _arg1);
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
case TRANSACTION_updateOrder:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.order.Order _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.updateOrder(_arg0, _arg1);
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
case TRANSACTION_deleteOrder:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.deleteOrder(_arg0, _arg1);
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
case TRANSACTION_addServiceCharge:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addServiceCharge(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteServiceCharge:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteServiceCharge(_arg0, _arg1, _arg2);
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
case TRANSACTION_addFixedPriceLineItem:
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
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.addFixedPriceLineItem(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_addPerUnitLineItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
String _arg3;
_arg3 = data.readString();
String _arg4;
_arg4 = data.readString();
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.addPerUnitLineItem(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addVariablePriceLineItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
long _arg2;
_arg2 = data.readLong();
String _arg3;
_arg3 = data.readString();
String _arg4;
_arg4 = data.readString();
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.addVariablePriceLineItem(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addCustomLineItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.order.LineItem _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _arg2;
_arg2 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.addCustomLineItem(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_updateLineItems:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<com.clover.sdk.v3.order.LineItem> _arg1;
_arg1 = data.createTypedArrayList(com.clover.sdk.v3.order.LineItem.CREATOR);
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.order.LineItem> _result = this.updateLineItems(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeTypedList(_result);
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_deleteLineItems:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteLineItems(_arg0, _arg1, _arg2);
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
case TRANSACTION_copyLineItems:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
java.util.List<String> _arg2;
_arg2 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.order.LineItem> _result = this.copyLineItems(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeTypedList(_result);
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setLineItemNote:
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
com.clover.sdk.v3.order.Order _result = this.setLineItemNote(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_addLineItemModification:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v3.inventory.Modifier _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.inventory.Modifier.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addLineItemModification(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_deleteLineItemModifications:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
java.util.List<String> _arg2;
_arg2 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteLineItemModifications(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_exchangeItem:
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
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.LineItem _result = this.exchangeItem(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addDiscount:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.order.Discount _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.order.Discount.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addDiscount(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteDiscounts:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteDiscounts(_arg0, _arg1, _arg2);
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
case TRANSACTION_addLineItemDiscount:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v3.order.Discount _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.order.Discount.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addLineItemDiscount(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_deleteLineItemDiscounts:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
java.util.List<String> _arg2;
_arg2 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteLineItemDiscounts(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_addTip:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
long _arg2;
_arg2 = data.readLong();
boolean _arg3;
_arg3 = (0!=data.readInt());
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addTip(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_pay:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.pay.PaymentRequest _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.pay.PaymentRequest.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _arg2;
_arg2 = (0!=data.readInt());
String _arg3;
_arg3 = data.readString();
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Payment _result = this.pay(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_addPayment:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Payment _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Payment.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.util.List<com.clover.sdk.v3.order.LineItem> _arg2;
_arg2 = data.createTypedArrayList(com.clover.sdk.v3.order.LineItem.CREATOR);
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addPayment(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_voidPayment:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.voidPayment(_arg0, _arg1, _arg2);
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
case TRANSACTION_addCredit:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Credit _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Credit.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Credit _result = this.addCredit(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteCredit:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteCredit(_arg0, _arg1, _arg2);
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
case TRANSACTION_addRefund:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Refund _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Refund _result = this.addRefund(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteRefund:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.deleteRefund(_arg0, _arg1, _arg2);
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
case TRANSACTION_deleteOrderOnline:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.deleteOrderOnline(_arg0, _arg1);
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
case TRANSACTION_addBatchLineItemModifications:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v3.inventory.Modifier _arg2;
if ((0!=data.readInt())) {
_arg2 = com.clover.sdk.v3.inventory.Modifier.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg4;
_arg4 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addBatchLineItemModifications(_arg0, _arg1, _arg2, _arg3, _arg4);
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
case TRANSACTION_addBatchLineItemDiscounts:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
java.util.List<com.clover.sdk.v3.order.Discount> _arg2;
_arg2 = data.createTypedArrayList(com.clover.sdk.v3.order.Discount.CREATOR);
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.addBatchLineItemDiscounts(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_createLineItemsFrom:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
java.util.List<String> _arg2;
_arg2 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
java.util.Map _result = this.createLineItemsFrom(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeMap(_result);
if ((_arg3!=null)) {
reply.writeInt(1);
_arg3.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_fire:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
boolean _result = this.fire(_arg0, _arg1);
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
case TRANSACTION_updatePayment:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Payment _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Payment.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Payment _result = this.updatePayment(_arg0, _arg1, _arg2);
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
case TRANSACTION_voidPayment2:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
String _arg2;
_arg2 = data.readString();
com.clover.sdk.v3.order.VoidReason _arg3;
if ((0!=data.readInt())) {
_arg3 = com.clover.sdk.v3.order.VoidReason.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
String _arg4;
_arg4 = data.readString();
com.clover.sdk.v1.ResultStatus _arg5;
_arg5 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.voidPayment2(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg5!=null)) {
reply.writeInt(1);
_arg5.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_removePayment:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.order.Order _result = this.removePayment(_arg0, _arg1, _arg2);
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
case TRANSACTION_addRefundOffline:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Refund _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Refund _result = this.addRefundOffline(_arg0, _arg1, _arg2);
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
case TRANSACTION_refund:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.payments.Refund _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.payments.Refund _result = this.refund(_arg0, _arg1, _arg2);
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
case TRANSACTION_addOnOrderUpdatedListener2:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.order.IOnOrderUpdateListener2 _arg0;
_arg0 = com.clover.sdk.v3.order.IOnOrderUpdateListener2.Stub.asInterface(data.readStrongBinder());
this.addOnOrderUpdatedListener2(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeOnOrderUpdatedListener2:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.order.IOnOrderUpdateListener2 _arg0;
_arg0 = com.clover.sdk.v3.order.IOnOrderUpdateListener2.Stub.asInterface(data.readStrongBinder());
this.removeOnOrderUpdatedListener2(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.clover.sdk.v3.order.IOrderService
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
@Override public void addOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addOnOrderUpdatedListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeOnOrderUpdatedListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public com.clover.sdk.v3.order.Order getOrder(String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_getOrder, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public java.util.List<com.clover.sdk.v3.order.Order> getOrders(java.util.List<String> orderIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.order.Order> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringList(orderIds);
mRemote.transact(Stub.TRANSACTION_getOrders, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.order.Order.CREATOR);
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
@Override public com.clover.sdk.v3.order.Order createOrder(com.clover.sdk.v3.order.Order order, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((order!=null)) {
_data.writeInt(1);
order.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createOrder, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order updateOrder(com.clover.sdk.v3.order.Order order, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((order!=null)) {
_data.writeInt(1);
order.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateOrder, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public boolean deleteOrder(String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_deleteOrder, _data, _reply, 0);
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
@Override public com.clover.sdk.v3.order.Order addServiceCharge(String orderId, String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(serviceChargeId);
mRemote.transact(Stub.TRANSACTION_addServiceCharge, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order deleteServiceCharge(String orderId, String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(serviceChargeId);
mRemote.transact(Stub.TRANSACTION_deleteServiceCharge, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItem addFixedPriceLineItem(String orderId, String itemId, String binName, String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeString(binName);
_data.writeString(userData);
mRemote.transact(Stub.TRANSACTION_addFixedPriceLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItem addPerUnitLineItem(String orderId, String itemId, int unitQuantity, String binName, String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeInt(unitQuantity);
_data.writeString(binName);
_data.writeString(userData);
mRemote.transact(Stub.TRANSACTION_addPerUnitLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItem addVariablePriceLineItem(String orderId, String itemId, long price, String binName, String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(itemId);
_data.writeLong(price);
_data.writeString(binName);
_data.writeString(userData);
mRemote.transact(Stub.TRANSACTION_addVariablePriceLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItem addCustomLineItem(String orderId, com.clover.sdk.v3.order.LineItem lineItem, boolean isTaxable, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((lineItem!=null)) {
_data.writeInt(1);
lineItem.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((isTaxable)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_addCustomLineItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
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
@Override public java.util.List<com.clover.sdk.v3.order.LineItem> updateLineItems(String orderId, java.util.List<com.clover.sdk.v3.order.LineItem> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.order.LineItem> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeTypedList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_updateLineItems, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.order.LineItem.CREATOR);
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
@Override public com.clover.sdk.v3.order.Order deleteLineItems(String orderId, java.util.List<String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_deleteLineItems, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public java.util.List<com.clover.sdk.v3.order.LineItem> copyLineItems(String sourceOrderId, String destinationOrderId, java.util.List<String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.order.LineItem> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
_data.writeString(destinationOrderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_copyLineItems, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.order.LineItem.CREATOR);
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
@Override public com.clover.sdk.v3.order.Order setLineItemNote(String orderId, String lineItemId, String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
_data.writeString(note);
mRemote.transact(Stub.TRANSACTION_setLineItemNote, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order addLineItemModification(String orderId, String lineItemId, com.clover.sdk.v3.inventory.Modifier modifier, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
if ((modifier!=null)) {
_data.writeInt(1);
modifier.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addLineItemModification, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order deleteLineItemModifications(String orderId, String lineItemId, java.util.List<String> modificationIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
_data.writeStringList(modificationIds);
mRemote.transact(Stub.TRANSACTION_deleteLineItemModifications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.LineItem exchangeItem(String orderId, String oldLineItemId, String itemId, String binName, String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.LineItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(oldLineItemId);
_data.writeString(itemId);
_data.writeString(binName);
_data.writeString(userData);
mRemote.transact(Stub.TRANSACTION_exchangeItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.LineItem.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order addDiscount(String orderId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((discount!=null)) {
_data.writeInt(1);
discount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addDiscount, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order deleteDiscounts(String orderId, java.util.List<String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(discountIds);
mRemote.transact(Stub.TRANSACTION_deleteDiscounts, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order addLineItemDiscount(String orderId, String lineItemId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
if ((discount!=null)) {
_data.writeInt(1);
discount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addLineItemDiscount, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order deleteLineItemDiscounts(String orderId, String lineItemId, java.util.List<String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(lineItemId);
_data.writeStringList(discountIds);
mRemote.transact(Stub.TRANSACTION_deleteLineItemDiscounts, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order addTip(String orderId, String paymentId, long amount, boolean online, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
_data.writeLong(amount);
_data.writeInt(((online)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_addTip, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.Payment pay(String orderId, com.clover.sdk.v3.pay.PaymentRequest paymentRequest, boolean isAllowOffline, String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Payment _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((paymentRequest!=null)) {
_data.writeInt(1);
paymentRequest.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((isAllowOffline)?(1):(0)));
_data.writeString(note);
mRemote.transact(Stub.TRANSACTION_pay, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Payment.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order addPayment(String orderId, com.clover.sdk.v3.payments.Payment payment, java.util.List<com.clover.sdk.v3.order.LineItem> lineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeTypedList(lineItems);
mRemote.transact(Stub.TRANSACTION_addPayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order voidPayment(String orderId, String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
mRemote.transact(Stub.TRANSACTION_voidPayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.Credit addCredit(String orderId, com.clover.sdk.v3.payments.Credit payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Credit _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addCredit, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Credit.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order deleteCredit(String orderId, String creditId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(creditId);
mRemote.transact(Stub.TRANSACTION_deleteCredit, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.Refund addRefund(String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Refund _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order deleteRefund(String orderId, String refundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(refundId);
mRemote.transact(Stub.TRANSACTION_deleteRefund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public boolean deleteOrderOnline(String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
mRemote.transact(Stub.TRANSACTION_deleteOrderOnline, _data, _reply, 0);
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
@Override public com.clover.sdk.v3.order.Order addBatchLineItemModifications(String orderId, java.util.List<String> lineItemIds, com.clover.sdk.v3.inventory.Modifier modifier, int quantity, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
if ((modifier!=null)) {
_data.writeInt(1);
modifier.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(quantity);
mRemote.transact(Stub.TRANSACTION_addBatchLineItemModifications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order addBatchLineItemDiscounts(String orderId, java.util.List<String> lineItemIds, java.util.List<com.clover.sdk.v3.order.Discount> discounts, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeStringList(lineItemIds);
_data.writeTypedList(discounts);
mRemote.transact(Stub.TRANSACTION_addBatchLineItemDiscounts, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public java.util.Map createLineItemsFrom(String sourceOrderId, String destinationOrderId, java.util.List<String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.Map _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
_data.writeString(destinationOrderId);
_data.writeStringList(lineItemIds);
mRemote.transact(Stub.TRANSACTION_createLineItemsFrom, _data, _reply, 0);
_reply.readException();
ClassLoader cl = (ClassLoader)this.getClass().getClassLoader();
_result = _reply.readHashMap(cl);
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
@Override public boolean fire(String sourceOrderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sourceOrderId);
mRemote.transact(Stub.TRANSACTION_fire, _data, _reply, 0);
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
@Override public com.clover.sdk.v3.payments.Payment updatePayment(String orderId, com.clover.sdk.v3.payments.Payment payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Payment _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updatePayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Payment.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order voidPayment2(String orderId, String paymentId, String iccContainer, com.clover.sdk.v3.order.VoidReason reason, String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
_data.writeString(iccContainer);
if ((reason!=null)) {
_data.writeInt(1);
reason.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(source);
mRemote.transact(Stub.TRANSACTION_voidPayment2, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.order.Order removePayment(String orderId, String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.order.Order _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
_data.writeString(paymentId);
mRemote.transact(Stub.TRANSACTION_removePayment, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.order.Order.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.Refund addRefundOffline(String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Refund _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addRefundOffline, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(_reply);
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
@Override public com.clover.sdk.v3.payments.Refund refund(String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.payments.Refund _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(orderId);
if ((payment!=null)) {
_data.writeInt(1);
payment.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_refund, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.payments.Refund.CREATOR.createFromParcel(_reply);
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
@Override public void addOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addOnOrderUpdatedListener2, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeOnOrderUpdatedListener2, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_addOnOrderUpdatedListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_removeOnOrderUpdatedListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getOrder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getOrders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_createOrder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_updateOrder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_deleteOrder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_addServiceCharge = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_deleteServiceCharge = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_addFixedPriceLineItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_addPerUnitLineItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_addVariablePriceLineItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_addCustomLineItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_updateLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_deleteLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_copyLineItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_setLineItemNote = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_addLineItemModification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_deleteLineItemModifications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_exchangeItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_addDiscount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_deleteDiscounts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_addLineItemDiscount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_deleteLineItemDiscounts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_addTip = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_pay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_addPayment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_voidPayment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_addCredit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_deleteCredit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_addRefund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_deleteRefund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_deleteOrderOnline = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_addBatchLineItemModifications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_addBatchLineItemDiscounts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_createLineItemsFrom = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_fire = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_updatePayment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_voidPayment2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_removePayment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_addRefundOffline = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_refund = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_addOnOrderUpdatedListener2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_removeOnOrderUpdatedListener2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
}
public void addOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException;
public void removeOnOrderUpdatedListener(com.clover.sdk.v3.order.IOnOrderUpdateListener listener) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order getOrder(String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public java.util.List<com.clover.sdk.v3.order.Order> getOrders(java.util.List<String> orderIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order createOrder(com.clover.sdk.v3.order.Order order, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order updateOrder(com.clover.sdk.v3.order.Order order, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public boolean deleteOrder(String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addServiceCharge(String orderId, String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteServiceCharge(String orderId, String serviceChargeId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItem addFixedPriceLineItem(String orderId, String itemId, String binName, String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItem addPerUnitLineItem(String orderId, String itemId, int unitQuantity, String binName, String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItem addVariablePriceLineItem(String orderId, String itemId, long price, String binName, String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItem addCustomLineItem(String orderId, com.clover.sdk.v3.order.LineItem lineItem, boolean isTaxable, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public java.util.List<com.clover.sdk.v3.order.LineItem> updateLineItems(String orderId, java.util.List<com.clover.sdk.v3.order.LineItem> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteLineItems(String orderId, java.util.List<String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public java.util.List<com.clover.sdk.v3.order.LineItem> copyLineItems(String sourceOrderId, String destinationOrderId, java.util.List<String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order setLineItemNote(String orderId, String lineItemId, String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addLineItemModification(String orderId, String lineItemId, com.clover.sdk.v3.inventory.Modifier modifier, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteLineItemModifications(String orderId, String lineItemId, java.util.List<String> modificationIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.LineItem exchangeItem(String orderId, String oldLineItemId, String itemId, String binName, String userData, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addDiscount(String orderId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteDiscounts(String orderId, java.util.List<String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addLineItemDiscount(String orderId, String lineItemId, com.clover.sdk.v3.order.Discount discount, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteLineItemDiscounts(String orderId, String lineItemId, java.util.List<String> discountIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addTip(String orderId, String paymentId, long amount, boolean online, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.Payment pay(String orderId, com.clover.sdk.v3.pay.PaymentRequest paymentRequest, boolean isAllowOffline, String note, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addPayment(String orderId, com.clover.sdk.v3.payments.Payment payment, java.util.List<com.clover.sdk.v3.order.LineItem> lineItems, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order voidPayment(String orderId, String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.Credit addCredit(String orderId, com.clover.sdk.v3.payments.Credit payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteCredit(String orderId, String creditId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.Refund addRefund(String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order deleteRefund(String orderId, String refundId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public boolean deleteOrderOnline(String orderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addBatchLineItemModifications(String orderId, java.util.List<String> lineItemIds, com.clover.sdk.v3.inventory.Modifier modifier, int quantity, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order addBatchLineItemDiscounts(String orderId, java.util.List<String> lineItemIds, java.util.List<com.clover.sdk.v3.order.Discount> discounts, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public java.util.Map createLineItemsFrom(String sourceOrderId, String destinationOrderId, java.util.List<String> lineItemIds, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public boolean fire(String sourceOrderId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.Payment updatePayment(String orderId, com.clover.sdk.v3.payments.Payment payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order voidPayment2(String orderId, String paymentId, String iccContainer, com.clover.sdk.v3.order.VoidReason reason, String source, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.order.Order removePayment(String orderId, String paymentId, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.Refund addRefundOffline(String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public com.clover.sdk.v3.payments.Refund refund(String orderId, com.clover.sdk.v3.payments.Refund payment, com.clover.sdk.v1.ResultStatus status) throws android.os.RemoteException;
public void addOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException;
public void removeOnOrderUpdatedListener2(com.clover.sdk.v3.order.IOnOrderUpdateListener2 listener) throws android.os.RemoteException;
}
