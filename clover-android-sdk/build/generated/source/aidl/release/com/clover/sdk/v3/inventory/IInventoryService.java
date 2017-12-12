/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/CristMac/Google Drive/donate_here_josh/clover-android-sdk/src/main/aidl/com/clover/sdk/v3/inventory/IInventoryService.aidl
 */
package com.clover.sdk.v3.inventory;
public interface IInventoryService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.clover.sdk.v3.inventory.IInventoryService
{
private static final String DESCRIPTOR = "com.clover.sdk.v3.inventory.IInventoryService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.clover.sdk.v3.inventory.IInventoryService interface,
 * generating a proxy if needed.
 */
public static com.clover.sdk.v3.inventory.IInventoryService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.clover.sdk.v3.inventory.IInventoryService))) {
return ((com.clover.sdk.v3.inventory.IInventoryService)iin);
}
return new com.clover.sdk.v3.inventory.IInventoryService.Stub.Proxy(obj);
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
case TRANSACTION_getItems:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Item> _result = this.getItems(_arg0);
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
case TRANSACTION_getItemsWithCategories:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Item> _result = this.getItemsWithCategories(_arg0);
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
case TRANSACTION_getItemIds:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<String> _result = this.getItemIds(_arg0);
reply.writeNoException();
reply.writeStringList(_result);
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Item _result = this.getItem(_arg0, _arg1);
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
case TRANSACTION_getItemWithCategories:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Item _result = this.getItemWithCategories(_arg0, _arg1);
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
case TRANSACTION_createItem:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Item _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Item.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Item _result = this.createItem(_arg0, _arg1);
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
case TRANSACTION_updateItem:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Item _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Item.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateItem(_arg0, _arg1);
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
case TRANSACTION_deleteItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteItem(_arg0, _arg1);
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
case TRANSACTION_getCategories:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Category> _result = this.getCategories(_arg0);
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
case TRANSACTION_createCategory:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Category _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Category.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Category _result = this.createCategory(_arg0, _arg1);
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
case TRANSACTION_updateCategory:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Category _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Category.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateCategory(_arg0, _arg1);
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
case TRANSACTION_deleteCategory:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteCategory(_arg0, _arg1);
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
case TRANSACTION_addItemToCategory:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.addItemToCategory(_arg0, _arg1, _arg2);
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
case TRANSACTION_removeItemFromCategory:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.removeItemFromCategory(_arg0, _arg1, _arg2);
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
case TRANSACTION_moveItemInCategoryLayout:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
com.clover.sdk.v1.ResultStatus _arg3;
_arg3 = new com.clover.sdk.v1.ResultStatus();
this.moveItemInCategoryLayout(_arg0, _arg1, _arg2, _arg3);
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
case TRANSACTION_getModifierGroups:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.ModifierGroup> _result = this.getModifierGroups(_arg0);
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
case TRANSACTION_createModifierGroup:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.ModifierGroup _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.ModifierGroup.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.ModifierGroup _result = this.createModifierGroup(_arg0, _arg1);
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
case TRANSACTION_updateModifierGroup:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.ModifierGroup _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.ModifierGroup.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateModifierGroup(_arg0, _arg1);
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
case TRANSACTION_deleteModifierGroup:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteModifierGroup(_arg0, _arg1);
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
case TRANSACTION_assignModifierGroupToItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.assignModifierGroupToItem(_arg0, _arg1, _arg2);
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
case TRANSACTION_removeModifierGroupFromItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
String _arg1;
_arg1 = data.readString();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.removeModifierGroupFromItem(_arg0, _arg1, _arg2);
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
case TRANSACTION_getModifiers:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Modifier> _result = this.getModifiers(_arg0, _arg1);
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
case TRANSACTION_createModifier:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v3.inventory.Modifier _arg1;
if ((0!=data.readInt())) {
_arg1 = com.clover.sdk.v3.inventory.Modifier.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Modifier _result = this.createModifier(_arg0, _arg1, _arg2);
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
case TRANSACTION_updateModifier:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Modifier _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Modifier.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateModifier(_arg0, _arg1);
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
case TRANSACTION_deleteModifier:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteModifier(_arg0, _arg1);
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
case TRANSACTION_getTaxRatesForItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.TaxRate> _result = this.getTaxRatesForItem(_arg0, _arg1);
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
case TRANSACTION_assignTaxRatesToItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.assignTaxRatesToItem(_arg0, _arg1, _arg2);
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
case TRANSACTION_removeTaxRatesFromItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.removeTaxRatesFromItem(_arg0, _arg1, _arg2);
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
case TRANSACTION_getTaxRates:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.TaxRate> _result = this.getTaxRates(_arg0);
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
case TRANSACTION_getTaxRate:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.TaxRate _result = this.getTaxRate(_arg0, _arg1);
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
case TRANSACTION_createTaxRate:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.TaxRate _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.TaxRate.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.TaxRate _result = this.createTaxRate(_arg0, _arg1);
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
case TRANSACTION_updateTaxRate:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.TaxRate _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.TaxRate.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateTaxRate(_arg0, _arg1);
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
case TRANSACTION_deleteTaxRate:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteTaxRate(_arg0, _arg1);
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
case TRANSACTION_getDiscounts:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Discount> _result = this.getDiscounts(_arg0);
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
case TRANSACTION_getDiscount:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Discount _result = this.getDiscount(_arg0, _arg1);
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
case TRANSACTION_createDiscount:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Discount _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Discount.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Discount _result = this.createDiscount(_arg0, _arg1);
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
case TRANSACTION_updateDiscount:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Discount _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Discount.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateDiscount(_arg0, _arg1);
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
case TRANSACTION_deleteDiscount:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteDiscount(_arg0, _arg1);
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
case TRANSACTION_getModifierGroupsForItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.ModifierGroup> _result = this.getModifierGroupsForItem(_arg0, _arg1);
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
case TRANSACTION_getTags:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Tag> _result = this.getTags(_arg0);
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
case TRANSACTION_getTag:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Tag _result = this.getTag(_arg0, _arg1);
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
case TRANSACTION_createTag:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Tag _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Tag.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Tag _result = this.createTag(_arg0, _arg1);
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
case TRANSACTION_updateTag:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Tag _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Tag.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateTag(_arg0, _arg1);
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
case TRANSACTION_deleteTag:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteTag(_arg0, _arg1);
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
case TRANSACTION_getTagsForItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Tag> _result = this.getTagsForItem(_arg0, _arg1);
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
case TRANSACTION_assignTagsToItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.assignTagsToItem(_arg0, _arg1, _arg2);
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
case TRANSACTION_removeTagsFromItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.removeTagsFromItem(_arg0, _arg1, _arg2);
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
case TRANSACTION_getTagsForPrinter:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Tag> _result = this.getTagsForPrinter(_arg0, _arg1);
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
case TRANSACTION_assignTagsToPrinter:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.assignTagsToPrinter(_arg0, _arg1, _arg2);
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
case TRANSACTION_removeTagsFromPrinter:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.removeTagsFromPrinter(_arg0, _arg1, _arg2);
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
case TRANSACTION_assignItemsToTag:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.assignItemsToTag(_arg0, _arg1, _arg2);
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
case TRANSACTION_removeItemsFromTag:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.removeItemsFromTag(_arg0, _arg1, _arg2);
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
case TRANSACTION_updateModifierSortOrder:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.updateModifierSortOrder(_arg0, _arg1, _arg2);
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
case TRANSACTION_updateItemStock:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
long _arg1;
_arg1 = data.readLong();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.updateItemStock(_arg0, _arg1, _arg2);
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
case TRANSACTION_removeItemStock:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.removeItemStock(_arg0, _arg1);
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
case TRANSACTION_getAttributes:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Attribute> _result = this.getAttributes(_arg0);
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
case TRANSACTION_getAttribute:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Attribute _result = this.getAttribute(_arg0, _arg1);
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
case TRANSACTION_createAttribute:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Attribute _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Attribute.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Attribute _result = this.createAttribute(_arg0, _arg1);
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
case TRANSACTION_updateAttribute:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Attribute _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Attribute.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateAttribute(_arg0, _arg1);
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
case TRANSACTION_deleteAttribute:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteAttribute(_arg0, _arg1);
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
case TRANSACTION_getOptions:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v1.ResultStatus _arg0;
_arg0 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Option> _result = this.getOptions(_arg0);
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
case TRANSACTION_getOption:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Option _result = this.getOption(_arg0, _arg1);
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
case TRANSACTION_createOption:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Option _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Option.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.Option _result = this.createOption(_arg0, _arg1);
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
case TRANSACTION_updateOption:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.Option _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.Option.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateOption(_arg0, _arg1);
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
case TRANSACTION_deleteOption:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteOption(_arg0, _arg1);
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
case TRANSACTION_getOptionsForItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
java.util.List<com.clover.sdk.v3.inventory.Option> _result = this.getOptionsForItem(_arg0, _arg1);
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
case TRANSACTION_assignOptionsToItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.assignOptionsToItem(_arg0, _arg1, _arg2);
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
case TRANSACTION_removeOptionsFromItem:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
java.util.List<String> _arg1;
_arg1 = data.createStringArrayList();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.removeOptionsFromItem(_arg0, _arg1, _arg2);
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
case TRANSACTION_getItemGroup:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.ItemGroup _result = this.getItemGroup(_arg0, _arg1);
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
case TRANSACTION_createItemGroup:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.ItemGroup _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.ItemGroup.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
com.clover.sdk.v3.inventory.ItemGroup _result = this.createItemGroup(_arg0, _arg1);
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
case TRANSACTION_updateItemGroup:
{
data.enforceInterface(DESCRIPTOR);
com.clover.sdk.v3.inventory.ItemGroup _arg0;
if ((0!=data.readInt())) {
_arg0 = com.clover.sdk.v3.inventory.ItemGroup.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.updateItemGroup(_arg0, _arg1);
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
case TRANSACTION_deleteItemGroup:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
com.clover.sdk.v1.ResultStatus _arg1;
_arg1 = new com.clover.sdk.v1.ResultStatus();
this.deleteItemGroup(_arg0, _arg1);
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
case TRANSACTION_updateItemStockQuantity:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
double _arg1;
_arg1 = data.readDouble();
com.clover.sdk.v1.ResultStatus _arg2;
_arg2 = new com.clover.sdk.v1.ResultStatus();
this.updateItemStockQuantity(_arg0, _arg1, _arg2);
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
private static class Proxy implements com.clover.sdk.v3.inventory.IInventoryService
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
   *  Retrieves all items from the local database; this will return a maximum of 500 items before
   *  returning a fault.  For iterating through the entire item database efficiently, use the
   *  content provider described by {@link com.clover.sdk.v3.inventory.InventoryContract}
   *  or get a list of item IDs via getItemIds() and retrieve individual items through the getItem() call.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Item> getItems(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Item> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getItems, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Item.CREATOR);
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
/**
   * Same as getItems() but returns the list of categories to which each item belongs.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Item> getItemsWithCategories(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Item> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getItemsWithCategories, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Item.CREATOR);
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
/**
   *  Retrieves all item IDs from the local database; use this in place of getItems() when the
   *  inventory database is large, and make subsequent calls to getItem() for the full item as necessary.
   */
@Override public java.util.List<String> getItemIds(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<String> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getItemIds, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArrayList();
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
/**
   *  Retrieve an individual item using the item ID. If the item is not in the local database, an
   *  attempt will be made to fetch the item from the server.
   */
@Override public com.clover.sdk.v3.inventory.Item getItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Item _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_getItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Item.CREATOR.createFromParcel(_reply);
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
/**
   * Same as getItem() but also includes the list of categories to which the item belongs.
   */
@Override public com.clover.sdk.v3.inventory.Item getItemWithCategories(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Item _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_getItemWithCategories, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Item.CREATOR.createFromParcel(_reply);
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
/**
   *  Inserts a new item into the database. If the client is in offline mode, the item will be inserted
   *  into the local cache and a request to create the new item on the server will be queued until
   *  the client is online again.  Returns the newly created item as it exists in the local content
   *  provider/cache.
   */
@Override public com.clover.sdk.v3.inventory.Item createItem(com.clover.sdk.v3.inventory.Item item, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Item _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((item!=null)) {
_data.writeInt(1);
item.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createItem, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Item.CREATOR.createFromParcel(_reply);
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
/**
   *  Updates an existing item.
   *  TODO: Describe what parts of the item are updated through this method
   */
@Override public void updateItem(com.clover.sdk.v3.inventory.Item item, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((item!=null)) {
_data.writeInt(1);
item.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateItem, _data, _reply, 0);
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
/**
   *  Deletes an existing item.
   */
@Override public void deleteItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_deleteItem, _data, _reply, 0);
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
/**
   * Retrieve the list of categories.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Category> getCategories(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Category> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCategories, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Category.CREATOR);
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
/**
   * Adds a new category.
   */
@Override public com.clover.sdk.v3.inventory.Category createCategory(com.clover.sdk.v3.inventory.Category category, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Category _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((category!=null)) {
_data.writeInt(1);
category.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createCategory, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Category.CREATOR.createFromParcel(_reply);
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
/**
   * Updates an existing category.
   */
@Override public void updateCategory(com.clover.sdk.v3.inventory.Category category, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((category!=null)) {
_data.writeInt(1);
category.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateCategory, _data, _reply, 0);
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
/**
   * Deletes an existing category.
   */
@Override public void deleteCategory(String categoryId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(categoryId);
mRemote.transact(Stub.TRANSACTION_deleteCategory, _data, _reply, 0);
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
/**
   * Adds an item to a category.
   */
@Override public void addItemToCategory(String itemId, String categoryId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeString(categoryId);
mRemote.transact(Stub.TRANSACTION_addItemToCategory, _data, _reply, 0);
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
/**
   * Removes an item from a category.
   */
@Override public void removeItemFromCategory(String itemId, String categoryId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeString(categoryId);
mRemote.transact(Stub.TRANSACTION_removeItemFromCategory, _data, _reply, 0);
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
/**
   * Moves an item's position within an existing category. If 'direction' is negative, the item is moved to the left.
   */
@Override public void moveItemInCategoryLayout(String itemId, String categoryId, int direction, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeString(categoryId);
_data.writeInt(direction);
mRemote.transact(Stub.TRANSACTION_moveItemInCategoryLayout, _data, _reply, 0);
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
/**
   * Retrieve the list of modifier groups.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.ModifierGroup> getModifierGroups(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.ModifierGroup> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getModifierGroups, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.ModifierGroup.CREATOR);
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
/**
   * Adds a new modifier group.
   */
@Override public com.clover.sdk.v3.inventory.ModifierGroup createModifierGroup(com.clover.sdk.v3.inventory.ModifierGroup group, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.ModifierGroup _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((group!=null)) {
_data.writeInt(1);
group.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createModifierGroup, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.ModifierGroup.CREATOR.createFromParcel(_reply);
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
/**
   * Updates an existing modifier group.
   */
@Override public void updateModifierGroup(com.clover.sdk.v3.inventory.ModifierGroup group, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((group!=null)) {
_data.writeInt(1);
group.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateModifierGroup, _data, _reply, 0);
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
/**
   * Deletes an existing modifier group.
   */
@Override public void deleteModifierGroup(String groupId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(groupId);
mRemote.transact(Stub.TRANSACTION_deleteModifierGroup, _data, _reply, 0);
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
/**
   * Associates a modifier group with an item.
   */
@Override public void assignModifierGroupToItem(String modifierGroupId, String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(modifierGroupId);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_assignModifierGroupToItem, _data, _reply, 0);
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
/**
   * Removes a modifier group association from an item.
   */
@Override public void removeModifierGroupFromItem(String modifierGroupId, String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(modifierGroupId);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_removeModifierGroupFromItem, _data, _reply, 0);
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
/**
   * Retrieve the list of modifiers belonging to a modifier group.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Modifier> getModifiers(String modifierGroupId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Modifier> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(modifierGroupId);
mRemote.transact(Stub.TRANSACTION_getModifiers, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Modifier.CREATOR);
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
/**
   * Adds a new modifier.
   */
@Override public com.clover.sdk.v3.inventory.Modifier createModifier(String modifierGroupId, com.clover.sdk.v3.inventory.Modifier modifier, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Modifier _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(modifierGroupId);
if ((modifier!=null)) {
_data.writeInt(1);
modifier.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createModifier, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Modifier.CREATOR.createFromParcel(_reply);
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
/**
   * Updates an existing modifier.
   */
@Override public void updateModifier(com.clover.sdk.v3.inventory.Modifier modifier, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((modifier!=null)) {
_data.writeInt(1);
modifier.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateModifier, _data, _reply, 0);
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
/**
   * Deletes an existing modifier.
   */
@Override public void deleteModifier(String modifierId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(modifierId);
mRemote.transact(Stub.TRANSACTION_deleteModifier, _data, _reply, 0);
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
/**
   * Retrieve the list of tax rates for an item.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.TaxRate> getTaxRatesForItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.TaxRate> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_getTaxRatesForItem, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.TaxRate.CREATOR);
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
/**
   * Assign a list of tax rates (identified by their unique ID) to an item.
   */
@Override public void assignTaxRatesToItem(String itemId, java.util.List<String> taxRates, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeStringList(taxRates);
mRemote.transact(Stub.TRANSACTION_assignTaxRatesToItem, _data, _reply, 0);
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
/**
   * Remove a list of tax rates (identified by their unique ID) from an item.
   */
@Override public void removeTaxRatesFromItem(String itemId, java.util.List<String> taxRates, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeStringList(taxRates);
mRemote.transact(Stub.TRANSACTION_removeTaxRatesFromItem, _data, _reply, 0);
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
/**
   * Gets all defined tax rates for the merchant.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.TaxRate> getTaxRates(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.TaxRate> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTaxRates, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.TaxRate.CREATOR);
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
/**
   * Gets a single tax rate identified by its unique ID.
   */
@Override public com.clover.sdk.v3.inventory.TaxRate getTaxRate(String taxRateId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.TaxRate _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(taxRateId);
mRemote.transact(Stub.TRANSACTION_getTaxRate, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.TaxRate.CREATOR.createFromParcel(_reply);
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
/**
   * Creates a new tax rate.
   */
@Override public com.clover.sdk.v3.inventory.TaxRate createTaxRate(com.clover.sdk.v3.inventory.TaxRate taxRate, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.TaxRate _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((taxRate!=null)) {
_data.writeInt(1);
taxRate.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createTaxRate, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.TaxRate.CREATOR.createFromParcel(_reply);
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
/**
   * Updates an existing tax rate.
   */
@Override public void updateTaxRate(com.clover.sdk.v3.inventory.TaxRate taxRate, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((taxRate!=null)) {
_data.writeInt(1);
taxRate.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateTaxRate, _data, _reply, 0);
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
/**
   * Deletes a tax rate.
   */
@Override public void deleteTaxRate(String taxRateId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(taxRateId);
mRemote.transact(Stub.TRANSACTION_deleteTaxRate, _data, _reply, 0);
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
/**
   * Retrieve the list of discounts.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Discount> getDiscounts(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Discount> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDiscounts, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Discount.CREATOR);
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
/**
   * Gets a single discount identified by its unique ID.
   */
@Override public com.clover.sdk.v3.inventory.Discount getDiscount(String discountId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Discount _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(discountId);
mRemote.transact(Stub.TRANSACTION_getDiscount, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Discount.CREATOR.createFromParcel(_reply);
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
/**
   * Adds a new discount.
   */
@Override public com.clover.sdk.v3.inventory.Discount createDiscount(com.clover.sdk.v3.inventory.Discount discount, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Discount _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((discount!=null)) {
_data.writeInt(1);
discount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createDiscount, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Discount.CREATOR.createFromParcel(_reply);
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
/**
   * Updates an existing discount.
   */
@Override public void updateDiscount(com.clover.sdk.v3.inventory.Discount discount, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((discount!=null)) {
_data.writeInt(1);
discount.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateDiscount, _data, _reply, 0);
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
/**
   * Deletes a discount.
   */
@Override public void deleteDiscount(String discountId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(discountId);
mRemote.transact(Stub.TRANSACTION_deleteDiscount, _data, _reply, 0);
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
/**
   * Retrieve the list of modifier groups for a particular item.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.ModifierGroup> getModifierGroupsForItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.ModifierGroup> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_getModifierGroupsForItem, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.ModifierGroup.CREATOR);
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
/**
   * Gets all defined tags for the merchant.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Tag> getTags(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Tag> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTags, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Tag.CREATOR);
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
/**
   * Gets a single tag identified by its unique ID.
   */
@Override public com.clover.sdk.v3.inventory.Tag getTag(String tagId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Tag _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tagId);
mRemote.transact(Stub.TRANSACTION_getTag, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Tag.CREATOR.createFromParcel(_reply);
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
/**
   * Creates a new tag.
   */
@Override public com.clover.sdk.v3.inventory.Tag createTag(com.clover.sdk.v3.inventory.Tag tag, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Tag _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((tag!=null)) {
_data.writeInt(1);
tag.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createTag, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Tag.CREATOR.createFromParcel(_reply);
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
/**
   * Updates an existing tag.
   */
@Override public void updateTag(com.clover.sdk.v3.inventory.Tag tag, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((tag!=null)) {
_data.writeInt(1);
tag.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateTag, _data, _reply, 0);
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
/**
   * Deletes a tag.
   */
@Override public void deleteTag(String tagId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tagId);
mRemote.transact(Stub.TRANSACTION_deleteTag, _data, _reply, 0);
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
/**
   * Retrieve the list of tags for an item.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Tag> getTagsForItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Tag> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_getTagsForItem, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Tag.CREATOR);
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
/**
   * Assign a list of tags (identified by their unique ID) to an item.
   */
@Override public void assignTagsToItem(String itemId, java.util.List<String> tags, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeStringList(tags);
mRemote.transact(Stub.TRANSACTION_assignTagsToItem, _data, _reply, 0);
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
/**
   * Remove a list of tags (identified by their unique ID) from an item.
   */
@Override public void removeTagsFromItem(String itemId, java.util.List<String> tags, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeStringList(tags);
mRemote.transact(Stub.TRANSACTION_removeTagsFromItem, _data, _reply, 0);
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
/**
   * Retrieve the list of tags for a printer.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Tag> getTagsForPrinter(String printerMac, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Tag> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(printerMac);
mRemote.transact(Stub.TRANSACTION_getTagsForPrinter, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Tag.CREATOR);
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
/**
   * Assign a list of tags (identified by their unique ID) to a printer.
   */
@Override public void assignTagsToPrinter(String printerUid, java.util.List<String> tags, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(printerUid);
_data.writeStringList(tags);
mRemote.transact(Stub.TRANSACTION_assignTagsToPrinter, _data, _reply, 0);
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
/**
   * Remove a list of tags (identified by their unique ID) from a printer.
   */
@Override public void removeTagsFromPrinter(String printerUid, java.util.List<String> tags, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(printerUid);
_data.writeStringList(tags);
mRemote.transact(Stub.TRANSACTION_removeTagsFromPrinter, _data, _reply, 0);
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
/**
   * Assign a list of items (identified by their unique ID) to a tag.
   */
@Override public void assignItemsToTag(String tagId, java.util.List<String> items, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tagId);
_data.writeStringList(items);
mRemote.transact(Stub.TRANSACTION_assignItemsToTag, _data, _reply, 0);
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
/**
   * Remove a list of items (identified by their unique ID) from a tag.
   */
@Override public void removeItemsFromTag(String tagId, java.util.List<String> items, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(tagId);
_data.writeStringList(items);
mRemote.transact(Stub.TRANSACTION_removeItemsFromTag, _data, _reply, 0);
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
/**
   * Update modifier sort order for a modifier group.
   */
@Override public void updateModifierSortOrder(String modifierGroupId, java.util.List<String> modifierIds, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(modifierGroupId);
_data.writeStringList(modifierIds);
mRemote.transact(Stub.TRANSACTION_updateModifierSortOrder, _data, _reply, 0);
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
/**
   * Update stock count for an item. This is the old way of updating stock that takes a long, the new way is
   * updateItemStockQuantity and takes a double.
   */
@Override public void updateItemStock(String itemId, long stockCount, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeLong(stockCount);
mRemote.transact(Stub.TRANSACTION_updateItemStock, _data, _reply, 0);
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
/**
   * Remove stock count for an item.
   */
@Override public void removeItemStock(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_removeItemStock, _data, _reply, 0);
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
/**
   * Gets all defined attributes for the merchant.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Attribute> getAttributes(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Attribute> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAttributes, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Attribute.CREATOR);
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
/**
   * Gets a single attribute identified by its unique ID.
   */
@Override public com.clover.sdk.v3.inventory.Attribute getAttribute(String attributeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Attribute _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(attributeId);
mRemote.transact(Stub.TRANSACTION_getAttribute, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Attribute.CREATOR.createFromParcel(_reply);
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
/**
   * Creates a new attribute.
   */
@Override public com.clover.sdk.v3.inventory.Attribute createAttribute(com.clover.sdk.v3.inventory.Attribute attribute, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Attribute _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((attribute!=null)) {
_data.writeInt(1);
attribute.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createAttribute, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Attribute.CREATOR.createFromParcel(_reply);
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
/**
   * Updates an existing attribute.
   */
@Override public void updateAttribute(com.clover.sdk.v3.inventory.Attribute attribute, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((attribute!=null)) {
_data.writeInt(1);
attribute.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateAttribute, _data, _reply, 0);
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
/**
   * Deletes an attribute, deletes all the options in that attribute and removes all the associations between those options and items.
   */
@Override public void deleteAttribute(String attributeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(attributeId);
mRemote.transact(Stub.TRANSACTION_deleteAttribute, _data, _reply, 0);
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
/**
   * Gets all defined options for the merchant.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Option> getOptions(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Option> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getOptions, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Option.CREATOR);
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
/**
   * Gets a single option identified by its unique ID.
   */
@Override public com.clover.sdk.v3.inventory.Option getOption(String optionId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Option _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(optionId);
mRemote.transact(Stub.TRANSACTION_getOption, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Option.CREATOR.createFromParcel(_reply);
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
/**
   * Creates a new option.
   */
@Override public com.clover.sdk.v3.inventory.Option createOption(com.clover.sdk.v3.inventory.Option option, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.Option _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((option!=null)) {
_data.writeInt(1);
option.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createOption, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.Option.CREATOR.createFromParcel(_reply);
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
/**
   * Updates an existing option.
   */
@Override public void updateOption(com.clover.sdk.v3.inventory.Option option, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((option!=null)) {
_data.writeInt(1);
option.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateOption, _data, _reply, 0);
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
/**
   * Deletes an option and removes all the associations between that option and items.
   */
@Override public void deleteOption(String optionId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(optionId);
mRemote.transact(Stub.TRANSACTION_deleteOption, _data, _reply, 0);
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
/**
   * Retrieve the list of options for an item.
   */
@Override public java.util.List<com.clover.sdk.v3.inventory.Option> getOptionsForItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.clover.sdk.v3.inventory.Option> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
mRemote.transact(Stub.TRANSACTION_getOptionsForItem, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.clover.sdk.v3.inventory.Option.CREATOR);
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
/**
   * Associate the given options with an item.
   */
@Override public void assignOptionsToItem(String itemId, java.util.List<String> optionIds, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeStringList(optionIds);
mRemote.transact(Stub.TRANSACTION_assignOptionsToItem, _data, _reply, 0);
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
/**
   * Remove the association between the given options and an item.
   */
@Override public void removeOptionsFromItem(String itemId, java.util.List<String> optionIds, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeStringList(optionIds);
mRemote.transact(Stub.TRANSACTION_removeOptionsFromItem, _data, _reply, 0);
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
/**
   * Gets a single item group identified by its unique ID.
   */
@Override public com.clover.sdk.v3.inventory.ItemGroup getItemGroup(String itemGroupId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.ItemGroup _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemGroupId);
mRemote.transact(Stub.TRANSACTION_getItemGroup, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.ItemGroup.CREATOR.createFromParcel(_reply);
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
/**
   * Creates a new item group.
   */
@Override public com.clover.sdk.v3.inventory.ItemGroup createItemGroup(com.clover.sdk.v3.inventory.ItemGroup itemGroup, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.clover.sdk.v3.inventory.ItemGroup _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((itemGroup!=null)) {
_data.writeInt(1);
itemGroup.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createItemGroup, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.clover.sdk.v3.inventory.ItemGroup.CREATOR.createFromParcel(_reply);
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
/**
   * Updates an existing item group.
   */
@Override public void updateItemGroup(com.clover.sdk.v3.inventory.ItemGroup itemGroup, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((itemGroup!=null)) {
_data.writeInt(1);
itemGroup.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateItemGroup, _data, _reply, 0);
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
/**
   * Deletes an item group, but does not delete the items in a group, they become items without an item group.
   */
@Override public void deleteItemGroup(String itemGroupId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemGroupId);
mRemote.transact(Stub.TRANSACTION_deleteItemGroup, _data, _reply, 0);
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
/**
   * Update stock for an item.
   */
@Override public void updateItemStockQuantity(String itemId, double quantity, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(itemId);
_data.writeDouble(quantity);
mRemote.transact(Stub.TRANSACTION_updateItemStockQuantity, _data, _reply, 0);
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
static final int TRANSACTION_getItems = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getItemsWithCategories = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getItemIds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getItemWithCategories = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_createItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_updateItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_deleteItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_getCategories = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_createCategory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_updateCategory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_deleteCategory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_addItemToCategory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_removeItemFromCategory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_moveItemInCategoryLayout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getModifierGroups = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_createModifierGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_updateModifierGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_deleteModifierGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_assignModifierGroupToItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_removeModifierGroupFromItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_getModifiers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_createModifier = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_updateModifier = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_deleteModifier = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_getTaxRatesForItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_assignTaxRatesToItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_removeTaxRatesFromItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_getTaxRates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_getTaxRate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_createTaxRate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_updateTaxRate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_deleteTaxRate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_getDiscounts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_getDiscount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_createDiscount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_updateDiscount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_deleteDiscount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_getModifierGroupsForItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_getTags = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_getTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_createTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_updateTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_deleteTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
static final int TRANSACTION_getTagsForItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
static final int TRANSACTION_assignTagsToItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
static final int TRANSACTION_removeTagsFromItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
static final int TRANSACTION_getTagsForPrinter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
static final int TRANSACTION_assignTagsToPrinter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
static final int TRANSACTION_removeTagsFromPrinter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
static final int TRANSACTION_assignItemsToTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
static final int TRANSACTION_removeItemsFromTag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
static final int TRANSACTION_updateModifierSortOrder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
static final int TRANSACTION_updateItemStock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
static final int TRANSACTION_removeItemStock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
static final int TRANSACTION_getAttributes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
static final int TRANSACTION_getAttribute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
static final int TRANSACTION_createAttribute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
static final int TRANSACTION_updateAttribute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
static final int TRANSACTION_deleteAttribute = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
static final int TRANSACTION_getOptions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
static final int TRANSACTION_getOption = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
static final int TRANSACTION_createOption = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
static final int TRANSACTION_updateOption = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
static final int TRANSACTION_deleteOption = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
static final int TRANSACTION_getOptionsForItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
static final int TRANSACTION_assignOptionsToItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
static final int TRANSACTION_removeOptionsFromItem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
static final int TRANSACTION_getItemGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
static final int TRANSACTION_createItemGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
static final int TRANSACTION_updateItemGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
static final int TRANSACTION_deleteItemGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
static final int TRANSACTION_updateItemStockQuantity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
}
/**
   *  Retrieves all items from the local database; this will return a maximum of 500 items before
   *  returning a fault.  For iterating through the entire item database efficiently, use the
   *  content provider described by {@link com.clover.sdk.v3.inventory.InventoryContract}
   *  or get a list of item IDs via getItemIds() and retrieve individual items through the getItem() call.
   */
public java.util.List<com.clover.sdk.v3.inventory.Item> getItems(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Same as getItems() but returns the list of categories to which each item belongs.
   */
public java.util.List<com.clover.sdk.v3.inventory.Item> getItemsWithCategories(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   *  Retrieves all item IDs from the local database; use this in place of getItems() when the
   *  inventory database is large, and make subsequent calls to getItem() for the full item as necessary.
   */
public java.util.List<String> getItemIds(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   *  Retrieve an individual item using the item ID. If the item is not in the local database, an
   *  attempt will be made to fetch the item from the server.
   */
public com.clover.sdk.v3.inventory.Item getItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Same as getItem() but also includes the list of categories to which the item belongs.
   */
public com.clover.sdk.v3.inventory.Item getItemWithCategories(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   *  Inserts a new item into the database. If the client is in offline mode, the item will be inserted
   *  into the local cache and a request to create the new item on the server will be queued until
   *  the client is online again.  Returns the newly created item as it exists in the local content
   *  provider/cache.
   */
public com.clover.sdk.v3.inventory.Item createItem(com.clover.sdk.v3.inventory.Item item, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   *  Updates an existing item.
   *  TODO: Describe what parts of the item are updated through this method
   */
public void updateItem(com.clover.sdk.v3.inventory.Item item, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   *  Deletes an existing item.
   */
public void deleteItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Retrieve the list of categories.
   */
public java.util.List<com.clover.sdk.v3.inventory.Category> getCategories(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Adds a new category.
   */
public com.clover.sdk.v3.inventory.Category createCategory(com.clover.sdk.v3.inventory.Category category, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Updates an existing category.
   */
public void updateCategory(com.clover.sdk.v3.inventory.Category category, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deletes an existing category.
   */
public void deleteCategory(String categoryId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Adds an item to a category.
   */
public void addItemToCategory(String itemId, String categoryId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Removes an item from a category.
   */
public void removeItemFromCategory(String itemId, String categoryId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Moves an item's position within an existing category. If 'direction' is negative, the item is moved to the left.
   */
public void moveItemInCategoryLayout(String itemId, String categoryId, int direction, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Retrieve the list of modifier groups.
   */
public java.util.List<com.clover.sdk.v3.inventory.ModifierGroup> getModifierGroups(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Adds a new modifier group.
   */
public com.clover.sdk.v3.inventory.ModifierGroup createModifierGroup(com.clover.sdk.v3.inventory.ModifierGroup group, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Updates an existing modifier group.
   */
public void updateModifierGroup(com.clover.sdk.v3.inventory.ModifierGroup group, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deletes an existing modifier group.
   */
public void deleteModifierGroup(String groupId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Associates a modifier group with an item.
   */
public void assignModifierGroupToItem(String modifierGroupId, String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Removes a modifier group association from an item.
   */
public void removeModifierGroupFromItem(String modifierGroupId, String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Retrieve the list of modifiers belonging to a modifier group.
   */
public java.util.List<com.clover.sdk.v3.inventory.Modifier> getModifiers(String modifierGroupId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Adds a new modifier.
   */
public com.clover.sdk.v3.inventory.Modifier createModifier(String modifierGroupId, com.clover.sdk.v3.inventory.Modifier modifier, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Updates an existing modifier.
   */
public void updateModifier(com.clover.sdk.v3.inventory.Modifier modifier, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deletes an existing modifier.
   */
public void deleteModifier(String modifierId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Retrieve the list of tax rates for an item.
   */
public java.util.List<com.clover.sdk.v3.inventory.TaxRate> getTaxRatesForItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Assign a list of tax rates (identified by their unique ID) to an item.
   */
public void assignTaxRatesToItem(String itemId, java.util.List<String> taxRates, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Remove a list of tax rates (identified by their unique ID) from an item.
   */
public void removeTaxRatesFromItem(String itemId, java.util.List<String> taxRates, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets all defined tax rates for the merchant.
   */
public java.util.List<com.clover.sdk.v3.inventory.TaxRate> getTaxRates(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets a single tax rate identified by its unique ID.
   */
public com.clover.sdk.v3.inventory.TaxRate getTaxRate(String taxRateId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Creates a new tax rate.
   */
public com.clover.sdk.v3.inventory.TaxRate createTaxRate(com.clover.sdk.v3.inventory.TaxRate taxRate, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Updates an existing tax rate.
   */
public void updateTaxRate(com.clover.sdk.v3.inventory.TaxRate taxRate, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deletes a tax rate.
   */
public void deleteTaxRate(String taxRateId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Retrieve the list of discounts.
   */
public java.util.List<com.clover.sdk.v3.inventory.Discount> getDiscounts(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets a single discount identified by its unique ID.
   */
public com.clover.sdk.v3.inventory.Discount getDiscount(String discountId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Adds a new discount.
   */
public com.clover.sdk.v3.inventory.Discount createDiscount(com.clover.sdk.v3.inventory.Discount discount, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Updates an existing discount.
   */
public void updateDiscount(com.clover.sdk.v3.inventory.Discount discount, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deletes a discount.
   */
public void deleteDiscount(String discountId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Retrieve the list of modifier groups for a particular item.
   */
public java.util.List<com.clover.sdk.v3.inventory.ModifierGroup> getModifierGroupsForItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets all defined tags for the merchant.
   */
public java.util.List<com.clover.sdk.v3.inventory.Tag> getTags(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets a single tag identified by its unique ID.
   */
public com.clover.sdk.v3.inventory.Tag getTag(String tagId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Creates a new tag.
   */
public com.clover.sdk.v3.inventory.Tag createTag(com.clover.sdk.v3.inventory.Tag tag, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Updates an existing tag.
   */
public void updateTag(com.clover.sdk.v3.inventory.Tag tag, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deletes a tag.
   */
public void deleteTag(String tagId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Retrieve the list of tags for an item.
   */
public java.util.List<com.clover.sdk.v3.inventory.Tag> getTagsForItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Assign a list of tags (identified by their unique ID) to an item.
   */
public void assignTagsToItem(String itemId, java.util.List<String> tags, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Remove a list of tags (identified by their unique ID) from an item.
   */
public void removeTagsFromItem(String itemId, java.util.List<String> tags, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Retrieve the list of tags for a printer.
   */
public java.util.List<com.clover.sdk.v3.inventory.Tag> getTagsForPrinter(String printerMac, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Assign a list of tags (identified by their unique ID) to a printer.
   */
public void assignTagsToPrinter(String printerUid, java.util.List<String> tags, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Remove a list of tags (identified by their unique ID) from a printer.
   */
public void removeTagsFromPrinter(String printerUid, java.util.List<String> tags, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Assign a list of items (identified by their unique ID) to a tag.
   */
public void assignItemsToTag(String tagId, java.util.List<String> items, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Remove a list of items (identified by their unique ID) from a tag.
   */
public void removeItemsFromTag(String tagId, java.util.List<String> items, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Update modifier sort order for a modifier group.
   */
public void updateModifierSortOrder(String modifierGroupId, java.util.List<String> modifierIds, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Update stock count for an item. This is the old way of updating stock that takes a long, the new way is
   * updateItemStockQuantity and takes a double.
   */
public void updateItemStock(String itemId, long stockCount, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Remove stock count for an item.
   */
public void removeItemStock(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets all defined attributes for the merchant.
   */
public java.util.List<com.clover.sdk.v3.inventory.Attribute> getAttributes(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets a single attribute identified by its unique ID.
   */
public com.clover.sdk.v3.inventory.Attribute getAttribute(String attributeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Creates a new attribute.
   */
public com.clover.sdk.v3.inventory.Attribute createAttribute(com.clover.sdk.v3.inventory.Attribute attribute, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Updates an existing attribute.
   */
public void updateAttribute(com.clover.sdk.v3.inventory.Attribute attribute, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deletes an attribute, deletes all the options in that attribute and removes all the associations between those options and items.
   */
public void deleteAttribute(String attributeId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets all defined options for the merchant.
   */
public java.util.List<com.clover.sdk.v3.inventory.Option> getOptions(com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets a single option identified by its unique ID.
   */
public com.clover.sdk.v3.inventory.Option getOption(String optionId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Creates a new option.
   */
public com.clover.sdk.v3.inventory.Option createOption(com.clover.sdk.v3.inventory.Option option, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Updates an existing option.
   */
public void updateOption(com.clover.sdk.v3.inventory.Option option, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deletes an option and removes all the associations between that option and items.
   */
public void deleteOption(String optionId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Retrieve the list of options for an item.
   */
public java.util.List<com.clover.sdk.v3.inventory.Option> getOptionsForItem(String itemId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Associate the given options with an item.
   */
public void assignOptionsToItem(String itemId, java.util.List<String> optionIds, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Remove the association between the given options and an item.
   */
public void removeOptionsFromItem(String itemId, java.util.List<String> optionIds, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Gets a single item group identified by its unique ID.
   */
public com.clover.sdk.v3.inventory.ItemGroup getItemGroup(String itemGroupId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Creates a new item group.
   */
public com.clover.sdk.v3.inventory.ItemGroup createItemGroup(com.clover.sdk.v3.inventory.ItemGroup itemGroup, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Updates an existing item group.
   */
public void updateItemGroup(com.clover.sdk.v3.inventory.ItemGroup itemGroup, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Deletes an item group, but does not delete the items in a group, they become items without an item group.
   */
public void deleteItemGroup(String itemGroupId, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
/**
   * Update stock for an item.
   */
public void updateItemStockQuantity(String itemId, double quantity, com.clover.sdk.v1.ResultStatus resultStatus) throws android.os.RemoteException;
}
